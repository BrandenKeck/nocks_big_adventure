package com.brandenkeck.nocksbigadventure;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;


public class ResourceManager {

	public static BufferedImage Loading;
	
	public static BufferedImage logo;
	public static BufferedImage play;
	public static BufferedImage options;
	public static BufferedImage tryagain;
	public static BufferedImage quit;
	public static BufferedImage titleBG;
	public static BufferedImage HealthBar;
	public static BufferedImage ItemBar;
	public static BufferedImage Current;
	public static BufferedImage Pause;
	public static BufferedImage Controls;
	public static BufferedImage Instructions;
	public static BufferedImage Cutscene;
	public static BufferedImage Level1;
	public static BufferedImage L1Para;
	public static BufferedImage BossBG1;
	public static BufferedImage Level3;
	public static BufferedImage L3Para;
	public static BufferedImage BossBG3;
	public static BufferedImage BossFG3;
	public static BufferedImage Level4;
	public static BufferedImage L4Para;
	public static BufferedImage BossFG4;
	public static BufferedImage Level6;
	public static BufferedImage BossBG6;
	public static BufferedImage Level7;
	public static BufferedImage L7Para;
	public static BufferedImage BossBG7;
	
	public static BufferedImage RainOverlay;
	public static BufferedImage LavaOverlay;
	public static BufferedImage TimeOverlay;
	public static BufferedImage Cloud1;
	public static BufferedImage Cloud2;
	public static BufferedImage Cloud3;
	public static BufferedImage BlackCloud;
	public static BufferedImage BlackCloud2;
	public static BufferedImage BlackCloud3;
	public static BufferedImage Rain;
	public static BufferedImage Blood;
	public static BufferedImage Leaf1;
	public static BufferedImage Leaf2;
	public static BufferedImage Explode;
	public static BufferedImage Stars;
	public static BufferedImage Comp;
	public static BufferedImage TV;
	public static BufferedImage Ash;
	public static BufferedImage Ember;
	public static BufferedImage GameOver;
	
	public static BufferedImage floorStone;
	public static BufferedImage floorBrick;
	public static BufferedImage floorWood;
	public static BufferedImage floorRoad;
	public static BufferedImage floorPlain;
	public static BufferedImage woodBlock;
	public static BufferedImage treeBlock;
	public static BufferedImage dirtBlock;
	public static BufferedImage dataBlock;
	public static BufferedImage constructBlock;
	public static BufferedImage floorLava;
	public static BufferedImage floorL6;
	public static BufferedImage floorSky;
	public static BufferedImage DRed;
	public static BufferedImage DGreen;
	public static BufferedImage DBlue;

	public static BufferedImage Acetone;
	public static BufferedImage Goal;
	public static BufferedImage Sword;
	public static BufferedImage Axe;
	public static BufferedImage Sickle;
	public static BufferedImage Mace;
	public static BufferedImage Flame;
	public static BufferedImage Lightning;
	public static BufferedImage Star;
	public static BufferedImage Time;
	public static BufferedImage Wrath;
	public static BufferedImage Fireball;
	public static BufferedImage Bolt;
	public static BufferedImage Starball;
	public static BufferedImage Timebomb;
	public static BufferedImage Tails;
	public static BufferedImage Meteor1;
	public static BufferedImage Meteor2;
	public static BufferedImage Meteor3;
	public static BufferedImage Meteor4;
	public static BufferedImage Meteor5;
	public static BufferedImage SwordDialog;
	public static BufferedImage AxeDialog;
	public static BufferedImage MaceDialog;
	public static BufferedImage SickleDialog;
	public static BufferedImage FlameDialog;
	public static BufferedImage LightningDialog;
	public static BufferedImage StarDialog;
	public static BufferedImage TimeDialog;
	public static BufferedImage WrathDialog;
	
