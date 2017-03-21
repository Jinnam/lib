<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head>
<body>
<jsp:include page="/WEB-INF/module/AdminTop.jsp"/>

<!-- First Container -->

	<div style="height:50px"></div>
	<center>
	<div class="panel panel-default" style="width:60%" >
		<div class="panel-heading" style="background-color:#2F2F2F;color:white" align="center">���� �ݳ�</div>
		<div class="panel-body">
			<form action="returnbook" method="post">
				<table class="table" style="color:black; width:50%" align="center">
					<tr>
						<td>�����ڵ�</td>
						<td><input type="text" name="bookCode" id="bookCode" value="100000010"/>&ensp;
							<input type="button" id="selectbtn" value="��ȸ" class="btn btn-default">
							<input type="hidden" id="paymentCode" name="paymentCode"/>
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
						<td>�뿩�Ⱓ</td>
						<td><input type="text" name="rentalDays" id="rentalDays" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>�����ȱݾ�</td>
						<td><input type="text" name="paidMoney" id="paidMoney" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>�����ݾ�</td>
						<td><input type="text" name="remainMoney" id="remainMoney" readonly="readonly"/></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><button type="submit" class="btn btn-default">����/�ݳ�</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	</center>
	<div style="height:50px"></div>
<script>
$(document).ready(function(){
	$("#selectbtn").click(function(){
		$.ajax({
			url : "returnbookinfo",
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
				$('#rentalDays').val(data.rentalDays);
				
			},
			error : function(request,status,error){
    	        alert("code:"+request.status+"\n"+"error: å������ �����ϴ�.\n"+error);
    	       }
			
		})
		
		$.ajax({
			url : "returnpayinfo",
			type : "POST",
			data : {"bookCode" : $('#bookCode').val()},
			dateType : "json",
			success: function(data){
				console.log(data);
				$('#paymentCode').val(data.paymentCode);
				var paymentPrice = data.paymentPrice;
				$('#paidMoney').val(paymentPrice);
				if(data.paymentStatus=='N'){
					console.log("����ȸ��");
					$('#remainMoney').val(2000-paymentPrice);	
				}else if(data.paymentStatus=='Y'){
					console.log("����ȸ��");
					$('#remainMoney').val(1000-paymentPrice);
				}
				
				
			}
		})
	})
})
</script>


<jsp:include page="/WEB-INF/module/footer.jsp"/>

</body>
</html>
