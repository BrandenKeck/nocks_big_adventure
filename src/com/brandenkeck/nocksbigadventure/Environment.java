package com.brandenkeck.nocksbigadventure;
import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.*;


public class Environment {
	
	public static int check, prevCheck, newWeapon;
	public static int BGx = 0;
	public static int BGy = 0;
	public static int currentWeapon = 0;
	public static int itemCount = 9;
	public static boolean itemCollected[] = new boolean[10];
	public static BufferedImage level = ResourceManager.Level1;
	private BufferedImage paralax = ResourceManager.L1Para;
	private Player player = new Player();
	private Random randNum = new Random();
	
	public static BufferedImage[] floorImg = new BufferedImage[10];
	public static boolean[] rfloor = new boolean[10];
	public static int[] xFloorPosition = new int[10];
	public static Rectangle[] floorBounds = new Rectangle[10];
	public static int[] floorCount = new int[10];
	
	public static BufferedImage[] damageImg = new BufferedImage[500];
	public static boolean[] rdamage = new boolean[500];
	public static int[] xDamagePosition = new int[500];
	public static int[] yDamagePosition = new int[500];
	public static int[] xDamageCount = new int[500];
	public static int[] yDamageCount = new int[500];
	public static Rectangle[] leftDamageBound = new Rectangle[500];
	public static Rectangle[] rightDamageBound = new Rectangle[500];
	public static Rectangle[] topDamageBound = new Rectangle[500];
	public static Rectangle[] bottomDamageBound = new Rectangle[500];
	private int damageTicker = 0;
	
	public static BufferedImage[] platformImg = new BufferedImage[500];
	public static boolean[] rplatform = new boolean[500];
	public static int[] xPlatformPosition = new int[500];
	public static int[] yPlatformPosition = new int[500];
	public static int[] velxPlatform = new int[500];
	public static int[] velyPlatform = new int[500];
	public static int[] xPlatformCount = new int[500];
	public static int[] yPlatformCount = new int[500];
	public static Rectangle[] leftPlatformBound = new Rectangle[500];
	public static Rectangle[] rightPlatformBound = new Rectangle[500];
	public static Rectangle[] topPlatformBound = new Rectangle[500];
	public static Rectangle[] bottomPlatformBound = new Rectangle[500];
	
	public static BufferedImage healthImg;
	public static boolean[] rhealth = new boolean[500];
	public static int[] xhealth = new int[500];
	public static int[] yhealth = new int[500];
	public static Rectangle[] healthItem = new Rectangle[500];

	public static BufferedImage goalImg;
	public static boolean rgoal;
	public static int xgoal;
	public static int ygoal;
	public static Rectangle goalItem;
	
	public static BufferedImage swordImg;
	public static boolean rsword;
	public static int xsword;
	public static int ysword;
	public static Rectangle swordItem;
	
	public static BufferedImage axeImg;
	public static boolean raxe;
	public static int xaxe;
	public static int yaxe;
	public static Rectangle axeItem;
	
	public static BufferedImage maceImg;
	public static boolean rmace;
	public static int xmace;
	public static int ymace;
	public static Rectangle maceItem;
	
	public static BufferedImage sickleImg;
	public static boolean rsickle;
	public static int xsickle;
	public static int ysickle;
	public static Rectangle sickleItem;
	
	public static BufferedImage flameImg;
	public static boolean rflame;
	public static int xflame;
	public static int yflame;
	public static Rectangle flameItem;
	
	public static BufferedImage lightningImg;
	public static boolean rlightning;
	public static int xlightning;
	public static int ylightning;
	public static Rectangle lightningItem;
	
	public static BufferedImage starImg;
	public static boolean rstar;
	public static int xstar;
	public static int ystar;
	public static Rectangle starItem;
	
	public static BufferedImage timeImg;
	public static boolean rtime;
	public static int xtime;
	public static int ytime;
	public static Rectangle timeItem;
	
	public static BufferedImage wrathImg;
	public static boolean rwrath;
	public static int xwrath;
	public static int ywrath;
	public static Rectangle wrathItem;
	
