$("Document").ready(function ()
{
    $("#title").keyup(function ()
    {
        if ($(this).val().length > 0)
        {

            $.ajax
            (
                {
                    type: 'get',
                    url: 'http://localhost/SMF1/web/app_dev.php/json/' + $(this).val(),
                    async: false,

                    success:function(response)
                    {
                        $("#test").html(response);

                    }
                }
            )
        }
    });
});