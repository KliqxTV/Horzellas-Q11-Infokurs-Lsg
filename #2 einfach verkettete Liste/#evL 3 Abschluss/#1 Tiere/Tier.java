public abstract class Tier
{
    String name;
    int alter;
    Tier naechster;

    public abstract void lautgeben();

    public abstract void pflegen();
    
    public int anzahltiere() {
        if (naechster == null) {
            return 1;
        }
        else {
            return (1 + naechster.anzahltiere());
        }
    }
 
    public void zaehletiere() {
        System.out.println("Es gibt " + anzahltiere() + " Tiere.");
    }
    
    public abstract void magfutter();
    
    public void ausgabe()
    {
        System.out.println(name + ", " + alter);
        
        if (naechster != null)
        {
            naechster.ausgabe();
        }
    }
    
    public int alter()
    {
        if (naechster != null)
        {
            return alter + naechster.alter();
        }
        else
        {
            return alter;
        }
    }
}
