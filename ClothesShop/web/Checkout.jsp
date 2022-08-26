<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="models.Shipper"%>
<%@page import="dal.ShipperDAO"%>
<%@page import="models.Cart"%>
<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ShipperDAO Sdao = new ShipperDAO();
    ArrayList<Shipper> shippers = Sdao.getAllShippers();
    User user = new User();
    if (session.getAttribute("userLogin") != null) {
        user = (User) session.getAttribute("userLogin");
    }
    ArrayList<Cart> carts = null;
    if (request.getAttribute("listOrders") != null) {
        carts = (ArrayList<Cart>) request.getAttribute("listOrders");
    }
    int total = 0;
    for (Cart c : carts) {
        total = total + c.getQuantity() * c.getProduct().getUnitPrice();
    }

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String currentDate = formatter.format(date);
    String queryString = request.getAttribute("queryString").toString();
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/Head.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="include/Header.jsp" %>
        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg" data-setbg="img/banner/pic2.JPG">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2>Checkout</h2>
                            <div class="breadcrumb__option">
                                <a href="./index.html">Home</a>
                                <span>Checkout</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Checkout Section Begin -->
        <section class="checkout spad">
            <div class="container">
                <div class="checkout__form">
                    <h4>Billing Details</h4>
                    <form action="orderProcess?<%=queryString%>" method="post">
                        <div class="row">
                            <div class="col-lg-8 col-md-6">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="checkout__input">
                                            <p>Full Name<span>*</span></p>
                                            <input type="text" name="name" value="<%=(user.getUserName() == null) ? "" : user.getUserName()%>" required="">
                                        </div>
                                    </div>

                                </div>

                                <div class="checkout__input">
                                    <p>Address<span>*</span></p>
                                    <input type="text" placeholder="Street Address - Apartment, suite, unite ect (optinal)" class="checkout__input__add" name="address"
                                           value="<%=(user.getAddress() == null) ? "" : user.getAddress()%>" required="">
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Phone<span>*</span></p>
                                            <input type="tel" name="phone" value="<%= (user.getPhone() == null) ? "" : user.getPhone()%>" required="">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Email<span>*</span></p>
                                            <input type="email" name="email" value="<%=(user.getEmail() == null) ? "" : user.getEmail()%>">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Order Date<span>*</span></p>
                                            <input type="text" name="orderdate" value="<%=currentDate%>" readonly>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Required Date<span>*</span></p>
                                            <input type="date" name="shipdate" min="<%=currentDate%>" required="">
                                        </div>
                                    </div>
                                </div>
                                <div class="checkout__input pb-4">
                                    <p>Shipping Unit<span>*</span></p>
                                    <select name="shipUnit" class="w-100">
                                        <c:forEach items="<%=shippers%>" var="s">
                                            <option value="${s.getShipId()}" style="font-size: 18px;">${s.getShipName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <br>
                                <div class="checkout__input">
                                    <p>Order notes<span> * (Notes about your order, e.g. special notes for delivery.)</span></p>
                                    <input type="text" style="height: 200px;" name="note">
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="checkout__order">
                                    <h4>Your Order</h4>
                                    <div class="checkout__order__products">Products <span>Total</span></div>
                                    <ul>
                                        <c:forEach items="${listOrders}" var="o">
                                            <div class="row pb-3 border-bottom">
                                                <li class="col-md-8">${o.getProduct().getProductName()}</li>
                                                <li class="col-md-4">
                                                    <fmt:formatNumber type = "number" 
                                                                      maxFractionDigits = "3" value = "${o.getQuantity() * o.getProduct().getUnitPrice()}" />&#8363;
                                                </li>
                                            </div>
                                        </c:forEach>
                                    </ul>
                                    <div class="checkout__order__subtotal">Subtotal <span> <fmt:formatNumber type = "number" 
                                            maxFractionDigits = "3" value = "<%=total%>" />&#8363;</span></div>
                                    <div class="checkout__order__total">Total <span><fmt:formatNumber type = "number" 
                                            maxFractionDigits = "3" value = "<%=total%>" />&#8363;</span></div>

                                    <button type="submit" class="site-btn">PLACE ORDER</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- Checkout Section End -->
        <%@include file="include/Footer.jsp" %>
    </body>
</html>
