/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package choujiang;

import java.awt.*;

/**
 *
 * @author fly
 */
public class MyButton extends Rectangle{

	Color color=Color.blue;
	String title;
	Font font;
	Image picture=null;
	MyButton(String title,int x, int y, int w, int h) {
		super(x,y,w,h);
		this.title=title;
		font=ChouJiang.font;
	}
	
	public void setPicture(Image picture)
	{
		this.picture=picture;
	}
	
	public void setColor(Color c)
	{
		color=c;
	}
	public void draw(Graphics g)
	{
		//绘制按键
		if(picture==null)
		{
			Color c=g.getColor();
			Font f=g.getFont();
			g.setColor(color);
			g.setFont(font);
			g.fillRoundRect(x, y, width, height,10,10);
			g.setColor(Color.black);
			g.drawRoundRect(x, y, width, height,10,10);
			g.drawString(title, x+5, y+height-5);
			g.setColor(c);
			g.setFont(f);
		}else{
			g.drawImage(picture, x, y, width, height, null);
		}

	}
}
