<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Video Player</title>
<style type="text/css">
        body {
        margin:0;
        padding:0;
        }

        /* 导航栏样式 */
        nav {
        background-color: #333;
        position: fixed;
        top: 0;
        left: 0;
        width: 200px;
        height: 100%;
        }

        nav ul {
        list-style: none;
        padding: 0;
        margin: 0;
        }

        nav li {
        padding: 20px;
        cursor: pointer;
        color: #fff;
        font-size: 20px;
        text-align: center;
        }

        nav li:hover {
        background-color: #555;
        }

        /* 播放器样式 */
        #player {
        text-align: center;
        margin: 50px auto;
        width: 800px;
        height: 450px;
        position: absolute;
        top: 45%;
        left: 50%;
        transform: translate(-50%, -50%);
        }

        #video {
        width: 100%;
        height: 100%;
        outline: none;
        }
</style>
<script>
        var video = document.getElementById("video");
        function playVideo() {
            video.src = "VideoServlet"; // 设置视频源
            video.play(); // 播放视频
        }
</script>
</head>
<body>
    <nav>
    <ul>
        <li onclick="playVideo()">播放视频</li>
        <li>菜单选项2</li>
        <li>菜单选项3</li>
    </ul>
    </nav>

    <div id="player">
        <video id="video" controls="">
            <source src="" type="video/mp4" />
        </video>
    </div>
</body>
</html>