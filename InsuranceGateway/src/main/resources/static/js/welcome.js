$(document).ready(function() {
	$("#subtmitButton").on("click", {}, function(e) {
		e.preventDefault();
		window.location.href="signup?userEmail=" + $("#useremail").val() + "&userName=" + $("#username").val()+ "&password=" + $("#password").val() 
	})
})
