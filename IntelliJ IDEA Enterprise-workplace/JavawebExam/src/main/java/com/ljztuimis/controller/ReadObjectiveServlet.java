package com.ljztuimis.controller;

import com.ljztuimis.bean.ObjectiveInfo;
import com.ljztuimis.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ReadObjectiveServlet", value = "/ReadObjectiveServlet")
public class ReadObjectiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "select * from objectiveinfo";
        ResultSet set;
        ObjectiveInfo objectiveInfo;
        ArrayList<ObjectiveInfo> objectiveList = new ArrayList<>();
        try {
            set = JDBCUtils.executeQuery(sql);
            while(set.next()){
                int objectiveId = set.getInt("objectiveid");
                String objectiveContent = set.getString("objectivecontent");
                objectiveInfo = new ObjectiveInfo(objectiveId,objectiveContent);
                objectiveList.add(objectiveInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("objectiveList",objectiveList);
        request.getRequestDispatcher("modifyObjective.jsp").forward(request,response);
    }
}
