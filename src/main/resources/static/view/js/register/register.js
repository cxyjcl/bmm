/**
 * Created by Administrator on 2018/1/24 0024.
 */
var registerId;
var calcTotal=function(table,column){//合计，表格对象，对哪一列进行合计，第一列从0开始
    var trs=table.getElementsByTagName('tr');
    var start=0,//忽略第一行的表头
        end=trs.length;
    var total=0;
    for(var i=start;i<end;i++){
        var td=trs[i].getElementsByTagName('input')[column];
        var t=parseFloat(td.value);
        if(t)total+=t;
    }
    $("#total td")[column].innerHTML=total;
};
$("#table").mouseout(function(){
    for(var i=1;i<5;i++)
        calcTotal(document.getElementById('table'),i);
})
function add_photo(){
  $("#file").click();
}
function upload() {
    var file = new FormData();
    file.append("file",document.getElementById('file').files[0]);
    file.append("registerId",registerId);
    if (document.getElementById('file').files[0] != null && document.getElementById('file').files[0] != "") {
        var filepath=$("#file").val();
        var extStart=filepath.lastIndexOf(".");
        var ext=filepath.substring(extStart,filepath.length).toUpperCase();
        if(ext!=".JPG"&&ext!=".JPEG"&&ext!=".PNG"&&ext!=".GIF"&&ext!=".BMP"){
            alert("文件仅限于JPG,JPEG,PNG,GIF,BMP");
        }else{
            $.ajax({
                type:"POST",
                contentType:false,
                processData:false,
                dataType: "json",
                url:"http://119.23.229.247:8080/register/upload",
                data:file,
                success:function(data){
                    alert(data.msg);
                    $("#photo").attr("src", data.data);
                },
                error:function(data){
                    alert("文件最大为3M");
                }
            });
        }
    }
}
$(function () {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        },
        url: "http://119.23.229.247:8080/get/id/register",
        type: "POST",
        dataType: "json",
        success: function (data) {
            if (data.data != null) {
                registerId = data.data;
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': "*"
                    },
                    url: "http://119.23.229.247:8080/all/register/get",
                    type: "POST",
                    dataType: "json",
                    success: function (data) {
                        if (data.code != "10000") {
                            $("#error_message").html(data.msg);
                        } else {
                            var info = $("#info").find("input");
                            info[0].value = data.data.info.realName;
                            info[1].value = data.data.info.birthday;
                            info[2].value = data.data.info.nativePlace;
                            info[3].value = data.data.info.association;
                            info[4].value = data.data.info.height;
                            info[5].value = data.data.info.weight;
                            info[6].value = data.data.info.cardNumber;
                            $("#education input:radio[value='" + data.data.info.education + "']").prop("checked", "checked");
                            info[11] = data.data.info.politicalStatus;
                            info[12] = data.data.info.foreignLanguage;
                            info[13] = data.data.info.phoneNumber;
                            info[14] = data.data.info.otherNumber;
                            info[15] = data.data.info.company;
                            $("#level input:radio[value='" + data.data.info.currentLevel + "']").prop("checked", "checked");
                            info[20].value = data.data.info.levelDate;
                            info[21].value = data.data.info.email;
                            info[22].value = data.data.info.address;
                            var info4 = $("#info4").find("input");
                            var j = 0;
                            var info2 = $("#info2").find("input");
                            for (var i = 0; i < data.data.experienceList.length; i = i + 3) {
                                if ((i + 5) < data.data.experienceList.length-1) {
                                    addRowToInfo2();
                                }
                                info2[i].value = data.data.experienceList[j].experienceDate;
                                info2[i + 1].value = data.data.experienceList[j].ballTeam;
                                info2[i + 2].value = data.data.experienceList[j].remark;
                                j++;
                            }
                            j=0
                            var info3 = $("#info3").find("input");
                            for (var i = 0; i < data.data.trainList.length; i = i + 5) {
                                if ((i + 5) < data.data.trainList.length-1) {
                                    addRowToInfo3();
                                }
                                info3[i].value = data.data.trainList[j].trainDate;
                                info3[i + 1].value = data.data.trainList[j].trainLesson;
                                info3[i + 2].value = data.data.trainList[j].trainLevel;
                                info3[i + 3].value = data.data.trainList[j].trainPlace;
                                info3[i + 4].value = data.data.trainList[j].teacher;
                                j++;
                            }
                            j = 0;
                            for (var i = 0; i < data.data.jobList.length; i = i + 5) {
                                if ((i + 5) < data.data.jobList.length-1) {
                                    addRowToInfo4();
                                }
                                info4[i].value = data.data.jobList[j].category;
                                info4[i + 1].value = data.data.jobList[j].judge;
                                info4[i + 2].value = data.data.jobList[j].observer;
                                info4[i + 3].value = data.data.jobList[j].fourthOfficial;
                                info4[i + 4].value = data.data.jobList[j].headJudge;
                            }

                        }
                    }
                });
            }
        },
        error:function () {
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': "*"
                },
                url: "http://119.23.229.247:8080/add/register",
                type: "POST",
                dataType: "json",
                success: function (data) {
                    if (data.code != "10000") {
                        $("#error_message").html(data.msg);
                    } else {
                        console.log(data.data)
                        registerId = data.data;
                    }
                }
            });
        }
    });
})
function CreateTD(num) {
    var value = '';
    var td = '<td><input type="text"/></td>'
    for (var i = 0; i < num; i++) {
        value += td;
    }
    return '<tr>' + value + '</tr>'
}
function addRowToInfo2() {
    var rs = confirm('是否要添加一行 足球运动经历？');
    if (rs) {
        // append nodes html
        var node = CreateTD(3);
        $("#info2 tbody").append(node)
    }
};
function addRowToInfo3() {
    var rs = confirm('是否要添加一行 裁判培训经历？');
    if (rs) {
        // append nodes html
        var node = CreateTD(5);
        // get tbody node
        $("#info3 tbody").append(node)
    }
};
function addRowToInfo4() {
    var rs = confirm('是否要添加一行 裁判工作经历？');
    if (rs) {
        // append nodes html
        var node = CreateTD(5);
        // get tbody node
        $("#info4 tbody").append(node)
    }
};

