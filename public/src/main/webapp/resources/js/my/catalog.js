/**
 * Created by Регина
 * on 16.03.2016.
 */
$(document).ready(function() {

    $('#categoryFilter').on('change', function() {
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: '/catalog/filter',
            data: {"categoryId": $this.val()},
            success: function (data) {  // успешное завершение работы
                console.log(data);
                $("#catalogContent").empty().append(data);
            },
            error: function () {    // На сервере произошла ошибка
                alert('Приносим извинения.<br/>На сервере произошла ошибка');
            }
        });

    })
});