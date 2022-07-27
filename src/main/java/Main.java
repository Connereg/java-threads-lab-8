import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(9);
        List<Future> listOfStringFutures = new ArrayList<>();


        listOfStringFutures.add(executor.submit(() -> " The Future is extremely bright!"));
        listOfStringFutures.add(executor.submit(() -> " The Future is now old man!"));
        listOfStringFutures.add(executor.submit(() -> " The Future will one day be present."));
        listOfStringFutures.add(executor.submit(() -> " The Future is extremely bright!"));
        listOfStringFutures.add(executor.submit(() -> " The Future is now old man!"));
        listOfStringFutures.add(executor.submit(() -> " The Future will one day be present."));

        Future<String> futureString4 = executor.submit(() -> (" The Future is extremely DARK!"));
        Future<String> futureString5 = executor.submit(() -> " The Future is now young man!");
        Future<String> futureString6 = executor.submit(() -> " The Future will one day be past.");


        listOfStringFutures.add(futureString4);
        listOfStringFutures.add(futureString5);
        listOfStringFutures.add(futureString6);

        System.out.println("Count finished before thread sleep: " + countFinishedFutures(listOfStringFutures));
        Thread.sleep(200);
        System.out.println("Count finished AFTER thread sleep: " + countFinishedFutures(listOfStringFutures));


//        System.out.println("Now we can call for future values: " + futureString1.get() + futureString2.get() + futureString3.get());

    }
    public static int countFinishedFutures(List<Future> futures) {
        // your code here
        int futureNum = 0;
        for (Future future : futures) {
            if (future.isDone()) {
                futureNum++;
            }
        }
        return futureNum;

    }
}
