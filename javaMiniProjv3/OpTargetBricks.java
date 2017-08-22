/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaMiniProjv3;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;
/**
 *
 * @author acer
 */
public class OpTargetBricks extends JFrame{
	
	JPanel P,P2;
	JLabel L,L1,L2,L3,L4;
	JTextArea rules;
	JButton sb,sb2;
	Font f;
	boolean disp = true;
	javax.swing.Timer T;
	String stim = "resources/javaim.png";
	String ruleim = "resources/rules.png";
	String bim = "resources/bim.png";
	String bim2 = "resources/bim3.png";
	String[] ibricks = {"resources/brickv3.png",
				"resources/brickb1.png",
				"resources/bricksb1.png",
				"resources/bricksb3.png",
				"resources/brickc3.png"};

       	public OpTargetBricks()
	{
	
		final ImageIcon icon = new ImageIcon(this.getClass().getResource(stim));
		final ImageIcon icon1 = new ImageIcon(this.getClass().getResource(bim));
		final ImageIcon icon2 = new ImageIcon(this.getClass().getResource(bim2));
		P = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				setBackground(Color.black);
				g.setColor(Color.red);
				g.drawString("OPERATION - TARGET bRICKS",450,50);
				g.drawString("A java mini - project",502,100);
				g.drawImage(icon1.getImage(),200,180,this);
				g.drawImage(icon.getImage(),550,140,this);
				g.drawImage(icon2.getImage(),900,220,this);
				g.drawString("Presented by VENKATRAGHAVAN,PRASANTHI and SIVARAMAN",250,500);
				if(disp)
					g.drawString("Press SPACE to continue",400,600);
				disp = !disp;
			}
		};
		P.setForeground(Color.red);
		Font f1 = new Font("Ubuntu",Font.BOLD,30);
		P.setFont(f1);
		
		P.setLayout(new BorderLayout());
		//ImageIcon icon = new ImageIcon(this.getClass().getResource(stim));
		
		/*L = new JLabel();
		L1 = new JLabel("OPERATION - TARGET bRICKS");
		L2 = new JLabel("A java mini - project");
		L3 = new JLabel("Presented by VENKATRAGHAVAN,PRASANTHI and SIVARAMAN");
		L.setIcon(icon);
		P.add(L3,BorderLayout.NORTH);
		P.add(L1,BorderLayout.WEST);
		P.add(L2,BorderLayout.EAST);
		P.add(L,BorderLayout.CENTER);*/
		//P.add(sb,BorderLayout.SOUTH);
		//P.setPreferredSize(new Dimension(500,300));
		add(P);
		setTitle("Starting");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(550,400);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setVisible(true);
		//}
		/*else
		{
			setExtendedState(Frame.NORMAL);
				setSize(600,420);
				initB();
		}*/
		addKeyListener(new FirstKey());
		T = new javax.swing.Timer(1000,new Firstdisp());
		T.start();
	}

	public class Firstdisp implements ActionListener
	{
		public void actionPerformed(ActionEvent E)
		{
			P.repaint();
		}
	}

	public class FirstKey extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode()==' ')
			{
				T.stop();
				remove(P);
				setExtendedState(Frame.MAXIMIZED_BOTH);
				setSize(300,400);
				//revalidate();
				//repaint();
				rulePanel2();
			}
		}
	}

	public void rulePanel()
	{
		
		P2 = new JPanel();
		P2.setBackground(Color.white);
		//P2.setPreferredSize(new Dimension(500,300));
		P2.setLayout(new BorderLayout());
		setSize(800,300);
		L4 = new JLabel();
		f = new Font("Ubuntu",Font.BOLD,20);
		
		rules = new JTextArea(3,30);
		rules.setText("");
		rules.setFont(f);
		rules.append("# The game consists of a grid of bricks\n");
		rules.append("# A paddle is provided at the bottom of the screen\n");
		rules.append("# TARGET the bricks using the ball and the paddle");
		ImageIcon icon = new ImageIcon(this.getClass().getResource(ruleim));
		L4.setIcon(icon);
		sb2 = new JButton("Start the GAME!!");
		sb2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent E)
			{
				remove(P2);
				setExtendedState(Frame.NORMAL);
				setSize(600,420);
				initB();
			}
		});
		P2.add(L4,BorderLayout.WEST);
		P2.add(rules,BorderLayout.EAST);
		P2.add(sb2,BorderLayout.SOUTH);
		setBackground(Color.BLACK);
		add(P2);
		setTitle("RULES");
        	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        	//setSize(Commons.WIDTH, Commons.HEIGTH);
        	setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public void rulePanel2()
	{
	
		final ImageIcon icon = new ImageIcon(this.getClass().getResource(ruleim));
		final ImageIcon i1 = new ImageIcon(this.getClass().getResource(ibricks[4]));
		final ImageIcon i2 = new ImageIcon(this.getClass().getResource(ibricks[0]));
		final ImageIcon i3 = new ImageIcon(this.getClass().getResource("resources/lives.png"));
		P2 = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				addKeyListener(new SecondKey());
				setBackground(Color.black);
				g.setColor(Color.red);
				g.drawImage(icon.getImage(),420,40,this);
				g.drawString("# The game consists of a grid of bricks\n",250,370);
				g.drawString("# A paddle is provided at the bottom of the screen\n",250,400);
				g.drawString("# TARGET the bricks using the ball and the paddle",250,430);
				g.drawString("# The Colour of the brick indicates its hardness",250,460);
				g.drawImage(i1.getImage(),300,490,this);
				g.drawImage(i2.getImage(),610,490,this);
				g.drawString("Weakest - 1 HIT!",250,540);
				g.drawString("Strongest - 5 HITS!!",530,540);
				g.drawString("# Press 'p' to pause/unpause the game",250,570);
				g.drawString("# Press 'q' to quit",250,600);
				g.drawString("# The ",250,630);
				g.drawImage(i3.getImage(),340,610,this);
				g.drawString("represents lives left",380,630);
				if(disp)
					g.drawString("Press SPACE to start!!",480,720);
				disp = !disp;
			}
		};
		addKeyListener(new SecondKey());

		InputMap imap = P2.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		ActionMap amap = P2.getActionMap();
		imap.put(KeyStroke.getKeyStroke(" "),"start");
		amap.put("start",new AbstractAction()
		{
			public void actionPerformed(ActionEvent E)
			{
					System.out.println("rrr");
					T.stop();
					remove(P2);
					setExtendedState(Frame.NORMAL);
					setSize(600,420);
					initB();
				
			}
		});
		Font f1 = new Font("Ubuntu",Font.BOLD,30);
		P2.setFont(f1);
		P2.addKeyListener(new SecondKey());
		P2.setFocusable(true);
		setSize(800,600);
		add(P2);
		setTitle("RULES");
        	setDefaultCloseOperation(EXIT_ON_CLOSE);
		T = new javax.swing.Timer(1000,new Seconddisp());
		T.start();
        	//setSize(Commons.WIDTH, Commons.HEIGTH);
        	setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public class Seconddisp implements ActionListener
	{
		public void actionPerformed(ActionEvent E)
		{
			P2.repaint();
		}
	}

	public class SecondKey extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			//if(e.getKeyCode()==' ')
			{
				//System.out.println("rrr");
				T.stop();
				remove(P2);
				setExtendedState(Frame.NORMAL);
				setSize(600,420);
				initB();
			}
		}
		public void keyReleased(KeyEvent e)
		{
			//System.out.println("rrre");
		}
		public void keyTyped(KeyEvent e)
		{
			//System.out.println("rrrq");
		}
	}

	public void initB()
	{
		MPanel M1 = new MPanel();
		
		M1.setBackground(Color.pink);
        	add(M1);
        	setTitle("Operation - TARGET BRICKS");
        	//setDefaultCloseOperation(EXIT_ON_CLOSE);
        	setSize(Commons.WIDTH, Commons.HEIGTH);
        	setLocationRelativeTo(null);
        	setIgnoreRepaint(true);
        	setResizable(false);

	}
	
	
    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable()
	{
		public void run()
		{
 	      		OpTargetBricks O =  new OpTargetBricks();
		}
	});
    }
}
