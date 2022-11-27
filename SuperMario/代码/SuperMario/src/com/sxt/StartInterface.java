package com.sxt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class StartInterface {
    JFrame jf = new JFrame("超级玛丽JAVA版");

    final int WIDTH = 800;
    final int HEIGHT = 600;
    static Music music=new Music();

    //组装视图
    public void init() throws Exception {
        //设置窗口的大小
        jf.setSize(WIDTH,HEIGHT);
        //设置窗口居中显示
        jf.setLocationRelativeTo(null);
        //设置窗口不可改变大小
        jf.setResizable(false);
        //设置窗口logo
        jf.setIconImage(ImageIO.read(new File(StaticValue.path+"logo.png")));
        //设置点击窗口上的关闭键,结束程序
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口的背景
        BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(StaticValue.path+"start.png")));
        bgPanel.setBounds(0,0,WIDTH,HEIGHT);

        //创建按钮
        JButton StartGameBtn = new JButton("开始游戏");
        JButton setBtn = new JButton("设    置");
        Font font=new Font("黑体",Font.BOLD,30);
        StartGameBtn.setContentAreaFilled(false);
        StartGameBtn.setBorder(null);
        StartGameBtn.setForeground(Color.white);
        StartGameBtn.setFont(font);
        setBtn.setContentAreaFilled(false);
        setBtn.setBorder(null);
        setBtn.setForeground(Color.white);
        setBtn.setFont(font);
        StartGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到关卡选择页面
                try {
                    new LevelChooseInterface().init();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //当前界面消失
                jf.dispose();
            }
        });

        setBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到设置页面
                try {
                    new SetInterface().init();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //当前界面消失
                jf.dispose();
            }
        });
        //组装按钮
        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(400));
        vBox.add(StartGameBtn);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(setBtn);

        bgPanel.add(vBox);
        jf.add(bgPanel);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        String file = System.getProperty("user.dir") + "/src/Music/music.wav";

        music.setMusic(file);

        // 开启
        music.start();

        try {
            new StartInterface().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
