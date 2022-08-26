<%-- 
    Document   : account
    Created on : Mar 21, 2022, 5:28:19 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="include/Head.jsp" %>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    </head>
    <body >
        <%@include file="include/Header.jsp" %>
        <div class="container" style="background-color: white;">
            <div class="row py-5" style="height: 800px;">
                <div class="col-md-3" style="border:solid 1px whitesmoke;">
                    <img src="img/user.JPG" class="mt-3" width="130" height="130" style="border-radius: 40%;margin-left: 50px;">
                    <h5 class="text-center mt-2 mb-5 font-weight-bold">${user.getEmail()}</h5>

                    <div class="text-center mb-4 border-bottom py-3 "><a href="./account?action=infor" class="text-decoration-none text-dark">Thông tin của tôi</a></div>
                    <div class="text-center mb-4 border-bottom py-3"><a href="./account?action=showOrder" class="text-decoration-none text-dark">Đơn hàng của tôi</a></div>
                    <div class="text-center mb-4 border-bottom py-3"><a href="./account?action=showAdress" class="text-decoration-none text-dark">Địa chỉ</a></div>
                    <div class="text-center mb-4 border-bottom py-3"><a href="./logout" class="text-decoration-none text-dark">Đăng xuất</a></div>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-8" style="border:solid 2px whitesmoke;">
                    <form method="post">
                        <c:if test="${action == 'infor'}">
                            <h3 class="font-weight-bold col-md-11 border-bottom ml-2 mt-4 pb-4 mb-2" style="color: #a29b9b;">Hồ sơ của tôi</h3>
                            <div class=" row ml-2 py-4">
                                <label class="col-md-3 text-center mt-1" style="font-size: 18px;color: #a29b9b;">Full Name</label>
                                <input name="fullname" type="text" value="${user.getUserName()}" class="col-md-8 py-2" placeholder="Enter your full name" style="border: 1px solid #dddcdc;">
                            </div>
                            <div class=" row ml-2 py-4">
                                <label class="col-md-3 text-center  mt-1" style="font-size: 18px;color: #a29b9b;">Email</label>
                                <input type="text" value="${user.getEmail()}" class="col-md-8 py-2" style="border: 1px solid #dddcdc;" readonly>
                            </div>
                            <div class=" row ml-2 py-4">
                                <label class="col-md-3 text-center " style="font-size: 18px;color: #a29b9b;">Gender</label>
                                <div class="form-check mr-5">
                                    <input class="form-check-input" name="gender" type="radio"  id="flexRadioDefault1" value="Male">
                                    <label class="form-check-label" for="flexRadioDefault1" style="font-size: 18px;">
                                        Male
                                    </label>
                                </div>
                                <div class="form-check ">
                                    <input class="form-check-input" type="radio" name="gender" id="flexRadioDefault2" value="Female">
                                    <label class="form-check-label" for="flexRadioDefault2" style="font-size: 19px;">
                                        Female
                                    </label>
                                </div>
                            </div>
                            <div class=" row ml-2 py-4">
                                <label class="col-md-3 text-center  mt-1" style="font-size: 18px;color: #a29b9b;">Date of birth</label>
                                <input type="date" name="dob" class="col-md-8 py-2" style="border: 1px solid #dddcdc;" >
                            </div>
                            <div class=" row ml-2 py-4 ">
                                <input type="submit" value="SAVE CHANGES" class="btn btn-outline-light border text-dark col-md-2 ml-5">
                                <div class="custom-file col-md-5 border" style="margin-left: 200px;">
                                    <input type="file" class="custom-file-input" id="customFile" name="filename" >
                                    <label class="custom-file-label" style="background-color: white;" for="customFile">Thay đổi ảnh đại diện</label>
                                </div>
                            </div>
                        </c:if>
                    </form>>

                </div>
            </div>
        </div>

        <%@include file="include/Footer.jsp" %>
        <script>
            // Add the following code if you want the name of the file appear on select
            $(".custom-file-input").on("change", function () {
                var fileName = $(this).val().split("\\").pop();
                $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
            });
        </script>
    </body>
</html>
