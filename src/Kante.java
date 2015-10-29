/**
 * Created by ltlts on 28.10.2015.
 */
public class Kante {
    private Knoten _von;
    private Knoten _nach;
    private String _name;
    private int _gewicht;

    // Konstruktor mit Knotengewichtung
    public Kante(String name, Knoten von, Knoten nach, int gewicht) {
        _name=name;
        _von=von;
        _nach=nach;
        _gewicht=gewicht;
    }

    // Konstruktor ohne Knotengewichtung (gewicht = 1)
    public Kante(String name, Knoten von, Knoten nach) {
        this (name, von, nach, 1);
    }

    @Override
    public String toString() {
        return _name+":"+_von.toString()+"->"+ _nach.toString();
    }
}
