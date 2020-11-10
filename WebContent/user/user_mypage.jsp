<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>      
    
<%@ include file="/include/header.jsp" %>
<section>
        <div class="container">
            <div class="row join-wrap">
                
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER                   
                    </div>
                    <div>
                        <p>${sessionScope.user.id}님 회원정보</p>
                    </div>
                    <div>
                        <button type="button" class="btn btn-primary" onclick="location.href='mypageinfo.user'">회원정보변경</button>
                        <button type="button" class="btn btn-primary" id="delCheck">회원 탈퇴</button>
                        
                    </div>
                    <div class="delete-hidden">
                        <form action="delete.user" method="post">
                        <input type="hidden" name="id" value="${sessionScope.user.id}">
                        <input type="password" class="form-control" name="pw" placeholder="비밀번호를 입력하세요">
                        <button type="button" class="btn btn-primary" onclick="submit();" >확인</button>
                        </form>
                    </div>
                    
                    <br>
                    <div>
                        <p>${sessionScope.user.id}님의 작성 게시물</p>
                        <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                    <thead>
                        <tr>
                            <th style="text-align: center;">번호</th>
                            <th style="text-align: center;">제목</th>
                            <th style="text-align: center;">작성자</th>
                            <th style="text-align: center;">작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="item" items="${myBoardList}">
                    	<tr>
                    		<td>${item.bno}</td>
                            <td><a href="/TestWeb/bbs/content.bbs?bno=${item.bno}">${item.title}</a></td>
                            <td>${item.writer}</td>
                            <td><fmt:formatDate value="${item.regdate}" pattern="yyyy-MM-dd hh:mm"/></td>
                        </tr>
                    	</c:forEach>
                    </tbody>
                </table>
                <div class="text-center">
                    <ul class="pagination pagination-sm">
                        <c:if test="${pageVo.prev}"><li><a href="mypage.user?page=${pageVo.start-1}">이전</a></li></c:if>
                        <c:forEach var="pageNum" begin="${pageVo.start}" end="${pageVo.end}">
                        	<li class="${pageNum eq pageVo.page?'active':''}"><a href="mypage.user?page=${pageNum}">${pageNum}</a></li>
                        </c:forEach>
                        <c:if test="${pageVo.next}"><li><a href="mypage.user?page=${pageVo.start+1}">다음</a></li></c:if>
                    </ul>
                </div>
                    </div>
                    
                    
                </div>


            </div>

        </div>

    </section>
    
    
    <script>
        //탈퇴버튼 디스플레이 처리
        var delCheck = document.getElementById("delCheck");
        delCheck.onclick = function() {
            var del  = document.querySelector(".delete-hidden");
            if(del.style.display == "none" || del.style.display == "") {
                del.style.display = "inline";
            } else {
                del.style.display = "none";
            }
        }
    </script>
<%@ include file="/include/footer.jsp" %>