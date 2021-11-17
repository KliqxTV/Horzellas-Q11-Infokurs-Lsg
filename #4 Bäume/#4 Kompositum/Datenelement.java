interface Datenelement
{
    public void informationAusgeben();

    public boolean istKleinerAls(Datenelement dVergleich);

    public boolean istGroesserAls(Datenelement dVergleich);

    public boolean istGleich(Datenelement dVergleich);

    public boolean schluesselIstKleinerAls(String sVergleich);

    public boolean schluesselIstGroesserAls(String sVergleich);

    public boolean schluesselIstGleich(String sVergleich);
}