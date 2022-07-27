import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future> listOfStringFutures = new ArrayList<>();

        Future<String> futureString1 = executor.submit(() -> ("The Future is extremely bright!"));

        Future<String> futureString2 = executor.submit(() -> "The Future is now old man!");

        Future<String> futureString3 = executor.submit(() -> "The Future will one day be present.");

        listOfStringFutures.add(futureString1);
        listOfStringFutures.add(futureString2);
        listOfStringFutures.add(futureString3);

        System.out.println(countFinishedFutures(listOfStringFutures));

    }
    public static int countFinishedFutures(List<Future> futures) {
        // your code here
        int futureNum = 0;
        for (Future future : futures) {
            futureNum++;
        }
        return futureNum;

    }
}

//Future
//        We can submit tasks which implement the Callable interface to an executor but the submit method doesn’t return the result of the task since it is executed asynchronously. The submit method instead returns a Future object.
//
//        The Future interface has the following methods:
//
//        get: A blocking call that waits for a task to complete and gets the result. It also accepts a timeout which defines how long it will wait for task completion.
//        cancel: Cancels the task if possible.
//        isDone: It returns true if the task ran successfully.
//        isCancelled: It returns true if the cancel method was called on the task before it finished running.


//import java.util.concurrent.*;
//
//class Example {
//    public static void main(String[] args) throws Exception {
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//
//        Future<Integer> num1 = executor.submit(()-> {
//            try {
//                Thread.sleep(3000);
//                return 1000;
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        Future<Integer> num2 = executor.submit(()-> {
//            try {
//                Thread.sleep(500);
//                return 2000;
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        int result = num1.get() * num2.get();
//        System.out.println(result); // 2000000
//
//        executor.shutdown();
//    }
//}

//    We have created two Callable objects using lambda expressions and passed them to the submit method. When we call the get method on num1 and num2 the program waits for the tasks to complete and return a result before continuing.