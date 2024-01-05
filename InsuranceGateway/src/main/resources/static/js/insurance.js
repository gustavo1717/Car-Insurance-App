$(document).ready(function() {
    
    $('#insuranceForm2').hide();
    $('#insuranceFormAddress').hide();
    $('#listPlansContainer').hide();
    $('#insuranceFormVehicle').hide();  
    $('#insuranceFormDocument').hide();
    $('#payment').hide();
    
    console.log($("#principalName").val())
    
    $('#insuranceForm').submit(function(event) {
        event.preventDefault();

        var driverData = {
            name: $("#name").val(),
            email: $("#email").val(),
            age: $("#age").val(),
            phone: $("#phone").val(),
            drivingRecord: $("#yearsDriving").val()
        }

        console.log(driverData);

        $('#insuranceForm').hide();
        $('#insuranceFormAddress').show();

        $('#insuranceFormAddress').submit(function(event) {
            event.preventDefault();

            var driverAddressData = {
                street: $("#street").val(),
                city: $("#city").val(),
                state: $("#state").val(),
                zipCode: $("#zipCode").val(),
            }

            console.log(driverAddressData);

            $.ajax({
                type: "POST",
                url: "http://localhost:8383/addresses/saveAddress",
                contentType: "application/json",
                data: JSON.stringify(driverAddressData),
                success: function(response) {
                    console.log("Address information saved successfully:", response);

                    $('#insuranceFormAddress').hide();
                    $('#insuranceFormVehicle').show();
                    
                    $('#insuranceFormVehicle').submit(function(event) {
                        event.preventDefault();
                        
                        var vehicleData = {
                            make: $("#make").val(),
                            model: $("#model").val(),
                            year: $("#year").val(),
                            vin: $("#vin").val()
                        }
                        
                        $.ajax({
                            type: "POST",
                            url: "http://localhost:8383/vehicles/saveVehicle",
                            contentType: "application/json",
                            data: JSON.stringify(vehicleData),
                            success: function(vehicleResponse) {
                                console.log("Vehicle information saved successfully:", vehicleResponse);
                                
                    			$('#insuranceFormVehicle').hide();
                    			$('#insuranceFormDocument').show();

                                // Store the vehicle ID for later use
                                vehicleId = vehicleResponse.id;
                                
                                $('#documentUploadForm').submit(function(event) {
								    event.preventDefault();
									
									var documentData = new FormData();
    
								    $.each($('#documentFile')[0].files, function(i, file) {
								        documentData.append('file', file);
								    });

								    
								    /*var documentData = new FormData();
								    documentData.append('file', $('#documentFile')[0].files[0]);
								    documentData.append('name', $("#documentName").val()); */
								
								    
								    $.ajax({
								        type: "POST",
								        url: "http://localhost:8383/documents/upload",
								        data: documentData,
								        contentType: false,
								        processData: false,
								        success: function(documentResponse) {
								            alert("Document uploaded!");
								            console.log("Document uploaded successfully:", documentResponse);
											console.log(documentResponse);

											$('#insuranceFormDocument').hide();
        									$('#listPlansContainer').show();
        																	            
								            console.log(vehicleResponse);
								            
								            console.log(documentResponse);
								            
								                    $.ajax({
											            type: "GET",
											            contentType: "application/json",
											            url: "http://localhost:8383/autoPlan",
											            success: function(result) {
											                console.log("AJAX request success!");
											                $("#plansTbl tr").not(".header").remove();
											                $.each(result, function(key1, value1) {
											                    $("#plansTbl").append("<tr><td >" + value1.name + "</td><td>" + value1.description + "</td><td>" + value1.type + "</td><td>" + "$"+value1.basePrice + "</td><td><img  src='" + value1.imageURL + "' style='width:150px;height:auto;' class='imgLink'></td><td><button class='select-button' >Select</button></td></tr>");
											                });
											                
											                $(".select-button").on("click", {}, function(e){arguments
											                	
											                	var selectedRow = $(this).closest("tr");
															    var planName = selectedRow.find("td:eq(0)").text(); // Get the plan name from the selected row
															
															    // Find the selected plan in the result array
															    var selectedPlan = result.find(function(plan) {
															        return plan.name === planName;
															    });
															    
															    console.log("PLANNN")
															    console.log(selectedPlan)
															    
																 var insuredData = {
														                name: driverData.name,
														                email: driverData.email,
														                age: driverData.age,
														                status : "Requested",
														                phone: driverData.phone,
														                drivingRecord: driverData.drivingRecord,
														                address: response,
														                vehicle: vehicleResponse,
														                document: documentResponse,
														                //plans : [selectedPlan]
														            };
								            
																	$.ajax({
														                type: "POST",
														                url: "http://localhost:8383/insureds/saveInsured",
														                contentType: "application/json",
														                data: JSON.stringify(insuredData),
														                success: function(insuredResponse) {
														                    console.log("Insured information saved successfully:", insuredResponse);
														                    
																			console.log($(this).parent().parent().children("td").eq(0).text())
																			console.log(result.filter(plan => plan.name == $(this).parent().parent().children("td").eq(0).text()))
																			
																			var currentDate = new Date(); 
																			var oneYearLater = new Date(currentDate); 
																			oneYearLater.setFullYear(oneYearLater.getFullYear() + 1);
																			
																			var policy = {
																				insured : insuredResponse,
																				vehicle : vehicleResponse,
																				plans : [selectedPlan],
																				startDate :currentDate ,
																				endDate: oneYearLater,
																				status: "Requested",
																				user : $("#principalName").val()
																			}
																	
																			$('#listPlansContainer').hide()
																	
																			var clientSecret = "";
																			console.log()
																			
																			$.ajax({
																                type: "POST",
																                url: "http://localhost:8282/checkout?amount=" + selectedPlan.basePrice*100,
																                contentType: "application/json",
																                data: JSON.stringify(selectedPlan.basePrice),
																                success: function(res) {
																					clientSecret = res;
																					$("#clientSecret").val(clientSecret);
																					$('#amount').val(selectedPlan.basePrice);
																					$('#payment').show();
																					
																					
																				}})
																
																 console.log(policy)
																		
																 $.ajax({
													                type: "POST",
													                url: "http://localhost:8383/policies/savePolicy",
													                contentType: "application/json",
													                data: JSON.stringify(policy),
													                success: function(policyResponse) {
																		console.log(policyResponse)
																		var username = $("#principalName").val();
																		
																		 $.ajax({
															                type: "POST",
															                url: "http://localhost:8282/user/policyId?policyId=" + policyResponse.id + "&username=" + username ,
															                contentType: "application/json",
															                data: JSON.stringify(policy),
															                success: function(policyResponse) {
																				
																			
																	
																			console.log(policyResponse)
																		}})
														
								
																	}})
														
															
											                
											            },
											            error: function(e) {
											            }
											        });
								                    })
								                    
								                    
								                },
								                error: function(insuredError) {
								                    console.error("Error saving insured information:", insuredError);
								                }
								            });
								        },
								        error: function(error) {
								            console.error("Error uploading document:", error);
								        }
								    });
							});

                              
                            },
                            error: function(vehicleError) {
                                console.error("Error saving vehicle information:", vehicleError);
                            }
                        });
                    });
                },
                error: function(addressError) {
                    console.error("Error saving address information:", addressError);
                }
            });
        });
    });
    															
    
            
    $("#plansButton").click(function(e) {
        window.location.href = "http://localhost:8282/plans"
    });
    
    $("#plansB").click(function(e) {
        window.location.href = "http://localhost:8282/plans"
    });
    
    
    $("#homeButton").click(function(e) {
        window.location.href = "http://localhost:8282/home";
    });
    
    $("#claimButton").click(function(e) {
        window.location.href = "http://localhost:8282/claim";
    });
    
    $("#claimB").click(function(e) {
        window.location.href = "http://localhost:8282/claim";
    });
});
