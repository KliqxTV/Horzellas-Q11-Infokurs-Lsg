public class Katze extends Tier
{
    public Katze(String uename, int uealter) {
        name = uename;
        alter = uealter;
    }

    public void lautgeben() {
        System.out.println(name+" macht miau miau!");
        if(naechster != null) naechster.lautgeben();
    }    

    public void pflegen(){
        System.out.println(name+" will gestreichelt werden");
        if(naechster != null) naechster.pflegen();
    }
    
    public void magfutter()
    {
        System.out.println(name + " mag Milch.");
        
        if (naechster != null)
        {
            naechster.magfutter();
        }
    }
}