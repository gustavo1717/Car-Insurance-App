<!DOCTYPE html>

<html>
	<style>
  </style>
	
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='./js/plans.js'></script>
	<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp" />
</head>
<body>
	<input type="hidden" id="principalName" value="${principalName}">
	
	<script>
        $(document).ready(function() {
           
            if (!$('#principalName').val()) {
                
                $('#claimB').hide();
				$('#profile').hide();
				$('#logout').hide();
			}else $('#Login').hide();
        });
    </script>

	<div class="row justify-content-center">
		<div id="listPlansContainer" class="col-7 border rounded text-center" style="margin-left: 50px; margin-bottom: 20px; margin-top: 20px;">
			<div style="text-align: center; font-size: 20px; font-family: 'Trebuchet MS', Helvetica, sans-serif;">List of Plans:</div>  
	
			<div id="listPlans">
				<table id="plansTbl" border="1">
					<tr class="header">
						<th>Plan Name</th>
						<th>Description</th>
						<th>Type</th>
						<th>Base Price</th>
						<th>Image</th>
					</tr>
				</table>
			</div>
	
		
		</div>
	</div>

  
	<footer>
    © 2023 InsuranceCar. All rights reserved.

    InsuranceCar and the InsuranceCar trademarks used herein are trademarks or registered trademarks of InsuranceCar and its affiliates. The use of any other trade name, copyright, or trademark is for identification and reference purposes only and does not imply any association with the copyright or trademark holder of their product or brand. Other product and company names mentioned here in are the property of their respective owners. Licenses and Disclosures.
  </footer>

	
</body>
</html>

</body>

</html>
