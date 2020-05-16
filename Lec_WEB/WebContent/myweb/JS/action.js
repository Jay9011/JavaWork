let download_link = 'https://store.steampowered.com/about/?snr=1_4_4__global-header';
let download = document.getElementById("header_download");
download.addEventListener("click", function(){
    location.href = download_link;
});

let logoUrl = $("#main_logo");
logoUrl.click(function(){
    $(location).attr("href", "index.html")
});

let searchBar = $("#menu_footer .search");
let searchIco = $("#footer_search");

searchIco.click(function(){
    searchBar.toggle("fast");
});

let menubar = $("#menu_bar");
let menuOffset = menubar.offset();
$(window).scroll(function(){
    let scrollT = $(window).scrollTop();
    if(scrollT > menuOffset.top + 25) {
        menubar.css({"position" : "fixed", "top" : "0px", "max-width" : "100%", "width" : "100%", "animation" : "sizeUp 0.5s", "-webkit-animation" : "sizeUp 0.5s"});
        $(".menu-empty").css("display", "block");
    } else {
        menubar.css({"position" : "static", "max-width" : "768px", "animation" : "", "-webkit-animation" : ""});
        $(".menu-empty").css("display", "none");
    }
});