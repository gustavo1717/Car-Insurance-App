$(document).ready(function() {
		$("#submitBtn").on("click", {}, function(e) {
			e.preventDefault();
			var policyId = $("#policy_number").val();
			var description = $("#claim_description").val();
			var accidentDate = $("#incident_date").val();
			var repairPrice = $("#claim_amount").val();
			//var report = $("#police_report");
			var images = $("#photos").val();

			var claims = {
				policyId,
				description,
				accidentDate,
				repairPrice,
				
			}
			
			console.log(claims)
			 $.ajax({
                type: "POST",
                url: "http://localhost:8383/createClaim",
                contentType: "application/json",
                data: JSON.stringify(claims),
                success: function(response) {
					console.log(response)
				}
				})
		})

})