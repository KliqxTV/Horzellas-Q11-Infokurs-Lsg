public class Wartezimmer
{
    Patient erster;

    public Wartezimmer()
    {
        Patient p1 = new Patient("Hansi", "AOK", 23);
        Patient p2 = new Patient("Susi", "BOK", 43);
        Patient p3 = new Patient("Konni", "Privat", 73);
        Patient p4 = new Patient("Berti", "DOK", 13);
        Patient p5 = new Patient("Marki", "Privat", 3);
        Patient p6 = new Patient("Muksi", "FOK", 83);

        erster = p1;
        p1.naechster = p2;
        p2.naechster = p3;
        p3.naechster = p4;
        p4.naechster = p5;
        p5.naechster = p6;

        alleAusgeben();
    }

    public void alleAusgeben()
    {
        int counter = 0;
        Patient ap = erster;
        
        while (ap != null)
        {
            counter++;
            System.out.println("[" + counter + "] " + ap.name + ", " + ap.kraka + ", " + ap.alter);

            ap = ap.naechster;
        }
    }

    public void anzahl()
    {
        int counter = 0;
        Patient ap = erster;

        while (ap != null)
        {
            counter++;

            ap = ap.naechster;
        }

        System.out.println("Es warten " + counter + " Personen.");
    }

    public void anzahlPrivatversicherte()
    {
        int counter = 0;
        Patient ap = erster;

        while (ap != null)
        {
            if (ap.kraka == "Privat")
            {
                counter++;
            }

            ap = ap.naechster;
        }

        System.out.println("Es sind " + counter + " Personen privat versichert.");
    }

    public void gibtsDen(String suchName)
    {
        Patient ap = erster;

        while (ap != null)
        {
            if (ap.name == suchName)
            {
                System.out.println(suchName + " wartet.");
                return;
            }

            ap = ap.naechster;
        }

        System.out.println(suchName + " nicht gefunden.");
    }

    private Patient getFirst()
    {
        return erster;
    }

    private Patient getLast()
    {
        Patient ap = erster;

        while (true)
        {
            if (ap.naechster != null)
            {
                ap = ap.naechster;
            }
            else
            {
                break;
            }
        }

        return ap;
    }

    public void hintenanfuegen(String uename, String uekraka, int uealter)
    {
        Patient neu = new Patient(uename, uekraka, uealter);
        Patient ehemLetzter = getLast();
        ehemLetzter.naechster = neu;

        alleAusgeben();
    }
    
    private Patient getObjectFromName(String name)
    {
        Patient ap = erster;

        try
        {
            while (true)
            {
                if (ap.name != name)
                {
                    ap = ap.naechster;
                }
                else
                {
                    break;
                }
            }
        }
        catch (Exception ex)
        {
            return new Patient("Platzhalter", "", 0);
        }

        return ap;
    }
    
    // public void loeschen_2(String loeschName)
    // {
        // Patient ap = erster;
        
        // while (true)
        // {
            // if (ap.name == loeschName)
            // {
                // ap = ap.naechster.naechster;
                // break;
            // }
            // else
            // {
                // ap = ap.naechster;
            // }
        // }
    // }

    public void loeschenKompliziert(String loeschName)
    {
        //Finde zu löschendes Patient-Objekt
        Patient loeschObjekt = getObjectFromName(loeschName);
        
        //Überprüfe Failsafes um NullPointerExceptions zu verhindern
        if (loeschObjekt == null || loeschObjekt.name == "Platzhalter")
        {
            //null-Referenz gefunden oder
            //Ende der Liste ohne Treffer erreicht
            //-> Löschversuch schlägt fehl
            
            System.out.println(loeschName + " konnte nicht gelöscht werden.");
            return;
        }
        
        //Starte Durchlauf der Liste mit dem ersten Element
        Patient jetzigesObjekt = getFirst();
        
        //Loop solange es "nächste Patienten" gibt und das jetzige Objekt nicht das zu löschende Objekt ist
        while (jetzigesObjekt.naechster != null && !(jetzigesObjekt.equals(loeschObjekt)))
        {
            //Wenn das Objekt nach dem jetzigen gleich dem zu löschenden Objekt ist
            if (jetzigesObjekt.naechster.equals(loeschObjekt))
            {
                //Wenn der "übernächste Patient" keine null-Referenz ist...
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
                }
            }
            
            //Ansonsten mache das nächste Objekt zum jetzigen Objekt
            jetzigesObjekt = jetzigesObjekt.naechster;
        }
        
        alleAusgeben();
    }
}