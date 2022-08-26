<%-- 
    Document   : HeaderSectionBegin
    Created on : Mar 18, 2022, 1:43:37 PM
    Author     : ADMIN
--%>
<%@page import="models.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dal.CategoryDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Head.jsp" %>
<%
    CategoryDAO Cdao = new CategoryDAO();
    ArrayList<Category> categories = Cdao.getAllCategories();

%>
<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__left">
                        <ul>
                            <li><i class="fa fa-envelope"></i> acbcd@gmail.com</li>
                            <li><i class="fa fa-phone"></i> +55-928-414</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__right d-flex justify-content-end">
                        <div class="header__top__right__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-linkedin"></i></a>
                        </div>
                        <div class="header__top__right__auth d-flex mt-1">
                            <i class="fa fa-user mx-2 " style="margin-top: 2px;"></i>
                            <c:if test="${sessionScope.userLogin==null}">
                                <a href="./login"> Đăng nhập </a>
                                <a href="./register"> / Đăng ký</a>
                            </c:if>
                            <c:if test="${sessionScope.userLogin!=null}">
                                <a>${sessionScope.userLogin.getUserName()} </a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="./home"><img src="img/banner/logo.PNG" alt="" ></a>
                </div>
            </div>
            <div class="col-lg-8 mt-3">
                <nav class="header__menu">
                    <ul>
                        <li><a href="./home">Home</a></li>
                        <li><a href="./shop">Shopping</a></li>
                        <li>
                            <a >Categories</a>
                            <ul class="header__menu__dropdown">
                                <c:forEach items="<%=categories%>" var="c">
                                    <li><a href="./shop?categoryid=${c.getCategoryId()}">${c.getCategoryName()}</a></li>
                                    </c:forEach>
                            </ul>
                        </li>
                        <li><a href="./size">Size Chart</a></li>
                        <li><a href="./contact">Contact</a></li>
                            <c:if test="${sessionScope.userLogin!=null}">
                            <li>
                                <a>Account</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./account?action=infor">Information</a></li>
                                    <li><a href="./logout">Log out</a></li>
                                </ul>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-1 mt-3">
                <div class="header__cart">
                    <ul class="cart">
                        <li><a href="./cart"><i class="fa fa-shopping-bag"></i> <span>${carts.size()}</span></a></li>
                    </ul>
                    
                </div>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>
<!-- Header Section End -->
