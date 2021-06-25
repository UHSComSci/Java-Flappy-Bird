/*=============================================================
This class is responsible for importing, decoding, and storing
graphical resources such as images. All imported resources
should be defined as a static class variable. No object should
be created from this class
===============================================================
 */

package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {

    //declare all graphical resource variables here
	public static BufferedImage tubeTop, tubeBottom;
	public static BufferedImage birdUp, birdDown;
	public static BufferedImage background;
	public static BufferedImage popup;


    public static void init(){
        //import and initialize all resources here
    	tubeTop = loadImage("/tube_top.png");
    	tubeBottom = loadImage("/tube_bottom.png");
    	birdUp = loadImage("/bird_up.png");
    	birdDown = loadImage("/bird_down.png");
    	background = loadImage("/bg.png");
    	popup = loadImage("/popup.png");
    }

    /**loadImage method
     * This functional method decodes the image file from the res folder by reading the
     * path of the image relative to the /res folder
     *
     * @param path - the file path used to locate the png image file used <type String>
     * @return - the decoded image from the given path. null if the ImageIO is unable
     *      to decode the file </type BufferedImage>
     */
    private static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(Assets.class.getResource(path));
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