	public void background(Graphics g){
		switch(MainGame.state){
		case LEVEL1:
				level = ResourceManager.Level1;
				paralax = ResourceManager.L1Para;
		break;
		case BOSS1:
				level = ResourceManager.BossBG1;
				paralax = ResourceManager.BossBG1;
		break;
		case LEVEL2:
			level = ResourceManager.Level3;
			paralax = ResourceManager.L3Para;
		break;
		case BOSS2:
			level = ResourceManager.BossFG3;
			paralax = ResourceManager.BossBG3;
		break;
		case LEVEL3:
			level = ResourceManager.Level4;
			paralax = ResourceManager.L4Para;
		break;
		case BOSS3:
			level = ResourceManager.BossFG4;
			paralax = ResourceManager.BossFG4;
		break;
		case LEVEL4:
			level = ResourceManager.Level6;
			paralax = ResourceManager.Level6;
		break;
		case BOSS4:
			level = ResourceManager.BossBG6;
			paralax = ResourceManager.BossBG6;
		break;
		case LEVEL5:
			level = ResourceManager.Level7;
			paralax = ResourceManager.L7Para;
		break;
		case BOSS5:
			level = ResourceManager.BossBG7;
			paralax = ResourceManager.BossBG7;
		break;
		default:
			switch(MainGame.prevState){
			case LEVEL1:
				level = ResourceManager.Level1;
				paralax = ResourceManager.L1Para;
			break;
			case BOSS1:
					level = ResourceManager.BossBG1;
					paralax = ResourceManager.BossBG1;
				break;
			case LEVEL2:
				level = ResourceManager.Level3;
				paralax = ResourceManager.L3Para;
			break;
			case BOSS2:
				level = ResourceManager.BossFG3;
				paralax = ResourceManager.BossBG3;
			break;
			case LEVEL3:
				level = ResourceManager.Level4;
				paralax = ResourceManager.L4Para;
			break;
			case BOSS3:
				level = ResourceManager.BossFG4;
				paralax = ResourceManager.BossFG4;
			break;
			case LEVEL4:
				level = ResourceManager.Level6;
				paralax = ResourceManager.Level6;
			break;
			case BOSS4:
				level = ResourceManager.BossBG6;
				paralax = ResourceManager.BossBG6;
			break;
			case LEVEL5:
				level = ResourceManager.Level7;
				paralax = ResourceManager.L7Para;
			break;
			case BOSS5:
				level = ResourceManager.BossBG7;
				paralax = ResourceManager.BossBG7;
			break;
			default:
				level = ResourceManager.Level1;
				paralax = ResourceManager.L1Para;
			break;
			}
			break;
		}
		System.out.println(paralax);
		if(BGx/10<(paralax.getWidth()-MainGame.xSize) && BGy/10<(paralax.getHeight()-MainGame.ySize)){
			g.drawImage(paralax.getSubimage((int)(BGx/10), (int)(BGy/10), 1920, 1080), 0, 0, (int) (MainGame.xSize*MainGame.xScalingFactor), (int) (MainGame.ySize*MainGame.yScalingFactor), null);
		}
		else if(BGx/10<(paralax.getWidth()-MainGame.xSize) && !(BGy/10<(paralax.getHeight()-MainGame.ySize))){
			g.drawImage(paralax.getSubimage((int)(BGx/10), paralax.getHeight()-MainGame.ySize, 1920, 1080), 0, 0, (int) (MainGame.xSize*MainGame.xScalingFactor), (int) (MainGame.ySize*MainGame.yScalingFactor), null);
		}
		else if(!(BGx/10<(paralax.getWidth()-MainGame.xSize)) && BGy/10<(paralax.getHeight()-MainGame.ySize)){
			g.drawImage(paralax.getSubimage(paralax.getWidth()-MainGame.xSize, (int)(BGy/10), 1920, 1080), 0, 0, (int) (MainGame.xSize*MainGame.xScalingFactor), (int) (MainGame.ySize*MainGame.yScalingFactor),null);
		}
		else{g.drawImage(paralax.getSubimage(paralax.getWidth()-MainGame.xSize, paralax.getHeight()-MainGame.ySize, 1920, 1080), 0, 0, (int) (MainGame.xSize*MainGame.xScalingFactor), (int) (MainGame.ySize*MainGame.yScalingFactor), null);}
		
		MainGame.getInstance().getScreenItems().BackgroundNoise(g);
		
		if(BGx<(level.getWidth()-MainGame.xSize) && BGy<(level.getHeight()-MainGame.ySize)){
			g.drawImage(level.getSubimage(BGx, BGy, 1920, 1080), 0, 0, (int) (MainGame.xSize*MainGame.xScalingFactor), (int) (MainGame.ySize*MainGame.yScalingFactor), null);
		}
		else if(BGx<(level.getWidth()-MainGame.xSize) && !(BGy<(level.getHeight()-MainGame.ySize))){
			g.drawImage(level.getSubimage(BGx, level.getHeight()-MainGame.ySize, 1920, 1080), 0, 0, (int) (MainGame.xSize*MainGame.xScalingFactor), (int) (MainGame.ySize*MainGame.yScalingFactor), null);
		}
		else if(!(BGx<(level.getWidth()-MainGame.xSize)) && BGy<(level.getHeight()-MainGame.ySize)){
			g.drawImage(level.getSubimage(level.getWidth()-MainGame.xSize, BGy, 1920, 1080), 0, 0, (int) (MainGame.xSize*MainGame.xScalingFactor), (int) (MainGame.ySize*MainGame.yScalingFactor), null);
		}
		else{g.drawImage(level.getSubimage(level.getWidth()-MainGame.xSize, level.getHeight()-MainGame.ySize, 1920, 1080), 0, 0, (int) (MainGame.xSize*MainGame.xScalingFactor), (int) (MainGame.ySize*MainGame.yScalingFactor), null);}
		
	}
	
