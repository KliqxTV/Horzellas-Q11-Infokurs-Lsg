public class Ort
{
    // Stinknormale 08/15-Klasse für was auch immer
    private String ortsname;
    private int einwohnerzahl;

    public Ort(String ortsname, int einwohnerzahl) {
        this.setOrtsname(ortsname);
        this.setEinwohnerzahl(einwohnerzahl);
    }

    public String getOrtsname()
    {
        return ortsname;
    }

    public void setOrtsname(String ortsname)
    {
        this.ortsname = ortsname;
    }

    public int getEinwohnerzahl() {
        return einwohnerzahl;
    }

    public void setEinwohnerzahl(int einwohnerzahl) {
        this.einwohnerzahl = einwohnerzahl;
    }
}