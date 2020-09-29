import java.util.*;

class ComputerPlayer{
    private String name;
    private ShipBoard shipBoard;
    private StrikeBoard strikeBoard;
    private RandomStrategy randomStrategy;

    public ComputerPlayer(){
        this.name = "HAL";
        shipBoard = new ShipBoard();
        strikeBoard = new StrikeBoard();
        randomStrategy = new RandomStrategy();
        shipBoard.enterAllShipsRandomly();
    }

    public int[] nextStrike(){

        return randomStrategy.nextStrike();
    }

    public void update(int pos[], boolean hit){
        strikeBoard.addStrike(pos, hit);
        randomStrategy.update(pos);
    }

    public boolean getStrike(int pos[]){
        return shipBoard.getStrike(pos);
    }

    public boolean allShipsSank(){
        return shipBoard.allShipsSank();
    }


    public String toString(){
        return name;
    }

    public void printStrikeBoard(){
        strikeBoard.print();
    }

    public void printShipBoard(){
        shipBoard.printBoard();
    }
}
