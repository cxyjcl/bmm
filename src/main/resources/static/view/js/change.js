$(function () {
    $.ajax({
        url: "http://localhost:8080/user/get",
        type: "POST",
        dataType: "json",
        success: function (data) {
            if (data.code != "10000") {
                alert(data.msg);
            } else {
                loginName = data.data.loginName;
                infoId = data.data.id;
                $("#show_username").html(data.data.loginName);
                $("#show_email").html(data.data.email);
                var status = data.data.dataStatus;
                status = get_status(status);
                $("#show_status").html(status);
                $("#join_time").html(data.data.joinTime);
                $("#user_img").attr("src", data.data.userImg);
                $("#real_name").val(data.data.realName);
                $("#sex").val(data.data.sex);
                $("#birthday").val(data.data.birthday);
                $("#level_name").val(data.data.levelName);
                $("#discription").val(data.data.description);
                $("#username").val(data.data.loginName);
                $("#email").val(data.data.email);
            }
        }
    });
})
$("#info_save_btn").click(function () {
    var real_name = $("#real_name").val();
    var sex = $("#sex").val();
    var birthday = $("#birthday").val();
    var discription = $("#discription").val();
    var email = $("#email").val();
    $("#error_message").html("请稍等....");
    var _data = {
        'id': infoId,
        'realName': real_name,
        'sex': sex,
        'birthday': birthday,
        'discription': discription,
        'email': email,
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        },
        url: "http://localhost:8080/user/info/update",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(_data),
        success: function (data) {
            $("#error_message").html(data.msg);
        }
    });
});
$("#login_save_btn").click(function () {
    var wordValue = $("#password").val();
    var rePassword = $("#re_password").val();
    $("#login_error_message").html("请稍等....");
    var _data = {
        'password': wordValue
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        },
        url: "http://localhost:8080/user/update",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(_data),
        success: function (data) {
            $("#login_error_message").html(data.msg);
        }
    });
});