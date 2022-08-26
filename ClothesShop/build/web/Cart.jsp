<%@page import="models.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Cart> carts = null;
    float total = 0;
    if (session.getAttribute("carts") != null) {
        carts = (ArrayList<Cart>) session.getAttribute("carts");
        for (Cart c : carts) {
            total = total + c.getQuantity() * c.getProduct().getUnitPrice();
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/Head.jsp" %>
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    </head>
    <body>
        <%@include file="include/Header.jsp" %>
        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg" data-setbg="img/banner/pic2.JPG">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2>Shopping Cart</h2>
                            <div class="breadcrumb__option">
                                <a href="./index.html">Home</a>
                                <span>Shopping Cart</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Shoping Cart Section Begin -->
        <section class="shoping-cart spad">
            <p>${cartList.size()}</p>
            <div class="container">
                <c:if test="${cartList.size() == 0}">
                    <h3 class="font-weight-bold text-center">My Cart</h3>
                    <div class="d-flex justify-content-center">
                        <img src="img/cart/empty_cart.JPG">
                    </div>
                    <p class="text-center text-dark">Không có sản phẩm nào trong giỏ hàng của bạn</p>
                    <div class="d-flex justify-content-center">
                        <a href="./shop" class="btn btn-outline-dark py-2 px-3 " style="border-radius: 7px;">Tiếp tục mua hàng </a>
                    </div>
                </c:if>
                <c:if test="${cartList.size() > 0}">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__table">
                                <table>
                                    <thead>
                                        <tr>
                                            <th class="shoping__product">Products</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessionScope.carts}" var="c">
                                            <tr>
                                                <td class="shoping__cart__item d-flex ">
                                                    <a href="./product_details?productid=${c.getProduct().getProductId()}"><img src="${c.getProduct().getProductImage()}" alt="" style="width: 150px;"></a>
                                                    <div style="position: relative">
                                                        <a href="./product_details?productid=${c.getProduct().getProductId()}"><h5  style="margin-top: 60px;position: relative;">${c.getProduct().getProductName()}</h5></a>
                                                        <a data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                            <p id="update_hover">Phân loại hàng : ${c.getColor().getColorName()} - ${c.getSize().getSizeName()}<i class='fas fa-angle-down mx-2'></i></p>
                                                        </a>
                                                        <div class="collapse w-100" id="collapseExample" style="position: absolute; z-index: 2;background: beige;margin-left: 180px;margin-top:0px;;">
                                                            <form method="post" action="cartProcess?action=updateProduct&productid=${c.getProduct().getProductId()}&color=${c.getColor().getColorId()}&size=${c.getSize().getSizeId()}&quantity=${c.getQuantity()}"  class="p-3 pl-5"  id="form_hover">
                                                                <div class="row mb-3 mt-3">
                                                                    <label style="margin-top: 10px;" class="mr-3 h6 ">Color</label>
                                                                    <select name="colorid" class="w-75">
                                                                        <c:forEach items="${c.getProduct().getColors()}" var="color">
                                                                            <option value="${color.getColorId()}"> ${color.getColorName()}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                                <div class="row mb-4">
                                                                    <label style="margin-top: 10px;" class=" mr-3 h6">Size</label>
                                                                    <select name="sizeid" class="w-75 ml-2">
                                                                        <c:forEach items="${c.getProduct().getSizes()}" var="size">
                                                                            <option value="${size.getSizeId()}"> ${size.getSizeName()}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                                <div class="row">
                                                                    <input class="btn btn-outline-light text-dark border " type="submit" value="Xác Nhận">
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="shoping__cart__price">
                                                    <fmt:formatNumber type = "number" 
                                                                      maxFractionDigits = "3" value = "${c.getProduct().getUnitPrice()}" />&#8363;
                                                </td>
                                                <td class="shoping__cart__quantity">
                                                    <div class="quantity">
                                                        <div >
                                                            <a class="text-dark px-2 " href="./cartProcess?action=subtract&productid=${c.getProduct().getProductId()}&color=${c.getColor().getColorId()}&size=${c.getSize().getSizeId()}">-</a>
                                                            <input type="text" value="${c.getQuantity()}" class="w-25 text-center " style="border: 1px solid whitesmoke;">
                                                            <a class="text-dark px-2" href="./cartProcess?action=add&productid=${c.getProduct().getProductId()}&color=${c.getColor().getColorId()}&size=${c.getSize().getSizeId()}">+</a>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="shoping__cart__total">
                                                    <fmt:formatNumber type = "number" 
                                                                      maxFractionDigits = "3" value = "${c.getProduct().getUnitPrice() * c.getQuantity()}" />&#8363;
                                                </td>
                                                <td class="shoping__cart__item__close">
                                                    <a  href="./cartProcess?action=delete&productid=${c.getProduct().getProductId()}&color=${c.getColor().getColorId()}&size=${c.getSize().getSizeId()}"><i class="fa fa-trash-o text-dark" style="font-size: 18px;"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>



                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="shoping__cart__btns mt-5">
                                <a href="./shop" class="primary-btn cart-btn">CONTINUE SHOPPING</a>

                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="shoping__checkout">
                                <h5>Cart Total</h5>
                                <ul>
                                    <li>Subtotal <span><fmt:formatNumber type = "number" 
                                            maxFractionDigits = "3" value = "<%=total%>" />&#8363;</span></li>
                                    <li>Total <span><fmt:formatNumber type = "number" 
                                            maxFractionDigits = "3" value = "<%=total%>" />&#8363;</span></li>
                                </ul>
                                <c:if test="${sessionScope.userLogin == null}">
                                    <a href="./login?for=carts_order" class="primary-btn">PROCEED TO CHECKOUT</a>
                                </c:if>
                                <c:if test="${sessionScope.userLogin != null}">
                                    <a href="./order?for=carts_order" class="primary-btn">PROCEED TO CHECKOUT</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:if>

            </div>
        </section>
        <!-- Shoping Cart Section End -->
        <%@include file="include/Footer.jsp" %>

    </body>
</html>