	public void addFloor(BufferedImage floor, int position, int length, int type, int num){
		rfloor[num]=true;
		floorImg[num] = SpriteObj(floor, 32, 32, type, 1);
		xFloorPosition[num]=position;
		floorCount[num] = length;
	}
	
	public void floor(int k){
		floorBounds[k] = new Rectangle((int) (MainGame.xScalingFactor*(xFloorPosition[k]-BGx)), (int) (MainGame.yScalingFactor*(MainGame.ySize-55-BGy)), (int) (MainGame.xScalingFactor*(32*floorCount[k]-32)), (int) (MainGame.yScalingFactor*(32)));
		if(player.getBounds().intersects(floorBounds[k])){
			if(!Keys.jumping){player.vely=-1;}
			Keys.jumping=false;
			player.y=(int) (MainGame.ySize-255*MainGame.yScalingFactor-BGy);
		}
		
		if(Bosses.GGr && Bosses.GG.intersects(floorBounds[k])){
			Bosses.GGvely=0;
			Bosses.GGy=(int) (MainGame.ySize-295*MainGame.yScalingFactor);
		}
		
		
		for(int j=0; j<100; j++){
			if(Bosses.SJr[j] && Bosses.SJ[j].intersects(floorBounds[k])){
				Bosses.SJvely[j]=0;
				Bosses.SJy[j]=(int) (MainGame.ySize-135*MainGame.yScalingFactor);
			}
		}
		
		for(int j=0; j<55; j++){
			if(Enemies.Billr[j] && Enemies.Bill[j].intersects(floorBounds[k])){
				Enemies.Billvely[j]=0;
				Enemies.Billy[j]=(int) (MainGame.ySize-255*MainGame.yScalingFactor);
			}
		}
		
		for(int j=0; j<55; j++){
			if(Enemies.Ninjar[j] && Enemies.Ninja[j].intersects(floorBounds[k])){
				Enemies.Ninjavely[j]=0;
				Enemies.Ninjay[j]=(int) (MainGame.ySize-255*MainGame.yScalingFactor);
			}
		}
		
		for(int j=0; j<55; j++){
			if(Enemies.Shader[j] && Enemies.Shade[j].intersects(floorBounds[k])){
				Enemies.Shadevely[j]=0;
				Enemies.Shadey[j]=(int) (MainGame.ySize-255*MainGame.yScalingFactor);
			}
		}
		
		for(int j=0; j<55; j++){
			if(Enemies.SJr[j] && Enemies.SJ[j].intersects(floorBounds[k])){
				Enemies.SJvely[j]=0;
				Enemies.SJy[j]=(int) (MainGame.ySize-135*MainGame.yScalingFactor);
			}
		}
	}
	
