package com.brandenkeck.nocksbigadventure;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;


public class ScreenItems {
	
	public static BufferedImage currentHB, currentIB, currentItem, currentD;
	public static BufferedImage overlay1, overlay2, precipitation1, precipitation2, precipitation3, noise1, noise2, noise3;
	private static Random getR = new Random();
	private static int R1, R2, R3;
	private static int OTicker1 = 1;
	private static int OTicker2 = 1;
	private static int PTicker = 1;
	
	public static boolean precR[] = new boolean[300];
	public static int precX[] = new int[300];
	public static int precY[] = new int[300];
	public static int precVelx[] = new int[300];
	public static int precVely[] = new int[300];
	
	public static boolean noiseR[] = new boolean[100];
	public static int noiseX[] = new int[100];
	public static int noiseY[] = new int[100];
	public static int noiseVelx[] = new int[100];
	public static int noiseVely[] = new int[100];
	
	public static Player player = new Player();
	public static int scroll=1;
	public Rectangle ta = new Rectangle((int)((MainGame.xSize)/2-(300*MainGame.xScalingFactor)), (int) (700*MainGame.yScalingFactor), (int)(600*MainGame.xScalingFactor), (int)(300*MainGame.yScalingFactor));;
	public static int faded = 1;
	private int c=1;

	public void healthbar(Graphics g){
		if(Player.health<0){Player.health=0;}
		currentHB = SpriteObj(ResourceManager.HealthBar, 500, 150, 51-Player.health, 1);
		g.drawImage(currentHB, 50, 30, (int) MainGame.xScalingFactor*500, (int) MainGame.yScalingFactor*150, null);	
	}
	
	public void itembar(Graphics g){
		
		g.drawImage(SpriteObj(ResourceManager.ItemBar, 500, 150, 1, 1), MainGame.xSize-550, 30,(int) MainGame.xScalingFactor*500, (int) MainGame.yScalingFactor*150, null);
		
		for(int i=1; i<=9; i++){
			if(Environment.itemCollected[i]){
				currentIB=SpriteObj(ResourceManager.ItemBar, 500, 150, i+1, 1);
				g.drawImage(currentIB, MainGame.xSize-550, 30,(int) MainGame.xScalingFactor*500, (int) MainGame.yScalingFactor*150, null);
			}
		}
		
		for(int i=1; i<=9; i++){
			if(Environment.currentWeapon == i){
				currentItem=SpriteObj(ResourceManager.Current, 500, 150, i, 1);
				g.drawImage(currentItem, MainGame.xSize-550, 30,(int) MainGame.xScalingFactor*500, (int) MainGame.yScalingFactor*150, null);
			}
		}
		
	}
	
	public void dialog(Graphics g){
		g.drawImage(currentD, 0, 0, (int) (MainGame.xSize), (int) (MainGame.ySize), null);
	}
	
	public void pause(Graphics g){
		g.drawImage(ResourceManager.Pause, 0, 0, (int) (MainGame.xSize), (int) (MainGame.ySize), null);
	}
	
	public void cutscene(Graphics g){
		g.drawImage(ResourceManager.SpriteObj(ResourceManager.Cutscene, 1920, 1080, scroll, 1), 0, 0, (int) (1920*MainGame.xScalingFactor), (int) (1080*MainGame.yScalingFactor), null);
		g.drawImage(ResourceManager.SpriteObj(ResourceManager.Instructions, 800, 200, c, 1), MainGame.xSize-((int) (800*MainGame.xScalingFactor)), 0, (int) (800*MainGame.xScalingFactor), (int) (200*MainGame.yScalingFactor), null);
		
		c+=MainGame.currentTickCount%2;
		if(c>46){c=1;}
		
		int i = MainGame.currentTickCount%10;
		if(i==0){scroll++;}
		if(scroll>21){scroll=21;}
	}
	
