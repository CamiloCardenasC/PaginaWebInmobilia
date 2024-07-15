$(window).load(function () { 
    // Asegura que todo el sitio esté cargado
    $('#status').fadeOut(); // Se desvanece la animación de carga
    $('#preloader').delay(350).fadeOut('slow'); // Se desvanece el DIV blanco que cubre el sitio
    $('body').delay(350).css({'overflow': 'visible'});
});

$(document).ready(function () {
    // Inicialización de iCheck
    $('input').iCheck({
        checkboxClass: 'icheckbox_square-yellow',
        radioClass: 'iradio_square-yellow',
        increaseArea: '20%' // opcional
    });

    // Cambio de disposición de la lista
    $('.layout-grid').on('click', function () {
        $('.layout-grid').addClass('active');
        $('.layout-list').removeClass('active');
        $('#list-type').removeClass('proerty-th-list').addClass('proerty-th');
    });

    $('.layout-list').on('click', function () {
        $('.layout-grid').removeClass('active');
        $('.layout-list').addClass('active');
        $('#list-type').removeClass('proerty-th').addClass('proerty-th-list');
    });

    // Configuración de Owl Carousel
    $("#bg-slider").owlCarousel({
        navigation: false,
        slideSpeed: 100,
        autoPlay: 5000,
        paginationSpeed: 100,
        singleItem: true,
        mouseDrag: false,
        transitionStyle: "fade"
    });
    $("#prop-smlr-slide_0, #testimonial-slider").owlCarousel({
        navigation: false,
        slideSpeed: 100,
        pagination: true,
        paginationSpeed: 100,
        items: 3
    });

    // Inicialización de sliders
    $('#price-range, #property-geo, #min-baths, #min-bed').slider();

    var RGBChange = function () {
        $('#RGB').css('background', '#FDC600');
    };

    // Toggle de búsqueda avanzada
    var $SearchToggle = $('.search-form .search-toggle');
    $SearchToggle.hide();
    $('.search-form .toggle-btn').on('click', function (e) {
        e.preventDefault();
        $SearchToggle.slideToggle(300);
    });

    // Contadores
    setTimeout(function () {
        $('#counter, #counter1, #counter2, #counter3').text('0');
        setInterval(function () {
            var curval = parseInt($('#counter').text());
            var curval1 = parseInt($('#counter1').text().replace(' ', ''));
            var curval2 = parseInt($('#counter2').text());
            var curval3 = parseInt($('#counter3').text());
            if (curval <= 1007) {
                $('#counter').text(curval + 1);
            }
            if (curval1 <= 1280) {
                $('#counter1').text(sdf_FTS((curval1 + 20), 0, ' '));
            }
            if (curval2 <= 145) {
                $('#counter2').text(curval2 + 1);
            }
            if (curval3 <= 1022) {
                $('#counter3').text(curval3 + 1);
            }
        }, 2);
    }, 500);

    function sdf_FTS(_number, _decimal, _separator) {
        var decimal = (typeof (_decimal) != 'undefined') ? _decimal : 2;
        var separator = (typeof (_separator) != 'undefined') ? _separator : '';
        var r = parseFloat(_number);
        var exp10 = Math.pow(10, decimal);
        r = Math.round(r * exp10) / exp10;
        var rr = Number(r).toFixed(decimal).toString().split('.');
        var b = rr[0].replace(/(\d{1,3}(?=(\d{3})+(?:\.\d|\b)))/g, "$1" + separator);
        r = (rr[1] ? b + '.' + rr[1] : b);
        return r;
    }

    // Inicialización de WOW.JS
    new WOW().init();
});
