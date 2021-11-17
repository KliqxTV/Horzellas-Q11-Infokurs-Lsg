import java.text.DecimalFormat;

public class Sachbearbeiter
{
    DecimalFormat df = new DecimalFormat("#,###");
    Antrag erster;

    public Sachbearbeiter()
    {
        Antrag a6 = new Antrag("Meyer", "Garage", 59000);
        Antrag a5 = new Antrag("Huber", "Haus", 160000);
        Antrag a4 = new Antrag("Albert", "Privat", 260000);
        Antrag a3 = new Antrag("Kuntz", "Terrasse", 230000);
        Antrag a2 = new Antrag("Ochsenknecht", "Carport", 12000);
        Antrag a1 = new Antrag("Ramke", "Haus", 97000);

        erster = a1;
        a1.naechster = a2;
        a2.naechster = a3;
        a3.naechster = a4;
        a4.naechster = a5;
        a5.naechster = a6;

        alleAusgeben();
    }

    public void alleAusgeben()
    {
        int total = 0;
        Antrag naechsterWennExistiert = erster.naechster;

        while (naechsterWennExistiert != null)
        {
            total++;

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }
        
        int counter = -1;
        naechsterWennExistiert = erster.naechster;

        System.out.println("[" + (total - counter) + "] " + erster.name + ", " + erster.art + ", " + df.format(erster.bausumme));

        while (naechsterWennExistiert != null)
        {
            counter++;
            System.out.println("[" + (total - counter) + "] " + naechsterWennExistiert.name + ", " + naechsterWennExistiert.art + ", " + df.format(naechsterWennExistiert.bausumme));

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }
    }

    public void anzahlHaus()
    {
        int counter = 0;
        Antrag naechsterWennExistiert = erster.naechster;

        while (naechsterWennExistiert != null)
        {
            if (naechsterWennExistiert.art == "Haus")
            {
                counter++;
            }

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }

        System.out.println("Es sind " + counter + " Anträge der Art Haus vorhanden.");
    }

    public void anzahl()
    {
        int counter = 0;
        Antrag naechsterWennExistiert = erster.naechster;

        while (naechsterWennExistiert != null)
        {
            counter++;

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }

        System.out.println("Es sind " + counter + " Anträge vorhanden.");
    }

    public void gibtsDen(String suchName)
    {
        int total = 0;
        Antrag naechsterWennExistiert = erster;

        while (naechsterWennExistiert != null)
        {
            total++;

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }
        
        int counter = -1;
        naechsterWennExistiert = erster;

        while (naechsterWennExistiert != null)
        {
            counter++;

            if (naechsterWennExistiert.name == suchName)
            {
                System.out.println(suchName + " hat den " + (total - counter) + ". Bauantrag.");
                return;
            }

            naechsterWennExistiert = naechsterWennExistiert.naechster;
        }

        System.out.println("Kein Bauantrag von " + suchName + " gefunden.");
    }

    public void pop(boolean bearbeitet)
    {
        if (bearbeitet == true)
        {
            System.out.println("Oberster Auftrag wurde bearbeitet und aus dem Stack entfernt.");
        }
        else
        {
            System.out.println("Oberster Auftrag wurde aus dem Stack gelöscht.");
        }

        //An sich ist das eins-zu-eins meine loeschen(String loeschName)-Methode aus Wartezimmer-Antrag
        //(class Wartezimmer) mit einer kleinen Änderung: Anstatt dass ein Objekt mit Namen gennant werden
        //muss, wird von vorn herein das loeschObjekt mit dem letzten (oder im Stack 'ersten') Objekt im Stack
        //gleichgesetzt. Mag unnötig sein, sollte aber ziemlich sicher 100%ig funktionieren, selbst wenn, wie
        //auch immer, irgendwas komisches mit der Reihenfolge der Anträge vor sich geht / ging. *shrug*

        //Finde zu löschendes Antrag-Objekt
        Antrag loeschObjekt = getLast();

        //Überprüfe Failsafe um NullPointerExceptions zu verhindern
        if (loeschObjekt == null)
        {
            //null-Referenz gefunden
            //-> Löschversuch schlägt fehl

            System.out.println("Der Bauantrag " + loeschObjekt.art + " von " + loeschObjekt.name + " konnte nicht gelöscht werden.");
            return;
        }

        //Starte Durchlauf der Liste mit dem ersten Element
        Antrag jetzigesObjekt = getFirst();

        //Loop solange es "nächste Antragen" gibt und das jetzige Objekt nicht das zu löschende Objekt ist
        while (jetzigesObjekt.naechster != null && !(jetzigesObjekt.equals(loeschObjekt)))
        {
            //Wenn das Objekt nach dem jetzigen gleich dem zu löschenden Objekt ist
            if (jetzigesObjekt.naechster.equals(loeschObjekt))
            {
                //Wenn der "übernächste Antrag" keine null-Referenz ist...
                if (jetzigesObjekt.naechster.naechster != null)
                {
                    //...lasse den "übernächsten" einen Platz "aufrücken
                    jetzigesObjekt.naechster = jetzigesObjekt.naechster.naechster;
                }
                else
                {
                    //Da der "übernächste" eine null-Referenz ist, muss das jetzige Objekt  sein
                    //also mache dieses Objekt zu einer null-Referenz und verlasse den while-Loop
                    jetzigesObjekt.naechster = null;
                    break;

                    //Dies SOLLTE immer der Fall sein, da immer das letzte Objekt aus dem Stack gelöscht wird
                }
            }

            //Ansonsten mache das nächste Objekt zum jetzigen Objekt
            jetzigesObjekt = jetzigesObjekt.naechster;
        }

        alleAusgeben();
    }

    private Antrag getFirst()
    {
        return erster;
    }

    private Antrag getLast()
    {
        Antrag naechsterWennExistiert = erster;

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

    public void push(String n, String a, int b)
    {
        Antrag neu = new Antrag(n, a, b);
        Antrag ehemLetzter = getLast();
        ehemLetzter.naechster = neu;

        System.out.println("Neuer Bauantrag " + a + " von " + n + ", Summe " + df.format(b) + " wurde dem Stack hinzugefügt.");
        alleAusgeben();
    }
}