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

        inOrderAusgabe();
    }
    
    public void einfuegen(int id, String name)
    {
        erster.einfuegen(id, name);
        
        inOrderAusgabe();
    }

    public void inOrderAusgabe()
    {
        // Macht exakt das gleiche wie ersteSiebenAusgeben(), nur viel einfacher XD

        erster.inOrderAusgabe();
    }
}