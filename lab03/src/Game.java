public class Game {
    Board board;

    Game(int size_x, int size_y){ board = new Board(size_x,size_y); }

    //metoda sterujaca symulacja
    void simulation(int steps){
        String separator = "===";
        separator = separator.repeat((board.getSize_x()-2)/2);
        firstLook(separator);

        for(int i=0; i<steps; i++){
            board.checkStates();
            System.out.println(separator + " " + (i+1) + " " + separator);
            System.out.println(board);
        }
    }

    //wyswietlenie planszy startowej
    void firstLook(String separator){
        System.out.println(separator + " " + (0) + " " + separator);
        System.out.println(board);
    }

    //metoda uruchamiajaca symulacje z odpowiednimi parametrami
    void gameStart(int steps, int preset){
        switch (preset){
            case 0:
                board.fillBoardRandom();
                simulation(steps);
                break;
            case 1:
                board.boat();
                simulation(steps);
                break;
            case 2:
                board.blinker();
                simulation(steps);
                break;
            case 3:
                board.spaceship();
                simulation(steps);
                break;
            default:
                System.out.println("Wrong parameter (preset)");
                break;
        }
    }

}
