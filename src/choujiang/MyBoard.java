/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package choujiang;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xxgyf
 */
public class MyBoard extends Rectangle implements Runnable{
	char ch='0';
	int num;
	int stat=1;
	int ey=0,dy=7;
	boolean f=false;
	public MyBoard(char c,int x,int y,int n)
	{
		super(x,y,ChouJiang.boardsize.width,ChouJiang.boardsize.height);
		this.ch=c;
		num=n;
	}
	public void set(char c)
	{
		if(f)return;
		this.ch=c;
		ey=0;
	}
	public boolean addy()
	{
		//下降
		ey+=dy;
		if(dy!=1)dy--;
		return ey<50;
	}
	public void draw(Graphics g)
	{
			Color c=g.getColor();
			Font f=g.getFont();
			
			g.setColor(Color.white);
			
			g.setFont(new Font("Dialog",Font.PLAIN,150));
			//System.out.println(g.getFont());
			g.fillRoundRect(x, y, width, height,5,5);
			
			//g.setColor(new Color((float)Math.random(),(float)Math.random()*0.5f,(float)Math.random()));
			
			g.setColor(Color.black);
			
			g.drawRoundRect(x, y, width, height,5,5);
		if(1==stat)
		{
			//绘制数字位置
			g.drawString(String.valueOf(ch), x, y+height/2+20+ey);

		}else if(0==stat){
			g.setColor(new Color(0,0,0,0.009f));
			for(int i=0;i<100;i++)
			{
//				co = (float)Math.random();
				g.drawString(Integer.toString((int)(Math.random()*ChouJiang.di),ChouJiang.di), x, y+height/2+10+(int)(Math.random()*60));
			}
		}
			
			g.setColor(c);
			g.setFont(f);
	}

	@Override
	public void run() {
		//数字或字母连续下落
		f=true;
		try {
			Thread.sleep(1000*(num+1));
			//Thread.sleep(1000*(num*num*num+1));//一等奖时用这个，比较皮。
			//if(num==2)Thread.sleep(10000);
			stat=1;
			while(addy())
			Thread.sleep(10);
			Thread.sleep(100);
			//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		} catch (InterruptedException ex) {
			Logger.getLogger(MyBoard.class.getName()).log(Level.SEVERE, null, ex);
		}
		f=false;
	}
}
