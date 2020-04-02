package com.book.cleancode.demo.system.ticktacktoe;

import com.book.cleancode.demo.exception.ChessRuntimeException;
import com.book.cleancode.demo.exception.OccupiedRuntimeException;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        randomTest();
    }

    public static void randomTest(){
        ChessSystem chessSystem = new ChessSystem(10, 10, 4);
        Random random = new Random();
        for (int i = 0; i < 1000; i++)
            try {
                int x = random.nextInt(10)+1;
                int y = random.nextInt(10)+1;
                chessSystem.checkIsCellOccupied(x-1, y-1);
                Thread.sleep(500);
                System.err.println("======================="+"轮到"+chessSystem.getCurrentPlayer()+"操作"+"=============================");
                Thread.sleep(500);
                String play = chessSystem.play(x,y);
                if (play.contains("wins")) {
                    break;
                }
            } catch (ChessRuntimeException e) {
                e.printStackTrace();
            } catch (OccupiedRuntimeException e) {

            } catch (Exception e) {
                e.printStackTrace();
            }


    }
}
