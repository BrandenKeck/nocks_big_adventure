package com.brandenkeck.nocksbigadventure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;



public class SpriteHandler {

	private Player player = new Player();
	private Environment environment = new Environment();
	private Enemies enemies = new Enemies();
	private Bosses bosses = new Bosses();
	private int goalTicker = 1;
	
	public void renderPlayer(Graphics g){
		g.drawImage(Keys.character, player.x, player.y, (int) MainGame.xScalingFactor*128, (int) MainGame.yScalingFactor*200, null);
	}
	
	public void renderWalking(Graphics g){
		g.drawImage(player.walking(), player.x-player.xOffset, player.y, (int) MainGame.xScalingFactor*128, (int) MainGame.yScalingFactor*200, null);
	}
	
	public void renderJump(Graphics g){
		g.drawImage(player.jumping(), player.x, player.y, (int) MainGame.xScalingFactor*128, (int) MainGame.yScalingFactor*200, null);
	}
	
	public void renderFight(Graphics g, int j){
			player.fighting(g, j);
			/*g.setColor(Color.BLACK);
			g.fillRect(player.getHeadBounds());
			g.setColor(Color.RED);
			g.fillRect(player.getHeadBounds());
			g.setColor(Color.BLUE);
			g.fillRect(player.getHeadBounds());
			g.setColor(Color.GREEN);
			g.fillRect(player.getHeadBounds());*/
			/*for(int i=0; i<50; i++){
				//System.out.println(Player.hit[0]);
				g.fillRect(Player.hit[i].x, Player.hit[i].y, Player.hit[i].width, Player.hit[i].height);
			}*/
	}
	
