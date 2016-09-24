<%@ page import="com.nexthoughts.stuff.Label; com.User" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.nexthoughts.issuetracker.Repository" %>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome !!</title>
</head>

<body>
<div class="row page-todo">

    <div class="col-sm-7 tasks">

        <div class="task-list">
            <h1>Tasks</h1>

            <div class="priority high"><span>high priority</span></div>

            <div class="task high">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="task high">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="task high">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="task high last">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="priority medium"><span>medium priority</span></div>

            <div class="task medium">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="task medium last">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="priority low"><span>low priority</span></div>

            <div class="task low">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="task low">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="task low">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="task low">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="task low">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="task low">
                <div class="desc">
                    <div class="title">Lorem Ipsum</div>

                    <div>Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit</div>
                </div>

                <div class="time">
                    <div class="date">Jun 1, 2012</div>

                    <div>1 day</div>
                </div>
            </div>

            <div class="clearfix"></div>

        </div>

    </div><!--/col-->

    <div class="col-sm-5">

        <div class="graph">
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <h1>Repositories</h1>

            <div class="timeline">
                <div id="list-repository" class="content scaffold-list" role="main">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <util:remoteSortableColumn property="name"
                                                       title="${message(code: 'name.label', default: 'Name')}"
                                                       update="list-repository" action="filter"/>
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${repositoryInstanceList}" status="i" var="repositoryInstance">
                            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                                <td>
                                    <a href="${createLink(controller: 'repository', action: 'showTickets')}"
                                       id="${repositoryInstance.id}">
                                        ${fieldValue(bean: repositoryInstance, field: "name")}
                                    </a>
                                </td>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>

                    <util:remotePaginate controller="repository" action="filter" total="${Repository.count()}"
                                         update="list-repository" max="20"
                                         pageSizes="[10: '10 Per Page', 20: '20 Per Page', 50: '50 Per Page', 100: '100 Per Page']"/>

                </div>
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
</html>