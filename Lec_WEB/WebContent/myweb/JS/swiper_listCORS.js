// swiper 에 값 넣기
var $items = news.rgAppData;
var swiper = $(".swiper-wrapper");
// txt = $items[1147560].name;
$.each($items, function(index, item){
    var html = '<div class="swiper-slide">';
    html += '<a href="' + item.url + '"><div class="big_thum" style="background-image: url(' + item.regular_thumbnail + ')"></div>'
    + '<div class="appname">' + item.name + '</div><div class="info"><div class="screenshot">';
    for(i = 0; i < item.preview.length; i++){
        html += '<div><img src="' + item.preview[i] + '" alt=""></div>';
    }
    html += '</div>'
    html += '<div class="tags">'
    for(i = 0; i < item.tags.length; i++){
        html += '<div class="tag">' + item.tags[i] + '</div>';
    }
    html += '</div>';
    if(item.discount) {
        html += '<div class="reason"><div class="default" style="color:#a4d007; font-weight: bold;">할인 행사중!!!</div></div>';
    } else if(item.early_access){
        html += '<div class="reason"><div class="default">앞서 해보기</div></div>';
    } else {
        html += '<div class="reason"><div class="default">판매중</div></div>';
    }
    html += '<div class="addition"><div class="price">';
    if(item.discount){
        html += item.discount_block;
    } else {
        html += item.price;
    }
    html += '</div>';
    html += '<div class="platforms">';
    
    if(item.os_windows){
        html += '<img src="images/icon_platform_win.png" alt="">'
    }
    if(item.os_macos){
        html += '<img src="images/icon_platform_mac.png" alt="">';
    }
    if(item.os_linux){
        html += '<img src="images/icon_platform_linux.png" alt="">';
    }
    html += '</div>';
    html += '</div></div></a></div>'
    swiper.append(html);
});