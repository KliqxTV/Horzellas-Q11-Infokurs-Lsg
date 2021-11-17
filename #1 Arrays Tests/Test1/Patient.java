public class Patient
{
    private String name;
    private int alter;
    private String krankenkasse;
    
    public Patient(String pName, int pAlter, String pKrankenkasse)
    {
        this.name = pName;
        this.alter = pAlter;
        this.krankenkasse = pKrankenkasse;
    }
    
    public void neueKrankenkasse(String neu)
    {
        this.krankenkasse = neu;
        System.out.println(name + "'s neue Krankenkasse ist " + neu);
    }
    
    public void kinder()
    {
        if (this.alter < 10)
        {
            System.out.println(name + " zum Kinderarzt.");
        }
    }
    
    public int wannerwachsen()
    {
        return 10 - this.alter;
    }
}