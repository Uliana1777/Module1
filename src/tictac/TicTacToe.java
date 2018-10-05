package tictac;

import java.util.Scanner;

public class TicTacToe {
   private Scanner sc = new Scanner(System.in);
   private int[][] gameBoard = new int [3][3];
   private int X = 1, O = -1;
   private int currentPlayer = X;

    private void initGameBoard (){
        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard[i].length; j++){
                gameBoard [i][j] = 0;}}}

    private void drawGameBoard(){
        for (int i = 0; i<gameBoard.length; i++){
            for (int j=0; j< gameBoard[i].length; j++){
                switch (gameBoard[i][j]){
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case -1:
                        System.out.print("O");
                        break;
                }
                if(j < gameBoard.length - 1)
                    System.out.print("|");
            }
            System.out.println();
            if(i < gameBoard.length - 1)
                System.out.println("-----");

        }
    }

    private int winCheck (int  currentPlayer){
         if ((gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2] == currentPlayer *3  )
            || (gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2] == currentPlayer *3)
            || (gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2] == currentPlayer * 3)
            || (gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0] == currentPlayer * 3)
            || (gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1] == currentPlayer * 3)
            || (gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2] == currentPlayer * 3)
            || (gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2] == currentPlayer * 3)
            || (gameBoard[2][0] + gameBoard[1][1] + gameBoard[0][2] == currentPlayer * 3)){
         return (currentPlayer);}

         else
            return (0);
  }

  private void playerPut (){
        int numberOfMoves = 0;
        int winner;

        System.out.println("Играем? (ДА/НЕТ)");
        String answer = sc.next();

        while (answer.equals("ДА")){
            drawGameBoard();
            String playerType = currentPlayer == 1 ? "X":"O" ;
            System.out.printf(" Ход игрока %s \n", playerType);
            System.out.println("Выбери строку: ");
            int row = sc.nextInt();
            System.out.println("Выбери столбец: ");
            int col = sc.nextInt();
            numberOfMoves++;

            if ((row<0 || row>2)||(col<0 || col>2)){
             System.out.println("Такой позиции не существует!!!");
             numberOfMoves--;
             continue;}

            if (gameBoard[row][col] != 0){
             System.out.println("Занято!!!");
             numberOfMoves--;
             continue;}

       gameBoard[row][col] = currentPlayer;
       winner = winCheck(currentPlayer);
       if (winner != 0){
           System.out.printf("Победили %s\n",playerType);
           initGameBoard();
           System.out.println("Играем? (ДА/НЕТ)");
           answer = sc.next();
           numberOfMoves=0;
           currentPlayer = X;
       }
       if (numberOfMoves == 9){
           System.out.println(" Ничья");
           System.out.println("Играем? (ДА/НЕТ)");
           answer = sc.next();
           numberOfMoves=0;
           currentPlayer = X;
       }


       currentPlayer = -currentPlayer;

}
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initGameBoard();
        game.playerPut();
    }
}

