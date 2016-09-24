<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome !!</title>
</head>

<body>
<div class="container-fluid content">
    <div class="row">

        <g:render template="navigation" model="[user: user]"/>

        <div class="col-md-10 col-sm-11 main ">

        </div>
    </div>

</div>

</body>
<script>
    mixpanel.identify("${user?.id}");
    mixpanel.people.set({
        "$first_name": "${user?.firstName}",
        "$last_name": "${user?.lastName}",
        "$email": "${user?.username}"
    });

</script>
</html>