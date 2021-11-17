public class Knoten
{
    int knotenID;
    String knotenName;
    Knoten links;
    Knoten rechts;

    public Knoten(int id, String name)
    {
        knotenID = id;
        knotenName = name;
    }

    public void sucheID(int id)
    {
        try
        {
            if (knotenID == id)
            {
                System.out.println("Gesuchte ID "
                    + id
                    + " ergab den Namen '"
                    + knotenName
                    + "'");
            }
            else if (knotenID < id)
            {
                // id ist kleiner, also gehe nach links
                links.sucheID(id);
            }
            else
            {
                // id muss größer sein, also gehe nach rechts
                rechts.sucheID(id);
            }
        }
        catch (Exception e)
        {
            System.out.println("Gesuchte ID "
                + id
                + " ergab keine Ergebnisse.");
        }
    }

    public String sucheName(String name)
    {
        String gefundeneIDs = "";

        // Wenn der knotenName gleich dem gesuchten name-Wert ist, ID dieses Knotens aufnehmen
        if (knotenName == name)
        {
            gefundeneIDs += knotenID + " ";
        }

        // Weiter links gehen wenn möglich
        if (links != null)
        {
            gefundeneIDs += links.sucheName(name);
        }

        // Jetzt eins nach rechts gehen und weitermachen, wenn möglich
        if (rechts != null)
        {
            gefundeneIDs += rechts.sucheName(name);
        }

        return gefundeneIDs;
    }

    public void inOrderAusgabe()
    {
        // Weiter links gehen wenn möglich
        if (links != null)
        {
            links.inOrderAusgabe();
        }

        // Linksgehen war nicht möglich, jetzt Wurzeldaten ausgeben
        System.out.println("ID: "
            + knotenID
            + ", Name: "
            + knotenName);

        // Wurzeldaten ausgegeben, jetzt eins nach rechts gehen und weitermachen, wenn möglich
        if (rechts != null)
        {
            rechts.inOrderAusgabe();
        }
    }
}