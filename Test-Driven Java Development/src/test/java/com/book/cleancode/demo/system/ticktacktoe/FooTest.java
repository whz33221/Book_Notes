package com.book.cleancode.demo.system.ticktacktoe;



import com.book.cleancode.demo.exception.ChessRuntimeException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(classes = CleanCodeDemoApplication.class)
public class FooTest {

    private static ChessSystem chessSystem;

    @BeforeAll
    public static void createchessBoard(){
        chessSystem = new ChessSystem(10, 10,3);
    }



    @BeforeEach
    public void clearchessBoard() {
        chessSystem.clearAll();
        chessSystem.setCurrentPlayer(Player.one);
    }


    /**
     * 需求一：可将棋子放在3X3棋盘上任何没有棋子的地方
     */
    @Test
    public void whenBeyondXAxialThenThrowRuntimeException(){
        assertThrows(ChessRuntimeException.class,()-> chessSystem.play(4,3));
    }

    @Test
    public void whenBeyondYAxialThenThrowRuntimeException(){
        assertThrows(ChessRuntimeException.class,()-> chessSystem.play(3,4));
    }
    @Test
    public void whenXIsMinusThenThrowRuntimeException(){
        assertThrows(ChessRuntimeException.class,()-> chessSystem.play(-3,3));
    }

    @Test
    public void whenYIsMinusThenThrowRuntimeException(){
        assertThrows(ChessRuntimeException.class,()-> chessSystem.play(3,-3));
    }
    @Test
    public void whenPieceExistedThenThrowRuntimeException(){
        chessSystem.play(3,3);
        assertThrows(ChessRuntimeException.class,()-> chessSystem.play(3,3));
    }

    @Test
    public void GivenAPlayFirstwhenTheNextPlayerIsA_AgainThenThrowRuntimeException(){
        chessSystem.play(1,1);
        assertNotEquals(Player.one, chessSystem.getCurrentPlayer());
    }

    @Test
    public void GivenPlay3TimewhenPlayerSwitchBetweenAandBThenSuccess(){
        assertEquals(Player.one, chessSystem.getCurrentPlayer());
        chessSystem.play(1,1);
        assertEquals(Player.two, chessSystem.getCurrentPlayer());
        chessSystem.play(2,2);
        assertEquals(Player.one, chessSystem.getCurrentPlayer());
        chessSystem.play(3,3);
        assertEquals(Player.two, chessSystem.getCurrentPlayer());
    }

    @Test
    public void GivenPlay3TimewhenThePieceFlagIsEqualPlayerNameThenSuccess(){
        Character currentPlayer = chessSystem.getCurrentPlayer();
        chessSystem.play(1,1);
        assertEquals(currentPlayer, chessSystem.peekCellPlayer(1, 1));
        currentPlayer = chessSystem.getCurrentPlayer();
        chessSystem.play(2,2);
        assertEquals(currentPlayer, chessSystem.peekCellPlayer(2, 2));
        currentPlayer = chessSystem.getCurrentPlayer();
        chessSystem.play(3,3);
        assertEquals(currentPlayer, chessSystem.peekCellPlayer(3, 3));
    }

    @Test
    public void whenPlayThenNoWiner(){
        assertEquals("No winner", chessSystem.play(1,2));
    }

    @Test
    public void whenCrosswise3ThenWin(){
        chessSystem.play(1,1);
        chessSystem.play(2,2);

        chessSystem.play(2,1);
        chessSystem.play(3,3);

        String WIN = chessSystem.play(3, 1);
        assertEquals(chessSystem.getLastPlayer()+" wins!",WIN);
    }

    @Test
    public void whenParallelwise3ThenWin(){
        chessSystem.play(1,1);
        chessSystem.play(2,2);

        chessSystem.play(1,2);
        chessSystem.play(3,3);

        String WIN = chessSystem.play(1, 3);
        assertEquals(chessSystem.getLastPlayer()+" wins!",WIN);
    }
    @Test
    public void whenDiagonalLineThenHasWiner(){
        chessSystem.play(1,1);
        chessSystem.play(1,2);

        chessSystem.play(2,2);
        chessSystem.play(1,3);

        String WIN = chessSystem.play(3, 3);
        assertEquals(chessSystem.getLastPlayer()+" wins!",WIN);

        chessSystem.play(1,3);
        chessSystem.play(1,1);

        chessSystem.play(2,2);
        chessSystem.play(1,2);

        WIN = chessSystem.play(3, 1);
        assertEquals(chessSystem.getLastPlayer()+" wins!",WIN);

    }


    @Test
    public void whenCrossWise5AndDoGrowThenWin(){
        chessSystem.play(1,1);
        chessSystem.play(2,2);

        chessSystem.play(1,4);
        chessSystem.play(3,7);

        chessSystem.play(1,5);
        chessSystem.play(3,8);

        chessSystem.play(1, 2);
        chessSystem.play(4, 4);
        String WIN = chessSystem.play(1, 3);
        assertEquals(chessSystem.getLastPlayer()+" wins!",WIN);
    }

    @Test
    public void whenForwordWise5AndDoGrowThenWin(){
        chessSystem.play(1,1);
        chessSystem.play(2,1);

        chessSystem.play(2,2);
        chessSystem.play(3,7);

        chessSystem.play(4,4);
        chessSystem.play(3,8);

        chessSystem.play(5, 5);
        chessSystem.play(3, 6);
        String WIN = chessSystem.play(3, 3);
        assertEquals(chessSystem.getLastPlayer()+" wins!",WIN);
    }

    @Test
    public void whenBackWise5AndDoGrowThenWin(){
        chessSystem.play(1,5);
        chessSystem.play(2,5);

        chessSystem.play(2,4);
        chessSystem.play(3,7);

        chessSystem.play(4,2);
        chessSystem.play(3,8);

        chessSystem.play(5, 1);
        chessSystem.play(3, 6);
        String WIN = chessSystem.play(3, 3);
        assertEquals(chessSystem.getLastPlayer()+" wins!",WIN);
    }




    @Test
    public void whenParallelwise5AndDoGrowThenWin(){

        chessSystem.play(1,1);
        chessSystem.play(2,2);

        chessSystem.play(4,1);
        chessSystem.play(3,7);

        chessSystem.play(5,1);
        chessSystem.play(3,8);

        chessSystem.play(2, 1);
        chessSystem.play(4, 4);
        String WIN = chessSystem.play(3, 1);
        assertEquals(chessSystem.getLastPlayer()+" wins!",WIN);
    }




}
