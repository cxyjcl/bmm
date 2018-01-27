/**
 * Created by pohoulong on 2018/1/17.
 */

function get_info_status(status) {
    if (status == "001") {
        return "已提交"
    }
    if (status == "000") {
        return "禁用中"
    }
    if (status == "003") {
        return "已删除"
    }
}
function get_status(status) {
    if (status == "001") {
        return "使用中"
    }
    if (status == "000") {
        return "禁用中"
    }
    if (status == "003") {
        return "已删除"
    }
}
$(function () {
    $.ajax({
        url: "http://119.23.229.247:8080/user/get",
        type: "POST",
        dataType: "json",
        success: function (data) {
            if (data.code != "10000") {
                alert(data.msg);
            } else {
                var date = new Date(data.data.createTime);
                loginName = data.data.loginName;
                infoId = data.data.id;
                $("#show_username").html(data.data.loginName);
                $("#header_name").html(data.data.loginName);
                $("#show_real_name").html(data.data.realName);
                var status = data.data.dataStatus;
                status = get_status(status);
                $("#show_status").html(status);
                $("#join_time").html(date.toLocaleDateString());
                $("#user_img").attr("src", data.data.userImg);
                $("#header_img").html(data.data.userImg);
                $("#username").val(data.data.loginName);
                $("#real_name").val(data.data.realName);
                if(data.data.userLevel == "普通用户"){
                    $("#people_manager").remove();
                    $("#list_tab").remove()
                }
            }
        },
        error:function () {
            window.location.href = "http://119.23.229.247:8080/view/error";
        }
    });
})