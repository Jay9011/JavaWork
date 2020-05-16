$(document).ready(function(){
    //스크롤 발생 이벤트
    $(window).scroll(function(){
        var scrollT = $(window).scrollTop();    //스크롤바의 상단위치
        var scrollH = $(window).height();       //스크롤바를 갖는 document의 높이
        var contentH = $('body').height();      //문서 전체 내용을 갖는 div의 높이
        if(scrollT > contentH - scrollH) {      // 스크롤바가 아래 쪽에 위치할 때
            addList();
        }
    });
});