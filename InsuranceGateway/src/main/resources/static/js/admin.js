$(document).ready(function() {
    
        //e.preventDefault();

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "http://localhost:8383/policies",
            success: function(result) {
                console.log("AJAX request success!");
                $("#plansTbl tr").not(".header").remove();
                $.each(result, function(key1, value1) {
               		
               		if (value1.status === 'Requested') {
                    var vehicle = value1.vehicle.make + " " + value1.vehicle.model;

					var buttonCellHtml = "<td>";
			        buttonCellHtml += "<div class='d-flex justify-content-between'>";
			        buttonCellHtml += "<button onclick='acceptPolicy(" + value1.id + ")' class='btn btn-success'>Accept</button>";
			        buttonCellHtml += "<button onclick='rejectPolicy(" + value1.id + ")' class='btn btn-danger ml-2'>Reject</button>";
			        buttonCellHtml += "</div>";
			        buttonCellHtml += "</td>";
			        
			        //console.log(value1.insured)
                    // Construct the image URL using data URI format
                    var base64Image = 'data:image/jpeg;base64,' + value1.insured.document.driverLicense;

                   $("#plansTbl").append("<tr><td>" + value1.insured.name + "</td><td>" + vehicle + "</td><td>" + value1.plans[0].type + "</td><td>" + "$" + value1.plans[0].basePrice + "</td><td>" + value1.status + "</td><td>" + value1.startDate + "</td><td>" + value1.endDate + "</td><td><img src='" + base64Image + "' class='imgLink' style='width:150px;height:auto;' onclick='openModal(this)'></td>" + buttonCellHtml + "</tr>");
                    }
                });
            },
            error: function(e) {
            }
        });
    
    
        $.ajax({
		    type: "GET",
		    contentType: "application/json",
		    url: "http://localhost:8383/claims",
		    success: function (result) {
		        console.log("AJAX request success!");
		        $("#plansTbl2 tr").not(".header").remove();
		        $.each(result, function (key1, value1) {
		            if (value1.status === 'Pending') {
                		$.ajax({
		                    type: "GET",
		                    url: "http://localhost:8383/policies/" + value1.policyId,
		                    contentType: "application/json",
		                    success: function (response) {

	                        var buttonCellHtml = "<td>";
	                        buttonCellHtml += "<div class='d-flex justify-content-between'>";
	                        buttonCellHtml += "<button onclick='acceptClaim(" + value1.id + ")' class='btn btn-success'>Accept</button>";
	                        buttonCellHtml += "<button onclick='rejectClaim(" + value1.id + ")' class='btn btn-danger ml-2'>Reject</button>";
	                        buttonCellHtml += "<button onclick='updateRepairPrice(" + value1.id + ")' class='btn btn-info ml-2'>Review</button>";
	                        buttonCellHtml += "</div>";
	                        buttonCellHtml += "</td>";
	
	                        var imageHtml = "";
	                        $.each(value1.images, function (key2, value2) {
	                            var base64Image = 'data:image/jpeg;base64,' + value2.data;
	                            imageHtml += "<img src='" + base64Image + "' class='imgLink' style='width:150px;height:auto;' onclick='openModal(this)'>";
	                        });
	
	                        $("#plansTbl2").append("<tr><td>" + value1.id + "</td><td>" + value1.accidentDate + "</td><td>" + value1.description + "</td><td>" + response.plans[0].type + "</td><td id='repairPrice_" + value1.id + "'>" + value1.repairPrice + "</td><td>" + value1.status + "</td><td style='{display:inline}'>" + imageHtml + "</td>" + buttonCellHtml + "</tr>");
	                    },
	                    error: function (e) {
	                        console.error("Policy request error:", e);
	                    }
	                });
	            }
	        });
	    },
	    error: function (e) {
	        console.error("Claims request error:", e);
	    }
	});

})

function updateRepairPrice(claimId) {
    console.log("Claim ID: " + claimId); // Debugging statement

    var newRepairPrice = parseFloat(prompt("Enter the new repair price:"));

    if (!isNaN(newRepairPrice)) {
        console.log("New Repair Price: " + newRepairPrice); // Debugging statement
        $.ajax({
            type: "PUT",
            contentType: "application/json",
            url: "http://localhost:8383/reviewClaim/" + claimId,
            data: JSON.stringify({
                repairPrice: newRepairPrice,
                status: "Accepted" // Set the status to "Accepted"
            }),
            success: function (result) {
                console.log("Update Repair Price and Status successful"); // Debugging statement
                // Update the repair price and status on the page
                $("#repairPrice_" + claimId).text(newRepairPrice);
                $("#status_" + claimId).text("Accepted");
            },
            error: function (e) {
                console.error("Update Repair Price and Status request error:", e);
            }
        });
    }
}



function openModal(img) {
  var modal = document.getElementById("myModal");
  var modalImg = document.getElementById("imgModal");
  var closeModal = document.getElementById("closeModal");

  modal.style.display = "block";
  modalImg.src = img.src;

  closeModal.addEventListener("click", function() {
    modal.style.display = "none";
  });
}


var closeModal = document.getElementById("closeModal");
closeModal.onclick = function() {
  var modal = document.getElementById("myModal");
  modal.style.display = "none";
};



function acceptPolicy(policyId) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "http://localhost:8383/policies/" + policyId,
        data: JSON.stringify({ status: "Accepted" }),
        success: function(result) {
            alert("Policy Accepted")
        },
        error: function(e) {
            // Handle error
        }
    });
}

function rejectPolicy(policyId) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "http://localhost:8383/policies/" + policyId,
        data: JSON.stringify({ status: "Rejected" }),
        success: function(result) {
            alert("Policy Rejected")
        },
        error: function(e) {
            // Handle error
        }
    });
}

function acceptClaim(claimId) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "http://localhost:8383/claims/" + claimId,
        data: JSON.stringify({ status: "Accepted" }),
        success: function(result) {
            alert("Claim Accepted")
        },
        error: function(e) {
            // Handle error
        }
    });
}

function rejectClaim(claimId) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "http://localhost:8383/claims/" + claimId,
        data: JSON.stringify({ status: "Rejected" }),
        success: function(result) {
            alert("Claim Rejected")
        },
        error: function(e) {
            // Handle error
        }
    });
}