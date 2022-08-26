<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="include/Head.jsp" %>
        <title>JSP Page</title>
    </head>
    <body
        <%@include file="include/HeaderSectionBegin.jsp" %>
        <!-- Hero Section Begin -->
        <section class="hero">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 ">
                        <div class="hero__categories">
                            <div class="hero__categories__all">
                                <i class="fa fa-bars"></i>
                                <span>All subcategories</span>
                            </div>
                            <ul>
                                <c:forEach items="${subcategories}" var="sub">
                                    <li><a href="./shop?subcategoryid=${sub.getSubCategoryId()}">${sub.getSubCategoryName()}</a></li>
                                    </c:forEach>

                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="#">
                                    <div class="hero__search__categories">
                                        All Categories
                                        <span class="arrow_carrot-down"></span>
                                    </div>
                                    <input type="text" placeholder="What do yo u need?">
                                    <button type="submit" class="site-btn">SEARCH</button>
                                </form>
                            </div>
                            <div class="hero__search__phone">
                                <div class="hero__search__phone__icon">
                                    <i class="fa fa-phone"></i>
                                </div>
                                <div class="hero__search__phone__text">
                                    <h5>+55-928-414</h5>
                                    <span>support 24/7 time</span>
                                </div>
                            </div>
                        </div>
                        <div class="hero__item set-bg" data-setbg="img/banner/pic1.JPG">
                            <div class="hero__text">
                                <span>Fashion & Beauty</span>
                                <h2>Clothes <br />trendy & diverse</h2>
                                <p>Free Pickup and Delivery Available</p>
                                <a href="" class="primary-btn">SHOP NOW</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->
        <!-- Categories Section Begin -->
        <section class="categories">
            <div class="container">
                <div class="row">
                    <div class="categories__slider owl-carousel">
                        <c:forEach items="${subcategories}" var="sub">
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="${sub.getDescription()}">
                                    <h5><a href="./shop?subcategoyrid=${sub.getSubCategoryId()}">${sub.getSubCategoryName()}</a></h5>
                                </div>
                            </div>
                        </c:forEach>


                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <!-- Featured Section Begin -->
        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Featured Product</h2>
                        </div>
                        <div class="featured__controls">
                            <ul>
                                <li class="active" data-filter="*">All</li>
                                    <c:forEach items="${categories}" var="c">
                                    <li data-filter=".${c.getCategoryName()}">${c.getCategoryName()}</li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row featured__filter">
                    <div class=" row col-md-12 mix Man">
                        <c:forEach items="${Man.subList(0,8)}" var="m">
                            <div class="featured__item col-md-3">
                                <div class="featured__item__pic set-bg" data-setbg="${m.getProductImage()}"  >
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="./product_details?productid=${m.getProductId()}"><i class="fa fa-search"></i></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="./product?productid=${m.getProductId()}">${m.getProductName()}</a></h6>
                                    <h5>
                                        <fmt:formatNumber type = "number" 
                                                          maxFractionDigits = "3" value = "${m.getUnitPrice()}" />&#8363;</h5>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <div class=" row col-md-12 mix Women">
                        <c:forEach items="${Women.subList(0,8)}" var="w">
                            <div class="featured__item col-md-3">
                                <div class="featured__item__pic set-bg" data-setbg="${w.getProductImage()}" style="width: 80%;">
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="./product_details?productid=${w.getProductId()}"><i class="fa fa-search"></i></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="./product?productid=${w.getProductId()}">${w.getProductName()}</a></h6>
                                    <h5> <fmt:formatNumber type = "number" 
                                                      maxFractionDigits = "3" value = "${w.getUnitPrice()}" />&#8363;</h5>
                                </div>
                            </div>
                        </c:forEach>
                    </div>



                </div>
            </div>
        </section>
        <!-- Featured Section End -->

        <!-- Banner Begin -->
        <div class="banner">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="banner__pic">
                            <img src="img/banner/pic2.JPG" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="banner__pic">
                            <img src="img/banner/pic5.JPG" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Banner End -->

        <!-- Latest Product Section Begin -->
        <section class="latest-product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6">
                        <div class="latest-product__text">
                            <h4>Latest Products</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${Women.subList(18,21)}" var="wo">
                                        <a href="./product_details?productid=${wo.getProductId()}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${wo.getProductImage()}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${wo.getProductName()}</h6>
                                                <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${wo.getUnitPrice()}" />&#8363;</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${Man.subList(14,17)}" var="ma">
                                        <a href="./product_details?productid=${ma.getProductId()}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${ma.getProductImage()}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${ma.getProductName()}</h6>
                                                <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${ma.getUnitPrice()}" />&#8363;</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="latest-product__text">
                            <h4>Top Rated Products</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${Women.subList(50,53)}" var="wo">
                                        <a href="./product_details?productid=${wo.getProductId()}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${wo.getProductImage()}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${wo.getProductName()}</h6>
                                                <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${wo.getUnitPrice()}" />&#8363;</span>
                                            </div>
                                        </a>
                                    </c:forEach>


                                </div>
                                <div class="latest-prdouct__slider__item">
                                     <c:forEach items="${Man.subList(50,53)}" var="ma">
                                        <a href="./product_details?productid=${ma.getProductId()}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${ma.getProductImage()}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${ma.getProductName()}</h6>
                                                <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${ma.getUnitPrice()}" />&#8363;</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="latest-product__text">
                            <h4>Review Products</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                    <a href="./product_details?productid=${Man.get(56).getProductId()}" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="${Man.get(56).getProductImage()}" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6>${Man.get(56).getProductName()}</h6>
                                            <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${Man.get(56).getUnitPrice()}" />&#8363;</span>
                                        </div>
                                    </a>
                                    <a href="./product_details?productid=${Man.get(24).getProductId()}" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="${Man.get(24).getProductImage()}" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6>${Man.get(24).getProductName()}</h6>
                                            <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${Man.get(24).getUnitPrice()}" />&#8363;</span>
                                        </div>
                                    </a>
                                    <a href="./product_details?productid=${Man.get(33).getProductId()}" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="${Man.get(33).getProductImage()}" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6>${Man.get(33).getProductName()}</h6>
                                            <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${Man.get(33).getUnitPrice()}" />&#8363;</span>
                                        </div>
                                    </a>
                                </div>
                                <div class="latest-prdouct__slider__item">
                                     <a href="./product_details?productid=${Women.get(56).getProductId()}" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="${Women.get(56).getProductImage()}" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6>${Women.get(56).getProductName()}</h6>
                                            <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${Women.get(56).getUnitPrice()}" />&#8363;</span>
                                        </div>
                                    </a>
                                     <a href="./product_details?productid=${Women.get(22).getProductId()}" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="${Women.get(22).getProductImage()}" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6>${Women.get(22).getProductName()}</h6>
                                            <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${Women.get(22).getUnitPrice()}" />&#8363;</span>
                                        </div>
                                    </a>
                                     <a href="./product_details?productid=${Women.get(21).getProductId()}" class="latest-product__item">
                                        <div class="latest-product__item__pic">
                                            <img src="${Women.get(21).getProductImage()}" alt="">
                                        </div>
                                        <div class="latest-product__item__text">
                                            <h6>${Women.get(21).getProductName()}</h6>
                                            <span><fmt:formatNumber type = "number" 
                                                                  maxFractionDigits = "3" value = "${Women.get(21).getUnitPrice()}" />&#8363;</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Latest Product Section End -->
        <%@include file="include/Footer.jsp" %>
    </body>
</html>
