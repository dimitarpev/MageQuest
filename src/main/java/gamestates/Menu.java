package gamestates;

import entities.Manaball;
import main.Game;
import ui.MenuButton;
import utilz.Constants;
import utilz.Constants.UI.Buttons.*;
import utilz.LoadSave;
import static utilz.Constants.UI.Buttons.*;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Menu extends State implements Statemethods{

    private MenuButton[] buttons = new MenuButton[2];
    public Menu(Game game) {

        super(game);
        loadButtons();
    }

    private void loadButtons() {
        buttons[0] = new MenuButton( 1920/ 2,(int) (150 * Game.SCALE), 0, Gamestate.PLAYING);
//        buttons[1] = new MenuButton(1920/ 2,(int) (220 * Game.SCALE), 1, Gamestate.OPTIONS);
        buttons[1] = new MenuButton(1920/ 2,(int) (220 * Game.SCALE) , 2, Gamestate.QUIT);
    }

    @Override
    public void update() {
        for(MenuButton mb : buttons)
            mb.update();
    }

    @Override
    public void render(Graphics g) {
        for(MenuButton mb : buttons)
            mb.render(g);
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(MenuButton mb: buttons){
            if (isIn(e,mb)){
                mb.setMousePressed(true);
                break;
            }
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        for(MenuButton mb: buttons){
            if (isIn(e,mb)){
                if(mb.isMousePressed())
                    mb.applyGameState();
                break;
            }
        }
        resetButtons();
    }
    private void resetButtons() {
        for(MenuButton mb: buttons){
            mb.resetBools();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(MenuButton mb: buttons){
            mb.setMouseOver(false);
        }
        for(MenuButton mb: buttons){
            if (isIn(e, mb)){
                mb.setMouseOver(true);
                break;
            }
        }

    }
}
