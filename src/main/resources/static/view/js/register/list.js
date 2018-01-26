/**
 * Created by pohoulong on 2018/1/17.
 */
var pageIndex = 0;
var pageTotal = 0;
var url = "/register/creator/get"
var _data = {
    'pageIndex': pageIndex,
};
var userId;
function page() {
    request();
}
$(function () {
    page();
});
$("#own_tab").click(function () {
    pageIndex=0
    url="/register/creator/get";
    request();
})
$("#list_tab").click(function () {
    pageIndex=0
    url="/register/all/get";
    list_request();
})
function list_page_up() {
    if ((pageIndex + 1) == pageTotal) {
        $("#list_up_page").addClass("disabled")
    } else {
        pageIndex++;
        list_request();
        $("#list_up_page").removeClass("disabled")
    }
}
function list_page_down() {
    if (pageIndex == 0) {
        $("#list_down_page").addClass("disabled")
    } else {
        $("#list_down_page").removeClass("disabled")
        pageIndex--;
        list_request();
    }
}

function page_up() {
    if ((pageIndex + 1) == pageTotal) {
        $("#up_page").addClass("disabled")
    } else {
        pageIndex++;
        page();
        $("#up_page").removeClass("disabled")
    }
}
function page_down() {
    if (pageIndex == 0) {
        $("#down_page").addClass("disabled")
    } else {
        $("#down_page").removeClass("disabled")
        pageIndex--;
        page();
    }
}
$("#search_all_btn").click(function () {
    var realName = $("#list_input").val();
    url = "/register/find";
    pageIndex=0;
    _data = {
        'realName': realName,
        'pageIndex': pageIndex
    };
    list_request();
})
function request() {
    $("#own-list").children().remove();
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        },
        url: "http://localhost:8080" + url,
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(_data),
        success: function (data) {
            var html = "";
            pageTotal = data.data.totalPages;
            if ((pageIndex + 1) == pageTotal) {
                $("#up_page").addClass("disabled")
            }
            $("#total_page").html(pageTotal)
            for (var i = 0; i < data.data.content.length; i++) {
                var date = new Date(data.data.content[i].createTime);
                html += "<tr id="+data.data.content[i].id+ "><td>"
                html += "<div class='icheckbox_minimal-grey' style='position: relative;'>"
                html += "<input type='checkbox' class='checkbox-style'>"
                html += "<ins class='iCheck-helper' class='checkbox-style'></ins>"
                html += "</div></td>"
                html += "<td>" + date.toLocaleDateString() + "</td>"
                html += "<td><span class='label label-sm label-success'>" + get_info_status(data.data.content[i].dataStatus) + "</span></td>"
                html += "<td> <button type='button' class='btn btn-default btn-xs' onclick='change(this)'><i class='fa fa-edit'></i>&nbsp; 修改 </button></td>"
                html += "<td> <button type='button' class='btn btn-default btn-xs' onclick='remove(this)'><i class='fa fa-trash'></i>&nbsp; 删除 </button></td></tr>"
            }
            $("#own-list").append(html);
        }
    });
}
function list_request() {
    $("#list").children().remove();
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        },
        url: "http://localhost:8080" + url,
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(_data),
        success: function (data) {
            var html = "";
            pageTotal = data.data.totalPages;
            if ((pageIndex + 1) == pageTotal) {
                $("#list_up_page").addClass("disabled")
            }
            $("#list_total_page").html(pageTotal)
            for (var i = 0; i < data.data.content.length; i++) {
                var date = new Date(data.data.content[i].createTime);
                html += "<tr id="+data.data.content[i].id+"><td>"
                html += "<div class='icheckbox_minimal-grey' style='position: relative;'>"
                html += "<input type='checkbox' class='checkbox-style'>"
                html += "<ins class='iCheck-helper' class='checkbox-style'></ins>"
                html += "</div></td>"
                html += "<td>" + date.toLocaleDateString() + "</td>"
                html += "<td>" + data.data.content[i].realName + "</td>"
                html += "<td><span class='label label-sm label-success'>" + get_info_status(data.data.content[i].dataStatus) + "</span></td>"
                html += "<td> <button type='button' class='btn btn-default btn-xs' onclick='change(this)'><i class='fa fa-edit'></i>&nbsp; 修改 </button></td>"
                html += "<td> <button type='button' class='btn btn-default btn-xs' onclick='remove(this)'><i class='fa fa-trash'></i>&nbsp; 删除 </button></td></tr>"
            }
            $("#list").append(html);
        }
    });
}

function change(which){
    var id = $(which).parent().parent().attr("id");
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        },
        url: "http://localhost:8080/update/"+id+"/register",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            window.open("http://localhost:8080/view/add");
        }
    });
}

$("#add_register").click(function () {
    window.open("http://localhost:8080/view/add")
})

function remove(which){
    var id = $(which).parent().parent().attr("id");
    var rs = confirm('是否要删除此记录？');
    if (rs) {
        var _remove = {
            'id': id,
            'dataStatus':"000"
        };
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': "*"
            },
            url: "http://localhost:8080/register/update",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(_remove),
            success: function (data) {
                alert(data.msg);
            }
        });
    }
}