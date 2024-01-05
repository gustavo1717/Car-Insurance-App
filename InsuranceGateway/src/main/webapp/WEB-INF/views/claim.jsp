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
<script src='./js/claim.js'></script>
	<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp" />
    

</head>
<script>
    $('#Login').hide();
		
		
	</script>
<body>
    <input type="hidden" id="principalName" value="${principalName}">

    <div class="container">
        <h1 class="mt-4">Auto Insurance Claim Form</h1>
        <form id="claimForm" class="mt-4">
            
            <div class="form-group">
                <label for="claim_description">Description of the Incident:</label>
                <textarea id="claim_description" class="form-control" rows="4" required></textarea>
            </div>

            <div class="form-group">
                <label for="incident_date">Date of the Incident:</label>
                <input type="date" id="incident_date" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="claim_amount">Estimated Claim Amount (USD):</label>
                <input type="number" id="claim_amount" step="0.01" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="photos">Upload Photos:</label>
                <input type="file" id="images" class="form-control-file" accept="image/*" multiple>
            </div>
            <div class="form-group">
                <label for="policy_number">Policy Number:</label>
                <input type="text" id="policy_number" class="form-control" value="${policyId}" readonly="true" required>
            </div>

            <button type="submit" id="submitBtn" class="btn btn-primary">Submit Claim</button>
        </form>
    </div>

    <jsp:include page="footer.jsp" />
	
</body>
</html>

</body>

</html>
