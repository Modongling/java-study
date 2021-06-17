package com.my.study.oop.array.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Play {
    private static final int BOARD_SIZE = 15;
    private String[][] board;
    public Play() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "+";
            }
        }
    }

    public void display() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Play play = new Play();
        play.display();
        //键盘输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        System.out.println("intput x, y:");
        while((input = br.readLine()) != null && !"z".equalsIgnoreCase(br.readLine())) {
            String[] pos = input.split(",");
            int xPos = Integer.parseInt(pos[0]);
            int yPos = Integer.parseInt(pos[1]);
            play.board[xPos - 1][yPos - 1] = "X";
            play.display();
        }
    }
}
