import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] array1 = new int[] {1, 33, 23, 15, 10, 57, 12, 11};
        int[] array2 = new int[] {5, 22, 76, 10, 12, 53, 4, 28};
        Double aver1 = Arrays.stream(array1).asDoubleStream().average().orElse(0.0);
        Double aver2 = Arrays.stream(array2).asDoubleStream().average().orElse(0.0);

        ArrayList<Double> sumX = new ArrayList<>();
        Arrays.stream(array1).asDoubleStream().map((x) -> x - aver1).forEach(sumX::add);
        ArrayList<Double> sumY = new ArrayList<>();
        Arrays.stream(array2).asDoubleStream().map((y) -> y - aver2).forEach(sumY::add);

        Double sumUp = IntStream.range(0, sumX.size()).mapToDouble(i -> sumX.get(i) * sumY.get(i)).sum();
        Double sumXpow = sumX.stream().mapToDouble(x -> Math.pow(x, 2)).sum();
        Double sumYpow = sumY.stream().mapToDouble(y -> Math.pow(y, 2)).sum();
        Double sqrtDown = Math.sqrt(sumYpow * sumXpow);

        System.out.println("Корреляция Пирсона для двух заданных массивов равна = " + sumUp/sqrtDown);
    }
}