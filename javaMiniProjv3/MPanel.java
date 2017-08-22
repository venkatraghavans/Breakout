/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaMiniProjv3;

//import java.util.*;
import java.util.Random;
import java.net.URL;
import java.applet.*;
//import java.util.concurrent.*;
/*import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;*/
import javax.swing.ImageIcon;

import javax.swing.Timer;
//import java.util.TimerTask;
import java.io.*;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author acer
 */
public class MPanel extends JPanel implements Commons{
    Image ii;
    Timer timer;
    String message = "Game Over";
    Ball ball;
    Paddle paddle;
    Brick bricks[];
	long lscore = 1000;
	int lives;
	long scores = 0;
	double sccount=0;
	boolean pause=false,start = true;
	Color[] PColor = {Color.YELLOW,Color.PINK,Color.GREEN,Color.CYAN,Color.MAGENTA};
	AudioClip clip = Applet.newAudioClip(this.getClass().getResource("resources/s3.wav"));
	Random r;
	int wx,cl;
	String[] Level = {"LEVEL 1","LEVEL 2"};

	String[] ibricks = {"resources/brickv3.png",
				"resources/brickb1.png",
				"resources/bricksb1.png",
				"resources/bricksb3.png",
				"resources/brickc3.png"};
	String livesim = "resources/lives.png";
	ImageIcon qqq;

    boolean ingame = true;
    int timerId;


    public MPanel() {
	init_comp();
	
    }

	public void init_comp()
	{
		wx = 1;
	r = new Random();
	
        addKeyListener(new TAdapter());
	addKeyListener(new TAdapter2());
	addKeyListener(new OAdapter());
//addKeyListener(new OAdapter());
//addKeyListener(new OAdapter());
//addKeyListener(new OAdapter());
	setFocusable(true);
        bricks = new Brick[30];
        setDoubleBuffered(true);
        timer = new Timer(7,new ScheduleTask());
	timer.start();
       // timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);
	lives = 2;

	InputMap imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	ActionMap amap = getActionMap();
	imap.put(KeyStroke.getKeyStroke("s"),"start");
	amap.put("start",new AbstractAction()
	{
		public void actionPerformed(ActionEvent E)
		{
			if(start)
			{
				System.out.println("ttt");
				int i;
				for(i=0;i<30;i++)
				if(!bricks[i].isDestroyed())
					break;
				if(i<30)
					start = true;
			}
		}
	});
	qqq = new ImageIcon(this.getClass().getResource(livesim));
	}

        public void addNotify() {
            super.addNotify();
            gameInit(0);
        }

