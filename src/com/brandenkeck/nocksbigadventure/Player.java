package com.brandenkeck.nocksbigadventure;
import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Player {
	public static StatePlayer state = StatePlayer.FLAME;
	public static int x;
	public static int y;
	public static int health = 50;
	//public static int defense, xTension;
	public static int velx, vely, kick, damage, w, xOffset, gravity;
	public static BufferedImage ss, returnimg;
	public static boolean falling = true;
	public static boolean intstruct = true;
	public static Rectangle[] hit = new Rectangle[100];
	public static boolean[] Hr = new boolean[100];
	
	public static int warpedTimer = 1;
	public static int warpedRandom = 1;
	public static int wrathRandom = 1;
	public static boolean starred = false;
	public static boolean souleater = false;
	public static boolean warped = false;
	public static boolean wrath = false;
	public static int[][] Wx = new int[100][5];
	public static int[][] Wy = new int[100][5];
	
	public static BufferedImage[] imgProg = new BufferedImage[100];
	public static int[] Px = new int[100];
	public static int[] Py = new int[100];
	public static int[] Pvelx = new int[100];
	public static int[] Pvely = new int[100];
	public static boolean[] Pr = new boolean[100];
	public static int[] Pt = new int[100];
	public static boolean reset = true;
	
	private static int platformTicker = 1;
	private static int progTicker=1;
	private static boolean switchMe;
	private static Environment environment = new Environment();
	private static Enemies enemies = new Enemies();
	private static Bosses bosses = new Bosses();
	private Random randNum = new Random();

	public void tick(){
		x += velx;
		y += vely;
		fall();
		ScreenMovement sm = new ScreenMovement();
		hitBox();
		tickProjectile();
		movePlatforms();
		stateSwitch();
		enemies.spawn();
		if(health==0){
			MainGame.prevState = MainGame.state;
			MainGame.nextState = MainGame.state;
			MainGame.state = StateClass.GAME_OVER;
		}
		if(warped){
			createProjectile();
		}
		if(wrath){
			createProjectile();
		}
		
	}
	
	
	public void stateSwitch(){
		switch(MainGame.state){
		case DIALOG:
			for(int i = 0; i<4; i++){
				Keys.keyDown[i]=false;
			}
			velx=0;
			vely=0;
			try {
		        Robot robot = new Robot();
		        robot.keyRelease(KeyEvent.VK_W);
		        robot.keyRelease(KeyEvent.VK_A);
		        robot.keyRelease(KeyEvent.VK_S);
		        robot.keyRelease(KeyEvent.VK_D);
		        robot.keyRelease(KeyEvent.VK_F);
		        robot.keyRelease(KeyEvent.VK_E);
		        robot.keyRelease(KeyEvent.VK_Q);
			} catch (AWTException e) {
			        e.printStackTrace();
			}
			break;
		case LEVEL1:
			if(intstruct){
				MainGame.prevState=StateClass.LEVEL1;
				ScreenItems.currentD = ResourceManager.Controls;
				MainGame.state=StateClass.DIALOG;
			}
			
			if(Environment.BGx>0){
			environment.goal();
				if(getBounds().intersects(Environment.goalItem)){
					MainGame.prevState=StateClass.LEVEL1;
					MainGame.nextState=StateClass.BOSS1;
					MainGame.state = StateClass.CUTSCENE;
				}
			}
			break;
		case BOSS1:
			if(Bosses.gctc>1){
				environment.addGoal(1200, 200);
				if(getBounds().intersects(environment.goalItem)){
					environment.goal();
					MainGame.prevState=StateClass.BOSS1;
					MainGame.nextState=StateClass.LEVEL2;
					MainGame.state = StateClass.CUTSCENE;
					environment.removeAll();
				}
			}
			break;
		case LEVEL2:
			if(Environment.BGx>0){
				if(getBounds().intersects(Environment.goalItem)){
					environment.goal();
					MainGame.prevState=StateClass.LEVEL2;
					MainGame.nextState=StateClass.BOSS2;
					MainGame.state = StateClass.CUTSCENE;
				}
			}
			break;
		case BOSS2:
			if(bosses.smctc>1){
				environment.addGoal(1400, 100);
				if(getBounds().intersects(environment.goalItem)){
					environment.goal();
					MainGame.prevState=StateClass.BOSS2;
					MainGame.nextState=StateClass.LEVEL3;
					MainGame.state = StateClass.CUTSCENE;
					environment.removeAll();
				}
			}
			break;	
		case LEVEL3:
			if(Environment.BGx>0){
				if(getBounds().intersects(Environment.goalItem)){
					environment.goal();
					MainGame.prevState=StateClass.LEVEL3;
					MainGame.nextState=StateClass.BOSS3;
					MainGame.state = StateClass.CUTSCENE;
				}
			}
			break;
		case BOSS3:
			if(bosses.moctc>1 && bosses.MOhealth==0){
					environment.goal();
				if(environment.goalItem != null){
				if(getBounds().intersects(environment.goalItem)){
					MainGame.prevState=StateClass.BOSS3;
					MainGame.nextState=StateClass.LEVEL4;
					MainGame.state = StateClass.CUTSCENE;
					environment.removeAll();
				}
				}
			}
			break;
		case LEVEL4:
			if(Environment.BGx>0){
				if(getBounds().intersects(Environment.goalItem)){
					environment.goal();
					MainGame.prevState=StateClass.LEVEL4;
					MainGame.nextState=StateClass.BOSS4;
					MainGame.state = StateClass.CUTSCENE;
				}
			}
			break;
		case BOSS4:
			switchMe = false;
			for(int check = 0; check<100; check++){
				if(Bosses.SJr[check]){
					switchMe = false;
					break;
				}
				else{switchMe = true;}
			}
			
			if(switchMe){
				environment.addGoal(1400, 100);
				if(getBounds().intersects(environment.goalItem)){
					environment.goal();
					MainGame.prevState=StateClass.BOSS4;
					MainGame.nextState=StateClass.LEVEL5;
					MainGame.state = StateClass.CUTSCENE;
					environment.removeAll();
				}
			}
			break;
		case LEVEL5:
			if(Environment.BGx>0){
				if(getBounds().intersects(Environment.goalItem)){
					environment.goal();
					MainGame.prevState=StateClass.LEVEL5;
					MainGame.nextState=StateClass.BOSS5;
					MainGame.state = StateClass.CUTSCENE;
					environment.removeAll();
				}
			}
			break;
		case BOSS5:
			if(bosses.smctc>1){
				environment.addGoal(1400, 100);
				if(getBounds().intersects(environment.goalItem)){
					environment.goal();
					MainGame.prevState=StateClass.LEVEL5;
					MainGame.nextState=StateClass.MENU;
					MainGame.state = StateClass.CUTSCENE;
					environment.removeAll();
				}
			}
			break;
		}
	}
	
	public void movePlatforms(){
		platformTicker+=MainGame.currentTickCount%2;
		if(platformTicker>100){platformTicker = 1;}
		
		switch(MainGame.state){
		case LEVEL1:

		break;
		case LEVEL2:
			for(int i=0; i<50; i++){
				for(int j=0; j<4; j++){
				environment.movePlatforms((int) (5*Math.cos(Math.PI*2*platformTicker/100)), (int) (2*Math.sin(Math.PI*2*platformTicker/100)), 7+4*i+j);
				}
			}
			
			for(int i=50; i<100; i++){
				for(int j=0; j<4; j++){
					environment.movePlatforms((int) (5*Math.sin(Math.PI*2*platformTicker/100)), (int) (2*Math.sin(Math.PI*2*platformTicker/100)), 7+4*i+j);
				}
			}
		break;
		case BOSS2:
			for(int i=1; i<50; i++){
				environment.movePlatforms((int) (5*Math.sin(Math.PI*2*platformTicker/100)), 0, i);
			}
			for(int i=50; i<100; i++){
				environment.movePlatforms((int) (5*Math.cos(Math.PI*2*platformTicker/100)), 0, i);
			}
			break;
		case LEVEL3:
			environment.moveDamage(0, (int) (MainGame.yScalingFactor*3*Math.PI*Math.cos(Math.PI*2*platformTicker/100)), 0);
			break;
		case BOSS3:
			for(int i=1; i<=4; i++){
				environment.movePlatforms(0, -5, i);
				if(environment.yPlatformPosition[i]<-32){environment.yPlatformPosition[i]=4032;}
			}
			for(int i=5; i<=8; i++){
				environment.movePlatforms(0, -3, i);
				if(environment.yPlatformPosition[i]<-32){environment.yPlatformPosition[i]=4032;}
			}
			for(int i=9; i<=12; i++){
				environment.movePlatforms(0, -2, i);
				if(environment.yPlatformPosition[i]<-32){environment.yPlatformPosition[i]=4032;}
			}
			for(int i=13; i<=16; i++){
				environment.movePlatforms(0, -7, i);
				if(environment.yPlatformPosition[i]<-32){environment.yPlatformPosition[i]=4032;}
			}
			for(int i=17; i<=20; i++){
				environment.movePlatforms(0, -4, i);
				if(environment.yPlatformPosition[i]<-32){environment.yPlatformPosition[i]=4032;}
			}
			for(int i=21; i<=24; i++){
				environment.movePlatforms(0, -5, i);
				if(environment.yPlatformPosition[i]<-32){environment.yPlatformPosition[i]=4032;}
			}
			for(int i=25; i<=28; i++){
				environment.movePlatforms(0, -3, i);
				if(environment.yPlatformPosition[i]<-32){environment.yPlatformPosition[i]=4032;}
			}
			for(int i=29; i<=32; i++){
				environment.movePlatforms(0, -6, i);
				if(environment.yPlatformPosition[i]<-32){environment.yPlatformPosition[i]=4032;}
			}
			break;
		case LEVEL5:
				environment.movePlatforms((int) (500-100*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[1]), (int) (49940+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[1]), 1);
				environment.movePlatforms((int) (500-200*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[2]), (int) (49940+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[2]), 2);
				environment.movePlatforms((int) (1000-100*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[3]), (int) (49440+200*Math.cos(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[3]), 3);
				environment.movePlatforms((int) (1000-200*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[4]), (int) (49440+200*Math.cos(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[4]), 4);
				environment.movePlatforms((int) (700-100*Math.cos(Math.PI*2*platformTicker/100+Math.PI) - environment.xPlatformPosition[5]), (int) (48940+200*Math.sin(Math.PI*2*platformTicker/100+Math.PI) - environment.yPlatformPosition[5]), 5);
				environment.movePlatforms((int) (700-200*Math.cos(Math.PI*2*platformTicker/100+Math.PI) - environment.xPlatformPosition[6]), (int) (48940+200*Math.sin(Math.PI*2*platformTicker/100+Math.PI) - environment.yPlatformPosition[6]), 6);
				environment.movePlatforms((int) (400-100*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[7]), (int) (48440+200*Math.cos(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[7]), 7);
				environment.movePlatforms((int) (400-200*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[8]), (int) (48440+200*Math.cos(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[8]), 8);
				environment.movePlatforms((int) (800-100*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[9]), (int) (47940+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[9]), 9);
				environment.movePlatforms((int) (800-200*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[10]), (int) (47940+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[10]), 10);
				environment.movePlatforms((int) (600-100*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[11]), (int) (47440+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[11]), 11);
				environment.movePlatforms((int) (600-200*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[12]), (int) (47440+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[12]), 12);
				environment.movePlatforms((int) (1000-100*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[13]), (int) (46840+200*Math.cos(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[13]), 13);
				environment.movePlatforms((int) (1000-200*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[14]), (int) (46840+200*Math.cos(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[14]), 14);
				environment.movePlatforms((int) (700-100*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[15]), (int) (46240+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[15]), 15);
				environment.movePlatforms((int) (700-200*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[16]), (int) (46240+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[16]), 16);
				environment.movePlatforms((int) (1100-100*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[17]), (int) (45640+200*Math.cos(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[17]), 17);
				environment.movePlatforms((int) (1100-200*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[18]), (int) (45640+200*Math.cos(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[18]), 18);
				environment.movePlatforms((int) (600-100*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[19]), (int) (45040+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[19]), 19);
				environment.movePlatforms((int) (600-200*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[20]), (int) (45040+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[20]), 20);
				environment.movePlatforms((int) (600-100*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[23]), (int) (43640+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[23]), 23);
				environment.movePlatforms((int) (600-200*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[24]), (int) (43640+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[24]), 24);
				environment.movePlatforms((int) (1000-100*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[25]), (int) (43040+200*Math.cos(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[25]), 25);
				environment.movePlatforms((int) (1000-200*Math.sin(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[26]), (int) (43040+200*Math.cos(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[26]), 26);
				environment.movePlatforms((int) (400-100*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[27]), (int) (42440+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[27]), 27);
				environment.movePlatforms((int) (400-200*Math.cos(Math.PI*2*platformTicker/100) - environment.xPlatformPosition[28]), (int) (42440+200*Math.sin(Math.PI*2*platformTicker/100) - environment.yPlatformPosition[28]), 28);
				break;
		default:
			break;
		}
	}
	
	
	public void fall(){
		if(falling){
			if(MainGame.state==StateClass.LEVEL4){gravity=MainGame.currentTickCount%2;}
			else{gravity = 1;}
			vely+=gravity;
		}
	}
	
	
	public Rectangle getBounds(){
		return new Rectangle((int)(x+28*MainGame.xScalingFactor), y, (int)(72*MainGame.xScalingFactor), (int)(200*MainGame.yScalingFactor));
	}
	
	public Rectangle getFeetBounds(){
		return new Rectangle((int)(x+28*MainGame.xScalingFactor), y, (int)(72*MainGame.xScalingFactor), (int)(200*MainGame.yScalingFactor));
	}
	
	public Rectangle getHeadBounds(){
		return new Rectangle((int)(x+28*MainGame.xScalingFactor), y, (int)(72*MainGame.xScalingFactor), (int)(200*MainGame.yScalingFactor));
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle((int)(x+28*MainGame.xScalingFactor), y, (int)(72*MainGame.xScalingFactor), (int)(200*MainGame.yScalingFactor));
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle((int)(x+28*MainGame.xScalingFactor), y, (int)(72*MainGame.xScalingFactor), (int)(200*MainGame.yScalingFactor));
	}
	
	
	public BufferedImage walking(){
		int imp = 128;
		switch(Keys.lastKey){
		case 2:
				switch(state){
				case SWORD:
				xOffset=22;
				ss=ResourceManager.WalkLeftSword;
				imp = 150;
				break;
				case AXE:
				xOffset=22;
				ss=ResourceManager.WalkLeftAxe;
				imp = 150;
				break;
				case MACE:
				xOffset=22;
				ss=ResourceManager.WalkLeftMace;
				imp = 128;
				break;
				case SICKLE:
				xOffset=22;
				ss=ResourceManager.WalkLeftSickle;
				imp = 128;
				break;
				default:
				xOffset=0;
				ss=ResourceManager.WalkLeft;
				imp = 128;
				break;
				}
			break;
		case 3:
			switch(state){
				case SWORD:
				xOffset=0;
				ss=ResourceManager.WalkRightSword;
				imp = 150;
				break;
				case AXE:
				xOffset=0;
				ss=ResourceManager.WalkRightAxe;
				imp = 150;
				break;
				case MACE:
				xOffset=0;
				ss=ResourceManager.WalkRightMace;
				imp = 128;
				break;
				case SICKLE:
				xOffset=0;
				ss=ResourceManager.WalkRightSickle;
				imp = 128;
				break;
				default:
				xOffset=0;
				ss=ResourceManager.WalkRight;
				imp = 128;
				break;
				}
			break;
		}
		
		int ctc = MainGame.currentTickCount%10;
		if(ctc == 0){
			ctc=10;
			//ResourceManager.soundMap.get("Step").play();
		}

		returnimg = SpriteObj(ss, imp, 200, ctc, 1);
		return returnimg;	
	}

	
	public BufferedImage still(){
		switch(Keys.lastKey){
		case 2:
			switch(state){
				case SWORD:
				ss=ResourceManager.StillLeftSword;
				break;
				case AXE:
				ss=ResourceManager.StillLeftAxe;
				break;
				case MACE:
				ss=ResourceManager.StillLeftMace;
				break;
				case SICKLE:
				ss=ResourceManager.StillLeftSickle;
				break;
				default:
				ss=ResourceManager.StillLeft;
				break;
			}
			break;
		case 3:
			switch(state){
				case SWORD:
				ss=ResourceManager.StillRightSword;
				break;
				case AXE:
				ss=ResourceManager.StillRightAxe;
				break;
				case MACE:
				ss=ResourceManager.StillRightMace;
				break;
				case SICKLE:
				ss=ResourceManager.StillRightSickle;
				break;
				default:
				ss=ResourceManager.StillRight;
				break;
			}
			break;
		}
		returnimg = SpriteObj(ss, ss.getWidth(), ss.getHeight(), 1, 1);
		return returnimg;
	}

	
	public BufferedImage duck(){
		switch(Keys.lastKey){
		case 2:
			switch(state){
				case SWORD:
				ss=ResourceManager.DuckLeftSword;
				break;
				case AXE:
				ss=ResourceManager.DuckLeftAxe;
				break;
				case MACE:
				ss=ResourceManager.DuckLeftMace;
				break;
				case SICKLE:
				ss=ResourceManager.DuckLeftSickle;
				break;
				default:
				ss=ResourceManager.DuckLeft;
				break;
			}
			break;
		case 3:
			switch(state){
				case SWORD:
				ss=ResourceManager.DuckRightSword;
				break;
				case AXE:
				ss=ResourceManager.DuckRightAxe;
				break;
				case MACE:
				ss=ResourceManager.DuckRightMace;
				break;
				case SICKLE:
				ss=ResourceManager.DuckRightSickle;
				break;
				default:
				ss=ResourceManager.DuckRight;
				break;
			}
			break;
		}
		returnimg = SpriteObj(ss, ss.getWidth(), ss.getHeight(), 1, 1);
		return returnimg;
	}

	
	public BufferedImage up(){
		switch(Keys.lastKey){
		case 2:
			switch(state){
				case SWORD:
				ss=ResourceManager.UpLeftSword;
				break;
				case AXE:
				ss=ResourceManager.UpLeftAxe;
				break;
				case MACE:
				ss=ResourceManager.UpLeftMace;
				break;
				case SICKLE:
				ss=ResourceManager.UpLeftSickle;
				break;
				default:
				ss=ResourceManager.UpLeft;
				break;
			}
			break;
		case 3:
			switch(state){
				case SWORD:
				ss=ResourceManager.UpRightSword;
				break;
				case AXE:
				ss=ResourceManager.UpRightAxe;
				break;
				case MACE:
				ss=ResourceManager.UpRightMace;
				break;
				case SICKLE:
				ss=ResourceManager.UpRightSickle;
				break;
				default:
				ss=ResourceManager.UpRight;
				break;
			}
			break;
		}
		returnimg = SpriteObj(ss, ss.getWidth(), ss.getHeight(), 1, 1);
		return returnimg;
	}
	
	
	public BufferedImage jumping(){
		switch(Keys.lastKey){
		case 2:
			switch(state){
				case SWORD:
				ss=ResourceManager.JumpLeftSword;
				break;
				case AXE:
				ss=ResourceManager.JumpLeftAxe;
				break;
				case MACE:
				ss=ResourceManager.JumpLeftMace;
				break;
				case SICKLE:
				ss=ResourceManager.JumpLeftSickle;
				break;
				default:
				ss=ResourceManager.JumpLeft;
				break;
			}
			break;
		case 3:
			switch(state){
				case SWORD:
				ss=ResourceManager.JumpRightSword;
				break;
				case AXE:
				ss=ResourceManager.JumpRightAxe;
				break;
				case MACE:
				ss=ResourceManager.JumpRightMace;
				break;
				case SICKLE:
				ss=ResourceManager.JumpRightSickle;
				break;
				default:
				ss=ResourceManager.JumpRight;
				break;
			}
			break;
		}

		returnimg = SpriteObj(ss, ss.getWidth(), ss.getHeight(), 1, 1);
		return returnimg;
	}
	
	
	public void fighting(Graphics g, int j){
		switch(Keys.lastKey){
		case 2:
			switch(state){
			case SWORD:
			xOffset=22;
			w = 150;
			ss=ResourceManager.SwipeLeft;
			j=12-j;
			break;
			case AXE:
			xOffset=111;
			w = 384;
			ss=ResourceManager.Swing;
			break;
			case MACE:
			xOffset=0;
			w = 128;
			ss=ResourceManager.Pound;
			break;
			case SICKLE:
			xOffset=40;
			w = 150;
			ss=ResourceManager.SwipeLeftSickle;
			break;
			case FLAME:
			if(Keys.keyDown[0]){ss=ResourceManager.ThrowUpLeft;}
			else{ss=ResourceManager.ThrowLeft;}
			xOffset=0;
			w = 128;
			createProjectile();
			break;
			case LIGHTNING:
			if(Keys.fireUp){ss=ResourceManager.ThrowUpLeft;}
			else{ss=ResourceManager.ThrowLeft;}
			xOffset=0;
			w = 128;
			createProjectile();
			break;
			case STAR:
			if(Keys.fireUp){ss=ResourceManager.ThrowUpLeft;}
			else{ss=ResourceManager.ThrowLeft;}
			xOffset=0;
			w = 128;
			createProjectile();
			break;
			case TIME_WARP:
			if(Keys.fireUp){ss=ResourceManager.ThrowUpLeft;}
			else{ss=ResourceManager.ThrowLeft;}
			xOffset=0;
			w = 128;
			createProjectile();
			break;
			case WRATH:
			if(Keys.fireUp){ss=ResourceManager.ThrowUpLeft;}
			else{ss=ResourceManager.ThrowLeft;}
			xOffset=0;
			w = 128;
			createProjectile();
			break;
			default:
			xOffset=0;
			w = 128;
			ss=ResourceManager.StillLeft;
			break;
		}
		break;
		case 3:
			switch(state){
			case SWORD:
			xOffset=0;
			w = 150;
			ss=ResourceManager.SwipeRight;
			break;
			case AXE:
			xOffset=111;
			w = 384;
			ss=ResourceManager.Swing;
			break;
			case MACE:
			xOffset=0;
			w = 128;
			ss=ResourceManager.Pound;
			break;
			case SICKLE:
			xOffset=-17;
			w = 150;
			ss=ResourceManager.SwipeRightSickle;
			break;
			case FLAME:
			if(Keys.fireUp){ss=ResourceManager.ThrowUpRight;}
			else{ss=ResourceManager.ThrowRight;}
			xOffset=0;
			w = 128;
			createProjectile();
			break;
			case LIGHTNING:
			if(Keys.keyDown[0]){ss=ResourceManager.ThrowUpRight;}
			else{ss=ResourceManager.ThrowRight;}
			xOffset=0;
			w = 128;
			createProjectile();
			break;
			case STAR:
			if(Keys.keyDown[0]){ss=ResourceManager.ThrowUpRight;}
			else{ss=ResourceManager.ThrowRight;}
			xOffset=0;
			w = 128;
			createProjectile();
			break;
			case TIME_WARP:
			if(Keys.keyDown[0]){ss=ResourceManager.ThrowUpRight;}
			else{ss=ResourceManager.ThrowRight;}
			xOffset=0;
			w = 128;
			createProjectile();
			break;
			case WRATH:
			if(Keys.keyDown[0]){ss=ResourceManager.ThrowUpRight;}
			else{ss=ResourceManager.ThrowRight;}
			xOffset=0;
			w = 128;
			createProjectile();
			break;
			default:
			xOffset=0;
			w = 128;
			ss=ResourceManager.StillRight;
			break;
		}
		break;
		}

			g.drawImage(SpriteObj(ss, w, ss.getHeight(), j, 1), x-xOffset, y, (int) (w*MainGame.xScalingFactor), (int) (ss.getHeight()*MainGame.yScalingFactor), null);
		
	}
	
	public void createProjectile(){
		switch(state){
		case FLAME:
			if(reset){
			int i = 0;
			for(int k = 1; k<50; k++){
				if(i==1){
					reset=false;
				}
				else if(!Pr[k]){
					Pr[k]=true;
					imgProg[k]=ResourceManager.SpriteObj(ResourceManager.Fireball, 30, 30, MainGame.currentTickCount%3+1, 1);
					if(Keys.keyDown[0]){
						Py[k] = y+20;
						Pvely[k]=-20;
						Pvelx[k]=0;
						switch(Keys.lastKey){
						case 2:
							Px[k] = x+40;
							break;
						case 3:
							Px[k] = x+80;
							break;
						}
					}
					else{
						Py[k] = y+95;
						Pvely[k]=0;
						switch(Keys.lastKey){
						case 2:
							Px[k] = x+10;
							Pvelx[k]=-20;
							break;
						case 3:
							Px[k] = x+110;
							Pvelx[k]=20;
							break;
						}
					}
					i++;
				}
			}
			}
		break;
		case LIGHTNING:
			if(reset){
			int i = 0;
			for(int k = 1; k<50; k++){
				if(i==3){
					reset=false;
				}
				else if(!Pr[k]){
					Pr[k]=true;
					imgProg[k]=ResourceManager.SpriteObj(ResourceManager.Bolt, 30, 30, MainGame.currentTickCount%3+1, 1);
					if(Keys.keyDown[0]){
						Py[k] = y+20;
						Pvely[k]=-20;
						Pvelx[k]=5-5*i;
						switch(Keys.lastKey){
						case 2:
							Px[k] = x+40;
							break;
						case 3:
							Px[k] = x+80;
							break;
						}
					}
					else{
						Py[k] = y+95;
						Pvely[k]=5-5*i;
						switch(Keys.lastKey){
						case 2:
							Px[k] = x+10;
							Pvelx[k]=-20;
							break;
						case 3:
							Px[k] = x+110;
							Pvelx[k]=20;
							break;
						}
					}
					i++;
				}
			}
			}
		break;
		}
		
		if(starred){
			if(reset){
			int i = 0;
			for(int k = 90; k<95; k++){
				if(i==5){
					reset=false;
				}
				else if(!Pr[k]){
					Pr[k]=true;
					imgProg[k]=ResourceManager.SpriteObj(ResourceManager.Starball, 30, 30, MainGame.currentTickCount%2+1, 1);
					if(Keys.keyDown[0]){
						Py[k] = y+20;
						switch(Keys.lastKey){
						case 2:
							Px[k] = x+40;
							break;
						case 3:
							Px[k] = x+80;
							break;
						}
					}
					else{
						Py[k] = y+95;
						switch(Keys.lastKey){
						case 2:
							Px[k] = x+10;
							break;
						case 3:
							Px[k] = x+110;
							break;
						}
					}
					i++;
				}
			}
			}
		}

		
		if(warped){
			for(int k=95; k<100; k++){
				if(!Pr[k]){
					Pr[k]=true;
					imgProg[k]=ResourceManager.SpriteObj(ResourceManager.Timebomb, 100, 100, warpedTimer, 1);
					warpedRandom = randNum.nextInt(MainGame.xSize);
					Px[k]=warpedRandom;
					warpedRandom = randNum.nextInt(MainGame.ySize);
					Py[k] = warpedRandom;
				}
			}
		}
		
		if(wrath){
			for(int k=51; k<55; k++){
				if(!Pr[k]){
					Pr[k]=true;
					imgProg[k]=ResourceManager.Meteor1;
					Px[k]=MainGame.xSize/(k%5+1);
					Py[k] = 1000-k*25;
					wrathRandom = randNum.nextInt(5);
					Pvelx[k] = wrathRandom-3;
					wrathRandom = randNum.nextInt(20);
					Pvely[k] = wrathRandom+20;
					for(int i=0; i<5; i++){
						Wx[k][i] = Px[k];
						Wy[k][i] = Py[k];
					}
				}
			}
			for(int k=55; k<60; k++){
				if(!Pr[k]){
					Pr[k]=true;
					imgProg[k]=ResourceManager.Meteor2;
					Px[k]=MainGame.xSize/(5-k%5);
					Py[k] = 880-k*25;
					wrathRandom = randNum.nextInt(5);
					Pvelx[k] = wrathRandom-3;
					wrathRandom = randNum.nextInt(20);
					Pvely[k] = wrathRandom+20;
					for(int i=0; i<5; i++){
						Wx[k][i] = Px[k];
						Wy[k][i] = Py[k];
					}
				}
			}
			for(int k=60; k<65; k++){
				if(!Pr[k]){
					Pr[k]=true;
					imgProg[k]=ResourceManager.Meteor3;
					Px[k]=MainGame.xSize/(k%5+1);
					Py[k] = 750-k*25;
					wrathRandom = randNum.nextInt(5);
					Pvelx[k] = wrathRandom-3;
					wrathRandom = randNum.nextInt(20);
					Pvely[k] = wrathRandom+20;
					for(int i=0; i<5; i++){
						Wx[k][i] = Px[k];
						Wy[k][i] = Py[k];
					}
				}
			}
			for(int k=65; k<70; k++){
				if(!Pr[k]){
					Pr[k]=true;
					imgProg[k]=ResourceManager.Meteor4;
					Px[k]=MainGame.xSize/(5-k%5);
					Py[k] = 630-k*25;
					wrathRandom = randNum.nextInt(5);
					Pvelx[k] = wrathRandom-3;
					wrathRandom = randNum.nextInt(20);
					Pvely[k] = wrathRandom+20;
					for(int i=0; i<5; i++){
						Wx[k][i] = Px[k];
						Wy[k][i] = Py[k];
					}
				}
			}
			for(int k=70; k<75; k++){
				if(!Pr[k]){
					Pr[k]=true;
					imgProg[k]=ResourceManager.Meteor5;
					Px[k]=MainGame.xSize/(k%5+1);
					Py[k] = 500-k*25;
					wrathRandom = randNum.nextInt(5);
					Pvelx[k] = wrathRandom-3;
					wrathRandom = randNum.nextInt(20);
					Pvely[k] = wrathRandom+20;
					for(int i=0; i<5; i++){
						Wx[k][i] = Px[k];
						Wy[k][i] = Py[k];
					}
				}
			}
		}



	}
	
	public void tickProjectile(){
		for(int k=1; k<100; k++){
		if(Pr[k]){
			changeVelocity(k);
			Px[k]+=Pvelx[k];
			Py[k]+=Pvely[k];
			Hr[k]=true;
			hit[k] = new Rectangle(Px[k], Py[k], (int) (imgProg[k].getWidth()*MainGame.xScalingFactor), (int) (imgProg[k].getHeight()*MainGame.yScalingFactor));
			if(Px[k]>MainGame.xSize || Px[k]<-30){
				Pr[k]=false;
			}
		}else{hit[k] = new Rectangle(0,0,0,0);}
		}
	}
	
	public void changeVelocity(int k){
		progTicker += MainGame.currentTickCount%2;
		if(progTicker>1000){progTicker=0;}
		if(state==StatePlayer.FLAME){
			imgProg[k]=ResourceManager.SpriteObj(ResourceManager.Fireball, 30, 30, MainGame.currentTickCount%3+1, 1);
			Pvely[k] += (int) (150*Math.sin(MainGame.currentTickCount%60/60));
		}
		if(state==StatePlayer.LIGHTNING){
			imgProg[k]=ResourceManager.SpriteObj(ResourceManager.Bolt, 30, 30, MainGame.currentTickCount%3+1, 1);
		}
		if(starred){
			imgProg[k]=ResourceManager.SpriteObj(ResourceManager.Starball, 30, 30, MainGame.currentTickCount%2+1, 1);
			Pvely[k]=(int) (int) ((y+100)+150*Math.sin(2*Math.PI*(progTicker+200*k)/1000))-Py[k];
			Pvelx[k]=(int) ((x+64)+150*Math.cos(2*Math.PI*(progTicker+200*k)/1000))-Px[k];
		}
		if(warped){
			if(MainGame.currentTickCount%5==0){warpedTimer++;}
			if(warpedTimer>4){
				warpedTimer=1;
				Pr[k]=false;
			}
			else{imgProg[k]=ResourceManager.SpriteObj(ResourceManager.Timebomb, 100, 100, warpedTimer, 1);}
		}
		if(wrath){
			Wx[k][0] = Px[k];
			Wy[k][0] = Py[k];
			for(int i=1; i<5; i++){
				if(MainGame.currentTickCount%i==0){
					Wx[k][i] = Wx[k][i-1];
					Wy[k][i] = Wy[k][i-1];
				}
			}
			if(Py[k]>MainGame.xSize+250){
				Pr[k]=false;
			}
		}
	}
	
	public void hitBox(){
		
		if(Keys.keyDown[5]){
			Hr[0]=true;
			switch(Keys.lastKey){
			case 2:
				switch(state){
				case SWORD:
					damage=25;
					kick=50;
					hit[0] = new Rectangle(x-(int) (MainGame.xScalingFactor*20),y+(int) (MainGame.yScalingFactor*40),(int) (MainGame.xScalingFactor*10), (int) (MainGame.yScalingFactor*120));
				break;
				case FLAME:
					damage=10;
					kick=25;
				break;
				case AXE:
					damage=40;
					kick=60;
					hit[0] = new Rectangle(x-(int) (MainGame.xScalingFactor*40),y+(int) (MainGame.yScalingFactor*95), (int) (MainGame.xScalingFactor*240), (int) (MainGame.yScalingFactor*20));
				break;
				case LIGHTNING:
					damage=30;
					kick=25;
				break;
				case STAR:
					damage=80;
					kick=81;
				break;
				case MACE:
					damage=80;
					kick=200;
					if(RenderingClass.j==9){
						hit[0] = new Rectangle(x-(int) (MainGame.xScalingFactor*100),y,(int) (MainGame.xScalingFactor*328),(int) (MainGame.yScalingFactor*200));
							for(int shookMe=1; shookMe<50000; shookMe++){
								ScreenMovement.shake(shookMe);
							}
						}
				break;
				case SICKLE:
					damage=125;
					kick=280;
					hit[0] = new Rectangle(x-(int) (MainGame.xScalingFactor*40),y+(int) (MainGame.yScalingFactor*50),(int) (MainGame.xScalingFactor*30),(int) (MainGame.yScalingFactor*100));
				break;
				case TIME_WARP:
					damage=150;
					kick=0;
				break;
				case WRATH:
					damage=2000;
					kick=0;
				break;
				default:
					hit[0] = new Rectangle(0,0,0,0);
				break;
				}
			break;
			case 3:
				switch(state){
				case SWORD:
					damage=25;
					kick=50;
					hit[0] = new Rectangle(x+(int) (MainGame.xScalingFactor*140),y+(int) (MainGame.yScalingFactor*40),(int) (MainGame.xScalingFactor*10),(int) (MainGame.yScalingFactor*120));
				break;
				case FLAME:
					damage=10;
					kick=25;
				break;
				case LIGHTNING:
					damage=30;
					kick=25;
				break;
				case STAR:
					damage=80;
					kick=81;
				break;
				case AXE:
					damage=40;
					kick=60;
					hit[0] = new Rectangle(x-(int) (MainGame.xScalingFactor*40),y+(int) (MainGame.yScalingFactor*95),(int) (MainGame.xScalingFactor*240),(int) (MainGame.yScalingFactor*20));
				break;
				case MACE:
					damage=80;
					kick=200;
					if(RenderingClass.j==10){hit[0] = new Rectangle(x-(int) (MainGame.xScalingFactor*100),y,(int) (MainGame.xScalingFactor*328),(int) (MainGame.yScalingFactor*200));}
				break;
				case SICKLE:
					damage=125;
					kick=280;
					hit[0] = new Rectangle(x+(int) (MainGame.xScalingFactor*140),y+(int) (MainGame.xScalingFactor*50),(int) (MainGame.xScalingFactor*30),(int) (MainGame.xScalingFactor*100));
				break;
				case TIME_WARP:
					damage=150;
					kick=0;
				break;
				case WRATH:
					damage=2000;
					kick=0;
				break;
				default:
					hit[0] = new Rectangle(0,0,0,0);
				break;
				}
			break;
			}
		}
		else{
			Hr[0]=false;
			hit[0] = new Rectangle(0,0,0,0);
		}
	}
	
	
	public static BufferedImage SpriteObj(BufferedImage image, int width, int height, int col, int row){
		return image.getSubimage((col*width) - width, (row*height)-height, width, height);
	}

}
