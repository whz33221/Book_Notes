package com.book.cleancode.demo.system.ticktacktoe;

import java.util.List;

public class Judgment {
    private final ChessSystem chessSystem;
    private List<Cell> lastWinCells;

    public Judgment(ChessSystem chessSystem) {
        this.chessSystem =chessSystem;
    }


    /**
     * 二维矩阵：移动窗口算法
     */
    public boolean judge() {
        WinningAnalyzerFactory analyzerFactory = new WinningAnalyzerFactoryBuilder()
                .setChessBoard(chessSystem.chessBoard)
                .setLastPlayCell(chessSystem.lastPlayCell)
                .setRule(chessSystem.rule).build();

        List<AroundCell> aroundCells = chessSystem.lastPlayCell.getAroundCells(chessSystem.chessBoard);
        for (AroundCell aroundCell : aroundCells) {
            if(!aroundCell.isExisted()){
                continue;
            }
            WinningAnalyzer analyzer = analyzerFactory.create(chessSystem.lastPlayCell, aroundCell,this);
            boolean win = analyzer.isWon();
            if(win){
              return true;
            }
        }
        return false;
    }

    public List<Cell> getLastWinCells() {

        return this.lastWinCells;
    }

    public void saveLastWinCells(List<Cell> cells) {
        this.lastWinCells = cells;

    }
}
