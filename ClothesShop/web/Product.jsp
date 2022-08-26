<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="include/Head.jsp" %>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="include/Header.jsp" %>
        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg" data-setbg="img/banner/pic2.JPG">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2>Shopping</h2>
                            <div class="breadcrumb__option">
                                <a href="./home">Home</a>
                                <span>Product Details</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->
        <!-- Product Details Section Begin -->
        <section class="product-details spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="product__details__pic">
                            <div class="product__details__pic__item">
                                <img class="product__details__pic__item--large"
                                     src="${product.getProductImage()}" alt="">
                            </div>
                            <div class="product__details__pic__slider owl-carousel">
                                <c:forEach items="${product.getImages()}" var="i">
                                    <img data-imgbigurl="${i.getUrl()}"
                                         src="${i.getUrl()}" alt="">
                                </c:forEach>

                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-md-6">
                        <form method="post">
                            <div class="product__details__text">
                                <h3>${product.getProductName()}</h3>
                                <div class="product__details__rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-half-o"></i>
                                    <span>(18 reviews)</span>
                                </div>
                                <div class="product__details__price">
                                    <fmt:formatNumber type = "number" 
                                                      maxFractionDigits = "3" value = "${product.getUnitPrice()}" />&#8363;</p>
                                </div>
                                <div class=" w-50 mb-4">
                                    <div class="quantity d-flex justify-content-between">
                                        <h5 class="mt-2">
                                            Color
                                        </h5>
                                        <div style="width: 140px;">
                                            <select name="color" class="w-100">
                                                <c:forEach items="${product.getColors()}" var="color">
                                                    <option value="${color.getColorId()}">${color.getColorName()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class=" w-50 mb-4">
                                    <div class="quantity d-flex justify-content-between">
                                        <h5 class="mt-2">
                                            Size
                                        </h5>
                                        <div style="width: 140px;">
                                            <select name="size" class="w-100">
                                                <c:forEach items="${product.getSizes()}" var="size">
                                                    <option value="${size.getSizeId()}">${size.getSizeName()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="product__details__quantity w-50 mb-4">
                                    <div class="quantity d-flex justify-content-between">
                                        <h5 class="mt-3">
                                            Quantity
                                        </h5>
                                        <div class="pro-qty">
                                            <input type="text" value="1" name="quantity">
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="d-flex ">
                                    <div style="width: 40%;text-align: center;" >
                                        <input type="submit" value="Add to cart" name="action" data-bs-toggles="modal" data-db-targets="#myModal"style="background-color: #ee4d2d;border: 1px solid #ee4d2d;" class="primary-btn w-100">

                                    </div>
                                    <div style="width: 20%;" class="ml-4" >
                                        <input type="submit" value="Order now"  name="action" style="background-color: #ee4d2d;border: 1px solid #ee4d2d;" class="primary-btn">
                                    </div>
                                </div>

                                <ul>
                                    <li><b>Availability</b> <span>In Stock</span></li>
                                    <li><b>Shipping</b> <span>01 day shipping. <samp>Free pickup today</samp></span></li>
                                    <li><b>Weight</b> <span>0.5 kg</span></li>
                                    <li><b>Share on</b>
                                        <div class="share">
                                            <a href="#"><i class="fa fa-facebook"></i></a>
                                            <a href="#"><i class="fa fa-twitter"></i></a>
                                            <a href="#"><i class="fa fa-instagram"></i></a>
                                            <a href="#"><i class="fa fa-pinterest"></i></a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </form>
                    </div>
                    </form>
                    <div class="col-lg-12">
                        <div class="product__details__tab">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                       aria-selected="true">Description</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                                       aria-selected="false">Information</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                       aria-selected="false">Reviews <span>(1)</span></a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    <div class="product__details__tab__desc">
                                        <h6>Products Infomation</h6>
                                        <p>${product.getProductDescription()}</p>

                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-2" role="tabpanel">
                                    <div class="product__details__tab__desc">
                                        <h6>Products Infomation</h6>

                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-3" role="tabpanel">
                                    <div class="product__details__tab__desc">
                                        <h6>Products Infomation</h6>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Details Section End -->

        <!-- Related Product Section Begin -->
        <section class="related-product">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title related__product__title">
                            <h2>Related Product</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${relatedProducts.subList(6,10)}" var="re">
                        <div class=" col-lg-3 col-md-4 col-sm-6 slider__item ">
                            <div class="product__item ">
                                <div class="product__item__pic set-bg" data-setbg="${re.getProductImage()}">
                                    <ul class="product__item__pic__hover">
                                        <li><a href=""><i class="fa fa-retweet"></i></a></li>
                                        <li><a href="./product_details?productid=${re.getProductId()}"><i class="fa fa-search"></i></a></li>
                                    </ul>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="./product_details?productid=${re.getProductId()}">${re.getProductName()}</a></h6>
                                    <h5><fmt:formatNumber type = "number" 
                                                      maxFractionDigits = "3" value = "${re.getUnitPrice()}" />&#8363;</h5>
                                </div>
                            </div>
                        </div>


                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Related Product Section End -->
        <%@include file="include/Footer.jsp" %>
    </body>
</html>
