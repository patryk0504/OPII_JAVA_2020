import java.io.*;
import java.util.ArrayList;

public class lab08 {
    public static void main(String[] args) {
        try{
            if(args.length != 2)
                throw new IllegalNumberOfParametersException("Bledna ilosc parametrow wywolania programu!");
            String inputFile = args[0];
            String outputFile = args[1];

            ArrayList<Integer> arr = new ArrayList<>();

            try( BufferedReader file = new BufferedReader(new FileReader(inputFile)) ) {
                String elem = "";
                while((elem = file.readLine())!=null){
                    arr.add(Integer.parseInt(elem));
                }
                PrintWriter save = null;
                try {
                    if(arr.size() == 0)
                        throw new ArithmeticException("Dzielenie przez 0! Być może brak danych w pliku wejsciowym.");
                    save = new PrintWriter(new FileWriter(outputFile));
                    double res = 0.0;
                    for(var x : arr)
                        res += x;
                    res /= arr.size();
                    save.print(res);
                }catch(ArithmeticException e){
                    System.out.println(e.toString());
                }catch (IOException e){
                    System.out.println(e.toString());
                    System.out.println("Blad zapisu pliku wynikowego!");
                }finally {
                    if(save != null) save.close();
                }
            }catch (IOException e){
                System.out.println(e.toString());
                System.out.println("Blad wczytania pliku wejsciowego!");
            }catch (NumberFormatException e){
                System.out.println(e.toString());
                System.out.println("Plik wejsciowy zawiera znaki lub liczby, które nie są typem INT");
            }
        }catch (IllegalNumberOfParametersException e){
            System.out.println(e.toString());
        }
    }
}

class IllegalNumberOfParametersException extends IOException{
    IllegalNumberOfParametersException(String mess) {
        super(mess);
    }
}