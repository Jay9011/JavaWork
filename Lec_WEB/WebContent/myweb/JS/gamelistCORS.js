function gameListPrev(){
    $("#gameList #listLeft .item").hover(function(){
        var itemId = $(this).attr("id");
        var imgViewer = $("#preview .preview").children('img');
        $(this).addClass("selected");
        $(this).siblings().removeClass("selected");
  
        var $items = datasJson.rgAppData;
        var thisObject = $items[itemId];
        var imgs = thisObject.preview;
        $.each(imgViewer, function(index, item){
          item.src = imgs[index];
        });
        var recommend = thisObject.recommand;
        if(thisObject.value > 3){
          $("#evaluation").css("color","#30acff").text(recommend);
        }else if(thisObject.value = 2){
          $("#evaluation").css("color","#B9A074").text(recommend);
        }else {
          $("#evaluation").css("color","#A34C25").text(recommend);
        }
    });
  }
    var $items = newsJson.news;
    var gameList = $("#gameList #listLeft");
    for(i = 0; i < $items.length; i++){
        var html = '<a id="' + $items[i].id + '" class="item" href="' + $items[i].url + '">';
        html += '<div class="item_thum"><img class="item_thum_img" src="' + $items[i].regular_thumbnail + '"></div>';
        html += '<div class="item_content"><div class="item_name">' + $items[i].name + '</div>';
        html += '<div class="item_tags">';
        for(j = 0; j < $items[i].tags.length; j++){
            if(j == 0){
                html += '<span class="tag">' + $items[i].tags[j] + '</span>';
            } else {
                html += '<span class="tag">,' + $items[i].tags[j] + '</span>';
            }
        }
        html += '</div>';
        html += '<div class="platforms">'
        if($items[i].os_windows){
            html += '<img src="images/icon_platform_win.png" alt="">'
        }
        if($items[i].os_macos){
            html += '<img src="images/icon_platform_mac.png" alt="">';
        }
        if($items[i].os_linux){
            html += '<img src="images/icon_platform_linux.png" alt="">';
        }
        html += '</div></div>';
        html += '<div class="price">';
        if($items[i].discount){
            html += $items[i].discount_block;
        } else {
            html += '<div class="discount_block"><div class="discount_pct"></div><div class="clear"></div><div class="discount_prices"><div class="discount_original_price"></div><div class="clear"></div>';
            html += $items[i].price;
        }                
        html += '</div></div></div><div class="clear"></div></a>';
        gameList.append(html);
    }
    gameListPrev();
