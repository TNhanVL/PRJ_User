<%-- Document : main Created on : May 18, 2023, 1:54:36 PM Author : TTNhan --%>

<%@page import="java.util.ArrayList" %>
<%@page import="Model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!-- Main content -->

<div class="container-fluid row">
    <div class="col-md-7">
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-12">
                        <!-- jquery validation -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">${title}</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->

                            <div class="card-body">
                                <table id="usersTable">
                                    <tr>
                                        <th>ID</th>
                                        <th>User Name</th>
                                        <th>Full Name</th>
                                        <th>Password</th>
                                        <th>SomeThing?
                                        <th>
                                    </tr>
                                    <% ArrayList<User> dataList = new ArrayList<>();
                                        dataList = Database.DB.getUsers();
                                        String editID = String.valueOf(request.getAttribute("editID"));
                                        if (editID == null) {
                                            editID = "";
                                        }
                                        for (int i = 0; i < dataList.size(); i++) { %>
                                    <tr>
                                        <td>
                                            <%out.println(dataList.get(i).getID());%>
                                        </td>
                                        <td>
                                            <%out.println(dataList.get(i).getUser_name());%>
                                        </td>
                                        <td>
                                            <%out.println(dataList.get(i).getFull_name());%>
                                        </td>
                                        <td>
                                            <%out.println(dataList.get(i).getPassword());%>
                                        </td>
                                        <td>
                                            <a href="/user/edit?id=<%out.println(dataList.get(i).getID());%>">
                                                <i class="fas fa-solid fa-pen"></i>
                                            </a>
                                            <a href="/user/delete?id=<%out.println(dataList.get(i).getID());%>">
                                                <i class="far fa-trash-alt"
                                                   style="color: #e60a0a;"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <%
                                        if (editID.equals(String.valueOf(dataList.get(i).getID()))) {
                                    %>
                                    <tr><td colspan="5"><form action="edit" method="post" id="editUserForm">
                                                <div class="card-body">
                                                    <div class="form-group" style="display: none">
                                                        <label for="exampleInputEmail1">ID</label>
                                                        <input type="text" class="form-control" id="id"
                                                               name="id" placeholder="User Name" value="<%out.println(dataList.get(i).getID());%>" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">User Name</label>
                                                        <input type="text" class="form-control" id="username"
                                                               name="username" placeholder="User Name" value="<%out.println(dataList.get(i).getUser_name());%>" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputPassword1">Full Name</label>
                                                        <input type="text" class="form-control" id="fullname"
                                                               name="fullname" placeholder="Full Name" value="<%out.println(dataList.get(i).getFull_name());%>" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputPassword1">Password</label>
                                                        <input type="text" class="form-control" id="password"
                                                               name="password" placeholder="Password" value="<%out.println(dataList.get(i).getPassword());%>" required>
                                                    </div>
                                                </div>
                                                <!-- /.card-body -->

                                                <div class="card-footer">
                                                    <button type="submit" class="btn btn-primary">Update</button>
                                                </div>
                                            </form></td></tr>
                                    }
                                    <%}
                                        }%>
                                </table>
                            </div>


                        </div>
                        <!-- /.card -->
                    </div>
                    <!--/.col (left) -->
                    <!--/.col (right) -->
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
    </div>
    <div class="col-md-5">
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-12">
                        <!-- jquery validation -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Add A User</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->

                            <form action="add" method="post" id="addUserForm">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">User Name</label>
                                        <input type="text" class="form-control" id="username"
                                               name="username" placeholder="User Name" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Full Name</label>
                                        <input type="text" class="form-control" id="fullname"
                                               name="fullname" placeholder="Full Name" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input type="password" class="form-control" id="password"
                                               name="password" placeholder="Password" required>
                                    </div>
                                </div>
                                <!-- /.card-body -->

                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </form>


                        </div>
                        <!-- /.card -->
                    </div>
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
    </div>
</div>