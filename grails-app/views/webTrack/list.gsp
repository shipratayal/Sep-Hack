<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="user"/>
    <title></title>
</head>

<body>
<div class="container-fluid content">
    <div class="row">

        <g:render template="/user/navigation"/>

        <div class="col-md-10 col-sm-11 main ">
            <div class="panel panel-primary">
                <div class="panel-heading">Tracking Events</div>

                <div class="panel-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Username</th>
                            <th>Event Type</th>
                            <th>URL</th>

                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${eventList}" var="event" status="i">
                            <tr>
                                <th scope="row">${i + 1}</th>
                                <td>${event.firstName}</td>
                                <td>${event.lastName}</td>
                                <td>${event.userEmailId}</td>
                                <td>${event.eventType}</td>
                                <td>${event.url}</td>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>