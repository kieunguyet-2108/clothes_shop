<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="no-js" lang="en">
    <head>
        <%@include file="include/head.jsp" %>
    </head>

    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <div class="wrapper">
            <%@include file="include/header.jsp" %>
            <div class="page-wrap">
                <%@include file="include/sliderbar.jsp" %>
                <div class="main-content">
                    <div class="container-fluid">
                        <div class="page-header">
                            <div class="row align-items-end">
                                <div class="col-lg-8">
                                    <div class="page-header-title">
                                        <i class="ik ik-inbox bg-blue"></i>
                                        <div class="d-inline">
                                            <h5>Quản lý Đơn hàng</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <table id="advanced_table" class="table">
                                    <thead>
                                        <tr>
                                            <th class="nosort" width="10">
                                                <label class="custom-control custom-checkbox m-0">
                                                    <input type="checkbox" class="custom-control-input" id="selectall" name="" value="option2">
                                                    <span class="custom-control-label">&nbsp;</span>
                                                </label>
                                            </th>
                                            <th>OrderId</th>
                                            <th>Tên</th>
                                            <th>Địa chỉ</th>
                                            <th>Email</th>
                                            <th>Số điện thoại</th>
                                            <th>Ngày mua</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${orders}" var="o">
                                            <tr>
                                                <th class="nosort" width="10">
                                                    <label class="custom-control custom-checkbox m-0">
                                                        <input type="checkbox" class="custom-control-input" id="selectall" name="" value="option2">
                                                        <span class="custom-control-label">&nbsp;</span>
                                                    </label>
                                                </th>
                                                <th>${o.getOrderId()}</th>
                                                <th>${o.getName()}</th>
                                                <th>${o.getShipAddress()}</th>
                                                <th>${o.getEmail()}</th>
                                                <th>${o.getPhoneNumber()}</th>
                                                <th>${o.getOrderDate()}</th>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="footer">
                    <div class="w-100 clearfix">
                        <span class="text-center text-sm-left d-md-inline-block">Copyright © 2018 ThemeKit v2.0. All Rights Reserved.</span>
                        <span class="float-none float-sm-right mt-1 mt-sm-0 text-center">Crafted with <i class="fa fa-heart text-danger"></i> by <a href="http://lavalite.org/" class="text-dark" target="_blank">Lavalite</a></span>
                    </div>
                </footer>

            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script>window.jQuery || document.write('<script src="src/js/vendor/jquery-3.3.1.min.js"><\/script>')</script>
        <script src="plugins/popper.js/dist/umd/popper.min.js"></script>
        <script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="plugins/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>
        <script src="plugins/screenfull/dist/screenfull.js"></script>
        <script src="plugins/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
        <script src="plugins/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="plugins/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>
        <script src="plugins/jvectormap/jquery-jvectormap.min.js"></script>
        <script src="plugins/jvectormap/tests/assets/jquery-jvectormap-world-mill-en.js"></script>
        <script src="plugins/moment/moment.js"></script>
        <script src="plugins/tempusdominus-bootstrap-4/build/js/tempusdominus-bootstrap-4.min.js"></script>
        <script src="plugins/d3/dist/d3.min.js"></script>
        <script src="plugins/c3/c3.min.js"></script>
        <script src="js/tables.js"></script>
        <script src="js/widgets.js"></script>
        <script src="js/charts.js"></script>
        <script src="dist/js/theme.min.js"></script>
        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            (function (b, o, i, l, e, r) {
                b.GoogleAnalyticsObject = l;
                b[l] || (b[l] =
                        function () {
                            (b[l].q = b[l].q || []).push(arguments)
                        });
                b[l].l = +new Date;
                e = o.createElement(i);
                r = o.getElementsByTagName(i)[0];
                e.src = 'https://www.google-analytics.com/analytics.js';
                r.parentNode.insertBefore(e, r)
            }(window, document, 'script', 'ga'));
            ga('create', 'UA-XXXXX-X', 'auto');
            ga('send', 'pageview');
        </script>
    </body>
</html>