	public void renderEnemies(Graphics g){
		for(int k=0; k<55; k++){
		if(enemies.Billr[k]){
			if(enemies.Billhealth[k]>0){
				enemies.tickBill(k);
				g.drawImage(enemies.charBill[k], Enemies.Billx[k]-environment.BGx, Enemies.Billy[k]-Environment.BGy, (int) MainGame.xScalingFactor*128, (int) MainGame.yScalingFactor*200, null);
			}
			else{
				enemies.Bill[k] = new Rectangle(0,0,0,0);
				g.drawImage(enemies.deathBill(k), Enemies.Billx[k]-environment.BGx, Enemies.Billy[k]-Environment.BGy, (int) MainGame.xScalingFactor*128, (int) MainGame.yScalingFactor*200, null);
			}
		}
		}
		
		for(int k=0; k<55; k++){
		if(enemies.Ninjar[k]){
			if(enemies.Ninjahealth[k]>0){
				enemies.tickNinja(k);
				g.drawImage(enemies.charNinja[k], Enemies.Ninjax[k]-environment.BGx, Enemies.Ninjay[k]-Environment.BGy, (int) MainGame.xScalingFactor*128, (int) MainGame.yScalingFactor*200, null);
			}
			else{
				enemies.Ninja[k] = new Rectangle(0,0,0,0);
				g.drawImage(enemies.deathNinja(k), Enemies.Ninjax[k]-environment.BGx, Enemies.Ninjay[k]-Environment.BGy, (int) MainGame.xScalingFactor*128, (int) MainGame.yScalingFactor*200, null);
			}
		}
		}
		
		for(int k=0; k<55; k++){
		if(enemies.UFOr[k]){
			if(enemies.UFOhealth[k]>0){
				enemies.tickUFO(k);
				g.drawImage(enemies.charUFO[k], Enemies.UFOx[k]-environment.BGx, Enemies.UFOy[k]-Environment.BGy, (int) MainGame.xScalingFactor*300, (int) MainGame.yScalingFactor*150, null);
			}
			else{
				enemies.UFO[k] = new Rectangle(0,0,0,0);
				g.drawImage(enemies.deathUFO(k), Enemies.UFOx[k]-environment.BGx, Enemies.UFOy[k]-Environment.BGy, (int) MainGame.xScalingFactor*300, (int) MainGame.yScalingFactor*150, null);
			}
		}
		}
		
		for(int k=0; k<55; k++){
			if(enemies.SJr[k]){
				if(enemies.SJhealth[k]>0){
					enemies.tickSJ(k);
					g.drawImage(enemies.charSJ[k], Enemies.SJx[k]-environment.BGx, Enemies.SJy[k]-Environment.BGy, (int) MainGame.xScalingFactor*80, (int) MainGame.yScalingFactor*80, null);
				}
				else{
					enemies.SJ[k] = new Rectangle(0,0,0,0);
					g.drawImage(enemies.deathSJ(k), Enemies.SJx[k]-environment.BGx, Enemies.SJy[k]-Environment.BGy, (int) MainGame.xScalingFactor*80, (int) MainGame.yScalingFactor*80, null);
				}
			}
			}
		
		for(int k=0; k<55; k++){
		if(enemies.Batr[k]){
			if(enemies.Bathealth[k]>0){
				enemies.tickBat(k);
				g.drawImage(enemies.charBat[k], Enemies.Batx[k]-environment.BGx, Enemies.Baty[k]-Environment.BGy, (int) MainGame.xScalingFactor*200, (int) MainGame.yScalingFactor*80, null);
			}
			else{
				enemies.Bat[k] = new Rectangle(0,0,0,0);
				g.drawImage(enemies.deathBat(k), Enemies.Batx[k]-environment.BGx, Enemies.Baty[k]-Environment.BGy, (int) MainGame.xScalingFactor*200, (int) MainGame.yScalingFactor*80, null);
			}
		}
		}
		
		for(int k=0; k<55; k++){
		if(enemies.Ghoulr[k]){
			if(enemies.Ghoulhealth[k]>0){
				enemies.tickGhoul(k);
				g.drawImage(enemies.charGhoul[k], Enemies.Ghoulx[k]-environment.BGx, Enemies.Ghouly[k]-Environment.BGy, (int) MainGame.xScalingFactor*100, (int) MainGame.yScalingFactor*100, null);
			}
			else{
				enemies.Ghoul[k] = new Rectangle(0,0,0,0);
				g.drawImage(enemies.deathGhoul(k), Enemies.Ghoulx[k]-environment.BGx, Enemies.Ghouly[k]-Environment.BGy, (int) MainGame.xScalingFactor*100, (int) MainGame.yScalingFactor*100, null);
			}
		}
		}
		
		if(bosses.GGr){
			if(bosses.GGhealth>0){
				bosses.tickGogai();
				g.drawImage(bosses.charGogai, bosses.GGx-environment.BGx, bosses.GGy-Environment.BGy, (int) MainGame.xScalingFactor*240, (int) MainGame.yScalingFactor*240, null);
			}
			else{
				bosses.GG = new Rectangle(0,0,0,0);
				g.drawImage(bosses.GGdeath(), bosses.GGx-environment.BGx, bosses.GGy-Environment.BGy, (int) MainGame.xScalingFactor*240, (int) MainGame.yScalingFactor*240, null);
			}
			
		}
		
		if(bosses.SkullMr){
			if(bosses.SkullMhealth>0){
				bosses.tickSkull();
				g.drawImage(bosses.charSkullM, bosses.SkullMx-environment.BGx, bosses.SkullMy-Environment.BGy, (int) MainGame.xScalingFactor*500, (int) MainGame.yScalingFactor*500, null);
			}
			else{
				bosses.SkullM = new Rectangle(0,0,0,0);
				bosses.SkullL = new Rectangle(0,0,0,0);
				bosses.SkullR = new Rectangle(0,0,0,0);
				g.drawImage(bosses.SkulldeathMain(), bosses.SkullMx-environment.BGx, bosses.SkullMy-Environment.BGy, (int) MainGame.xScalingFactor*500, (int) MainGame.yScalingFactor*500, null);
				if(bosses.SkullRr){
					g.drawImage(bosses.SkulldeathR(), bosses.SkullRx-environment.BGx, bosses.SkullRy-Environment.BGy, (int) MainGame.xScalingFactor*225, (int) MainGame.yScalingFactor*150, null);
				}
				if(bosses.SkullLr){
					g.drawImage(bosses.SkulldeathL(), bosses.SkullLx-environment.BGx, bosses.SkullLy-Environment.BGy, (int) MainGame.xScalingFactor*225, (int) MainGame.yScalingFactor*150, null);
				}
				
			}
		}
		
		if(bosses.SkullLr){
			if(bosses.SkullLhealth>0){
				bosses.tickSkull();
				g.drawImage(bosses.charSkullL, bosses.SkullLx-environment.BGx, bosses.SkullLy-Environment.BGy, (int) MainGame.xScalingFactor*225, (int) MainGame.yScalingFactor*150, null);
			}
			else{
				bosses.SkullL = new Rectangle(0,0,0,0);
				g.drawImage(bosses.SkulldeathL(), bosses.SkullLx-environment.BGx, bosses.SkullLy-Environment.BGy, (int) MainGame.xScalingFactor*225, (int) MainGame.yScalingFactor*150, null);
			}
		}
		
		if(bosses.SkullRr){
			if(bosses.SkullRhealth>0){
				bosses.tickSkull();
				g.drawImage(bosses.charSkullR, bosses.SkullRx-environment.BGx, bosses.SkullRy-Environment.BGy, (int) MainGame.xScalingFactor*225, (int) MainGame.yScalingFactor*150, null);
			}
			else{
				bosses.SkullR = new Rectangle(0,0,0,0);
				g.drawImage(bosses.SkulldeathR(), bosses.SkullRx-environment.BGx, bosses.SkullRy-Environment.BGy, (int) MainGame.xScalingFactor*225, (int) MainGame.yScalingFactor*150, null);
			}
		}
		
		if(bosses.MOr){
			if(bosses.MOhealth>0){
				bosses.tickOrb();
				g.drawImage(bosses.charMO, bosses.MOx-environment.BGx, bosses.MOy-Environment.BGy, (int) MainGame.xScalingFactor*500, (int) MainGame.yScalingFactor*500, null);
			}
			else{
				bosses.MO = new Rectangle(0,0,0,0);
				g.drawImage(bosses.deathOrb(), bosses.MOx-environment.BGx, bosses.MOy-Environment.BGy, (int) MainGame.xScalingFactor*500, (int) MainGame.yScalingFactor*500, null);
			}
			
		}
		
		for(int k=0; k<100; k++){
		if(bosses.SJr[k]){
			if(bosses.SJhealth[k]>0){
				bosses.tickSJ(k);
				g.drawImage(bosses.charSJ[k], bosses.SJx[k]-environment.BGx, bosses.SJy[k]-environment.BGy, (int) MainGame.xScalingFactor*80, (int) MainGame.yScalingFactor*80, null);
			}
			else{
				bosses.SJ[k] = new Rectangle(0,0,0,0);
				g.drawImage(bosses.deathSJ(k), bosses.SJx[k]-environment.BGx, bosses.SJy[k]-environment.BGy, (int) MainGame.xScalingFactor*80, (int) MainGame.yScalingFactor*80, null);
			}
		}
		}
	
		if(bosses.Omegar){
			if(bosses.Omegahealth>0){
				bosses.tickOmega();
				g.drawImage(bosses.charOL, bosses.OmegaLx-environment.BGx, bosses.Omegay-Environment.BGy, (int) MainGame.xScalingFactor*750, (int) MainGame.yScalingFactor*550, null);
				g.drawImage(bosses.charOR, bosses.OmegaRx-environment.BGx, bosses.Omegay-Environment.BGy, (int) MainGame.xScalingFactor*750, (int) MainGame.yScalingFactor*550, null);
			}
			else{
				bosses.OL = new Rectangle(0,0,0,0);
				bosses.OR = new Rectangle(0,0,0,0);
				g.drawImage(bosses.deathOmegaL(), bosses.OmegaLx-environment.BGx, bosses.Omegay-Environment.BGy, (int) MainGame.xScalingFactor*750, (int) MainGame.yScalingFactor*550, null);
				g.drawImage(bosses.deathOmegaR(), bosses.OmegaRx-environment.BGx, bosses.Omegay-Environment.BGy, (int) MainGame.xScalingFactor*750, (int) MainGame.yScalingFactor*550, null);
			}
			
		}
	}
	
