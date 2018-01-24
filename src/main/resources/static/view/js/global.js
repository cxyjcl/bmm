/**
 * Created by pohoulong on 2018/1/17.
 */
var loginName;
var infoId;
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
    $("#header_name").html(loginName)
})