	public void addPlatform(BufferedImage platform, int xposition, int yposition, int length, int height, int type, int num){
		rplatform[num]=true;
		platformImg[num] = SpriteObj(platform, 32, 32, type, 1);
		xPlatformPosition[num] = xposition;
		yPlatformPosition[num] = yposition;
		xPlatformCount[num] = length;
		yPlatformCount[num] = height;
		velxPlatform[num] = 0;
		velyPlatform[num] = 0;
	}
	
	public void platform(int k){
		leftPlatformBound[k] = new Rectangle((int) (MainGame.xScalingFactor*(xPlatformPosition[k]-BGx)), (int) (MainGame.yScalingFactor*(yPlatformPosition[k]+16-BGy)), (int) (MainGame.xScalingFactor*10), (int) (MainGame.yScalingFactor*(yPlatformCount[k]*32-32)));
		rightPlatformBound[k] = new Rectangle((int) (MainGame.xScalingFactor*(xPlatformPosition[k]+(xPlatformCount[k]*32)-10-BGx)), (int) (MainGame.yScalingFactor*(yPlatformPosition[k]+16-BGy)), (int) (MainGame.xScalingFactor*10), (int) (MainGame.yScalingFactor*(yPlatformCount[k]*32-32)));
		topPlatformBound[k] = new Rectangle((int) (MainGame.xScalingFactor*(xPlatformPosition[k]-BGx-5)), (int) (MainGame.yScalingFactor*(yPlatformPosition[k]-BGy)), (int) (MainGame.xScalingFactor*(10+xPlatformCount[k]*32)), (int) (MainGame.yScalingFactor*10));
		bottomPlatformBound[k] = new Rectangle((int) (MainGame.xScalingFactor*(xPlatformPosition[k]-BGx)), (int) (MainGame.yScalingFactor*(yPlatformPosition[k]+(yPlatformCount[k]*32)-10-BGy)), (int) (MainGame.xScalingFactor*(xPlatformCount[k]*32-2)), (int) (MainGame.yScalingFactor*10));
		xPlatformPosition[k]+=velxPlatform[k];
		yPlatformPosition[k]+=velyPlatform[k];
		
		if(player.getBounds().intersects(leftPlatformBound[k])){
			player.velx=0;
			player.x=(int) (MainGame.xScalingFactor*(xPlatformPosition[k]-BGx-128));
		}
		if(player.getBounds().intersects(rightPlatformBound[k])){
			player.velx=0;
			player.x=(int) (MainGame.xScalingFactor*(xPlatformPosition[k]+xPlatformCount[k]*32-BGx));
		}
		if(player.getBounds().intersects(topPlatformBound[k])){
			if(!Keys.jumping){player.vely=-1;}
			Keys.jumping=false;
			player.y=(int) (MainGame.yScalingFactor*(yPlatformPosition[k]-200-BGy));
		}
		if(player.getBounds().intersects(bottomPlatformBound[k])){
			player.vely=0;
			player.y=(int) (MainGame.yScalingFactor*(yPlatformPosition[k]+(yPlatformCount[k]*32)-BGy));
		}
		
		for(int j=0; j<55; j++){
			if(Enemies.SJr[j] && Enemies.SJ[j].intersects(bottomPlatformBound[k])){
				Enemies.SJvely[j]=0;
				Enemies.SJvely[j]=(int) (MainGame.yScalingFactor*(yPlatformPosition[k]+(yPlatformCount[k]*32)-BGy));
			}
		}
		
		for(int j=0; j<55; j++){
			if(Enemies.SJr[j] && Enemies.SJ[j].intersects(topPlatformBound[k])){
				Enemies.SJvely[j]=-1;
				Enemies.SJy[j]=(int) (MainGame.yScalingFactor*(yPlatformPosition[k]-70));
			}
		}
		
		for(int j=0; j<55; j++){
			if(Enemies.Ninjar[j] && Enemies.Ninja[j].intersects(bottomPlatformBound[k])){
				Enemies.Ninjavely[j]=0;
				Enemies.Ninjay[j]=(int) (MainGame.xScalingFactor*(yPlatformPosition[k]+(yPlatformCount[k]*32)-BGy));
			}
		}
		
		for(int j=0; j<55; j++){
			if(Enemies.Ninjar[j] && Enemies.Ninja[j].intersects(topPlatformBound[k])){
				Enemies.Ninjavely[j]=-1;
				Enemies.Ninjay[j]=(int) (MainGame.xScalingFactor*(yPlatformPosition[k]-200));
			}
		}
		
		}
		
