package beispiel1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class NumbersMain {
    public static void main(String[] args) { //todo: Ausgaben (Zahlen) überprüfen
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        ThreadPoolExecutor executor;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("numbers.csv"));
            String line = reader.readLine();

            while (line != null)
            {
                String[] arr = line.split(":");
                for (int i = 0; i < arr.length; i++)
                {
                    try
                    {
                        numbers.add(Integer.parseInt(arr[i]));
                    }
                    catch (NumberFormatException e)
                    {

                    }
                }
                line = reader.readLine();
            }

            System.out.println("chunks:");
            int chunks = scanner.nextInt();
            System.out.println("divider:");
            int divider = scanner.nextInt();
            executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(chunks);
            int chunkSize = numbers.size() / chunks;

            for (int i = 0; i < chunks; i++)
            {
                ArrayList<Integer> chunk = new ArrayList<>();

                for (int j = chunkSize * i; j< (chunkSize*i)+chunkSize; j++)
                {
                    chunk.add(numbers.get(j));
                }

                NumbersRunnable numbersRunnable = new NumbersRunnable(chunk, divider);
                executor.execute(numbersRunnable);
            }

            executor.shutdown();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}