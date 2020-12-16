import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;

public class lab09 {
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Podano " + args.length + " parametrow wejsciowych, potrzeba 1");
            exit(-1);
        }
        String filename = args[0];
        try(BufferedReader file = new BufferedReader(new FileReader(filename))){
            int numOfRows = Integer.parseInt(file.readLine());
            Rectangle [] rect = new Rectangle[numOfRows+1];
            int minX = 0;
            int maxX = 0;
            int minY = 0;
            int maxY = 0;
            for(int i=0; i<numOfRows; i++){
                String [] line = file.readLine().split(" ");
                int x1 = Integer.parseInt(line[0]);
                int y1 = Integer.parseInt(line[1]);
                int x2 = Integer.parseInt(line[2]);
                int y2 = Integer.parseInt(line[3]);
                //zapisujemy prostokaty
                rect[i] = new Rectangle(x1,y1,x2,y2);

                //szukamy wymiarow calego ogrodu
                int temp = Math.max(x1,x2);
                maxX = Math.max(temp, maxX);

                temp = Math.min(x1,x2);
                minX = Math.min(temp,minX);

                temp = Math.max(y1,y2);
                maxY = Math.max(temp, maxY);

                temp = Math.min(y1,y2);
                minY = Math.min(temp, minY);
            }
            //tworzymy tabele ogrodu wypelniona zerami
            int [][] garden = new int [maxX - minX + 1][maxY - minY + 1];

            //bedziemy sprawdzac ile razy kazdy punk ogrodu zawiera sie w prostokatach
            for(int k=0; k<numOfRows; k++){
                for(int i=0; i<garden.length; i++){
                    for(int j=0; j<garden[i].length; j++){
                        if(rect[k].checkIfInside(i,j))
                            garden[i][j]++;
                    }
                }
            }
            int counter=0;
            //sprawdzamy czy dany punkt ogrodu ma wartosc < 2
            for(var row : garden){
                for(var cell : row){
                    if(cell < 2)
                        counter++;
                }
            }
            //ilosc kwadratow do przekopania
            System.out.println(counter);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

//klasa przechowywujaca wspolrzedne prostokata
class Rectangle{
    int x1,x2, y1,y2;
    Rectangle(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    boolean checkIfInside(int i, int j){
        return (i >= x1 && j >= y1 && i <= x2 && j <= y2);
    }
}