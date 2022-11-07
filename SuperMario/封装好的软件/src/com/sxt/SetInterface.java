package com.sxt;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class SetInterface {
    JFrame jf = new JFrame("超级玛丽JAVA版");

    final int WIDTH = 800;
    final int HEIGHT = 600;
    static int OpMode=0;
    static int voice=1;
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

        //创建返回按钮
        JButton backToStart = new JButton("返回主页");
        Font fontB=new Font("黑体",Font.BOLD,30);
        backToStart.setForeground(Color.BLACK);
        backToStart.setContentAreaFilled(false);
        backToStart.setBorder(null);
        backToStart.setFont(fontB);
        Box back=Box.createHorizontalBox();
        back.add(backToStart);
        back.add(Box.createHorizontalStrut(650));
        //创建选择按钮
        JRadioButton WASD = new JRadioButton("WASD操作方式",true);
        JRadioButton OpTwo = new JRadioButton("上下左右操作方式",false);
        JRadioButton On = new JRadioButton("开声音",true);
        JRadioButton Off= new JRadioButton("静音",false);
        Font fontJ=new Font("黑体",Font.BOLD,25);
        WASD.setForeground(Color.BLACK);
        WASD.setContentAreaFilled(false);
        WASD.setBorder(null);
        WASD.setFont(fontJ);

        OpTwo.setFont(fontJ);
        OpTwo.setBorder(null);
        OpTwo.setContentAreaFilled(false);
        OpTwo.setForeground(Color.BLACK);

        On.setContentAreaFilled(false);
        On.setBorder(null);
        On.setFont(fontJ);
        On.setForeground(Color.BLACK);

        Off.setContentAreaFilled(false);
        Off.setBorder(null);
        Off.setFont(fontJ);
        Off.setForeground(Color.BLACK);

        ButtonGroup group1=new ButtonGroup();
        group1.add(WASD);
        group1.add(OpTwo);
        ButtonGroup group2=new ButtonGroup();
        group2.add(On);
        group2.add(Off);
        WASD.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(WASD.isSelected()){
                    OpMode=0;
                }
            }
        });
        OpTwo.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(OpTwo.isSelected()){
                    OpMode=1;
                }
            }
        });
        On.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(On.isSelected()&&StartInterface.music.status==0){
                    StartInterface.music.setMusic(System.getProperty("user.dir") + "/src/Music/music.wav");
                    StartInterface.music.start();
                    voice=1;
                }
            }
        });
        Off.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(Off.isSelected()){
                    StartInterface.music.stop();
                    voice=0;
                }
            }
        });
        backToStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new StartInterface().init();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                jf.dispose();
            }
        });

        //组装按钮
        Box OpModeBox = Box.createHorizontalBox();
        JLabel jLabel=new JLabel("操作方式:");
        jLabel.setFont(fontJ);
        jLabel.setForeground(Color.BLACK);
        OpModeBox.add(Box.createHorizontalStrut(100));
        OpModeBox.add(jLabel);
        OpModeBox.add(Box.createHorizontalStrut(10));
        OpModeBox.add(WASD);
        OpModeBox.add(Box.createHorizontalStrut(50));
        OpModeBox.add(OpTwo);

        Box voiceBox = Box.createHorizontalBox();
        JLabel vLabel=new JLabel("声音:");
        vLabel.setFont(fontJ);
        vLabel.setForeground(Color.BLACK);
        voiceBox.add(vLabel);
        voiceBox.add(Box.createHorizontalStrut(30));
        voiceBox.add(On);
        voiceBox.add(Box.createHorizontalStrut(80));
        voiceBox.add(Off);
        voiceBox.add(Box.createHorizontalStrut(150));
        Box vBox=Box.createVerticalBox();
        vBox.setSize(800,600);
        vBox.add(back);
        vBox.add(Box.createVerticalStrut(300));
        vBox.add(OpModeBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(voiceBox);
        bgPanel.add(vBox);
        jf.add(bgPanel);
        jf.setVisible(true);
    }

}
