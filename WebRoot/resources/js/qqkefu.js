var online = [];
function QQPanel() {
    this.url = 'http://webpresence.qq.com/getonline?Type=1&';
    this.items = $("a[qq]");  //$("#"+id).children("li");//this.id.childNodes;
    this.lens = $("a[qq]").length;
    this.index = 0;
    // this.data  = data;
    this.start();
}
QQPanel.prototype = {
    qqRequestedArray: new Array(),
    start: function () {
        var _this = this;
        if (this.index >= this.lens) return false;
        var qq = $(_this.items.eq(_this.index)).attr("qq");
        if ($.inArray(qq, _this.qqRequestedArray) == -1) {
            $.getScript(_this.url + qq + ':', function (data, textStatus) {
                _this.qqRequestedArray.push(qq);
                _this.show(qq, online[0]);
            });
        }
    },
    show: function (q, s) {
        var _this = this;
        $("a[qq=" + q + "]").each(function (i, current) {
            $(current).addClass('qqoffline');
            $(current).attr("title", '中钢网客服');
            if (s == 1) {
                $(current).addClass('qqonline');
                $(current).attr("title", '中钢网客服');
            }
            $(current).attr("href", 'http://wpa.qq.com/msgrd?v=3&uin=' + q + '&site=中钢网&menu=yes');
            _this.index++;
            _this.start();
        });
    },
    reload: function () {
        if (this.running) return false;
        this.index = 0;
        this.start();
    }
}
$(function () {
    var QQOnline = new QQPanel();
})
//  setInterval(function(){//每隔10秒检测一次在线状态
//  QQOnline.reload();
//}, 10000);
