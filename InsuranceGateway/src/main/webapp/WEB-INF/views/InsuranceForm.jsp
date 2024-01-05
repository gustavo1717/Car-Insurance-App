
<!DOCTYPE html>
<html>
	<style>
        .insurance-form {
            padding: 20px;
            border: 2px solid #3498db;
            border-radius: 10px;
            background-color: #f8f9fa;
            margin-bottom: 20px;
        }

        .insurance-form input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
        }

        .insurance-form button {
            padding: 10px 20px;
        }
    </style>
	
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='./js/insurance.js'></script>
<script src="https://js.stripe.com/v3/"></script>
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security"></html>

	<!DOCTYPE html>
<html>
<head>
  <meta name="_csrf" content="authenticated">
	<jsp:include page="header.jsp" />
	
  <script>
    $('#Login').hide();
		
		
	</script>

</head>
<body>
  <input type="hidden" id="principalName" value="${principalName}">
  
	<div id="insuranceForm" class="insurance-form">
        <h2>Car Insurance Application</h2>
        <form>
            <div class="form-group">
                <b>Complete Name:</b>
                <input type="text" name="name" id="name" required>
            </div>
            <div class="form-group">
                <b>Email:</b>
                <input type="email" name="email" id="email"required>
            </div>
            <div class="form-group">
              <b>Age:</b>
              <input type="number" name="age" id="age" required>
          </div>
            <div class="form-group">
                <b>Phone:</b>
                <input type="tel" name="phone" id="phone" required>
            </div>
            <div class="form-group">
                <b>Years Driving:</b>
                <input type="number" name="yearsDriving" id="yearsDriving" required>
            </div>
            <button type="submit" class="btn btn-primary"> Next</button>
        </form>
    </div>

    <div id="insuranceFormAddress" class="insurance-form">
      <h2>Address</h2>
      <form>
          <div class="form-group">
              <b>Street:</b>
              <input type="text" name="street" id="street"required>
          </div>
          <div class="form-group">
            <b>City:</b>
            <input type="text" name="city" id="city"required>
          </div>
          <div class="form-group">
            <b>State:</b>
            <select class="form-control" id="state" required>
                <option value="Arizona">Arizona</option>
                <option value="California">California</option>
                <option value="Florida">Florida</option>
                <option value="Georgia">Georgia</option>
                <option value="New Jersey">New Jersey</option>
                <option value="New York">New York</option>
            </select>
        </div>
          <div class="form-group">
            <b>Zip Code:</b>
            <input type="number" name="zipCode" id="zipCode"required>
          </div>
          <button type="submit" class="btn btn-primary"> Next</button>
        </form>
    </div>
    
    <div id="insuranceFormVehicle" class="insurance-form">
      <h2>Car Insurance Application Vehicle</h2>
      <form>
          <div class="form-group">
              <b>VIN:</b>
              <input type="text" name="vin" id="vin" required>
          </div>
          <div class="form-group">
            <b>Make:</b>
            <select class="form-control" id="make" required>
                <option value="Toyota">Toyota</option>
                <option value="Chevrolet">Chevrolet</option>
                <option value="Ford Motor">Ford Motor</option>
                <option value="BMW">BMW</option>
                <option value="Mercedes">Mercedes</option>
                <option value="Honda">Honda</option>
            </select>
        </div>
          <div class="form-group">
              <b>Model:</b>
              <input type="text" name="model" id="model" required>
          </div>
          <div class="form-group">
              <b>Year:</b>
              <input type="text" name="year" id="year" required>
          </div>
          <button type="submit" class="btn btn-primary">Submit Application</button>
      </form>
    </div>

    <div id="insuranceFormDocument" class="insurance-form">
      <form id="documentUploadForm" enctype="multipart/form-data">
        <h2>Driver License Photo:</h2>

        <input type="file" name="file" id="documentFile" multiple>
        <button type="submit">Upload Documents</button>
    </form>
</div>
  

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

    <div class="row justify-content-center">
      <div id="payment" class="col-7 border rounded text-center" style="margin-left: 50px; margin-bottom: 20px; margin-top: 20px;">
          <div style="text-align: center; font-size: 20px; font-family: 'Trebuchet MS', Helvetica, sans-serif;">Payment Form:</div>
          
          <form method="post" id="payment-form" style="margin-top: 20px;">
              <input type="hidden" id="clientSecret" value="">
  
              <div class="form-group">
                <label for="amount">Amount to Pay (USD):</label>
                <input type="text" class="form-control" id="amount" name="amount" readonly>
              </div>

              <div id="card-element">
                  <!-- A Stripe Element will be inserted here. -->
              </div>
  
              <script>
                  var stripe = Stripe('pk_test_51O7orfAexmwKsuT7igSbRUAzXJpkMBAcJg2K6uYtQGthRQGc6yTXh5e83q1UHRIAWdrZfDbM28FDL5bUmO0nMe9P00TJgYXekt');
                  var elements = stripe.elements();
  
                  // Create an instance of the card Element.
                  var card = elements.create('card');
  
                  // Add an instance of the card Element into the card-element div.
                  card.mount('#card-element');
              </script>
              
  
              <div class="form-group">
                  <label for="name">Name</label>
                  <input type="text" class="form-control" id="name" name="name" placeholder="John Doe" required>
              </div>
              <button type="submit" id="submitPayment" class="btn btn-primary">Submit Payment</button>
          </form>
      </div>
  </div>
  

    <script>
      $(document).ready(function(){
         
          

          $("#submitPayment").on("click", {}, function(e){
              e.preventDefault();

              let clientSecret = $("#clientSecret").val();
              console.log(clientSecret)

              stripe.confirmCardPayment(clientSecret, {
                  payment_method: {
                      card: card
                  }

              }).then(function(result) {
                  if(result.error) {
                      console.log(result)
                  } else {
                    window.location.href="http://localhost:8282/home"
                  }
              })
          })

      })
  </script>
      

      <jsp:include page="footer.jsp" />

</body>
</html>

</body>
</html>
