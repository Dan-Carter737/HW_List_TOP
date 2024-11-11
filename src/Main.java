import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class Main {
    public static void main(String[] args) {


        List<Transaction> transactionList = Arrays.asList(
                                            new Transaction("Milk bottle 1.5", 5, 87),
                                            new Transaction("Bread", 7, 54),
                                            new Transaction("Butter 220", 2, 189));


        int totalQty = transactionList.stream()
                .mapToInt(Transaction::getQuantity)
                .sum();

        System.out.println("Общее количество проданных единиц всех продуктов " + totalQty );

        double sum = transactionList.stream()
               .mapToDouble(Transaction::getTotalPrice)
               .sum();
        System.out.println("Общая сумма продаж " + sum);

        Transaction maxQuantity = transactionList.stream()
                .max(Comparator.comparingInt(Transaction::getQuantity))
                .orElse(null);

        System.out.println("Продукт с наибольшим количеством продаж " + maxQuantity.getProduct());


        Transaction minQuantity  = transactionList.stream()
                        .min(Comparator.comparingDouble(Transaction::getTotalPrice))
                                .orElse(null);
        System.out.println("Продукт с наименьшей суммой продаж: " + minQuantity.getProduct());

    }



}