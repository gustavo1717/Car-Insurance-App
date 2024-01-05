
<!DOCTYPE html>
<html>
	<style>
        .form-group {
            margin-bottom: 10px;
        }

        .form-group b {
            display: inline-block;
            width: 100px;
            text-align: right;
            margin-right: 10px;
        }

        .form-group input {
            width: 200px; 
        }

		.quote-container {
			margin-bottom: 20px;
			border: 2px solid #3498db; /* Change border color to blue (#3498db) */
			border-radius: 10px; /* Rounded corners for the container */
			padding: 20px; /* Padding inside the container */
			display: flex; /* Arrange elements in a row */
			justify-content: space-between; /* Space elements evenly */
			align-items: center; /* Center items vertically */
		}

		.quote-box {
			flex: 1; /* Take up available space within the container */
		}

		.car-image {
			width: 400px; /* Adjust the width of the car image */
			border-radius: 10px; /* Rounded corners for the image */
		}

		footer {
            background-color: #f8f9fa; /* Background color for the footer */
            padding: 10px; /* Padding for the footer */
            text-align: center;
            font-size: 12px;
            color: #555;
            
        }

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

		th {
        white-space: nowrap;
    }

    </style>
	
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='./js/insurance.js'></script>
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security"></html>
	<!DOCTYPE html>
<html>
<head>
	<meta name="_csrf" content="authenticated">
	<jsp:include page="header.jsp" />
	<script>

		var userIsAuthenticated = ${userIsAuthenticated};
		console.log("userIsAuthenticated:", userIsAuthenticated);
		$(document).ready(function() {
			if("${role.equals('admin')}" ){
				window.location.href = "http://localhost:8282/admin"
			}

			if (!userIsAuthenticated){
				$('#ins').hide();
				$('#ins3').hide();
				$('#logout').hide();
				$('#profile').hide();
				$('#claimB').hide();


			}
			if (userIsAuthenticated){
				$('#Login').hide();
			}

		})

		

	</script>
</head>
<body>
	<input type="hidden" id="principalName" value="${principalName}">

	<div class="quote-container" id="ins">
		<div class="quote-box" >
			<h2>Get a Car Insurance Quote</h2>
			<p>Get the best car insurance deals tailored for you.</p>
			<a href="insuranceForm" class="btn btn-primary">Get Quote</a>
		</div>
	
		<img src="https://di-uploads-pod10.dealerinspire.com/landroverparamus/uploads/2018/05/2018-Land-Rover-Range-Rover-Sport.png" alt="Car Image" class="car-image">
	</div>
	

	<div class="quote-container" id="ins2" >
		<div class="quote-box">
			<h2>See plans</h2>
			<p>Here you can see what we can offer.</p>
			<a  class="btn btn-primary" id="plansButton">Get Plans</a>
		</div>
	
		<img src="https://cars.usnews.com/static/images/Auto/izmo/i159615630/2023_nissan_sentra_angularfront.jpg" alt="Car Image" class="car-image">
	</div>

	<div class="quote-container" id="ins3" >
		<div class="quote-box">
			<h2>Claims</h2>
			<p>Fast and fair settlements.</p>
			<a  class="btn btn-primary" id="claimButton">Go to Claims</a>
		</div>
	
		<img src="https://www.hdwallpapers.in/thumbs/2023/adro_ford_mustang_coupe_car_white_background_4k_hd_cars-t2.jpg" alt="Car Image" class="car-image">
	</div>

	


	<jsp:include page="footer.jsp" />

	
</body>
</html>

</body>
</html>
