$(document).ready(function() {
    	
    console.log($("#principalName").val())
       $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "http://localhost:8383/autoPlan",
            success: function(result) {
                console.log("AJAX request success!");
                $("#plansTbl tr").not(".header").remove();
                $.each(result, function(key1, value1) {
                    $("#plansTbl").append("<tr><td >" + value1.name + "</td><td>" + value1.description + "</td><td>" + value1.type + "</td><td>" + "$"+value1.basePrice + "</td><td><img  src='" + value1.imageURL + "' style='width:150px;height:auto;' class='imgLink'></td></tr>");
                });
            },
            error: function(e) {
            }
        });
        
        $("#claimB").click(function(e) {
       		window.location.href = "http://localhost:8282/claim";
		}); 

})