	public void renderProjectiles(Graphics g){
		if(bosses.GGr){
			for(int k=1; k<5; k++){
				int armTimer = MainGame.currentTickCount%20;
				if(bosses.Ar[k]){
					g.drawImage(ResourceManager.Arm, Bosses.GGx+110-Environment.BGx, Bosses.GGy-10-Environment.BGy, (int) MainGame.xScalingFactor*28, (int) MainGame.yScalingFactor*56, null);
					if(armTimer==0){
					bosses.Ar[k]=false;
					}
				}
				if(Bosses.Wr[k]){
					g.drawImage(ResourceManager.Weights, Bosses.Wx[k]-Environment.BGx, Bosses.Wy[k]-Environment.BGy, (int) MainGame.xScalingFactor*90, (int) MainGame.yScalingFactor*60, null);
				}
			}
		}
		
		if(bosses.SkullLr){
			for(int k=0; k<=2; k++){
				if(Bosses.Mr[k]){
					g.drawImage(ResourceManager.SpriteObj(ResourceManager.Magic, 50, 50, MainGame.currentTickCount%2+1, 1), Bosses.Mx[k]-Environment.BGx, Bosses.My[k]-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*50, null);
				}
			}
		}
		
		if(bosses.SkullRr){
			for(int k=3; k<=5; k++){
				if(Bosses.Mr[k]){
					g.drawImage(ResourceManager.SpriteObj(ResourceManager.Magic, 50, 50, MainGame.currentTickCount%2+1, 1), Bosses.Mx[k]-Environment.BGx, Bosses.My[k]-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*50, null);
				}
			}
		}
		
		/*if(bosses.Omegar){
			for(int k=0; k<30; k++){
				if(Bosses.Lr[k]){
					g.drawImage(bosses.charL[k], Bosses.Lx[k]-Environment.BGx, Bosses.Ly[k]-Environment.BGy, null);
				}
			}
			for(int k=0; k<30; k++){
				if(Bosses.Fr[k]){
					g.drawImage(bosses.charF[k], Bosses.Fx[k]-Environment.BGx, Bosses.Fy[k]-Environment.BGy, null);
				}
			}
		}*/
		
		for(int k=0; k<500; k++){
			if(Enemies.projR[k]){
				g.drawImage(Enemies.projImg[k], Enemies.projX[k], Enemies.projY[k], (int) MainGame.xScalingFactor*Enemies.projImg[k].getWidth(), (int) MainGame.yScalingFactor*Enemies.projImg[k].getHeight(), null);
			}
		}
		
		for(int k=0; k<100; k++){
			if(Player.Pr[k]){
				g.drawImage(Player.imgProg[k], Player.Px[k], Player.Py[k], (int) MainGame.xScalingFactor*Player.imgProg[k].getWidth(), (int) MainGame.yScalingFactor*Player.imgProg[k].getHeight(), null);
			}
		}
		
		for(int k=51; k<74; k++){
			if(Player.wrath){
				g.drawImage(ResourceManager.SpriteObj(ResourceManager.Tails, 50, 50, 1, 1), Player.Wx[k][0], Player.Wy[k][0], (int) (100*MainGame.xScalingFactor), (int) (100*MainGame.yScalingFactor), null);
				g.drawImage(ResourceManager.SpriteObj(ResourceManager.Tails, 50, 50, 2, 1), Player.Wx[k][1], Player.Wy[k][1], (int) (100*MainGame.xScalingFactor), (int) (100*MainGame.yScalingFactor), null);
				g.drawImage(ResourceManager.SpriteObj(ResourceManager.Tails, 50, 50, 3, 1), Player.Wx[k][2], Player.Wy[k][2], (int) (100*MainGame.xScalingFactor), (int) (100*MainGame.yScalingFactor), null);
				g.drawImage(Player.imgProg[k], Player.Px[k], Player.Py[k], (int) MainGame.xScalingFactor*Player.imgProg[k].getWidth(), (int) MainGame.yScalingFactor*Player.imgProg[k].getHeight(),  null);
				//g.drawImage(ResourceManager.SpriteObj(ResourceManager.Tails, 50, 50, 4, 1), Player.Wx[k][3], Player.Wy[k][3], (int) (100*MainGame.xScalingFactor), (int) (100*MainGame.yScalingFactor), null);
				//g.drawImage(ResourceManager.SpriteObj(ResourceManager.Tails, 50, 50, 5, 1), Player.Wx[k][4], Player.Wy[k][4], (int) (100*MainGame.xScalingFactor), (int) (100*MainGame.yScalingFactor), null);
			}
		}
	
	}
	
