// swiper 에 값 넣기
$.getJSON('./json/news.json', function(data){
    var $items = data.rgAppData;
    var gameList = $("#gameList #listLeft");
    var count = 0;
    $.each($items, function(index, item){
        var html = '<a id="' + index + '" class="item" href="' + item.url + '">';
        html += '<div class="item_thum"><img class="item_thum_img" src="' + item.regular_thumbnail + '"></div>';
        html += '<div class="item_content"><div class="item_name">' + item.name + '</div>';
        html += '<div class="item_tags">';
        for(i = 0; i < item.tags.length; i++){
            if(i == 0){
                html += '<span class="tag">' + item.tags[i] + '</span>';
            } else {
                html += '<span class="tag">,' + item.tags[i] + '</span>';
            }
        }
        html += '</div>';
        html += '<div class="platforms">'
        if(item.os_windows){
            html += '<img src="images/icon_platform_win.png" alt="">'
        }
        if(item.os_macos){
            html += '<img src="images/icon_platform_mac.png" alt="">';
        }
        if(item.os_linux){
            html += '<img src="images/icon_platform_linux.png" alt="">';
        }
        html += '</div></div>';
        html += '<div class="price">';
        if(item.discount){
            html += item.discount_block;
        } else {
            html += '<div class="discount_block"><div class="discount_pct"></div><div class="clear"></div><div class="discount_prices"><div class="discount_original_price"></div><div class="clear"></div>';
            html += item.price;
        }                
        html +=  '</div></div></div><div class="clear"></div></a>';
        gameList.append(html);
        count++;
        if(count < 10) return;
    });
});
