package beispiel1;

import java.util.ArrayList;

public class NumbersRunnable implements Runnable{
    private ArrayList<Integer> chunk;
    private int divider;

    public NumbersRunnable(ArrayList<Integer> chunk, int divisor) {
        this.chunk = chunk;
        this.divider = divisor;
    }

    @Override
    public void run() {
        for (int i : chunk)
        {
            if (i % divider == 0)
            {
                System.out.println(i);
            }
        }
    }
}
