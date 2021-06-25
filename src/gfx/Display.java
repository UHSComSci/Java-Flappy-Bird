/*==========================================================================
A critical graphic component, responsible for the game window
A Display object stores the JFrame and the Canvas which are responsible
for rendering images
============================================================================
 */

package gfx;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    /**Display method
     * The constructor method of the Display class
     * It sets the dimension of the window, packs in a canvas
     * object to render onto, and performs some other critical
     * procedures for displaying a window on the screen.
     *
     * @param width - The width of the JFrame </type int>
     * @param height - The height of the JFrame </type int>
     */
    public Display(String title, int width, int height){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

}
