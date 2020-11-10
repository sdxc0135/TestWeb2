<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/TestWeb/css/bootstrap.css">
        <link rel="stylesheet" href="/TestWeb/css/custom.css">
        <title>BBS Test</title>
    </head>

	<body>
    <nav class="navbar navbar-default" id="nav">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/TestWeb">MIN and PARK</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/TestWeb" style="margin-right: 10px;">메인</a></li>
                <li><a href="/TestWeb/bbs/list.bbs">게시판</a></li>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
            	<c:choose>
            		<c:when test="${sessionScope.user == null }">
            			<li class="dropdown">
		                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span></a>
		                    <ul class="dropdown-menu">
		                        <li><a href="/TestWeb/user/login.user?reqURI=${reqURI}">로그인</a></li>
		                        <li><a href="/TestWeb/user/join.user">회원가입</a></li>
		                    </ul>
		                </li>
            		</c:when>
            		<c:otherwise>
            			<li class="dropdown">
            				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">회원메뉴<span class="caret"></span></a>
            				<ul class="dropdown-menu">
		                        <li><a href="/TestWeb/user/logout.user">LOGOUT</a></li>
		                        <li><a href="/TestWeb/user/mypage.user">회원정보</a></li>
		                    </ul>
            			</li>
            		</c:otherwise>
            	</c:choose>
            </ul>
        </div>
    </nav>

    