package com.sxt;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BackGround {
    //当前场景要显示的图像
    private BufferedImage bgImage = null;
    //记录当前是第几个场景
    private int sort;
    //每个关卡总共有几个场景
    static int[] BgNum = {3,4,5,5,6};
    //判断是否是最后一个场景
    private boolean flag;
    //用于存放我们的所有障碍物
    private List<Obstacle> obstacleList = new ArrayList<>();
    //用于存放我们的所有敌人
    private List<Enemy> enemyList = new ArrayList<>();
    //用于显示旗杆
    private BufferedImage gan = null;
    //用于显示城堡
    private BufferedImage tower = null;
    //判断马里奥是否到达旗杆位置
    private boolean isReach = false;
    //判断旗子是否落地
    private boolean isBase = false;

    public BackGround() {

    }

    public BackGround(int level,int sort,boolean flag) {
        this.sort = sort;
        this.flag = flag;

        if (flag) {
            bgImage = StaticValue.bg2;
        }else {
            bgImage = StaticValue.bg;
        }

        //第一关设计,三个场景，关卡难度低
        if(level==0){
            //判断是否是第一个场景
            if (sort == 1) {
                //绘制第一个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }


                //绘制砖块A
                for (int i = 120;i <= 150;i += 30) {
                    obstacleList.add(new Obstacle(i,300,7,this));
                }


                //绘制砖块B-F
                for (int i = 300;i <= 570;i += 30) {
                    if (i == 360 || i == 390 || i == 480 || i == 510 || i == 540) {
                        obstacleList.add(new Obstacle(i,300,7,this));
                    } else {
                        obstacleList.add(new Obstacle(i,300,0,this));
                    }
                }


                //绘制砖块G
                for (int i = 420;i <= 450;i += 30) {
                    obstacleList.add(new Obstacle(i,240,7,this));
                }


                //绘制水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(620,i,3,this));
                        obstacleList.add(new Obstacle(645,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(620,i,5,this));
                        obstacleList.add(new Obstacle(645,i,6,this));
                    }
                }

                //绘制第一个场景的蘑菇敌人
                enemyList.add(new Enemy(580,385,true,1,this));
                //绘制第一个场景的食人花敌人
                enemyList.add(new Enemy(635,420,true,2,328,428,this));
            }

            //判断是否是第二个场景
            else if (sort == 2) {
                //绘制第二个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }

                //绘制第一个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(60,i,3,this));
                        obstacleList.add(new Obstacle(85,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(60,i,5,this));
                        obstacleList.add(new Obstacle(85,i,6,this));
                    }
                }

                //绘制第二个水管
                for (int i = 330;i <= 600;i += 25) {
                    if (i == 330) {
                        obstacleList.add(new Obstacle(620,i,3,this));
                        obstacleList.add(new Obstacle(645,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(620,i,5,this));
                        obstacleList.add(new Obstacle(645,i,6,this));
                    }
                }

                //绘制砖块C
                obstacleList.add(new Obstacle(300,330,0,this));

                //绘制砖块B,E,G
                for (int i = 270;i <= 330;i += 30) {
                    if (i == 270 || i == 330) {
                        obstacleList.add(new Obstacle(i,360,0,this));
                    }else {
                        obstacleList.add(new Obstacle(i,360,7,this));
                    }
                }

                //绘制砖块A,D,F,H,I
                for (int i = 240;i <= 360;i += 30) {
                    if (i == 240 || i == 360) {
                        obstacleList.add(new Obstacle(i,390,0,this));
                    }else {
                        obstacleList.add(new Obstacle(i,390,7,this));
                    }
                }

                //绘制妨碍1砖块
                obstacleList.add(new Obstacle(240,300,0,this));

                //绘制空1-4砖块
                for (int i = 360;i <= 540;i += 60) {
                    obstacleList.add(new Obstacle(i,270,7,this));
                }

                //绘制第二个场景的第一个食人花敌人
                enemyList.add(new Enemy(75,420,true,2,328,418,this));
                //绘制第二个场景的第二个食人花敌人
                enemyList.add(new Enemy(635,420,true,2,298,388,this));
                //绘制第二个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(200,385,true,1,this));
                //绘制第二个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(500,385,true,1,this));
            }

            //判断是否是第三个场景
            else if (sort == 3) {
                //绘制第三个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }

                //绘制第三个背景的A-O砖块
                int temp = 290;
                for (int i = 390;i >= 270;i -= 30) {
                    for (int j = temp;j <= 410;j += 30) {
                        obstacleList.add(new Obstacle(j,i,7,this));
                    }
                    temp += 30;
                }

                //绘制第三个背景的P-R砖块
                temp = 60;
                for (int i = 390;i >= 360;i -= 30) {
                    for (int j = temp;j <= 90;j += 30) {
                        obstacleList.add(new Obstacle(j,i,7,this));
                    }
                    temp += 30;
                }

                //绘制旗杆
                gan = StaticValue.gan;

                //绘制城堡
                tower = StaticValue.tower;

                //添加旗子到旗杆上
                obstacleList.add(new Obstacle(515,220,8,this));

                //绘制第三个场景的蘑菇敌人
                enemyList.add(new Enemy(150,385,true,1,this));
            }
        }

        //第二关设计，四个场景，关卡难度适中
        else if(level==1){
            //判断是否是第一个场景
            if (sort == 1) {
                //绘制第一个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }


                //绘制砖块A,B,C,E,F
                for (int i = 210;i <= 360;i += 30) {
                    if(i==240){
                        obstacleList.add(new Obstacle(i,300,0,this));
                    }
                    else{
                        obstacleList.add(new Obstacle(i,300,7,this));
                    }
                }


                //绘制砖块G
                obstacleList.add(new Obstacle(360,270,7,this));


                //绘制砖块H,I
                obstacleList.add(new Obstacle(150,390,0,this));
                obstacleList.add(new Obstacle(150,360,0,this));


                //绘制水管
                for (int i = 340;i <= 600;i += 25) {
                    if (i == 340) {
                        obstacleList.add(new Obstacle(490,i,3,this));
                        obstacleList.add(new Obstacle(515,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(490,i,5,this));
                        obstacleList.add(new Obstacle(515,i,6,this));
                    }
                }

                //绘制第一个场景的蘑菇敌人
                enemyList.add(new Enemy(440,385,true,1,this));
                enemyList.add(new Enemy(700,385,true,1,this));
                //绘制第一个场景的食人花敌人
                enemyList.add(new Enemy(505,430,true,2,308,398,this));
            }

            //判断是否是第二个场景
            else if (sort == 2) {
                //绘制第二关的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }


                //绘制砖块A,B,C,D
                for (int i = 120;i <= 180;i += 30) {
                    if (i == 150) {
                        obstacleList.add(new Obstacle(i, 360, 0, this));
                    }

                    obstacleList.add(new Obstacle(i,390,7,this));
                }

                //绘制第一个水管
                for (int i = 340;i <= 600;i += 25) {
                    if (i == 340) {
                        obstacleList.add(new Obstacle(270,i,3,this));
                        obstacleList.add(new Obstacle(295,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(270,i,5,this));
                        obstacleList.add(new Obstacle(295,i,6,this));
                    }
                }

                //绘制砖块E,F,G
                for (int i = 450;i <= 510;i += 30) {
                    if (i == 510) {
                        obstacleList.add(new Obstacle(i, 360, 7, this));
                    }

                    obstacleList.add(new Obstacle(i,360,0,this));
                }

                //绘制第二个水管
                for (int i = 350;i <= 600;i += 25) {
                    if (i == 350) {
                        obstacleList.add(new Obstacle(620,i,3,this));
                        obstacleList.add(new Obstacle(645,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(620,i,5,this));
                        obstacleList.add(new Obstacle(645,i,6,this));
                    }
                }


                //绘制第二个场景的第一个食人花敌人
                enemyList.add(new Enemy(285,430,true,2,308,398,this));
                //绘制第二个场景的第二个食人花敌人
                enemyList.add(new Enemy(635,440,true,2,318,408,this));
                //绘制第二个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(240,385,true,1,this));
                //绘制第二个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(470,385,true,1,this));
                //绘制第二个场景的第三个蘑菇敌人
                enemyList.add(new Enemy(720,385,true,1,this));
            }

            //判断是否是第三个场景
            else if (sort == 3) {
                //绘制第三关的地面,上地面type=1,下地面type=2
                for (int i = 0; i < 27; i++) {
                    obstacleList.add(new Obstacle(i * 30, 420, 1, this));
                }

                for (int j = 0; j <= 120; j += 30) {
                    for (int i = 0; i < 27; i++) {
                        obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                    }
                }

                //绘制第一个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(150,i,3,this));
                        obstacleList.add(new Obstacle(175,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(150,i,5,this));
                        obstacleList.add(new Obstacle(175,i,6,this));
                    }
                }

                //绘制第二个水管
                for (int i = 330;i <= 600;i += 25) {
                    if (i == 330) {
                        obstacleList.add(new Obstacle(265,i,3,this));
                        obstacleList.add(new Obstacle(290,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(265,i,5,this));
                        obstacleList.add(new Obstacle(290,i,6,this));
                    }
                }

                //绘制方块A，B，C
                obstacleList.add(new Obstacle(415,390,0,this));
                obstacleList.add(new Obstacle(415,360,0,this));
                obstacleList.add(new Obstacle(510,320,7,this));

                //绘制第三个水管
                for (int i = 290;i <= 600;i += 25) {
                    if (i == 290) {
                        obstacleList.add(new Obstacle(600,i,3,this));
                        obstacleList.add(new Obstacle(625,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(600,i,5,this));
                        obstacleList.add(new Obstacle(625,i,6,this));
                    }
                }

                //绘制第三个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(210,385,true,1,this));
                //绘制第三个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(500,385,true,1,this));

                //绘制第三个场景的第一个食人花敌人
                enemyList.add(new Enemy(170,450,true,2,328,418,this));
                //绘制第三个场景的第二个食人花敌人
                enemyList.add(new Enemy(275,420,true,2,298,388,this));
                //绘制第三个场景的第三个食人花敌人
                enemyList.add(new Enemy(615,380,true,2,258,348,this));
            }

            //判断是否是第四个场景
            else if (sort == 4) {
                //绘制第四个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }

                //绘制第四个背景的A1,A2砖块
                obstacleList.add(new Obstacle(90,390,0,this));
                obstacleList.add(new Obstacle(90,360,0,this));

                //绘制第四个背景的B,C,D,E砖块
                for (int i = 155;i <= 245;i += 30) {
                    obstacleList.add(new Obstacle(i,300,7,this));
                }

                //绘制水管
                for (int i = 270;i <= 600;i += 25) {
                    if (i == 270) {
                        obstacleList.add(new Obstacle(340,i,3,this));
                        obstacleList.add(new Obstacle(365,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(340,i,5,this));
                        obstacleList.add(new Obstacle(365,i,6,this));
                    }
                }

                //绘制旗杆
                gan = StaticValue.gan;

                //绘制城堡
                tower = StaticValue.tower;

                //添加旗子到旗杆上
                obstacleList.add(new Obstacle(515,220,8,this));

                //绘制第四个场景的蘑菇敌人
                enemyList.add(new Enemy(180,385,true,1,this));

                //绘制第四个场景的食人花敌人
                enemyList.add(new Enemy(355,360,true,2,238,328,this));
            }
        }

        //第三关设计，五个场景，关卡难度中等
        else if(level==2){
            //判断是否是第一个场景
            if (sort == 1) {
                //绘制第一个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }


                //绘制砖块A,B,C,D
                for (int i = 120;i <= 180;i += 30) {
                    if (i == 150) {
                        obstacleList.add(new Obstacle(i, 360, 0, this));
                    }

                    obstacleList.add(new Obstacle(i,390,7,this));
                }

                //绘制砖块E
                obstacleList.add(new Obstacle(210,300,7,this));

                //绘制砖块F,G,H,I,J,K,M,N
                for (int i = 320;i <= 470;i += 30) {
                    if(i==320||i==470){
                        obstacleList.add(new Obstacle(i,270,0,this));
                    }
                    obstacleList.add(new Obstacle(i,300,7,this));
                }

                //绘制水管
                for (int i = 240;i <= 600;i += 25) {
                    if (i == 240) {
                        obstacleList.add(new Obstacle(580,i,3,this));
                        obstacleList.add(new Obstacle(605,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(580,i,5,this));
                        obstacleList.add(new Obstacle(605,i,6,this));
                    }
                }

                //绘制第一个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(510,385,true,1,this));

                //绘制第一个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(710,385,true,1,this));

                //绘制第一个场景的第三个蘑菇敌人
                enemyList.add(new Enemy(380,265,true,1,this));

                //绘制第一个场景的食人花敌人
                enemyList.add(new Enemy(595,330,true,2,208,298,this));
            }

            //判断是否是第二个场景
            else if (sort == 2) {
                //绘制第二个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }

                //绘制砖块A
                obstacleList.add(new Obstacle(510,360,7,this));

                //绘制砖块B
                obstacleList.add(new Obstacle(400,330,7,this));

                //绘制砖块C
                obstacleList.add(new Obstacle(290,300,7,this));

                //绘制砖块D
                obstacleList.add(new Obstacle(180,270,7,this));

                //绘制砖块E
                obstacleList.add(new Obstacle(70,240,7,this));

                //绘制砖块F
                obstacleList.add(new Obstacle(180,210,7,this));

                //绘制砖块G
                obstacleList.add(new Obstacle(290,180,7,this));

                //绘制砖块B
                obstacleList.add(new Obstacle(400,150,7,this));

                //绘制砖块A
                obstacleList.add(new Obstacle(510,120,7,this));

                //绘制第一个水管
                for (int i = 300;i <= 600;i += 25) {
                    if (i == 300) {
                        obstacleList.add(new Obstacle(620,i,3,this));
                        obstacleList.add(new Obstacle(645,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(620,i,5,this));
                        obstacleList.add(new Obstacle(645,i,6,this));
                    }
                }

                //绘制第二个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(720,i,3,this));
                        obstacleList.add(new Obstacle(745,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(720,i,5,this));
                        obstacleList.add(new Obstacle(745,i,6,this));
                    }
                }

                //绘制第二个场景的第一个食人花敌人
                enemyList.add(new Enemy(635,390,true,2,268,318,this));
                //绘制第二个场景的第二个食人花敌人
                enemyList.add(new Enemy(735,450,true,2,328,388,this));
            }

            //判断是否是第三个场景
            else if (sort == 3) {
                //绘制第三个场景的地面,上地面type=1,下地面type=2
                for (int i = 0; i < 27; i++) {
                    obstacleList.add(new Obstacle(i * 30, 420, 1, this));
                }

                for (int j = 0; j <= 120; j += 30) {
                    for (int i = 0; i < 27; i++) {
                        obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                    }
                }

                //绘制第一个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(120,i,3,this));
                        obstacleList.add(new Obstacle(145,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(120,i,5,this));
                        obstacleList.add(new Obstacle(145,i,6,this));
                    }
                }

                //绘制第二个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(250,i,3,this));
                        obstacleList.add(new Obstacle(275,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(250,i,5,this));
                        obstacleList.add(new Obstacle(275,i,6,this));
                    }
                }

                //绘制第三个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(380,i,3,this));
                        obstacleList.add(new Obstacle(405,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(380,i,5,this));
                        obstacleList.add(new Obstacle(405,i,6,this));
                    }
                }

                //绘制第四个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(510,i,3,this));
                        obstacleList.add(new Obstacle(535,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(510,i,5,this));
                        obstacleList.add(new Obstacle(535,i,6,this));
                    }
                }

                //绘制第五个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(630,i,3,this));
                        obstacleList.add(new Obstacle(655,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(630,i,5,this));
                        obstacleList.add(new Obstacle(655,i,6,this));
                    }
                }

                //绘制第三个场景的第一个食人花敌人
                enemyList.add(new Enemy(135,450,true,2,328,368,this));
                //绘制第三个场景的第二个食人花敌人
                enemyList.add(new Enemy(265,450,true,2,328,376,this));
                //绘制第三个场景的第三个食人花敌人
                enemyList.add(new Enemy(395,450,true,2,328,372,this));
                //绘制第三个场景的第四个食人花敌人
                enemyList.add(new Enemy(525,450,true,2,328,398,this));
                //绘制第三个场景的第五个食人花敌人
                enemyList.add(new Enemy(645,450,true,2,328,388,this));
            }

            //判断是否是第四个场景
            else if(sort==4){
                //绘制第四个场景的地面,上地面type=1,下地面type=2
                for (int i = 0; i < 27; i++) {
                    obstacleList.add(new Obstacle(i * 30, 420, 1, this));
                }

                for (int j = 0; j <= 120; j += 30) {
                    for (int i = 0; i < 27; i++) {
                        obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                    }
                }

                //绘制第四个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(90,385,true,1,this));
                //绘制第四个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(150,385,true,1,this));
                //绘制第四个场景的第三个蘑菇敌人
                enemyList.add(new Enemy(210,385,true,1,this));
                //绘制第四个场景的第四个蘑菇敌人
                enemyList.add(new Enemy(270,385,true,1,this));
                //绘制第四个场景的第五个蘑菇敌人
                enemyList.add(new Enemy(330,385,true,1,this));
                //绘制第四个场景的第六个蘑菇敌人
                enemyList.add(new Enemy(390,385,true,1,this));
                //绘制第四个场景的第七个蘑菇敌人
                enemyList.add(new Enemy(450,385,true,1,this));
                //绘制第四个场景的第八个蘑菇敌人
                enemyList.add(new Enemy(510,385,true,1,this));
                //绘制第四个场景的第九个蘑菇敌人
                enemyList.add(new Enemy(570,385,true,1,this));
                //绘制第四个场景的第十个蘑菇敌人
                enemyList.add(new Enemy(630,385,true,1,this));
                //绘制第四个场景的第十一个蘑菇敌人
                enemyList.add(new Enemy(690,385,true,1,this));
                //绘制第四个场景的第十二个蘑菇敌人
                enemyList.add(new Enemy(750,385,true,1,this));
            }

            //判断是否是第五个场景
            else if(sort==5){
                //绘制第三个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }

                //绘制第水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(60,i,3,this));
                        obstacleList.add(new Obstacle(85,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(60,i,5,this));
                        obstacleList.add(new Obstacle(85,i,6,this));
                    }
                }

                //绘制第三个背景的A-O砖块
                int temp = 290;
                for (int i = 390;i >= 270;i -= 30) {
                    for (int j = temp;j <= 410;j += 30) {
                        obstacleList.add(new Obstacle(j,i,7,this));
                    }
                    temp += 30;
                }

                //绘制第五个场景的第一个食人花敌人
                enemyList.add(new Enemy(75,358,true,2,328,358,this));
                //绘制第五个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(115,385,true,1,this));
                //绘制第五个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(155,385,true,1,this));
                //绘制第五个场景的第三个蘑菇敌人
                enemyList.add(new Enemy(210,385,true,1,this));

                //绘制旗杆
                gan = StaticValue.gan;

                //绘制城堡
                tower = StaticValue.tower;

                //添加旗子到旗杆上
                obstacleList.add(new Obstacle(515,220,8,this));

                //绘制第三个场景的蘑菇敌人
                enemyList.add(new Enemy(150,385,true,1,this));

            }
        }

        //第四关设计，五个场景，关卡难度偏高，启动加速
        else if(level==3){
            //判断是否是第一个场景
            if (sort == 1) {
                //绘制第一个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }


                //绘制砖块A
                for (int i = 120;i <= 150;i += 30) {
                    obstacleList.add(new Obstacle(i,300,7,this));
                }


                //绘制砖块B-F
                for (int i = 300;i <= 570;i += 30) {
                    if (i == 360 || i == 390 || i == 480 || i == 510 || i == 540) {
                        obstacleList.add(new Obstacle(i,300,7,this));
                    } else {
                        obstacleList.add(new Obstacle(i,300,0,this));
                    }
                }


                //绘制砖块G
                for (int i = 420;i <= 450;i += 30) {
                    obstacleList.add(new Obstacle(i,240,7,this));
                }


                //绘制水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(620,i,3,this));
                        obstacleList.add(new Obstacle(645,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(620,i,5,this));
                        obstacleList.add(new Obstacle(645,i,6,this));
                    }
                }

                //绘制第一个场景的蘑菇敌人
                enemyList.add(new Enemy(580,385,true,1,this));
                //绘制第一个场景的食人花敌人
                enemyList.add(new Enemy(635,420,true,2,328,428,this));
            }

            //判断是否是第二个场景
            else if (sort == 2) {
                //绘制第二关的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }


                //绘制砖块A,B,C,D
                for (int i = 120;i <= 180;i += 30) {
                    if (i == 150) {
                        obstacleList.add(new Obstacle(i, 360, 0, this));
                    }

                    obstacleList.add(new Obstacle(i,390,7,this));
                }

                //绘制第一个水管
                for (int i = 340;i <= 600;i += 25) {
                    if (i == 340) {
                        obstacleList.add(new Obstacle(270,i,3,this));
                        obstacleList.add(new Obstacle(295,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(270,i,5,this));
                        obstacleList.add(new Obstacle(295,i,6,this));
                    }
                }

                //绘制砖块E,F,G
                for (int i = 450;i <= 510;i += 30) {
                    if (i == 510) {
                        obstacleList.add(new Obstacle(i, 360, 7, this));
                    }

                    obstacleList.add(new Obstacle(i,360,0,this));
                }

                //绘制第二个水管
                for (int i = 350;i <= 600;i += 25) {
                    if (i == 350) {
                        obstacleList.add(new Obstacle(620,i,3,this));
                        obstacleList.add(new Obstacle(645,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(620,i,5,this));
                        obstacleList.add(new Obstacle(645,i,6,this));
                    }
                }


                //绘制第二个场景的第一个食人花敌人
                enemyList.add(new Enemy(285,430,true,2,308,398,this));
                //绘制第二个场景的第二个食人花敌人
                enemyList.add(new Enemy(635,440,true,2,318,408,this));
                //绘制第二个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(240,385,true,1,this));
                //绘制第二个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(470,385,true,1,this));
                //绘制第二个场景的第三个蘑菇敌人
                enemyList.add(new Enemy(720,385,true,1,this));
            }

            //判断是否是第三个场景
            else if (sort == 3) {
                //绘制第三关的地面,上地面type=1,下地面type=2
                for (int i = 0; i < 27; i++) {
                    obstacleList.add(new Obstacle(i * 30, 420, 1, this));
                }

                for (int j = 0; j <= 120; j += 30) {
                    for (int i = 0; i < 27; i++) {
                        obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                    }
                }

                //绘制第一个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(150,i,3,this));
                        obstacleList.add(new Obstacle(175,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(150,i,5,this));
                        obstacleList.add(new Obstacle(175,i,6,this));
                    }
                }

                //绘制第二个水管
                for (int i = 330;i <= 600;i += 25) {
                    if (i == 330) {
                        obstacleList.add(new Obstacle(265,i,3,this));
                        obstacleList.add(new Obstacle(290,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(265,i,5,this));
                        obstacleList.add(new Obstacle(290,i,6,this));
                    }
                }

                //绘制方块A，B，C
                obstacleList.add(new Obstacle(415,390,0,this));
                obstacleList.add(new Obstacle(415,360,0,this));
                obstacleList.add(new Obstacle(510,320,7,this));

                //绘制第三个水管
                for (int i = 290;i <= 600;i += 25) {
                    if (i == 290) {
                        obstacleList.add(new Obstacle(600,i,3,this));
                        obstacleList.add(new Obstacle(625,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(600,i,5,this));
                        obstacleList.add(new Obstacle(625,i,6,this));
                    }
                }

                //绘制第三个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(210,385,true,1,this));
                //绘制第三个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(500,385,true,1,this));

                //绘制第三个场景的第一个食人花敌人
                enemyList.add(new Enemy(170,450,true,2,328,418,this));
                //绘制第三个场景的第二个食人花敌人
                enemyList.add(new Enemy(275,420,true,2,298,388,this));
                //绘制第三个场景的第三个食人花敌人
                enemyList.add(new Enemy(615,380,true,2,258,348,this));
            }

            //判断是否是第四个场景
            else if (sort == 4) {
                //绘制第四个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }


                //绘制砖块A,B,C,D
                for (int i = 120;i <= 180;i += 30) {
                    if (i == 150) {
                        obstacleList.add(new Obstacle(i, 360, 0, this));
                    }

                    obstacleList.add(new Obstacle(i,390,7,this));
                }

                //绘制砖块E
                obstacleList.add(new Obstacle(210,300,7,this));

                //绘制砖块F,G,H,I,J,K,M,N
                for (int i = 320;i <= 470;i += 30) {
                    if(i==320||i==470){
                        obstacleList.add(new Obstacle(i,270,0,this));
                    }
                    obstacleList.add(new Obstacle(i,300,7,this));
                }

                //绘制水管
                for (int i = 240;i <= 600;i += 25) {
                    if (i == 240) {
                        obstacleList.add(new Obstacle(580,i,3,this));
                        obstacleList.add(new Obstacle(605,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(580,i,5,this));
                        obstacleList.add(new Obstacle(605,i,6,this));
                    }
                }

                //绘制第四个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(510,385,true,1,this));

                //绘制第四个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(710,385,true,1,this));

                //绘制第四个场景的第三个蘑菇敌人
                enemyList.add(new Enemy(380,265,true,1,this));

                //绘制第四个场景的食人花敌人
                enemyList.add(new Enemy(595,330,true,2,208,298,this));
            }

            //判断是否是第五个场景
            else if (sort == 5) {
                //绘制第五个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }

                //绘制第五个背景的A1,A2砖块
                obstacleList.add(new Obstacle(90,390,0,this));
                obstacleList.add(new Obstacle(90,360,0,this));

                //绘制第五个背景的B,C,D,E砖块
                for (int i = 155;i <= 245;i += 30) {
                    obstacleList.add(new Obstacle(i,300,7,this));
                }

                //绘制水管
                for (int i = 270;i <= 600;i += 25) {
                    if (i == 270) {
                        obstacleList.add(new Obstacle(340,i,3,this));
                        obstacleList.add(new Obstacle(365,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(340,i,5,this));
                        obstacleList.add(new Obstacle(365,i,6,this));
                    }
                }

                //绘制旗杆
                gan = StaticValue.gan;

                //绘制城堡
                tower = StaticValue.tower;

                //添加旗子到旗杆上
                obstacleList.add(new Obstacle(515,220,8,this));

                //绘制第五个场景的蘑菇敌人
                enemyList.add(new Enemy(180,385,true,1,this));

                //绘制第五个场景的食人花敌人
                enemyList.add(new Enemy(355,360,true,2,238,328,this));
            }
        }
        //第五关设计，六个场景，关卡难度地狱，启动加速
        else if(level==4){
            //判断是否是第一个场景
            if(sort==1){
                //绘制第二个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }

                //绘制第一个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(60,i,3,this));
                        obstacleList.add(new Obstacle(85,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(60,i,5,this));
                        obstacleList.add(new Obstacle(85,i,6,this));
                    }
                }

                //绘制第二个水管
                for (int i = 330;i <= 600;i += 25) {
                    if (i == 330) {
                        obstacleList.add(new Obstacle(620,i,3,this));
                        obstacleList.add(new Obstacle(645,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(620,i,5,this));
                        obstacleList.add(new Obstacle(645,i,6,this));
                    }
                }

                //绘制砖块C
                obstacleList.add(new Obstacle(300,330,0,this));

                //绘制砖块B,E,G
                for (int i = 270;i <= 330;i += 30) {
                    if (i == 270 || i == 330) {
                        obstacleList.add(new Obstacle(i,360,0,this));
                    }else {
                        obstacleList.add(new Obstacle(i,360,7,this));
                    }
                }

                //绘制砖块A,D,F,H,I
                for (int i = 240;i <= 360;i += 30) {
                    if (i == 240 || i == 360) {
                        obstacleList.add(new Obstacle(i,390,0,this));
                    }else {
                        obstacleList.add(new Obstacle(i,390,7,this));
                    }
                }

                //绘制妨碍1砖块
                obstacleList.add(new Obstacle(240,300,0,this));

                //绘制空1-4砖块
                for (int i = 360;i <= 540;i += 60) {
                    obstacleList.add(new Obstacle(i,270,7,this));
                }

                //绘制第二个场景的第一个食人花敌人
                enemyList.add(new Enemy(75,420,true,2,328,418,this));
                //绘制第二个场景的第二个食人花敌人
                enemyList.add(new Enemy(635,420,true,2,298,388,this));
                //绘制第二个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(200,385,true,1,this));
                //绘制第二个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(500,385,true,1,this));
            }

            //判断是否是第二个场景
            else if(sort==2){
                //绘制第二个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }


                //绘制砖块A,B,C,E,F
                for (int i = 210;i <= 360;i += 30) {
                    if(i==240){
                        obstacleList.add(new Obstacle(i,300,0,this));
                    }
                    else{
                        obstacleList.add(new Obstacle(i,300,7,this));
                    }
                }


                //绘制砖块G
                obstacleList.add(new Obstacle(360,270,7,this));


                //绘制砖块H,I
                obstacleList.add(new Obstacle(150,390,0,this));
                obstacleList.add(new Obstacle(150,360,0,this));


                //绘制水管
                for (int i = 340;i <= 600;i += 25) {
                    if (i == 340) {
                        obstacleList.add(new Obstacle(490,i,3,this));
                        obstacleList.add(new Obstacle(515,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(490,i,5,this));
                        obstacleList.add(new Obstacle(515,i,6,this));
                    }
                }

                //绘制第二个场景的蘑菇敌人
                enemyList.add(new Enemy(440,385,true,1,this));
                enemyList.add(new Enemy(700,385,true,1,this));
                //绘制第一个场景的食人花敌人
                enemyList.add(new Enemy(505,430,true,2,308,398,this));
            }

            //判断是否是第三个场景
            else if(sort==3){
                //绘制第一个场景的地面,上地面type=1,下地面type=2
                for (int i = 0; i < 27; i++) {
                    obstacleList.add(new Obstacle(i * 30, 420, 1, this));
                }

                for (int j = 0; j <= 120; j += 30) {
                    for (int i = 0; i < 27; i++) {
                        obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                    }
                }

                //绘制第四个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(150,385,true,1,this));
                //绘制第四个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(210,385,true,1,this));
                //绘制第四个场景的第三个蘑菇敌人
                enemyList.add(new Enemy(270,385,true,1,this));
                //绘制第四个场景的第四个蘑菇敌人
                enemyList.add(new Enemy(330,385,true,1,this));
                //绘制第四个场景的第五个蘑菇敌人
                enemyList.add(new Enemy(390,385,true,1,this));
                //绘制第四个场景的第六个蘑菇敌人
                enemyList.add(new Enemy(450,385,true,1,this));
                //绘制第四个场景的第七个蘑菇敌人
                enemyList.add(new Enemy(510,385,true,1,this));
                //绘制第四个场景的第八个蘑菇敌人
                enemyList.add(new Enemy(570,385,true,1,this));
                //绘制第四个场景的第九个蘑菇敌人
                enemyList.add(new Enemy(630,385,true,1,this));
                //绘制第四个场景的第十个蘑菇敌人
                enemyList.add(new Enemy(690,385,true,1,this));
                //绘制第四个场景的第十一个蘑菇敌人
                enemyList.add(new Enemy(750,385,true,1,this));
            }
            //判断是否是第四个场景
            else if(sort==4){
                //绘制第四个场景的地面,上地面type=1,下地面type=2
                for (int i = 0; i < 27; i++) {
                    obstacleList.add(new Obstacle(i * 30, 420, 1, this));
                }

                for (int j = 0; j <= 120; j += 30) {
                    for (int i = 0; i < 27; i++) {
                        obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                    }
                }

                //绘制第一个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(120,i,3,this));
                        obstacleList.add(new Obstacle(145,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(120,i,5,this));
                        obstacleList.add(new Obstacle(145,i,6,this));
                    }
                }

                //绘制第二个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(250,i,3,this));
                        obstacleList.add(new Obstacle(275,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(250,i,5,this));
                        obstacleList.add(new Obstacle(275,i,6,this));
                    }
                }

                //绘制第三个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(380,i,3,this));
                        obstacleList.add(new Obstacle(405,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(380,i,5,this));
                        obstacleList.add(new Obstacle(405,i,6,this));
                    }
                }

                //绘制第四个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(510,i,3,this));
                        obstacleList.add(new Obstacle(535,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(510,i,5,this));
                        obstacleList.add(new Obstacle(535,i,6,this));
                    }
                }

                //绘制第五个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(630,i,3,this));
                        obstacleList.add(new Obstacle(655,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(630,i,5,this));
                        obstacleList.add(new Obstacle(655,i,6,this));
                    }
                }

                //绘制第四个场景的第一个食人花敌人
                enemyList.add(new Enemy(135,450,true,2,328,368,this));
                //绘制第四个场景的第二个食人花敌人
                enemyList.add(new Enemy(265,450,true,2,328,376,this));
                //绘制第四个场景的第三个食人花敌人
                enemyList.add(new Enemy(395,450,true,2,328,372,this));
                //绘制第四个场景的第四个食人花敌人
                enemyList.add(new Enemy(525,450,true,2,328,398,this));
                //绘制第四个场景的第五个食人花敌人
                enemyList.add(new Enemy(645,450,true,2,328,388,this));
            }

            //判断是否是第五个场景
            else if(sort==5){
                //绘制第二个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }

                //绘制砖块A
                obstacleList.add(new Obstacle(510,360,7,this));

                //绘制砖块B
                obstacleList.add(new Obstacle(400,330,7,this));

                //绘制砖块C
                obstacleList.add(new Obstacle(290,300,7,this));

                //绘制砖块D
                obstacleList.add(new Obstacle(180,270,7,this));

                //绘制砖块E
                obstacleList.add(new Obstacle(70,240,7,this));

                //绘制砖块F
                obstacleList.add(new Obstacle(180,210,7,this));

                //绘制砖块G
                obstacleList.add(new Obstacle(290,180,7,this));

                //绘制砖块B
                obstacleList.add(new Obstacle(400,150,7,this));

                //绘制砖块A
                obstacleList.add(new Obstacle(510,120,7,this));

                //绘制第一个水管
                for (int i = 300;i <= 600;i += 25) {
                    if (i == 300) {
                        obstacleList.add(new Obstacle(620,i,3,this));
                        obstacleList.add(new Obstacle(645,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(620,i,5,this));
                        obstacleList.add(new Obstacle(645,i,6,this));
                    }
                }

                //绘制第二个水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(720,i,3,this));
                        obstacleList.add(new Obstacle(745,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(720,i,5,this));
                        obstacleList.add(new Obstacle(745,i,6,this));
                    }
                }

                //绘制第二个场景的第一个食人花敌人
                enemyList.add(new Enemy(635,390,true,2,268,318,this));
                //绘制第二个场景的第二个食人花敌人
                enemyList.add(new Enemy(735,450,true,2,328,388,this));
            }

            //判断是否是第六个场景
            else if(sort==6){
                //绘制第六个场景的地面,上地面type=1,下地面type=2
                for (int i = 0;i < 27;i++) {
                    obstacleList.add(new Obstacle(i*30,420,1,this));
                }

                for (int j = 0;j <= 120;j += 30) {
                    for (int i = 0;i < 27;i++) {
                        obstacleList.add(new Obstacle(i*30,570-j,2,this));
                    }
                }

                //绘制第水管
                for (int i = 360;i <= 600;i += 25) {
                    if (i == 360) {
                        obstacleList.add(new Obstacle(60,i,3,this));
                        obstacleList.add(new Obstacle(85,i,4,this));
                    }else {
                        obstacleList.add(new Obstacle(60,i,5,this));
                        obstacleList.add(new Obstacle(85,i,6,this));
                    }
                }

                //绘制第六个背景的A-O砖块
                int temp = 290;
                for (int i = 390;i >= 270;i -= 30) {
                    for (int j = temp;j <= 410;j += 30) {
                        obstacleList.add(new Obstacle(j,i,7,this));
                    }
                    temp += 30;
                }

                //绘制第六个场景的第一个食人花敌人
                enemyList.add(new Enemy(75,358,true,2,328,358,this));
                //绘制第六个场景的第一个蘑菇敌人
                enemyList.add(new Enemy(115,385,true,1,this));
                //绘制第六个场景的第二个蘑菇敌人
                enemyList.add(new Enemy(155,385,true,1,this));
                //绘制第六个场景的第三个蘑菇敌人
                enemyList.add(new Enemy(210,385,true,1,this));

                //绘制旗杆
                gan = StaticValue.gan;

                //绘制城堡
                tower = StaticValue.tower;

                //添加旗子到旗杆上
                obstacleList.add(new Obstacle(515,220,8,this));

                //绘制第六个场景的蘑菇敌人
                enemyList.add(new Enemy(150,385,true,1,this));
            }
        }
    }

    public BufferedImage getBgImage() {
        return bgImage;
    }

    public int getSort() {
        return sort;
    }

    public boolean isFlag() {
        return flag;
    }

    public List<Obstacle> getObstacleList() {
        return obstacleList;
    }

    public BufferedImage getGan() {
        return gan;
    }

    public BufferedImage getTower() {
        return tower;
    }

    public boolean isReach() {
        return isReach;
    }

    public void setReach(boolean reach) {
        isReach = reach;
    }

    public boolean isBase() {
        return isBase;
    }

    public void setBase(boolean base) {
        isBase = base;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }
}
