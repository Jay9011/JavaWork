$(function(){
  var mySwiper;
  function startSwiper() {
      mySwiper = new Swiper ('.swiper-container', {
        direction: 'horizontal',
        navigation: {
          prevEl: '.swiper-button-prev',
          nextEl: '.swiper-button-next',
        },
        pagination: {
          el: '.swiper-pagination',
          type: 'bullets',
          clickable: true
        },
        loop: true,
        autoplay: {
          delay: 3000,
          disableOnInteraction: false
        },
        spaceBetween: 5
      });
  }
  function swiper_screenshot(){
      $("#swiper_wraper .screenshot img").hover(function(){
        var imgViewer = $(this).parents("a").find(".big_thum");
        var html = '<img id="previmg" src="' + $(this).attr("src") + '"/>';
        $(this).css({"opacity": "0.5"});
        imgViewer.append(html);
      }, function(){
        var imgViewer = $(this).parents("a").find(".big_thum");
        imgViewer.empty();
        $(this).css({"opacity": "1"});
      });
    }
  // swiper 에 값 넣기
  $.getJSON('json/notice.json', function(data){
      var $items = data.notice;
      var swiper = $(".swiper-wrapper");
      // txt = $items[1147560].name;
      
      for(i = 0; i < $items.length; i++){
        var html = '<div class="swiper-slide">';
        html += '<a href="' + $items[i].url + '"><div class="big_thum" style="background-image: url(' + $items[i].regular_thumbnail + ')"></div>'
        + '<div class="appname">' + $items[i].name + '</div><div class="info"><div class="screenshot">';
        for(j = 0; j < $items[i].preview.length; j++){
            html += '<div><img src="' + $items[i].preview[j] + '" alt=""></div>';
        }
        html += '</div>'
        html += '<div class="tags">'
        for(j = 0; j < $items[i].tags.length; j++){
            html += '<div class="tag">' + $items[i].tags[j] + '</div>';
        }
        html += '</div>';
        if($items[i].discount) {
            html += '<div class="reason"><div class="default" style="color:#a4d007; font-weight: bold;">할인 행사중!!!</div></div>';
        } else if($items[i].early_access){
            html += '<div class="reason"><div class="default">앞서 해보기</div></div>';
        } else {
            html += '<div class="reason"><div class="default">판매중</div></div>';
        }
        html += '<div class="addition"><div class="price">';
        if($items[i].discount){
            html += $items[i].discount_block;
        } else {
            html += $items[i].price;
        }
        html += '</div>';
        html += '<div class="platforms">';
        
        if($items[i].os_windows){
            html += '<img src="images/icon_platform_win.png" alt="">'
        }
        if($items[i].os_macos){
            html += '<img src="images/icon_platform_mac.png" alt="">';
        }
        if($items[i].os_linux){
            html += '<img src="images/icon_platform_linux.png" alt="">';
        }
        html += '</div>';
        html += '</div></div></a></div>'
        swiper.append(html);
      }
      swiper_screenshot();
      startSwiper();
      // mySwiper.update();
  });

})