<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

 <%@ include file="/include/header.jsp" %>
    
    <!--회원가입 폼만 적용되는 css-->
    <style type="text/css">
        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }

        .join-form {
            margin: 0 auto;
            padding: 20px;
            width: 50%;
            float: none;
            background-color: white;
        }
        
        
        .form-group > .sel {
            width: 120px;
            display: inline-block;
            
        }
    </style>
    


    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2>회원가입<small>(가운데정렬)</small></h2>

                    <form action="req_join.user" method="post" name="join_form">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 (영문포함 4~12자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" id="password" name="pw" onkeyup="check_pw()" placeholder="비밀번호 (영 대/소문자, 숫자, 특수문자 3종류 이상 조합 8자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password-confrim">비밀번호 확인</label>
                            <input type="password" class="form-control" id="password-confrim" name="pwChk" onkeyup="check_pw()" placeholder="비밀번호를 확인해주세요.">
                            <span id=checkpw></span>
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요.">
                        </div>
                        <!--input2탭의 input-addon을 가져온다 -->
                        <div class="form-group">
                            <label for="hp">휴대폰번호</label><br>
                            
                            <input class="form-control sel" name="phone_number1" placeholder="010"> -
                            <input class="form-control sel" name="phone_number2" placeholder="xxxx"> -
                            <input class="form-control sel" name="phone_number3" placeholder="xxxx">
                        
                        </div>
                        <div class="form-group">
                            <label for="hp">이메일</label><br>
                            
                            <input name="email1" class="form-control sel">@
                            <select name="email2" class="form-control sel" >
                                <option selected>naver.com</option>
                                <option>gmail.com</option>
                                <option>daum.net</option>
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <label for="addr-num">주소</label>
                            <input type="text" class="form-control" id="addr-basic" name="address1" placeholder="기본주소">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="addr-detail" name="address2" placeholder="상세주소">
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" onclick="check();">회원가입</button>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </section>
<script>
	function check_pw(){
		if(document.getElementById('password').value !=''){
	        if(document.getElementById('password').value==document.getElementById('password-confrim').value){
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
		
		var exp1 = /[a-zA-Z0-9]{4,12}/;
		var exp2 = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}/;
		
	
		var pw = document.join_form.pw.value;
		var pwChk = document.join_form.pwChk.value;
		
		if(!exp1.test(document.join_form.id.value)){
			alert("아이디는 영문포함 4~12자이어야합니다.");
			return;	//함수종료
		}	
		else if(!exp2.test(document.join_form.pw.value)){
			alert("비밀번호는 영 대/소문자, 숫자, 특수문자 3종류 이상 조합 8자 이상입니다.");
			return;	//함수종료
		}
		else if (document.join_form.pw.value != document.join_form.pwChk.value){
			alert("비밀번호가 일치하지 않습니다.");
			return;	//함수종료
		}
		else if(document.join_form.name.value == ''){
			alert("이름은 필수입니다.");
			return;
		}else{
			//submit을 보낼 수 있으며 submit()함수를보냅
			document.join_form.submit();
		}
	}
	
</script>

<%@ include file="/include/footer.jsp" %>

