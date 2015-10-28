/**
 * Created by ltlts on 28.10.2015.
 */
public class Knoten {
    private String _name;
    private double _xKoo;
    private double _yKoo;

    public Knoten(String name, double xKoo, double yKoo) {
        _name=name;
        _xKoo=xKoo;
        _yKoo=yKoo;
    }

    @Override
    public String toString() {
        return _name;
    }

    public String getName() {
        return _name;
    }
}
