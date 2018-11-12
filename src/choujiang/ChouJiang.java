/**
 *
 *      
 * 
                                                                                                                         
                                                                                                                         
                                                ',,,#!!!!!!!!!!!!!!!!+,,,                                                
                                          ',#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!',,                                          
                                     ',#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!+,                                      
                                  ',!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!,,                                  
                               '#!!!!!!!!!!!!!!!!!!!"""'''''''''''"""!!!!!!!!!!!!!!!!!!!,,                               
                            ',!!!!!!!!!!!!!!!"'''''                   ''''""!!!!!!!!!!!!!!!,                             
                          ',!!!!!!!!!!!!!"'''                              '''`"!!!!!!!!!!!!!',                          
                        '#!!!!!!!!!!!!'''           ',,,,+++++++,,,,            ''"!!!!!!!!!!!!!,                        
                       '!!!!!!!!!!!'''        ',+!!!!!!!!!!!!!!!!!!!!!!!+,         ''"!!!!!!!!!!!'                       
                       ''"!!!!!!!''       ',!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!,        ''"!!!!!!!!!'                      
                         ''"!!!''      ',!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!,,      ''"!!!!!''                       
                            '''     ',!!!!!!!!!!!!!!!!!!"""""""""!!!!!!!!!!!!!!!!!!,      ''!"''                         
                                  ',!!!!!!!!!!!!!""'''''         ''''`""!!!!!!!!!!!!!,      '                            
                                 '!!!!!!!!!!!!'''                      '''"!!!!!!!!!!!!,                                 
                                  ''!!!!!!!'''     ',#!!!!!!!!!!!!!!,,     ''"!!!!!!!!!'                                 
                                    ''"!!''    ',!!!!!!!!!!!!!!!!!!!!!!!+,    '`!!!!"''                                  
                           ',,+'      '''   ',!!!!!!!!!!!!!!!!!!!!!!!!!!!!!,    '`"''                                    
                        '#!!''             ,!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'                                           
                       '!!!'              ''"!!!!!!!!!"'''''''''''"!!!!!!!!!!!'                                          
                       '!!!,                ''"!!!!'''   ,#!!!!!,  '''!!!!!!''        '`%,,                              
                        '!!!!,                ''"''    '!!!'''`"!!,   ''!"''            ''"!!,                           
                         '"!!!!,,                      !!!'    '"!!     '                 ''!!!                          
                          ''"!!!!!+,                   "!!      !!!                         '!!!                         
                            ''`"!!!!!!,,               '"!!,,,,!!!'                         '!!!                         
                               ''"!!!!!!!!+,            ''""!!!"''                         ,!!!'                         
                                  ''`"!!!!!!!!!+,,                                      ',!!!!''                         
                                     ''''"!!!!!!!!!!!!,,,,                         ',,!!!!!!''                           
                                          ''`"!!!!!!!!!!!!!!!!!!!+++,,,,,,,++!!!!!!!!!!!!"''                             
                                              ''''""!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"'''                                
                                                    '''''`'"""""!!!!!!!!!!!""""''''''                                    
                                                                 '''''''''                                          
				
											首 经 贸 起 点 计 算 机 协 会
 * 
 *                                                                                                                                                                                                                                                                                                              
 *                                                                                    **                                                                                                              ****                                                                                                      
 *              **********                                            **              **                                          ******************                                            ****************                                                                                                
 *          ********                                                  **              **                                        ****************                                                ****          ****                                                                                              
 *        ****                                                        **              **                                          **                                                            ****            **                                                                                              
 *      ****                                                          **              **                                          **                                                            ****          **                                                                                                
 *      **                                                            **              **                                          **                                                            ****        ****                                                                                                
 *    ****                                                          ****              **                                          **                                                            ****      ****                                                                                                  
 *    ****                                                          ****              **                                          ********************                                          ****  ************                                                                                              
 *    ****                                                          ****              **                                          ****          ****                                            **********    ******                                                                                            
 *    ****                                                          ****              **                                          **                                                          ******            ******                                                                                          
 *    ****                                                          ****              **                                          **                                                            **                ****                                                                                          
 *      ****                                                        ****            ***.*                                          **                                                            **              ******                                                                                          
 *      ******                                                      ****          ****                                            **                                                            **              ****                                                                                            
 *        ********                                                  ****        ****                                            ****            ******                                          **            ******                                                                                            
 *          ******************                                      **************                                              ****  **************  **                                        ******  **********                                                                                              
 *              **********                                            ********                                                    ******                                                            **********                                                                                                  
 * 
 ****************************************信息！！！**********************************
 */
package choujiang;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author xxgyf
 */
public class ChouJiang extends JPanel implements MouseListener{

	public static BufferedImage logo;
	public static Font font;

	public static Dimension boardsize=new Dimension(100,160);
	
	public static int di=10,start=0,end;
	public static ArrayList<String> blacknum=new ArrayList();
	
	private String num="NAN";

	MyButton xinxi;
	MyBoard[] board=new MyBoard[3];
	
	public void paint(Graphics g)
	{
		//绘制
		super.paint(g);
		xinxi.draw(g);
		for(int i=0;i<3;i++)
		{
			board[i].draw(g);
		}
		g.setFont(font);		
		g.setColor(Color.blue);
		g.drawString("2018信院迎新专用抽奖程序",80, 40);
	}
	