    public void gameInit(int h) {

	cl = h;
	ingame = true;
	lscore = 1000;
	lives = 2;
	scores = 0;
	sccount=0;
	pause=false;
        ball = new Ball();
        paddle = new Paddle();
	r = new Random();
	if(h==0)
	{
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                bricks[k] = new Brick(j * 90 + 30, i * 30 + 50, ibricks[i],4-i);
                k++;
            }
        }
	}
	else
	{
		int k=0,u;
		for(int i=0;i<6;i++)	{
			for(int j=0;j<5;j++)	{
				if(j<3)	u=4-j;
				else	u=j;
				bricks[k] = new Brick(j * 110 + 30, i * 30 + 50, ibricks[u],4-u);
               			k++;
			}
		}
	}
	ball.resetState();
	paddle.resetState();
    }

	  private void Pause()
    {
        if (!start)
            return;

        pause = !pause;
        if (pause) {
            timer.stop();
            //statusbar.setText("paused");
        } else {
            timer.start();
            //statusbar.setText(String.valueOf(numLinesRemoved));
        }
        //repaint();
    }


    public void paint(Graphics g) {
        super.paint(g);

	Font f1 = new Font("FreeSans",Font.BOLD,20);
        if (ingame) {
		//g.setColor(Color.white);
		//g.fillRect(10,45,570,370);
		
            g.drawImage(ball.getImage(), ball.getX(), ball.getY(),
                        ball.getWidth(), ball.getHeight(), this);
            g.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                        paddle.getWidth(), paddle.getHeight(), this);

		for(int i=0;i<=lives;i++)
			g.drawImage(qqq.getImage(),500+(i*30),10,this);

            for (int i = 0; i < 30; i++) {
                if (!bricks[i].isDestroyed())
                    g.drawImage(bricks[i].getImage(), bricks[i].getX(),
                                bricks[i].getY(), bricks[i].getWidth(),
                                bricks[i].getHeight(), this);
		
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(f1);
		if(!pause){
		//g2.drawString("Lives Left: "+lives,260,250);
		g2.drawString("Time left : "+lscore,270,40);
		}
		else if(pause)
		g2.drawString("GAME PAUSED",260,270);
		g2.drawString(Level[cl],0,40);
		if(!start)
			g2.drawString("Press s to start",240,300);
            }
        } else {

            /*Font font = new Font("Verdana", Font.BOLD, 18);
            FontMetrics metr = this.getFontMetrics(font);

            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString(message,
                         (Commons.WIDTH - metr.stringWidth(message)) / 2,
                         Commons.WIDTH / 2);*/
		if(message.equals("Victory"))
		{
			/*try{
			Thread.sleep(1000);
			wx = 1;
	r = new Random();
        addKeyListener(new TAdapter());
        setFocusable(true);

        bricks = new Brick[30];
        setDoubleBuffered(true);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);
	lives = 2;
	gameInit(0);
			//TimeUnit.Seconds.sleep(3);}
			}catch(Exception E){E.printStackTrace();}*/
			//OpTargetBricks O1 = new OpTargetBricks(1,1);
			//Graphics g = Graphics.getGraphics();
		//System.out.println("LSCORE "+(lscore+100)+" Lives "+(lives+1));
		final long s = (lscore) + ((lives) * 200) + (30*100);
		addKeyListener(new OAdapter());
		//gameInit(0);	
		Font f2 = new Font("Ubuntu",Font.BOLD,20);
		setFont(f2);
		g.drawString("Lives bonus = "+(lives)+" x 200",100,100);
		g.drawString("Time Bonus = "+(lscore),100,120);
		g.drawString("Bricks bonus = "+3000,100,140);
		g.drawString("Final Score = "+s,100,160);
		if(cl==0)
		{
			g.drawString("Press 'n' to go to next level",100,240);
		}
		g.drawString("Press 'r' to restart",100,200);
		/*JFrame F = new JFrame();
		//dispose();
		F.setSize(300,400);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*JPanel PP = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawString("Final Score = "+s,0,200);
				
			}
		};*//*
		PP.setFont(new Font("Verdana",Font.BOLD,20));
		F.add(PP);
		F.setLocationRelativeTo(null);
		F.setVisible(true);*/
		
		}
		else
		{
		final ImageIcon I1 = new ImageIcon(this.getClass().getResource("resources/gameover.png"));
		int m=0;
		for(int k=0;k<30;k++)
			if(bricks[k].isDestroyed())
				m++;
		g.drawImage(I1.getImage(),0,0,this);
		setFont(new Font("Ubuntu",Font.BOLD,20));
		g.setColor(Color.white);
		g.drawString("Bricks bonus = "+m+" x 100",100,50);
		g.drawString("Total Score = "+(m*100),100,70);
		g.drawString("Press 'r' to restart",100,110);
		/*JFrame F = new JFrame();
		//dispose();
		F.setSize(650,450);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel PP = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(I1.getImage(),0,0,this);
			}
		};
		F.add(PP);
		F.setLocationRelativeTo(null);
		F.setVisible(true);*/
		}
            /*Graphics2D g2 = (Graphics2D)g;
            g2.drawImage(paddle.getImage(),0,2,null);
            g2.drawImage(bricks[0].getImage(),5,2,null);
            g2.drawImage(ball.getImage(),10,2,null);*/
        }


        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
		
			
		System.out.print("");
            paddle.keyPressed(e);
        }

	public void keyTyped(KeyEvent e)	{
//System.out.print("w");
		//init_comp();
		//if(e.getKeyCode()=='g')
		//if(!ingame)
		//gameInit();
	}
    }

	 private class TAdapter2 extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
           if(!start&&e.getKeyCode()==KeyEvent.VK_S)
		{
			//System.out.println("->@@# "+" "+start);
			//int i;
			//for(i=0;i<30;i++)
			//	if(!bricks[i].isDestroyed())
			//		break;
			//if(i<30)
			start = true;
			timer.start();
		}
        }
	}

	class OAdapter extends KeyAdapter	{

		public void keyPressed(KeyEvent e)	{
			int x = e.getKeyCode();
		//System.out.println("-> "+x+" "+e.getKeyCode());
		if(x==80)
		{
			//System.out.println("->** "+x+" "+pause);
			/*if(pause)	pause = false;
			else	pause = true;*/
			//Pause();
			pause = !pause;
			if(pause)	timer.stop();
			else	timer.start();
			//if(pause)
				//return;
		}
		
		
		if(x==67)
		{
			for(int j=0;j<30;j++)
				bricks[j].setDestroyed(true);
			message = "Victory";
			start = false;
			ingame = false;
			timer.stop();
			//stopGame();
		}

		if(x==82)
		{
			//System.out.println("rrrrrrrr");
			//init_comp();
			if(ingame==false)
			gameInit(cl);
		}
		if(x==78)
		{
			if(ingame==false&&message.equals("Victory"))
				gameInit(1);
		}
		if(x==81)
		{
			timer.stop();
			System.exit(0);
		}
		repaint();
	}
	}

    class ScheduleTask implements ActionListener {

        public void actionPerformed(ActionEvent E) {

		try{
		 //paddle.move();
		System.out.print("");
		//if(!pause&&start){
            ball.move();
            paddle.move();
            checkCollision();
            repaint();
		//revalidate();
		requestFocus(true);
		sccount+=7;
		if((int)sccount==994)
		{
			setBackground(PColor[r.nextInt(3)]);
			scores++;
			if(lscore-1>0)
			lscore--;
			else
			lscore=0;
			sccount = 0;
			/*if(wx==1)
			{
				ball.changeImg("resources/ball2.png");
				wx=0;
			}
			else
			{
				ball.changeImg("resources/ball.png");
				wx=1;
			}*/	
		}
		}

	//}
		catch(Exception E1){}

        }
    }

    public void stopGame() {
	/*if(message.equals("Victory"))
	{	
		ingame = false;
		start = false;
		timer.stop();
		return;
	}*/
	if(lives==0)
	{
        ingame = false;
	start = false;
     timer.stop();
	//timer.stop();
	}
	else
	{
		message = "Gameover";
		start = false;
		//pause = true;
		lives--;
		if(lscore-100>=0)
		lscore-=100;
		else
		lscore = 0;
		ball.resetState();
		paddle.resetState();
		timer.stop();
	}
    }


    public void checkCollision() {

        if (ball.getRect().getMaxY() > Commons.BOTTOM) {
            stopGame();
        }

        for (int i = 0, j = 0; i < 30; i++) {
            if (bricks[i].isDestroyed()) {
                j++;
            }
            if (j == 30) {
                message = "Victory";
		//Graphics g = Graphics.getGraphics();
		/*final long s = scores + (lives * 10);
		//g.drawString("Final Score = "+scores,200,200,this);
		JFrame F = new JFrame();
		//dispose();
		F.setSize(300,400);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel PP = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawString("Final Score = "+s,200,200);
			}
		};
		F.add(PP);
		F.setLocationRelativeTo(null);
		F.setVisible(true);*/
                stopGame();
            }
        }

        if ((ball.getRect()).intersects(paddle.getRect())) {

            int paddleLPos = (int)paddle.getRect().getMinX();
            int ballLPos = (int)ball.getRect().getMinX();

            int first = paddleLPos + 8;
            int second = paddleLPos + 16;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;

            if (ballLPos < first) {
                ball.setXDir(-1);
                ball.setYDir(-1);
            }

            if (ballLPos >= first && ballLPos < second) {
                ball.setXDir(-1);
                ball.setYDir(-1 * ball.getYDir());
            }

            if (ballLPos >= second && ballLPos < third) {
                ball.setXDir(0);
                ball.setYDir(-1);
            }

            if (ballLPos >= third && ballLPos < fourth) {
                ball.setXDir(1);
                ball.setYDir(-1 * ball.getYDir());
            }

            if (ballLPos > fourth) {
                ball.setXDir(1);
                ball.setYDir(-1);
            }


        }


        for (int i = 0; i < 30; i++) {
            if ((ball.getRect()).intersects(bricks[i].getRect())) {

                int ballLeft = (int)ball.getRect().getMinX();
                int ballHeight = (int)ball.getRect().getHeight();
                int ballWidth = (int)ball.getRect().getWidth();
                int ballTop = (int)ball.getRect().getMinY();

                Point pointRight =
                    new Point(ballLeft + ballWidth + 1, ballTop);
                Point pointLeft = new Point(ballLeft - 1, ballTop);
                Point pointTop = new Point(ballLeft, ballTop - 1);
                Point pointBottom =
                    new Point(ballLeft, ballTop + ballHeight + 1);

                if (!bricks[i].isDestroyed()) {
                    if (bricks[i].getRect().contains(pointRight)) {
                        ball.setXDir(-1);
                    }

                    else if (bricks[i].getRect().contains(pointLeft)) {
                        ball.setXDir(1);
                    }

                    if (bricks[i].getRect().contains(pointTop)) {
                        ball.setYDir(1);
                    }

                    else if (bricks[i].getRect().contains(pointBottom)) {
                        ball.setYDir(-1);
                    }
			if(bricks[i].k>0)
			{	
				bricks[i].k--;
				bricks[i].changeImg(ibricks[4-bricks[i].k]);
			}
			else
                    bricks[i].setDestroyed(true);
			clip.play();
                }
            }
        }
    }
}
