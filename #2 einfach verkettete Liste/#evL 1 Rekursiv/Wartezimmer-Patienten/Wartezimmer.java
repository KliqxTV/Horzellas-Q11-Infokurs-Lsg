import java.util.Random;
import java.text.DecimalFormat;

public class Wartezimmer
{
    Patient erster;

    public Wartezimmer()
    {
        Random ran = new Random();
        
        Patient p1 = new Patient("Hansi", "AOK", ran.nextInt(90) + 2);
        Patient p2 = new Patient("Susi", "BOK", ran.nextInt(90) + 2);
        Patient p3 = new Patient("Konni", "Privat", ran.nextInt(90) + 2);
        Patient p4 = new Patient("Berti", "DOK", ran.nextInt(90) + 2);
        Patient p5 = new Patient("Marki", "Privat", ran.nextInt(90) + 2);
        Patient p6 = new Patient("Muksi", "FOK", ran.nextInt(90) + 2);

        erster = p1;
        p1.naechster = p2;
        p2.naechster = p3;
        p3.naechster = p4;
        p4.naechster = p5;
        p5.naechster = p6;
        
        System.out.println();
        alleausgeben();
    }

    public void alleausgeben()
    {
        System.out.println();
        erster.ausgabe();
    }

    public void anzahl()
    {
        System.out.println("Es sind " + erster.anzahl() + " Patienten im Wartezimmer");
        
        alleausgeben();
    }

    public void anzahlPrivatversicherte()
    {
        System.out.println("Es sind " + erster.anzahlPrivat() + " Patienten privat versichert.");
        
        alleausgeben();
    }

    public void gibtsDen(String suchName)
    {
        if (erster.gibts(suchName) == 0)
        {
            System.out.println(suchName + " nicht gefunden.");
        }
        else
        {
            System.out.println(suchName + " wartet.");
        }
        
        alleausgeben();
    }

    public void hintenanfuegen(String n, String k, int a)
    {
        erster.hintenanfuegen(new Patient(n, k, a));
        
        alleausgeben();
    }

    public void durchschnittsalter()
    {
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println(df.format(erster.gesamtalter() / erster.anzahl()) + " ist das Durchschnittsalter");
        
        alleausgeben();
    }
    
    public void letztenAusgeben()
    {
        System.out.println("Der letzte Patient heißt " + erster.letztenAusgeben() + ".");
        
        alleausgeben();
    }
    
    public void loeschen(String n)
    {
        erster.loeschen(n);
        
        alleausgeben();
    }
    
    public void einfuegenVor(String n, String k, int a, String such)
    {
        if (erster.gibts(such) == 0)
        {
            erster.hintenanfuegen(new Patient(n, k, a));
        }
        else
        {
            erster = erster.einfuegen(new Patient(n, k, a), erster, such);
        }
        
        alleausgeben();
    }
}