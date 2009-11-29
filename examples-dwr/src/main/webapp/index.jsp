<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Hello world!</title>
        <script type="text/javascript" src="jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="dwr/interface/Greeting.js"></script>
        <script type='text/javascript' src="dwr/engine.js"></script>
        <script type="text/javascript">
            $(function() {
                $('#greet').click(function() {
                    $('#greeting').fadeOut(500);
                    var name = $('#name').val();
                    Greeting.greet(name, function(data) {
                        setTimeout(function() {
                            $('#greeting').text(data);
                            $('#greeting').fadeIn(500);
                        }, 1000);
                    });
                    return false;
                });
            });
        </script>
    </head>
    <body>
        <h1>Hello world!</h1>
        <form action="hello">
            <p>
                <label for="name">Your name:</label> <input type="text" id="name" name="name" /><br />
                <input type="submit" value="Greet!" id="greet" />
            </p>
        </form>
        <p id="greeting"></p>
    </body>
</html>