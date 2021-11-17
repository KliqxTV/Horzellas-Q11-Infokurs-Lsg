public class Hase extends Tier
{
    public Hase(String n, int a)
    {
        name = n;
        alter = a;
    }

    public void lautgeben()
    {
        System.out.println(name + " macht schnuff-schnuff!");

        if (naechster != null)
        {
            naechster.lautgeben();
        }
    }    

    public void pflegen()
    {
        System.out.println(name + " will gekrault werden.");

        if (naechster != null)
        {
            naechster.pflegen();
        }
    }

    public void magfutter()
    {
        System.out.println(name + " mag Karotte.");

        if (naechster != null)
        {
            naechster.magfutter();
        }
    }
}