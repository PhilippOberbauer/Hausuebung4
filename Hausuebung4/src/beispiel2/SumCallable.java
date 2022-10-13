package beispiel2;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class SumCallable implements Callable<Integer> {
    private ArrayList<Integer> numbers;

    public SumCallable(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        for (int i : numbers)
        {
            sum += i;
        }

        return sum;
    }
}
