public abstract class Zugteil
{
    public int laenge;
    public int leergewicht;
    public Zugteil naechster;
    
    public abstract void ausgabe();
    
    public int leergewicht()
    {
        if (naechster != null)
        {
            return leergewicht + naechster.leergewicht();
        }
        else
        {
            return leergewicht;
        }
    }
    
    public abstract int sitzplaetze();
    
    public abstract int gesamtladung();
}