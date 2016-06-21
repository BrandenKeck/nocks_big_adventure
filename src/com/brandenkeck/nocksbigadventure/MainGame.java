package com.brandenkeck.nocksbigadventure;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class MainGame extends Canvas implements Runnable {

	private static Toolkit tk = Toolkit.getDefaultToolkit();
	public static int xSize = ((int) tk.getScreenSize().getWidth());
	public static int ySize = ((int) tk.getScreenSize().getHeight());
	public static double xScalingFactor = MainGame.xSize/1920;
	public static double yScalingFactor = MainGame.ySize/1080;
	public static int currentTickCount;
	
	private static MainGame main = new MainGame();
	private static ResourceManager resources = new ResourceManager();
	private static RenderingClass renderer = new RenderingClass();
	private static Menu menu = new Menu();
	private static Mouse mouse = new Mouse();
	private static Keys key;
	public static Environment en;
	private ScreenItems si;
	private SpriteHandler sh;
	public static Adder add;
	private Player player = new Player();
	public static StateClass state = StateClass.LOADING;
	public static StateClass prevState;
	public static StateClass nextState;
	
	private boolean running = false;
	private Thread thread;
	
	public MainGame(){
		Dimension size = new Dimension(xSize, ySize);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
	}
	
	public static MainGame getInstance(){
		return main;
	}
	public Menu getMenu(){
		return menu;
	}
	public SpriteHandler getSprites(){
		return sh;
	}
	public ScreenItems getScreenItems(){
		return si;
	}
	public Environment renderBackground(){
		return en;
	}
	
	public void loadProperties(Graphics g){
		Keys.lastKey = 3;
		resources.Loading();
		state = StateClass.LOADING;
		
		/*LS = ResourceManager.Loading;
		JWindow img1 = new JWindow();
		img1.getContentPane().add(new JLabel(new ImageIcon(resources.SpriteObj(LS, 1920, 1080, 3, 1))));
		img1.setBounds(0, 0, xSize, ySize);*/
		
		//img1.setVisible(true);
		resources.level1Image();
		resources.menuImage();
		
		menu = new Menu();
		sh = new SpriteHandler();
		si = new ScreenItems();
		en = new Environment();
		key = new Keys();
			
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		this.addKeyListener(key);
		
		for(int i=0; i<500; i++){
			Enemies.projR[i]=false;
		}
		
		//img1.setVisible(false);
		state = StateClass.MENU;
	}
	
	public void tick(int ticks){
		switch(state){
		case LOADING:
			break;
		case MENU:
			break;
		case CUTSCENE:
			break;
		case DIALOG:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		case GAME_OVER:
			break;
		default:
			player.tick();
			break;
		}
		
		currentTickCount = ticks;
	}
	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,xSize,ySize);
		renderer.RenderBackground(g);
		renderer.RenderForeground(g);
		
		if(state==StateClass.LOADING){
			loadProperties(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000/numTicks;
		double delta = 0.0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long currentTime = System.nanoTime();
			delta += (currentTime-lastTime)/n;
			lastTime = currentTime;
			
			if(player.warped){
			try {
				thread.sleep(50);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			
			render();
			frames++;
			
			if(delta >= 1){
				tick(ticks);
				ticks++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer > 1000){
				timer+=1000;
				//System.out.println(ticks + " Ticks, FPS: " + frames);
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	public static void main(String args[]){
		JFrame frame = new JFrame("Nock's Big Adventure");
		//Image cursor = tk.getImage(References.RESOURCE_LOCATION + "Cursed.png");
		//frame.setCursor(tk.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "cursor"));
		frame.add(main);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		main.start();	
	}
	
	public void start(){
		if(running){
			return;
		}
		else{
		running = true;
		}
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop(){
		if(!running)
			return;
		else
		running=false;
		try{
			thread.join();
		} catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
	}

}
