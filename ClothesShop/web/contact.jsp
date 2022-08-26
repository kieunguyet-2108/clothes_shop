<%-- 
    Document   : contact
    Created on : Mar 20, 2022, 1:33:37 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include  file="include/Head.jsp" %>
    </head>
    <body>
        <%@include  file="include/Header.jsp" %>
        <div class="container" style="margin-bottom: 100px;">
            <section class="contact spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                            <div class="contact__widget">
                                <span class="icon_phone"></span>
                                <h4>Phone</h4>
                                <p>+55 - 928 - 414</p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                            <div class="contact__widget">
                                <span class="icon_pin_alt"></span>
                                <h4>Address</h4>
                                <p>Ha Noi</p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                            <div class="contact__widget">
                                <span class="icon_clock_alt"></span>
                                <h4>Open time</h4>
                                <p>10:00 am to 23:00 pm</p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                            <div class="contact__widget">
                                <span class="icon_mail_alt"></span>
                                <h4>Email</h4>
                                <p>abcd@gmail.com</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <div class="map">
                <iframe
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.5400242364744!2d105.84729461488308!3d21.011067686007962!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab8ba9bb3a45%3A0xb4aef3b19c6583db!2zMTkxIELDoCBUcmnhu4d1LCBMw6ogxJDhuqFpIEjDoG5oLCBIYWkgQsOgIFRyxrBuZywgSMOgIE7hu5lpLCBWaWV0bmFt!5e0!3m2!1sen!2s!4v1647764314603!5m2!1sen!2s" 
                    height="500" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                <div class="map-inside">
                    <i class="icon_pin"></i>
                    <div class="inside-widget">
                        <h4>HÀ NỘI</h4>
                        <ul>
                            <li>Phone: +55 - 928 - 414</li>
                            <li>Add: 191 Ba Trieu - Hai Ba Trung - Ha Noi</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <%@include  file="include/Footer.jsp" %>
    </body>
</html>
