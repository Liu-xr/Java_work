package com.ljztuimis.filter;

import com.ljztuimis.bean.ChapterInfo;
import com.ljztuimis.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebFilter(filterName = "MenuFilter", urlPatterns = { "/*" },
        initParams = { @WebInitParam(name = "encoding", value = "utf-8") })
public class MenuFilter implements Filter {
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        // 过滤器先执行的字符集编码
        this.encoding = config.getInitParameter("encoding");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //使用注解中提供的默认初始化参数
        request.setCharacterEncoding(encoding);
        /* 初始化导航栏选项 */
        String sql = "select chapterid,chaptername from chapterinfo";
        ResultSet set;
        ArrayList<ChapterInfo> chapterList = new ArrayList<>();
        try {
            set = JDBCUtils.executeQuery(sql);
            while(set.next()){
                int chapterId = set.getInt("chapterid");
                String chapterName = set.getString("chaptername");
                ChapterInfo chapterInfo = new ChapterInfo();
                chapterInfo.setChapterId(chapterId);
                chapterInfo.setChapterName(chapterName);
                chapterList.add(chapterInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("chapterList",chapterList);
        chain.doFilter(request, response);
    }
}
