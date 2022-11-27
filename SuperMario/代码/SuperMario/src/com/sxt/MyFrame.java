package com.sxt;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame implements KeyListener,Runnable {
    //用于存储所有的背景
    private List<BackGround> allBg = new ArrayList<>();
    //用于存储当前的背景
    private BackGround nowBg = new BackGround();
    //用于双缓存
    private Image offScreenImage = null;
    //马里奥对象
    private Mario mario = new Mario();
    //定义一个线程对象,用于实现马里奥的运动
    private Thread thread = new Thread(this);
    //操作方式
    int right=68;
    int left=65;
    int up=87;
    int down=83;
    int option;
    //死亡或通关时选择对话框的选项
    String[] options={"继续游戏","退出"};

    public MyFrame() {
        //设置窗口的大小为800 * 600
        this.setSize(800,600);
        //设置窗口居中显示
        this.setLocationRelativeTo(null);
        //设置窗口的可见性
        this.setVisible(true);
        //设置窗口logo
        try {
            this.setIconImage(ImageIO.read(new File(StaticValue.path+"logo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置点击窗口上的关闭键,结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        this.setResizable(false);
        //向窗口对象添加键盘监听器
        this.addKeyListener(this);
        //设置窗口名称
        this.setTitle("超级玛丽JAVA版");
        //初始化图片
        StaticValue.init();
        //初始化马里奥
        mario = new Mario(10,355);
        //更新操作方式
        if (SetInterface.OpMode==1) {
            right=39;
            left=37;
            up=38;
            down=40;
        }else{
            right=68;
            left=65;
            up=87;
            down=83;
        }
        //创建全部的场景
        for (int i = 1;i <= BackGround.BgNum[LevelChooseInterface.level];i++) {
            allBg.add(new BackGround(LevelChooseInterface.level,i, i == BackGround.BgNum[LevelChooseInterface.level]));
        }

        //将第一个场景设置为当前场景
        nowBg = allBg.get(0);
        mario.setBackGround(nowBg);
        //绘制图像
        repaint();
        thread.start();

    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(800,600);
        }

        Graphics graphics = offScreenImage.getGraphics();
        graphics.fillRect(0,0,800,600);

        //绘制背景
        graphics.drawImage(nowBg.getBgImage(),0,0,this);

        //绘制敌人
        for (Enemy e : nowBg.getEnemyList()) {
            graphics.drawImage(e.getShow(),e.getX(),e.getY(),this);
        }

        //绘制障碍物
        for (Obstacle ob : nowBg.getObstacleList()) {
            graphics.drawImage(ob.getShow(),ob.getX(),ob.getY(),this);
        }

        //绘制城堡
        graphics.drawImage(nowBg.getTower(),620,270,this);

        //绘制旗杆
        graphics.drawImage(nowBg.getGan(),500,220,this);

        //绘制马里奥
        graphics.drawImage(mario.getShow(),mario.getX(),mario.getY(),this);

        //添加分数
        Color c = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("黑体",Font.BOLD,25));
        graphics.drawString("当前的分数为: " + mario.getScore(),300,100);
        graphics.setColor(c);

        //将图像绘制到窗口中
        g.drawImage(offScreenImage,0,0,this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当键盘按下按键时调用
    @Override
    public void keyPressed(KeyEvent e) {
        //向右移动
        if (e.getKeyCode() == right) {
            mario.rightMove();
        }
        //向左移动
        if (e.getKeyCode() == left) {
            mario.leftMove();
        }
        //跳跃
        if (e.getKeyCode() == up) {
            mario.jump();
        }
    }
    //当键盘松开按键时调用
    @Override
    public void keyReleased(KeyEvent e) {
        //想左停止
        if (e.getKeyCode() == left) {
            mario.leftStop();
        }
        //向右停止
        if (e.getKeyCode() == right) {
            mario.rightStop();
        }
    }

    @Override
    public void run() {
        int sleep=(LevelChooseInterface.level==3||LevelChooseInterface.level==4) ? 20 : 50;
        while (true) {
            repaint();
            try {


                if (mario.getX() >= 775) {
                    nowBg = allBg.get(nowBg.getSort());
                    mario.setBackGround(nowBg);
                    mario.setX(10);
                    mario.setY(355);
                }

                //判断马里奥是否死亡
                if (mario.isDeath()) {
                    new gameMusic(System.getProperty("user.dir") + "/src/Music/死亡2.mp3").start();
                    if(LevelChooseInterface.level>=3){
                        if(SetInterface.voice==1){
                            StartInterface.music.stop();
                            StartInterface.music.setMusic(System.getProperty("user.dir") + "/src/Music/music.wav");
                            StartInterface.music.start();
                        }
                    }
                    option=JOptionPane.showOptionDialog(this,"马里奥死亡!!!","超级玛丽",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
                    if(option==0){
                        try {
                            new LevelChooseInterface().init();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.exit(0);
                    }
                    this.dispose();
                    break;
                }

                //判断游戏是否结束
                if (mario.isOK()) {
                    if(LevelChooseInterface.level>=3){
                        if(SetInterface.voice==1){
                            StartInterface.music.stop();
                            StartInterface.music.setMusic(System.getProperty("user.dir") + "/src/Music/music.wav");
                            StartInterface.music.start();
                        }
                    }
                    option=JOptionPane.showOptionDialog(this,"恭喜通关!!!","超级玛丽",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
                    if(option==0){
                        try {
                            new LevelChooseInterface().init();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.exit(0);
                    }
                    this.dispose();
                    break;
                }
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
