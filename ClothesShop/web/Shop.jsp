<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
                            <h2>Organi Shop</h2>
                            <div class="breadcrumb__option">
                                <a href="./index.html">Home</a>
                                <span>Shop</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Product Section Begin -->
        <section class="product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-5">
                        <div class="sidebar">
                            <form method="get">
                                <div class="sidebar__item">
                                    <h4>Tìm kiếm</h4>
                                    <input class="input-group-sm" name="search" type="text" placeholder="Tìm kiếm sản phẩm">
                                    <button class="btn btn-outline-dark btn-sm">Tìm kiếm</button>
                                </div>
                            </form>
                            <div class="sidebar__item">
                                <h4>Danh mục</h4>
                                <ul>
                                    <c:forEach items="${subcategories}" var="s">
                                        <li><a href="shop?subcategoyrid=${s.getSubCategoryId()}" ${productFilter.getSubcategoryId()==s.getSubCategoryId()?"style='color: yellowgreen;font-weight: bold;'":""} >${s.getSubCategoryName()}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                            <form method="get">
                                <div class="sidebar__item">
                                    <h4>Giá tiền</h4>
                                    <div class="price-range-wrap">
                                        <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                             data-min="${minprice}" data-max="${maxprice}">
                                            <div class="ui-slider-range ui-corner-all ui-widget-header">
                                            </div>
                                            <span tabindex="0"
                                                  class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                            <span tabindex="0"
                                                  class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                        </div>
                                        <div class="range-slider">
                                            <div class="price-input">
                                                <input type="text" id="minamount" name="minprice"style="max-width: 40%">
                                                <input type="text" id="maxamount" name="maxprice" style="max-width: 40%">
                                            </div>
                                        </div>
                                        <div class="range-slider">
                                            <button class="btn btn-outline-info">Tìm ngay</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="sidebar__item sidebar__item__color--option">
                                    <h4>Màu sắc</h4>
                                    <div class="col-6"> 
                                        <input type="radio" name="colorId" onchange="this.form.submit()" value="all">
                                        <label> Tất cả</label>
                                    </div>
                                    <c:forEach items="${colors}" var="c">
                                        <div class="col-6"> 
                                            <input type="radio" name="colorId" ${productFilter.getColorId()==c.getColorId()?"checked":""} onchange="this.form.submit()" value="${c.getColorId()}">
                                            <label> ${c.getColorName()}</label>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="sidebar__item">
                                    <h4>Kích cỡ</h4>
                                    <div class="sidebar__item__size">
                                        <label for="large" ${productFilter.getSizeId()==0?"style='background: yellowgreen;'":""} >
                                            <input type="radio" id="large" name="sizeId" ${productFilter.getSizeId()==0?"checked":""} onchange="this.form.submit()" value="all">
                                            Tất cả
                                        </label>
                                    </div>
                                    <c:forEach items="${sizes}" var="s">
                                        <div class="sidebar__item__size">
                                            <label for="${s.getSizeId()}" ${productFilter.getSizeId()==s.getSizeId()?"style='background: yellowgreen;'":""} >
                                                <input type="radio" id="${s.getSizeId()}"  name="sizeId" ${productFilter.getSizeId()==s.getSizeId()?"checked":""} onchange="this.form.submit()" value="${s.getSizeId()}">
                                                ${s.getSizeName()}
                                            </label>
                                        </div>
                                    </c:forEach>
                                </div>
                                <!--                            <div class="sidebar__item">
                                                                <div class="latest-product__text">
                                                                    <h4>Latest Products</h4>
                                                                    <div class="latest-product__slider owl-carousel">
                                                                        <div class="latest-prdouct__slider__item">
                                                                            <a href="#" class="latest-product__item">
                                                                                <div class="latest-product__item__pic">
                                                                                    <img src="img/latest-product/lp-1.jpg" alt="">
                                                                                </div>
                                                                                <div class="latest-product__item__text">
                                                                                    <h6>Crab Pool Security</h6>
                                                                                    <span>$30.00</span>
                                                                                </div>
                                                                            </a>
                                                                            <a href="#" class="latest-product__item">
                                                                                <div class="latest-product__item__pic">
                                                                                    <img src="img/latest-product/lp-2.jpg" alt="">
                                                                                </div>
                                                                                <div class="latest-product__item__text">
                                                                                    <h6>Crab Pool Security</h6>
                                                                                    <span>$30.00</span>
                                                                                </div>
                                                                            </a>
                                                                            <a href="#" class="latest-product__item">
                                                                                <div class="latest-product__item__pic">
                                                                                    <img src="img/latest-product/lp-3.jpg" alt="">
                                                                                </div>
                                                                                <div class="latest-product__item__text">
                                                                                    <h6>Crab Pool Security</h6>
                                                                                    <span>$30.00</span>
                                                                                </div>
                                                                            </a>
                                                                        </div>
                                                                        <div class="latest-prdouct__slider__item">
                                                                            <a href="#" class="latest-product__item">
                                                                                <div class="latest-product__item__pic">
                                                                                    <img src="img/latest-product/lp-1.jpg" alt="">
                                                                                </div>
                                                                                <div class="latest-product__item__text">
                                                                                    <h6>Crab Pool Security</h6>
                                                                                    <span>$30.00</span>
                                                                                </div>
                                                                            </a>
                                                                            <a href="#" class="latest-product__item">
                                                                                <div class="latest-product__item__pic">
                                                                                    <img src="img/latest-product/lp-2.jpg" alt="">
                                                                                </div>
                                                                                <div class="latest-product__item__text">
                                                                                    <h6>Crab Pool Security</h6>
                                                                                    <span>$30.00</span>
                                                                                </div>
                                                                            </a>
                                                                            <a href="#" class="latest-product__item">
                                                                                <div class="latest-product__item__pic">
                                                                                    <img src="img/latest-product/lp-3.jpg" alt="">
                                                                                </div>
                                                                                <div class="latest-product__item__text">
                                                                                    <h6>Crab Pool Security</h6>
                                                                                    <span>$30.00</span>
                                                                                </div>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>-->
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-7">
                        <div class="filter__item">
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="filter__sort">
                                        <span>Sắp xếp theo</span>
                                        <select name="sortBy" onchange="this.form.submit()">
                                            <option value="all">Mặc định</option>
                                            <option value="priceUp" ${productFilter.getSortBy() eq 'price' && productFilter.isSortMode() ?"selected":""}>Giá tăng dần</option>
                                            <option value="priceDown" ${productFilter.getSortBy() eq 'price' && !productFilter.isSortMode() ?"selected":""}>Giá giảm dần</option>
                                            <option value="latest" ${productFilter.getSortBy() eq 'date' && !productFilter.isSortMode() ?"selected":""}>Mới nhất</option>
                                            <option value="oldest" ${productFilter.getSortBy() eq 'date' && productFilter.isSortMode() ?"selected":""}>Cũ nhất</option>
                                        </select>
                                        <span>Hiển thị</span>
                                        <select name="view" onchange="this.form.submit()">
                                            <option value="18">Mặc định</option>
                                            <option value="36" ${productFilter.getRecordsPerPage() == 36 ?"selected":""}>36</option>
                                            <option value="54" ${productFilter.getRecordsPerPage() == 54 ?"selected":""}>54</option>
                                            <option value="73" ${productFilter.getRecordsPerPage() == 73?"selected":""}>73</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="filter__found">
                                        <h6><span>${productFilter.getTotalResult()}</span> sản phẩm tìm thấy</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach items="${products}" var="p">
                                <div class="col-lg-4 col-md-6 col-sm-6">
                                    <div class="product__item">
                                        <div class="product__item__pic set-bg" data-setbg="${p.getProductImage()}">
                                            <ul class="product__item__pic__hover">
                                                <li><a href="#"><i class="fa fa-heart"></i></a>
                                                </li>
                                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="product__item__text">
                                            <h6><a href="product_details?productid=${p.getProductId()}">${p.getProductName()}</a></h6>
                                            <h5><fmt:formatNumber type="number" value="${p.getUnitPrice()}"/>&dstrok;</h5>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        </form>
                        <div class="product__pagination" id="pagination">
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Section End -->
        <%@include file="include/Footer.jsp" %>
        <script>
            /*-----------------------
             Price Range Slider
             ------------------------ */
            var rangeSlider = $(".price-range"),
                    minamount = $("#minamount"),
                    maxamount = $("#maxamount"),
                    minPrice = rangeSlider.data('min'),
                    maxPrice = rangeSlider.data('max');
            rangeSlider.slider({
                range: true,
                min: minPrice,
                max: maxPrice,
                values: [minPrice, maxPrice],
                slide: function (event, ui) {
                    minamount.val(ui.values[0]);
                    maxamount.val(ui.values[1]);
                }
            });
            minamount.val(rangeSlider.slider("values", 0));
            maxamount.val(rangeSlider.slider("values", 1));
            function pagination(c, m) {
                var current = c,
                        last = m,
                        delta = 2,
                        left = current - delta,
                        right = current + delta + 1,
                        range = [],
                        rangeWithDots = [],
                        l;
                for (let i = 1; i <= last; i++) {
                    if (i === 1 || i === last || i >= left && i < right) {
                        range.push(i);
                    }
                }

                for (let i of range) {
                    if (l) {
                        if (i - l === 2) {
                            rangeWithDots.push(l + 1);
                        } else if (i - l !== 1) {
                            rangeWithDots.push('...');
                        }
                    }
                    rangeWithDots.push(i);
                    l = i;
                }
                return rangeWithDots;
            }
            var currentPage = ${productFilter.getCurrentPage()};
            console.log(currentPage);
            var totalPage = ${productFilter.getTotalPage()};
            var pagination = pagination(currentPage, totalPage);
            var paginationHtml = '';
            for (let i of pagination) {
                if (i == currentPage) {
                    paginationHtml += `<a href="#" style="background-color: #7fad39;color: white;">` + i + `</a>`;
                } else if (i == '...') {
                    paginationHtml += `<a href="#" style="pointer-events: none; cursor: default;">` + i + `</a>`;
                } else {
                    paginationHtml += `<a href="${linkParam}page=` + i + `">` + i + `</a>`;
                }
            }
            document.getElementById('pagination').innerHTML = paginationHtml;
        </script>
    </body>

</html>