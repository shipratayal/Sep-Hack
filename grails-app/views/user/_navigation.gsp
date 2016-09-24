<div class="sidebar col-md-2 col-sm-1 ">

    <div class="sidebar-collapse collapse">

        <div class="nav-sidebar title"><span>Main Menu</span></div>

        <ul class="nav nav-sidebar">

            <li><a href="index.html"><i class="fa fa-bar-chart-o"></i><span
                    class="hidden-sm text">Dashboard</span></a></li>

            <li>
                <a class="dropmenu" href="index.html#"><i class="fa fa-eye"></i><span
                        class="hidden-sm text">UI Features</span> <span class="chevron closed"></span></a>
                <ul>
                    <li><a class="submenu" href="ui-sliders-progress.html"><i class="fa fa-eye"></i><span
                            class="hidden-sm text">Sliders & Progress</span></a></li>
                    <li><a class="submenu" href="ui-nestable-list.html"><i class="fa fa-eye"></i><span
                            class="hidden-sm text">Nestable Lists</span></a></li>
                    <li><a class="submenu" href="ui-elements.html"><i class="fa fa-eye"></i><span
                            class="hidden-sm text">Elements</span></a></li>
                    <li><a class="submenu" href="ui-panels.html"><i class="fa fa-eye"></i><span
                            class="hidden-sm text">Panels</span></a></li>
                    <li><a class="submenu" href="ui-buttons.html"><i class="fa fa-eye"></i><span
                            class="hidden-sm text">Buttons</span></a></li>
                </ul>
            </li>
            <li><a href="${createLink(action: 'index', controller: 'repository')}" id="repo"><i
                    class="fa fa-eye"></i><span
                    class="hidden-sm text">Repository</span></a></li>
            <li><g:link action="list" controller="webTrack"><i class="fa fa-eye"></i><span
                    class="hidden-sm text">Tracking Event</span></g:link></li>
            <li><g:link action="userList" controller="webTrack"><i class="fa fa-eye"></i><span
                    class="hidden-sm text">Track User</span></g:link></li>

        </ul>

    </div>
    <a href="javascript:void(0)" id="main-menu-min" class="full visible-md visible-lg"><i
            class="fa fa-angle-double-left"></i></a>
</div>
<script>
    mixpanel.track_links("#repo", "link event", {
        id: "Repository",
        "userId": "${user?.id}",
        "first_name": "${user?.firstName}",
        "last_name": "${user?.lastName}",
        "email": "${user?.username}"
    });
</script>
