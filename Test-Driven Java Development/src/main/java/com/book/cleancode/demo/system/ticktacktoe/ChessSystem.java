package com.book.cleancode.demo.system.ticktacktoe;

import com.book.cleancode.demo.exception.ChessRuntimeException;
import com.book.cleancode.demo.exception.OccupiedRuntimeException;

import java.util.List;

public class ChessSystem {
    protected final Judgment judgment;
    protected ChessBoard chessBoard;
    protected int rule;
    protected Cell lastPlayCell;
    protected Character currentPlayer;

    public ChessSystem(int xMax, int yMax,int rule){
        if( xMax<0 || yMax<0){
            throw new IllegalArgumentException();
        }
        this.rule = rule;
        this.currentPlayer = Player.one;
        this.chessBoard = new ChessBoard(new Character[xMax][yMax]);
        this.judgment = new Judgment(this);
        clearAll();
    }


    public void clearAll() {
        initChessBoard();
        printChessBoard();
    }

    public void initChessBoard(){
        for (int i = chessBoard.getXLength()-1; i >=0 ; i--) {
            for (int j = 0; j <chessBoard.getYLength(); j++) {
                chessBoard.setCellPlayerMark(i,j,Cell.none);
            }
        }
    }
    public void printChessBoard(){
        for (int i = 0; i <chessBoard.getXLength(); i++) {
            for (int j = 0; j <chessBoard.getYLength(); j++) {
                System.out.print(chessBoard.getCellPlayerMark(i,j)+" ");
            }
            System.out.println();
        }
    }




    private void printChessBoardWithWinCells(List<Cell> cells) {
        for (int i = 0; i <chessBoard.getXLength(); i++) {
            for (int j = 0; j <chessBoard.getYLength(); j++) {
                boolean contains = cells.contains(new Cell(i, j));
                if(contains){
                    if(lastPlayCell.getPlayer()==Player.one){
                        System.out.print("A ");
                    }else{
                        System.out.print("B ");
                    }
                }else{
                    System.out.print(chessBoard.getCellPlayerMark(i,j)+" ");
                }
            }
            System.out.println();
        }
    }

    public String play(int x, int y) {
        x-=1;
        y-=1;
        checkX(x);
        checkY(y);
        checkIsCellOccupied(x,y);
        setPiece(x,y);
        markLastPlayer(x,y,this.currentPlayer);
        changePlayer();
        if(judgment.judge()){
            List<Cell> cells = judgment.getLastWinCells();
            printChessBoardWithWinCells(cells);
            System.err.println("======================="+(char)(lastPlayCell.getPlayer()-32)+" wins!"+"=============================");
//            System.out.println(cells);
            initChessBoard();
            return lastPlayCell.getPlayer()+" wins!";
        }else{
            printChessBoard();
        }
//        System.out.println("No winner");
        return "No winner";
    }




    private void markLastPlayer(int x, int y,Character currentPlayer) {
        lastPlayCell = new Cell(x,y,currentPlayer);
    }


    private void checkX(int x) {
        if(x>=chessBoard.getXLength()||x<0){
            throw new ChessRuntimeException("The cell doesn't existed! x("+x+") is over of range");
        }
    }

    private void checkY(int y) {
        if(y>=chessBoard.getYLength()||y<0){
            throw new ChessRuntimeException("The cell doesn't existed! y("+y+")is over of range");
        }
    }

    public void checkIsCellOccupied(int x, int y) {
        if(chessBoard.getCellPlayerMark(x,y) != Cell.none){
            throw new OccupiedRuntimeException("Cell is occupied!");
        }
    }

    private void setPiece(int x, int y) {
        chessBoard.setCellPlayerMark(x,y,currentPlayer);
    }

    private void changePlayer() {
        currentPlayer = currentPlayer.equals(Player.one)? Player.two:Player.one;
    }

    public Character getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Character currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public Character peekCellPlayer(int x, int y) {
        return chessBoard.getCellPlayerMark(x-1,y-1);
    }

    public Character getLastPlayer() {
        return lastPlayCell.getPlayer();
    }
}
