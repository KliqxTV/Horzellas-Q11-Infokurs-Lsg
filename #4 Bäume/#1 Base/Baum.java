public class Baum
{
    Knoten erster;

    public Baum()
    {
        Knoten k1 = new Knoten(7, "Huber");
        Knoten k2 = new Knoten(3, "Müller");
        Knoten k3 = new Knoten(1, "Huber");
        Knoten k4 = new Knoten(4, "Meier");
        Knoten k5 = new Knoten(22, "Huber");
        Knoten k6 = new Knoten(14, "Haber");
        Knoten k7 = new Knoten(35, "Leister");

        erster = k1;
        k1.links = k2;
        k1.rechts = k5;
        k2.links = k3;
        k2.rechts = k4;
        k5.links = k6;
        k5.rechts = k7;
    }

    public void minimumAusgeben()
    {
        Knoten result = erster.minimumAusgeben();

        System.out.println("ID: "
            + result.knotenID
            + ", Name: "
            + result.knotenName);
    }

    public void ersteDreiAusgeben()
    {
        Knoten[] results = new Knoten[3];

        results[0] = erster;
        results[1] = results[0].links;
        results[2] = results[0].rechts;

        results = bubbleSort(results);

        for (Knoten k : results)
        {
            System.out.println("ID: "
                + k.knotenID
                + ", Name: "
                + k.knotenName);
        }
    }
    
    public void ersteSiebenAusgeben()
    {
        Knoten[] results = new Knoten[7];

        results[0] = erster;
        results[1] = results[0].links;
        results[2] = results[0].rechts;
        results[3] = results[1].links;
        results[4] = results[1].rechts;
        results[5] = results[2].links;
        results[6] = results[2].rechts;

        results = bubbleSort(results);
        
        for (Knoten k : results)
        {
            System.out.println("ID: "
                + k.knotenID
                + ", Name: "
                + k.knotenName);
        }
    }

    private Knoten[] bubbleSort(Knoten[] k)
    {
        boolean getauscht = true;
        Knoten[] sortErgebnis = k;

        int n = k.length;

        while (getauscht == true)
        {
            getauscht = false;

            for (int i = 1; i <= n - 1; i++)
            {
                if (sortErgebnis[i - 1].knotenID > sortErgebnis[i].knotenID)
                {
                    Knoten temp = new Knoten(sortErgebnis[i - 1].knotenID, sortErgebnis[i - 1].knotenName);
                    sortErgebnis[i - 1] = null;

                    sortErgebnis[i - 1] = new Knoten(sortErgebnis[i].knotenID, sortErgebnis[i].knotenName);
                    sortErgebnis[i] = null;
                    
                    sortErgebnis[i] = new Knoten(temp.knotenID, temp.knotenName);
                    temp = null;

                    getauscht = true;
                }
            }
        }

        return sortErgebnis;
    }
    
    public void inOrderAusgabe()
    {
        // Macht exakt das gleiche wie ersteSiebenAusgeben(), nur viel einfacher XD
        
        erster.inOrderAusgabe();
    }
    
    public void preOrderAusgabe()
    {
        erster.preOrderAusgabe();
    }
    
    public void postOrderAusgabe()
    {
        erster.postOrderAusgabe();
    }
}