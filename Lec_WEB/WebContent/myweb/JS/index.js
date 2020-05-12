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
      },
      loop: true,
    //   autoplay: {
    //     delay: 2000,
    //     disableOnInteraction: false
    //   },
    })
  });