	public void renderHealthItemsAndGoal(Graphics g){
		for(int k=0; k<55; k++){
			if(Environment.rhealth[k]){
				g.drawImage(environment.health(k), Environment.xhealth[k]-environment.BGx, (int) (Environment.yhealth[k]+10*Math.sin(MainGame.currentTickCount*Math.PI/30))-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*50, null);
			}
		}
		if(Environment.rgoal){
			environment.goal();
			goalTicker+=MainGame.currentTickCount%2;
			if(goalTicker>27){goalTicker=1;}
			g.drawImage(ResourceManager.SpriteObj(ResourceManager.Goal, 300, 500, goalTicker, 1), Environment.xgoal-environment.BGx, (int) (Environment.ygoal-Environment.BGy), (int) MainGame.xScalingFactor*500, (int) MainGame.yScalingFactor*500, null);
		}
	}
	
	public void renderPowerups(Graphics g){
			if(Environment.rsword){
				g.drawImage(environment.sword(), Environment.xsword-environment.BGx, (int) (Environment.ysword+10*Math.cos(MainGame.currentTickCount*2*Math.PI/30))-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*100, null);
			}
			if(Environment.raxe){
				g.drawImage(environment.axe(), Environment.xaxe-environment.BGx, (int) (Environment.yaxe+10*Math.cos(MainGame.currentTickCount*2*Math.PI/30))-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*100, null);
			}
			if(Environment.rmace){
				g.drawImage(environment.mace(), Environment.xmace-environment.BGx, (int) (Environment.ymace+10*Math.cos(MainGame.currentTickCount*2*Math.PI/30))-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*100, null);
			}
			if(Environment.rsickle){
				g.drawImage(environment.sickle(), Environment.xsickle-environment.BGx, (int) (Environment.ysickle+10*Math.cos(MainGame.currentTickCount*2*Math.PI/30))-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*100, null);
			}
			if(Environment.rflame){
				g.drawImage(environment.flame(), Environment.xflame-environment.BGx, (int) (Environment.yflame+10*Math.cos(MainGame.currentTickCount*2*Math.PI/30))-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*50, null);
			}
			if(Environment.rlightning){
				g.drawImage(environment.lightning(), Environment.xlightning-environment.BGx, (int) (Environment.ylightning+10*Math.cos(MainGame.currentTickCount*2*Math.PI/30))-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*50, null);
			}
			if(Environment.rstar){
				g.drawImage(environment.star(), Environment.xstar-environment.BGx, (int) (Environment.ystar+10*Math.cos(MainGame.currentTickCount*2*Math.PI/30))-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*50, null);
			}
			if(Environment.rtime){
				g.drawImage(environment.time(), Environment.xtime-environment.BGx, (int) (Environment.ytime+10*Math.cos(MainGame.currentTickCount*2*Math.PI/30))-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*50, null);
			}
			if(Environment.rwrath){
				g.drawImage(environment.wrath(), Environment.xwrath-environment.BGx, (int) (Environment.ywrath+10*Math.cos(MainGame.currentTickCount*2*Math.PI/30))-Environment.BGy, (int) MainGame.xScalingFactor*50, (int) MainGame.yScalingFactor*50, null);
			}
	}
	
