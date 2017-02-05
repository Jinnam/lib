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
			<div class="panel-heading" style="background-color:#2F2F2F;color:white" align="center">회원정보</div>
			<div class="panel-body">
			
				<table class="table" style="color:black; width:60%" align="center">
					<tr>
						<td>회원아이디</td>
						<td><input type="text" name="memberId" id="memberId"/>
							<input type="button" value="조회" id="memberBtn" class="btn btn-default"/>
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name = "memberName" id="memberName" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text" name = "memberPhone" id="memberPhone" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>유료회원 여부</td>
						<td><input type="text" name="memberPaymentStatus" id="memberPaymentStatus"/> </td>
					</tr>
				</table>
			</div>
		</div>
	
	
		<div class="panel panel-default" style="width:40%" >
			<div class="panel-heading" style="background-color:#2F2F2F;color:white; align:center">도서정보</div>
			<div class="panel-body" style="align:center">
			
				<table class="table" style="color:black; width:60%; align :center">
					<tr>
						<td>도서코드</td>
						<td><input type="text" name="bookCode" id="bookCode"/>
							<input type="button" value="조회" class="btn btn-default" id="bookbtn"/>
						</td>
					</tr>
					<tr>
						<td>도서명</td>
						<td><input type="text" name="bookName" id="bookName" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>저자이름</td>
						<td><input type="text" name="writer" id="writer" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>출판사</td>
						<td><input type="text" name="publisher" id="publisher" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>분류명</td>
						<td><input type="text" name="category" id="category" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>장르</td>
						<td><input type="text" name="genre" id="genre" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>위치</td>
						<td><input type="text" name="bookLocation" id="bookLocation" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>대여시작일</td>
						<td><input type="text" name="rentalStartDay" id="rentalStartDay" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>반납예정일	</td>
						<td><input type="text" name="rentalFinishDay" id="rentalFinishDay" readonly="readonly"/></td>
					</tr>
					<tr>
						<td>결제금액</td>
						<td><input type="text" name="totalPrice" id="totalPrice" readonly="readonly"/>원</td>
					</tr>
					<tr>
						<td>받은금액</td>
						<td>
							<select name="paymentPrice">
								<option value="0">0</option>
								<option id="paymentPrice"></option>
							</select>원
						</td>
					</tr>
					<tr>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><button type="submit" class="btn btn-default">결제/대여</button></td>
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
    	console.log('버튼클릭');
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
					$('#memberPaymentStatus').val("유료회원")
				}else{
					$('#memberPaymentStatus').val("무료회원")
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
				if($('#memberPaymentStatus').val()=="유료회원"){
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
