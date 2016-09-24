<%@ page import="com.nexthoughts.stuff.Label; com.User" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.nexthoughts.issuetracker.Repository" %>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome !!</title>
</head>

<body>
<br/>

<div class="row page-todo">
    <div class="col-sm-6">

        <div class="graph">
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>

            <g:link controller="team" action="createTeam">Create Team</g:link>

            <h1>Notifications</h1>

            <div class="timeslot">

                <div class="task">
                    <span>
                        <span class="type">appointment</span>
                        <span class="details">
                            Lukasz Holeczek at creativeLabs HQ
                        </span>
                        <span>
                            remaining time
                            <span class="remaining">
                                3h 38m 15s
                            </span>
                        </span>
                    </span>

                    <div class="arrow"></div>
                </div>

                <div class="icon">
                    <i class="fa fa-map-marker"></i>
                </div>

                <div class="time">
                    3:43 PM
                </div>

            </div>

            <div class="clearfix"></div>
        </div>
    </div>

    <div class="col-sm-6 tasks">

        <div class="task-list">
            <h1>Repository</h1>

            <g:each in="${repositoryInstanceList}" status="i" var="repositoryInstance">

                <div class="task high ${i == repositoryInstanceList?.size() ? "last" : ""}">
                    <div class="desc">
                        <div class="title">
                            <a href="${createLink(controller: 'issue', action: 'showTickets', id: repositoryInstance?.id)}">
                                ${fieldValue(bean: repositoryInstance, field: "name")}
                            </a>
                        </div>

                        <div>${repositoryInstance?.description}</div>
                    </div>

                    <div class="time">
                        <div class="date">${repositoryInstance?.dateCreated}</div>
                    </div>
                </div>
            </g:each>
            <div class="clearfix"></div>
        </div>
    </div>

</div>

<script>
    function selectAll(checkbox) {
        var boolean = checkbox.checked;
        if (boolean) {
            $('.loanToBeApproved').prop("checked", true);
        } else {
            $('.loanToBeApproved').prop("checked", false);
        }
    }
</script>
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