	public static void createWeather(Graphics g){
		if(player.wrath){
			wrathOfGod(g);
		}
		else{			
			switch(MainGame.state){
				case LEVEL1:
					if(MainGame.currentTickCount%5==0){OTicker1+=MainGame.currentTickCount%2;}
					if(OTicker1>13){OTicker1=1;}
					
					overlay1 = ResourceManager.SpriteObj(ResourceManager.RainOverlay, 50, 50, (int)(OTicker1), 1);
					precipitation1 = ResourceManager.Rain;
					
					for(int k = 0; k<=99; k++){
						R1 = getR.nextInt(50);
						R2 = getR.nextInt(50);
						R3 = getR.nextInt(50);
						if(!precR[k]){
							precR[k]=true;
							precX[k]=(int) (10+(k%10+1)*(MainGame.xSize/10));
							precY[k]=(k%10+1)*k;
						}
						else{
							precX[k]+=precVelx[k];
							precY[k]+=precVely[k];
						}
						
						precVelx[k]=-5+R1%(k+1)-R3%(k+1);
						precVely[k]=50-R2%(k+1);
						
						if(precY[k]>MainGame.ySize+50){
							precR[k]=false;
						}
						
						g.drawImage(precipitation1, precX[k], precY[k], (int)(5*MainGame.xScalingFactor), (int)(10*MainGame.yScalingFactor), null);
					}
					
					if(player.warped){
						overlay1 = ResourceManager.TimeOverlay;
					}
					g.drawImage(overlay1, 0, 0, MainGame.xSize, MainGame.ySize, null);
					
				break;
				case LEVEL2:
					if(MainGame.currentTickCount%5==0){OTicker1+=MainGame.currentTickCount%2;}
					if(OTicker1>9){OTicker1=1;}
					PTicker+=MainGame.currentTickCount%2;
					if(PTicker>8){PTicker=1;}
					
					overlay1 = ResourceManager.SpriteObj(ResourceManager.LavaOverlay, 20, 20, (int)(OTicker1), 1);
					precipitation1 = ResourceManager.Ash;
					precipitation2 = ResourceManager.Ember;
					
					for(int k = 0; k<=99; k++){
						R1 = getR.nextInt(50);
						R2 = getR.nextInt(50);
						R3 = getR.nextInt(50);
						if(!precR[k]){
							precR[k]=true;
							precX[k]=(int) (10+(k%10+1)*(MainGame.xSize/10));
							precY[k]=(k%10+1)*k;
						}
						else{
							precX[k]+=precVelx[k];
							precY[k]+=precVely[k];
						}
						
						precVelx[k]=-5+R1%(k+1)-R3%(k+1);
						precVely[k]=50-R2%(k+1);
						
						if(precY[k]>MainGame.ySize+50){
							precR[k]=false;
						}
						
						g.drawImage(precipitation1, precX[k], precY[k], (int)(10*MainGame.xScalingFactor), (int)(10*MainGame.yScalingFactor), null);
					}
					
					for(int k = 100; k<=199; k++){
						R1 = getR.nextInt(50);
						R2 = getR.nextInt(50);
						R3 = getR.nextInt(500);
						if(!precR[k]){
							precR[k]=true;
							precX[k]=(int) (10+(k%10+1)*(MainGame.xSize/10));
							precY[k]=(k%10+1)*k;
						}
						else{
							precX[k]+=precVelx[k];
							precY[k]+=precVely[k];
						}
						
						precVelx[k]=-5+R1%(k+1)-R3%(k+1);
						precVely[k]=50-R2%(k+1);
						
						if(precY[k]>MainGame.ySize+50){
							precR[k]=false;
						}
						
						g.drawImage(ResourceManager.SpriteObj(precipitation2, 3, 3, PTicker, 1), precX[k], precY[k], (int)(10*MainGame.xScalingFactor), (int)(10*MainGame.yScalingFactor), null);
					}
					
					if(player.warped){
						overlay1 = ResourceManager.TimeOverlay;
					}
					g.drawImage(overlay1, 0, 0, MainGame.xSize, MainGame.ySize, null);
				break;
			}
			
		}
	}
	
