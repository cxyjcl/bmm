$("#login_save_btn").click(function () {
    var wordValue = $("#password").val();
    var realName = $("#real_name").val();
    var rePassword = $("#re_password").val();
    var loginName = $("#username").val();
    $("#error_message").html("请稍等....");
    if (realName == "") {
        $("#error_message").html("真实名不得为空");
    }
    else if (wordValue == "") {
        $("#error_message").html("密码不得为空");
    }
    else if (rePassword == "") {
        $("#error_message").html("密码不得为空");
    }
    else if (rePassword != wordValue) {
        $("#error_message").html("两次密码输入不正确");
    }
    else{
        var _data = {
            'loginName': loginName,
            'password': wordValue,
            'realName': realName
        };
        console.log(_data)
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': "*"
            },
            url: "http://119.23.229.247:8080/user/update",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(_data),
            success: function (data) {
                $("#error_message").html(data.msg);
            }
        });
    }
});