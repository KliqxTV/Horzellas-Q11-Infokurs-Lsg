import java.util.Random;

public class Wartezimmer
{
    private Liste li;
    
    public Wartezimmer()
    {
        li = new Liste();
    }

    public void alleEinfuegen()
    {
        Random ran = new Random();
        
        Patient p1 = new Patient("Hansi", "AOK", ran.nextInt(90) + 2);
        Patient p2 = new Patient("Susi", "BOK", ran.nextInt(90) + 2);
        Patient p3 = new Patient("Konni", "Privat", ran.nextInt(90) + 2);
        Patient p4 = new Patient("Berti", "DOK", ran.nextInt(90) + 2);
        Patient p5 = new Patient("Marki", "Privat", ran.nextInt(90) + 2);
        Patient p6 = new Patient("Muksi", "FOK", ran.nextInt(90) + 2);
        
        li.vorneEinfuegen(p1);
        li.vorneEinfuegen(p2);
        li.vorneEinfuegen(p3);
        li.vorneEinfuegen(p4);
        li.vorneEinfuegen(p5);
        
        listeAusgeben();
    }

    public void alleSortiertEinfuegen()
    {
        Random ran = new Random();
        
        Patient p1 = new Patient("Hansi", "AOK", ran.nextInt(90) + 2);
        Patient p2 = new Patient("Susi", "BOK", ran.nextInt(90) + 2);
        Patient p3 = new Patient("Konni", "Privat", ran.nextInt(90) + 2);
        Patient p4 = new Patient("Berti", "DOK", ran.nextInt(90) + 2);
        Patient p5 = new Patient("Marki", "Privat", ran.nextInt(90) + 2);
        Patient p6 = new Patient("Muksi", "FOK", ran.nextInt(90) + 2);
        
        li.sortiertEinfuegen(p1);
        li.sortiertEinfuegen(p2);
        li.sortiertEinfuegen(p3);
        li.sortiertEinfuegen(p4);
        li.sortiertEinfuegen(p5);
        
        listeAusgeben();
    }
    
    public void vorneEinfuegen(String name, String kraka, int alter)
    {
        Patient p = new Patient(name, kraka, alter);
        li.vorneEinfuegen(p);
        listeAusgeben();
    }
    
    public void hintenEinfuegen(String name, String kraka, int alter)
    {
        Patient p = new Patient(name, kraka, alter);
        li.hintenEinfuegen(p);
        listeAusgeben();
    }
    
    public void sortiertEinfuegen(String name, String kraka, int alter)
    {
        Patient p = new Patient(name, kraka, alter);
        li.sortiertEinfuegen(p);
        listeAusgeben();
    }
    
    public void einfuegenVor(String name, String kraka, int alter, String nameVergleich)
    {
        Patient p = new Patient(name, kraka, alter);
        Patient v = li.suchen(nameVergleich);
        li.einfuegenVor(p,v);
    }
    
    public void listeAusgeben()
    {
        li.alleInformationenAusgeben();
    }
}