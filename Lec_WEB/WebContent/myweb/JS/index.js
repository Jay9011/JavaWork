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
        var html = `<img id="previmg" src="${$(this).attr("src")}"/>`;
        $(this).css({"opacity": "0.5"});
        imgViewer.append(html);
      }, function(){
        var imgViewer = $(this).parents("a").find(".big_thum");
        imgViewer.empty();
        $(this).css({"opacity": "1"});
      });
  });