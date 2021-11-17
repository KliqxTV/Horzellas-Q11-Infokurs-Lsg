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

    public Knoten minimumAusgeben()
    {
        if (links != null)
        {
            return links.minimumAusgeben();
        }
        else
        {
            return this;
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

    public void preOrderAusgabe()
    {
        // Zuerst Wurzeldaten ausgeben
        System.out.println("ID: "
            + knotenID
            + ", Name: "
            + knotenName);

        // Weiter links gehen wenn möglich
        if (links != null)
        {
            links.preOrderAusgabe();
        }

        // Eins nach rechts gehen und weitermachen, wenn möglich
        if (rechts != null)
        {
            rechts.preOrderAusgabe();
        }
    }

    public void postOrderAusgabe()
    {
        // Weiter links gehen wenn möglich
        if (links != null)
        {
            links.postOrderAusgabe();
        }

        // Linksgehen war nicht möglich, jetzt eins nach rechts gehen
        if (rechts != null)
        {
            rechts.postOrderAusgabe();
        }

        // Zuletzt Wurzeldaten ausgeben
        System.out.println("ID: "
            + knotenID
            + ", Name: "
            + knotenName);
    }
}