	public static BufferedImage WalkLeft;
	public static BufferedImage WalkRight;
	public static BufferedImage WalkRightSword;
	public static BufferedImage WalkLeftSword;
	public static BufferedImage WalkRightAxe;
	public static BufferedImage WalkLeftAxe;
	public static BufferedImage WalkRightMace;
	public static BufferedImage WalkLeftMace;
	public static BufferedImage WalkRightSickle;
	public static BufferedImage WalkLeftSickle;
	public static BufferedImage DuckRight;
	public static BufferedImage DuckLeft;
	public static BufferedImage DuckRightSword;
	public static BufferedImage DuckLeftSword;
	public static BufferedImage DuckRightAxe;
	public static BufferedImage DuckLeftAxe;
	public static BufferedImage DuckRightMace;
	public static BufferedImage DuckLeftMace;
	public static BufferedImage DuckRightSickle;
	public static BufferedImage DuckLeftSickle;
	public static BufferedImage UpRight;
	public static BufferedImage UpLeft;
	public static BufferedImage UpRightSword;
	public static BufferedImage UpLeftSword;
	public static BufferedImage UpRightAxe;
	public static BufferedImage UpLeftAxe;
	public static BufferedImage UpRightMace;
	public static BufferedImage UpLeftMace;
	public static BufferedImage UpRightSickle;
	public static BufferedImage UpLeftSickle;
	public static BufferedImage StillRight;
	public static BufferedImage StillLeft;
	public static BufferedImage StillRightSword;
	public static BufferedImage StillLeftSword;
	public static BufferedImage StillRightAxe;
	public static BufferedImage StillLeftAxe;
	public static BufferedImage StillRightMace;
	public static BufferedImage StillLeftMace;
	public static BufferedImage StillRightSickle;
	public static BufferedImage StillLeftSickle;
	public static BufferedImage JumpRight;
	public static BufferedImage JumpLeft;
	public static BufferedImage JumpRightSword;
	public static BufferedImage JumpLeftSword;
	public static BufferedImage JumpRightAxe;
	public static BufferedImage JumpLeftAxe;
	public static BufferedImage JumpRightMace;
	public static BufferedImage JumpLeftMace;
	public static BufferedImage JumpRightSickle;
	public static BufferedImage JumpLeftSickle;
	public static BufferedImage FightRight;
	public static BufferedImage FightLeft;
	public static BufferedImage SwipeRight;
	public static BufferedImage SwipeLeft;
	public static BufferedImage Swing;
	public static BufferedImage Pound;
	public static BufferedImage SwipeRightSickle;
	public static BufferedImage SwipeLeftSickle;
	public static BufferedImage ThrowRight;
	public static BufferedImage ThrowLeft;
	public static BufferedImage ThrowUpRight;
	public static BufferedImage ThrowUpLeft;
	
	public static BufferedImage BillStillRight;
	public static BufferedImage BillStillLeft;
	public static BufferedImage BillWalkingRight;
	public static BufferedImage BillWalkingLeft;
	public static BufferedImage BillDeathLeft;
	public static BufferedImage BillDeathRight;
	public static BufferedImage UFO;
	public static BufferedImage UFOdeath;
	public static BufferedImage Mini;
	public static BufferedImage Minideath;
	public static BufferedImage Minibolt;
	public static BufferedImage LSJStill;
	public static BufferedImage LSJJump;
	public static BufferedImage LSJDeath;
	public static BufferedImage BSJStill;
	public static BufferedImage BSJJump;
	public static BufferedImage BSJDeath;
	public static BufferedImage PSJStill;
	public static BufferedImage PSJJump;
	public static BufferedImage PSJDeath;
	public static BufferedImage NinjaStillLeft;
	public static BufferedImage NinjaStillRight;
	public static BufferedImage NinjaWalkLeft;
	public static BufferedImage NinjaWalkRight;
	public static BufferedImage NinjaDeathLeft;
	public static BufferedImage NinjaDeathRight;
	public static BufferedImage NinjaArmLeft;
	public static BufferedImage NinjaArmRight;
	public static BufferedImage Bat;
	public static BufferedImage BatDeath;
	public static BufferedImage BlackBat;
	public static BufferedImage BlackBatDeath;
	public static BufferedImage ShadeStillRight;
	public static BufferedImage ShadeStillLeft;
	public static BufferedImage ShadeWalkingRight;
	public static BufferedImage ShadeWalkingLeft;
	public static BufferedImage ShadeDeathRight;
	public static BufferedImage ShadeDeathLeft;
	public static BufferedImage GhoulLeft;
	public static BufferedImage GhoulRight;
	public static BufferedImage GhoulDeathLeft;
	public static BufferedImage GhoulDeathRight;
	
