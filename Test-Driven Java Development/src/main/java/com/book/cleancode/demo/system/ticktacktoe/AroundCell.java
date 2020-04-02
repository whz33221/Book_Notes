package com.book.cleancode.demo.system.ticktacktoe;

import java.util.Objects;

public class AroundCell extends Cell {
    private int location;


    @Override
    public boolean equals(Object o) {
      return super.equals(o);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location);
    }

    public static AroundCell notExistedCell() {
        return new AroundCell(false);
    }
    private AroundCell(boolean isExisted) {
        super.isExisted = isExisted;
    }


    public static AroundCell existedCell(int x, int y, Character player) {
        return new AroundCell(x,y,player);
    }
    private AroundCell(int x, int y, Character player) {
        super(x, y, player);
        super.isExisted = true;
    }


    public static boolean isExisted(int x, int y, Character[][] chessBoard) {
        if(x<0 || x>=chessBoard.length || y<0 || y>=chessBoard[0].length){
            return   false;
        }
        return true;
    }

    public AroundCell setLocation(int location) {
        this.location = location;
        return this;
    }

    public boolean isParallelAroundCell(){
        if(AroundCellLocation.up == location||AroundCellLocation.down == location){
            return true;
        }
        return false;
    }
    public boolean isCrossAroundCell(){
        if(AroundCellLocation.right == location||AroundCellLocation.left == location){
            return true;
        }
        return false;
    }
    public boolean isDiagonalAroundCell(){
        if(AroundCellLocation.leftUp == location||AroundCellLocation.rightUp == location
        || AroundCellLocation.leftDown == location||AroundCellLocation.rightDown == location){
            return true;
        }
        return false;
    }

    public static AroundCell createAroundCell(int x,int y,ChessBoard chessBoard,int location){
        boolean isExisted =  chessBoard.isExisted(x,y);
        if(!isExisted){
            return AroundCell.notExistedCell();
        }
        return AroundCell.existedCell(x,y-1,chessBoard.getCellPlayerMark(x,y)).setLocation(location);
    }
}
