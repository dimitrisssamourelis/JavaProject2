class StrikeBoard{
    private int board[][];

    public StrikeBoard(){
        board = new int[10][10];
    }

    public void addStrike(int pos[], boolean hit){
        int x = pos[0];
        int y = pos[1];


        if(hit == true){
            board[x][y] = 1;
        }
        else{
            board[x][y] = -1;
        }
    }

     public void print(){
        System.out.print("   ");
        for(int i=0;i<10;i++){
            System.out.print(i+"  ");
        }
        System.out.println();
        for(int i=0;i<10;i++){
            System.out.print(i+":");
            for(int j=0;j<10;j++){
                if(board[i][j] == -1)
                    System.out.print(" "+board[i][j]);
                else
                    System.out.print("  "+board[i][j]);
            }
            System.out.println();
        }
    }
}
