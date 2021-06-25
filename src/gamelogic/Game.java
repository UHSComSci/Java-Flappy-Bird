/*==========================================================
This is the class for the main game object for flappy bird.
All of the critical components are organized in this class.
============================================================
 */

package gamelogic;

import gfx.Assets;
import gfx.Display;
import io.KeyManager;
import io.KeyboardObject;
import ui.Popup;
import ui.UIManager;
import utils.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import entity.ObstacleManager;
import entity.Player;

public class Game {

    //graphics
    private Display display;

    //fps control
    private double timePerUpdate, delta;
    private long lastTime;

    //io
    private KeyManager keyManager;
    
    //game
    private Player player;
    private ObstacleManager om;
    private UIManager uim;
    private boolean isPaused;
    private Popup popup;


    /**Game method
     * The constructor of the Game object.
     * It initializes all the program variables
     */
    public Game(){
        keyManager = new KeyManager();
        Constants.init();
        display = new Display(Constants.title, Constants.width, Constants.height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        
        player = new Player(keyManager);
        keyManager.addKeyboardObject(player);
        uim = new UIManager();
        isPaused = false;
    }

    /**start method
     * The game will start after this method is called
     */
    public void start(){
    	popup = new Popup(this);
    	keyManager.addKeyboardObject(popup);
        om = new ObstacleManager(this, player);
        timePerUpdate = 1e9/Constants.fps;
        delta = 0;
        lastTime = System.nanoTime();
        run();
    }

    /**run method
     * This method contains the infinite loop
     * that keeps the game running
     */
    private void run(){
        while (true){
            if (timerCheck()){
                update();
                render();
            }
        }
    }

    /**render method
     * This procedural method is called once per frame to render
     * images onto screen.
     * Do no edit the graphical setting in the method
     */
    private void render(){
        BufferStrategy bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0,0,Constants.width,Constants.height); //clear the screen
        //Draw Below

        uim.render(graphics);
        player.render(graphics);
        om.render(graphics);
        popup.render(graphics);

        //End Drawing
        bufferStrategy.show();
        graphics.dispose();
    }

    /**update method
     * This procedural method is called once per frame to update
     * game data.
     */
    private void update(){
    	if(isPaused)
    		return;
    	uim.update();
    	player.update();
    	om.update();
    }

    /**timerCheck method
     * This functional method is used to to determine whether the
     * game should start rendering the next frame on the screen.
     *
     * @return whether to start rendering the next frame </type boolean>
     */
    private boolean timerCheck(){
        long now = System.nanoTime();
        delta += (now - lastTime)/timePerUpdate;
        lastTime = now;
        if (delta >= 1){
            delta --;
            return true;
        } else{
            return false;
        }
    }
    
    public void die() {
    	popup.setActive(true);
    	isPaused = true;
    }
    
    public void restart() {
    	isPaused = false;
    	player.resetPos();
        om = new ObstacleManager(this, player);
        uim = new UIManager();
    }

}