		public void addDamage(BufferedImage damage, int xdamage, int ydamage, int length, int height, int num){
			rdamage[num]=true;
			damageImg[num] = SpriteObj(damage, 32, 32, 1, 1);
			xDamagePosition[num] = xdamage;
			yDamagePosition[num] = ydamage;
			xDamageCount[num] = length;
			yDamageCount[num] = height;
		}
		
		public void damage(int k, BufferedImage damage){
			if(MainGame.currentTickCount%7==0){damageTicker++;}
			if(damageTicker>10 || damageTicker<1){damageTicker=1;}
			damageImg[k] = SpriteObj(damage, 32, 32, damageTicker, 1);
			leftDamageBound[k] = new Rectangle((int) (MainGame.xScalingFactor*(xDamagePosition[k]-BGx)), (int) (MainGame.yScalingFactor*(yDamagePosition[k]+16-BGy)), (int) (MainGame.xScalingFactor*10), (int) (MainGame.yScalingFactor*(yDamageCount[k]*32-32)));
			rightDamageBound[k] = new Rectangle((int) (MainGame.xScalingFactor*(xDamagePosition[k]+(xDamageCount[k]*32)-10-BGx)), (int) (MainGame.yScalingFactor*(yDamagePosition[k]+16-BGy)), (int) (MainGame.xScalingFactor*10), (int) (MainGame.yScalingFactor*(yDamageCount[k]*32-32)));
			topDamageBound[k] = new Rectangle((int) (MainGame.xScalingFactor*(xDamagePosition[k]-BGx-5)), (int) (MainGame.yScalingFactor*(yDamagePosition[k]-BGy)), (int) (MainGame.xScalingFactor*(10+xDamageCount[k]*32)), (int) (MainGame.yScalingFactor*10));
			bottomDamageBound[k] = new Rectangle((int) (MainGame.xScalingFactor*(xDamagePosition[k]-BGx)), (int) (MainGame.yScalingFactor*(yDamagePosition[k]+(yDamageCount[k]*32)-10-BGy)), (int) (MainGame.xScalingFactor*(xDamageCount[k]*32-2)), (int) (MainGame.yScalingFactor*10));
			
			if(player.getBounds().intersects(leftDamageBound[k])){
				player.velx=-20;
				player.health-=2;
			}
			if(player.getBounds().intersects(rightDamageBound[k])){
				player.velx=20;
				player.health-=2;;
			}
			if(player.getBounds().intersects(topDamageBound[k])){
				player.vely=-25;
				player.health-=2;
			}
			if(player.getBounds().intersects(bottomDamageBound[k])){
				player.velx=25;
				player.health-=2;;
			}
		
	}
	
	public void movePlatforms(int velx, int vely, int id){
		if(rplatform[id]){
			platform(id);
			velxPlatform[id]=velx;
			velyPlatform[id]=vely;
			platform(id);
			if(player.getBounds().intersects(topPlatformBound[id])){
				player.velx=Player.velx+vely;
				player.vely=vely;
			}
		}
	}
	
	public void moveDamage(int velx, int vely, int id){
		if(rdamage[id]){
			xDamagePosition[id]+=velx;
			yDamagePosition[id]+=vely;
		}
	}
	
	public void addHealth(int x, int y, int k){
		xhealth[k]=x;
		yhealth[k]=y;
		rhealth[k]=true;
		healthItem[k]=new Rectangle(xhealth[k], yhealth[k], 50, 50);
		itemCollected[0]=true;
	}
	
	public BufferedImage health(int k){
		healthImg = ResourceManager.Acetone;
		if(player.getBounds().intersects(healthItem[k])){
			rhealth[k]=false;
			healthItem[k]=new Rectangle(0,0,0,0);
			if(player.health<45){player.health+=2;}
			else{player.health=50;}
		}
		if(rhealth[k]){
			healthItem[k]=new Rectangle(xhealth[k]-BGx, yhealth[k]-BGy, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		}
		return healthImg;
	}
	
	public void addGoal(int x, int y){
		xgoal=x;
		ygoal=y;
		rgoal=true;
		goalItem=new Rectangle(xgoal, ygoal, (int) (MainGame.xScalingFactor*300), (int) (MainGame.yScalingFactor*500));
	}
	
	public void goal(){
		if(rgoal){
		goalItem=new Rectangle(xgoal-BGx, ygoal-BGy, (int) (MainGame.xScalingFactor*300), (int) (MainGame.yScalingFactor*500));
		}
	}
	
	public void addSword(int x, int y){
		xsword=x;
		ysword=y;
		rsword=true;
		swordItem=new Rectangle(xsword, ysword, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*100));
		itemCollected[1]=false;
	}
	
