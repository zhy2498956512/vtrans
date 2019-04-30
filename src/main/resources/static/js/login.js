$(function () {
    $(".iphone,.test-code").hover(function(){
        $(this).css("border","1px solid #ff7b11");
    },function(){
        $(this).css("border","1px solid #d8d8d8");
    });

    $(".btn").hover(function(){
        $(this).css("background-color","#ff6600");
    },function(){
        $(this).css("background-color","#ff7b11");
    });

    $("#gsjs1").click(function () {
        $(this).removeClass("gsjs").addClass("gsjss");
        $("#gsjs2").removeClass("gsjss").addClass("gsjs");
        $("#content1").show();
        $("#content2").hide();
    });
    $("#gsjs2").click(function () {
        $(this).removeClass("gsjs").addClass("gsjss");
        $("#gsjs1").removeClass("gsjss").addClass("gsjs");
        $("#content2").show();
        $("#content1").hide();
    });

    $(".tips").hide();
    function tips(tipsText){
        var tips = $(".tips");
        tips.html(tipsText);
        tips.show();
        tips.fadeOut(3000);
    }

    function verificationPass(){
        var userMail = $("#userMail").val();
        var userPass = $("#userPass").val();
        if(userMail==""){
            tips("请输入用户邮箱");
            return false;
        }else if(userMail.indexOf("@") < 0 ) {
            tips("邮箱格式不正确");
            return false;
        }else if(userPass==""){
            tips("请输入密码");
            return false;
        }else if(userPass.indexOf(" ") >= 0 ){
            tips("密码使用非法字符");
            return false;
        }
        return true;
    }

    function verificationCode(){
        var userMail = $("#userMail").val();
        var code = $("#code").val();
        if(userMail==""){
            tips("请输入用户邮箱");
            return false;
        }else if(userMail.indexOf("@") < 0 ) {
            tips("邮箱格式不正确");
            return false;
        }else if(code==""){
            tips("验证码不为空");
            return false;
        }else if(code.indexOf(" ")>= 0||code.size()!=6){
            tips("验证码错误");
            return false;
        }
        return true;
    }

    function countDown(){
        var left_time = 60;
        var sendsms = $("#sendsms");
        sendsms.val(left_time+"S");
        setInterval(function(){
            if(left_time>1){
                left_time = left_time - 1;
                sendsms.val(left_time+"S");
            }else {
                sendsms.val("重新发送");
            }
        }, 1000);
    }

    
    $("#sendsms").click(function () {
        var x = verificationPass();
        if(x==true){
            $.ajax({
                url: "sendMail",
                data: {"userMail": $("#userMail").val(),"userPass": $("#userPass").val()},
                type: "POST",
                dataType: "json",
                success: function (msg) {
                    tips(msg.data);
                    if(msg.code==200) countDown();
                }
            });
        }
    });

    $("#login").click(function () {
        if($("#content1").is(":hidden")){
            //如果隐藏时。。。
            if(verificationCode()==true){
                $.ajax({
                    url: "sendLogin",
                    data: {"userMail": $("#userMail").val(),"userCode":$("#code").val(),"identification":1},
                    type: "POST",
                    dataType: "json",
                    success: function (msg) {
                        tips(msg.data);
                        if(msg.code==200) location.href = "jumpIndex";
                    }
                });
            }
        }else{
            //如果显示时。。。
            if(verificationPass()==true){
                $.ajax({
                    url: "sendLogin",
                    data: {"userMail": $("#userMail").val(), "userPass": $("#userPass").val(),"identification":2},
                    type: "POST",
                    dataType: "json",
                    success: function (msg) {
                        tips(msg.data);
                        if (msg.code == 200) location.href = "jumpIndex";
                    }
                });
            }
        }
    });

});