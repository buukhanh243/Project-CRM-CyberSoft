<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <link rel="stylesheet" href="./css/custom.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!-- Preloader -->
<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top m-b-0">
        <div class="navbar-header">
            <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse"
               data-target=".navbar-collapse">
                <i class="fa fa-bars"></i>
            </a>
            <div class="top-left-part">
                <a class="logo" href="index.jsp">
                    <b>
                        <img src="plugins/images/pixeladmin-logo.png" alt="home"/>
                    </b>
                    <span class="hidden-xs">
                                <img src="plugins/images/pixeladmin-text.png" alt="home"/>
                            </span>
                </a>
            </div>
            <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                <li>
                    <form role="search" class="app-search hidden-xs">
                        <input type="text" placeholder="Search..." class="form-control">
                        <a href="">
                            <i class="fa fa-search"></i>
                        </a>
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-top-links navbar-right pull-right">
                <li>
                    <div class="dropdown">
                        <a class="profile-pic dropdown-toggle" data-toggle="dropdown" href="#">
                            <img src="plugins/images/users/varun.jpg" alt="user-img" width="36" class="img-circle"/>
                            <b class="hidden-xs">Cybersoft</b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="profile.jsp">Thông tin cá nhân</a></li>
                            <li><a href="#">Thống kê công việc</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Đăng xuất</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
        <!-- /.navbar-header -->
        <!-- /.navbar-top-links -->
        <!-- /.navbar-static-side -->
    </nav>
    <!-- Left navbar-header -->
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse slimscrollsidebar">
            <ul class="nav" id="side-menu">
                <li style="padding: 10px 0 0;">
                    <a href="index.jsp" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                                                aria-hidden="true"></i><span
                            class="hide-menu">Dashboard</span></a>
                </li>
                <li>
                    <a href='<c:url value="/user"></c:url>' class="waves-effect"><i class="fa fa-user fa-fw"
                                                                                    aria-hidden="true"></i><span
                            class="hide-menu">Thành viên</span></a>
                </li>
                <li>
                    <a href="role-table.jsp" class="waves-effect"><i class="fa fa-modx fa-fw"
                                                                     aria-hidden="true"></i><span class="hide-menu">Quyền</span></a>
                </li>
                <li>
                    <a href="groupwork.jsp" class="waves-effect"><i class="fa fa-table fa-fw"
                                                                    aria-hidden="true"></i><span
                            class="hide-menu">Dự án</span></a>
                </li>
                <li>
                    <a href="task.jsp" class="waves-effect"><i class="fa fa-table fa-fw"
                                                               aria-hidden="true"></i><span
                            class="hide-menu">Công việc</span></a>
                </li>
                <li>
                    <a href="blank.jsp" class="waves-effect"><i class="fa fa-columns fa-fw"
                                                                aria-hidden="true"></i><span class="hide-menu">Blank Page</span></a>
                </li>
                <li>
                    <a href="404.jsp" class="waves-effect"><i class="fa fa-info-circle fa-fw"
                                                              aria-hidden="true"></i><span
                            class="hide-menu">Error 404</span></a>
                </li>
            </ul>
        </div>
    </div>
    <!-- Left navbar-header end -->
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Danh sách thành viên</h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                    <a href='<c:url value="/user-add"></c:url>' class="btn btn-sm btn-success">Thêm mới</a>
                </div>
                <%--Modal--%>
                <form class="form-horizontal form-material">
                    <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
                         aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content" style="top: 50px">
                                <div class="modal-header">
                                    <h4 class="modal-title" style="color: rgba(0,0,0,.5);
                                font-weight: 600;
                                margin-top: 6px;">Cập nhập Quyền</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="container-fluid">

                                        <div class="form-group">
                                            <label class="col-md-12">Full Name</label>
                                            <div class="col-md-12">
                                                <input type="text" id="fullname"
                                                       class="form-control form-control-line" name="fullname"></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="email" class="col-md-12">Email</label>
                                            <div class="col-md-12">
                                                <input type="email"
                                                       class="form-control form-control-line" name="email"
                                                       id="email"></div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-12">Password</label>
                                            <div class="col-md-12">
                                                <input type="password" id="password" name="password"
                                                       class="form-control form-control-line myInput">
                                                <div class="form-check form-switch">
                                                    <input class="form-check-input" id="showPass" type="checkbox"
                                                           id="flexSwitchCheckDefault" onclick="myFunction()">
                                                    <label class="form-check-label" for="flexSwitchCheckDefault">Show
                                                        Password</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-12">Avatar</label>
                                            <div class="col-md-12">
                                                <input type="text" placeholder="avatar" id="avatar"
                                                       class="form-control form-control-line" name="avatar"></div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-12">Role</label>
                                            <div class="col-sm-12">
                                                <select class="form-control form-control-line" id="roleId"
                                                        name="roleId">
                                                    <option value="1">Quản lý trang</option>
                                                    <option value="2">Quản lý</option>
                                                    <option value="3">Nhân viên</option>
                                                </select>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                    </button>
                                    <button type="button" class="btn btn-primary btn-save-update">Save</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </form>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="white-box">
                        <div class="table-responsive">
                            <table class="table" id="example">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                    <th>Role</th>
                                    <th>#</th>
                                </tr>
                                </thead>

                                <tbody id="user-body">
                                <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td id="user_id">${user.getId()}</td>
                                        <td id="user_firtName">${user.getFirstName()}</td>
                                        <td id="user_lastName">${user.getLastName()}</td>
                                        <td id="user_fullName">${user.getFullName()}</td>
                                        <td id="user_role">${user.getRole()}</td>
                                        <td>
                                            <a href="#" data-toggle="modal"
                                               data-target="#modelId" class="btn btn-sm btn-primary btn-update-user"
                                               roleId="${user.getId()}">Sửa</a>

                                            <a href="#" class="btn btn-sm btn-danger btn-delete-user" roleId="${user.getId()}">Xóa</a>
                                            <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
        <footer class="footer text-center"> 2018 &copy; myclass.com</footer>
        <div id="toastrSuccess" value="${success}"></div>
        <div id="toastError" value="${error}"></div>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<!-- jQuery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"
        integrity="sha512-3P8rXCuGJdNZOnUx/03c1jOTnMn3rP63nBip5gOP2qmUh5YAdVAvFZ1E+QLZZbC1rtMrQb+mah3AfYW11RUrWA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
<!--slimscroll JavaScript -->
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.dataTables.js"></script>
<!--Wave Effects -->
<script src="js/waves.js"></script>
<script src="js/user.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/custom.min.js"></script>
<script>

    toastr.options = {
        "closeButton": true,
        "debug": false,
        "newestOnTop": false,
        "progressBar": true,
        "positionClass": "toast-top-right",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "5000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }

    function toast(type, msg) {
        toastr[type](msg)
    }

    var successValue = $('#toastrSuccess').attr('value');
    var errorValue = $('#toastError').attr('value');

    function showToastr() {

        if (successValue) {
            toast("success", successValue);
        } else if (errorValue) {
            toast("error", errorValue);
        }

    }

    showToastr();

    $(document).ready(function () {
        $('#example').DataTable();
    });

</script>
</body>

</html>