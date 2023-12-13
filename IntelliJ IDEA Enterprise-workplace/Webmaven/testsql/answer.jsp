<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<html>
<head>
<meta charset="UTF-8">
<title>问题列表</title>
<style>
    table {
            border-collapse: collapse;
            width: 100%;
            }

            th,
            td {
            padding: 8px;
            text-align: left;
            vertical-align: middle;
            border: 1px solid #ddd;
            }

            th {
            background-color: #f2f2f2;
            }

            input[type="text"] {
            width: 100%;
            }

            .submit {
            background-color: #007bff;
            color: white;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            }

            .submit:hover {
            background-color: blue;
            }
            #grid-container1{
            grid-template-columns: repeat(2, 1fr);
            grid-gap: 20px;
            padding: 20px;
            }
            .grid-item {
            width: 80%;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 3px 5px rgba(0,0,0,0.2);
            }
</style>
</head>
<body>
<!--问题解答-->
<div id="grid-container1">
<div class="grid-item">
<h2>学生问题答疑质疑</h2>
</div>

<table id="question-table">
<thead>
<tr>
<th>ID号</th>
<th>问题</th>
<th>提问时间</th>
<th>回答</th>
<th>操作</th>
</tr>
</thead>
<tbody>
</tbody>
</table>
</div>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
		$(document).ready(function() {
                $.ajax({
                url: "QuestionServlet",
                type: "GET",
                dataType: "json",
                success: function(data) {
                var tbody = $("#question-table tbody");
                for (var i = 0; i < data.length; i++) {
        var tr = $("<tr></tr>");
        tr.append($("<td>" + data[i].id + "</td>"));
        tr.append($("<td>" + data[i].question + "</td>"));
        tr.append($("<td>" + data[i].time + "</td>"));
        tr.append($("<td><input type='text' value='" + data[i].answer + "'></td>"));
        tr.append($("<td><button class='submit'>提交</button></td>"));
        tbody.append(tr);
        }
        },
        error: function() {
        alert("获取问题列表失败");
        }
        });

        // 提交按钮点击事件
        $("#question-table tbody").on("click", ".submit", function() {
        var tr = $(this).closest("tr");
        var id = tr.find("td:eq(0)").text();
        var answer = tr.find("td:eq(3) input").val();

        $.ajax({
        url: "QuestionServlet",
        type: "POST",
        data: {
        id: id,
        answer: answer
        },
        success: function(data) {
        alert("回答提交成功");
        },
        error: function() {
        alert("回答提交失败");
        }
        });
        });
        });
</script>
</body>
</html>