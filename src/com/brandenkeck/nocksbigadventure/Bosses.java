package com.brandenkeck.nocksbigadventure;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Bosses {
	
	public static int GGx, GGy, GGhealth, GGvely, GGvelx, GGdir;
	public static int gctc = 1;
	private static int counter = 0;
	public static Rectangle GG = new Rectangle(0,0,0,0);
	public static Rectangle GGL = new Rectangle(0,0,0,0);
	public static Rectangle GGR = new Rectangle(0,0,0,0);
	public static BufferedImage charGogai;
	public static boolean GGr = false;
	
	public static int[] Wx = new int[5];
	public static int[] Wy = new int[5];
	public static int[] Wvelx = new int[5];
	public static int[] Wvely = new int[5];
	public static boolean[] Wr = new boolean[5];
	public static boolean[] Ar = new boolean[5];
	
	public static int SkullMx, SkullMy, SkullMhealth, SkullMvely, SkullMvelx;
	public static int smctc = 1;
	public static Rectangle SkullM = new Rectangle(0,0,0,0);
	public static Rectangle SkullML = new Rectangle(0,0,0,0);
	public static Rectangle SkullMR = new Rectangle(0,0,0,0);
	public static BufferedImage charSkullM;
	public static boolean SkullMr = false;
	
	public static int SkullLx, SkullLy, SkullLhealth, SkullLvely, SkullLvelx;
	public static int slctc = 1;
	public static Rectangle SkullL = new Rectangle(0,0,0,0);
	public static Rectangle SkullLL = new Rectangle(0,0,0,0);
	public static Rectangle SkullLR = new Rectangle(0,0,0,0);
	public static BufferedImage charSkullL;
	public static boolean SkullLr = false;
	
	public static int SkullRx, SkullRy, SkullRhealth, SkullRvely, SkullRvelx;
	public static int srctc = 1;
	public static Rectangle SkullR = new Rectangle(0,0,0,0);
	public static Rectangle SkullRL = new Rectangle(0,0,0,0);
	public static Rectangle SkullRR = new Rectangle(0,0,0,0);
	public static BufferedImage charSkullR;
	public static boolean SkullRr = false;
	
	public static int[] Mx = new int[6];
	public static int[] My = new int[6];
	public static int[] Mvelx = new int[6];
	public static int[] Mvely = new int[6];
	public static boolean[] Mr = new boolean[6];
	
	public static int MOx, MOy, MOhealth, MOvelx, MOvely;
	public static int[] Appsx = new int[40];
	public static int[] Appsy = new int[40];
	public static int[] Appshealth = new int[40];
	public static int[] Appsvelx = new int[40];
	public static int[] Appsvely = new int[40];
	public static int moctc = 1;
	public static Rectangle MO = new Rectangle(0,0,0,0);
	public static Rectangle[] MOApps = new Rectangle[40];
	public static BufferedImage charMO;
	public static BufferedImage[] Appschar = new BufferedImage[40];
	public static boolean MOr = false;
	public static boolean[] Appsr = new boolean[40];
	
	public static int SJx[] = new int[100];
	public static int SJy[] = new int[100];
	public static int SJhealth[] = new int[100];
	public static int SJvely[] = new int[100];
	public static int SJvelx[] = new int[100];
	public static Rectangle SJ[] = new Rectangle[100];
	public static BufferedImage charSJ[] = new BufferedImage[100];
	public static boolean SJr[] = new boolean[100];
	public static int sjctc[] = new int[100];
	public static int sjticker[] = new int[100];
	
	public static int OmegaLx, OmegaRx, Omegay, Omegahealth, Omegavelx, Omegavely, otick1, otick2, otick3;
	public static int octc = 1;
	public static Rectangle OL = new Rectangle(0,0,0,0);
	public static Rectangle OR = new Rectangle(0,0,0,0);
	public static BufferedImage charOL, charOR;
	public static boolean Omegar = false;
	
	public static int[] randx = new int[3];
	public static int[] kStartL = new int[3];
	public static boolean[] Totalr = new boolean[3];
	public static boolean[] Lr = new boolean[30];
	public static int[] Lx = new int[30];
	public static int[] Ly = new int[30];
	public static Rectangle[] lightning = new Rectangle[30];
	public static BufferedImage[] charL = new BufferedImage[30];
	
	public static boolean[] Fr = new boolean[30];
	public static int[] Fx = new int[30];
	public static int[] Fy = new int[30];
	public static Rectangle[] fire = new Rectangle[30];
	public static BufferedImage[] charF = new BufferedImage[30];
	
	
	public static int gravity, check;
	public static BufferedImage ss, returnimg;
	public static boolean falling = true;
	public static int ticker = 1;
	public static int pTicker = 1;
	private Random randNum = new Random();
	private static Environment environment = new Environment();
	public Player player = new Player();
	
	public void spawnGG(int x, int y, int health){
		GGx=x;
		GGy=y;
		GGr=true;
		GGhealth=health;
		charGogai=ResourceManager.GogaiLeft;
		GG = new Rectangle(GGx, GGy, (int) (240*MainGame.xScalingFactor), (int) (240*MainGame.yScalingFactor));
		gctc=1;
	}
	
	public void tickGogai(){
		GGx = GGx+GGvelx;
		GGy = GGy+GGvely;
		GG = new Rectangle(GGx-Environment.BGx, GGy-Environment.BGy, (int) (240*MainGame.xScalingFactor), (int) (240*MainGame.yScalingFactor));
		GGR = new Rectangle(GGx-(int) (MainGame.xScalingFactor*2000)-Environment.BGx, GGy-(int) (MainGame.yScalingFactor*500)-Environment.BGy, (int) (2000*MainGame.xScalingFactor), (int) (700*MainGame.yScalingFactor));
		GGL = new Rectangle(GGx+(int) (MainGame.xScalingFactor*128)-Environment.BGx, GGy-(int) (MainGame.yScalingFactor*500)-Environment.BGy, (int) (2000*MainGame.xScalingFactor), (int) (700*MainGame.yScalingFactor));
		
		GGfall();
		GGsensePlayer();
		weights();
	}
	
	public void GGfall(){
		if(falling){
			gravity = 1;
			GGvely+=gravity;
		}
	}
	
public void GGsensePlayer(){
		counter+=MainGame.currentTickCount%2;
		
		if(GGL.intersects(player.getBounds())){
			charGogai=ResourceManager.GogaiRight;
			GGvelx=0;
			GGdir=1;
			
			if(counter%300>150 && counter%300<250){
			GGvelx=10;
			charGogai=GGriding(1);
			}
			
			if(counter%300>250){
			GGvelx=-10;
			charGogai=GGriding(1);
			}
		}
		
		if(GGR.intersects(player.getBounds())){
			charGogai=ResourceManager.GogaiLeft;
			GGvelx=0;
			GGdir=0;
			
			if(counter%300>150 && counter%300<250){
			GGvelx=-10;
			charGogai=GGriding(0);
			}
			
			if(counter%300>250){
			GGvelx=10;
			charGogai=GGriding(0);
			}
		}
		
		if(GG.intersects(player.getBounds())){
			
			switch(GGdir){
			case 0:
				player.vely-=5;
				player.velx=20;
				if(player.health>=1){player.health-=1;}
				else{player.health=0;}
			case 1:
				player.vely-=5;
				player.velx=-20;
				if(player.health>=1){player.health-=1;}
				else{player.health=0;}
			}
		}
		
		for(int k=0; k<50; k++){
		if(Player.Hr[k]){
		if(GG.intersects(Player.hit[k])){
			if(Player.Pr[k]){Player.Pr[k]=false;}
			GGhealth-=Player.damage;
		}
		}
		}
		
		if(!GGR.intersects(player.getBounds()) && !GGL.intersects(player.getBounds())){
			switch(GGdir){
			case 0:
				charGogai=ResourceManager.GogaiLeft;
				break;
			case 1:
				charGogai=ResourceManager.GogaiRight;
				break;
			}
			GGvelx=0;
		}
		

		if(GGx<300){
			GGvelx=0;
			GGx=300;
		}
		if(GGx>MainGame.xSize-(int)(240*MainGame.xScalingFactor)){
			GGvelx=0;
			GGx=MainGame.xSize-(int)(240*MainGame.xScalingFactor);
		}
}

public BufferedImage GGriding(int p){
	switch(p){
	case 0:
		ss=ResourceManager.GGMoveLeft;
		break;
	case 1:
		ss=ResourceManager.GGMoveRight;
		break;
	}
	int ctc = MainGame.currentTickCount%2;
	if(ctc == 0){
		ctc=2;
	}
	
	returnimg = ResourceManager.SpriteObj(ss, 240, 240, ctc, 1);
	return returnimg;
}

public void weights(){
	
	for(int k=0; k<5; k++){
		if(!Wr[k]){
			Wr[k]=true;
			Wx[k] = GGx+120;
			Wy[k] = GGy;
			Wvely[k]=-20;
			switch(GGdir){
			case 0:
				Wvelx[k]=-(randNum.nextInt(50)+1);
				break;
			case 1:
				Wvelx[k]=randNum.nextInt(50)+1;
				break;
			}
		}
		else{
			Wx[k]+=Wvelx[k];
			Wy[k]+=Wvely[k];
			Wvely[k]+=1;
			if(Wy[k]>=MainGame.ySize-32){
				Wr[k]=false;
				Ar[k]=true;
			}
			if(player.getBounds().intersects(new Rectangle(Wx[k], Wy[k], (int) (90*MainGame.xScalingFactor), (int) (60*MainGame.yScalingFactor)))){
				player.health-=1;
				Wr[k]=false;
				Ar[k]=true;
			}
		}

	}
	
}


public BufferedImage GGdeath(){
	
	int RAWctc = MainGame.currentTickCount%5;
	if(RAWctc == 0){
		gctc++;
	}
	if(gctc>15){
		GGr=false;
		gctc=15;
	}
	
	switch(GGdir){
	case 0:
		ss=ResourceManager.GGDeathLeft;
		returnimg = ResourceManager.SpriteObj(ss, 240, 240, gctc, 1);
		break;
	case 1:
		ss=ResourceManager.GGDeathRight;
		returnimg = ResourceManager.SpriteObj(ss, 240, 240, gctc, 1);
		break;
	}
	
	return returnimg;
}

public void spawnSkull(int x, int y, int health){
	SkullMx=x;
	SkullMy=y;
	SkullMr=true;
	SkullMhealth=health;
	charSkullM=ResourceManager.SpriteObj(ResourceManager.Skull, 500, 500, 1, 1);
	SkullM = new Rectangle(SkullMx, SkullMy, (int) (500*MainGame.xScalingFactor), (int) (500*MainGame.yScalingFactor));
	smctc=1;
	SkullLx=x-100;
	SkullLy=y+450;
	SkullLr=true;
	SkullLhealth=(int) (health/2);
	charSkullL=ResourceManager.SkullHand;
	SkullL = new Rectangle(SkullMx, SkullMy, (int) (225*MainGame.xScalingFactor), (int) (150*MainGame.yScalingFactor));
	slctc=1;
	SkullRx=x-50;
	SkullRy=y+550;
	SkullRr=true;
	SkullRhealth=(int) (health/2);
	charSkullR=ResourceManager.SkullHand;
	SkullR = new Rectangle(SkullMx, SkullMy, (int) (225*MainGame.xScalingFactor), (int) (150*MainGame.yScalingFactor));
	srctc=1;
}

public void tickSkull(){
	ticker+=MainGame.currentTickCount%2;
	if(ticker>60){ticker=1;}
	
	SkullMx=SkullMx+SkullMvelx+((int) (4*Math.sin(2*Math.PI*ticker/60)));;
	SkullMy=SkullMy+SkullMvely+((int) (4*Math.sin(2*Math.PI*ticker/60)));;
	SkullLx=SkullLx+SkullLvelx+((int) (4*Math.cos(2*Math.PI*ticker/60)));;
	SkullLy=SkullLy+SkullLvely+((int) (4*Math.sin(2*Math.PI*ticker/60)));;
	SkullRx=SkullRx+SkullRvelx+((int) (4*Math.sin(2*Math.PI*ticker/60)));;
	SkullRy=SkullRy+SkullRvely+((int) (4*Math.cos(2*Math.PI*ticker/60)));;
	
	SkullM = new Rectangle(SkullMx-Environment.BGx, SkullMy-Environment.BGy, (int) (500*MainGame.xScalingFactor), (int) (500*MainGame.yScalingFactor));
	SkullL = new Rectangle(SkullLx-Environment.BGx, SkullLy-Environment.BGy, (int) (225*MainGame.xScalingFactor), (int) (150*MainGame.yScalingFactor));
	SkullR = new Rectangle(SkullRx-Environment.BGx, SkullRy-Environment.BGy, (int) (225*MainGame.xScalingFactor), (int) (150*MainGame.yScalingFactor));
	
	magic();
	moveSkull();
	SkullsensePlayer();
}



public void moveSkull(){
	
	charSkullM=ResourceManager.SpriteObj(ResourceManager.Skull, 500, 500, MainGame.currentTickCount%3+1, 1);
	
	SkullMvelx=player.velx - (SkullMx-1200)/20;
	SkullMvely=player.vely -((SkullMy-Environment.BGy)-200)/20;
	SkullLvelx=SkullMvelx;
	SkullLvely=SkullMvely;
	SkullRvelx=SkullMvelx;
	SkullRvely=SkullMvely;
	
}

public void SkullsensePlayer(){
	if(SkullM.intersects(player.getBounds())){
		if(player.x<=SkullMx){	
			player.velx=-20;
		}
		if(player.x>SkullMx){	
			player.velx=20;
		}
		if(player.y<SkullMy){	
			player.vely-=20;
		}
		if(player.y>=SkullMy){
			player.vely=20;
		}
		if(player.health>=3){player.health-=3;}
		else{player.health=0;}
	}
	
	for(int k=0; k<50; k++){
	if(Player.Hr[k]){
	if(SkullM.intersects(Player.hit[k])){
		if(Player.Pr[k]){Player.Pr[k]=false;}
		SkullMhealth-=Player.damage;
	}
	}
	}
	
	if(SkullL.intersects(player.getBounds())){
		if(player.x<=SkullLx){	
			player.velx=-20;
		}
		if(player.x>SkullLx){	
			player.velx=20;
		}
		if(player.y<SkullLy){	
			player.vely-=20;
		}
		if(player.y>=SkullLy){
			player.vely=20;
		}
		if(player.health>=3){player.health-=3;}
		else{player.health=0;}
	}
	
	for(int k=0; k<50; k++){
	if(Player.Hr[k]){
	if(SkullL.intersects(Player.hit[k])){
		if(Player.Pr[k]){Player.Pr[k]=false;}
		SkullLhealth-=Player.damage;
	}
	}
	}
	
	if(SkullR.intersects(player.getBounds())){
		if(player.x<=SkullRx){	
			player.velx=-20;
		}
		if(player.x>SkullRx){	
			player.velx=20;
		}
		if(player.y<SkullRy){	
			player.vely-=20;
		}
		if(player.y>=SkullRy){
			player.vely=20;
		}
		if(player.health>=3){player.health-=3;}
		else{player.health=0;}
	}
	
	for(int k=0; k<50; k++){
	if(Player.Hr[k]){
	if(SkullR.intersects(Player.hit[k])){
		if(Player.Pr[k]){Player.Pr[k]=false;}
		SkullRhealth-=Player.damage;
	}
	}
	}
}

public void magic(){
	pTicker+=MainGame.currentTickCount%2;
	if(check<50){pTicker=1;}
	
	if(SkullLr){
	for(int k=0; k<=2; k++){
		if(!Mr[k]){
			Mr[k]=true;
			Mx[k] = SkullLx;
			My[k] = SkullLy;
			Mvelx[k] = 0;
			Mvely[k] = 0;
			}
		else{
			Mx[k]+=Mvelx[k];
			My[k]+=Mvely[k];
			if(Mx[k]>player.x+128){
				Mvelx[k]=(int) ((player.x+Environment.BGx-Mx[k])/(100*k+1));
				Mvely[k]=(int) ((player.y+Environment.BGy-My[k])/(100*k+1));
			}
			else{
				Mvelx[k]=-5;
				Mvely[k]=-5;
			}
			if(Mx[k]<=-50-Environment.BGx){Mr[k]=false;}
			if(player.getBounds().intersects(new Rectangle(Mx[k], My[k], (int) (50*MainGame.xScalingFactor), (int) (50*MainGame.yScalingFactor)))){
				player.health-=1;
				Mr[k]=false;
			}
		}
	}
	}
	
	if(SkullRr){
	for(int k=3; k<=5; k++){
		if(!Mr[k]){
			Mr[k]=true;
			Mx[k] = SkullRx;
			My[k] = SkullRy;
			Mvelx[k] = 0;
			Mvely[k] = 0;
			}
		else{
			Mx[k]+=Mvelx[k];
			My[k]+=Mvely[k]+((int) ((k-3)*Math.sin(2*Math.PI*pTicker/50)));
			if(Mx[k]>player.x+128){
				Mvelx[k]=(int) ((player.x+Environment.BGx-Mx[k])/(100*(k-3+1)));
				Mvely[k]=(int) ((player.y+Environment.BGy-My[k])/(100*(k-3+1)));
			}
			else{
				Mvelx[k]=-5;
				Mvely[k]=-5;
			}
			if(Mx[k]<=-50-Environment.BGx){Mr[k]=false;}
			if(player.getBounds().intersects(new Rectangle(Mx[k], My[k], (int) (50*MainGame.xScalingFactor), (int) (50*MainGame.yScalingFactor)))){
				player.health-=1;
				Mr[k]=false;
			}
		}
	}
	}
}
	

public BufferedImage SkulldeathL(){
int RAWctc = MainGame.currentTickCount%5;
if(RAWctc == 0){
	slctc++;
}
if(slctc>15){
	SkullLr=false;
	slctc=15;
}

ss=ResourceManager.SkullHandDeath;
returnimg = ResourceManager.SpriteObj(ss, 225, 150, slctc, 1);

return returnimg;
}

public BufferedImage SkulldeathR(){
int RAWctc = MainGame.currentTickCount%5;
if(RAWctc == 0){
	srctc++;
}
if(srctc>15){
	SkullRr=false;
	srctc=15;
}

ss=ResourceManager.SkullHandDeath;
returnimg = ResourceManager.SpriteObj(ss, 225, 150, srctc, 1);

return returnimg;
}

public BufferedImage SkulldeathMain(){
int RAWctc = MainGame.currentTickCount%5;
if(RAWctc == 0){
	smctc++;
}
if(smctc>15){
	SkullMr=false;
	smctc=15;
}

ss=ResourceManager.SkullDeath;
returnimg = ResourceManager.SpriteObj(ss, 500, 500, smctc, 1);

return returnimg;
}

public void spawnOrb(int x, int y, int health){
	MOx=x;
	MOy=y;
	MOvelx = 4;
	MOvely = 4;
	charMO= ResourceManager.MasterOrb;
	MO = new Rectangle(MOx-Environment.BGx, MOy-Environment.BGy, (int) (MainGame.xScalingFactor*500), (int) (MainGame.yScalingFactor*500));
	MOr = true;
	MOhealth=health;
}

public void tickOrb(){
	MOx += MOvelx;
	MOy += MOvely;
	MO = new Rectangle(MOx-Environment.BGx, MOy-Environment.BGy, (int) (MainGame.xScalingFactor*500), (int) (MainGame.yScalingFactor*500));
	charOR= ResourceManager.SpriteObj(ResourceManager.OmegaRight, 750, 550, MainGame.currentTickCount%4+1, 1);
	collisionOrb();
	motionOrb();
}

public void collisionOrb(){
	if(MO.intersects(player.getBounds())){
		if(MOx>player.x){player.velx=-10;}
		if(MOx<=player.x){player.velx=10;}
		player.vely+=5;
		if(player.health>=5){player.health-=5;}
		else{player.health=0;}
	}
	
	for(int j=0; j<50; j++){
	if(Player.Hr[j]){
	if(MO.intersects(Player.hit[j])){
		if(Player.Pr[j]){Player.Pr[j]=false;}
		MOhealth-=Player.damage;
	}
	}
	}
}

public void motionOrb(){
	
	int plusx1, plusx2, plusy1, plusy2;
	
	if(MOhealth>200){
		plusx1 = randNum.nextInt(5);
		plusx2 = randNum.nextInt(5);
		plusy1 = randNum.nextInt(5);
		plusy2 = randNum.nextInt(5);
	}
	else{
		plusx1 = randNum.nextInt(25);
		plusx2 = randNum.nextInt(25);
		plusy1 = randNum.nextInt(25);
		plusy2 = randNum.nextInt(25);
	}
	
	if(MOx<=100){
		MOvelx = plusx1 + plusx2;
	}
	if(MOx>=2400){
		MOvelx = -plusx1 - plusx2;
	}
	if(MOy<10){
		MOvely = plusy1 + plusy2;
	}
	if(MOy>3490){
		MOvely = -plusy1 - plusy2;
	}
}

public BufferedImage deathOrb(){
	
	int RAWctc = MainGame.currentTickCount%5;
	if(moctc==1){
		//Sound
	}
	if(RAWctc == 0){
		moctc++;
	}
	if(moctc>15){
		environment.addGoal(player.x+200, player.y-100);
		MOr=false;
		moctc=15;
	}
	
	ss=ResourceManager.OrbDeath;
	returnimg = ResourceManager.SpriteObj(ss, 500, 500, octc, 1);
	return returnimg;
}

public void spawnSJ0(){
	SJx[0]=(int) (1850*MainGame.xScalingFactor);
	SJx[0]=(int) (1000*MainGame.yScalingFactor);
	SJr[0]=true;
	SJhealth[0]=1;
	charSJ[0] = ResourceManager.SpriteObj(ResourceManager.SJStill, 80, 80, 1, 1);
	SJ[0] = new Rectangle(SJx[0], SJy[0], (int) (80*MainGame.xScalingFactor), (int) (80*MainGame.yScalingFactor));
	sjctc[0]=1;
}

public void spawnSJRemaining(int k){
	SJx[k]=(int) player.x+(1+k%2)*2000+(1+k%2)*85*k;
	SJy[k]=(int) (900*MainGame.yScalingFactor);
	SJr[k]=true;
	SJhealth[k]=100;
	charSJ[k] = ResourceManager.SpriteObj(ResourceManager.SJStill, 80, 80, 1, 1);
	SJ[k] = new Rectangle(SJx[0], SJy[0], (int) (80*MainGame.xScalingFactor), (int) (80*MainGame.yScalingFactor));
	sjctc[k]=1;
}

public void tickSJ(int k){
	SJx[k] = SJx[k]+SJvelx[k];
	SJy[k] = SJy[k]+SJvely[k];
	SJ[k] = new Rectangle(SJx[k]-Environment.BGx, SJy[k]-Environment.BGy, (int) (MainGame.xScalingFactor*80), (int) (MainGame.yScalingFactor*80));
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
		SJx[k]+=Player.kick;
		SJy[k]-=Player.kick;
		SJhealth[k]-=Player.damage;
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
			charSJ[k]=ResourceManager.SpriteObj(ResourceManager.SJJump, 80, 80, sjctc[k], 1);
			sjctc[k]=1;
			int nR = randNum.nextInt(4);
			SJvely[k] = -25 - 5*nR;
			if((Player.x+64)<SJx[k]-Environment.BGx){SJvelx[k] = -45;}
			if((Player.x+64)>=SJx[k]-Environment.BGx){SJvelx[k] = 45;}
			sjticker[k] = 1;
		}
		else{charSJ[k]=ResourceManager.SpriteObj(ResourceManager.SJJump, 80, 80, sjctc[k], 1);}
	
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
		
		if(k==0){
			for(int j=1; j<100; j++){
				spawnSJRemaining(j);
			}
			
		}
	}
	
	ss=ResourceManager.SJDeath;
	
	returnimg = ResourceManager.SpriteObj(ss, 80, 80, sjctc[k], 1);
	return returnimg;
}

