import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.*;

public class lab11 {
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Brak nazwy pliku jako parametr wywolania");
            exit(-1);
        }
        String filename = args[0];

        try (BufferedReader file = new BufferedReader(new FileReader(filename))){
            var params = file.readLine().split(" ");
            int numOfElements = Integer.parseInt( params[0] );
            int numOfTest = Integer.parseInt( params[1] );

            int [][] group1 = new int [numOfTest][numOfElements/2];
            int [][] group2 = new int [numOfTest][numOfElements/2];

            String line = "";
            int ind = 0;
            while((line = file.readLine()) != null){//pobranie danych z pliku
                var splLine = line.split(" ");
                for(int i=0; i<numOfElements; i++){
                    if(i<numOfElements/2){
                        group1[ind][i] = Integer.parseInt(splLine[i]);
                    }else {
                        group2[ind][i-numOfElements/2] = Integer.parseInt(splLine[i]);
                    }
                }
                ind++;
            }

            boolean isTested = true;//flaga czy wszystkie testy zostaly przeprowadzone

            //przeprowadzamy testy
            for(int i=1; i<=numOfElements; i++){//petla po kazdej liczbie ze zbioru [1, numOfElements]
                ind = 0;
                int [] testowane = new int [numOfElements];//bedziemy przechowywywac liczby ktore zostaly przetestowane z liczbą "i"
                for(int j=0; j<numOfTest; j++){
                    if(checkIfTabContains(i,group1[j])){//jesli testowana liczba znajduje sie w grupie 1 to nie znajduje się w grupie 2
                        for(var x : group2[j]){
                            if(!checkIfTabContains(x,testowane)){
                                testowane[ind] = x;//dopisujemy liczby ktore zostaly przetestowane przeciwko liczbie "i"
                                ind++;
                            }
                        }
                    }else{//jesli nie w grupie 1 to musi sie znajdowac w grupie 2
                        for(var x : group1[j]){
                            if(!checkIfTabContains(x,testowane)){
                                testowane[ind] = x;
                                ind++;
                            }
                        }
                    }
                }

                if(ind < numOfElements-1) {
                    isTested = false;
                    break;
                }
            }

            if(isTested)
                System.out.println("TAK");
            else
                System.out.println("NIE");

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static boolean checkIfTabContains(int elem, int [] tab){
        for (int x : tab)
            if (x == elem)
                return true;
        return false;
    }
}
