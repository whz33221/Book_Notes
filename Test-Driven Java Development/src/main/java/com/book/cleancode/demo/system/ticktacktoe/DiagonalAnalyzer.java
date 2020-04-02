package com.book.cleancode.demo.system.ticktacktoe;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalAnalyzer extends WinningAnalyzer {

    @Override
    public boolean isWon() {
        if(forwarDiagonalAnalyze(datumCell)){
            return true;
        }else{
           return backDiagonalAnalyze(datumCell);
        }
    }


    private boolean forwarDiagonalAnalyze(Cell datumCell) {
        Queue<Cell> checkWindow = new LinkedList<>();
        int datumX = datumCell.getX();
        int datumY = datumCell.getY();


        int startX =datumX-(rule-1);
        int startY =datumY-(rule-1);

        int endX = datumX+(rule+1);
        int endY = datumY+(rule+1);

        int windowheadX = startX;
        int windowheadY = startY;




        while(windowheadX<=endX){
            boolean existed = chessBoard.isExisted(windowheadX, windowheadY);
            Cell windowheadCell = null;
            if(!existed){
                windowheadCell = AroundCell.notExistedCell();
            }else{
                windowheadCell = AroundCell.existedCell(windowheadX, windowheadY,chessBoard.getCellPlayerMark(windowheadX,windowheadY));
            }
            if(checkWindow.size()!=rule){
                checkWindow.offer(windowheadCell);
                windowheadX+=1;
                windowheadY+=1;
                continue;
            }else{
                boolean success =  isWon(checkWindow);
                if(success){
                    forwardResultGrow((LinkedList<Cell>) checkWindow);
                    saveResult(checkWindow);
                    return true;
                }
                if(!success){
                    checkWindow.poll();
                    checkWindow.offer(windowheadCell);
                    windowheadX+=1;
                    windowheadY+=1;
                }
            }
        }
        return false;
    }

    private boolean backDiagonalAnalyze(Cell datumCell) {
        Queue<Cell> checkWindow = new LinkedList<>();
        int datumX = datumCell.getX();
        int datumY = datumCell.getY();


        int startX =datumX-(rule-1);
        int startY =datumY+(rule-1);

        int endX = datumX+(rule+1);
        int endY = datumY-(rule+1);

        int windowheadX = startX;
        int windowheadY = startY;

        while(windowheadX<=endX){
            boolean existed = chessBoard.isExisted(windowheadX, windowheadY);
            Cell windowheadCell = null;
            if(!existed){
                windowheadCell = AroundCell.notExistedCell();
            }else{
                windowheadCell = AroundCell.existedCell(windowheadX, windowheadY,chessBoard.getCellPlayerMark(windowheadX,windowheadY));
            }
            if(checkWindow.size()!=rule){
                checkWindow.offer(windowheadCell);
                windowheadX+=1;
                windowheadY-=1;
                continue;
            }else{
                boolean success =  isWon(checkWindow);
                if(success){
                    backResultGrow((LinkedList<Cell>) checkWindow);
                    saveResult(checkWindow);
                    return true;
                }
                if(!success){
                    checkWindow.poll();
                    checkWindow.offer(windowheadCell);
                    windowheadX+=1;
                    windowheadY-=1;
                }
            }
        }
        return false;
    }

    private void forwardResultGrow(LinkedList<Cell> winResult) {
        forwardGrowHead(winResult);
        forwardGrowtail(winResult);
    }
    private void backResultGrow(LinkedList<Cell> winResult) {
        backGrowHead(winResult);
        backGrowtail(winResult);
    }
    private void forwardGrowtail(LinkedList<Cell> winResult) {
        Cell tail = winResult.getLast();
        int x = tail.getX()+1;
        int y = tail.getY()+1;
        while(chessBoard.isExisted(x,y) && chessBoard.getCellPlayerMark(x,y)== tail.getPlayer()){
            winResult.addLast(AroundCell.existedCell(x,y,chessBoard.getCellPlayerMark(x,y)));
            x+=1;
            y+=1;
        }
    }

    private void forwardGrowHead(LinkedList<Cell> winResult) {
        Cell tail = winResult.getFirst();
        int x = tail.getX()-1;
        int y = tail.getY()-1;
        while(chessBoard.isExisted(x,y) && chessBoard.getCellPlayerMark(x,y)== tail.getPlayer()){
            winResult.addFirst(AroundCell.existedCell(x,y,chessBoard.getCellPlayerMark(x,y)));
            x-=1;
            y-=1;
        }
    }

    private void backGrowtail(LinkedList<Cell> winResult) {
        Cell tail = winResult.getLast();
        int x = tail.getX()+1;
        int y = tail.getY()-1;
        while(chessBoard.isExisted(x,y) && chessBoard.getCellPlayerMark(x,y)== tail.getPlayer()){
            winResult.addLast(AroundCell.existedCell(x,y,chessBoard.getCellPlayerMark(x,y)));
            x+=1;
            y-=1;
        }
    }

    private void backGrowHead(LinkedList<Cell> winResult) {
        Cell head = winResult.getFirst();
        int x = head.getX()-1;
        int y = head.getY()+1;
        while(chessBoard.isExisted(x,y) && chessBoard.getCellPlayerMark(x,y)== head.getPlayer()){
            winResult.addFirst(AroundCell.existedCell(x,y,chessBoard.getCellPlayerMark(x,y)));
            x-=1;
            y+=1;
        }
    }
}