public void spawnOmega(int x, int y, int health){
	OmegaLx=x;
	OmegaRx=x+650;
	Omegay=y;
	Omegavelx = 4;
	Omegavely = 4;
	charOL= ResourceManager.OmegaLeft;
	charOR= ResourceManager.SpriteObj(ResourceManager.OmegaRight, 750, 550, 1, 1);
	OL = new Rectangle(OmegaLx-Environment.BGx, Omegay-Environment.BGy, (int) (MainGame.xScalingFactor*750), (int) (MainGame.yScalingFactor*550));
	OR = new Rectangle(OmegaRx-Environment.BGx, Omegay-Environment.BGy, (int) (MainGame.xScalingFactor*750), (int) (MainGame.yScalingFactor*550));
	otick1 = 30;
	otick2 = 1;
	otick3 = 1;
	Omegar = true;
	Omegahealth=health;
}

public void tickOmega(){
	OmegaLx += Omegavelx;
	OmegaRx += Omegavelx;
	Omegay += Omegavely;
	OL = new Rectangle(OmegaLx-Environment.BGx, Omegay-Environment.BGy, (int) (MainGame.xScalingFactor*750), (int) (MainGame.yScalingFactor*550));
	OR = new Rectangle(OmegaRx-Environment.BGx, Omegay-Environment.BGy, (int) (MainGame.xScalingFactor*750), (int) (MainGame.yScalingFactor*550));
	charOR= ResourceManager.SpriteObj(ResourceManager.OmegaRight, 750, 550, MainGame.currentTickCount%4+1, 1);
	if(MainGame.currentTickCount%25==0){otick1++;}
	collisionOmega();
	motionOmega();
	tickFire();
	tickLightning();
	
	if(Omegahealth > 50000){
		
	}
	else if(Omegahealth > 20000){
		
	}
	else{
		
	}
}

