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
