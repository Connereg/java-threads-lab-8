import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<Future> listOfFutures = new ArrayList<>();


    for (int i = 0; i < 7; i++) {
        Future<Integer> futureInt = executor.submit(() -> {
            Random randInt = new Random();
            int num = randInt.nextInt(100);
            return num;
        });
        // INSIDE LOOP, BUT OUTSIDE INSTANCIATION OF futureInt
        listOfFutures.add(futureInt);
    }


        listOfFutures.get(4).cancel(true);
        listOfFutures.get(5).cancel(true);
        listOfFutures.get(3).cancel(true);

        for(Future f: listOfFutures){
            if(!f.isCancelled()){
                f.get();
            }
        }

        System.out.println("Count finished before thread sleep: " + countFinishedFutures(listOfFutures));
        Thread.sleep(200);
        System.out.println("Count finished AFTER thread sleep: " + countFinishedFutures(listOfFutures));

    }

    public static int countFinishedFutures(List<Future> futures) {
    // ROTE CODE (NON-STREAM) COMMENTED OUT
//        int futureNum = 0;
        return (int)futures.stream().filter(future -> !future.isCancelled()).filter(future -> future.isDone()).count();

//        for (Future future : futures) {
//            if (!future.isCancelled()) {
//                if (future.isDone()) {
//                    futureNum++;
//                }
//            }
//        }
//        return futureNum;
    }
}
