public class Kunde
{
    private String name;
    private int alter;
    private double guthaben;
    private String wohnort;
    

    public Kunde(String uename, int uealter, String uewohnort)
    { 
        name = uename;
        alter = uealter;
        guthaben = 0;
        wohnort = uewohnort;
    }
    
    public void istwertinger()
    {
        if (this.wohnort == "Wertingen")
        {
            System.out.println(name + " ist Wertinger.");
        }
        else
        {
            System.out.println(name + " ist kein Wertinger.");
        }
    }
    
    public void umzugnach(String nach)
    {
        this.wohnort = nach;
        System.out.println(name + "'s neuer Wohnort ist " + nach);
    }
    
    public void einzahlen(double ein)
    {
        this.guthaben += ein;
    }
    
    public void zins(double zinssatz, int jahre)
    {
        System.out.println("Startwert: " + this.guthaben);
        System.out.println();
        
        for (int i = 0; i < jahre; i++)
        {
            this.guthaben *= zinssatz + 1;
            System.out.println((i + 1) + ". Jahr: " + this.guthaben);
        }
    }

    public void ausgabe()
    { 
        System.out.println(" Der Kunde heisst " + name + " und ist " + alter + " Jahre alt.");
    }

    public int alterinzehnjahren()
    {
        return (alter+10);
    }

    public void alterzehnjahreausgeben()
    { 
        System.out.println("Der Kunde " + name + " ist in 10 Jahren " + alterinzehnjahren() + " alt");
    }

    public void erwachsen()
    { 
        if(alter>17) 
        {
            System.out.println("Kunde ist volljährig!");
        } 
        else 
        { 
            System.out.println("Kunde ist nicht volljährig!");
        }
    }

    public void hochzaehlen()
    {  
        for (int i = 1; i <= alter; i++)
        { 
            System.out.println(i);
        }
    }

    public void alterinxjahren(int x)
    { 
        System.out.println("Der Kunde " + name + " ist in " + x + " Jahren "+ (alter+x) +" Jahre alt");
    }

}