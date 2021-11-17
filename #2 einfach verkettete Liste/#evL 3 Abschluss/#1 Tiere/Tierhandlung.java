public class Tierhandlung {
    Tier erster;
    
    public Tierhandlung() {
        Tier t1 = new Katze("Mimmi", 3);
        Tier t2 = new Hund("Bello", 7, 5);
        Tier t3 = new Katze("Molli", 2);
        Tier t4 = new Hund("Waldi", 4, 4);
        Tier t5 = new Hase("Schnuffi", 1);

        erster = t1;
        t1.naechster = t2;
        t2.naechster = t3;
        t3.naechster = t4;
        t4.naechster = t5;
        
        erster.ausgabe();
    }

    public void allelautgeben() { 
        erster.lautgeben();
    }

    public void allepflegen() { 
        erster.pflegen();
    }
    
    public void zaehletiere() {
        erster.zaehletiere();
    }
    
    public void alleFuettern()
    {
        erster.magfutter();
    }
    
    public void gesamtalter()
    {
        System.out.println("Das Gesamtalter aller Tiere ist " + erster.alter() + ".");
    }
    
    public void durchschnittsalter()
    {
        System.out.println("Das Durchschnittsalter ist " + erster.alter() / erster.anzahltiere() + ".");
    }
}