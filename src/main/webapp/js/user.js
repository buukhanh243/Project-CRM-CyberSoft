//$ => jquery
function myFunction() {
    var x = document.querySelector(".myInput");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

$(document).ready(function () {
    //$("selector") :
    // id : # (Dấu thăng)
    // class :  . (Dấu chấm)
    //find("selector")
    //this: đại diện cho thẻ đang xảy ra sự kiện click
    //parent(): Đi 1 cấp ra thằng cha của selector gọi
    //closest(): Đi ra n cấp chỉ định ( đi ra tổ tiên )
    //String template : `` để gọi code ${code}
    $(".btn-delete-user").click(function () {
        var idDelete = $(this).attr("roleId");
        var This = $(this);

        $.ajax({
            method: "delete",
            url: "http://localhost:8081/crm/api/user?idDelete=" + idDelete,
        }).done(function (data) {
            if (data.success) {
                //Xoá thành công
                This.closest("tr").remove();
            } else {
                //Xoá thất bại
                alert("Xoá thất bại");
            }
        });
    });

    $(".btn-update-user").click(function () {
        //Thêm html vào selector chỉ định
        // var html = `<tr>
        //        <td id="role_id" >8</td>
        //        <td>Role_Cứng</td>
        //        <td>Role ABCCSCASc</td>
        //        <td>
        //            <a href="#" class="btn btn-sm btn-primary btn-update">Sửa</a>
        //            <a href="#" roleId="8" class="btn btn-sm btn-danger btn-delete">Xóa</a>
        //        </td>
        //    </tr>`
        //
        // $("#role-body").append(html)

        var idUpdate = $(this).attr("roleId");

        var ThisUpdate = $(this);
        $.ajax({
            method: "get",
            url: "http://localhost:8081/crm/api/user?idUpdate=" + idUpdate,
            // data: { name: "John", location: "Boston" } => Gửi tham số dạng post
        }).done(function (data) {
            if (data.success) {
                var userJson = data.description[0];
                $("#fullname").val(`${userJson.fullName.toString()}`);
                $("#email").val(`${userJson.email.toString()}`);
                $("#password").val(`${userJson.password.toString()}`);
                $("#avatar").val(`${userJson.avatar.toString()}`);
                $("#roleId").val(`${userJson.roleId.toString()}`);
                console.log("ok: " + JSON.stringify(userJson));

                $(".btn-save-update").click(function () {
                    var ThisSaveUpdate = $(this);

                    var fullName = $("#fullname").val();
                    var email = $("#email").val();
                    var password = $("#password").val();
                    var avatar = $("#avatar").val();
                    var roleId = $("#roleId").val();

                    $.ajax({
                        method: "put",
                        url: `http://localhost:8081/crm/api/user?id=${idUpdate}&email=${email}&password=${password}&avatar=${avatar}&fullname=${fullName}&roleid=${roleId}`,
                    }).done(function (data) {
                        if (data.success) {

                            function showRoleDetail(roleDetal) {
                                if (roleDetal === '1') {
                                    return "Quản lý trang";
                                } if (roleDetal === '2'){
                                    return "Quản lý";
                                } if (roleDetal === '3'){
                                    return "Quản lý";
                                }
                            }
                            var Role = showRoleDetail(roleId)
                            console.log(Role)
                            var html = `
                                        <td id="user_id">${idUpdate}</td>
                                        <td id="user_firtName">${fullName
                                .split(" ")
                                .slice(0, -1)
                                .join(" ")}</td>
                                        <td id="user_lastName">${fullName
                                .split(" ")
                                .slice(-1)
                                .join(" ")}</td>
                                        <td id="user_fullName">${fullName}</td>
                                        <td id="user_role">${Role}</td>
                                        <td>
                                            <a href="#" data-toggle="modal"
                                                data-target="#modelId" class="btn btn-sm btn-primary btn-update-user"
                                                roleId="${idUpdate}">Sửa</a>
                                            <a href="#" class="btn btn-sm btn-danger btn-delete-user" roleId="${idUpdate}">Xóa</a>
                                            <a href="user-details.jsp" class="btn btn-sm btn-info">Xem</a>
                                        </td>
                                    `;
                            //update thành công
                            ThisUpdate.closest("tr").html(html);
                            toast("success", "Cập nhập thành công");
                        } else {
                            //Xoá thất bại
                            console.log(ThisUpdate);
                        }
                    });
                });
            } else {
                console.log("that bai");
            }
        });
    });
});
