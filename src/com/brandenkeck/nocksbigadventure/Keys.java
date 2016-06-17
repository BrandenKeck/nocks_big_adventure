package com.brandenkeck.nocksbigadventure;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class Keys extends KeyAdapter{

	public static boolean[] keyDown = new boolean[6];
	public static boolean jumping = false;
	public static boolean fireUp = false;
	public static boolean fighting = false;
	public static int lastKey;
	public static BufferedImage character;
	
	private Player player = new Player();
	private Environment environment = new Environment();
	
	public Keys(){
		character = player.still();
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		switch(MainGame.state){
		case DIALOG:
			if(key == KeyEvent.VK_ESCAPE){
				for(int i = 0; i<4; i++){
					keyDown[i]=false;
				}
				player.intstruct=false;
				player.velx=0;
				player.vely=0;
				MainGame.state = MainGame.prevState;
			}
			break;
		case CUTSCENE:
			if(key == KeyEvent.VK_SPACE){
					MainGame.add = new Adder();
					ScreenItems.scroll=1;
					for(int i = 0; i<4; i++){
						keyDown[i]=false;
					}
					player.velx=0;
					player.vely=0;
					MainGame.state=MainGame.nextState;
			}
			break;
		case GAME_OVER:
			break;
		case LOADING:
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			if(key == KeyEvent.VK_ESCAPE){
				MainGame.state=MainGame.prevState;
			}
			break;
		default:
			if(key == KeyEvent.VK_W){
				if(!fighting){
					keyDown[0]=true;
					fireUp=true;
					character = player.up();
				}
			}
			if(key == KeyEvent.VK_S){
				if(!fighting){
					keyDown[1]=true;
					character = player.duck();
				}
			}
			if(key == KeyEvent.VK_A){
				if(!fighting){
					player.velx=-10;
					keyDown[2]=true;
					lastKey = 2;
				}
			}
			if(key == KeyEvent.VK_D){
				if(!fighting){
					player.velx=10;
					keyDown[3]=true;
					lastKey = 3;
				}
			}
			if(key == KeyEvent.VK_E){
				Environment.nextItem();
			}
			if(key == KeyEvent.VK_Q){
				Environment.prevItem();
			}
			if(key == KeyEvent.VK_SPACE){
				if(!jumping && !fighting){
					keyDown[4]=true;
					player.velx=0;
					player.vely=0;
				}
			}
			if(key==KeyEvent.VK_F){
				fighting=true;
				keyDown[5]=true;
			}
			if(key == KeyEvent.VK_ESCAPE){
				MainGame.prevState = MainGame.state;
				MainGame.state=StateClass.PAUSE;
			}
			break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		switch(MainGame.state){
		case CUTSCENE:
			break;
		case DIALOG:
			break;
		case GAME_OVER:
			break;
		case LOADING:
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		default:
			if(key == KeyEvent.VK_W){
				keyDown[0]=false;
				fireUp=false;
				character=player.still();
			}
			if(key == KeyEvent.VK_S){
				keyDown[1]=false;
				character=player.still();
			}
			if(key == KeyEvent.VK_A){
				keyDown[2]=false;
				character=player.still();
			}
			if(key == KeyEvent.VK_D){
				keyDown[3]=false;
				character=player.still();
			}
			if(key == KeyEvent.VK_SPACE){
				if(!jumping){
					if(MainGame.state == StateClass.LEVEL4){player.vely=-20;}
					else{player.vely=-30;}
					jumping=true;
					keyDown[4]=false;
				}
				character=player.still();
			}
			if(key==KeyEvent.VK_F){
				RenderingClass.j=1;
				keyDown[5]=false;
				player.reset=true;
				fighting=false;
				character=player.still();
				
				if(player.state==StatePlayer.STAR && player.starred){
					player.starred = false;
					for(int k=1; k<5; k++){player.Pr[k]=false;}
					break;}
				else if(player.state==StatePlayer.STAR && !player.starred){
					player.starred = true;
					break;}
				
				if(player.state==StatePlayer.TIME_WARP && player.warped){
					player.wrath = false;
					player.warped = false;
					for(int k=1; k<5; k++){player.Pr[k]=false;}
					break;}
				else if(player.state==StatePlayer.TIME_WARP && !player.warped){
					player.wrath = false;
					player.warped=true;
					break;}
				
				if(player.state==StatePlayer.WRATH && player.wrath){
					player.warped = false;
					player.wrath = false;
					break;}
				else if(player.state==StatePlayer.WRATH && !player.wrath){
					player.warped = false;
					player.wrath=true;
					break;}
			}
			
			if(keyDown[2] && !keyDown[3]){
				player.velx=-10;
			}
			if(!keyDown[2] && keyDown[3]){
				player.velx=10;
			}
			if(!keyDown[2] && !keyDown[3]){
				player.velx=0;
			}
			break;
		}
	}

}
