/**
 * Created by Administrator on 2018/1/24 0024.
 */
function CreateTD(num) {
    var value = '';
    var td = '<td><input type="text"/></td>'
    for (var i = 0; i < num; i ++) {
        value += td;
    }
    return '<tr>' + value + '</tr>'
}
function addRowToInfo2() {
    var rs = confirm('是否要添加一行 足球运动经历？');
    if (rs) {
        // append nodes html
        var node = CreateTD(3);
        // get tbody node
        var html = document.getElementById('info2').getElementsByTagName('tbody')[0];
        // append to tbody
        html.innerHTML += node;
    }
};
function addRowToInfo3() {
    var rs = confirm('是否要添加一行 裁判培训经历？');
    if (rs) {
        // append nodes html
        var node = CreateTD(5);
        // get tbody node
        var html = document.getElementById('info3').getElementsByTagName('tbody')[0];
        // append to tbody
        html.innerHTML += node;
    }
};
function addRowToInfo4() {
    var rs = confirm('是否要添加一行 裁判工作经历？');
    if (rs) {
        // append nodes html
        var node = CreateTD(5);
        // get tbody node
        var html = document.getElementById('info4').getElementsByTagName('tbody')[0];
        // append to tbody
        html.innerHTML += node;
    }
};