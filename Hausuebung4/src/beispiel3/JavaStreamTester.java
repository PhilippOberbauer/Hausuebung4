package beispiel3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamTester {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("POS");
        strings.add("WMC");
        strings.add("");
        strings.add("hallo");

        System.out.println("Empty Strings: " +  getCountEmptyString(strings));

        System.out.println("Length 3: " + getCountLength3(strings));

        List<String>stringsWithoutEmtpyStrings = deleteEmptyStrings(strings);
        System.out.println("Empty Strings deleted:");
        stringsWithoutEmtpyStrings.forEach(s -> System.out.println(s));

        System.out.println("Merged String: " + getMergedString(strings, ":"));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        List<Integer> squares = getSquares(numbers);
        System.out.println("Squares:");
        squares.forEach(i -> System.out.println(i));

        System.out.println("Max: " + getMax(numbers));

        System.out.println("Min: "  + getMin(numbers));

        System.out.println("Sum: " + getSum(numbers));

        System.out.println("Average: " + getAverage(numbers));
    }

    private static int getCountEmptyString(List<String> strings)
    {
        Stream<String> stream = strings.stream();
        return (int) stream.filter(s -> s.length() == 0).count();
    }

    private static int getCountLength3(List<String> strings)
    {
        Stream<String> stream = strings.stream();
        return (int) stream.filter(s -> s.length() == 3).count();
    }

    private static List<String> deleteEmptyStrings(List<String> strings)
    {
        Stream<String> stream = strings.stream();
        return stream.filter(s -> s.length() != 0).collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String separator)
    {
        Stream<String> stream = strings.stream();
        return stream.reduce("", (s1, s2) -> s1 + separator + s2);
    }

    private static List<Integer> getSquares(List<Integer> numbers)
    {
        Stream<Integer> stream = numbers.stream();
        return stream.map(i -> i * i).collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers)
    {
        Stream<Integer> stream = numbers.stream();
        return stream.mapToInt(i -> i.intValue()).max().getAsInt();
    }

    private static int getMin(List<Integer> numbers)
    {
        Stream<Integer> stream = numbers.stream();
        return stream.mapToInt(i -> i.intValue()).min().getAsInt();
    }

    private static int getSum(List<Integer> numbers)
    {
        Stream<Integer> stream = numbers.stream();
        return stream.mapToInt(i -> i.intValue()).sum();
    }

    private static int getAverage(List<Integer> numbers)
    {
        Stream<Integer> stream = numbers.stream();
        return (int) stream.mapToInt(i -> i.intValue()).average().getAsDouble();
    }
}
