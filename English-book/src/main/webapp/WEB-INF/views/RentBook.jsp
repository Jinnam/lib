<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<jsp:include page="/WEB-INF/module/AdminTop.jsp"/>

<!-- First Container -->

	<div style="height:100px"></div>
<center>
	<div class="panel panel-default" style="width:40%" align="left">
		<div class="panel-heading" style="background-color:#2F2F2F;color:white" align="center">ȸ������</div>
		<div class="panel-body">
			<table class="table" style="color:black; width:60%" align="center">
				<tr>
					<td>ȸ�����̵�</td>
					<td><input type="text" name="MEMBERID" id="memberId"/>
						<button id="memberBtn" class="btn btn-default">��ȸ</button>
					</td>
				</tr>
				<tr>
					<td>�̸�</td>
					<td><input type="text" id="MEMBERNAME"/></td>
				</tr>
				<tr>
					<td>��ȭ��ȣ</td>
					<td><input type="text" id="MEMBERPHONE"/></td>
				</tr>
			</table>
		</div>
	</div>


	<div class="panel panel-default" style="width:40%" align="right">
		<div class="panel-heading" style="background-color:#2F2F2F;color:white" align="center">��������</div>
		<div class="panel-body">
			<table class="table" style="color:black; width:60%" align="center">
				<tr>
					<td>�����ڵ�</td>
					<td><input type="text"/> <button class="btn btn-default">��ȸ</button> </td>
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
					<td>�뿩������</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>�ݳ�������	</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>�����ݾ�</td>
					<td><input type="text"/>��</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><button class="btn btn-default">����/�뿩</button></td>
				</tr>
			</table>
		</div>
	</div>
</center>
	<div style="height:100px"></div>
<script>
$(document).ready(function(){
    $("#memberBtn").click(function(){
    	console.log('��ưŬ��');
       $.ajax({
    	   url : "/rentmember",
    	   type : "POST",
    	   data : {"MEMBERID" : $('#memberId').val()},
    	   dataType : "json",
    	   success : function(data){
    		   var Member = data.Member;
    		   $('#MEMBERNAME').val()= Member.MEMBERNAME;
    	   }
       });
    });
});
</script>

<jsp:include page="/WEB-INF/module/footer.jsp"/>

</body>
</html>
