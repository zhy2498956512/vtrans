$(function () {
    $(".app,.sign-out").hover(function(){
        $(this).css("color","#ff6600");
    },function(){
        $(this).css("color","#121639");
    });

    $(".app").hover(function(){
        $(".QRCode").show();
    },function(){
        $(".QRCode").hide();
    });
    
    $(".sign-out").click(function () {
        location.href = "/signOut";
    });

    $("li").hover(function(){
        $(this).css("background-color","#fff7e0");
    },function(){
        $(this).css("background-color","#fff");
    });
});