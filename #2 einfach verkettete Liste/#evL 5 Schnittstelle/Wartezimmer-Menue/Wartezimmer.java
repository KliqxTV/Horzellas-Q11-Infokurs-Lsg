import java.util.Scanner;

public class Wartezimmer{

    private Liste li;

    public Wartezimmer(){
        li = new Liste();
        menu();
    }

    public void menu()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("1) Patient eingeben");
        System.out.println("2) Liste ausgeben");
        System.out.println("3) Beenden");
        System.out.print("Eingabe: ");

        switch(s.nextInt()) {
            case 1:
            patientEinfuegen();
            menu();
            break;
            case 2:
            li.alleInformationenAusgeben();
            menu();
            break;
            case 3:
            System.out.println("ENDE");
            break;
            default:
            System.err.println("Falsche Eingabe");
            menu();
            break;
        }
    }

    public void patientEinfuegen(){
        Scanner s = new Scanner(System.in);
        System.out.print("Name: ");
        String name = s.next();
        System.out.print("Krankenkasse: ");
        String kraka = s.next();
        System.out.print("Alter: ");
        int alter = s.nextInt();        
        Patient p = new Patient(name, kraka, alter);
        li.vorneEinfuegen(p);
    }

    public void listeAusgeben(){
        li.alleInformationenAusgeben();
    }

}