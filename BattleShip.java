import java.util.*;

class BattleShip{

    private static void HumanVsHuman(){
        HumanPlayer player1 = new HumanPlayer("Panagiotis");
        HumanPlayer player2 = new HumanPlayer("Maria");

        while(true){

            System.out.println(player1.toString() + " plays!!");
            player1.printStrikeBoard();
            int pos[] = player1.nextStrike();
            boolean result = player2.getStrike(pos);
            player1.update(pos, result);

            boolean isWinner = player2.allShipsSank();
            if(isWinner == true){
                System.out.println(player1.toString() + " is winner!!");
                return;
            }

            System.out.println(player2.toString() + " plays!!");
            player2.printStrikeBoard();
            pos = player2.nextStrike();
            result = player1.getStrike(pos);
            player2.update(pos, result);

            isWinner = player1.allShipsSank();
            if(isWinner == true){
                System.out.println(player2.toString() + " is winner!!");
                return;
            }
        }
    }

    private static void HumanVsComputer(){
        HumanPlayer player1 = new HumanPlayer("Panagiotis");
        ComputerPlayer player2 = new ComputerPlayer();

        while(true){

            System.out.println(player1.toString() + " plays!!");
           // player2.printShipBoard();
            player1.printStrikeBoard();
            int pos[] = player1.nextStrike();
            boolean result = player2.getStrike(pos);
            player1.update(pos, result);

            boolean isWinner = player2.allShipsSank();
            if(isWinner == true){
                System.out.println(player1.toString() + " is winner!!");
                return;
            }

            System.out.println(player2.toString() + " plays!!");
            player2.printStrikeBoard();
            pos = player2.nextStrike();
            result = player1.getStrike(pos);
            player2.update(pos, result);

            isWinner = player1.allShipsSank();
            if(isWinner == true){
                System.out.println(player2.toString() + " is winner!!");
                return;
            }
        }
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Computer(0) or human(1)> ");
        int choice = scanner.nextInt();
        if(choice == 0)
            HumanVsComputer();
        else
            HumanVsHuman();
    }
}
