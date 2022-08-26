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
            <div class=" d-flex justify-content-center border" id="main_register" >
                <form class="w-100 py-4 pb-4 px-5" method="post">
                    <h3 class="font-weight-bold pb-4 pt-2 text-center">Đăng Ký</h3>
                    <div class="d-flex py-2 ">
                        <a href="./home" class="text-dark text-decoration-none">Trang chủ</a>
                        <i class='fa fa-angle-double-right mx-2 mt-1'></i>
                        <a href="./register" class="text-dark text-decoration-none">Đăng ký</a>
                    </div>

                    <div class="form-group ">
                        <label for="exampleInputEmail1">Email</label>
                        <input type="email" class="form-control "  id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email" value="${email}" required="">
                    </div>
                    <div class="form-group ">
                        <label for="exampleInputPassword1">Mật khẩu</label>
                        <input type="password" class="form-control " id="exampleInputPassword1" placeholder="Password" name="password" value="${password}" required="">
                    </div>
                    <div class="form-group ">
                        <label for="exampleInputPassword1">Nhập lại mật khẩu</label>
                        <input type="password" class="form-control " id="exampleInputPassword1" placeholder="Password" name="re_password" value="${password}" required="">
                    </div>
                    <button type="submit" class="btn btn-outline-light text-dark px-4 border mt-2">Đăng Ký</button>
                    <p class="mt-2 ">Bạn đã có tài khoản?<a href="./login" class="text-decoration-none text-danger ml-1">Đăng nhập</a></p>
                    <p class="text-danger mt-2">${message}</p>
                </form>
            </div>

        </div>

        <!-- Latest Product Section End -->
        <%@include file="include/Footer.jsp" %>
    </body>
</html>
