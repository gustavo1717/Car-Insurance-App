$(document).ready(function() {
    
        //e.preventDefault();
		var username = $("#principalName").val();
		
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "http://localhost:8383/policies/byUser/" + username,
            success: function(result) {
                console.log("AJAX request success!");
                $("#plansTbl tr").not(".header").remove();
                $.each(result, function(key1, value1) {
               		console.log(result)
               		
                    var vehicle = value1.vehicle.make + " " + value1.vehicle.model;

                    // Construct the image URL using data URI format
                    var base64Image = 'data:image/jpeg;base64,' + value1.insured.document.driverLicense;

                    // Append the image to the table with a click event
                    $("#plansTbl").append("<tr><td>" + value1.insured.name + "</td><td>" + vehicle + "</td><td>" + value1.plans[0].type + "</td><td>" + "$" + value1.plans[0].basePrice + "</td><td>" + value1.status + "</td><td>" + value1.startDate + "</td><td>" + value1.endDate + "</td><td><img src='" + base64Image + "' class='imgLink' style='width:150px;height:auto;' onclick='openModal(this)'></td> </tr>");
                    
                });
            },
            error: function(e) {
            }
        });
    
   $.ajax({
    type: "GET",
    contentType: "application/json",
    url: "http://localhost:8383/claims/byUser/" + username,
    success: function (result) {
        console.log("AJAX request success!");
        $("#plansTbl2 tr").not(".header").remove();
        $.each(result, function (key1, value1) {
                
            $.ajax({
                type: "GET",
                url: "http://localhost:8383/policies/" + value1.policyId,
                contentType: "application/json",
                success: function (response) {

                    // Construct the image HTML content
                    var imageHtml = "<div class='img-container'>";
                    $.each(value1.images, function (key2, value2) {
                        var base64Image = 'data:image/jpeg;base64,' + value2.data;
                        imageHtml += "<img src='" + base64Image + "' class='imgLink' onclick='openModal(this)'>";
                    });
                    imageHtml += "</div>";

                    // Append the row with images (without buttons)
                    $("#plansTbl2").append("<tr><td>" + value1.id + "</td><td>" + value1.accidentDate + "</td><td>" + value1.description + "</td><td>" + response.plans[0].type + "</td><td>" + value1.repairPrice + "</td><td>" + value1.status + "</td><td>" + imageHtml + "</td></tr>");
                },
                error: function (e) {
                    console.error("Policy request error:", e);
                }
            });
            
        });
    },
    error: function (e) {
        console.error("Claims request error:", e);
    }
});



    
    
	$("#claimB").click(function(e) {
        window.location.href = "http://localhost:8282/claim";
	}); 
	
	$("#plansB").click(function(e) {
        window.location.href = "http://localhost:8282/plans";
	});
	
});





function openModal(img) {
  var modal = document.getElementById("myModal");
  var modalImg = document.getElementById("imgModal");
  var closeModal = document.getElementById("closeModal");

  modal.style.display = "block";
  modalImg.src = img.src;

  // Add an event listener to the "X" button to close the modal
  closeModal.addEventListener("click", function() {
    modal.style.display = "none";
  });
}


var closeModal = document.getElementById("closeModal");
closeModal.onclick = function() {
  var modal = document.getElementById("myModal");
  modal.style.display = "none";
};



