public abstract class Listenelement
{
    abstract Listenelement nachfolgerGeben();

    abstract Patient inhaltGeben();

    abstract void informationAusgeben();

    abstract Patient suchen(String vergleichswert);

    abstract Knoten hintenEinfuegen(Patient pNeu);

    abstract Knoten einfuegenVor(Patient pNeu, Patient pVergleich);

    abstract Knoten sortiertEinfuegen(Patient pNeu);

    abstract Patient endeGeben(Patient p);

    abstract Listenelement endeEntfernen(Patient p);

    abstract Listenelement knotenEntfernen(Patient dVergleich);

    abstract int restlaengeGeben();
}
