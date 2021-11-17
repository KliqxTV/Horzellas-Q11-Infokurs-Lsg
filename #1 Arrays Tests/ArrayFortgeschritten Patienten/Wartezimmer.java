import java.util.Random;
import java.text.DecimalFormat;

public class Wartezimmer
{
    int anzahl;
    Patient[] p = new Patient[20];

    public Wartezimmer()
    {
        start();
    }

    public void anzahlGeben(boolean neu)
    {
        if (neu == true)
        {
            System.out.println(anzahl + " Patienten warten jetzt.");
        }
        else
        {
            System.out.println(anzahl + " Patienten warten.");
        }
    }

    public void anzahlPrivatversicherte()
    {
        int anz = 0;

        for (int i = 0; i < anzahl; i++)
        {
            if (p[i].krankenkasse == "Privat")
            {
                anz++;
            }
        }

        System.out.println(anz + " Patienten sind privat versichert.");
    }

    public void start()
    {
        Random ran = new Random();

        p[0] = new Patient("Häusler", ran.nextInt(80), "BARMER");
        p[1] = new Patient("Wechsler", ran.nextInt(80), "Privat");
        p[2] = new Patient("Holzknecht", ran.nextInt(80), "DAK");
        p[3] = new Patient("Schenk", ran.nextInt(80), "hkk");
        p[4] = new Patient("Adler", ran.nextInt(80), "DAK");
        p[5] = new Patient("Fertig", ran.nextInt(80), "Privat");
        p[6] = new Patient("Huffmann", ran.nextInt(80), "Techniker Krankenkasse");

        anzahl = 7;

        ausgabe(false);
    }

    public void ausgabe(boolean neu)
    {
        anzahlGeben(neu);
        
        for (int i = 0; i < anzahl; i++)
        {
            System.out.println(p[i].name + ", " + p[i].alter + ", " + p[i].krankenkasse);
        }
    }

    public void verlassen(int nr, boolean drangekommen)
    {
        if (drangekommen == true)
        {
            System.out.println(p[nr].name + " ist drangekommen und alle anderen Patienten rücken auf.");
        }
        else
        {
            System.out.println(p[nr].name + " hat das Wartezimmer verlassen.");
        }

        try
        {    
            for (int i = nr; i < p.length; i++)
            {
                p[i] = p[i + 1];
            }
        }
        catch (Exception ex)
        {
            // Ende des Arrays erreicht
        }

        anzahl--;
    }

    public void naechsterBitte()
    {
        verlassen(0, true);
    }

    public void notfall(String uename, int uealter, String uekrankenkasse)
    {
        anzahl++;

        try
        {    
            for (int i = anzahl; i != 0; i--)
            {
                p[i] = p[i - 1];
            }
        }
        catch (Exception ex)
        {
            // Anfang des Arrays erreicht
        }

        p[0] = new Patient(uename, uealter, uekrankenkasse);

        ausgabe(true);
    }

    public void neuerPatient(String uename, int uealter, String uekrankenkasse)
    {
        p[anzahl] = new Patient(uename, uealter, uekrankenkasse);
        anzahl++;

        ausgabe(true);
    }

    public void altersdurchschnitt()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        double dAlter = 0;

        for (int i = 0; i < anzahl; i++)
        {
            dAlter += p[i].alter;
        }

        dAlter /= anzahl;

        System.out.println("Das Durchschnittsalter aller Wartenden ist " + df.format(dAlter) + " Jahre.");
    }
}