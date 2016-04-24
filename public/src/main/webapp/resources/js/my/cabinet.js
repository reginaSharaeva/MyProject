/**
 * Created by Регина on 24.04.2016.
 */
$(document).ready(function() {

    $(document).on('click', '.js_removeOrder', function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/cabinet/removeOrder',
            data: {"orderId": $this.data('id')},
            success: function (data) {  // успешное завершение работы
                $("#main").empty().append(data);
            },
            error: function () {    // На сервере произошла ошибка
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });
    });
});