$("#submit_btn").click(function () {
    var info = $("#info").find("input");
    var education = $('#education input:radio:checked').val();
    var level = $('#level input:radio:checked').val();
    var _info = {
        'realName': info[0].value,
        'birthday': info[1].value,
        'nativePlace': info[2].value,
        'association': info[3].value,
        'height': info[4].value,
        'weight': info[5].value,
        'cardNumber': info[6].value,
        'education': education,
        'politicalStatus': info[11].value,
        'foreignLanguage': info[12].value,
        'phoneNumber': info[13].value,
        'otherNumber': info[14].value,
        'company': info[15].value,
        'currentLevel': level,
        'levelDate': info[20].value,
        'email': info[21].value,
        'address': info[22].value,
        'registerInfoId': registerId
    }
    var _experience = [];
    var info2 = $("#info2").find("input");
    for (var i = 0; i < info2.length; i = i + 3) {
        var data = {
            'experienceDate': info2[i].value,
            'ballTeam': info2[i + 1].value,
            'remark': info2[i + 2].value
        }
        _experience.push(data)
    }
    var _train = [];
    var info3 = $("#info3").find("input");
    for (var i = 0; i < info3.length; i = i + 5) {
        var data = {
            'trainDate': info3[i].value,
            'trainLesson': info3[i + 1].value,
            'trainLevel': info3[i + 2].value,
            'trainPlace': info3[i + 3].value,
            'teacher': info3[i + 4].value,
            'registerInfoId': registerId
        }
        _train.push(data)
    }
    var _job = [];
    var info4 = $("#info4").find("input");
    for (var i = 0; i < info4.length; i = i + 5) {
        var data = {
            'category': info4[i].value,
            'judge': info4[i + 1].value,
            'observer': info4[i + 2].value,
            'fourthOfficial': info4[i + 3].value,
            'headJudge': info4[i + 4].value,
            'registerInfoId': registerId
        }
        _job.push(data)
    }
    console.log(_job);
    var _data = {
        'info': _info,
        'experienceList': _experience,
        'trainList': _train,
        'jobList': _job,
        'registerInfoId': registerId
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        },
        url: "http://119.23.229.247:8080/all/register/add",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(_data),
        success: function (data) {
            if (data.code != "10000") {
                $("#error_message").html(data.msg);
            } else {
                alert("添加成功！");
            }
        }
    });
});