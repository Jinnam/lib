<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head>
<body>
<jsp:include page="/WEB-INF/module/AdminTop.jsp"/>

<!-- First Container -->

	<div style="height:200px"></div>
	<center>
	<div class="panel panel-default" style="width:60%" >
		<div class="panel-heading" style="background-color:#2F2F2F;color:white" align="center">���� �ݳ�</div>
		<div class="panel-body">
			
				<table class="table" style="color:black; width:50%" align="center">
					<tr>
						<td>�����ڵ�</td>
						<td><input type="text" name="bookCode" id="bookCode"/>&ensp;
							<input type="button" id="selectbtn" value="��ȸ" class="btn btn-default">
						</td>
					</tr>
					<tr>
						<td>������</td>
						<td><input type="text" name="bookName" id="bookName" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>�����̸�</td>
						<td><input type="text" name="writer" id="writer" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>���ǻ�</td>
						<td><input type="text" name="publisher" id="publisher" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>�з���</td>
						<td><input type="text" name="category" id="category" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>�帣</td>
						<td><input type="text" name="genre" id="genre" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>��ġ</td>
						<td><input type="text" name="bookLocation" id="bookLocation" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>�뿩������</td>
						<td><input type="text" name="rentalStartDay" id="rentalStartDay" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>�����ݾ�</td>
						<td><input type="text"/></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><button type="submit" class="btn btn-default">����/�ݳ�</button></td>
					</tr>
				</table>
			
		</div>
	</div>
	</center>
	<div style="height:100px"></div>
<script>
$(document).ready(function(){
	$("#selectbtn").click(function(){
		$.ajax({
			url : "/selectbook",
			type : "POST",
			data : {"bookCode" : $('#bookCode').val()},
			dateType : "json",
			success: function(data){
				console.log(data);
				$('#bookName').val(data.bookName);
				$('#writer').val(data.writer);
				$('#publisher').val(data.publisher);
				$('#category').val(data.category);
				$('#genre').val(data.genre);
				$('#bookLocation').val(data.bookLocation);
				var rentalStartDay = data.rentalStartDay;
				var rentalFinishDay = data.rentalFinishDay;
				$('#rentalStartDay').val(rentalStartDay);
				$('#rentalFinishDay').val(data.rentalFinishDay);
			}
			
		});			
	});
});
</script>


<jsp:include page="/WEB-INF/module/footer.jsp"/>

</body>
</html>
