<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- 다음 우편번호 검색 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function getDaumPostcode(){
		new daum.Postcode({
			oncomplete: function(data){
				//팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분
				
				//각 주소의 노출 규칙에따라 주소를 조합한다.
				//내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var fullAddr=''; //최종 주소 변수
				var extraAddr='';//조합형 주소 변수
				
				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if(data.userSelectedType==='R'){	//사용자가 도로명 주소를 선택했을 경우
					fullAddr= data.roadAddress;
				}else{//사용자가 지번 주소를 선택했을 경우(J)
					fullAddr = data.jibunAddress;					
				}
				
				//사용자가 선택한 주소가 도로명 타입일대 조합한다.
				if(data.userSelectedType='R'){
					//법정동명이 있을 경우 추가한다.
					if(data.bname !==''){
						extraAddr +=data.bname;
					}
					//건물명이 있을 경우 추가한다.
					if(data.buildingName !==''){
						extraAddr += (extraAddr !==''?', '+data.buildingName : data.buildingName);
					}
					//조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
					fullAddr += (extraAddr !==''?'('+ extraAddr+')' : '');
				}
			//우편번호와 주소 정보를 해당 필드에 넣는다.	
		//	document.getElementById('memberPostcode').vaule=data.zonecode; //5자리 새 우편번호 사용
			$('#memberPostcode').val(data.zonecode);	//javascript는 안되는데 jquery는 됨.
			document.getElementById('memberAddr').value=fullAddr;
			console.log(data);
			console.log(data.zonecode);
			//커서를 상세주소 필드로 이동한다.
			document.getElementById('memberAddr2').focus();
			}
		}).open();
	}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/module/MemberTop.jsp"/>
<!-- Header -->
    <header>
    <p align="right"><a class="btn btn-warning btn-lg" href="login">관리자 로그인</a></p>
        <div id="mainbody" align="center">
        	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                <div class="intro-lead-in">꿈과 사랑이 가득한</div>
                <div class="intro-heading">JB 도서관에 오신것을 환영합니다.</div>
                <!-- Button trigger modal -->
<button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#myModal">
  회원가입
</button>

<!-- 회원가입  폼 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">회원가입 신청서</h4>
      </div>
      <div class="modal-body">
      
      <!-- 회원가입 폼 -->
        <form action="index" method="post">
			<table class="table table-hover">
				<tr>
					<td>도서관</td>
					<td><select name="libCode">
						<option>도서관을 선택하세요.</option>
						<c:forEach var="library" items="${library}">
							<option value="${library.libCode}">${library.libName}</option>
						</c:forEach>
					</select>  </td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="memberId" placeholder="아이디"/>
				</tr>
				<tr>
				<td>비밀번호</td>
					<td><input type="password" name="memberPw" placeholder="비밀번호"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="memberName" placeholder="이름"/></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="memberBirthDay" 
						maxlength="6" size="15" placeholder="생년월일 ex)880701"/>
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" size="3" maxlength="3" name="phone1" placeholder="000"/>-
					<input type="text" size="4" maxlength="4" name="Phone2" placeholder="0000"/>-
					<input type="text" size="4" maxlength="4" name="Phone3" placeholder="0000"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" id="memberPostcode" name="postNum" placeholder="우편번호" size="5" readonly="readonly"/>
						<input type="button" onclick="getDaumPostcode()" value="우편번호 찾기"/><br/>
						<input type="text" id="memberAddr" name="memberAddr" placeholder="주소" size="40" readonly="readonly"/><br/>
						<input type="text" id="memberAddr2" name="memberAddr2" placeholder="상세주소"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-warning">가입신청</button>&nbsp;<button type="reset" class="btn btn-warning">다시입력</button>
					</td>
				</tr>
			</table>
		</form>
	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-warning">Apply</button>
      </div>
    </div>
  </div>
</div>
        </div>
    </header>
<jsp:include page="/WEB-INF/module/footer.jsp"/>
</body>
</html>