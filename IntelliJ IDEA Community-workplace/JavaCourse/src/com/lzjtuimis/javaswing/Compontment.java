package com.lzjtuimis.javaswing;

import javax.swing.*;
import java.awt.*;

public class Compontment {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();  // 窗口
        // 容器
        JPanel jPanel = new JPanel(){
            // 每次刷新绘制界面
            @Override
            public void paint(Graphics g) { // 参数为绘制图形的距离
                Graphics2D graphics2D = (Graphics2D) g.create(); // 绘制2d图形花画板
                // 设置字体
                Font font = new Font("宋体", Font.PLAIN, 100);
                graphics2D.setFont(font);

                // 写字符串draw
                graphics2D.drawString("刘兴瑞", 500, 100);

                // 划线，两个坐标一条直线
                graphics2D.setColor(Color.orange);                    //设置颜色
                graphics2D.drawLine(500, 200, 700, 200);

                // 绘制椭圆，以矩形内接绘制，这是圆，draw划线
                graphics2D.setColor(Color.BLACK);
                graphics2D.drawOval(100, 100, 150, 150);

                // 绘制椭圆，fill电填充
                graphics2D.setColor(Color.red);
                graphics2D.fillOval(500, 400, 250, 150);

                // 绘制矩形
                graphics2D.setColor(Color.BLACK);
                graphics2D.fillRect(300, 200, 50, 100);
            }
        };

        // 按钮
        JButton jButton = new JButton("按钮");
        jButton.setSize(100, 145); // 按钮大小
        jButton.setBackground(Color.orange);
        jButton.setBounds(800, 600, 200, 120);
       // jButton.setVisible(true);

        jFrame.add(jButton);
        jFrame.add(jPanel);

        // 关闭窗体的时候，退出程序
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 使窗口可见
        jFrame.setVisible(true);
    }
}


