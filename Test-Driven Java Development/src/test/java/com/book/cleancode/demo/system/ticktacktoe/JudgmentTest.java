package com.book.cleancode.demo.system.ticktacktoe;

public class JudgmentTest {
//
//    @BeforeAll
//    public void init(){
//        new Judgment(new Cell())
//    }
        public static void main(String[] args) {
            int[][] chessBoard =new int[10][10];
            for (int i = 0; i <chessBoard.length; i++) {
                for (int j = 0; j <chessBoard[0].length; j++) {
                    System.out.print("{"+i+","+j+"}"+" ");
                }
                System.out.println();
            }
        }
}
