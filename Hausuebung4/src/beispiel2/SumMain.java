package beispiel2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class SumMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        ArrayList<Integer> numbers = new ArrayList<>();
        ThreadPoolExecutor executor;
        int sum = 0;

        System.out.println("n");
        int limit = scanner.nextInt();
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(limit);

        for (int i = 0; i < limit; i++)
        {
            numbers.add(i+1);
        }

        List<SumCallable> callableList = new ArrayList<>();

        for (int i = 0; i <= limit/100; i++)
        {
            ArrayList<Integer> chunk = new ArrayList<>();

            for (int j = 100*i; j < (100*i)+100 && j < limit; j++)
            {
                chunk.add(numbers.get(j));
            }

            SumCallable sumCallable = new SumCallable(chunk);
            callableList.add(sumCallable);
        }

        try {
            List<Future<Integer>> results = executor.invokeAll(callableList);

            for (int i = 0; i < results.size(); i++)
            {
                sum += results.get(i).get();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();

        int gaußResult = (int) ((Math.pow(limit, 2) + limit) / 2);

        if (sum == gaußResult)
        {
            System.out.println(sum);
        }
    }
}
