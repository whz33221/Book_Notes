package com.book.cleancode.demo.system.ticktacktoe;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WinningAnalyzerFactoryBuilder {
    private final WinningAnalyzerFactory factory;

    public WinningAnalyzerFactoryBuilder() {
        this.factory = new WinningAnalyzerFactory();
    }

    public WinningAnalyzerFactory build(){

        return this.factory;
    }




    public WinningAnalyzerFactoryBuilder setLastPlayCell(Cell lastPlayCell) {
        this.factory.setLastPlayCell(lastPlayCell);
        return this;
    }

    public WinningAnalyzerFactoryBuilder setChessBoard(ChessBoard chessBoard) {
        this.factory.setChessBoard(chessBoard);
        return this;
    }

    public WinningAnalyzerFactoryBuilder setRule(int rule) {
        this.factory.setRule(rule);
        return this;
    }


}
