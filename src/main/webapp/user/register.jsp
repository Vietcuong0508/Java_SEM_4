<%@ page import="com.example.t2009m1java.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%
    List<Student> students = (List<Student>) request.getAttribute("list");
    if (students == null) {
        students = new ArrayList<>();
    }
%>
<html>
<head>
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.0.0/mdb.min.css" rel="stylesheet"/>
    <!-- MDB -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.0.0/mdb.min.js"></script>
    <title>Title</title>
</head>
<body>
<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

<%--                                <ul>--%>
<%--                                    <%for (int i = 0; i < students.size(); i++) {--%>
<%--                                            Student student = students.get(i);%>--%>
<%--                                    <li><%=student.getFullName()%> - <%=student.getRollNumber()%></li>--%>
<%--                                    <%}%>--%>
<%--                                </ul>--%>

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                                <form action="/register" method="post" class="mx-1 mx-md-4">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="form3Example1c" class="form-control" name="username"/>
                                            <label class="form-label" for="form3Example1c">User Name</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="email" id="form3Example3c" class="form-control" name="email"/>
                                            <label class="form-label" for="form3Example3c">Your Email</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="password" id="form3Example4c" class="form-control" name="password"/>
                                            <label class="form-label" for="form3Example4c">Password</label>
                                        </div>
                                    </div>

<%--                                    <div class="d-flex flex-row align-items-center mb-4">--%>
<%--                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>--%>
<%--                                        <div class="form-outline flex-fill mb-0">--%>
<%--                                            <input type="password" id="form3Example4cd" class="form-control" name="confirmPassword"/>--%>
<%--                                            <label class="form-label" for="form3Example4cd">Repeat your password</label>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="form3Example5c" class="form-control" name="fullName"/>
                                            <label class="form-label" for="form3Example5c">Full Name</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-mobile-alt fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="form3Example6c" class="form-control" name="phone"/>
                                            <label class="form-label" for="form3Example6c">Phone</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-calendar-alt fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="date" id="form3Example7c" class="form-control" name="birthday"/>
                                            <label class="form-label" for="form3Example7c">Birthday</label>
                                        </div>
                                    </div>

<%--                                    <div class="form-check d-flex justify-content-center mb-5">--%>
<%--                                        <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />--%>
<%--                                        <label class="form-check-label" for="form2Example3c">--%>
<%--                                            I agree all statements in <a href="#!">Terms of service</a>--%>
<%--                                        </label>--%>
<%--                                    </div>--%>

                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Register</button>
                                    </div>

                                </form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
