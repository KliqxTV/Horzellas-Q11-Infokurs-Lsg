public abstract class Listenelement
{
    abstract Listenelement nachfolgerGeben();

    abstract Datenelement inhaltGeben();

    abstract void informationAusgeben();

    abstract Datenelement suchen(String vergleichswert);

    abstract Knoten hintenEinfuegen(Datenelement pNeu);

    abstract Knoten einfuegenVor(Datenelement pNeu, Datenelement pVergleich);

    abstract Knoten sortiertEinfuegen(Datenelement pNeu);

    abstract Datenelement endeGeben(Datenelement p);

    abstract Listenelement endeEntfernen(Datenelement p);

    abstract Listenelement knotenEntfernen(Datenelement dVergleich);

    abstract int restlaengeGeben();
}
