public class Patient
{
    private String name;
    private String kraka;
    private int alter;
    
    public Patient(String nameNeu, String krakaNeu, int alterNeu)
    {
        name = nameNeu;
        kraka = krakaNeu;
        alter = alterNeu;
    }

    public String nameGeben()
    {
      return name;
    }
    
    public String krakaGeben()
    {
      return kraka;
    }
    
    public int alterGeben()
    {
        return alter;
    }
    
    public void nameSetzen(String nameNeu)
    {
      name = nameNeu;
    }
    
    public void krakaSetzen(String krakaNeu)
    {
       kraka = krakaNeu;
    }

    public void informationAusgeben()
    {
        System.out.println("Der Patient " + name + " ist bei " + kraka + " versichert und " + alter + " Jahre alt.");
    }
   
    public boolean istKleinerAls(Patient p)
    {
       return name.compareTo(p.name) < 0;
    }
    
    public boolean schluesselIstGleich(String s)
    {
        return name.equals(s);
    }
}