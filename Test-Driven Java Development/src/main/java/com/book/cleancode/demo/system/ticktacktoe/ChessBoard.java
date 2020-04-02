package com.book.cleancode.demo.system.ticktacktoe;

public class ChessBoard {
    private Character[][] chessBoard;

    public ChessBoard(Character[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    public boolean checkIsCellOccupied(int x, int y) {
        if(chessBoard[x][y] != Cell.none){
            return true;
        }else{
            return false;
        }
    }
    public int getXLength(){
        return chessBoard.length;
    }

    public int getYLength(){
        return chessBoard[0].length;
    }

    public boolean isExisted(int x,int y){
        if(x<0 || x>=chessBoard.length || y<0 || y>=chessBoard[0].length){
            return  false;
        }
        return true;
    }

    public Character getCellPlayerMark(int x,int y){
        return chessBoard[x][y];
    }
    public void setCellPlayerMark(int x,int y,Character player){
        chessBoard[x][y] = player;
    }

}
