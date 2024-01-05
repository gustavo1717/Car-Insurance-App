<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src='js/welcome.js'></script>

<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
	<body>

		<div class='mt-5 d-flex justify-content-center'>
			<form method='get'>
		
				<div class='form-group'>
					<label>
						Please Enter User Email:
					</label>
					<input class='form-control' type = 'text' id='useremail'/>
				</div>

				<div class='form-group'>
					<label>
						Please Enter Username:
					</label>
					<input class='form-control' type = 'text' id='username'/>
				</div>
				
				<div class='form-group'>
					<label>
						Please Enter Password:
					</label>
					<input class='form-control' type = 'password' id='password'/>
				</div>
				
				<input class='btn btn-primary mt-5' type = 'submit' value='Submit' id="subtmitButton"/>
				<sec:csrfInput/>
			</form>

	
	</body>
</html>