	public ChouJiang()
	{
		xinxi=new MyButton("信息！！",300,350,200,50);
		xinxi.setColor(Color.red);
		
		for(int i=0;i<3;i++)
		{
			board[i]=new MyBoard(num.charAt(i),220+i*(boardsize.width+20),100,i);
		}
		
		this.addMouseListener(this);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true)
				{
					repaint();
					try {
						//每60毫秒刷新一次
						Thread.sleep(60);
					} catch (InterruptedException ex) {
						Logger.getLogger(ChouJiang.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}
		}).start();
	}
	
	public void shownum(String num)
	{
		//设置要显示的数字
		this.num=num;
		for(int i=0;i<3;i++)
		{
			//设置单个位上要显示的数字
			board[i].stat=0;
			board[i].set(num.charAt(i));
			//启动数字下落的线程
			new Thread((Runnable) board[i]).start();
			new Thread().start();
		}

	}
	
	public static void main(String[] args) {
		//
		
		System.out.println("Hello CUEB!");
		
		//获取其他屏幕
		GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices =env.getScreenDevices();
		for(int i=0;i<devices.length;i++)System.out.println(i+":"+devices[i]);
		
		JWindow jw;
		JFrame jf;
		
		//新建并打开启动界面
		jw=new Begin();
		GraphicsDevice d=devices[devices.length-1];
		//在外接屏幕上居中显示
		jw.setLocation((int)(d.getDefaultConfiguration().getBounds().x+(d.getDefaultConfiguration().getBounds().getWidth()-jw.getWidth())/2),
			   (int)(d.getDefaultConfiguration().getBounds().y+(d.getDefaultConfiguration().getBounds().getHeight()-jw.getHeight())/2));
		try {
			//延长3秒
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			Logger.getLogger(ChouJiang.class.getName()).log(Level.SEVERE, null, ex);
		}
		//界面消失
		jw.setVisible(false);
		jw.dispose();
		jw=null;
		
		
		jf=new  JFrame();
		jf.add(new ChouJiang());
		//设置关闭结束
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//将计协logo设为图标
		jf.setIconImage(logo);
		
		JOptionPane.setRootFrame(jf);
		
		//输入数据
		String str;
		str=JOptionPane.showInputDialog("随机生成几进制数？","10");
		di=Integer.parseInt(str);
		str=JOptionPane.showInputDialog("start（闭区间）：","0");
		start=Integer.parseInt(str, di);
		str=JOptionPane.showInputDialog("end（闭区间）：","999");
		end=Integer.parseInt(str, di);
		System.out.println(di+":"+start+":"+end);
		
		//测试rand函数
		for(int i=0;i<100;i++){
			System.out.println(rand());
		}
		
		//新建主界面
		//设置大小、固定大小
		jf.setSize(800, 480);
		jf.setResizable(false);
		//居中显示
		jf.setLocation((int)(d.getDefaultConfiguration().getBounds().x+(d.getDefaultConfiguration().getBounds().getWidth()-jf.getWidth())/2),
			   (int)(d.getDefaultConfiguration().getBounds().y+(d.getDefaultConfiguration().getBounds().getHeight()-jf.getHeight())/2));
		
		//f.setLocationRelativeTo(null);
		//设为可见
		jf.setVisible(true);
	}
	
	/**根据号码生成随机数*/
	public static String rand(){
		return Integer.toString((int)(Math.random()*(end-start+1)+start),di);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		System.out.println(me.getPoint());
		//Rectangle r=new Rectangle(0,0,10,10);
		if(xinxi.contains(me.getPoint())){
			//单击信息！！！按钮
			//检测上一次抽奖是否结束
			if(board[0].f||board[1].f||board[2].f)return;//没结束就返回
			//生成随机数并检测是否重复生成，如果重复就继续，直到抽到新的为止
			String s;
			do{
				s=rand();
				int l=s.length();
				//一位数和两位数高位补零
				if(1==l)s="00"+s;
				else if(2==l)s="0"+s;
			}while(blacknum.indexOf(s)!=-1);
			//显示数字并加入“黑名单”
			shownum(s);
			blacknum.add(s);
			repaint();
		}
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mousePressed(MouseEvent me) {
		//鼠标按压按钮颜色变深
		if(xinxi.contains(me.getPoint())){
			xinxi.setColor(new Color(200,0,0));
			repaint();
		}
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		//释放还原
		if(xinxi.contains(me.getPoint())){
			xinxi.setColor(Color.red);
			repaint();
		}
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		System.out.println(me.getX()+","+me.getY());
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void mouseExited(MouseEvent me) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	static{
		//初始化logo和字体
		try {
			logo = ImageIO.read(ChouJiang.class.getResource("/logo.png"));
		} catch (IOException ex) {
			Logger.getLogger(ChouJiang.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		Font f=null;
		try {
			f=Font.createFont(Font.TRUETYPE_FONT, ChouJiang.class.getResourceAsStream("/BeiAn-Kai.ttf"));
				   } catch (FontFormatException ex) {
			Logger.getLogger(ChouJiang.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ChouJiang.class.getName()).log(Level.SEVERE, null, ex);
		}
		font=f.deriveFont(50.0f);
	}
}

class Begin extends JWindow{
	public void paint(Graphics g)
	{
		//绘图部分,这部分自己看吧。
		super.paint(g);
		//g.clearRect(0, 0, 200, 200);
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.setFont(ChouJiang.font);
		g.drawString("Hello CUEB!", 20,getHeight()-10);
		g.drawString("by:", 200, 200);
		g.drawImage(ChouJiang.logo, 250, 50, 270, 270, this);
		
		g.setColor(Color.blue);
		g.drawString("2018信院迎新专用抽奖程序", 20, 40);
	}
	
	public Begin()
	{
		//this.setIconImage(ChouJiang.logo);
		this.setSize(600, 400);
		//this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
