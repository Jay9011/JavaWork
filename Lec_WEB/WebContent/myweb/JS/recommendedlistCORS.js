var counter = 0;
function addList(){
    var items = recommandJson.recommend;
    var gameList = $("#gameList2 #listLeft");
    var html = "";
    
    for(index = 0; index < 15; index++){
        if(items.length - 1 < counter){
            break;
        }
        html = '<a id="' + items[counter].id + '" class="item" href="' + items[counter].url + '">';
        html += '<div class="item_thum"><img class="item_thum_img" src="' + items[counter].regular_thumbnail + '"></div>';
        html += '<div class="item_content"><div class="item_name">' + items[counter].name + '</div>';
        html += '<div class="item_tags">';
        for(i = 0; i < items[counter].tags.length; i++){
            if(i == 0){
                html += '<span class="tag">' + items[counter].tags[i] + '</span>';
            } else {
                html += '<span class="tag">,' + items[counter].tags[i] + '</span>';
            }
        }
        html += '</div>';
        html += '<div class="platforms">'
        if(items[counter].os_windows){
            html += '<img src="images/icon_platform_win.png" alt="">'
        }
        if(items[counter].os_macos){
            html += '<img src="images/icon_platform_mac.png" alt="">';
        }
        if(items[counter].os_linux){
            html += '<img src="images/icon_platform_linux.png" alt="">';
        }
        html += '</div></div>';
        html += '<div class="price">';
        if(items[counter].discount){
            html += items[counter].discount_block;
        } else {
            html += '<div class="discount_block"><div class="discount_pct"></div><div class="clear"></div><div class="discount_prices"><div class="discount_original_price"></div><div class="clear"></div>';
            html += items[counter].price;
        }                
        html +=  '</div></div></div><div class="clear"></div></a>';
        gameList.append(html);
        counter++;
    }
}
addList();