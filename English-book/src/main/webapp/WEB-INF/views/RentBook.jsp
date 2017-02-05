<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head>
<body>
<jsp:include page="/WEB-INF/module/AdminTop.jsp"/>

<!-- First Container -->

	<div style="height:100px"></div>
<center>
	<form action="/rentbook" method="post">
		<div class="panel panel-default" style="width:40%" align="left">
			<div class="panel-heading" style="background-color:#2F2F2F;color:white" align="center">ȸ������</div>
			<div class="panel-body">
			
				<table class="table" style="color:black; width:60%" align="center">
					<tr>
						<td>ȸ�����̵�</td>
						<td><input type="text" name="memberId" id="memberId"/>
							<input type="button" value="��ȸ" id="memberBtn" class="btn btn-default"/>
						</td>
					</tr>
					<tr>
						<td>�̸�</td>
						<td><input type="text" name = "memberName" id="memberName" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>��ȭ��ȣ</td>
						<td><input type="text" name = "memberPhone" id="memberPhone" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>����ȸ�� ����</td>
						<td><input type="text" name="memberPaymentStatus" id="memberPaymentStatus"/> </td>
					</tr>
				</table>
			</div>
		</div>
	
	
		<div class="panel panel-default" style="width:40%" >
			<div class="panel-heading" style="background-color:#2F2F2F;color:white; align:center">��������</div>
			<div class="panel-body" style="align:center">
			
				<table class="table" style="color:black; width:60%; align :center">
					<tr>
						<td>�����ڵ�</td>
						<td><input type="text" name="bookCode" id="bookCode"/>
							<input type="button" value="��ȸ" class="btn btn-default" id="bookbtn"/>
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
						<td>�ݳ�������	</td>
						<td><input type="text" name="rentalFinishDay" id="rentalFinishDay" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>�����ݾ�</td>
						<td><input type="text" name="totalPrice" id="totalPrice" readonly="readonly"/>��</td>
					</tr>
					<tr>
						<td>�����ݾ�</td>
						<td>
							<select name="paymentPrice">
								<option value="0">0</option>
								<option id="paymentPrice"></option>
							</select>��
						</td>
					</tr>
					<tr>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><button type="submit" class="btn btn-default">����/�뿩</button></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</center>
	<div style="height:100px"></div>
<script>
$(document).ready(function(){
    $("#memberBtn").click(function(){
    	console.log('��ưŬ��');
       $.ajax({
    	   url : "/rentmember",
    	   type : "POST",
    	   data : {"memberId" : $('#memberId').val()},
    	   dataType : "json",
    	   success : function(data){
    		   console.log(data);
				$('#memberName').val(data.memberName);
				$('#memberPhone').val(data.memberPhone);
				var memberPayStatus = data.memberPaymentStatus;
				console.log(memberPayStatus);
				if(memberPayStatus=='Y'){
					$('#memberPaymentStatus').val("����ȸ��")
				}else{
					$('#memberPaymentStatus').val("����ȸ��")
				}
				
    	   }
       })
    });
 
	$("#bookbtn").click(function(){
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
				$('#rentalStartDay').val(data.rentalStartDay);
				$('#rentalFinishDay').val(data.rentalFinishDay);
			}
		})
		 $.ajax({
    	   url : "/costselect",
    	   type : "POST",
    	   dataType : "json",
    	   success : function(data){
				console.log(data);
				var memberRentalCost = data.memberRentalCost;
				var nonMemberRentalCost = data.nonMemberRentalCost;
				if($('#memberPaymentStatus').val()=="����ȸ��"){
					$('#totalPrice').val(memberRentalCost);
					$('#paymentPrice').val=data.memberRentalCost;
					$("#paymentPrice").html(data.memberRentalCost);
				}else{
					$('#totalPrice').val(nonMemberRentalCost);
					$('#paymentPrice').val=data.nonMemberRentalCost;
					$("#paymentPrice").html(data.nonMemberRentalCost);
				}
				
    	   }
       })
	});
});
</script>

<jsp:include page="/WEB-INF/module/footer.jsp"/>

</body>
</html>
