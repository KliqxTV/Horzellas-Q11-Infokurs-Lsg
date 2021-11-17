public class Antrag
{
    String name;
    String art;
    int bausumme;
    Antrag naechster;

    public Antrag(String n, String a, int b)
    {
        name = n;
        art = a;
        bausumme = b;
    }
}