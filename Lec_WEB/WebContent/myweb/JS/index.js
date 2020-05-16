$(document).ready(function () {
      var mySwiper = new Swiper ('.swiper-container', {
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
          delay: 5000,
          disableOnInteraction: false
        },
      })

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
      
      $("#gameList #listLeft .item").hover(function(){
          var itemId = $(this).attr("id");
          var imgViewer = $("#preview .preview").children('img');
          $(this).addClass("selected");
          $(this).siblings().removeClass("selected");

          $.getJSON('./json/news.json', function(data){
            var $items = data.rgAppData;
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
      });
  });