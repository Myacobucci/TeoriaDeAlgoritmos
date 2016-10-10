package statistic;

import org.junit.Before;
import org.junit.Test;
import reporter.Reporter;

import java.util.ArrayList;

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
        Reporter reporter = new Reporter(7500,statistics);
        reporter.generateReport();
    }
}