public void collisionOmega(){
	if(OL.intersects(player.getBounds()) || OR.intersects(player.getBounds())){
		player.vely+=20;
		if(player.health>=10){player.health-=10;}
		else{player.health=0;}
	}
	
	for(int j=0; j<50; j++){
	if(Player.Hr[j]){
	if(OL.intersects(Player.hit[j]) || OR.intersects(Player.hit[j])){
		if(Player.Pr[j]){Player.Pr[j]=false;}
		Omegahealth-=Player.damage;
	}
	}
	}
}

public void motionOmega(){
	
	int plusx1, plusx2, plusy1, plusy2;
	
	if(Omegahealth>20000){
		plusx1 = randNum.nextInt(5);
		plusx2 = randNum.nextInt(5);
		plusy1 = randNum.nextInt(5);
		plusy2 = randNum.nextInt(5);
	}
	else{
		plusx1 = randNum.nextInt(25);
		plusx2 = randNum.nextInt(25);
		plusy1 = randNum.nextInt(25);
		plusy2 = randNum.nextInt(25);
	}
	
	if(OmegaLx<=250){
		Omegavelx = plusx1 + plusx2;
	}
	if(OmegaRx>=950){
		Omegavelx = -plusx1 - plusx2;
	}
	if(Omegay<10){
		Omegavely = plusy1 + plusy2;
	}
	if(Omegay>130){
		Omegavely = -plusy1 - plusy2;
	}
}

