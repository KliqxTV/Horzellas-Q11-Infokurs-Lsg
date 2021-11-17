public class Wartezimmer{
    
    private Liste li;
    
    public Wartezimmer(){
        li = new Liste();
    }
    
    public void alleEinfuegen(){
        Patient p1 = new Patient("Hansi","AOK",23);
        Patient p2 = new Patient("Susi","BOK",43);
        Patient p3 = new Patient("Konni","Privat",73);
        Patient p4 = new Patient("Berti","DOK",13);
        Patient p5 = new Patient("Marki","Privat",3);
        Patient p6 = new Patient("Muksi","FOK",83);
        li.vorneEinfuegen(p1);
        li.vorneEinfuegen(p2);
        li.vorneEinfuegen(p3);
        li.vorneEinfuegen(p4);
        li.vorneEinfuegen(p5);
        li.vorneEinfuegen(p6);
    }
    
    // Funktioniert erst richtig, wenn HintenEinfuegen programmiert ist
    public void alleSortiertEinfuegen(){
        Patient p1 = new Patient("Hansi","AOK",23);
        Patient p2 = new Patient("Susi","BOK",43);
        Patient p3 = new Patient("Konni","Privat",73);
        Patient p4 = new Patient("Berti","DOK",13);
        Patient p5 = new Patient("Marki","Privat",3);
        Patient p6 = new Patient("Muksi","FOK",83);
        li.sortiertEinfuegen(p1);
        li.sortiertEinfuegen(p2);
        li.sortiertEinfuegen(p3);
        li.sortiertEinfuegen(p4);
        li.sortiertEinfuegen(p5);
        li.sortiertEinfuegen(p6);
    }
    
    public void vorneEinfuegen(String name, String kraka, int alter){
        Patient p = new Patient(name, kraka, alter);
        li.vorneEinfuegen(p);
        listeAusgeben();
    }
    
    public void hintenEinfuegen(String name, String kraka, int alter){
        Patient p = new Patient(name, kraka, alter);
        li.hintenEinfuegen(p);
        listeAusgeben();
    }
    
    // Funktioniert erst richtig, wenn HintenEinfuegen programmiert ist
    public void sortiertEinfuegen(String name, String kraka, int alter){
        Patient p = new Patient(name, kraka, alter);
        li.sortiertEinfuegen(p);
        listeAusgeben();
    }
    
    // Funktioniert erst richtig, wenn HintenEinfuegen programmiert ist
    public void einfuegenVor(String name, String kraka, int alter, String nameVergleich){
        Patient p = new Patient(name, kraka, alter);
        Patient v = li.suchen(nameVergleich);
        li.einfuegenVor(p,v);
    }
    
    public void listeAusgeben(){
        li.alleInformationenAusgeben();
    }
    
    public void laengeAusgeben(){
        System.out.println("Es warten "+li.laengeGeben()+" Patienten.");
    }
        
}