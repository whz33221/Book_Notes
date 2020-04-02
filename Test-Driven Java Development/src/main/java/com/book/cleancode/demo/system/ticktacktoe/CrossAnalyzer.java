package com.book.cleancode.demo.system.ticktacktoe;

import java.util.LinkedList;
import java.util.Queue;

public class CrossAnalyzer extends WinningAnalyzer {

    @Override
    public boolean isWon() {
        Queue<Cell> checkWindow = new LinkedList<>();
        int datumX = datumCell.getX();
        int startX = datumX - (super.rule - 1);
        int endX = datumX + (super.rule + 1);
        int windowheadX = startX;
        int windowheadY = datumCell.getY();
        while (windowheadX <= endX) {
            boolean existed = chessBoard.isExisted(windowheadX, windowheadY);
            Cell windowheadCell = null;
            if(!existed){
                windowheadCell = AroundCell.notExistedCell();
            }else{
                windowheadCell = AroundCell.existedCell(windowheadX, windowheadY,chessBoard.getCellPlayerMark(windowheadX,windowheadY));
            }
            if (checkWindow.size() != rule) {
                checkWindow.offer(windowheadCell);
                windowheadX += 1;
                continue;
            } else {
                boolean success =  isWon(checkWindow);
                if(success){
                    resultGrow((LinkedList<Cell>) checkWindow);
                    saveResult(checkWindow);
                    return true;
                }
                if(!success){
                    checkWindow.poll();
                    checkWindow.offer(windowheadCell);
                    windowheadX += 1;
                }
            }
        }
        return false;
    }

    private void resultGrow(LinkedList<Cell> winResult) {
        growHead(winResult);
        growtail(winResult);
    }

    private void growtail(LinkedList<Cell> winResult) {
        Cell tail = winResult.getLast();
        int x = tail.getX()+1;
        int y = tail.getY();
        while(chessBoard.isExisted(x,y) && chessBoard.getCellPlayerMark(x,y)== tail.getPlayer()){
            winResult.addLast(AroundCell.existedCell(x,y,chessBoard.getCellPlayerMark(x,y)));
            x+=1;
        }
    }

    private void growHead(LinkedList<Cell> winResult) {
        Cell tail = winResult.getFirst();
        int x = tail.getX()-1;
        int y = tail.getY();
        while(chessBoard.isExisted(x,y) && chessBoard.getCellPlayerMark(x,y)== tail.getPlayer()){
            winResult.addFirst(AroundCell.existedCell(x,y,chessBoard.getCellPlayerMark(x,y)));
            x-=1;
        }
    }

}
