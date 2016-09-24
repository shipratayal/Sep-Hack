<div class="navbar" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar">a</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${createLink(uri: '/')}">
                <asset:image src="theme/img/logo.png"/> cleverAdmin</a>
        </div>
        <ul class="nav navbar-nav navbar-actions navbar-left">
            <li><a href="${createLink(uri: '/')}" id="main-menu-toggle"><i class="fa fa-bars"></i></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="${createLink(uri: '/')}" class="dropdown-toggle avatar" data-toggle="dropdown"><asset:image
                        src="theme/img/avatar.jpg"/><span class="badge"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${createLink(controller: 'logout', action: 'index')}"><i
                            class="fa fa-lock"></i> Logout</a></li>
                </ul>
            </li>
            <li><a href="${createLink(uri: '/')}"><i class="fa fa-bars"></i></a></li>
        </ul>

        <g:render template="/search"/>
    </div>
</div>