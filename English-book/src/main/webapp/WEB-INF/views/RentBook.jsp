<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head>
<body>
	<jsp:include page="/WEB-INF/module/AdminTop.jsp" />

	<!-- First Container -->

	<div style="height: 50px"></div>
	<center>
		<form action="rentbook" method="post">
			<div class="panel panel-default" style="width: 40%" align="left">
				<div class="panel-heading"
					style="background-color: #2F2F2F; color: white" align="center">ȸ������</div>
				<div class="panel-body">

					<table style="color: black; width: 60%" align="center">
						<tr>
							<td>ȸ�����̵�</td>
							<td><input class="membertable" type="text" name="memberId" value="id001"
								id="memberId" /> <input type="button" value="��ȸ" id="memberBtn"
								class="btn btn-default" /></td>
						</tr>
						<tr>
							<td>�̸�</td>
							<td><input class="membertable" type="text" name="memberName"
								id="memberName" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>��ȭ��ȣ</td>
							<td><input class="membertable" type="text"
								name="memberPhone" id="memberPhone" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>����ȸ�� ����</td>
							<td><input class="membertable" type="text"
								name="memberPaymentStatus" id="memberPaymentStatus"
								readonly="readonly" /></td>
						</tr>
					</table>
				</div>
			</div>


			<div class="panel panel-default" style="width: 40%">
				<div class="panel-heading"
					style="background-color: #2F2F2F; color: white; align: center">��������</div>
				<div class="panel-body" style="align: center">

					<table style="color: black; width: 60%; align: center">
						<tr>
							<td>�����ڵ�</td>
							<td><input class="booktable" type="text" name="bookCode" value="100000003"
								id="bookCode" /> <input type="button" value="��ȸ"
								class="btn btn-default" id="bookbtn" /></td>
						</tr>
						<tr>
							<td>������</td>
							<td><input class="booktable" type="text" name="bookName"
								id="bookName" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>�����̸�</td>
							<td><input class="booktable" type="text" name="writer"
								id="writer" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>���ǻ�</td>
							<td><input class="booktable" type="text" name="publisher"
								id="publisher" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>�з���</td>
							<td><input class="booktable" type="text" name="category"
								id="category" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>�帣</td>
							<td><input class="booktable" type="text" name="genre"
								id="genre" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>��ġ</td>
							<td><input class="booktable" type="text" name="bookLocation"
								id="bookLocation" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>�뿩������</td>
							<td><input class="booktable" type="text"
								name="rentalStartDay" id="rentalStartDay" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>�ݳ�������</td>
							<td><input class="booktable" type="text"
								name="rentalFinishDay" id="rentalFinishDay" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>�����ݾ�</td>
							<td><input class="booktable" type="text" name="totalPrice"
								id="totalPrice" readonly="readonly" />��</td>
						</tr>
						<tr>
							<td>�����ݾ�</td>
							<td><select name="paymentPrice">
									<option value="0">0</option>
									<option id="paymentPrice"></option>
							</select>��</td>
						</tr>
						<tr>
							<td colspan="2"></td>
						</tr>
						<tr>
							<td colspan="2" align="right"><button type="submit"
									class="btn btn-default">����/�뿩</button></td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</center>
	<div style="height: 50px"></div>
	<script>
$(document).ready(function(){
	$("#memberBtn").click(function(){
		$('.membertable').empty();
		console.log('��ưŬ��');
		$.ajax({
			url : "rentmember",
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
				
    	   },
			error : function(request,status,error){
    	        alert("code:"+request.status+"\n"+"error: ȸ�� ������ �����ϴ�. \n"+error);
    	       }
			
       })
    });
 
	$("#bookbtn").click(function(){
		$('.booktable').empty(); 
		$.ajax({
			url : "selectbook",
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
				$('#rentalFinishDay').val(data.returnExpectDay);
			},
			error : function(request,status,error){
    	        alert("code:"+request.status+"\n"+"error: å������ �����ϴ�.\n"+error);
    	       }
		})
		 $.ajax({
    	   url : "costselect",
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
				
    	   },
			error : function(request,status,error){
    	        alert("code:"+request.status+"\n"+"error: �ܰ� ������ �����ϴ�.\n"+error);
    	       }
       })
	});
});
</script>

	<jsp:include page="/WEB-INF/module/footer.jsp" />

</body>
</html>
