package com.book.cleancode.demo.system.ticktacktoe;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WinningAnalyzerFactory {
    private ChessBoard chessBoard;
    private Cell lastPlayCell;
    private int rule;
    
    public WinningAnalyzer create(Cell datumCell, AroundCell aroundCell, Judgment judgment){
        WinningAnalyzer analyzer = createAnalyzerInstance(aroundCell);
        transferData(datumCell,analyzer,judgment);
        return analyzer;
    }

    private WinningAnalyzer createAnalyzerInstance(AroundCell aroundCell) {
        if(aroundCell.isCrossAroundCell()){
         return new CrossAnalyzer();
        }else if(aroundCell.isParallelAroundCell()){
            return new ParallelAnalyzer();
        }else if(aroundCell.isDiagonalAroundCell()){
            return new DiagonalAnalyzer();
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void transferData(Cell datumCell, WinningAnalyzer winningAnalyzer, Judgment judgment){
        winningAnalyzer.chessBoard  = this.chessBoard;
        winningAnalyzer.lastPlayCell = this.lastPlayCell;
        winningAnalyzer.rule = this.rule;
        winningAnalyzer.datumCell = datumCell;
        winningAnalyzer.judgment = judgment;
    }
}
