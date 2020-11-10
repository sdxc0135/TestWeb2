<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp" %>
    
<!--login만 적용되는 css-->   
<style>
    .table-striped>tbody>tr {
        background-color: #f9f9f9
    }

    .join-form {
        margin: 100px auto;
        padding: 20px;
        width: 50%;
        float: none;
        background-color: white;
    }
</style>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2>로그인<small>(가운데정렬)</small></h2>
                    
                    
                    <form action="chk_login.user" method="post" >
                    	<input type="hidden" name="reqURI" value="${reqURI}">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" id="id" placeholder="아이디" name="id" required>
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" id="password" placeholder="비밀번호 " name="pw" required>
                        </div>
                        
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block" onclick="submit();">로그인</button>
                        </div>
                        
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" onclick="location.href='join.user'">회원가입</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </section>

<%@ include file="/include/footer.jsp" %>