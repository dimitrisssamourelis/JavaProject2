import java.util.*;

class HumanPlayer{
    private String name;
    private ShipBoard shipBoard;
    private StrikeBoard strikeBoard;

    public HumanPlayer(String name){
        this.name = name;
        shipBoard = new ShipBoard();
        strikeBoard = new StrikeBoard();

        shipBoard.enterAllShipsManually();
    }

    public int[] nextStrike(){
        Scanner scanner = new Scanner(System.in);
        int x = 0, y =0;

        do{

            System.out.println("Give pos:");
            System.out.print("x= ");
            x = scanner.nextInt();
            System.out.print("y= ");
            y = scanner.nextInt();
        }while(x<0 || x>9 || y<0 || y>9);

        int pos[] = new int[2];

        pos[0] = x;
        pos[1] = y;

        return pos;
    }

    public void update(int pos[], boolean hit){
        strikeBoard.addStrike(pos, hit);
    }

    public boolean getStrike(int pos[]){
        return shipBoard.getStrike(pos);
    }

    public boolean allShipsSank(){
        return shipBoard.allShipsSank();
    }

    public boolean lastStrikeSankShip(){
        return shipBoard.lastStrikeSankShip();
    }

    public String toString(){
        return name;
    }

    public void printStrikeBoard(){
        strikeBoard.print();
    }
}