	public static BufferedImage GogaiRight;
	public static BufferedImage GogaiLeft;
	public static BufferedImage GGMoveRight;
	public static BufferedImage GGMoveLeft;
	public static BufferedImage GGDeathLeft;
	public static BufferedImage GGDeathRight;
	public static BufferedImage Weights;
	public static BufferedImage Arm;
	public static BufferedImage Skull;
	public static BufferedImage SkullHand;
	public static BufferedImage SkullDeath;
	public static BufferedImage SkullHandDeath;
	public static BufferedImage Magic;
	public static BufferedImage MasterOrb;
	public static BufferedImage OrbDeath;
	public static BufferedImage MOA1;
	public static BufferedImage MOA2;
	public static BufferedImage SJStill;
	public static BufferedImage SJJump;
	public static BufferedImage SJDeath;
	public static BufferedImage OmegaRight;
	public static BufferedImage OmegaLeft;
	public static BufferedImage ORDeath;
	public static BufferedImage OLDeath;
	public static BufferedImage OmegaLightning;
	public static BufferedImage OmegaFire;
	
	public void Loading(){
		try{
			Loading=ImageIO.read(new File("res/Backgrounds/Loading.ss.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	
	}
	
	public void WeatherImage(){
		try{
			RainOverlay=ImageIO.read(new File("res/Levels/Weather/RainOverlay.ss.png"));
			LavaOverlay=ImageIO.read(new File("res/Levels/Weather/LavaOverlay.ss.png"));
			TimeOverlay=ImageIO.read(new File("res/Levels/Weather/TimeOverlay.png"));
			Cloud1=ImageIO.read(new File("res/Levels/Weather/Cloud1.png"));
			Cloud2=ImageIO.read(new File("res/Levels/Weather/Cloud2.png"));
			Cloud3=ImageIO.read(new File("res/Levels/Weather/Cloud3.png"));
			BlackCloud=ImageIO.read(new File("res/Levels/Weather/BlackCloud.png"));
			BlackCloud2=ImageIO.read(new File("res/Levels/Weather/BC2.png"));
			BlackCloud3=ImageIO.read(new File("res/Levels/Weather/BC3.png"));
			Rain=ImageIO.read(new File("res/Levels/Weather/RainDrop.png"));
			Blood=ImageIO.read(new File("res/Levels/Weather/BloodDrop.png"));
			Leaf1=ImageIO.read(new File("res/Levels/Weather/Leaf1.png"));
			Leaf2=ImageIO.read(new File("res/Levels/Weather/Leaf2.png"));
			Explode=ImageIO.read(new File("res/Levels/Weather/Explosion.png"));
			Stars=ImageIO.read(new File("res/Levels/Weather/Falling Star.png"));
			Comp=ImageIO.read(new File("res/Levels/Weather/Computer.ss.png"));
			TV=ImageIO.read(new File("res/Levels/Weather/TV.ss.png"));
			Ash=ImageIO.read(new File("res/Levels/Weather/Ash.png"));
			Ember=ImageIO.read(new File("res/Levels/Weather/Ember.ss.png"));
			GameOver=ImageIO.read(new File("res/Backgrounds/GameOver.ss.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void ScreenImage(){
				
		try{
			logo=ImageIO.read(new File("res/Logo/title_logo.png"));
			play=ImageIO.read(new File("res/Buttons/PlayButtonNoScroll.png"));
			options=ImageIO.read(new File("res/Buttons/SettingsButtonNoScroll.png"));
			tryagain=ImageIO.read(new File("res/Buttons/TryAgain.png"));
			quit=ImageIO.read(new File("res/Buttons/QuitButtonNoScroll.png"));
			titleBG=ImageIO.read(new File("res/Backgrounds/Title.ss.png"));
			HealthBar=ImageIO.read(new File("res/PowerUps/Health.ss.png"));
			ItemBar=ImageIO.read(new File("res/PowerUps/Items.ss.png"));
			Current=ImageIO.read(new File("res/PowerUps/Current.ss.png"));
			Pause=ImageIO.read(new File("res/Backgrounds/Pause.png"));
			Controls=ImageIO.read(new File("res/PowerUps/Instructions.png"));
			Instructions=ImageIO.read(new File("res/PowerUps/Instructions.ss.png"));
			Cutscene=ImageIO.read(new File("res/PowerUps/Lvls.ss.png"));
			Level1=ImageIO.read(new File("res/Levels/Level1.png"));
			L1Para=ImageIO.read(new File("res/Levels/Level1Parallax.png"));
			BossBG1=ImageIO.read(new File("res/Levels/Boss1Background.png"));
			Level3=ImageIO.read(new File("res/Levels/Level3.png"));
			L3Para=ImageIO.read(new File("res/Levels/Level3Parallax.png"));
			BossBG3=ImageIO.read(new File("res/Levels/Boss3Background.png"));
			BossFG3=ImageIO.read(new File("res/Levels/Boss3Foreground.png"));
			Level4=ImageIO.read(new File("res/Levels/Level4.png"));
			L4Para=ImageIO.read(new File("res/Levels/Level4Parallax.png"));
			BossFG4=ImageIO.read(new File("res/Levels/Boss4Foreground.png"));
			Level6=ImageIO.read(new File("res/Levels/Level6.png"));
			BossBG6=ImageIO.read(new File("res/Levels/Boss6Background.png"));
			Level7=ImageIO.read(new File("res/Levels/Level7.png"));
			L7Para=ImageIO.read(new File("res/Levels/Level7Parallax.png"));
			BossBG7=ImageIO.read(new File("res/Levels/Boss7Background.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void EnvironmentImage(){
		try{
			floorStone=ImageIO.read(new File("res/Sprites/Tiles/StoneFloor.ss.png"));
			floorBrick=ImageIO.read(new File("res/Sprites/Tiles/BrickFloor.ss.png"));
			floorWood=ImageIO.read(new File("res/Sprites/Tiles/WoodFloor.ss.png"));
			floorRoad=ImageIO.read(new File("res/Sprites/Tiles/RoadFloor.ss.png"));
			floorPlain=ImageIO.read(new File("res/Sprites/Tiles/PlainFloor.ss.png"));
			woodBlock=ImageIO.read(new File("res/Sprites/Tiles/WoodBlock.png"));
			treeBlock=ImageIO.read(new File("res/Sprites/Tiles/TreeBLock.png"));
			dirtBlock=ImageIO.read(new File("res/Sprites/Tiles/DirtBlock.png"));
			dataBlock=ImageIO.read(new File("res/Sprites/Tiles/DataBlock.ss.png"));
			constructBlock=ImageIO.read(new File("res/Sprites/Tiles/Construction.ss.png"));
			floorLava=ImageIO.read(new File("res/Sprites/Tiles/LavaFloor.ss.png"));
			floorL6=ImageIO.read(new File("res/Sprites/Tiles/L6Floor.png"));
			floorSky=ImageIO.read(new File("res/Sprites/Tiles/SkyBlock.png"));
			DRed=ImageIO.read(new File("res/Sprites/Tiles/Damage2.ss.png"));
			DGreen=ImageIO.read(new File("res/Sprites/Tiles/Damage1.ss.png"));
			DBlue=ImageIO.read(new File("res/Sprites/Tiles/Damage3.ss.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void ItemImage(){
		try{
			Acetone=ImageIO.read(new File("res/PowerUps/Acetone.png"));
			Goal = ImageIO.read(new File("res/PowerUps/Portal.ss.png"));
			Sword=ImageIO.read(new File("res/PowerUps/Sword.png"));
			Axe=ImageIO.read(new File("res/PowerUps/Axe.png"));
			Mace=ImageIO.read(new File("res/PowerUps/Mace.png"));
			Sickle=ImageIO.read(new File("res/PowerUps/Sickle.png"));
			Flame=ImageIO.read(new File("res/PowerUps/Flame.png"));
			Lightning=ImageIO.read(new File("res/PowerUps/Lightning.png"));
			Star=ImageIO.read(new File("res/PowerUps/StarDestroyer.png"));
			Time=ImageIO.read(new File("res/PowerUps/Time.png"));
			Wrath=ImageIO.read(new File("res/PowerUps/Wrath.png"));
			Fireball=ImageIO.read(new File("res/PowerUps/Fireball.ss.png"));
			Bolt=ImageIO.read(new File("res/PowerUps/Bolt.ss.png"));
			Starball=ImageIO.read(new File("res/PowerUps/Star.ss.png"));
			Timebomb=ImageIO.read(new File("res/PowerUps/TimeBomb.ss.png"));
			Tails=ImageIO.read(new File("res/PowerUps/Tails.ss.png"));
			Meteor1=ImageIO.read(new File("res/PowerUps/Meteor1.png"));
			Meteor2=ImageIO.read(new File("res/PowerUps/Meteor2.png"));
			Meteor3=ImageIO.read(new File("res/PowerUps/Meteor3.png"));
			Meteor4=ImageIO.read(new File("res/PowerUps/Meteor4.png"));
			Meteor5=ImageIO.read(new File("res/PowerUps/Meteor5.png"));
			SwordDialog=ImageIO.read(new File("res/PowerUps/SwordDialog.png"));
			AxeDialog=ImageIO.read(new File("res/PowerUps/AxeDialog.png"));
			MaceDialog=ImageIO.read(new File("res/PowerUps/MaceDialog.png"));
			SickleDialog=ImageIO.read(new File("res/PowerUps/SickleDialog.png"));
			FlameDialog=ImageIO.read(new File("res/PowerUps/FlameDialog.png"));
			LightningDialog=ImageIO.read(new File("res/PowerUps/LightningDialog.png"));
			StarDialog=ImageIO.read(new File("res/PowerUps/StarDialog.png"));
			TimeDialog=ImageIO.read(new File("res/PowerUps/TimeDialog.png"));
			WrathDialog=ImageIO.read(new File("res/PowerUps/wrathDialog.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void PlayerImage(){
			
		try{
			WalkLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/WalkingLeft.ss.png"));
			WalkRight=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/WalkingRight.ss.png"));
			DuckRight=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/DuckRight.png"));
			DuckLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/DuckLeft.png"));
			UpRight=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/UpRight.png"));
			UpLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/UpLeft.png"));
			StillRight=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/Nock_Right.png"));
			StillLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/Nock_Left.png"));
			JumpRight=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/JumpRight.png"));
			JumpLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/JumpLeft.png"));
			WalkRightSword=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/WalkingRightSword.ss.png"));
			WalkLeftSword=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/WalkingLeftSword.ss.png"));
			DuckRightSword=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/DuckRightSword.png"));
			DuckLeftSword=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/DuckLeftSword.png"));
			UpRightSword=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/UpRightSword.png"));
			UpLeftSword=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/UpLeftSword.png"));
			StillRightSword=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/Nock_RightSword.png"));
			StillLeftSword=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/Nock_LeftSword.png"));
			JumpRightSword=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/JumpRightSword.png"));
			JumpLeftSword=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/JumpLeftSword.png"));
			WalkRightAxe=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/WalkingRightAxe.ss.png"));
			WalkLeftAxe=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/WalkingLeftAxe.ss.png"));
			DuckRightAxe=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/DuckRightAxe.png"));
			DuckLeftAxe=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/DuckLeftAxe.png"));
			UpRightAxe=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/UpRightAxe.png"));
			UpLeftAxe=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/UpLeftAxe.png"));
			StillRightAxe=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/Nock_RightAxe.png"));
			StillLeftAxe=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/Nock_LeftAxe.png"));
			JumpRightAxe=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/JumpRightAxe.png"));
			JumpLeftAxe=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/JumpLeftAxe.png"));
			WalkRightMace=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/WalkingRightMace.ss.png"));
			WalkLeftMace=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/WalkingLeftMace.ss.png"));
			DuckRightMace=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/DuckRightMace.png"));
			DuckLeftMace=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/DuckLeftMace.png"));
			UpRightMace=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/UpRightMace.png"));
			UpLeftMace=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/UpLeftMace.png"));
			StillRightMace=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/NockRightMace.png"));
			StillLeftMace=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/NockLeftMace.png"));
			JumpRightMace=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/JumpRightMace.png"));
			JumpLeftMace=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/JumpLeftMace.png"));
			WalkLeftSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/WalkingLeftSickle.ss.png"));
			WalkRightSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/WalkingRightSickle.ss.png"));
			DuckRightSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/DuckRightSickle.png"));
			DuckLeftSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/DuckLeftSickle.png"));
			UpRightSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/UpRightSickle.png"));
			UpLeftSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/UpLeftSickle.png"));
			StillRightSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/NockRightSickle.png"));
			StillLeftSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/NockLeftSickle.png"));
			JumpRightSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/JumpRightSickle.png"));
			JumpLeftSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/JumpLeftSickle.png"));
			FightRight=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/FightRight.ss.png"));
			FightLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/FightLeft.ss.png"));
			SwipeRight=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/SwipeRight.ss.png"));
			SwipeLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/SwipeLeft.ss.png"));
			Swing=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/Swing.ss.png"));
			Pound=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/Pound.ss.png"));
			SwipeRightSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/SwipeRightSickle.ss.png"));
			SwipeLeftSickle=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/SwipeLeftSickle.ss.png"));
			ThrowRight=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/ThrowRight.png"));
			ThrowLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/ThrowLeft.png"));
			ThrowUpRight=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/ThrowRight.png"));
			ThrowUpLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Nock/ThrowLeft.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
			
	public void BillImage(){
		
		try{
			BillStillRight=ImageIO.read(new File("res/Sprites/ActionSheets/Bill/Bill_Right.png"));
			BillStillLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Bill/Bill_Left.png"));
			BillWalkingRight=ImageIO.read(new File("res/Sprites/ActionSheets/Bill/BillWalkingRight.ss.png"));
			BillWalkingLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Bill/BillWalkingLeft.ss.png"));
			BillDeathLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Bill/DeathLeft.ss.png"));
			BillDeathRight=ImageIO.read(new File("res/Sprites/ActionSheets/Bill/DeathRight.ss.png"));
			UFO=ImageIO.read(new File("res/Sprites/ActionSheets/UFO/UFO.png"));
			UFOdeath=ImageIO.read(new File("res/Sprites/ActionSheets/UFO/UFOdeath.ss.png"));
			NinjaStillLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Ninja/NinjaLeft.png"));
			NinjaStillRight=ImageIO.read(new File("res/Sprites/ActionSheets/Ninja/NinjaRight.png"));
			NinjaWalkLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Ninja/NinjaWalkLeft.ss.png"));
			NinjaWalkRight=ImageIO.read(new File("res/Sprites/ActionSheets/Ninja/NinjaWalkRight.ss.png"));
			NinjaDeathLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Ninja/NinjaDeathLeft.ss.png"));
			NinjaDeathRight=ImageIO.read(new File("res/Sprites/ActionSheets/Ninja/NinjaDeathRight.ss.png"));
			NinjaArmLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Ninja/ArmLeft.png"));
			NinjaArmRight=ImageIO.read(new File("res/Sprites/ActionSheets/Ninja/ArmRight.png"));
			BlackBat=ImageIO.read(new File("res/Sprites/ActionSheets/Bat/BlackBat.ss.png"));
			BlackBatDeath=ImageIO.read(new File("res/Sprites/ActionSheets/Bat/BlackBatDeath.ss.png"));
			GhoulLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Ghoul/GhoulLeft.ss.png"));
			GhoulRight=ImageIO.read(new File("res/Sprites/ActionSheets/Ghoul/GhoulRight.ss.png"));
			GhoulDeathLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Ghoul/GhoulDeathLeft.ss.png"));
			GhoulDeathRight=ImageIO.read(new File("res/Sprites/ActionSheets/Ghoul/GhoulDeathRight.ss.png"));
			LSJStill=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/LimeStill.png"));
			LSJJump=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/LimeJumper.ss.png"));
			LSJDeath=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/LimeSJDeath.ss.png"));
			BSJStill=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/BlueStill.png"));
			BSJJump=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/BlueJumper.ss.png"));
			BSJDeath=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/BlueSJDeath.ss.png"));
			PSJStill=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/PinkStill.png"));
			PSJJump=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/PinkJumper.ss.png"));
			PSJDeath=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/PinkSJDeath.ss.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void BossImage(){
		
		try{
			GogaiRight=ImageIO.read(new File("res/Sprites/ActionSheets/Gogai/GogaiRight.png"));
			GogaiLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Gogai/GogaiLeft.png"));
			GGMoveRight=ImageIO.read(new File("res/Sprites/ActionSheets/Gogai/GogaiRideRight.ss.png"));
			GGMoveLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Gogai/GogaiRideLeft.ss.png"));
			GGDeathLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Gogai/GogaiDeathLeft.ss.png"));
			GGDeathRight=ImageIO.read(new File("res/Sprites/ActionSheets/Gogai/GogaiDeathRight.ss.png"));
			Weights=ImageIO.read(new File("res/Sprites/ActionSheets/Gogai/Weights.png"));
			Arm=ImageIO.read(new File("res/Sprites/ActionSheets/Gogai/Arm.png"));
			Skull=ImageIO.read(new File("res/Sprites/ActionSheets/Skull/Skull.ss.png"));
			SkullHand=ImageIO.read(new File("res/Sprites/ActionSheets/Skull/SkullHand.png"));
			SkullDeath=ImageIO.read(new File("res/Sprites/ActionSheets/Skull/SkullDeath.ss.png"));
			SkullHandDeath=ImageIO.read(new File("res/Sprites/ActionSheets/Skull/SkullHandDeath.ss.png"));
			Magic=ImageIO.read(new File("res/Sprites/ActionSheets/Skull/Magic.ss.png"));
			MasterOrb=ImageIO.read(new File("res/Sprites/ActionSheets/MasterOrb/Body.png"));
			OrbDeath=ImageIO.read(new File("res/Sprites/ActionSheets/MasterOrb/DeathOrb.ss.png"));
			MOA1=ImageIO.read(new File("res/Sprites/ActionSheets/MasterOrb/Appendage.png"));
			MOA2=ImageIO.read(new File("res/Sprites/ActionSheets/MasterOrb/Appendage2.png"));
			SJStill=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/Still.png"));
			SJJump=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/Jumper.ss.png"));
			SJDeath=ImageIO.read(new File("res/Sprites/ActionSheets/SamJohn/SJDeath.ss.png"));
			OmegaRight=ImageIO.read(new File("res/Sprites/ActionSheets/Omega/OmegaRight.ss.png"));
			OmegaLeft=ImageIO.read(new File("res/Sprites/ActionSheets/Omega/OmegaLeft.png"));
			ORDeath=ImageIO.read(new File("res/Sprites/ActionSheets/Omega/ORDeath.ss.png"));
			OLDeath=ImageIO.read(new File("res/Sprites/ActionSheets/Omega/OLDeath.ss.png"));
			OmegaLightning=ImageIO.read(new File("res/Sprites/ActionSheets/Omega/Firestarter.ss.png"));
			OmegaFire=ImageIO.read(new File("res/Sprites/ActionSheets/Omega/Lightning.ss.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static BufferedImage SpriteObj(BufferedImage image, int width, int height, int col, int row){
		return image.getSubimage((col*width) - width, (row*height)-height, width, height);
	}

}
