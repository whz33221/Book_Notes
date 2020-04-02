package com.book.cleancode.demo.system.ticktacktoe;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Data
public class Cell {
    public static Character none='-';
    private int x;
    private int y;
    private Character player;
    protected boolean isExisted;
    private boolean isWinCell;

    protected Cell() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Cell(int x, int y, Character player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<AroundCell> getAroundCells(ChessBoard chessBoard){
        List<AroundCell> cells = new LinkedList<>();
        cells.add(getLeftCell(chessBoard));
        cells.add(getRightCell(chessBoard));
        cells.add(getUpCell(chessBoard));
        cells.add(getDownCell(chessBoard));

        cells.add(getLeftUpCell(chessBoard));
        cells.add(getLeftDownCell(chessBoard));
        cells.add(getRightUpCell(chessBoard));
        cells.add(getRightDownCell(chessBoard));
        return cells;
    }

    private AroundCell getLeftCell(ChessBoard chessBoard) {
        return AroundCell.createAroundCell(x-1,y,chessBoard,AroundCellLocation.left);
    }
    private AroundCell getRightCell(ChessBoard chessBoard) {
        return AroundCell.createAroundCell(x+1,y,chessBoard,AroundCellLocation.right);
    }

    private AroundCell getUpCell(ChessBoard chessBoard) {
        return AroundCell.createAroundCell(x,y+1,chessBoard,AroundCellLocation.up);
    }

    private AroundCell getDownCell(ChessBoard chessBoard) {
        return AroundCell.createAroundCell(x,y-1,chessBoard,AroundCellLocation.down);

    }
    private AroundCell getLeftUpCell(ChessBoard chessBoard) {
        return AroundCell.createAroundCell(x-1,y+1,chessBoard,AroundCellLocation.leftUp);
    }
    private AroundCell getLeftDownCell(ChessBoard chessBoard) {
        return AroundCell.createAroundCell(x-1,y-1,chessBoard,AroundCellLocation.leftDown);
    }


    private AroundCell getRightUpCell(ChessBoard chessBoard) {
        return AroundCell.createAroundCell(x+1,y+1,chessBoard,AroundCellLocation.rightUp);
    }

    private AroundCell getRightDownCell(ChessBoard chessBoard) {
        return AroundCell.createAroundCell(x+1,y-1,chessBoard,AroundCellLocation.rightDown);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", player=" + player +
                ", isExisted=" + isExisted +
                ", isWinCell=" + isWinCell +
                '}';
    }
}
