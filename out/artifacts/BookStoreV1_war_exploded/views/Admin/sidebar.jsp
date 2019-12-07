<nav id="sidebar" class="sidebar-wrapper">
    <div class="sidebar-content">
        <div class="sidebar-header">
            <div class="user-pic">
                <img class="img-responsive img-rounded" src="https://raw.githubusercontent.com/azouaoui-med/pro-sidebar-template/gh-pages/src/img/user.jpg"
                     alt="User picture">
            </div>
            <div class="user-info">
          <span class="user-name">Admin
          </span>
                <span class="user-role">Administrator</span>
                <span class="user-status">
            <i class="fa fa-circle"></i>
            <form action="logout" method="post">
                <input type="submit" value="Logout" class="inputLogout">
            </form>

          </span>
            </div>
        </div>
        <!-- sidebar-header  -->

        <div class="sidebar-menu">
            <ul>
                <li>
                    <a href="admin">
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="sidebar-dropdown">
                    <a href="#">
                        <span>Admin</span>
                    </a>
                    <div class="sidebar-submenu">
                        <ul>
                            <li>
                                <a href="#">List</a>
                            </li>
                            <li>
                                <a href="#">Add</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li class="sidebar-dropdown">
                    <a href="#">
                        <span>Books</span>
                    </a>
                    <div class="sidebar-submenu">
                        <ul>
                            <li>
                                <a href="QLBook">List</a>
                            </li>
                            <li>
                                <a href="QLAddBook">Add</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li class="sidebar-dropdown">
                    <a href="#">
                        <span>Categories</span>
                    </a>
                    <div class="sidebar-submenu">
                        <ul>
                            <li>
                                <a href="QLCategory">List</a>
                            </li>
                            <li>
                                <a href="QLAddCategory">Add</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li class="sidebar-dropdown">
                    <a href="#">
                        <span>User</span>
                    </a>
                    <div class="sidebar-submenu">
                        <ul>
                            <li>
                                <a href="QLUser">List</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li class="sidebar-dropdown">
                    <a href="#">
                        <span>Orders</span>
                    </a>
                    <div class="sidebar-submenu">
                        <ul>
                            <li>
                                <a href="#">List</a>
                            </li>
                            <li>
                                <a href="#">Add</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="index.jsp">
                        <span>View Store</span>
                    </a>
                </li>

            </ul>
        </div>
        <!-- sidebar-menu  -->
    </div>
    <!-- sidebar-content  -->
</nav>