public void createLightning(){
	for(int j=0; j<3; j++){
		if(!Totalr[j]){
			randx[j] = randNum.nextInt(1920);
			Totalr[j] = true;
		}
	}
}

public void tickLightning(){
	for(int j=0; j<30; j++){
	
	}
}

public void createFire(){
	for(int i=0; i<30; i++){
		if(!Fr[i]){
			Fr[i] = true;
			Fx[i] = randNum.nextInt(1920);
			Fy[i]=-100;
		}
	}
}

public void tickFire(){
	for(int k=0; k<30; k++){
		if(Fr[k]){
			fire[k] = new Rectangle(Fx[k], Fy[k], (int) (MainGame.xScalingFactor*100), (int) (MainGame.yScalingFactor*100));
			if(Fy[k]<980){Fy[k]+=1;}
			if(player.getBounds().intersects(fire[k])){
				player.health-=1;
				if(Fx[k]>player.x){player.velx=-5;}
				if(Fx[k]<player.x){player.velx=5;}
				Fr[k]=false;
				fire[k] = new Rectangle(0, 0, 0, 0);
			}
		}
	}
}

public BufferedImage deathOmegaL(){
	
	int RAWctc = MainGame.currentTickCount%5;
	if(octc==1){
		//Sound
	}
	if(RAWctc == 0){
		octc++;
	}
	if(octc>15){
		octc=15;
	}
	
	ss=ResourceManager.OLDeath;
	returnimg = ResourceManager.SpriteObj(ss, 750, 550, octc, 1);
	return returnimg;
}

public BufferedImage deathOmegaR(){
	if(octc>15){
		Omegar=false;
		octc=15;
	}
	
	ss=ResourceManager.ORDeath;
	returnimg = ResourceManager.SpriteObj(ss, 750, 550, octc, 1);
	return returnimg;
}

}
