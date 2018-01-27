$("#verify_img").click(function () {
    $("#verify_img").attr("src", "http://119.23.229.247:8080/code/verify?time=" + new Date().getTime());
})
$("#submit_btn").click(function () {
    var userValue = $("#login_name").val();
    var wordValue = $("#password").val();
    var codeValue = $("#code").val();
    var strcheck = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    if (userValue == "") {
        $("#error_message").html("用户名不得为空");
    }
    else if (wordValue == "") {
        $("#error_message").html("密码不得为空");
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
        var _data = {
            'loginName': userValue,
            'password': wordValue,
            'code': codeValue
        };
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': "*"
            },
            url: "http://119.23.229.247:8080/login",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(_data),
            success: function (data) {
                if (data.code != "10000") {
                    $("#error_message").html(data.msg);
                    $("#verify_img").attr("src", "http://119.23.229.247:8080/code/verify?time=" + new Date().getTime());
                } else {
                    window.location.href = "http://119.23.229.247:8080/view/change"
                }
            }
        });
    }
});