import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by ltlts on 28.10.2015.
 */
public class Graph {
    private Knoten[] _knoten;
    private Kante[] _kanten;
    private ArrayList<Knoten>[] _nachbarn;

    Graph(String dateiName, boolean ungerichtet) throws IOException {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new BufferedReader(new FileReader(dateiName)));
            int knoten=inputStream.nextInt();
            _knoten = new Knoten[knoten];
            _nachbarn = new ArrayList[knoten];
            for (int i=0;i<knoten;++i)
                _nachbarn[i]=new ArrayList<Knoten>();
            inputStream.nextLine();
            _kanten = new Kante[inputStream.nextInt()];
            inputStream.nextLine();
            inputStream.nextLine();
            for (int i = 0; i < _knoten.length; ++i)
                _knoten[i] = new Knoten(inputStream.next(), inputStream.nextDouble(), inputStream.nextDouble());
            for (int i = 0; i < _kanten.length; ++i) {
                String name = inputStream.next();
                String von = inputStream.next();
                String nach = inputStream.next();
                _kanten[i] = new Kante(name, getKnoten(von), getKnoten(nach), inputStream.nextInt());
                _nachbarn[getKnotenIndex(von)].add(getKnoten(nach));
                if (ungerichtet)
                    _nachbarn[getKnotenIndex(nach)].add(getKnoten(von));
            }
        } finally {
            if (inputStream != null)
                inputStream.close();
        }
    }

    private int getKnotenIndex(String name) {
        for (int i = 0; i < _knoten.length; ++i)
            if (Objects.equals(name, _knoten[i].getName()))
                return i;
        return -1;
    }

    public Knoten getKnoten(String name) {
        for (Knoten a_knoten : _knoten)
            if (Objects.equals(name, a_knoten.getName()))
                return a_knoten;
        return null;
    }

    public Knoten getKnoten(int index) {
        if (index < 0 || index >= _knoten.length)
            throw new IndexOutOfBoundsException();
        return _knoten[index];
    }

    public Kante getKante(int index) {
        if (index < 0 || index >= _kanten.length)
            throw new IndexOutOfBoundsException();
        return _kanten[index];
    }

    public ArrayList<Knoten> getNachbarn(int index) {
        if (index < 0 || index >= _nachbarn.length)
            throw new IndexOutOfBoundsException();
        return _nachbarn[index];
    }

    public int nKnoten() {
        return _knoten.length;
    }

    public int nKanten() {
        return _kanten.length;
    }

    @Override
    public String toString() {
        String s = "Knoten:";
        for (int i = 0; i < nKnoten(); ++i)
            s += " " + _knoten[i].toString();
        s += "\n Kanten:";
        for (int i = 0; i < nKanten(); ++i)
            s += "\n" + _kanten[i].toString();
        return s;
    }
}
