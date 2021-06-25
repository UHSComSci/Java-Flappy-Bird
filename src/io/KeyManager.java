/*=======================================================
The object created form this class receives and record
keyboard actions from the Display object. Do not edit
this class!
=========================================================
 */
package io;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyManager implements KeyListener {

    private boolean keyJustPressed[];
    private ArrayList<KeyboardObject> keyboardObjects;

    public KeyManager(){
        keyJustPressed = new boolean[256];
        keyboardObjects = new ArrayList<>();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for(KeyboardObject ko: keyboardObjects)
            ko.onKeyPressed(e);
        keyJustPressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyJustPressed[e.getKeyCode()] = false;
    }

    public boolean isKeyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= 256)
            return false;
        return keyJustPressed[keyCode];
    }

    public void addKeyboardObject(KeyboardObject ko){
        keyboardObjects.add(ko);
    }

}
