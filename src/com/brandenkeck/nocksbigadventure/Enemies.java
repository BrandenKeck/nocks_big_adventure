package com.brandenkeck.nocksbigadventure;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Enemies {
	public static BufferedImage[] charBill = new BufferedImage[55];
	public static boolean[] Billr = new boolean[55];
	public static int[] Billx = new int[55];
	public static int[] Billy = new int[55];
	public static int[] Billhealth = new int[55];
	public static int[] Billvely = new int[55];
	public static int[] Billvelx = new int[55];
	public static int dirBill[] = new int[55];
	public static int[] bctc = new int[55];
	public static Rectangle[] Bill = new Rectangle[55];
	public static Rectangle[] BAL = new Rectangle[55];
	public static Rectangle[] BAR = new Rectangle[55];
	public static Rectangle[] BAU = new Rectangle[55];
	
	public static BufferedImage[] charUFO = new BufferedImage[55];
	public static boolean[] UFOr = new boolean[55];
	public static int[] UFOx = new int[55];
	public static int[] UFOy = new int[55];
	public static int[] UFOhealth = new int[55];
	public static int[] UFOvelx = new int[55];
	public static int[] UFOvely = new int[55];
	public static int[] uctc = new int[55];
	public static Rectangle[] UFO = new Rectangle[55];
	
	public static BufferedImage[] charMini = new BufferedImage[55];
	public static boolean[] Minir = new boolean[55];
	public static int[] Minix = new int[55];
	public static int[] Miniy = new int[55];
	public static int[] Minihealth = new int[55];
	public static int[] Minivelx = new int[55];
	public static int[] Minively = new int[55];
	public static int[] mctc = new int[55];
	public static Rectangle[] Mini = new Rectangle[55];
	
	public static int SJx[] = new int[55];
	public static int SJy[] = new int[55];
	public static int SJhealth[] = new int[55];
	public static int SJvely[] = new int[55];
	public static int SJvelx[] = new int[55];
	public static Rectangle SJ[] = new Rectangle[55];
	public static BufferedImage charSJ[] = new BufferedImage[55];
	public static boolean SJr[] = new boolean[55];
	public static int sjctc[] = new int[55];
	public static int sjticker[] = new int[55];
	
	public static BufferedImage[] charNinja = new BufferedImage[55];
	public static boolean[] Ninjar = new boolean[55];
	public static int[] Ninjax = new int[55];
	public static int[] Ninjay = new int[55];
	public static int[] Ninjahealth = new int[55];
	public static int[] Ninjavely = new int[55];
	public static int[] Ninjavelx = new int[55];
	public static int dirNinja[] = new int[55];
	public static int[] nctc = new int[55];
	public static Rectangle[] Ninja = new Rectangle[55];
	public static Rectangle[] NAR = new Rectangle[55];
	public static Rectangle[] NAL = new Rectangle[55];
	public static Rectangle[] NAU = new Rectangle[55];
	public static Rectangle[] tNAR = new Rectangle[55];
	public static Rectangle[] tNAL = new Rectangle[55];
	
	public static BufferedImage[] charBat = new BufferedImage[55];
	public static boolean[] Batr = new boolean[55];
	public static int[] Batx = new int[55];
	public static int[] Baty = new int[55];
	public static int[] Bathealth = new int[55];
	public static int[] Batvelx = new int[55];
	public static int[] Batvely = new int[55];
	public static int[] batctc = new int[55];
	public static Rectangle[] Bat = new Rectangle[55];
	
	public static BufferedImage[] charShade = new BufferedImage[55];
	public static boolean[] Shader = new boolean[55];
	public static int[] Shadex = new int[55];
	public static int[] Shadey = new int[55];
	public static int[] Shadehealth = new int[55];
	public static int[] Shadevely = new int[55];
	public static int[] Shadevelx = new int[55];
	public static int dirShade[] = new int[55];
	public static int[] sctc = new int[55];
	public static Rectangle[] Shade = new Rectangle[55];
	public static Rectangle[] SAL = new Rectangle[55];
	public static Rectangle[] SAR = new Rectangle[55];
	public static Rectangle[] SAU = new Rectangle[55];
	
	public static BufferedImage[] charGhoul = new BufferedImage[55];
	public static boolean[] Ghoulr = new boolean[55];
	public static int[] Ghoulx = new int[55];
	public static int[] Ghouly = new int[55];
	public static int[] Ghoulhealth = new int[55];
	public static int[] Ghoulvelx = new int[55];
	public static int[] Ghoulvely = new int[55];
	public static int[] dirGhoul = new int[55];
	public static int[] ghoulctc = new int[55];
	public static Rectangle[] Ghoul = new Rectangle[55];
	
	public static BufferedImage[] projImg = new BufferedImage[500];
	public static Rectangle[] Proj = new Rectangle[500];
	public static int[] projX = new int[500];
	public static int[] projY = new int[500];
	public static int[] projVelX = new int[500];
	public static int[] projVelY = new int[500];
	public static boolean[] projR = new boolean[500];
	public static int projTicker;
	
	public static int gravity;
	public static int motion = 0;
	public static int motion2 = 0;
	public static int jumpticker;
	public static boolean falling = true;
	private Random randNum = new Random();
	public Player player = new Player();
	public static BufferedImage ss, returnimg;
	
	public void spawn(){
		switch(MainGame.state){
		case LEVEL1:
			if(Environment.BGx>2000){
				for(int i=0; i<12; i++){
					if(!Billr[i]){
						addBill(Environment.BGx+player.x+i*(int) (MainGame.xScalingFactor*500)+(int) (MainGame.xScalingFactor*2000), (int) (MainGame.yScalingFactor*800), 30, i);
					}
				}
				for(int j=12; j<15; j++){
					if(!Billr[j]){
						addBill(Environment.BGx+player.x-(int) (MainGame.xScalingFactor*1000)-(j-12)*(int) (MainGame.xScalingFactor*600), (int) (MainGame.yScalingFactor*800), 30, j);
					}
				}
				for(int j=0; j<6; j++){
					if(!SJr[j]){
						addSJ(Environment.BGx+player.x+(int) (MainGame.xScalingFactor*1000)+j*(int) (MainGame.xScalingFactor*900), (int) (MainGame.yScalingFactor*800), 35, j);
					}
				}
			}
			if(Environment.BGx>10000){
				for(int u=0; u<3; u++){
					if(!UFOr[u]){
						addUFO(Environment.BGx+player.x+u*(int) (MainGame.xScalingFactor*1000)+(int) (MainGame.xScalingFactor*3000), (int) (MainGame.yScalingFactor*400), 35, u);
					}
				}
			}
			break;
		case LEVEL2:
			for(int i=0; i<12; i++){
				if(!Ninjar[i]){
					addNinja(Environment.BGx+player.x+i*(int) (MainGame.xScalingFactor*500)+(int) (MainGame.xScalingFactor*2000), (int) (MainGame.yScalingFactor*-500), 50, i);
				}
			}
			for(int b=0; b<4; b++){
				if(!Batr[b]){
					addBat(Environment.BGx+player.x+b*(int) (MainGame.xScalingFactor*1000)+(int) (MainGame.xScalingFactor*3000), (int) (MainGame.yScalingFactor*400), 35, b);
				}
			}
			for(int b=4; b<7; b++){
				if(!Batr[b]){
					addBat(-(Environment.BGx+player.x+b*(int) (MainGame.xScalingFactor*1000)+(int) (MainGame.xScalingFactor*3000)), (int) (MainGame.yScalingFactor*400), 35, b);
				}
			}
			for(int b=0; b<4; b++){
				if(!Ghoulr[b]){
					addGhoul(Environment.BGx+player.x+b*(int) (MainGame.xScalingFactor*1000)+(int) (MainGame.xScalingFactor*3000), player.y+Environment.BGy+(int) (MainGame.yScalingFactor*1000), 35, b);
				}
			}
			for(int b=4; b<7; b++){
				if(!Ghoulr[b]){
					addGhoul(-(Environment.BGx+player.x+b*(int) (MainGame.xScalingFactor*1000)+(int) (MainGame.xScalingFactor*3000)), player.y+Environment.BGy+(int) (MainGame.yScalingFactor*1000), 35, b);
				}
			}
			break;
		case LEVEL3:
			for(int i=0; i<12; i++){
				if(!Billr[i]){
					addBill(Environment.BGx+player.x+i*(int) (MainGame.xScalingFactor*500)+(int) (MainGame.xScalingFactor*2000), (int) (MainGame.yScalingFactor*800), (int) (MainGame.yScalingFactor*90), i);
				}
			}
			for(int j=12; j<15; j++){
				if(!Billr[j]){
					addBill(Environment.BGx+player.x-(int) (MainGame.xScalingFactor*1000)-(j-12)*(int) (MainGame.xScalingFactor*600), (int) (MainGame.yScalingFactor*800), (int) (MainGame.yScalingFactor*90), j);
				}
			}
			for(int u=0; u<5; u++){
				if(!UFOr[u]){
					addUFO(Environment.BGx+player.x+u*(int) (MainGame.xScalingFactor*2000)+(int) (MainGame.xScalingFactor*3000), (int) (MainGame.yScalingFactor*400), 100, u);
				}
			}
			for(int j=0; j<7; j++){
				if(!SJr[j]){
					addSJ(Environment.BGx+player.x+(int) (MainGame.xScalingFactor*1000)+j*(int) (MainGame.xScalingFactor*2000), (int) (MainGame.yScalingFactor*800), 55, j);
				}
			}
			break;
		case LEVEL4:
			for(int j=0; j<7; j++){
				if(!SJr[j]){
					addSJ(Environment.BGx+player.x+(int) (MainGame.xScalingFactor*1000)+j*(int) (MainGame.xScalingFactor*2000), (int) (MainGame.yScalingFactor*800), 100, j);
				}
			}
			break;
		case LEVEL5:
			for(int b=0; b<4; b++){
				if(!Ghoulr[b]){
					addGhoul(0, Environment.BGx+player.x+b*(int) (MainGame.xScalingFactor*1000)+(int) (MainGame.xScalingFactor*3000), 50, b);
				}
			}
			break;
		}
		
		for(int i=0; i<55; i++){
			if(Billy[i]<Environment.BGy || Billy[i]>Environment.BGy+1080){
				Billr[i]=false;
			}
			if(Ninjay[i]<Environment.BGy || Ninjay[i]>Environment.BGy+1080){
				Ninjar[i]=false;
			}
			if(Shadey[i]<Environment.BGy || Shadey[i]>Environment.BGy+1080){
				Shader[i]=false;
			}
			if(SJy[i]<Environment.BGy-100 || SJy[i]>Environment.BGy+1080){
				SJr[i]=false;
			}
		}
		
	}
	
	public void addBill(int x, int y, int health, int k){
		Billx[k]=x;
		Billy[k]=y;
		Billr[k]=true;
		Billhealth[k]=health;
		charBill[k]=ResourceManager.BillStillLeft;
		Bill[k] = new Rectangle(Billx[k], Billy[k], (int) (MainGame.xScalingFactor*120), (int) (MainGame.yScalingFactor*200));
		dirBill[k]=1;
		bctc[k]=1;
	}
	
	public void tickBill(int k){
		Billx[k] = Billx[k]+Billvelx[k];
		Billy[k] = Billy[k]+Billvely[k];
		Bill[k] = new Rectangle(Billx[k]-Environment.BGx, Billy[k]-Environment.BGy, (int) (MainGame.xScalingFactor*120), (int) (MainGame.yScalingFactor*200));
		BAR[k] = new Rectangle(Billx[k]-2000-Environment.BGx, Billy[k]-2000-Environment.BGy, (int) (MainGame.xScalingFactor*2000), (int) (MainGame.yScalingFactor*2500));
		BAL[k] = new Rectangle(Billx[k]+128-Environment.BGx, Billy[k]-2000-Environment.BGy, (int) (MainGame.xScalingFactor*2000), (int) (MainGame.yScalingFactor*2500));
		
		fallBill(k);
		sensePlayerBill(k);
	}
	
	public void fallBill(int k){
		if(falling){
			if(MainGame.state==StateClass.LEVEL3){gravity=MainGame.currentTickCount%2;}
			else{gravity = 1;}
			Billvely[k]+=gravity;
		}
	}

	public void sensePlayerBill(int k){
		if(!BAR[k].intersects(player.getBounds()) && !BAL[k].intersects(player.getBounds())){
			switch(dirBill[k]){
			case 0:
				charBill[k]=ResourceManager.BillStillLeft;
				break;
			case 1:
				charBill[k]=ResourceManager.BillStillRight;
				break;
			}
			Billvelx[k]=0;
		}
		
		if(BAL[k].intersects(player.getBounds())){
			Billvelx[k]=7;
			dirBill[k]=1;
			charBill[k]=walkingBill(1);
		}
		
		if(BAR[k].intersects(player.getBounds())){
			Billvelx[k]=-3;
			dirBill[k]=0;
			charBill[k]=walkingBill(0);
		}
		
		if(Bill[k].intersects(player.getBounds())){
			
			switch(dirBill[k]){
			case 0:
				player.vely-=5;
				player.velx=-20;
				if(player.health>=1){player.health-=1;}
				else{player.health=0;}
				break;
			case 1:
				player.vely-=5;
				player.velx=20;
				if(player.health>=1){player.health-=1;}
				else{player.health=0;}
				break;
			}
		}
		
		for(int j=0; j<50; j++){
		if(Player.Hr[j]){
		if(Bill[k].intersects(Player.hit[j])){
			if(Player.Pr[j]){Player.Pr[j]=false;}
			
			switch(dirBill[k]){
			case 0:
				Billvelx[k]=2*Player.kick;
				break;
			case 1:
				Billvelx[k]=-(2*Player.kick);
				break;
			}
			Billvely[k]=Player.kick;
			Billhealth[k]-=Player.damage;
		}
		}
		}
		
		if(Environment.BGx==0 && Bill[k].intersects(new Rectangle(0, 0, 1, MainGame.ySize))){
			Billvelx[k]=0;
			Billx[k]=1;
		}
	}
	
	public BufferedImage walkingBill(int p){
		switch(p){
		case 0:
			ss=ResourceManager.BillWalkingLeft;
			break;
		case 1:
			ss=ResourceManager.BillWalkingRight;
			break;
		}
		int ctc = MainGame.currentTickCount%10;
		if(ctc == 0){
			ctc=10;
		}
		
		returnimg = ResourceManager.SpriteObj(ss, 128, 200, ctc, 1);
		return returnimg;
	}
	
	public BufferedImage deathBill(int k){
		
		int RAWctc = MainGame.currentTickCount%5;
		if(RAWctc == 0){
			bctc[k]++;
		}
		if(bctc[k]>15){
			Billr[k]=false;
			bctc[k]=15;
		}
		
		switch(dirBill[k]){
		case 0:
			ss=ResourceManager.BillDeathLeft;
			returnimg = ResourceManager.SpriteObj(ss, 128, 200, bctc[k], 1);
			break;
		case 1:
			ss=ResourceManager.BillDeathRight;
			returnimg = ResourceManager.SpriteObj(ss, 128, 200, bctc[k], 1);
			break;
		}
		
		return returnimg;
	}
	
	public void addUFO(int x, int y, int health, int k){
		UFOx[k]=x;
		UFOy[k]=y;
		UFOr[k]=true;
		UFOhealth[k]=health;
		charUFO[k]=ResourceManager.UFO;
		UFO[k] = new Rectangle(UFOx[k], UFOy[k], (int) (MainGame.xScalingFactor*300), (int) (MainGame.yScalingFactor*150));
		uctc[k]=1;
	}
	
	public void tickUFO(int k){
		UFOx[k] = UFOx[k]+UFOvelx[k];
		UFOy[k] = UFOy[k]+UFOvely[k];
		UFO[k] = new Rectangle(UFOx[k]-Environment.BGx, UFOy[k]-Environment.BGy, (int) (MainGame.xScalingFactor*300), (int) (MainGame.yScalingFactor*150));
		collisionUFO(k);
		motionUFO(k);
	}
	
	public void collisionUFO(int k){
		if(UFO[k].intersects(player.getBounds())){
			player.velx=-30;
			UFOhealth[k]=0;
		}
		
		for(int j=0; j<50; j++){
		if(Player.Hr[j]){
		if(UFO[k].intersects(Player.hit[j])){
			if(Player.Pr[j]){Player.Pr[j]=false;}
			UFOx[k]+=Player.kick;
			UFOhealth[k]-=Player.damage;
		}
		}
		}
	}
	
	public void motionUFO(int k){
		motion += MainGame.currentTickCount%2;
		if(motion>200){motion=0;}
		if(k%2==0){
			UFOvelx[k]=(int) (-7-5*Math.sin(2*Math.PI*motion/200));
			UFOvely[k]=(int) (50*Math.cos(2*Math.PI*motion/200));
		}
		else{
			UFOvely[k]=(int) (50*Math.sin(2*Math.PI*motion/200));
			UFOvelx[k]=(int) (-7-5*Math.cos(2*Math.PI*motion/200));
			}
		if((UFOx[k]-Environment.BGx)<-300){
			UFOr[k]=false;
		}
	}
	
	public BufferedImage deathUFO(int k){
		
		int RAWctc = MainGame.currentTickCount%5;
		if(RAWctc == 0){
			uctc[k]++;
		}
		if(uctc[k]>15){
			UFOr[k]=false;
			uctc[k]=15;
		}
		
		ss=ResourceManager.UFOdeath;
		returnimg = ResourceManager.SpriteObj(ss, 300, 150, uctc[k], 1);
		return returnimg;
	}
	
	public void addSJ(int x, int y, int health, int k){
		SJx[k]=x;
		SJy[k]=y;
		SJr[k]=true;
		SJhealth[k]=health;
		if(MainGame.nextState == StateClass.LEVEL1){charSJ[k] = ResourceManager.SpriteObj(ResourceManager.PSJStill, 80, 80, 1, 1);}
		else if(MainGame.nextState == StateClass.LEVEL2){charSJ[k] = ResourceManager.SpriteObj(ResourceManager.BSJStill, 80, 80, 1, 1);}
		else if(MainGame.nextState == StateClass.LEVEL4){charSJ[k] = ResourceManager.SpriteObj(ResourceManager.SJStill, 80, 80, 1, 1);}
		else{charSJ[k] = ResourceManager.SpriteObj(ResourceManager.LSJStill, 80, 80, 1, 1);}
		SJ[k] = new Rectangle(SJx[k], SJy[k], (int) (80*MainGame.xScalingFactor), (int) (80*MainGame.yScalingFactor));
		sjctc[k]=1;
	}

	public void tickSJ(int k){
		SJx[k] = SJx[k]+SJvelx[k];
		SJy[k] = SJy[k]+SJvely[k];
		SJ[k] = new Rectangle(SJx[k]-Environment.BGx, SJy[k]-Environment.BGy, (int) (80*MainGame.xScalingFactor), (int) (80*MainGame.yScalingFactor));
		SJfall(k);
		collisionSJ(k);
		motionSJ(k);
	}

	public void SJfall(int k){
		if(falling){
			gravity = 1;
			SJvely[k]+=gravity;
		}
		
		if(SJvelx[k] > 0){SJvelx[k]-=1;}
		if(SJvelx[k] < 0){SJvelx[k]+=1;}
		
	}

	public void collisionSJ(int k){
		if(SJ[k].intersects(player.getBounds())){
			if(SJx[k]>player.x){player.velx=-10;}
			if(SJx[k]<=player.x){player.velx=10;}
			player.vely=-10;
			if(player.health>=7){player.health-=7;}
			else{player.health=0;}
			
		}
		
		for(int j=0; j<50; j++){
		if(Player.Hr[j]){
		if(SJ[k].intersects(Player.hit[j])){
			if(Player.Pr[j]){Player.Pr[j]=false;}
			SJhealth[k]-=Player.damage;
			if(SJhealth[k]>0){
				if(SJx[k]>player.x){SJx[k]+=Player.kick;}
				if(SJx[k]>player.x){SJx[k]-=Player.kick;}
			}
		}
		}
		}
	}

	public void motionSJ(int k){
		int plus = randNum.nextInt(30) + 1;
		sjticker[k] += MainGame.currentTickCount%plus;
		
		if(sjticker[k]>2000){
			int RAWctc = MainGame.currentTickCount%7;
			if(RAWctc == 0){sjctc[k]++;}
			if(sjctc[k]>3){
				sjctc[k]=3;
				if(MainGame.state == StateClass.LEVEL1){charSJ[k] = ResourceManager.SpriteObj(ResourceManager.PSJJump, 80, 80, sjctc[k], 1);}
				else if(MainGame.state == StateClass.LEVEL2){charSJ[k] = ResourceManager.SpriteObj(ResourceManager.BSJJump, 80, 80, sjctc[k], 1);}
				else if(MainGame.state == StateClass.LEVEL4){charSJ[k] = ResourceManager.SpriteObj(ResourceManager.SJJump, 80, 80, sjctc[k], 1);}
				else{charSJ[k] = ResourceManager.SpriteObj(ResourceManager.LSJJump, 80, 80, sjctc[k], 1);}
				sjctc[k]=1;
				int nR = randNum.nextInt(4);
				SJvely[k] = -25 - 5*nR;
				if((Player.x+64)<SJx[k]-Environment.BGx){SJvelx[k] = -45;}
				if((Player.x+64)>=SJx[k]-Environment.BGx){SJvelx[k] = 45;}
				sjticker[k] = 1;
			}
			else{
				if(MainGame.state == StateClass.LEVEL1){charSJ[k] = ResourceManager.SpriteObj(ResourceManager.PSJJump, 80, 80, sjctc[k], 1);}
				else if(MainGame.state == StateClass.LEVEL2){charSJ[k] = ResourceManager.SpriteObj(ResourceManager.BSJJump, 80, 80, sjctc[k], 1);}
				else if(MainGame.state == StateClass.LEVEL4){charSJ[k] = ResourceManager.SpriteObj(ResourceManager.SJJump, 80, 80, sjctc[k], 1);}
				else{charSJ[k] = ResourceManager.SpriteObj(ResourceManager.LSJJump, 80, 80, sjctc[k], 1);}
				}
		
		}
	}

	public BufferedImage deathSJ(int k){
		
		int RAWctc = MainGame.currentTickCount%5;
		if(sjctc[k]==1){
			//Sound
		}
		if(RAWctc == 0){
			sjctc[k]++;
		}
		if(sjctc[k]>15){
			SJr[k]=false;
			sjctc[k]=15;
		}
		
		if(MainGame.state == StateClass.LEVEL1){ss=ResourceManager.PSJDeath;}
		else if(MainGame.state == StateClass.LEVEL2){ss=ResourceManager.BSJDeath;}
		else if(MainGame.state == StateClass.LEVEL4){ss=ResourceManager.SJDeath;}
		else{ss=ResourceManager.LSJDeath;}
		
		returnimg = ResourceManager.SpriteObj(ss, 80, 80, sjctc[k], 1);
		return returnimg;
	}
	
	public void addNinja(int x, int y, int health, int k){
		Ninjax[k]=x;
		Ninjay[k]=y;
		Ninjar[k]=true;
		Ninjahealth[k]=health;
		charNinja[k]=ResourceManager.NinjaStillLeft;
		Ninja[k] = new Rectangle(Ninjax[k], Ninjay[k], (int) (MainGame.xScalingFactor*120), (int) (MainGame.yScalingFactor*200));
		dirNinja[k]=1;
		nctc[k]=1;
	}
	
	public void tickNinja(int k){
		Ninjax[k] = Ninjax[k]+Ninjavelx[k];
		Ninjay[k] = Ninjay[k]+Ninjavely[k];
		Ninja[k] = new Rectangle(Ninjax[k]-Environment.BGx, Ninjay[k]-Environment.BGy, (int) (MainGame.xScalingFactor*120), (int) (MainGame.xScalingFactor*200));
		tNAR[k] = new Rectangle(Ninjax[k]-(int) (MainGame.xScalingFactor*200)-Environment.BGx, Ninjay[k]-(int) (MainGame.yScalingFactor*2000-Environment.BGy), (int) (MainGame.xScalingFactor*200), (int) (MainGame.yScalingFactor*2500));
		tNAL[k] = new Rectangle(Ninjax[k]+(int) (MainGame.xScalingFactor*128)-Environment.BGx, Ninjay[k]-(int) (MainGame.yScalingFactor*2000-Environment.BGy), (int) (MainGame.xScalingFactor*200), (int) (MainGame.yScalingFactor*2500));
		NAR[k] = new Rectangle(Ninjax[k]-(int) (MainGame.xScalingFactor*2000)-Environment.BGx, Ninjay[k]-(int) (MainGame.yScalingFactor*2000-Environment.BGy), (int) (MainGame.xScalingFactor*2000), (int) (MainGame.yScalingFactor*2500));
		NAL[k] = new Rectangle(Ninjax[k]+(int) (MainGame.xScalingFactor*128)-Environment.BGx, Ninjay[k]-(int) (MainGame.yScalingFactor*2000-Environment.BGy), (int) (MainGame.xScalingFactor*2000), (int) (MainGame.yScalingFactor*2500));
		
		fallNinja(k);
		sensePlayerNinja(k);
	}
	
	public void fallNinja(int k){
		if(falling){
			if(MainGame.state==StateClass.LEVEL3){gravity=MainGame.currentTickCount%2;}
			else{gravity = 1;}
			Ninjavely[k]+=gravity;
		}
	}

	public void sensePlayerNinja(int k){
		if(!NAR[k].intersects(player.getBounds()) && !NAL[k].intersects(player.getBounds())){
			switch(dirNinja[k]){
			case 0:
				charNinja[k]=ResourceManager.NinjaStillLeft;
				break;
			case 1:
				charNinja[k]=ResourceManager.NinjaStillRight;
				break;
			}
			Ninjavelx[k]=0;
		}
		
		if(NAL[k].intersects(player.getBounds())){
			Ninjavelx[k]=10;
			dirNinja[k]=1;
			charNinja[k]=walkingNinja(1);
		}
		
		if(NAR[k].intersects(player.getBounds())){
			Ninjavelx[k]=-10;
			dirNinja[k]=0;
			charNinja[k]=walkingNinja(0);
		}
		
		if(Ninja[k].intersects(player.getBounds())){
			
			switch(dirNinja[k]){
			case 0:
				player.vely-=5;
				player.velx=-20;
				if(player.health>=2){player.health-=2;}
				else{player.health=0;}
				break;
			case 1:
				player.vely-=5;
				player.velx=20;
				if(player.health>=2){player.health-=2;}
				else{player.health=0;}
				break;
			}
		}
		
		for(int j=0; j<50; j++){
		if(Player.Hr[j]){
		if(Ninja[k].intersects(Player.hit[j])){
			if(Player.Pr[j]){Player.Pr[j]=false;}
			
			switch(dirNinja[k]){
			case 0:
				Ninjavelx[k]=2*Player.kick;
				break;
			case 1:
				Ninjavelx[k]=-(2*Player.kick);
				break;
			}
			Ninjavely[k]=Player.kick;
			Ninjahealth[k]-=Player.damage;
		}
		}
		}
		
		if(Environment.BGx==0 && Ninja[k].intersects(new Rectangle(0, 0, 1, MainGame.ySize))){
			Ninjavelx[k]=0;
			Ninjax[k]=1;
		}
	}
	
	public BufferedImage walkingNinja(int p){
		switch(p){
		case 0:
			ss=ResourceManager.NinjaWalkLeft;
			break;
		case 1:
			ss=ResourceManager.NinjaWalkRight;
			break;
		}
		int ctc = MainGame.currentTickCount%10;
		if(ctc == 0){
			ctc=10;
		}
		
		returnimg = ResourceManager.SpriteObj(ss, 128, 200, ctc, 1);
		return returnimg;
	}
	
	public BufferedImage deathNinja(int k){
		
		int RAWctc = MainGame.currentTickCount%5;
		if(nctc[k]==1){
		}
		if(RAWctc == 0){
			nctc[k]++;
		}
		if(nctc[k]>15){
			Ninjar[k]=false;
			nctc[k]=15;
		}
		
		switch(dirNinja[k]){
		case 0:
			ss=ResourceManager.NinjaDeathLeft;
			returnimg = ResourceManager.SpriteObj(ss, 128, 200, nctc[k], 1);
			break;
		case 1:
			ss=ResourceManager.NinjaDeathRight;
			returnimg = ResourceManager.SpriteObj(ss, 128, 200, nctc[k], 1);
			break;
		}
		
		return returnimg;
	}
	
	public void addBat(int x, int y, int health, int k){
		Batx[k]=x;
		Baty[k]=y;
		Batr[k]=true;
		Bathealth[k]=health;
		charBat[k] = ResourceManager.SpriteObj(ResourceManager.BlackBat, 200, 80, 1, 1);
		Bat[k] = new Rectangle(Batx[k], Baty[k], (int) (MainGame.xScalingFactor*200), (int) (MainGame.yScalingFactor*20));
		batctc[k]=1;
	}
	
	public void tickBat(int k){
		Batx[k] = Batx[k]+Batvelx[k];
		Baty[k] = Baty[k]+Batvely[k];
		Bat[k] = new Rectangle(Batx[k]-Environment.BGx, Baty[k]-Environment.BGy, (int) (MainGame.xScalingFactor*200), (int) (MainGame.yScalingFactor*80));
		collisionBat(k);
		motionBat(k);
	}
	
	public void collisionBat(int k){
		if(Bat[k].intersects(player.getBounds())){
			if(Batx[k]>player.x){player.velx=-10;}
			if(Batx[k]<=player.x){player.velx=10;}
			if(player.health>=3){player.health-=3;}
			else{player.health=0;}
			
		}
		
		for(int j=0; j<50; j++){
		if(Player.Hr[j]){
		if(Bat[k].intersects(Player.hit[j])){
			if(Player.Pr[j]){Player.Pr[j]=false;}
			Batx[k]+=Player.kick;
			Bathealth[k]-=Player.damage;
		}
		}
		}
	}
	
	public void motionBat(int k){
		if((Player.x+64)<Batx[k]-Environment.BGx){Batvelx[k]=-10;}
		else{Batvelx[k]=10;}
		if((Player.y+50)<Baty[k]-Environment.BGy){Batvely[k]=-10;}
		else{Batvely[k]=10;}
		
		int RAWctc = MainGame.currentTickCount%5;
		if(RAWctc == 0){batctc[k]++;}
		if(batctc[k]>4){batctc[k]=1;}
		
		charBat[k] = ResourceManager.SpriteObj(ResourceManager.BlackBat, 200, 80, batctc[k], 1);
	}
	
	public BufferedImage deathBat(int k){
		
		int RAWctc = MainGame.currentTickCount%5;
		if(batctc[k]==1){
			//Sound
		}
		if(RAWctc == 0){
			batctc[k]++;
		}
		if(batctc[k]>15){
			Batr[k]=false;
			batctc[k]=15;
		}
		
		ss=ResourceManager.BlackBatDeath;
		
		returnimg = ResourceManager.SpriteObj(ss, 200, 80, batctc[k], 1);
		return returnimg;
	}
	
	public void addGhoul(int x, int y, int health, int k){
		Ghoulx[k]=x;
		Ghouly[k]=y;
		Ghoulr[k]=true;
		Ghoulhealth[k]=health;
		charGhoul[k] = ResourceManager.SpriteObj(ResourceManager.GhoulLeft, 100, 100, 1, 1);
		Ghoul[k] = new Rectangle(Ghoulx[k], Ghouly[k], (int) (MainGame.xScalingFactor*200), (int) (MainGame.yScalingFactor*20));
		ghoulctc[k]=1;
		dirGhoul[k]=1;
	}
	
	public void tickGhoul(int k){
		Ghoulx[k] = Ghoulx[k]+Ghoulvelx[k];
		Ghouly[k] = Ghouly[k]+Ghoulvely[k];
		Ghoul[k] = new Rectangle(Ghoulx[k]-Environment.BGx, Ghouly[k]-Environment.BGy, (int) (MainGame.xScalingFactor*100), (int) (MainGame.yScalingFactor*100));
		collisionGhoul(k);
		motionGhoul(k);
	}
	
	public void collisionGhoul(int k){
		if(Ghoul[k].intersects(player.getBounds())){
			if(Ghoulx[k]>player.x){player.velx=-10;}
			if(Ghoulx[k]<=player.x){player.velx=10;}
			if(player.health>=5){player.health-=5;}
			else{player.health=0;}
			
		}
		
		for(int j=0; j<50; j++){
		if(Player.Hr[j]){
		if(Ghoul[k].intersects(Player.hit[j])){
			if(Player.Pr[j]){Player.Pr[j]=false;}
			Ghoulx[k]+=Player.kick;
			Ghoulhealth[k]-=Player.damage;
		}
		}
		}
	}
	
	public void motionGhoul(int k){
		if((Player.x+64)<Ghoulx[k]-Environment.BGx){
			Ghoulvelx[k]=-4;
			dirGhoul[k] = 0;
			}
		else{
			Ghoulvelx[k]=4;
			dirGhoul[k] = 1;
			}
		if((Player.y+50)<Ghouly[k]-Environment.BGy){Ghoulvely[k]=-2;}
		else{Ghoulvely[k]=2;}
		
		int RAWctc = MainGame.currentTickCount%5;
		if(RAWctc == 0){ghoulctc[k]++;}
		if(ghoulctc[k]>4){ghoulctc[k]=1;}
		
		switch(dirGhoul[k]){
		case 0:
		charGhoul[k] = ResourceManager.SpriteObj(ResourceManager.GhoulLeft, 100, 100, ghoulctc[k], 1);
		break;
		case 1:
		charGhoul[k] = ResourceManager.SpriteObj(ResourceManager.GhoulRight, 100, 100, ghoulctc[k], 1);
		break;
		}
	}
	
	public BufferedImage deathGhoul(int k){
		
		int RAWctc = MainGame.currentTickCount%5;
		if(ghoulctc[k]==1){
			//ResourceManager.soundMap.get("UFODeath").play();
		}
		if(RAWctc == 0){
			ghoulctc[k]++;
		}
		if(ghoulctc[k]>15){
			Ghoulr[k]=false;
			ghoulctc[k]=15;
		}
		
		switch(dirGhoul[k]){
		case 0:
		ss = ResourceManager.GhoulDeathLeft;
		returnimg = ResourceManager.SpriteObj(ss, 100, 100, ghoulctc[k], 1);
		break;
		case 1:
		ss = ResourceManager.GhoulDeathRight;
		returnimg = ResourceManager.SpriteObj(ss, 100, 100, ghoulctc[k], 1);
		break;
		}
		
		return returnimg;
	}
}
