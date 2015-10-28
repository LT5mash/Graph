import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ltlts on 28.10.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the file name: ");
        String file = br.readLine();
        Graph g=new Graph(file,false);
        System.out.print(g.toString());
    }
}