	public BufferedImage sword(){
		swordImg = ResourceManager.Sword;
		if(player.getBounds().intersects(swordItem)){
			rsword=false;
			swordItem=new Rectangle(0,0,0,0);
			player.state=StatePlayer.SWORD;
			itemCollected[1]=true;
			currentWeapon=1;
			MainGame.prevState = MainGame.state;
			ScreenItems.currentD = ResourceManager.SwordDialog;
			MainGame.state=StateClass.DIALOG;
		}
		if(rsword){
			swordItem=new Rectangle(xsword-BGx, ysword-BGy, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*100));
		}
		return swordImg;
	}
	
	public void addAxe(int x, int y){
		xaxe=x;
		yaxe=y;
		raxe=true;
		axeItem=new Rectangle(xaxe, yaxe, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*100));
		itemCollected[3]=false;
	}
	
	public BufferedImage axe(){
		axeImg = ResourceManager.Axe;
		if(player.getBounds().intersects(axeItem)){
			raxe=false;
			axeItem=new Rectangle(0,0,0,0);
			player.state=StatePlayer.AXE;
			itemCollected[3]=true;
			currentWeapon=3;
			MainGame.prevState = MainGame.state;
			ScreenItems.currentD = ResourceManager.AxeDialog;
			MainGame.state=StateClass.DIALOG;
		}
		if(raxe){
			axeItem=new Rectangle(xaxe-BGx, yaxe-BGy, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*100));
		}
		return axeImg;
	}
	
	public void addMace(int x, int y){
		xmace=x;
		ymace=y;
		rmace=true;
		maceItem=new Rectangle(xmace, ymace, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*100));
		itemCollected[6]=false;
	}
	
	public BufferedImage mace(){
		maceImg = ResourceManager.Mace;
		if(player.getBounds().intersects(maceItem)){
			rmace=false;
			maceItem=new Rectangle(0,0,0,0);
			player.state=StatePlayer.MACE;
			itemCollected[6]=true;
			currentWeapon=5;
			MainGame.prevState = MainGame.state;
			ScreenItems.currentD = ResourceManager.MaceDialog;
			MainGame.state=StateClass.DIALOG;
		}
		if(rmace){
			maceItem=new Rectangle(xmace-BGx, ymace-BGy, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*100));
		}
		return maceImg;
	}
	
	public void addSickle(int x, int y){
		xsickle=x;
		ysickle=y;
		rsickle=true;
		sickleItem=new Rectangle(xsickle, ysickle, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		itemCollected[7]=false;
	}
	
	public BufferedImage sickle(){
		sickleImg = ResourceManager.Sickle;
		if(player.getBounds().intersects(sickleItem)){
			rsickle=false;
			sickleItem=new Rectangle(0,0,0,0);
			player.state=StatePlayer.SICKLE;
			itemCollected[7]=true;
			currentWeapon=7;
			MainGame.prevState = MainGame.state;
			ScreenItems.currentD = ResourceManager.SickleDialog;
			MainGame.state=StateClass.DIALOG;
		}
		if(rsickle){
			sickleItem=new Rectangle(xsickle-BGx, ysickle-BGy, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		}
		return sickleImg;
	}
	
	public void addFlame(int x, int y){
		xflame=x;
		yflame=y;
		rflame=true;
		flameItem=new Rectangle(xflame, yflame, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		itemCollected[2]=false;
	}
	
	public BufferedImage flame(){
		flameImg = ResourceManager.Flame;
		if(player.getBounds().intersects(flameItem)){
			rflame=false;
			flameItem=new Rectangle(0,0,0,0);
			player.state=StatePlayer.FLAME;
			itemCollected[2]=true;
			currentWeapon=2;
			MainGame.prevState = MainGame.state;
			ScreenItems.currentD = ResourceManager.FlameDialog;
			MainGame.state=StateClass.DIALOG;
		}
		if(rflame){
			flameItem=new Rectangle(xflame-BGx, yflame-BGy, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		}
		return flameImg;
	}
	
	public void addLightning(int x, int y){
		xlightning=x;
		ylightning=y;
		rlightning=true;
		lightningItem=new Rectangle(xlightning, ylightning, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		itemCollected[4]=false;
	}
	
	public BufferedImage lightning(){
		lightningImg = ResourceManager.Lightning;
		if(player.getBounds().intersects(lightningItem)){
			rlightning=false;
			lightningItem=new Rectangle(0,0,0,0);
			player.state=StatePlayer.LIGHTNING;
			itemCollected[4]=true;
			currentWeapon=4;
			MainGame.prevState = MainGame.state;
			ScreenItems.currentD = ResourceManager.LightningDialog;
			MainGame.state=StateClass.DIALOG;
		}
		if(rlightning){
			lightningItem=new Rectangle(xlightning-BGx, ylightning-BGy, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		}
		return lightningImg;
	}
	
	public void addStar(int x, int y){
		xstar=x;
		ystar=y;
		rstar=true;
		starItem=new Rectangle(xstar, ystar, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		itemCollected[5]=false;
	}
	
	public BufferedImage star(){
		starImg = ResourceManager.Star;
		if(player.getBounds().intersects(starItem)){
			rstar=false;
			starItem=new Rectangle(0,0,0,0);
			player.state=StatePlayer.STAR;
			itemCollected[5]=true;
			currentWeapon=5;
			MainGame.prevState = MainGame.state;
			ScreenItems.currentD = ResourceManager.StarDialog;
			MainGame.state=StateClass.DIALOG;
		}
		if(rstar){
			starItem=new Rectangle(xstar-BGx, ystar-BGy, 50, 50);
		}
		return starImg;
	}
	
	public void addTime(int x, int y){
		xtime=x;
		ytime=y;
		rtime=true;
		timeItem=new Rectangle(xtime, ytime, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		itemCollected[8]=false;
	}
	
	public BufferedImage time(){
		timeImg = ResourceManager.Time;
		if(player.getBounds().intersects(timeItem)){
			rtime=false;
			timeItem=new Rectangle(0,0,0,0);
			player.state=StatePlayer.TIME_WARP;
			itemCollected[8]=true;
			currentWeapon=8;
			MainGame.prevState = MainGame.state;
			ScreenItems.currentD = ResourceManager.TimeDialog;
			MainGame.state=StateClass.DIALOG;
		}
		if(rtime){
			timeItem=new Rectangle(xtime-BGx, ytime-BGy, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		}
		return timeImg;
	}
	
	public void addWrath(int x, int y){
		xwrath=x;
		ywrath=y;
		rwrath=true;
		wrathItem=new Rectangle(xsickle, ysickle, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		itemCollected[9]=false;
	}
	
	public BufferedImage wrath(){
		wrathImg = ResourceManager.Wrath;
		if(player.getBounds().intersects(wrathItem)){
			rwrath=false;
			wrathItem=new Rectangle(0,0,0,0);
			player.state=StatePlayer.WRATH;
			itemCollected[9]=true;
			currentWeapon=9;
			MainGame.prevState = MainGame.state;
			ScreenItems.currentD = ResourceManager.WrathDialog;
			MainGame.state=StateClass.DIALOG;
		}
		if(rwrath){
			wrathItem=new Rectangle(xwrath-BGx, ywrath-BGy, (int) (MainGame.xScalingFactor*50), (int) (MainGame.yScalingFactor*50));
		}
		return wrathImg;
	}
	
	
	public static void nextItem(){
		prevCheck = itemCount;
		for(int i=currentWeapon+1; i<=itemCount; i++){
			if(itemCollected[i]){
				if(i<=prevCheck){
					currentWeapon=i;
					prevCheck=i;
				}
			}
		}
		
		switch(currentWeapon){
		case 0:
			Player.state=StatePlayer.NORMAL;
			break;
		case 1:
			Player.state=StatePlayer.SWORD;
			break;
		case 2:
			Player.state=StatePlayer.FLAME;
			break;
		case 3:
			Player.state=StatePlayer.AXE;
			break;
		case 4:
			Player.state=StatePlayer.LIGHTNING;
			break;
		case 5:
			Player.state=StatePlayer.STAR;
			break;
		case 6:
			Player.state=StatePlayer.MACE;
			break;
		case 7:
			Player.state=StatePlayer.SICKLE;
			break;
		case 8:
			Player.state=StatePlayer.TIME_WARP;
			break;
		case 9:
			Player.state=StatePlayer.WRATH;
			break;
		}
	}
	
	public static void prevItem(){
		prevCheck = 0;
		for(int i=currentWeapon-1; i>=0; i--){
			if(itemCollected[i]){
				if(i>=prevCheck){
					currentWeapon=i;
					prevCheck=i;
				}
			}
		}
		
		switch(currentWeapon){
		case 0:
			Player.state=StatePlayer.NORMAL;
			break;
		case 1:
			Player.state=StatePlayer.SWORD;
			break;
		case 2:
			Player.state=StatePlayer.FLAME;
			break;
		case 3:
			Player.state=StatePlayer.AXE;
			break;
		case 4:
			Player.state=StatePlayer.LIGHTNING;
			break;
		case 5:
			Player.state=StatePlayer.STAR;
			break;
		case 6:
			Player.state=StatePlayer.MACE;
			break;
		case 7:
			Player.state=StatePlayer.SICKLE;
			break;
		case 8:
			Player.state=StatePlayer.TIME_WARP;
			break;
		case 9:
			Player.state=StatePlayer.WRATH;
			break;
		}
	}
	
	public static void removeAll(){
		BGx = 0;
		BGy = 0;
		Player.x=20;
		Player.y=700;
		rgoal=false;
		for(int k=0; k<55; k++){
			if(Enemies.Billr[k]){
				Enemies.Billr[k]=false;
			}
			if(Enemies.UFOr[k]){
				Enemies.UFOr[k]=false;
			}
			if(Enemies.Minir[k]){
				Enemies.Minir[k]=false;
			}
			if(Enemies.Ninjar[k]){
				Enemies.Ninjar[k]=false;
			}
			if(Enemies.Batr[k]){
				Enemies.Batr[k]=false;
			}
			if(Enemies.Shader[k]){
				Enemies.Shader[k]=false;
			}
			if(Enemies.Ghoulr[k]){
				Enemies.Ghoulr[k]=false;
			}
		}
		for(int k=0; k<55; k++){
			if(Environment.rhealth[k]){
				Environment.rhealth[k]=false;
			}
		}
		if(Environment.rsword){
			Environment.rsword=false;
			swordItem = new Rectangle(0,0,0,0);
		}
		if(Environment.rflame){
			Environment.rflame=false;
			flameItem = new Rectangle(0,0,0,0);
		}
		if(Environment.raxe){
			Environment.raxe=false;
			axeItem = new Rectangle(0,0,0,0);
		}
		if(Environment.rlightning){
			Environment.rlightning=false;
			lightningItem = new Rectangle(0,0,0,0);
		}
		if(Environment.rstar){
			Environment.rstar=false;
			starItem = new Rectangle(0,0,0,0);
		}
		if(Environment.rmace){
			Environment.rmace=false;
			maceItem = new Rectangle(0,0,0,0);
		}
		if(Environment.rsickle){
			Environment.rsickle=false;
			sickleItem = new Rectangle(0,0,0,0);
		}
		if(Environment.rtime){
			Environment.rtime=false;
			timeItem = new Rectangle(0,0,0,0);
		}
		if(Environment.rwrath){
			Environment.rwrath=false;
			wrathItem = new Rectangle(0,0,0,0);
		}
		
		for(int k=0; k<10; k++){
			if(Environment.rfloor[k]){
				Environment.rfloor[k]=false;
			}
		}
		for(int k=0; k<500; k++){
			if(Environment.rplatform[k]){
				Environment.rplatform[k]=false;
			}
			if(Environment.rdamage[k]){
				Environment.rdamage[k]=false;
			}
		}
	}
	
	public static BufferedImage SpriteObj(BufferedImage image, int width, int height, int col, int row){
		return image.getSubimage((col*width) - width, (row*height)-height, width, height);
	}


}
