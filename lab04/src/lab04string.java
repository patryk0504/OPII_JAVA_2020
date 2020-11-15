/***
 * Implementacja metod do zadania z lab04.
 * Klasa implementuje metody pozwalajace operowac na ciagach znakow typu String.
 * @author Patryk Sledz
 */
public class lab04string {
    /**
     * Metoda statyczna zwracajaca dlugosc Stringa.
     * @param str wejsciowy ciag znakow String
     * @return dlugosc ciagu znakow
     */
    public static int dlugosc(String str){ return str.length(); }

    /**
     * Metoda statyczna zwracajaca ilosc wystapien danego znaku w ciagu znakow String.
     * @param str wejsciowy ciag znakow String
     * @param a wejsciowy znak char
     * @return ilosc wystapien
     */
    public static int ile_razy_literka_wystepuje(String str, char a) {
        int counter = 0;
        for (var x : str.toCharArray())
            if(x == a)
                counter++;
        return counter;
    }

    /**
     * Metoda statyczna sprawdzajaca czy dwa przekazane napisy sa identyczne.
     * @param str1 wejsciowy ciag znakow String
     * @param str2 wejsciowy ciag znakow String
     * @return wartosc boolean czy napisy identyczne
     */
    public static boolean czy_takie_same(String str1, String str2) { return str1.equals(str2); }

    /**
     * Metoda statyczna zwracajaca nowy napis String, ktory jest odwrotnoscia wejsciowego.
     * @param str wejsciowy ciag znakow String
     * @return  wyjsciowy ciag znakow String
     */
    public static String wspak(String str) {
        StringBuilder wspak = new StringBuilder();
        for(var v : str.toCharArray())
            wspak.insert(0,v);

        return wspak.toString();
    }

    /**
     * Metoda statyczna sprawdzajca czy napis String jest palindromem.
     * @param str wejsciowy ciag znakow String
     * @return wartosc boolean czy napis jest palindromem
     */
    public static boolean czy_plaindrom(String str) {
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != wspak(str).charAt(i))
                return false;
        }
        return true;
    }

    /**
     * Metoda statyczna sprawdzajaca czy napis String jest abecadlowy.
     * @param str wejsciowy ciag znakow String
     * @return wartosc boolean czy napis jest abecadlowy
     */
    public static boolean czy_abecadlowe(String str) {
        for(int i =0; i<str.length()-1; i++){
            if(str.charAt(i) > str.charAt(i+1))
                return false;
        }
        return true;
    }

    /**
     * Metoda statyczna sprawdzajaca czy dany znak jest litera.
     * @param v wejsciowy znak char
     * @return wartosc boolean czy znak jest litera
     */
    public static boolean isLetter(char v){ return v >= 65 && v <= 122; }

    /**
     * Metoda statyczna sprawdzajaca czy dany znak jest wielka litera.
     * @param v wejsciowy znak char
     * @return wartosc boolean
     */
    public static boolean isBigLetter(char v){ return (int) v >= 65 && (int) v <= 90; }

    /**
     * Metoda statyczna zwracajaca napis String, ktory jest wynikiem szyfrowania ROT13.
     * @param str wejsciowy ciag znakow String do zaszyfrowania
     * @return zaszyfrowany ciag znakow String
     */
    public static String rot13(String str) {
        StringBuilder rotted = new StringBuilder();

        for(var v : str.toCharArray()) {
            if(isLetter(v)){
                int tmp = v + 13;
                if (isBigLetter(v)) {//mamy wielką litere
                    if (tmp > 90) tmp = 65 + (tmp % 91);
                }else {//mamy mala litere
                    if (tmp > 122) tmp = 97 + (tmp % 123);
                }
                rotted.append((char)tmp);
            }else {
                rotted.append((char) v);
            }
        }
        return rotted.toString();
    }
}
