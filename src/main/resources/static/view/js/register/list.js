/**
 * Created by pohoulong on 2018/1/17.
 */
var pageIndex=0;
var pageTotal=0;
var url = "/user/all/get"
var _data = {
    'pageIndex': pageIndex,
};
function page() {
    request();
}
$(function () {
    page();
});
function page_up(){
    if((pageIndex+1) == pageTotal){
        $("#up_page").addClass("disabled")
    } else{
        pageIndex++;
        page();
        $("#up_page").removeClass("disabled")
    }
}
function page_down() {
    if(pageIndex==0){
        $("#down_page").addClass("disabled")
    } else{
        $("#down_page").removeClass("disabled")
        pageIndex--;
        page();
    }
}

$("#search_btn").click(function () {
    var realName= $("#real_input").val();
    url = "/user/find";
    _data={
        'realName': realName,
        'pageIndex': pageIndex
    };
    page();
})

function request(){
    $("#list").children().remove();
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        },
        url: "http://localhost:8080"+url,
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(_data),
        success: function (data) {
            var html = "";
            pageTotal = data.data.totalPages;
            if((pageIndex+1) == pageTotal){
                $("#up_page").addClass("disabled")
            }
            $("#total_page").html(pageTotal)
            for (var i = 0; i < data.data.content.length; i++) {
                var date = new Date(data.data.content[i].createTime);
                html += "<tr><td>"
                html += "<div class='icheckbox_minimal-grey' style='position: relative;'>"
                html += "<input type='checkbox' class='checkbox-style'>"
                html += "<ins class='iCheck-helper' class='checkbox-style'></ins>"
                html += "</div></td>"
                html += "<td>" + data.data.content[i].loginName + "</td>"
                html += "<td>" + data.data.content[i].realName + "</td>"
                html += "<td>" + data.data.content[i].userLevel + "</td>"
                html += "<td>" + date.toLocaleDateString() + "</td>"
                html += "<td><span class='label label-sm label-success'>" + get_status(data.data.content[i].dataStatus) + "</span></td>"
                html += "<td> <button type='button' class='btn btn-default btn-xs' data-toggle='modal' data-target='#myModal'><i class='fa fa-edit'></i>&nbsp; 修改 </button></td></tr>"
            }
            $("#list").append(html);
        }
    });
}