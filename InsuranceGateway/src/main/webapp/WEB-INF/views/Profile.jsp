<!DOCTYPE html>
<html>
	
	
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='./js/profile.js'></script>
<input type="hidden" id="principalName" value="${principalName}">

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
    .img-container img {
            max-width: 150px; /* Set the maximum width for the images */
            max-height: auto; /* Let the height adjust automatically to maintain aspect ratio */
        }
    </style>

	<!DOCTYPE html>
<html>
<head>
    <jsp:include page="header.jsp" />

    <script>
      $('#Login').hide();
    </script>
</head>
<body>

  <div class="row justify-content-center">
    <div id="listPolicyContainer" class="col-7 border rounded" style="margin-left: 50px; margin-bottom: 20px; margin-top: 20px;">
        <div class="text-center">
            <div style="font-size: 20px; font-family: 'Trebuchet MS', Helvetica, sans-serif;">Your Policies:</div>  
        
            <div id="listPolicy" class="row justify-content-center">
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
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>


<div class="row justify-content-center">
  <div id="listPolicyContainer" class="col-7 border rounded text-center" style="margin-left: 50px; margin-bottom: 20px; margin-top: 20px;">
    <div style="text-align: center; font-size: 20px; font-family: 'Trebuchet MS', Helvetica, sans-serif;">List of Claims:</div>  

    <div id="listPolicy" class="row justify-content-center">
      <table id="plansTbl2" border="1">
        <tr class="header">
          <th>Claim ID</th>
          <th>Accident Date</th>
          <th>Description</th>
          <th>Policy Type</th>
          <th>Amount</th>
          <th>Status</th>
          <th>Image</th>
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