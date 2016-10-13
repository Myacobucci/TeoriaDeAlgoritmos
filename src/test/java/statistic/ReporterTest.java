package statistic;

import org.junit.Before;
import org.junit.Test;
import reporter.Reporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by juan on 09/10/16.
 */
public class ReporterTest {

    private ArrayList<IStatistic> statistics = new ArrayList<>();

    @Before
    public void setUp() {
        this.statistics = new ArrayList<>();
        statistics.add(new BruteForce());
        statistics.add(new SortAndGet());
        statistics.add(new Quickselect());
        statistics.add(new KSelections());
        statistics.add(new HeapSelect());

    }

    @Test
    public void reporterTest() {
        // Genera 10 puntos , para los graficos, cambiando el entero , se agregan o quitan puntos, con esto hacemos el grafico
        // mide el tiempo, en un vector random de 8 , 16, 32 .... , con k = n/2 , lo que imprime , son los tiempos en nanosecons
        Reporter reporter = new Reporter(10,this.statistics);
        HashMap<String,ArrayList<String>> information = reporter.getTotalInformation();

        System.out.println("Vector sizes");
        System.out.println(reporter.getVectorSizes());
        System.out.println("Time per algorithm");
        for (Map.Entry entry : information.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
