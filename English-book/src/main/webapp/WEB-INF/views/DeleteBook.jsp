<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<jsp:include page="/WEB-INF/module/AdminTop.jsp"/>

	<div style="height:200px"></div>
	<center>
	<div class="panel panel-default" style="width:60%" >
		<div class="panel-heading" style="background-color:#2F2F2F;color:white" align="center">���� ���</div>
		<div class="panel-body">
			<table class="table" style="color:black; width:50%" align="center">
				<tr>
					<td>�����ڵ�</td>
					<td><input type="text"/> <button class="btn btn-default">��ȸ</button></td>
				</tr>
				<tr>
					<td>��������</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>������</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>�����̸�</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>���ǻ�</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>�з���</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>�帣</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>��ġ</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>������</td>
					<td><textarea rows="3" cols="19"></textarea> </td>
				</tr>
				<tr>
					<td colspan="2" align="right"><button class="btn btn-default">���</button>
				</tr>
			</table>
		</div>
	</div>
	</center>
	<div style="height:100px"></div>

<jsp:include page="/WEB-INF/module/footer.jsp"/>
</body>
</html>
