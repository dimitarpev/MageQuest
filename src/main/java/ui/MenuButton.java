package ui;

import gamestates.Gamestate;

public class MenuButton {

    private int xPos, yPos, rowIndex;
    private Gamestate state;

    public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state){
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        //loadImgs
    }
}
