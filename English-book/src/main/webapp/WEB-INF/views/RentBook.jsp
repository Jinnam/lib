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
		<div class="panel-heading" style="background-color:#2F2F2F;color:white" align="center">회원정보</div>
		<div class="panel-body">
			<table class="table" style="color:black; width:60%" align="center">
				<tr>
					<td>회원아이디</td>
					<td><input type="text" name="MEMBERID" id="memberId"/>
						<button id="memberBtn" class="btn btn-default">조회</button>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="MEMBERNAME"/></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" id="MEMBERPHONE"/></td>
				</tr>
			</table>
		</div>
	</div>


	<div class="panel panel-default" style="width:40%" align="right">
		<div class="panel-heading" style="background-color:#2F2F2F;color:white" align="center">도서정보</div>
		<div class="panel-body">
			<table class="table" style="color:black; width:60%" align="center">
				<tr>
					<td>도서코드</td>
					<td><input type="text"/> <button class="btn btn-default">조회</button> </td>
				</tr>
				<tr>
					<td>도서명</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>저자이름</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>출판사</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>분류명</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>장르</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>위치</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>대여시작일</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td>반납예정일	</td>
					<td><input type="text"/></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>결제금액</td>
					<td><input type="text"/>원</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><button class="btn btn-default">결제/대여</button></td>
				</tr>
			</table>
		</div>
	</div>
</center>
	<div style="height:100px"></div>
<script>
$(document).ready(function(){
    $("#memberBtn").click(function(){
    	console.log('버튼클릭');
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
