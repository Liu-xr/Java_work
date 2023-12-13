package com.lzjtuimis.listeners;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class EventListener implements HttpSessionAttributeListener {

    public EventListener() {
    }

    //属性添加事件
    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        String name = sbe.getName();
        System.out.println("新建session存放的数据" + name + "值为：" + sbe.getValue());
    }

    //属性替换事件
    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        HttpSession session = sbe.getSession();
        String name = sbe.getName();
        Object oldValue = sbe.getValue();

        System.out.println("修改session存放的数据" + name + "原值：" + oldValue + "新值：" + session.
                getAttribute(name));
    }

    //属性删除事件
    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        String name = sbe.getName();
        System.out.println("删除session存放的数据" + name + "值为：" + sbe.getValue());
    }
}
