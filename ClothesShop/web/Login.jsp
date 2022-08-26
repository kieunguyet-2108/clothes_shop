<%-- 
    Document   : Login
    Created on : Mar 18, 2022, 1:17:08 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/style1.css" type="text/css">
        <%@include file="include/Head.jsp" %>

    </head>
    <body >
        <%@include file="include/Header.jsp" %>
        <div class="container d-flex justify-content-center" >
            <div class=" d-flex justify-content-center border" id="main_login" >
                <form class="w-100 py-4 pb-4 px-5" method="post">
                    <h3 class="font-weight-bold pb-4 pt-2 text-center">Đăng nhập</h3>
                    <div class="d-flex py-2 ">
                        <a href="./home" class="text-dark text-decoration-none">Trang chủ</a>
                        <i class='fa fa-angle-double-right mx-2 mt-1'></i>
                        <a href="./login" class="text-dark text-decoration-none">Đăng nhập</a>
                    </div>
                    <div class="form-group ">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control " id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email" value="${email}">
                    </div>
                    <div class="form-group ">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control " id="exampleInputPassword1" placeholder="Password" name="password" value="${password}">
                    </div>

                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
                        <label class="form-check-label" for="exampleCheck1">Remember me</label>
                    </div>
                    <button type="submit" class="btn btn-outline-light text-dark px-4 border mt-3">Đăng nhập</button>
                    <c:if test="${forAction} == ''">
                        <p class="mt-2 ">Bạn chưa có tài khoản?<a href="./register" class="text-decoration-none text-danger ml-1">Đăng ký</a></p>
                    </c:if>
                    <c:if test="${forAction != ''}">
                        <p class="mt-2 ">Bạn chưa có tài khoản?<a href="./register?${queryString}" class="text-decoration-none text-danger ml-1">Đăng ký</a></p>
                    </c:if>
                    <p class="text-danger mt-2">${message}</p>
                </form>
            </div>

        </div>

        <!-- Latest Product Section End -->
        <%@include file="include/Footer.jsp" %>
    </body>
</html>
