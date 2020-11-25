public class Owoce implements Towar{
    String name;
    double cena_zakupu = 0;
    double cena_sprzed = 0;
    int currTermin = 1;

    public void setName(String name){this.name = name;}
    public void setCena_zakupu(double cena) { this.cena_zakupu = cena; }
    public void setCena_sprzed(double cena) { this.cena_sprzed = cena; }
    public double getCena_zakupu() { return cena_zakupu; }
    public double getCena_sprzed() { return cena_sprzed;}
    public boolean nextDay() {
        currTermin--;
        return currTermin > 0;
    }
    @Override public String toString() { return "Nazwa: " + name + " cena zakupu: " + cena_zakupu + " cena sprzedazy: " + cena_sprzed; }

}
