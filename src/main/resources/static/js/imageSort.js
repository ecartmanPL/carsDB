$( function() {
    $( "#sortable" ).sortable({
      update: function (event, ui) {
        var data = $(this).sortable('serialize');
        console.log( "Sample of data:", data);
        $("#wynik").text(data);
        // POST to server using $.post or $.ajax
        $.ajax({
            data: 'abcdef',
            type: 'POST',
            url: 'http://127.0.0.1'
        });
      }
    });
});