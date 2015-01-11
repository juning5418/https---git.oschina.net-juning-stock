var isIe10 = typeof document.msHidden !== "undefiend";


$("#J_registerForm").html5Validate(function() {
    this.submit();
 }, {
	novalidate: isIe10? false: true,    // 布尔型。是否取消现代浏览器的内置验证
    validate: function(){   // 包含返回值的函数，插件自带验证以外的其他验证
    // 下面这些就是额外的一些特殊验证
    var flag = false;
    if($('#confirmPassword').val() != $('#password').val()) {
        $('#password').testRemind("密码不一致");
        return false;
    }
    $.ajax({
        async : false,
        cache : false,
        type : 'POST',
        url:'./checkuser',
        data:$('#J_registerForm').serialize(),
        error:function(){
        },
        success:function(data){
            var d = $.parseJSON(data);
            if (!d.success) {
               if(d.msg == "error1") {
                   $("#email").testRemind("此邮箱已注册！");
                   flag = false;
               }else if(d.msg == "error2") {
                   $("#mobile").testRemind("此手机已注册！");
                   flag = false;
               }else if(d.msg == "error3") {
                   $("#username").testRemind("此用户名已注册！");
                   flag = false;
               } else {
                   flag = true;
               }
           } else {
               flag = true;
           }}
    	});
    	return flag;
    }
});
