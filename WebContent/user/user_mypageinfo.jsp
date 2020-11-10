<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/header.jsp" %>
    
<section>
        <div class="container">
            <div class="row join-wrap">
                <!--join-form을 적용한다 float해제 margin:0 auto-->
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER INFO                    
                    </div>
                    
                    
                    <p>*표시는 필수 입력 표시입니다</p>
                    <form action="req_modify.user" method="post" name="modify_form"> 
	                    <table class="table">
	                        <tbody class="m-control">
	                            <tr>
	                                <td class="m-title">*ID</td>
	                                <td><input class="form-control input-sm" type="text" name="id" value="${sessionScope.user.id }" readonly></td>
	                            </tr>
	                            <tr>
	                                <td class="m-title">*이름</td>
	                                <td><input class="form-control input-sm" type="text" name="name" value="${sessionScope.user.name }"></td>
	                            </tr>
	                            <tr>
	                                <td class="m-title">*비밀번호</td>
	                                <td><input class="form-control input-sm" type="password" name="pw" id="pw" onkeyup="check_pw()"></td>
	                            </tr>
	                            <tr>
	                                <td class="m-title">*비밀번호확인</td>
	                                <td><input class="form-control input-sm" type="password" name="pwChk"  id="pw2" onkeyup="check_pw()">&nbsp;<span id=checkpw></span></td>
	                            </tr>
	                            <tr>
	                                <td class="m-title">*E-mail</td>
	                                <td>
	                                    <input class="form-control input-sm" type="text" name="email1" value="${sessionScope.user.email1}">@
	                                    <select class="form-control input-sm sel">
	                                        <option ${sessionScope.user.email2 eq naver.com?'selected':''}>naver.com</option>
	                                        <option ${sessionScope.user.email2 eq gmail.com?'selected':''}>gmail.com</option>
	                                        <option ${sessionScope.user.email2 eq daum.com?'selected':''}>daum.net</option>
	                                    </select>
	                                    <button class="btn btn-info">중복확인</button>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="m-title">*휴대폰</td>
	                                <td>
	                                    <input class="form-control input-sm sel" type="text" name="phone_number1" value="${sessionScope.user.phone_number1}"> -
	                                    <input class="form-control input-sm sel" type="text" name="phone_number2" value="${sessionScope.user.phone_number2}"> -
	                                    <input class="form-control input-sm sel" type="text" name="phone_number3" value="${sessionScope.user.phone_number3}">
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="m-title">*주소</td>
	                                <td><input class="form-control input-sm add" type="text" name="address1" value="${sessionScope.user.address1 }"></td>
	                            </tr>
	                            <tr>
	                                <td class="m-title">*상세주소</td>
	                                <td><input class="form-control input-sm add" type="text" name="address2" value="${sessionScope.user.address2 }"></td>
	                            </tr>
	                        </tbody>
	                    </table>
	                    
	                    <div class="titlefoot">
	                        <button type="button" class="btn" onclick="check()">수정</button>
	                        <button type="button" class="btn" onclick="location.href='mypage.user'" >목록</button>
	                    </div>
                    </form> 
                </div>


            </div>

        </div>

    </section>

<script type="text/javascript">
	function check_pw(){
		if(document.getElementById('pw').value !=''){
            if(document.getElementById('pw').value==document.getElementById('pw2').value){
                document.getElementById('checkpw').innerHTML='비밀번호가 일치합니다.'
                document.getElementById('checkpw').style.color='blue';
            }
            else{
                document.getElementById('checkpw').innerHTML='비밀번호가 일치하지 않습니다.';
                document.getElementById('checkpw').style.color='red';
            }
        }
	}
	
	/* 자바의 함수와 같음, 반환유형 없음  */
	function check(){
		//form에서만 사용 가능
		//form태그는 유일하게 document.form이름.이름.. 이런 형태로 접근이 가능합니다.
		//document는 현재 페이지를 의미함, form은 document의 자식임
		//문서에서 form에 접근 한다는 의미임 
		//name 속성을 사용해 접근
		
		var exp2 = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}/;
		
		if(!exp2.test(document.modify_form.pw.value)){
			alert("비밀번호는 영 대/소문자, 숫자, 특수문자 3종류 이상 조합 8자 이상입니다.");
			return;	//함수종료
		}
		else if (document.modify_form.pw.value != document.modify_form.pwChk.value){
			alert("비밀번호가 일치하지 않습니다.");
			return;	//함수종료
		}
		else if(document.modify_form.name.value == ''){
			alert("이름은 필수입니다.");
			return;
		}
		else{
			//submit을 보낼 수 있으며 submit()함수를보냅
			alert("너브밋!")
			document.modify_form.submit();
		}
	}
	
</script>    
    
<%@ include file="/include/footer.jsp" %>