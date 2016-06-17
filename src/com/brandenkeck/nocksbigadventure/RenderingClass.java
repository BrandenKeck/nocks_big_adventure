package com.brandenkeck.nocksbigadventure;
import java.awt.Color;
import java.awt.Graphics;

public class RenderingClass {
	
	public static int j=1;
	
	public  void RenderBackground(Graphics g){
		switch(MainGame.state){
		case LOADING:
			break;
		case PAUSE:
			MainGame.getInstance().renderBackground().background(g);
			MainGame.getInstance().getSprites().renderEnvironment(g);
			MainGame.getInstance().getScreenItems().pause(g);
			break;
		case MENU:
			MainGame.getInstance().getMenu().render(g);
			break;
		case CUTSCENE:
			MainGame.getInstance().renderBackground().background(g);
			MainGame.getInstance().getSprites().renderEnvironment(g);
			MainGame.getInstance().getScreenItems().cutscene(g);
			break;
		case DIALOG:
			MainGame.getInstance().renderBackground().background(g);
			MainGame.getInstance().getSprites().renderEnvironment(g);
			MainGame.getInstance().getScreenItems().dialog(g);
			break;
		case GAME_OVER:
			MainGame.getInstance().getScreenItems().gameover(g);
			break;
		default:
			MainGame.getInstance().renderBackground().background(g);
			MainGame.getInstance().getSprites().renderEnvironment(g);
			break;
		}
	}
	
	public void RenderForeground(Graphics g){
		switch(MainGame.state){
		case LOADING:
			break;
		case DIALOG:
			break;
		case MENU:
			break;
		case CUTSCENE:
			break;
		case GAME_OVER:
			break;
		case PAUSE:
			break;
		default:
			MainGame.getInstance().getSprites().renderProjectiles(g);
			if(Keys.keyDown[5]){
				int i = MainGame.currentTickCount%2;
				if(i==0){j++;}
				
				switch(Player.state){
				case SWORD:
					if(j>11){j=1;}
					MainGame.getInstance().getSprites().renderFight(g, j);
					break;
				case AXE:
					if(j>4){j=1;}
					MainGame.getInstance().getSprites().renderFight(g, j);
					break;
				case FLAME:
					if(j>1){j=1;}
					MainGame.getInstance().getSprites().renderFight(g, j);
					break;
				case LIGHTNING:
					if(j>1){j=1;}
					MainGame.getInstance().getSprites().renderFight(g, j);
					break;
				case STAR:
					if(j>1){j=1;}
					MainGame.getInstance().getSprites().renderFight(g, j);
					break;
				case MACE:
					if(j>9){j=1;}
					MainGame.getInstance().getSprites().renderFight(g, j);
					break;
				case SICKLE:
					if(j>5){j=1;}
					MainGame.getInstance().getSprites().renderFight(g, j);
					break;
				case TIME_WARP:
					if(j>1){j=1;}
					MainGame.getInstance().getSprites().renderFight(g, j);
					break;
				case WRATH:
					if(j>1){j=1;}
					MainGame.getInstance().getSprites().renderFight(g, j);
					break;
				default:
					MainGame.getInstance().getSprites().renderPlayer(g);
					break;
				}
			}
			else if(Keys.keyDown[4]){
				MainGame.getInstance().getSprites().renderJump(g);
			}
			else if(Keys.keyDown[3] || Keys.keyDown[2]){
				MainGame.getInstance().getSprites().renderWalking(g);
			}
			else{
				MainGame.getInstance().getSprites().renderPlayer(g);
			}
			

			MainGame.getInstance().getSprites().renderEnemies(g);
			MainGame.getInstance().getScreenItems().createWeather(g);
			MainGame.getInstance().getSprites().renderHealthItemsAndGoal(g);
			MainGame.getInstance().getSprites().renderPowerups(g);
			MainGame.getInstance().getScreenItems().healthbar(g);
			MainGame.getInstance().getScreenItems().itembar(g);
			break;
		}
	}

}
