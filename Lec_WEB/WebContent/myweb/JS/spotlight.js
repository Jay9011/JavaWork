let soptlight = $("#flyshow");
let soptlightOffset = soptlight.offset();
$(window).scroll(function(){
    let scrollT = $(window).scrollTop();
    if(scrollT > soptlightOffset.top - 70) {
        soptlight.css({"position" : "fixed", "top" : "70px"});
    } else {
        soptlight.css({"position" : "relative", "top" : "0"});
    }
});