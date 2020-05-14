$(function(){
    $("#login").on("click", function(){
        var loginForm = document.forms["login"];
        var username = loginForm["username"];
        var userPass = loginForm["password"];
        var wornbox = $("#loginbox .worn");
        var isPass = true;
        var offset = wornbox.offset();
        var winHeight = $(window).height();

        // 초기화
        wornbox.html("");
        wornbox.removeClass("error_box");
        username.classList.remove("worn_box");
        userPass.classList.remove("worn_box");

        if (username.value.trim() == "") {
            wornbox.append("<p>계정 이름을 입력해 주세요.</p>");
            username.setAttribute("class", "worn_box");
            isPass = false;
        }
        if (userPass.value.trim() == "") {
            wornbox.append("<p>비밀번호를 입력해 주세요.</p>");
            userPass.setAttribute("class", "worn_box");
            isPass = false;
        }
        if(isPass){
            loginForm.submit();
        } else {
            wornbox.addClass("error_box");
            $('html, body').animate({
                scrollTop : (offset.top - winHeight/2)
            }, 400);
        }
        
    });

    $("#joinIn").on("click", function(){
        var joinForm = document.forms["join"];
        var userMail = joinForm["usermail"];
        var chkMail = joinForm["chkusermail"];
        var userPass = joinForm["password"];
        var chkPass = joinForm["chkpassword"];
        var wornbox = $("#loginbox .worn");
        var isPass = true;
        var offset = wornbox.offset();
        var winHeight = $(window).height();
        var emailPat = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

        // 초기화
        wornbox.html("");
        wornbox.removeClass("error_box");
        userMail.classList.remove("worn_box");
        chkMail.classList.remove("worn_box");
        userPass.classList.remove("worn_box");
        chkPass.classList.remove("worn_box");
        
        if(userMail.value.trim() == ""){
            wornbox.append("<p>이메일을 입력해 주세요.</p>");
            userMail.setAttribute("class", "worn_box");
            isPass = false;
        } else if(!emailPat.test(userMail.value.trim())){
            wornbox.append("<p>이메일을 형식이 잘못되었습니다. 다시 확인해주세요.</p>");
            userMail.setAttribute("class", "worn_box");
            isPass = false;
        } else if(userMail.value.trim() != chkMail.value.trim()){
            wornbox.append("<p>이메일이 다릅니다. 확인해 주세요.</p>");
            chkMail.setAttribute("class", "worn_box");
            isPass = false;
        }
        if(userPass.value.trim() == ""){
            wornbox.append("<p>비밀번호를 입력해 주세요.</p>");
            userPass.setAttribute("class", "worn_box");
            isPass = false;        
        } else if(userPass.value.trim() != chkPass.value.trim()){
            wornbox.append("<p>비밀번호가 다릅니다. 확인해 주세요.</p>");
            chkPass.setAttribute("class", "worn_box");
            isPass = false;        
        }
        if(!joinForm["agree_check"].checked){
            wornbox.append("<p>동의서에 동의해야 가입할 수 있습니다.</p>");
            $(".agree_box").addClass("worn_box");
            isPass = false;
        }
        if(isPass){
            joinForm.submit();
        } else {
            wornbox.addClass("error_box");
            $('html, body').animate({
                scrollTop : (offset.top - winHeight/2)
            }, 400);
        }
    });
});