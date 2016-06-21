package com.brandenkeck.nocksbigadventure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Menu {

	public Rectangle p;
	public Rectangle o;
	public Rectangle q;
	public BufferedImage background;
	public int ctc = 1;
	
	public Menu(){
		
		p = new Rectangle((int)((MainGame.xSize)/2-(150*MainGame.xScalingFactor)), (int) (430*MainGame.yScalingFactor), (int)(300*MainGame.xScalingFactor), (int)(150*MainGame.yScalingFactor));
		//Rectangle o = new Rectangle();
		q = new Rectangle((int)((MainGame.xSize)/2-(150*MainGame.xScalingFactor)), (int) (600*MainGame.yScalingFactor), (int)(300*MainGame.xScalingFactor), (int)(150*MainGame.yScalingFactor));
		background = ResourceManager.titleBG;
	}
	
	public void tick(){
		int RAWctc = MainGame.currentTickCount%10;
		if(RAWctc == 0){
			ctc++;
			if(ctc>22){
				ctc=1;
			}
		}
	}
	
	public void render(Graphics g){
		tick();
		//g.drawImage(SpriteObj(background, 1920, 1080, ctc, 1), 0, 0, MainGame.xSize, MainGame.ySize, null);
		g.drawImage(ResourceManager.logo, (MainGame.xSize)/2-(int) (MainGame.xScalingFactor*430), 0, null);
		g.drawImage(ResourceManager.play, (MainGame.xSize)/2-(int) (MainGame.xScalingFactor*150), (int) (430*MainGame.yScalingFactor), null);
		//g.drawImage(ResourceManager.options, 500, 800, null);
		g.drawImage(ResourceManager.quit, (MainGame.xSize)/2-(int) (MainGame.xScalingFactor*150), (int) (600*MainGame.yScalingFactor), null);
	}

	public static BufferedImage SpriteObj(BufferedImage image, int width, int height, int col, int row){
		return image.getSubimage((col*width) - width, (row*height)-height, width, height);
	}
	
}
