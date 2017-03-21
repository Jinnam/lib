<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	body{
	background-color: #F6F6F6;
	}
</style>

<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header navbar-middle">
	      	<h2 style="color: #F6F6F6;" align="center">개인 프로젝트 - 도서 대여/반납 시스템</h2>
	    </div>
	    
	  </div>
	</nav>

	<div class="container">
		<div class="row" style="height: 220px"></div>
		<div class="row">
			<div class="col-lg-1"></div>
		
			<div class="col-lg-4">
				<div>
					<a href="login">
						<h3>관리자 로그인</h3>
						<img src="resources/adminlogin.PNG" class="img-thumbnail" alt="Cinque Terre" width="608" height="472">
					</a>
				</div>
			</div>
		
			<div class="col-lg-1"></div>
			<div class="col-lg-4">
				<div>
					<a href="index">
						<h3>회원가입 페이지</h3>
						<img src="resources/memjoin.PNG" class="img-thumbnail" alt="Cinque Terre" width="608" height="472">
					</a>
				</div>
			</div>
			
		</div>
	</div>

</body>
</html>
