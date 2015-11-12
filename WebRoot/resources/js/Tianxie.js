// JavaScript Document

            $(function () {
                checkusernameTip();
                checkusername();
                checkxingming();
                checkQQ();
            })
        
            function btnSubmit() {
                var v = "";
                if (v.length <= 0) {
                    var username = $.trim($("#username").val());
                    if (username.length <= 0) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip8").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (username.length < 4 || username.length > 20) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip4").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (checkIsNum(username)) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip6").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (checkusernameIxExist(username)) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip7").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (checkIsHanZi(username)) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip4").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (checkIsTrue(username)) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip4").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (containSpecial(username)) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip4").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                }
        
        
                var xingming = $.trim($("#xingming").val());
                if (strlen(xingming) <= 0) {
                    $("#divxingming span").hide();
                    $("#xingmingTip1").show();
                    $("#xingmingTip3").show();
                    $("#xingming").addClass("inp_red");
                    return false;
                }
                if (containSpecialName(xingming)) {
                    $("#divxingming span").hide();
                    $("#xingmingTip1").show();
                    $("#xingmingTip6").show();
                    $("#xingming").addClass("inp_red");
                    return false;
                }
                if (strlen(xingming) < 4 || strlen(xingming) > 20) {
                    $("#divxingming span").hide();
                    $("#xingmingTip1").show();
                    $("#xingmingTip5").show();
                    $("#xingming").addClass("inp_red");
                    return false;
                }
        
                var qq = $.trim($("#QQ").val());
                if (qq.length > 0) {
                    if (!checkIsNum(qq) || containSpecial(qq)) {
                        $("#divQQ span").hide();
                        $("#qqTip1").show();
                        $("#qqTip3").show();
                        $("#QQ").addClass("inp_red");
                        return false;
                    }
                }
        
                $("form").submit();
            }
        
            function checkQQ() {
                var result = false;
                $("#QQ").blur(function () {
                    var qq = $.trim($("#QQ").val());
                    if (qq.length > 0) {
                        if (!checkIsNum(qq) || containSpecial(qq)) {
                            $("#divQQ span").hide();
                            $("#qqTip1").show();
                            $("#qqTip3").show();
                            $("#QQ").addClass("inp_red");
                            return false;
                        }
                        $("#divQQ span").hide();
                        $("#qqTip2").show();
                        $("#QQ").removeClass("inp_red");
                        result = true;
                    }
                    else {
                        $("#divQQ span").hide();
                        $("#QQ").removeClass("inp_red");
                    }
        
                }).focus(function () {
                    $("#QQ").removeClass("inp_red");
                });
                return result;
            }
        
            function checkusernameTip() {
                var msg = "";
                if (msg == "只允许输入英文，最长14个英文字母") {
                    $("#msg").hide();
                    $("#divusername span").hide();
                    $("#nickTip1").show();
                    $("#nickTip4").show();
                }
            }
        
            function checkxingming() {
                var result = false;
                $("#xingming").blur(function () {
                    var xingming = $.trim($("#xingming").val());
                    if (strlen(xingming) <= 0) {
                        $("#divxingming span").hide();
                        $("#xingmingTip1").show();
                        $("#xingmingTip3").show();
                        $("#xingming").addClass("inp_red");
                        return false;
                    }
                    if (containSpecialName(xingming)) {
                        $("#divxingming span").hide();
                        $("#xingmingTip1").show();
                        $("#xingmingTip6").show();
                        $("#xingming").addClass("inp_red");
                        return false;
                    }
                    if (strlen(xingming) < 4 || strlen(xingming) > 20) {
                        $("#divxingming span").hide();
                        $("#xingmingTip1").show();
                        $("#xingmingTip5").show();
                        $("#xingming").addClass("inp_red");
                        return false;
                    }
        
        
                    $("#divxingming span").hide();
                    $("#xingmingTip2").show();
                    $("#xingming").removeClass("inp_red");
                    result = true;
                }).focus(function () {
                    $("#divxingming span").hide();
                    $("#xingmingTip4").show();
                    $("#xingming").removeClass("inp_red");
                });
                return result;
            }
        
            function checkusername() {
                var result = false;
                $("#username").blur(function () {
                    var username = $.trim($("#username").val());
                    if (username.length <= 0) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip8").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (username.length < 4 || username.length > 20) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip4").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (checkIsNum(username)) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip6").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (checkusernameIxExist(username)) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip7").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (checkIsHanZi(username)) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip4").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (checkIsTrue(username)) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip4").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
                    if (containSpecial(username)) {
                        $("#divusername span").hide();
                        $("#nickTip1").show();
                        $("#nickTip4").show();
                        $("#username").addClass("inp_red");
                        return false;
                    }
        
                    $("#divusername span").hide();
                    $("#nickTip2").show();
                    $("#nickTip5").show();
                    $("#username").removeClass("inp_red");
                    result = true;
                }).focus(function () {
                    $("#divusername span").hide();
                    $("#nickTip3").show();
                    $("#username").removeClass("inp_red");
                });
                return result;
            }
        
            //检查用户名规则
            function checkIsTrue(text) {
                var r = true;
                if (!(/[a-z][A-Z][\d][\-\_]/.test(text))) {
                    r = true;
                }
                var re = /^[\-\_]*$/;
                if (!re.test(text)) {
                    r = false;
                }
                return r;
            }
        
            //检查是否是汉字
            function checkIsHanZi(text) {
                var r = false;
                var reg = /[^\u4e00-\u9fa5]/g;
                if (/.*[\u4e00-\u9fa5]+.*$/.test(text)) {
                    r = true;
                }
                return r;
            }
            //检验用户名是否为纯数字
            function checkIsNum(text) {
                var r = true;
                var re = /^[0-9]+.?[0-9]*$/;   //判断字符串是否为数字
                if (!re.test(text)) {
                    r = false;
                }
                return r;
            }
            //检验用户名是否存在
            function checkusernameIxExist(text) {
                var r = true;
                var memberId = $("#MemberID").val();
                $.ajax({
                    type: "POST",
                    async: false,
                    url: "/UCenter/Account/CheckusernameIsExist",
                    data: { username: text, memberId: memberId },
                    success: function (msg) {
                        if (msg == 0) {
                            r = false;
                        }
                    }
                });
                return r;
            }
            //字符串的实际长度
            function strlen(str) {
                var len = 0;
                for (var i = 0; i < str.length; i++) {
                    var c = str.charCodeAt(i);
                    //单字节加1
                    if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
                        len++;
                    }
                    else {
                        len += 2;
                    }
                }
                return len;
            }
            //判断字符中是否包含有特殊字符：
            function containSpecial(s) {
                var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\+)(\=)(\[)(\])(\【)(\】)(\（)(\）)(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\，)(\。)(\/)(\<)(\>)(\《)(\》)(\——)(\？)(\、)(\……)(\····)(\；)(\”)(\“)(\：)(\‘)(\’)(\?)(\)]+/);
                return (containSpecial.test(s));
            }
            function containSpecialName(s) {
                var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\【)(\】)(\（)(\）)(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\，)(\。)(\/)(\<)(\>)(\《)(\》)(\?)(\)(\——)(\？)(\、)(\……)(\····)(\；)(\”)(\“)(\：)(\‘)(\’)(0-9)]+/);
                return (containSpecial.test(s));
            }
            function containSpecial1(s) {
                var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\——)(\？)(\、)(\……)(\····)(\；)(\”)(\“)(\：)(\‘)(\’)(\)]+/);
                return (containSpecial.test(s));
            }
