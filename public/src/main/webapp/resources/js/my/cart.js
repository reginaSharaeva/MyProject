/**
 * Created by Регина on 02.04.2016.
 */

$(document).ready(function() {

    $(document).on('click', '.js_countLess', function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/cart/less',
            data: {"cartId": $this.data('id')},
            success: function (data) {  // успешное завершение работы
                $("#main-block").empty().append(data);
            },
            error: function () {    // На сервере произошла ошибка
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });

    $(document).on('click', '.js_countMore', function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/cart/more',
            data: {"cartId": $this.data('id')},
            success: function (data) {  // успешное завершение работы
                $("#main-block").empty().append(data);
            },
            error: function () {    // На сервере произошла ошибка
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });

    $(document).on('click', '.js_cartRemove', function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/cart/remove',
            data: {"cartId": $this.data('id')},
            success: function (data) {  // успешное завершение работы
                $("#main-block").empty().append(data);
            },
            error: function () {    // На сервере произошла ошибка
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });
});

