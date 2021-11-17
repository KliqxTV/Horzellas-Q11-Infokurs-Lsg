import java.text.DecimalFormat;

public class Onlineshop
{
    Bestellung erster;

    public Onlineshop()
    {
        Bestellung a1 = new Bestellung("oPhone 8", 1, 899.99);
        Bestellung a2 = new Bestellung("Netzteil ARC-42", 3, 9.99);
        Bestellung a3 = new Bestellung("Yntel Kore Y5", 14, 44.99);
        Bestellung a4 = new Bestellung("PC-Set Kronika R87", 2, 1649.99);
        Bestellung a5 = new Bestellung("Kücheneinrichtung M762", 1, 3889.99);

        erster = a1;

        a1.naechster = a2;
        a2.naechster = a3;
        a3.naechster = a4;
        a4.naechster = a5;
        
        alleAusgeben();
    }

    public void alleAusgeben()
    {
        int counter = 1;
        Bestellung naechsterWennExistiert = erster.naechster;

        System.out.println("[" + counter + "] " + erster.artikel + ", " + erster.anzahl + ", " + erster.einzelpreis);

        while (naechsterWennExistiert != null)
        {
            counter++;
            System.out.println("[" + counter + "] " + naechsterWennExistiert.artikel + ", " + naechsterWennExistiert.anzahl + ", " + naechsterWennExistiert.einzelpreis);

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }
    }

    public void anzahl()
    {
        int counter = 1;
        Bestellung naechsterWennExistiert = erster.naechster;

        while (naechsterWennExistiert != null)
        {
            counter++;

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }

        System.out.println("Es sind " + counter + " Bestellungen verzeichnet.");
    }

    public void anzahlUeber1000()
    {
        int counter = 0;
        Bestellung naechsterWennExistiert = erster.naechster;

        while (naechsterWennExistiert != null)
        {
            if (naechsterWennExistiert.anzahl * naechsterWennExistiert.einzelpreis > 1000)
            {
                counter++;
            }

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }

        System.out.println("Es sind " + counter + " Bestellungen mit Gesamtpreis über 1000,- verzeichnet.");
    }

    public void gesamtsumme()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        double summe = 0;
        Bestellung naechsterWennExistiert = erster.naechster;

        while (naechsterWennExistiert != null)
        {
            summe += naechsterWennExistiert.anzahl * naechsterWennExistiert.einzelpreis;

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }

        System.out.println("Die Gesamtsumme aller Bestellungen ist " + df.format(summe) + ".");
    }

    private Bestellung getFirst()
    {
        return erster;
    }

    private Bestellung getLast()
    {
        Bestellung naechsterWennExistiert = erster;

        while (true)
        {
            if (naechsterWennExistiert.naechster != null)
            {
                naechsterWennExistiert = naechsterWennExistiert.naechster;
            }
            else
            {
                break;
            }
        }

        return naechsterWennExistiert;
    }

    public void hintenanfuegen(String art, int anz, double ein)
    {
        Bestellung neu = new Bestellung(art, anz, ein);
        Bestellung ehemLetzter = getLast();
        ehemLetzter.naechster = neu;

        alleAusgeben();
    }

    public void durchschnittsbetrag()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        int counter = 1;
        double summe = 0;
        Bestellung naechsterWennExistiert = erster.naechster;

        while (naechsterWennExistiert != null)
        {
            counter++;
            summe += naechsterWennExistiert.anzahl * naechsterWennExistiert.einzelpreis;

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }

        double durchschnitt = summe / counter;

        System.out.println("Der Durchschnittsbetrag aller Bestellungen ist " + df.format(durchschnitt) + ".");
    }
    
    public void maxBetrag()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        double letztesMax = 0.0;
        Bestellung naechsterWennExistiert = erster.naechster;

        while (naechsterWennExistiert != null)
        {
            if (naechsterWennExistiert.anzahl * naechsterWennExistiert.einzelpreis > letztesMax)
            {
                letztesMax = naechsterWennExistiert.anzahl * naechsterWennExistiert.einzelpreis;
            }

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }

        System.out.println("Die teuerste Bestellung kostet " + df.format(letztesMax) + ".");
    }
}