<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="CleverAdmin - Bootstrap Admin Template">
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword" content="CleverAdmin, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <title><g:layoutTitle default="cleverAdmin - Bootstrap Admin Template"/></title>
    <g:layoutHead/>
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="toaster.min.css"/>
    <asset:javascript src="application.js"/>
    <link rel="shortcut icon" href="${assetPath(src: 'theme/ico/favicon.png')}" type="image/x-icon">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<g:render template="/topHeader"/>
<div class="container-fluid content">
    <div class="row">

        <g:render template="/user/navigation"/>

        <div class="col-md-10 col-sm-11 main ">
        <g:layoutBody/>
        </div>
    </div>
</div>

<g:render template="/footer"/>
<g:render template="/templates/toastMessages"/>
<script>
    $(document).ready(function () {
        window.setTimeout(function () {
            $("#flashError").fadeTo(500, 0).slideUp(500, function () {
                $(this).remove();
            });
        }, 3000);
    });

    $(document).ready(function () {
        toastr.options.debug = false
        toastr.options.positionClass = 'toast-top-right'
        toastr.options.onclick = null
        toastr.options.fadeIn = 300
        toastr.options.fadeOut = 1000
        toastr.options.timeOut = 8000
        toastr.options.extendedTimeOut = 1000
        toastr.options.preventDuplicates = true;
        toastr.options.closeButton = true;
    })
</script>
</body>
</html>