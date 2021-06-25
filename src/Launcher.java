/*=========================================
This is the launcher of the game.
It contains the main() method which is
call automatically as the game launches
===========================================
 */

import gamelogic.Game;

public class Launcher {

    public static void main(String[] args){
        Game game = new Game();
        game.start();
    }


}
