public class Konto
{
    String name;
    int betrag;
    
    public Konto(String kname, int kbetrag)
    {
        name = kname;
        betrag = kbetrag;
        ausgabe();
    }

    public void ausgabe()
    {
        System.out.println("Das Konto gehört "+name+" und der Kontostand beträgt "+betrag);
    }
        
    public static void main (String [] args)
    { 
        new Konto("Mair",1200);
    }
}