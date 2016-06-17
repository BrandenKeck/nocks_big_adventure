package com.brandenkeck.nocksbigadventure;
import java.awt.Rectangle;

public class ScreenMovement {

	public static Player player = new Player();
	
	public ScreenMovement() {
		/*switch(MainGame.state){
		case BOSS1:
			if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=5;
			}
			if(player.getBounds().intersects(new Rectangle(MainGame.xSize-5, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=MainGame.xSize-5;
			}
			break;
		case BOSS2:
			if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=5;
			}
			if(player.getBounds().intersects(new Rectangle(MainGame.xSize-5, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=MainGame.xSize-5;
			}
			break;
		case LEVEL1:
			if(player.x>=MainGame.xSize-600){
				if(Environment.BGx>(Environment.level.getWidth()*MainGame.xScalingFactor-MainGame.xSize)){
					if(player.x>(MainGame.xSize-128*MainGame.xScalingFactor)){
						player.velx=0;
						player.x=(int) (MainGame.xSize-128*MainGame.xScalingFactor);
					}
				}
				else{
					Environment.BGx+=player.velx;
					player.x=MainGame.xSize-600;
				}
			}
			if(Environment.BGx>0){
				if(player.x<=600){
					Environment.BGx+=player.velx;
					player.x=600;
				}
			}
			if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=5;
			}
			break;
		case LEVEL3:
			if(player.y>=MainGame.ySize-(232*MainGame.yScalingFactor)){
				if(Environment.BGy<((int) (MainGame.yScalingFactor*3000-MainGame.ySize))){
						Environment.BGy+=player.vely;
						player.y=(int) (MainGame.ySize-(200*MainGame.yScalingFactor));
				}
				if(player.y>30000){
					MainGame.state = StateClass.GAME_OVER;
				}
			}
			if(player.y<0){
				if(Environment.BGy>0){Environment.BGy+=player.vely;}
				player.y=0;
			}
			if(player.x>=MainGame.xSize-600){
				if(Environment.BGx>(Environment.level.getWidth()*MainGame.xScalingFactor-MainGame.xSize)){
					if(player.x>(MainGame.xSize-128*MainGame.xScalingFactor)){
						player.velx=0;
						player.x=(int) (MainGame.xSize-128*MainGame.xScalingFactor);
					}
				}
				else{
					Environment.BGx+=player.velx;
					player.x=MainGame.xSize-600;
				}
			}
			if(Environment.BGx>0){
				if(player.x<=600){
					Environment.BGx+=player.velx;
					player.x=600;
				}
			}
			if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=5;
			}
			break;
		case BOSS3:
			if(player.y>=MainGame.ySize-(232*MainGame.yScalingFactor)){
				if(Environment.BGy<((int) (MainGame.yScalingFactor*3000-MainGame.ySize))){
						Environment.BGy+=player.vely;
						player.y=(int) (MainGame.ySize-(200*MainGame.yScalingFactor));
				}
				if(player.y>MainGame.ySize+50){
					player.health=0;
				}
			}
			if(player.y<0){
				if(Environment.BGy>0){Environment.BGy+=player.vely;}
				player.y=0;
			}
			if(player.x>=MainGame.xSize-600){
				if(Environment.BGx>(Environment.level.getWidth()*MainGame.xScalingFactor-MainGame.xSize)){
					if(player.x>(MainGame.xSize-128*MainGame.xScalingFactor)){
						player.velx=0;
						player.x=(int) (MainGame.xSize-128*MainGame.xScalingFactor);
					}
				}
				else{
					Environment.BGx+=player.velx;
					player.x=MainGame.xSize-600;
				}
			}
			if(Environment.BGx>0){
				if(player.x<=600){
					Environment.BGx+=player.velx;
					player.x=600;
				}
			}
			if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=5;
			}
			break;
		case LEVEL5:
			if(player.y>=MainGame.ySize-(300*MainGame.yScalingFactor)){
				if(Environment.BGy<((int) (MainGame.yScalingFactor*3000-MainGame.ySize))){
						while(player.y>=MainGame.ySize-(300*MainGame.yScalingFactor)){
							Environment.BGy+=1;
							player.y-=1;
						}
				}
				if(player.y>5000){
					MainGame.state = StateClass.GAME_OVER;
				}
			}
			if(player.y<=0){
				if(Environment.BGy>0){
						while(player.y<=0){
							Environment.BGy-=1;
							player.y+=1;
						};
				
				}
			}
			if(player.x>=MainGame.xSize-600){
				if(Environment.BGx>(Environment.level.getWidth()*MainGame.xScalingFactor-MainGame.xSize)){
					if(player.x>(MainGame.xSize-128*MainGame.xScalingFactor)){
						player.velx=0;
						player.x=(int) (MainGame.xSize-128*MainGame.xScalingFactor);
					}
				}
				else{
					Environment.BGx+=player.velx;
					player.x=MainGame.xSize-600;
				}
			}
			if(Environment.BGx>0){
				if(player.x<=600){
					Environment.BGx+=player.velx;
					player.x=600;
				}
			}
			if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=5;
			}
			break;
		case LEVEL6:
			if(player.y>=MainGame.ySize-(500*MainGame.yScalingFactor)){
				if(Environment.BGy<((int) (MainGame.yScalingFactor*5000-MainGame.ySize))){
						Environment.BGy+=10;
				}
			}
			if(player.y<=50){
				if(Environment.BGy>0){
						Environment.BGy-=10;
				}
			}
			if(player.x>=MainGame.xSize-600){
				if(Environment.BGx>(Environment.level.getWidth()*MainGame.xScalingFactor-MainGame.xSize)){
					if(player.x>(MainGame.xSize-128*MainGame.xScalingFactor)){
						player.velx=0;
						player.x=(int) (MainGame.xSize-128*MainGame.xScalingFactor);
					}
				}
				else{
					Environment.BGx+=player.velx;
					player.x=MainGame.xSize-600;
				}
			}
			if(Environment.BGx>0){
				if(player.x<=600){
					Environment.BGx+=player.velx;
					player.x=600;
				}
			}
			if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=5;
			}
			break;
		case BOSS6:
			if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=5;
			}
			if(player.getBounds().intersects(new Rectangle(MainGame.xSize-5, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=MainGame.xSize-205;
			}
			break;
		case LEVEL7:
			if(player.y>=MainGame.ySize-(500*MainGame.yScalingFactor)){
				if(Environment.BGy<((int) (MainGame.yScalingFactor*5000-MainGame.ySize))){
						Environment.BGy+=10;
				}
			}
			if(player.y<=50){
				if(Environment.BGy>0){
						Environment.BGy-=10;
				}
			}
			if(player.x>=MainGame.xSize-600){
				if(Environment.BGx>(Environment.level.getWidth()*MainGame.xScalingFactor-MainGame.xSize)){
					if(player.x>(MainGame.xSize-128*MainGame.xScalingFactor)){
						player.velx=0;
						player.x=(int) (MainGame.xSize-128*MainGame.xScalingFactor);
					}
				}
				else{
					Environment.BGx+=player.velx;
					player.x=MainGame.xSize-600;
				}
			}
			if(Environment.BGx>0){
				if(player.x<=600){
					Environment.BGx+=player.velx;
					player.x=600;
				}
			}
			if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=5;
			}
			break;
		default:
			if(player.y>=MainGame.ySize-(232*MainGame.yScalingFactor)){
				Environment.BGy+=player.vely;
				player.y=(int) (MainGame.ySize-(200*MainGame.yScalingFactor));
			}
			if(player.y<0){
				if(Environment.BGy>0){Environment.BGy+=player.vely;}
				player.y=0;
			}
			if(player.x>=MainGame.xSize-600){
				if(Environment.BGx>(Environment.level.getWidth()*MainGame.xScalingFactor-MainGame.xSize)){
					if(player.x>(MainGame.xSize-128*MainGame.xScalingFactor)){
						player.velx=0;
						player.x=(int) (MainGame.xSize-128*MainGame.xScalingFactor);
					}
				}
				else{
					Environment.BGx+=player.velx;
					player.x=MainGame.xSize-600;
				}
			}
			if(Environment.BGx>0){
				if(player.x<=600){
					Environment.BGx+=player.velx;
					player.x=600;
				}
			}
			if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
				player.velx=0;
				player.x=5;
			}
			break;
	
	}*/
	if(MainGame.state == StateClass.LEVEL1 || MainGame.state == StateClass.LEVEL3 || MainGame.state == StateClass.BOSS1 || MainGame.state == StateClass.BOSS4 || MainGame.state == StateClass.BOSS5){
		if(player.x>=MainGame.xSize-600){
			if(Environment.BGx>(Environment.level.getWidth()*MainGame.xScalingFactor-MainGame.xSize)){
				if(player.x>(MainGame.xSize-128*MainGame.xScalingFactor)){
					player.velx=0;
					player.x=(int) (MainGame.xSize-128*MainGame.xScalingFactor);
				}
			}
			else{
				Environment.BGx+=player.velx;
				player.x=MainGame.xSize-600;
			}
		}
		if(Environment.BGx>0){
			if(player.x<=600){
				Environment.BGx+=player.velx;
				player.x=600;
			}
		}
		if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
			player.velx=0;
			player.x=5;
		}
	}
	else{
		if(player.y>=MainGame.ySize-(500*MainGame.yScalingFactor)){
			if(MainGame.state == StateClass.LEVEL3 && Environment.BGy>3000){
				if(player.y>4000){
					MainGame.state = StateClass.GAME_OVER;
				}
			}
			else if(MainGame.state == StateClass.LEVEL5 && Environment.BGy>2000){
				if(player.y>3000){
					MainGame.state = StateClass.GAME_OVER;
				}
			}
			else{
				while(player.y>=MainGame.ySize-(500*MainGame.yScalingFactor)){
					Environment.BGy+=1;
					player.y-=1;
				}
			}
			
		}
		if(player.y<=500){
			if(Environment.BGy>0){
					while(player.y<=500){
						Environment.BGy-=1;
						player.y+=1;
					};
			
			}
		}
		if(player.x>=MainGame.xSize-600){
			if(Environment.BGx>(Environment.level.getWidth()*MainGame.xScalingFactor-MainGame.xSize)){
				if(player.x>(MainGame.xSize-128*MainGame.xScalingFactor)){
					player.velx=0;
					player.x=(int) (MainGame.xSize-128*MainGame.xScalingFactor);
				}
			}
			else{
				Environment.BGx+=player.velx;
				player.x=MainGame.xSize-600;
			}
		}
		if(Environment.BGx>0){
			if(player.x<=600){
				Environment.BGx+=player.velx;
				player.x=600;
			}
		}
		if(player.getBounds().intersects(new Rectangle(0, 0, 5, MainGame.ySize))){
			player.velx=0;
			player.x=5;
		}
	}
	
	if(Environment.BGx<0){Environment.BGx=0;}
	if(Environment.BGy<0){Environment.BGy=0;}
			
	}
	
	public static void shake(int shaker){
		if(shaker>500){shaker=0;}
		
		//Player.x+=(int) (2*Math.cos(Math.PI*2*shaker/500));
		//Environment.BGy+=(int) (50*Math.cos(Math.PI*2*shaker/500));
		
	}

}
