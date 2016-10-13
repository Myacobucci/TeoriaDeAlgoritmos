package reporter;

import com.google.common.base.Stopwatch;
import statistic.IStatistic;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by juan on 08/10/16.
 */
public class Reporter {
    private ArrayList<Integer> arrayList;
    private ArrayList<IStatistic> statistics;
    private final HashMap<String,ArrayList<String>> information = new HashMap<>();
    private Integer totalPoints;
    private Integer initialSize;
    private final ArrayList<Integer> vectorSizes = new ArrayList<>();

    public Reporter(Integer totalPoints, ArrayList<IStatistic> statistics) {
        this.totalPoints = totalPoints;
        this.statistics = statistics;
        this.initialSize = 8;
        vectorSizes.add(initialSize);
    }

    private void generateRandomArray(Integer size) {
        this.arrayList = new ArrayList<>();
        Random random = new Random();
        Integer current;
        for (int index = 0; index < size ; index++) {
            current = random.nextInt();
            arrayList.add(current);
        }
    }

    private void generateReport() {

        Integer k = arrayList.size() / 2;
        for (IStatistic statistic : statistics) {
            long start = System.nanoTime();
            statistic.getKelement(k,arrayList);
            long finish = System.nanoTime();
            if (!information.containsKey(statistic.getClass().getName())) {
                information.put(statistic.getClass().getName(),new ArrayList<>());
            }
            information.get(statistic.getClass().getName()).add(Long.toString(finish - start));
        }
    }

    public HashMap<String,ArrayList<String>> getTotalInformation() {

        for (int index = 0 ; index < totalPoints ; index++) {
            generateRandomArray(this.initialSize);
            generateReport();
            this.initialSize = this.initialSize * 2;
            vectorSizes.add(initialSize);
        }
        return this.information;
    }

    public ArrayList<Integer> getVectorSizes() {
        return this.vectorSizes;
    }

}
