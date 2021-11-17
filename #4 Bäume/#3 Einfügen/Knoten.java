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

    public void einfuegen(int id, String name)
    {
        try
        {
            if (knotenID == id)
            {
                System.out.println("Neue ID "
                    + id
                    + " existiert bereits mit dem Namen '"
                    + knotenName
                    + "'!");
            }
            else if (knotenID > id)
            {
                // Neue id ist kleiner, also gehe nach links
                links.einfuegen(id, name);
            }
            else
            {
                // Neue id muss größer sein, also gehe nach rechts
                rechts.einfuegen(id, name);
            }
        }
        catch (Exception e)
        {
            if (knotenID > id)
            {
                Knoten neu = new Knoten(id, name);
                links = neu;
            }
            else
            {
                Knoten neu = new Knoten(id, name);
                rechts = neu;
            }
        }
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