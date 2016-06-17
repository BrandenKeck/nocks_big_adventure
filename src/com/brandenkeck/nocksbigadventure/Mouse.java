package com.brandenkeck.nocksbigadventure;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Mouse extends MouseAdapter{
	public static boolean pressed=false;
	public static int MOUSE_X, MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle(1,1,1,1);
	
	@Override
	public void mouseClicked(MouseEvent e){
		int mouse=e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(),1,1);
		
		if(mouse == MouseEvent.BUTTON1){
			
			switch(MainGame.state){
			case MENU:
				if(rect.intersects(MainGame.getInstance().getMenu().p)){
					MainGame.prevState=StateClass.BOSS3;
					MainGame.state = StateClass.BOSS3;
					MainGame.nextState=StateClass.BOSS3;
					MainGame.add = new Adder();
				}
				/*else if(rect.intersects(MainGame.getInstance().getMenu().o);
					MainGame.state = StateClass.OPTIONS;
				break;
				}*/
				else if(rect.intersects(MainGame.getInstance().getMenu().q)){
					System.exit(1);
				}
				break;
			case GAME_OVER:
				if(rect.intersects(MainGame.getInstance().getScreenItems().ta)){
					Player.health = 50;
					ScreenItems.faded = 1;
					MainGame.state=MainGame.prevState;
					for(int i = 0; i<4; i++){
						Keys.keyDown[i]=false;
					}
					Player.velx=0;
					Player.vely=0;
					try {
				        Robot robot = new Robot();
				        robot.keyRelease(KeyEvent.VK_W);
				        robot.keyRelease(KeyEvent.VK_A);
				        robot.keyRelease(KeyEvent.VK_S);
				        robot.keyRelease(KeyEvent.VK_D);
				        robot.keyRelease(KeyEvent.VK_F);
				        robot.keyRelease(KeyEvent.VK_E);
				        robot.keyRelease(KeyEvent.VK_Q);
					} catch (AWTException err) {
					        err.printStackTrace();
					}
					Environment.removeAll();
					MainGame.add = new Adder();
				}
				break;
			default:
				break;
			}
		}
	}
	
	public void mousePressed(MouseEvent e){
		pressed=true;
	}
	
	public void mouseReleased(MouseEvent e){
		pressed = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e){
		MOUSE_X=e.getX();
		MOUSE_Y=e.getY();
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y,1,1);
	}
}
