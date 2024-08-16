public class Nqueen {
    public static void main(String[] args) {
        int n=8;
        boolean board[][]=new boolean[n][n];

        System.out.println(nqueen(board,0));

    }
    public static int nqueen(boolean[][] board,int row){
        if(row== board.length){

            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        for (int col = 0; col< board.length ; col++) {
            //place the queen if it is safe
            if(isSafe(board,row,col)){
                board[row][col]=true;
                count+=nqueen(board,row+1);
                board[row][col]=false;

            }

        }
        return count;

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check verticle row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }


        }
        //gor left diagonal of perticular element
        int minleft = Math.min(row, col);

        for (int i = 0; i < minleft; i++) {
            if (board[row - 1][col - 1]) {
                return false;
            }

        }
        //for right diagonal
        int minright = Math.min(row, board.length - col - 1);

        for (int i = 0; i < minright; i++) {
            if (board[row - 1][col + 1]) {
                return false;

            }
        }
        return true;
    }


    private static void display(boolean[][] board) {
        for (boolean[] row:board) {
            for (boolean element:row){
                if(element){
                    System.out.print("Q ");
                }else {
                    System.out.print("x ");
                }


        }
            System.out.println();
    }


}
}
