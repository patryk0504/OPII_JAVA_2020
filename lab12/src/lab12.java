import java.io.*;
import java.util.TreeMap;

import static java.lang.System.exit;

public class lab12 {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Zbyt mała ilość argumentów wywolania: " + args.length);
            exit(-1);
        }
        Dictionary myDiction = new Dictionary();
        switch (args[0]){
            case "add":
                if(args[1]!=null && args[2]!=null)
                    myDiction.add(args[1],args[2]);
                break;
            case "del":
                if(args[1]!=null)
                    myDiction.delete(args[1]);
                break;
            default:
                myDiction.translate(args[0]);
                break;
        }
    }
}

class Dictionary{
    File file;
    Dictionary(){
        file = new File("dic.txt");
        try{
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    TreeMap<String,String> readMapFromFile(){
        TreeMap<String,String> map = new TreeMap<String, String>();
        String line="";
        try(BufferedReader dicFile = new BufferedReader(new FileReader(file.getName()))){
            //wczytujemy mape z pliku
            while((line=dicFile.readLine())!=null){
                String [] tmp = line.split(";");
                if(tmp.length >=2){
                    map.put(tmp[0],tmp[1]);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return map;
    }

    void saveMapToFile(TreeMap<String, String> map){
        try{
            //zapis nowej mapy
            FileOutputStream fileoutstream=new FileOutputStream(file);
            PrintWriter writeFile = new PrintWriter(fileoutstream);
            for(var m : map.entrySet()){
                writeFile.println(m.getKey()+";"+m.getValue());
            }
            writeFile.flush();
            writeFile.close();
            fileoutstream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //zalozenie ze slowo w1 jednoznacznie odpowiada slowu w2
    void add(String w1, String w2){
        var map = readMapFromFile();
            //zapis nowej mapy
        if(!map.containsKey(w1) && !map.containsValue(w1)){
            if(!map.containsKey(w2) && !map.containsValue(w2)){
                map.put(w1,w2);
                saveMapToFile(map);
            }else{
                System.out.println("Słowo " + w2 + " jest już w słowniku.");
            }
//            saveMapToFile(map);
        }else{
            System.out.println("Słowo " + w1 + " jest już w słowniku.");
        }
    }

    public void delete(String w1) {
        var map = readMapFromFile();
        if(map.remove(w1) == null){
            map.values().remove(w1);
        }
        saveMapToFile(map);
    }

    public void translate(String w1) {
        var map = readMapFromFile();
        if(map.containsKey(w1)){
            System.out.println(map.get(w1));
        }else if(map.containsValue(w1)){
            for(var x : map.entrySet()){
                if(x.getValue().equals(w1))
                    System.out.println(x.getKey());
            }
        }else{
            System.out.println("Brak słowa " + w1);
        }
    }
}
