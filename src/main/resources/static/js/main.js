// 点击用户名，弹出下拉列表。
$(function () {
    var $getDisplay=$("#user-set").css("display");
    function getdisplay(){
        $getDisplay=$("#user-set").css("display");
    }
    $("#user").click(function(){
        if ($getDisplay=="none"){
            $("#user-set").css("display","block");
            getdisplay();
        }else{
            $("#user-set").css("display","none");
            getdisplay();
        }
    })
})