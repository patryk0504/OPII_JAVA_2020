interface Towar {
    void setName(String name);
    void setCena_zakupu(double cena);
    void setCena_sprzed(double cena);
    double getCena_zakupu();
    double getCena_sprzed();
    boolean nextDay();
}
