<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<jsp:include page="/WEB-INF/module/AdminTop.jsp"/>

	<div style="height:200px"></div>
	

	<div class="panel panel-default" style="width:60%" >
		<div class="panel-heading" style="background-color:#2F2F2F;color:white" align="center">���� ���</div>
		<div class="panel-body" align="center">
			
			<form action="/addbook" method="post">
				<table class="table" style="color:black; width:50%" align="center">
					<tr>
						<td>������</td>
						<td><input type="text" readonly="readonly" value="����������" style="background-color:gray; text-align:center"/></td>
					</tr>
					<tr>
						<td>�����̸�</td>
						<td><input type="text" name="bookName"/></td>
					</tr>
					<tr>
						<td>�����̸�</td>
						<td><input type="text" name="writer"/></td>
					</tr>
					<tr>
						<td>���ǻ�</td>
						<td><input type="text" name="publisher"/></td>
					</tr>
					<tr>
						<td>�з���</td>
						<td><input type="text" name="category"/></td>
					</tr>
					<tr>
						<td>�帣</td>
						<td><input type="text" name="genre"/></td>
					</tr>
					<tr>
						<td>��ġ</td>
						<td><input type="text" name="bookLocation"/></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><button type="submit" class="btn btn-default">���</button></td>
					</tr>
				</table>
			</form>
			
		</div>
	</div>

	
	<div style="height:100px"></div>
	
<jsp:include page="/WEB-INF/module/footer.jsp"/>
</body>
</html>
