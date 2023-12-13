package com.lzjtuimis.controller.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lzjtuimis.pojo.Question;

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Question> questions = new ArrayList<>();

        // 连接数据库
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/computernet?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "root";
            String password = "mysql2022!";
            Connection conn = DriverManager.getConnection(url, user, password);

            // 查询问题列表
            String sql = "SELECT id, question, time, answer FROM question";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setTime(rs.getString("time"));
                question.setAnswer(rs.getString("answer"));

                questions.add(question);
            }

            // 关闭连接
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.print("[]"); // 返回空数组
            return;
        }

        // 返回问题列表
        Gson gson = new Gson();
        out.print(gson.toJson(questions));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String answer = request.getParameter("answer");

        // 更新回答
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/computernet?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "root";
            String password = "mysql2022!";
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "UPDATE question SET answer=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, answer);
            pstmt.setInt(2, Integer.parseInt(id));
            int result = pstmt.executeUpdate();

            // 关闭连接
            pstmt.close();
            conn.close();

            if (result > 0) {
                response.getWriter().print("success");
            } else {
                response.getWriter().print("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("fail");
        }
    }

}