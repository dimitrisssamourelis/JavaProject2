import java.util.*;

class ShipBoard{
    private int shipSize[];
    private int remainingShipSize[];

    private int board[][];
    private boolean hitBoard[][];
    private boolean isSunk;

    public ShipBoard(){
        shipSize = new int[5];
        shipSize[0] = 5;
        shipSize[1] = 4;
        shipSize[2] = 3;
        shipSize[3] = 3;
        shipSize[4] = 2;

        remainingShipSize = new int[5];
        remainingShipSize[0] = 5;
        remainingShipSize[1] = 4;
        remainingShipSize[2] = 3;
        remainingShipSize[3] = 3;
        remainingShipSize[4] = 2;

        board = new int[10][10];

        hitBoard = new boolean[10][10];

        isSunk = false;
    }

    //gia test
    public ShipBoard(int test){
        shipSize = new int[5];
        shipSize[0] = 5;
        shipSize[1] = 4;
        shipSize[2] = 3;
        shipSize[3] = 3;
        shipSize[4] = 2;

        remainingShipSize = new int[5];
        remainingShipSize[0] = 0;
        remainingShipSize[1] = 0;
        remainingShipSize[2] = 0;
        remainingShipSize[3] = 0;
        remainingShipSize[4] = 2;

        board = new int[10][10];

        hitBoard = new boolean[10][10];

        board[0][0] = 5;
        board[0][1] = 5;


        isSunk = false;
    }

    private void enterShipManually(int id){

        Scanner scanner = new Scanner(System.in);
        while(true){

            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            int x = -1;
            int y = -1;
            int direction = -1;

            do{

                System.out.println("Give start pos:");
                System.out.print("x= ");
                x = scanner.nextInt();
                System.out.print("y= ");
                y = scanner.nextInt();
            }while(x<0 || x>9 || y<0 || y>9);

            do{
                System.out.println("Give direction(0,1):");
                System.out.print("direction= ");
                direction = scanner.nextInt();
            }while(direction < 0 || direction > 1);


            if(direction == 0){
                boolean canEnter = true;
                for(int i=x;i<x+shipSize[id-1];i++){
                    if(i>9){
                        canEnter = false;
                        break;
                    }
                    else{
                        if(board[i][y] != 0){
                            canEnter = false;
                            break;
                        }
                    }
                }
                if(canEnter == true){
                    for(int i=x;i<x+shipSize[id-1];i++){
                        board[i][y] = id;
                    }
                    return;
                }
            }
            else{
                boolean canEnter = true;
                for(int i=y;i<y+shipSize[id-1];i++){
                    if(i>9){
                        canEnter = false;
                        break;
                    }
                    else{
                        if(board[x][i] != 0){
                            canEnter = false;
                            break;
                        }
                    }
                }
                if(canEnter == true){
                    for(int i=y;i<y+shipSize[id-1];i++){
                        board[x][i] = id;
                    }
                    return;
                }
            }
        }
    }

    public void enterAllShipsManually(){
        for(int i=0;i<5;i++){
            enterShipManually(i+1);
        }


    }
    public void enterAllShipsRandomly(){
        for(int i=0;i<5;i++){
            enterShipRandomly(i+1);
        }
    }
    private void enterShipRandomly(int id){
        Random random = new Random();



        while(true){

            int direction = random.nextInt(2);

            int x = -1;
            int y = -1;

            if(direction == 0){
                x = random.nextInt(11-shipSize[id-1]);
                y = random.nextInt(10);
            }
            else{
                x = random.nextInt(10);
                y = random.nextInt(11-shipSize[id-1]);
            }


            if(direction == 0){
                boolean canEnter = true;
                for(int i=x;i<x+shipSize[id-1];i++){
                    if(i>9){
                        canEnter = false;
                        break;
                    }
                    else{
                        if(board[i][y] != 0){
                            canEnter = false;
                            break;
                        }
                    }
                }
                if(canEnter == true){
                    for(int i=x;i<x+shipSize[id-1];i++){
                        board[i][y] = id;
                    }
                    return;
                }
            }
            else{
                boolean canEnter = true;
                for(int i=y;i<y+shipSize[id-1];i++){
                    if(i>9){
                        canEnter = false;
                        break;
                    }
                    else{
                        if(board[x][i] != 0){
                            canEnter = false;
                            break;
                        }
                    }
                }
                if(canEnter == true){
                    for(int i=y;i<y+shipSize[id-1];i++){
                        board[x][i] = id;
                    }
                    return;
                }
            }
        }
    }
    public boolean getStrike(int pos[]){
        int x = pos[0];
        int y = pos[1];

        isSunk = false;

        if(hitBoard[x][y] == false){
            hitBoard[x][y] = true;
            if(board[x][y] != 0){
                int id = board[x][y]-1;
                remainingShipSize[id]--;
                if(remainingShipSize[id] == 0){
                    isSunk = true;
                    System.out.println("Ship with id "+id+ " sunk!!!");
                }
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public boolean allShipsSank(){
        for(int i=0;i<5;i++){
            if(remainingShipSize[i] != 0){
                return false;
            }
        }

        return true;
    }

    public boolean lastStrikeSankShip(){
        return isSunk;
    }

    public void print(){
        System.out.print("  ");
        for(int i=0;i<10;i++){
            System.out.print(i+"  ");
        }
        for(int i=0;i<10;i++){
            System.out.print(i+":");
            for(int j=0;j<10;j++){
                if(hitBoard[i][j] == false){
                    System.out.print("-- ");
                }
                else{
                    if(board[i][j] == 0){
                        System.out.print("X ");
                    }
                    else{
                        System.out.print("O ");
                    }
                }
            }
            System.out.println();
        }
    }
    public void printBoard(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        ShipBoard shipBoard = new ShipBoard();

        shipBoard.enterAllShipsManually();


        ShipBoard shipBoard1 = new ShipBoard(1);//gia na elegxw thn getStrike

        int pos[] = new int[2];

        pos[0]=0;
        pos[1]=0;

        System.out.println("Perimenw true: 0,0 "+shipBoard1.getStrike(pos));

        System.out.println("allShipsSank(Perimenw false): "+shipBoard1.allShipsSank());

        pos[0]=0;
        pos[1]=0;
        System.out.println("Perimenw false(exw xtyphsei): 0,0 "+shipBoard1.getStrike(pos));
        pos[0]=1;
        pos[1]=0;
        System.out.println("Perimenw false(den exei kati): 1,0 "+shipBoard1.getStrike(pos));
        pos[0]=0;
        pos[1]=1;
        System.out.println("Perimenw true: 0,1 "+shipBoard1.getStrike(pos));

        System.out.println("lastStrikeSankShip(Perimenw true): "+shipBoard1.lastStrikeSankShip());

        System.out.println("allShipsSank(Perimenw true): "+shipBoard1.allShipsSank());

        ShipBoard shipBoard2 = new ShipBoard();
        shipBoard2.enterAllShipsRandomly();
        shipBoard2.printBoard();

    }
}
