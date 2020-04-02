package com.book.cleancode.demo.system.ticktacktoe;

import java.util.*;

public abstract class WinningAnalyzer {


    protected Judgment judgment;
    protected Cell lastPlayCell;
    protected ChessBoard chessBoard;
    protected int rule;
    protected Cell datumCell;
    protected boolean hasWon;


    public abstract boolean isWon();

    protected boolean isWon(Queue<Cell> analyticCells) {
        for (Cell cell : analyticCells) {
            if(!cell.isExisted){
                return false;
            }
        }
        int count=0;
        for (Cell cell : analyticCells) {
            if(cell.getPlayer()== lastPlayCell.getPlayer()){
                count+=1;
            }
        }
        if(count!=rule){
            return false;
        }else{
            return true;
        }
    }


    protected void saveResult(Queue<Cell> lastWinCells){
        judgment.saveLastWinCells(new ArrayList<>(lastWinCells));
        this.hasWon = true;
    }
}
