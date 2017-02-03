<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Theme Made By www.w3schools.com - No Copyright -->
	<title>Bootstrap Theme Simply Me</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<link href="/resources/admincss.css" rel="stylesheet" type="text/css" >
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>                        
			</button>
		<a class="navbar-brand" href="#">JB-LIBRARY</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li role="presentation" class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
					���������� <span class="caret"></span>
					 </a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/addlib">���������</a></li>
					    </ul>
				</li>
				<li role="presentation" class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
					�������� <span class="caret"></span>
					 </a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/addbook">�������</a></li>
							<li><a href="/deletebook">�������</a></li>
					    </ul>
				</li>
				<li role="presentation" class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
					�뿩/�ݳ�<span class="caret"></span>
					 </a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/rentbook">�����뿩</a></li>
							<li><a href="/returnbook">�����ݳ�</a></li>
					    </ul>
				</li>
				
				<li role="presentation" class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
					ȸ������ <span class="caret"></span>
					 </a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/approval">ȸ�񳳺�</a></li>
					    </ul>
				</li>
				<li><a href="/logout">${adminId} �α׾ƿ�</a></li>
			</ul>
		</div>
	</div>
</nav>

</body>
</html>