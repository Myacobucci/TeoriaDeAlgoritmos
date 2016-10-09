package reporter;

import statistic.IStatistic;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * Created by juan on 08/10/16.
 */
public class Reporter {
    private final ArrayList<Integer> arrayList = new ArrayList<>();
    private final ArrayList<Integer> sortArrayList = new ArrayList<>();
    private final ArrayList<Integer> invertedSortArrayList = new ArrayList<>();
    private ArrayList<IStatistic> statistics;
    private final HashMap<String,String> information = new HashMap<>();

    public Reporter(Integer size, ArrayList<IStatistic> statistics) {
        this.statistics = statistics;
        Random random = new Random();
        Integer current;
        for (int index = 0 ; index < size ; index ++) {
            current = random.nextInt();
            arrayList.add(current);
            sortArrayList.add(current);
            invertedSortArrayList.add(current);
        }
        Collections.sort(sortArrayList);
        Collections.sort(invertedSortArrayList);
        Collections.reverse(invertedSortArrayList);
    }

    public void generateReport() {
        Integer k = 0;
        for (IStatistic statistic : statistics) {
            Instant start = Instant.now();
            statistic.getKelement(k,arrayList);
            Instant finish = Instant.now();
            information.put(statistic.getClass().getName() + "/Random/k = " + k, Duration.between(start,finish).toString());
            start = Instant.now();
            statistic.getKelement(k,sortArrayList);
            finish = Instant.now();
            information.put(statistic.getClass().getName() + "/Sort/k = " + k, Duration.between(start,finish).toString());
            start = Instant.now();
            statistic.getKelement(k,invertedSortArrayList);
            finish = Instant.now();
            information.put(statistic.getClass().getName() + "/Inverted Sort/k = " + k, Duration.between(start,finish).toString());
        }
        k = arrayList.size() - 1;
        for (IStatistic statistic : statistics) {
            Instant start = Instant.now();
            statistic.getKelement(k,arrayList);
            Instant finish = Instant.now();
            information.put(statistic.getClass().getName() + "/Random/k = " + k, Duration.between(start,finish).toString());
            start = Instant.now();
            statistic.getKelement(k,sortArrayList);
            finish = Instant.now();
            information.put(statistic.getClass().getName() + "/Sort/k = " + k, Duration.between(start,finish).toString());
            start = Instant.now();
            statistic.getKelement(k,invertedSortArrayList);
            finish = Instant.now();
            information.put(statistic.getClass().getName() + "/Inverted Sort/k = " + k, Duration.between(start,finish).toString());
        }

        k = arrayList.size() / 2;
        for (IStatistic statistic : statistics) {
            Instant start = Instant.now();
            statistic.getKelement(k,arrayList);
            Instant finish = Instant.now();
            information.put(statistic.getClass().getName() + "/Random/k = " + k, Duration.between(start,finish).toString());
            start = Instant.now();
            statistic.getKelement(k,sortArrayList);
            finish = Instant.now();
            information.put(statistic.getClass().getName() + "/Sort/k = " + k, Duration.between(start,finish).toString());
            start = Instant.now();
            statistic.getKelement(k,invertedSortArrayList);
            finish = Instant.now();
            information.put(statistic.getClass().getName() + "/Inverted Sort/k = " + k, Duration.between(start,finish).toString());
        }

        for (Map.Entry entry : information.entrySet()) {
            System.out.printf("(%s,%s)\n",entry.getKey(),entry.getValue());
        }
    }

}
