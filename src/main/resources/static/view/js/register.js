$("#verify_img").click(function () {
    $("#verify_img").attr("src", "http://localhost:8080/code/verify?time=" + new Date().getTime());
})
$("#submit_btn").click(function () {
    var userValue = $("#login_name").val();
    var realValue = $("#real_name").val();
    var wordValue = $("#password").val();
    var rePassword = $("#re_password").val();
    var codeValue = $("#code").val();
    var strcheck = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    if (userValue == "") {
        $("#error_message").html("用户名不得为空");
    }
    else if (realValue == "") {
        $("#error_message").html("真实名不得为空");
    }
    else if (wordValue == "") {
        $("#error_message").html("密码不得为空");
    }
    else if (rePassword == "") {
        $("#error_message").html("密码不得为空");
    }
    if (rePassword != wordValue) {
        $("#error_message").html("两次密码输入不正确");
    }
    else if (codeValue == "") {
        $("#error_message").html("验证码不得为空");
    }
    else if (strcheck.test(userValue)) {
        $("#error_message").html("用户名不能包含空格\\<>等非法字符");
    }
    else if (strcheck.test(wordValue)) {
        $("#error_message").html("密码不能包含空格\\<>等非法字符");
    }
    else if (strcheck.test(codeValue)) {
        $("#error_message").html("验证码不能包含空格\\<>等非法字符");
    }
    else {
        $("#error_message").html("请稍等....");
        $.ajax({
            url: "http://localhost:8080/" + userValue + "/find",
            type: "GET",
            dataType: "json",
            success: function (data) {
                if (data.code != "10000") {
                    $("#error_message").html(data.msg);
                } else {
                    var _data = {
                        'loginName': userValue,
                        'realName': realValue,
                        'password': wordValue,
                        'code': codeValue
                    };
                    $.ajax({
                        url: "http://localhost:8080/register",
                        type: "POST",
                        contentType: "application/json",
                        dataType: "json",
                        data: JSON.stringify(_data),
                        success: function (data) {
                            if (data.code != "10000") {
                                $("#error_message").html(data.msg);
                                $("#verify_img").attr("src", "http://localhost:8080/code/verify?time=" + new Date().getTime());
                            } else {
                                alert("注册成功！");
                            }
                        }
                    });
                }
            }
        });
    }
});