	public void renderEnvironment(Graphics g){
		for(int k=0; k<10; k++){
			if(environment.rfloor[k]){
				environment.floor(k);
				for(int i=0; i<environment.floorCount[k]; i++){
					g.drawImage(environment.floorImg[k], environment.xFloorPosition[k]+32*i-environment.BGx, MainGame.ySize-55-Environment.BGy, (int) MainGame.xScalingFactor*32, (int) MainGame.yScalingFactor*32, null);
				}
			}
		}
		for(int k=0; k<500; k++){
			if(environment.rplatform[k]){
				environment.platform(k);
				for(int i=0; i<environment.xPlatformCount[k]; i++){
					for(int j=0; j<environment.yPlatformCount[k]; j++){
						g.drawImage(environment.platformImg[k], environment.xPlatformPosition[k]+32*i-environment.BGx, environment.yPlatformPosition[k]+32*j-Environment.BGy, (int) MainGame.xScalingFactor*32, (int) MainGame.yScalingFactor*32, null);
					}
				}
				
				//System.out.println(environment.xPlatformPosition[k] + "," + environment.yPlatformPosition[k] + " " + environment.rplatform[k] + " " + k);
				/*g.setColor(Color.BLUE);
				g.fillRect(environment.xPlatformPosition[k]-environment.BGx, environment.yPlatformPosition[k]+16-environment.BGy, 1, environment.yPlatformCount[k]*32-32);
				g.fillRect(environment.xPlatformPosition[k]+(environment.xPlatformCount[k]*32)-1-environment.BGx, environment.yPlatformPosition[k]+16-environment.BGy, 1, environment.yPlatformCount[k]*32-32);
				g.setColor(Color.RED);
				g.fillRect(environment.xPlatformPosition[k]-environment.BGx-5, environment.yPlatformPosition[k]-environment.BGy, 10+environment.xPlatformCount[k]*32, 1);
				g.fillRect(environment.xPlatformPosition[k]-environment.BGx, environment.yPlatformPosition[k]+(environment.yPlatformCount[k]*32)-1-environment.BGy, environment.xPlatformCount[k]*32-2, 1);
				*/
			}
		}
		for(int k=0; k<500; k++){
			if(environment.rdamage[k]){
				if(MainGame.state == StateClass.LEVEL1){
					environment.damage(k, ResourceManager.DRed);
				}
				if(MainGame.state == StateClass.LEVEL3){
					environment.damage(k, ResourceManager.DGreen);
				}
				else{
					environment.damage(k, ResourceManager.DBlue);
				}
				for(int i=0; i<environment.xDamageCount[k]; i++){
					for(int j=0; j<environment.yDamageCount[k]; j++){
						g.drawImage(environment.damageImg[k], environment.xDamagePosition[k]+32*i-environment.BGx, environment.yDamagePosition[k]+32*j-Environment.BGy, (int) MainGame.xScalingFactor*32, (int) MainGame.yScalingFactor*32, null);
					}
				}
			}
		}
	}

}
