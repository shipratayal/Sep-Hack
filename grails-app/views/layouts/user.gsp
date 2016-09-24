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
    <!-- start Mixpanel --><script type="text/javascript">(function (e, a) {
    if (!a.__SV) {
        var b = window;
        try {
            var c, l, i, j = b.location, g = j.hash;
            c = function (a, b) {
                return (l = a.match(RegExp(b + "=([^&]*)"))) ? l[1] : null
            };
            g && c(g, "state") && (i = JSON.parse(decodeURIComponent(c(g, "state"))), "mpeditor" === i.action && (b.sessionStorage.setItem("_mpcehash", g), history.replaceState(i.desiredHash || "", e.title, j.pathname + j.search)))
        } catch (m) {
        }
        var k, h;
        window.mixpanel = a;
        a._i = [];
        a.init = function (b, c, f) {
            function e(b, a) {
                var c = a.split(".");
                2 == c.length && (b = b[c[0]], a = c[1]);
                b[a] = function () {
                    b.push([a].concat(Array.prototype.slice.call(arguments,
                            0)))
                }
            }

            var d = a;
            "undefined" !== typeof f ? d = a[f] = [] : f = "mixpanel";
            d.people = d.people || [];
            d.toString = function (b) {
                var a = "mixpanel";
                "mixpanel" !== f && (a += "." + f);
                b || (a += " (stub)");
                return a
            };
            d.people.toString = function () {
                return d.toString(1) + ".people (stub)"
            };
            k = "disable time_event track track_pageview track_links track_forms register register_once alias unregister identify name_tag set_config reset people.set people.set_once people.increment people.append people.union people.track_charge people.clear_charges people.delete_user".split(" ");
            for (h = 0; h < k.length; h++)e(d, k[h]);
            a._i.push([b, c, f])
        };
        a.__SV = 1.2;
        b = e.createElement("script");
        b.type = "text/javascript";
        b.async = !0;
        b.src = "undefined" !== typeof MIXPANEL_CUSTOM_LIB_URL ? MIXPANEL_CUSTOM_LIB_URL : "file:" === e.location.protocol && "//cdn.mxpnl.com/libs/mixpanel-2-latest.min.js".match(/^\/\//) ? "https://cdn.mxpnl.com/libs/mixpanel-2-latest.min.js" : "//cdn.mxpnl.com/libs/mixpanel-2-latest.min.js";
        c = e.getElementsByTagName("script")[0];
        c.parentNode.insertBefore(b, c)
    }
})(document, window.mixpanel || []);
mixpanel.init("fe6e0511e774af4eb3fc8fd76dd0bcb5");</script><!-- end Mixpanel -->
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

    mixpanel.identify("${user?.id}");
    mixpanel.people.set({
        "$first_name": "${user?.firstName}",
        "$last_name": "${user?.lastName}",
        "$email": "${user?.username}"
    });



</script>
</body>
</html>