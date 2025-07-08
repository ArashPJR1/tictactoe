package org.example;

// TODO: Beispieländerung für PR-Test

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        System.out.println("Willkommen zu Tic-Tac-Toe!");

        while (true) {
            game.printBoard();
            System.out.println("Spieler " + game.getCurrentPlayer() + ", gib deine Zeile (0-2): ");
            int row = scanner.nextInt();
            System.out.println("Spieler " + game.getCurrentPlayer() + ", gib deine Spalte (0-2): ");
            int col = scanner.nextInt();

            if (!game.makeMove(row, col)) {
                System.out.println("Ungültiger Zug, versuch es erneut!");
                continue;
            }

            if (game.checkWin()) {
                game.printBoard();
                System.out.println("Spieler " + game.getCurrentPlayer() + " hat gewonnen!");
                break;
            }

            if (game.isBoardFull()) {
                game.printBoard();
                System.out.println("Unentschieden!");
                break;
            }

            game.switchPlayer();
        }

        scanner.close();
    }
}
