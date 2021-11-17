public abstract class Baumelement
{
    public abstract Datenelement suchen(String suchSchluessel);

    public abstract boolean istVorhanden(String suchSchluessel);

    public abstract Baumelement einfuegen(Datenelement dNeu);

    public abstract Datenelement getDaten();

    public abstract void setDaten(Datenelement dNeu);
    
    public abstract void inOrderAusgabe();
    
    public abstract void preOrderAusgabe();
    
    public abstract void postOrderAusgabe();
}