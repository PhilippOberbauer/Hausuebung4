import java.util.ArrayList;

public class NumbersRunnable implements Runnable{
    private ArrayList<Integer> numbers;
    private int divisor;

    public NumbersRunnable(ArrayList<Integer> numbers, int divisor) {
        this.numbers = numbers;
        this.divisor = divisor;
    }

    @Override
    public void run() {
        for (int i : numbers)
        {
            if (i % divisor == 0)
            {
                System.out.println(i);
            }
        }
    }
}
