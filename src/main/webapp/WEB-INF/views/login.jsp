<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style type="text/css">
        * {
            padding: 0;
            margin: 0;
        }
        .top {
            height: 100px;
            background-color: skyblue;
        }
        .content {
            height: 750px;
            background-color: deepskyblue;
        }
        .bottom {
            height: 100px;
            background-color: lightskyblue;
        }
        .login {
            float: right;
            padding-top: 300px;
            padding-right: 250px;

        }
        .username {
            height: 25px;
            text-align: center;
            font-size: 16px;
            padding-bottom: 15px;
        }
        .password {
            height: 25px;
            text-align: center;
            font-size: 16px;
            padding-bottom: 15px;
        }
        .btn {
            height: 25px;
            text-align: center;
            font-size: 16px;
        }
        .itxt {
            float: left;
            display: block;
            height: 25px;
        }
        .lcf {
            display: block;
            float: left;
        }
        .btn {
            padding-left: 120px;
        }
        .username .itxt {
            margin-left: 3px;
        }
    </style>
</head>
<body>

<div class="top"></div>
<div class="content">
    <div class="login">
        <form action="login.do" method="post">
            <div class="username">
                <label class="lcf"><span>用户名：</span></label>
                <input class="itxt" type="text" name="username"/>
            </div>
            <div class="password">
                <label class="lcf"><span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span></label>
                <input class="itxt" type="password" name="password"/>
            </div>
            <div id="btn" class="btn">
                <input class="itxt" type="submit" value="&nbsp;登&nbsp;&nbsp;录&nbsp;">
            </div>
        </form>
    </div>
</div>
<div class="bottom"></div>
</body>
</html>
