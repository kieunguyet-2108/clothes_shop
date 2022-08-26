<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html class="no-js" lang="en">
    <head>
        <%@include file="include/head.jsp" %>
        <!-- CSS -->
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
        <!-- Default theme -->
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
        <!-- Semantic UI theme -->
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
        <!-- Bootstrap theme -->
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
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
                                            <h5>Quản lý sản phẩm</h5>
                                            <span>Thêm/ sửa/ xóa sản phẩm tại đây</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header"><h3>Sản phẩm hiện có</h3></div>
                                    <button class="btn btn-primary" onclick="addProduct()">Thêm sản phẩm</button>
                                    <div class="card-body">
                                        <table id="data_table" class="table">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th class="nosort">Hình ảnh</th>
                                                    <th>Tên sản phẩm</th>
                                                    <th>Giá tiền</th>
                                                    <th>Ngày tạo</th>
                                                    <th class="nosort">&nbsp;</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${products}" var="p">
                                                    <tr>
                                                        <td>${p.getProductId()}</td>
                                                        <td><img style="width: 100px;height: 100px" src="${p.getProductImage()}" class="table-user-thumb" alt=""></td>
                                                        <td>${p.getProductName()}</td>
                                                        <td><fmt:formatNumber value="${p.getUnitPrice()}" type="number"/></td>
                                                        <td>${p.getCreatedTime()}</td>
                                                        <td>
                                                            <div class="table-actions">
                                                                <a data-id="${p.getProductId()}" onclick="viewProduct(this)"><i class="ik ik-eye"></i></a>
                                                                <a data-id="${p.getProductId()}" onclick="editProduct(this)"><i class="ik ik-edit-2"></i></a>
                                                                <a data-id="${p.getProductId()}" onclick="deleteProduct(this)"><i class="ik ik-trash-2"></i></a>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
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
        <div class="modal fade" id="viewProductModal" tabindex="-1" role="dialog" aria-labelledby="viewProductModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="viewProductModalLabel">Chi tiết sản phẩm</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-6">
                                <img src="" class="img-fluid" alt="" id="productImage">
                                <div id="list-image" class="row"> </div>
                            </div>
                            <div class="col-md-6">
                                <h5>Tên sản phẩm:</h5>
                                <p id="productName"></p>
                                <h5>Giá tiền:</h5>
                                <p id="unitPrice"></p>
                                <h5>Mô tả:</h5>
                                <p id="description"></p>
                                <h5>Danh mục:</h5>
                                <p id="categoryName"></p>
                                <h5>Options:</h5>
                                <p id="options"></p>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="editProductModal" tabindex="-1" role="dialog" aria-labelledby="editProductModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editProductModalLabel">Sửa sản phẩm</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="editProductForm" method="POST">
                            <div class="form-group">
                                <label for="productName">Tên sản phẩm:</label>
                                <input type="text" class="form-control" id="productName" name="productName">
                            </div>
                             <div class="form-group">
                                <label for="productImage">Ảnh sản phẩm:</label>
                                <input type="text" class="form-control" id="productImage" name="productImage">
                            </div>
                            <div class="form-group">
                                <label for="unitPrice">Giá tiền:</label>
                                <input type="number" class="form-control" id="unitPrice" name="unitPrice">
                            </div>
                            <div class="form-group">
                                <label for="description">Mô tả:</label>
                                <textarea class="form-control" id="description" name="description"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="categoryId">Danh mục:</label>
                                <select
                                    class="form-control" id="categoryId" name="categoryId">
                                    <option value="">Chọn danh mục</option>
                                    <c:forEach items="${subcategories}" var="s">
                                        <option value="${s.getSubCategoryId()}">${s.getSubCategoryName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="options">Options:</label>
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Màu sắc</th>
                                            <th>Kích thước</th>
                                            <th>Số lượng</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody id="list-options">
                                    </tbody>
                                    <th>
                                        <select class="form-control" id="color" name="color">
                                            <option value="">Chọn màu sắc</option>
                                            <c:forEach items="${colors}" var="c">
                                                <option value="${c.getColorId()}" data-name="${c.getColorName()}">${c.getColorName()}</option>
                                            </c:forEach>
                                        </select>
                                    </th>
                                    <th><select class="form-control" id="size" name="size">
                                            <option value="">Chọn kích thước</option>
                                            <c:forEach items="${sizes}" var="s">
                                                <option value="${s.getSizeId()}" data-name="${s.getSizeName()}">${s.getSizeName()}</option>
                                            </c:forEach>
                                        </select>
                                    </th>
                                    <th><input type="number" class="form-control" id="quantity" name="quantity" value="1"></th>
                                    <th><button type="button" class="btn btn-primary" onclick="addOption()">Thêm</button></th>
                                </table>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="plugins/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
        <script src="plugins/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>
        <script src="js/tables.js"></script>
        <script src="dist/js/theme.min.js"></script>
        <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
        <script>
        $(document).ready(function () {
            viewProduct = function (e) {
                var id = $(e).data('id');
                $.ajax({
                    url: 'api',
                    type: 'get',
                    data: {
                        action: 'view',
                        id: id
                    },
                    success: function (data) {
                        //   view data on modal 
                        var list_img = '';
                        $.each(data.images, function (index, value) {
                            list_img += '<img src="' + value.url + '" class="col-4 m-3" style="width:50px;height=50px;" alt="">';
                        });
                        var list_option = '';
                       
                            $.each(data.productOptions, function (index, value) {
                                list_option += '<p> Màu: ' + value.colorName + ' Size: ' + value.sizeName + ' Số lượng: ' + value.quantity + '</p>';
                            });
                        
                        $("#categoryName").html(data.subcategory.SubCategoryName);
                        $("#options").html(list_option);
                        $('#list-image').html(list_img);
                        $('#productImage').attr('src', data.productImage);
                        $('#productName').text(data.productName);
                        $('#unitPrice').text(data.unitPrice);
                        $('#description').text(data.productDescription);
                        $('#viewProductModal').modal('show');
                    }
                });
            }
            deleteProduct = function (e) {
                var id = $(e).data('id');
                alertify.confirm('Bạn có chắc chắn muốn xóa sản phẩm này?', function (e) {
                    if (e) {
                        $.ajax({
                            url: 'api',
                            type: 'get',
                            data: {
                                action: 'delete',
                                id: id
                            },
                            success: function (data) {
                                if (data == 'success') {
                                    alertify.success('Xóa thành công');
                                    location.reload();
                                } else {
                                    alertify.error('Xóa thất bại');
                                }
                            }
                        });
                    } else {
                        alertify.error('Hủy thao tác');
                    }
                });
            }
            editProduct = function (e) {
                var id = $(e).data('id');
                $.ajax({
                    url: 'api',
                    type: 'get',
                    data: {
                        action: 'view',
                        id: id
                    },
                    success: function (data) {
                        // add data to form editProductForm
                        $('#editProductForm').attr('action', 'api?action=update&id=' + id);
                        $('#editProductForm #productName').val(data.productName);
                        $('#editProductForm #unitPrice').val(data.unitPrice);
                        $('#editProductForm #description').val(data.productDescription);
                        $('#editProductForm #categoryId').val(data.subcategory.SubCategoryId);
                        $('#editProductForm #quantity').val(data.quantity);
                        var list_option = '';
                        $.each(data.productOptions, function (index, value) {
                            list_option += '<tr>';
                            list_option += '<td><input type="text" readonly class="form-control" name="colorId" value="' + value.colorId + '">'+value.colorName+'</td>';
                            list_option += '<td><input type="text" readonly class="form-control" name="sizeId" value="' + value.sizeId + '">'+value.sizeName+'</td>';
                            list_option += '<td> <input type="number" class="form-control" name="quantity" value="' + value.quantity + '"></td>';
                            list_option += '<td><button type="button" class="btn btn-danger" onclick="deleteOption(this)" data-id="' + value.productOptionId + '">Xóa</button></td>';
                            list_option += '</tr>';
                        });
                        $('#list-options').html(list_option);
                        $('#editProductForm #productImage').val(data.productImage);
                        $('#editProductModal #editProductForm').attr('action', 'api?action=update&id=' + id);
                        $('#editProductModal').modal('show');
                        // confirm save change
                        $('#editProductModal #editProductForm').submit(function (e1) {
                            e1.preventDefault();
                            alertify.confirm('Bạn có chắc chắn muốn cập nhật sản phẩm này?', function (e) {
                                if (e) {
                                    alertify.success('Cập nhật thành công');
                                    e1.target.submit();
                                    $('#editProductModal #editProductForm').submit();
                                } else {
                                    alertify.error('Hủy thao tác');
                                }
                            });
                        });
                    }
                });
            }
            addProduct = function () {
                $('#editProductModal #editProductForm').attr('action', 'api?action=add');
                $('#editProductModalLabel').text('Thêm sản phẩm');
                        $('#editProductModal').modal('show');
                // confirm save change
               $('#editProductModal #editProductForm').submit(function (e1) {
                    e1.preventDefault();
                    alertify.confirm('Bạn có chắc chắn muốn thêm sản phẩm này?', function (e) {
                        if (e) {
                            alertify.success('Thêm thành công');
                            e1.target.submit();
                            $('#addProductModal #addProductForm').submit();
                        } else {
                            alertify.error('Hủy thao tác');
                        }
                    });
                });
            }
            // delete option html
            deleteOption = function (e) {
                var id = $(e).data('id');
                $(e).parent().parent().remove();
            }
            // add option html
            // get value above add-option and add to html
            addOption = function () {
                var colorId = $('#color').val();
                var colorName = $('#color option:selected').text();
                var sizeId = $('#size').val();
                var sizeName = $('#size option:selected').text();
                var quantity = $('#quantity').val();
                // id increment
                var id = $('#list-options tr').length + 1;
                var list_option = '';
                list_option += '<tr>';
                list_option += '<td> <input type="text"  readonly class="form-control" name="colorId" value="' + colorId + '">'+colorName+'</td>';
                list_option += '<td> <input type="text"  readonly class="form-control" name="sizeId" value="' + sizeId + '">'+sizeName+'</td>';
                list_option += '<td> <input type="number" class="form-control" name="quantity" value="' + quantity + '"></td>';
                list_option += '<td><button type="button" class="btn btn-danger" onclick="deleteOption(this)" data-id="' + id + '">Xóa</button></td>';
                list_option += '</tr>';
                $('#list-options').append(list_option);
                $('#colorName').val('');
                $('#sizeName').val('');
                $('#quantity').val('');
            }
        });
        </script>
    </body>
</html>