	public static void BackgroundNoise(Graphics g){
		if(player.wrath){
			//wrathOfGod(g);
		}
		else{
			switch(MainGame.state){
				case LEVEL1:
					noise1 = ResourceManager.Cloud1;
					noise1 = ResourceManager.Cloud2;
					noise1 = ResourceManager.Cloud3;
					
					for(int k = 0; k<=5; k++){
						if(!noiseR[k]){
							noiseR[k]=true;
							noiseX[k]=(int) (player.x+(k*3000));
							noiseY[k]=100+50*k%3;
						}
						else{
							noiseX[k]+=noiseVelx[k];
							noiseY[k]+=noiseVely[k];
						}
						
						noiseVelx[k]=-5;
						noiseVely[k]=0;
						
						if(noiseX[k]<-2000){
							noiseR[k]=false;
						}
						
						g.drawImage(noise1, noiseX[k]-Environment.BGx, noiseY[k]-Environment.BGy, (int)(780*MainGame.xScalingFactor), (int)(190*MainGame.yScalingFactor), null);
					}
					
					for(int k = 6; k<=10; k++){
						if(!noiseR[k]){
							noiseR[k]=true;
							noiseX[k]=(int) (player.x+(300+k*1500));
							noiseY[k]=100+75*k%2;
						}
						else{
							noiseX[k]+=noiseVelx[k];
							noiseY[k]+=noiseVely[k];
						}
						
						noiseVelx[k]=-2;
						noiseVely[k]=0;
						
						if(noiseX[k]<-2000){
							noiseR[k]=false;
						}
						
						g.drawImage(noise2, noiseX[k]-Environment.BGx, noiseY[k]-Environment.BGy, (int)(780*MainGame.xScalingFactor), (int)(190*MainGame.yScalingFactor), null);
					}
					
					for(int k = 11; k<=17; k++){
						if(!noiseR[k]){
							noiseR[k]=true;
							noiseX[k]=(int) (player.x+(450+k*3750));
							noiseY[k]=100+25*k;
						}
						else{
							noiseX[k]+=noiseVelx[k];
							noiseY[k]+=noiseVely[k];
						}
						
						noiseVelx[k]=-4;
						noiseVely[k]=0;
						
						if(noiseX[k]<-2000){
							noiseR[k]=false;
						}
						
						g.drawImage(noise3, noiseX[k]-Environment.BGx, noiseY[k]-Environment.BGy, (int)(780*MainGame.xScalingFactor), (int)(190*MainGame.yScalingFactor), null);
					}
				break;
				/*case LEVEL2:
					noise1 = ResourceManager.SpriteObj(ResourceManager.Explode, 128, 128, 1, 1);
					if(MainGame.currentTickCount%8==0){PTicker++;}
					if(PTicker>10){PTicker=1;}
					if(MainGame.currentTickCount%7==0){OTicker1++;}
					if(OTicker1>10){OTicker1=1;}
					if(MainGame.currentTickCount%9==0){OTicker2++;}
					if(OTicker2>10){OTicker2=1;}
					
					for(int k = 0; k<=25; k++){
						if(!noiseR[k]){
							R1 = getR.nextInt(5000);
							R2 = getR.nextInt(500)+580;
							noiseR[k]=true;
							noiseX[k]=(int) (R1+Environment.BGx/10);
							noiseY[k]=R2;
						}
						else{			
							if(k%2==0 && k%3!=0){noise1 = ResourceManager.SpriteObj(ResourceManager.Explode, 128, 128, OTicker1, 1);}
							else if(k%2==0){noise1 = ResourceManager.SpriteObj(ResourceManager.Explode, 128, 128, OTicker2, 1);}
							else{noise1 = ResourceManager.SpriteObj(ResourceManager.Explode, 128, 128, PTicker, 1);}
							
							g.drawImage(noise1, (int) (noiseX[k]-Environment.BGx/10), noiseY[k], (int)(128*MainGame.xScalingFactor), (int)(128*MainGame.yScalingFactor), null);
							
							if(k%2==0 && k%3!=0 && OTicker1 == 10){
								noiseR[k]=false;
								OTicker1=1;
							}
							else if(k%2==0 && OTicker2 == 10){
								noiseR[k]=false;
								OTicker2=1;
							}
							else if(PTicker == 10){
								noiseR[k]=false;
								PTicker=1;
							}
						}
					}
				break;*/
				case BOSS2:
					noise1 = ResourceManager.Stars;
					
					for(int k = 0; k<=99; k++){
						R1 = getR.nextInt(50);
						R2 = getR.nextInt(50);
						R3 = getR.nextInt(50);
						if(!noiseR[k]){
							noiseR[k]=true;
							noiseX[k]=(int) (10+(k%10+1)*(MainGame.xSize/10));
							noiseY[k]=(k%10+1)*k;
						}
						else{
							noiseX[k]+=noiseVelx[k];
							noiseY[k]+=noiseVely[k];
						}
						
						noiseVelx[k]=-50+R1%(k+1)-R3%(k+1);
						noiseVely[k]=30-R2%(k+1);
						
						if(noiseY[k]>MainGame.ySize+Environment.BGx){
							noiseR[k]=false;
						}
						else{
							g.drawImage(noise1, noiseX[k], noiseY[k], (int)(25*MainGame.xScalingFactor), (int)(25*MainGame.yScalingFactor), null);
						}
					}
				break;
				case LEVEL3:
					noise1 = ResourceManager.Stars;
					
					for(int k = 0; k<=5; k++){
						R1 = getR.nextInt(1000);
						R2 = getR.nextInt(500);
						R3 = getR.nextInt(500);
						if(!noiseR[k]){
							noiseR[k]=true;
							noiseX[k]=R1+R2+R3+k*500;
							noiseY[k]=-30-R1*3-R2-R3*5;
						}
						else{
							noiseX[k]+=noiseVelx[k];
							noiseY[k]+=noiseVely[k];
						}
						
						noiseVelx[k]=-20+(int)(R3/50);
						noiseVely[k]=30+(int)(R3/50);
						
						if(noiseY[k]>8000){
							noiseR[k]=false;
						}
						else{
							g.drawImage(noise1, noiseX[k], noiseY[k], (int)(25*MainGame.xScalingFactor), (int)(25*MainGame.yScalingFactor), null);
						}
					}
				break;
				case BOSS3:
					if(MainGame.currentTickCount%4==0){PTicker++;}
					if(PTicker>16){PTicker=1;}
					if(MainGame.currentTickCount%7==0){OTicker1++;}
					if(OTicker1>16){OTicker1=1;}
					if(MainGame.currentTickCount%5==0){OTicker2++;}
					if(OTicker2>16){OTicker2=1;}
					
					precipitation1 = ResourceManager.SpriteObj(ResourceManager.Comp, 500, 1000, PTicker%16+1, 1);
					precipitation2 = ResourceManager.SpriteObj(ResourceManager.Comp, 500, 1000, 16-OTicker1%16, 1);
					precipitation3 = ResourceManager.SpriteObj(ResourceManager.Comp, 500, 1000, 16-OTicker2%16, 1);
					noise1 = ResourceManager.SpriteObj(ResourceManager.Comp, 500, 1000, OTicker1%16+1, 1);
					noise2 = ResourceManager.SpriteObj(ResourceManager.Comp, 500, 1000, OTicker2%16+1, 1);
					noise3 = ResourceManager.SpriteObj(ResourceManager.Comp, 500, 1000, 16-PTicker%16, 1);
					
					g.drawImage(noise3, 0-Environment.BGx, 2000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation2, 500-Environment.BGx, 2000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation2, 1000-Environment.BGx, 2000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation3, 1500-Environment.BGx, 2000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(noise1, 2000-Environment.BGx, 2000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation1, 2500-Environment.BGx, 2000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation1, 3000-Environment.BGx, 2000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(noise1, 3500-Environment.BGx, 2000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					
					g.drawImage(precipitation1, 0-Environment.BGx, 1000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation2, 500-Environment.BGx, 1000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(noise1, 1000-Environment.BGx, 1000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(noise2, 1500-Environment.BGx, 1000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(noise1, 2000-Environment.BGx, 1000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation2, 2500-Environment.BGx, 1000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation3, 3000-Environment.BGx, 1000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(noise3, 3500-Environment.BGx, 1000-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					
					g.drawImage(precipitation3, 0-Environment.BGx, 0-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(noise3, 500-Environment.BGx, 0-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation2, 1000-Environment.BGx, 0-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation1, 1500-Environment.BGx, 0-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(precipitation3, 2000-Environment.BGx, 0-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(noise1, 2500-Environment.BGx, 0-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(noise3, 3000-Environment.BGx, 0-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
					g.drawImage(noise2, 3500-Environment.BGx, 0-Environment.BGy, (int)(500*MainGame.xScalingFactor), (int)(1000*MainGame.yScalingFactor), null);
				break;
			}
		}
	}
	
	public static void wrathOfGod(Graphics g){
		OTicker1 = 1;
		noise1 = ResourceManager.BlackCloud;
		noise1 = ResourceManager.BlackCloud2;
		noise1 = ResourceManager.BlackCloud3;
		overlay1 = ResourceManager.SpriteObj(ResourceManager.LavaOverlay, 20, 20, (int)(OTicker1), 1);
		precipitation1 = ResourceManager.Blood;
		
		OTicker1+=MainGame.currentTickCount%2;
		OTicker2+=MainGame.currentTickCount%2;
		PTicker+=MainGame.currentTickCount%2;
		if(OTicker1>9){OTicker1=1;}
		if(OTicker2>9){OTicker2=1;}
		if(PTicker>8){PTicker=1;}
		
		for(int k = 0; k<=299; k++){
			R1 = getR.nextInt(50);
			R2 = getR.nextInt(50);
			R3 = getR.nextInt(50);
			if(!precR[k]){
				precR[k]=true;
				precX[k]=(int) (10+(k%10+1)*(MainGame.xSize/10));
				precY[k]=(k%10+1)*k;
			}
			else{
				precX[k]+=precVelx[k];
				precY[k]+=precVely[k];
			}
			
			precVelx[k]=-5+R1%(k+1)-R3%(k+1);
			precVely[k]=50-R2%(k+1);
			
			if(precY[k]>MainGame.ySize+50){
				precR[k]=false;
			}
			
			g.drawImage(precipitation1, precX[k], precY[k], (int)(5*MainGame.xScalingFactor), (int)(10*MainGame.yScalingFactor), null);
		}
		
		g.drawImage(overlay1, 0, 0, MainGame.xSize, MainGame.ySize, null);
		
		for(int k = 50; k<=79; k++){
			if(!noiseR[k]){
				noiseR[k]=true;
				noiseX[k]=(int) (player.x+(k*1500));
				noiseY[k]=100+50*k%3;
			}
			else{
				noiseX[k]+=noiseVelx[k];
				noiseY[k]+=noiseVely[k];
			}
			
			noiseVelx[k]=-10;
			noiseVely[k]=0;
			
			if(noiseX[k]<-2000){
				noiseR[k]=false;
			}
			
			g.drawImage(noise1, noiseX[k]-Environment.BGx, noiseY[k]-Environment.BGy, (int)(780*MainGame.xScalingFactor), (int)(190*MainGame.yScalingFactor), null);
		}
		
		for(int k = 80; k<=99; k++){
			if(!noiseR[k]){
				noiseR[k]=true;
				noiseX[k]=(int) (player.x+(300+k*700));
				noiseY[k]=100+75*k%2;
			}
			else{
				noiseX[k]+=noiseVelx[k];
				noiseY[k]+=noiseVely[k];
			}
			
			noiseVelx[k]=-2;
			noiseVely[k]=0;
			
			if(noiseX[k]<-2000){
				noiseR[k]=false;
			}
			
			g.drawImage(noise2, noiseX[k]-Environment.BGx, noiseY[k]-Environment.BGy, (int)(780*MainGame.xScalingFactor), (int)(190*MainGame.yScalingFactor), null);
		}
		
	}
	
	public void gameover(Graphics g){
		int ctc = MainGame.currentTickCount%5;
		if(ctc == 0 && faded<=26){
			faded++;
		}
			
		g.drawImage(SpriteObj(ResourceManager.GameOver, 1920, 1080, faded, 1), 0, 0, (int) MainGame.xScalingFactor*1920, (int) MainGame.yScalingFactor*1080, null);
	
		if(faded>=26){
			g.drawImage(ResourceManager.tryagain, ((int)((MainGame.xSize)/2-(300*MainGame.xScalingFactor))), (int) (700*MainGame.yScalingFactor), (int)(600*MainGame.xScalingFactor), (int)(300*MainGame.yScalingFactor), null);
		}
	}

	public static BufferedImage SpriteObj(BufferedImage image, int width, int height, int col, int row){
		return image.getSubimage((col*width) - width, (row*height)-height, width, height);
	}
}
