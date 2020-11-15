import java.util.Random;

public class Board {
    private final int size_x, size_y;
    private int [][] board;
    Random r = new Random();

    Board(int size_x, int size_y){
        this.size_x = size_x;
        this.size_y = size_y;
        board = new int [this.size_x+2][this.size_y+2];
    }

    private int srodek_x(){ return (size_x)/2; }
    private int srodek_y(){ return (size_y)/2; }
    public int getSize_x() { return size_x; }

    /////////////////// Presets ///////////////////////
    void fillBoardRandom(){
        for(int i=1; i<size_x-1; i++){//pomijamy sztuczne krawedzie, one są domyślnie = 0
            for(int j=1; j<size_y-1; j++)
                board[i][j] =  r.nextInt(2);
        }
    }

    void blinker(){
        board[srodek_x()-1][srodek_y()] = 1;
        board[srodek_x()][srodek_y()] =1;
        board[srodek_x()+1][srodek_y()] =1 ;
    }

    void spaceship(){
        board[srodek_x()+1][srodek_y()] = 1;
        board[srodek_x()-1][srodek_y()] = 1;
        board[srodek_x()][srodek_y()-1] = 1;
        board[srodek_x()-1][srodek_y()-1] = 1;
        board[srodek_x()-1][srodek_y()+1] = 1;
    }

    void boat(){
        board[srodek_x()+1][srodek_y()] = 1;
        board[srodek_x()-1][srodek_y()] = 1;
        board[srodek_x()][srodek_y()-1] = 1;
        board[srodek_x()-1][srodek_y()-1] = 1;
        board[srodek_x()][srodek_y()+1] = 1;
    }
///////////////////////////////////////////////////////

    //metoda sprawdza kazdy punkt i generuje nowa zaktualizowana plansze
    void checkStates(){
        int [][] nextBoard = new int [size_x+2][size_y+2];

        for(int i=1; i<size_x-1;i++) {
            for (int j = 1; j < size_y-1; j++) {
                //zasady gry
                int state = board[i][j];
                int neighbours = sumNeighbours(board, i, j);
                if (state == 0 && neighbours == 3)
                    nextBoard[i][j] = 1;
                else if (state == 1 && (neighbours < 2 || neighbours > 3))
                    nextBoard[i][j] = 0;
                else
                    nextBoard[i][j] = board[i][j];
            }
        }
        board = nextBoard;
    }

    //metoda pomocniczna - sprawdza ile jest zywych sasiadow punktu (x,y)
    private int sumNeighbours(int [][] tab, int x, int y){
        int counter = 0;
        for(int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++)
                counter += tab[x + i][y + j];
        }
        counter -= tab[x][y];//pomijamy element srodkowy (x,y)
        return counter;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=1; i<size_x-1;i++){
            for(int j=1; j<size_y-1; j++){
                if(board[i][j] == 0)
                    result = result.concat("  .");
                else
                    result = result.concat("  X");
            }
            result = result.concat("\n");
        }
        return result;
    }
}
