<!DOCTYPE html>
<html>
	
	
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='./js/admin.js'></script>
<script src="https://js.stripe.com/v3/"></script>
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security"></html>
<style>
    
    .modal {
      display: none;
      position: fixed;
      z-index: 1;
      padding-top: 100px;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      overflow: auto;
      background-color: rgba(0, 0, 0, 0.9);
    }
    
    .modal-content {
      margin: auto;
      display: block;
      max-width: 90%;
      max-height: 90%;
    }
    
    .close {
      position: absolute;
      top: 15px;
      right: 25px;
      font-size: 35px;
      cursor: pointer;
      color: #fff;
    }
    </style>

	<!DOCTYPE html>
<html>
<head>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" >Welcome!</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active" id="homeButton">
          <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="logout" href="/logout">Log Out</a>
        </li>
      </ul>
    </div>
  </nav>

</head>
<body>

    <div class="row justify-content-center">
        <div id="listPolicyContainer" class="col-7 border rounded text-center" style="margin-left: 50px; margin-bottom: 20px; margin-top: 20px;">
          <div style="text-align: center; font-size: 20px; font-family: 'Trebuchet MS', Helvetica, sans-serif;">List of Policies:</div>  
      
          <div id="listPolicy">
            <table id="plansTbl" border="1">
              <tr class="header">
                <th>Name</th>
                <th>Vehicle</th>
                <th>Policy Type</th>
                <th>Price</th>
                <th>Status</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Image</th>
                <th>Action</th>

              </tr>
            </table>
          </div>
        </div>
      </div>

      <div class="row justify-content-center">
        <div id="listPolicyContainer" class="col-7 border rounded text-center" style="margin-left: 50px; margin-bottom: 20px; margin-top: 20px;">
          <div style="text-align: center; font-size: 20px; font-family: 'Trebuchet MS', Helvetica, sans-serif;">List of Claims:</div>  
      
          <div id="listPolicy">
            <table id="plansTbl2" border="1">
              <tr class="header">
                <th>Claim ID</th>
                <th>Accident Date</th>
                <th>Description</th>
                <th>Policy Type</th>
                <th>Amount</th>
                <th>Status</th>
                <th>Image</th>
                <th>Action</th>
              </tr>
            </table>
          </div>
        </div>
      </div>

      <div id="myModal" class="modal">
        <span class="close" id="closeModal">&times;</span>
        <img class="modal-content" id="imgModal">
      </div>

  <jsp:include page="footer.jsp" />

</body>
</html>

</body>
</html>