import java.util.Scanner;

public class Shop {
    Towar [] tab = new Towar[10];//max 10 towarow
    int count = 0;
    int data = 0;
    private double portfel = 0;
    Scanner s = new Scanner(System.in);

    /**
     * Funkcja informacyjna 1
     * Wypisuje pierwsze menu programu
     */
    void info1(){
        System.out.println("\n1) Dodaj towar\n" +
                "2) Sprzedaj towar\n" +
                "3) Kolejny dzień\n" +
                "4) Bilans\n" +
                "X) Koniec programu\n");
    }
    /**
     * Funkcja informacyjna 2
     * Wypisuje drugie menu programu
     */
    void info2(){
        System.out.println("\n1) dodaj owoc\n" +
                "2) dodaj warzywo\n" +
                "3) dodaj drobne agd\n");
    }
    /**
     * Funkcja informacyjna 3 - ustawia odpowiednie parametry towaru
     * @param obj obiekt na ktorym maja byc przeprowadzone przeksztalcenia
     */
    void info3(Towar obj){
        System.out.println("\npodaj nazwę:");
        obj.setName(s.next());
        System.out.println("podaj cenę zakupu:");
        obj.setCena_zakupu(Double.parseDouble(s.next()));
        System.out.println("podaj cenę sprzedaży:");
        obj.setCena_sprzed(Double.parseDouble(s.next()));
    }
    /**
     * Funkcja pozwala usunac dowolny element z tablicy towarow (zalozenie - podajemy poprawny indeks)
     * @param index indeks obiektu do usuniecia
     * @return zwracana jest nowa tablica
     */
    Towar [] removeElement(int index){
        Towar [] newTab = new Towar[10];
        for(int i = 0, k = 0; i < tab.length; i++){
            if(i == index){
                tab[i] = null;
                continue;
            }
            newTab[k++] = tab[i];
        }
        count--;
        return newTab;
    }
    /**
     * Funkcja dodajaca produkt
     */
    void optionAdd(){
        info2();
        int option = s.nextInt();
        switch (option){
            case 1:
                tab[count] = new Owoce();
                info3(tab[count]);
                count++;
                break;
            case 2:
                tab[count] = new Warzywa();
                info3(tab[count]);
                count++;
                break;
            case 3:
                tab[count] = new Agd();
                info3(tab[count]);
                count++;
                break;
        }
    }
    /**
     * Funkcja sprzedajaca produkt
     */
    void optionSell(){
        if(count == 0) {
            System.out.println("\nBrak towarow");
            return;
        }
        for(int i=0; i<count; i++)
            System.out.println((i+1) + ") " +tab[i].toString());

        System.out.println("Co chcesz sprzedać?");
        int option = s.nextInt();
        if(option-1 < count){
            option = option - 1;
            portfel += tab[option].getCena_sprzed() - tab[option].getCena_zakupu();
            tab = removeElement(option);
        }
    }
    /**
     * Funkcja zmieniajaca date
     */
    void optionNextDay(){
        data++;
        int [] indexRemove = new int[10];
        int k = 0;
        for(int i=0; i<count; i++){
            if(!tab[i].nextDay()){
                portfel -= tab[i].getCena_zakupu();
                indexRemove[0] = i;
                k++;
            }
        }
        for(int i=0; i<k; i++)
            tab = removeElement(indexRemove[i]);
    }
    /**
     * Glowna funkcja programu, wywoluje wszystkie inne potrzebne funkcje
     */
    void menu(){
        info1();
        String input = s.next();
        while(!input.equals("X") && !input.equals("x")){
            int option = Integer.parseInt(input);
            switch (option){
                case 1://dodaj
                    optionAdd();
                    break;
                case 2://sprzedaj
                    optionSell();
                    break;
                case 3://kolejny dzien
                    optionNextDay();
                    break;
                case 4://bilans
                    System.out.println("\nStan konta: " + portfel);
                    break;
                default:
                    System.out.println("Bledny parametr!");
                    break;
            }
            info1();
            input = s.next();
        }
        System.out.println("\nZamykam...");
    }
}
