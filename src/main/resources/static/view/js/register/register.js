/**
 * Created by Administrator on 2018/1/24 0024.
 */
var registerId;
$(function () {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        },
        url: "http://localhost:8080/get/id/register",
        type: "POST",
        dataType: "json",
        success: function (data) {
            if (data.data != null) {
                registerId= data.data;
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': "*"
                    },
                    url: "http://localhost:8080/all/register/get",
                    type: "POST",
                    dataType: "json",
                    success: function (data) {
                        if (data.code != "10000") {
                            $("#error_message").html(data.msg);
                        } else {
                            var info = $("#info").find("input");
                            var education =$('#education input:radio:checked').val();
                            var level = $('#level input:radio:checked').val();
                                info[0].value=data.data.realName;
                                info[1].value=data.data.birthday;
                                info[2].value=data.data.nativePlace;
                                info[3].value=data.data.association;
                                info[4].value=data.data.height;
                                info[5].value=data.data.weight;
                                info[6].value=data.data.cardNumber;
                                education=data.data.education;
                                info[11]=data.data.politicalStatus;
                                info[12]=data.data.foreignLanguage;
                                info[13]=data.data.phoneNumber;
                                info[14]=data.data.otherNumber;
                                info[15]=data.data.company;
                                'currentLevel':level,
                                info[20].value=data.data.levelDate;
                                info[21].value=data.data.email;
                                info[22].value=data.data.address;
                        }
                    }
                });
            } else{
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': "*"
                    },
                    url: "http://localhost:8080/add/register",
                    type: "POST",
                    dataType: "json",
                    success: function (data) {
                        if (data.code != "10000") {
                            $("#error_message").html(data.msg);
                        } else {
                            registerId= data.data;
                        }
                    }
                });
            }
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
    var education =$('#education input:radio:checked').val();
    var level = $('#level input:radio:checked').val();
    var _info = {
        'realName':info[0].value,
        'birthday':info[1].value,
        'nativePlace':info[2].value,
        'association':info[3].value,
        'height':info[4].value,
        'weight':info[5].value,
        'cardNumber':info[6].value,
        'education':education,
        'politicalStatus':info[11].value,
        'foreignLanguage':info[12].value,
        'phoneNumber':info[13].value,
        'otherNumber':info[14].value,
        'company':info[15].value,
        'currentLevel':level,
        'levelDate':info[20].value,
        'email':info[21].value,
        'address':info[22].value,
        'registerInfoId':registerId
    }
    var _experience = [];
    var info2 = $("#info2").find("input");
    for(var i=0;i<info2.length;i=i+3){
        var data = {
            'experienceDate':info2[i].value,
            'ballTeam':info2[i+1].value,
            'remark':info2[i+2].value
        }
        _experience.push(data)
    }
    var _train = [];
    var info3 = $("#info3").find("input");
    for(var i=0;i<info3.length;i=i+5){
        var data = {
            'trainDate':info3[i].value,
            'trainLesson':info3[i+1].value,
            'trainLevel':info3[i+2].value,
            'trainPlace':info3[i+3].value,
            'teacher':info3[i+4].value,
            'registerInfoId':registerId
        }
        _train.push(data)
    }
    var _job = [];
    var info4 = $("#info4").find("input");
    for(var i=0;i<info4.length;i=i+5){
        var data = {
            'category':info4[i].value,
            'judge':info4[i+1].value,
            'observer':info4[i+2].value,
            'fourthOfficial':info4[i+3].value,
            'headJudge':info4[i+4].value,
            'registerInfoId':registerId
        }
        _job.push(data)
    }
    console.log(_job);
    var _data = {
        'info': _info,
        'experienceList': _experience,
        'trainList': _train,
        'jobList':_job,
        'registerInfoId':registerId
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': "*"
        },
        url: "http://localhost:8080/all/register/add",
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