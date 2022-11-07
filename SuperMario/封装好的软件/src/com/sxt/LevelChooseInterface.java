package com.sxt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LevelChooseInterface {
    JFrame jf = new JFrame("超级玛丽JAVA版");
    static int level;
    final int WIDTH = 800;
    final int HEIGHT = 600;
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

        JButton LevelOne = new JButton("第一关");
        JButton LevelTwo = new JButton("第二关");
        JButton LevelThree = new JButton("第三关");
        JButton LevelFour = new JButton("第四关");
        JButton LevelFive = new JButton("第五关");
        JButton backStart=new JButton("返  回");
        Font fontJ=new Font("黑体",Font.BOLD,20);
        LevelOne.setFont(fontJ);
        LevelTwo.setFont(fontJ);
        LevelThree.setFont(fontJ);
        LevelFour.setFont(fontJ);
        LevelFive.setFont(fontJ);
        backStart.setFont(fontJ);

        LevelOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置为第一关
                level=0;
                jf.dispose();
                MyFrame myFrame = new MyFrame();
            }
        });
        LevelTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置为第二关
                level=1;
                jf.dispose();
                MyFrame myFrame = new MyFrame();
            }
        });
        LevelThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置为第三关
                level=2;
                jf.dispose();
                MyFrame myFrame = new MyFrame();
            }
        });
        LevelFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置为第四关
                level=3;
                if(SetInterface.voice==1){
                    StartInterface.music.stop();
                    StartInterface.music.setMusic(System.getProperty("user.dir") + "/src/Music/地上加速.mp3");
                    StartInterface.music.start();
                }
                jf.dispose();
                MyFrame myFrame = new MyFrame();
            }
        });
        LevelFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置为第五关
                level=4;
                if(SetInterface.voice==1){
                    StartInterface.music.stop();
                    StartInterface.music.setMusic(System.getProperty("user.dir") + "/src/Music/地上加速.mp3");
                    StartInterface.music.start();
                }
                jf.dispose();
                MyFrame myFrame = new MyFrame();
            }
        });
        backStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //返回开始界面
                try {
                    new StartInterface().init();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                jf.dispose();
            }
        });
        //组装按钮
        Box FirstHBox = Box.createHorizontalBox();
        Box SecondHBox = Box.createHorizontalBox();
        FirstHBox.add(Box.createHorizontalStrut(10));
        FirstHBox.add(LevelOne);
        FirstHBox.add(Box.createHorizontalStrut(10));
        FirstHBox.add(LevelTwo);
        FirstHBox.add(Box.createHorizontalStrut(10));
        FirstHBox.add(LevelThree);
        SecondHBox.add(Box.createHorizontalStrut(10));
        SecondHBox.add(LevelFour);
        SecondHBox.add(Box.createHorizontalStrut(10));
        SecondHBox.add(LevelFive);
        SecondHBox.add(Box.createHorizontalStrut(10));
        SecondHBox.add(backStart);
        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(250));
        vBox.add(FirstHBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(SecondHBox);

        bgPanel.add(vBox);
        jf.add(bgPanel);
        jf.setVisible(true);
    }

}
