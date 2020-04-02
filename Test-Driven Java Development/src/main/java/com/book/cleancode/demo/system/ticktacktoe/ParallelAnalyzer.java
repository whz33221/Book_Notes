package com.book.cleancode.demo.system.ticktacktoe;

import java.util.LinkedList;
import java.util.Queue;

public class ParallelAnalyzer extends WinningAnalyzer {




    @Override
    public boolean isWon() {
        Queue<Cell> checkWindow = new LinkedList<>();
        int datumY = datumCell.getY();
        int startY = datumY - (rule - 1);
        int endY = datumY + (rule - 1);
        int windowheadY = startY;
        int windowheadX = datumCell.getX();

        while (windowheadY <= endY) {
            boolean existed = chessBoard.isExisted(windowheadX, windowheadY);
            Cell windowheadCell = null;
            if(!existed){
                windowheadCell = AroundCell.notExistedCell();
            }else{
                windowheadCell = AroundCell.existedCell(windowheadX, windowheadY,chessBoard.getCellPlayerMark(windowheadX,windowheadY));
            }


            if (checkWindow.size() != rule) {
                checkWindow.offer(windowheadCell);
                windowheadY += 1;
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
                    windowheadY += 1;
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
        int x = tail.getX();
        int y = tail.getY()+1;
        while(chessBoard.isExisted(x,y) && chessBoard.getCellPlayerMark(x,y)== tail.getPlayer()){
            winResult.addLast(AroundCell.existedCell(x,y,chessBoard.getCellPlayerMark(x,y)));
            y+=1;
        }
    }

    private void growHead(LinkedList<Cell> winResult) {
        Cell tail = winResult.getFirst();
        int x = tail.getX();
        int y = tail.getY()-1;
        while(chessBoard.isExisted(x,y) && chessBoard.getCellPlayerMark(x,y)== tail.getPlayer()){
            winResult.addFirst(AroundCell.existedCell(x,y,chessBoard.getCellPlayerMark(x,y)));
            y-=1;
        }
    }
}
