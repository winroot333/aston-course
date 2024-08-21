package homework2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//        1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
//        к большей).

        System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).");
        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()))
                .toList();
        list.forEach(System.out::println);

//        2. Вывести список неповторяющихся городов, в которых работают трейдеры.

        System.out.println("\n2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

//        3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.

        System.out.println("\n3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .forEach(System.out::println);

//        4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
//        порядке.

        System.out.println("\n4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
        Optional<String> traders = transactions.stream().map(transaction -> transaction.getTrader().getName())
                .sorted()
                .distinct()
                .reduce((o1, o2) -> o1 + " " + o2);
        traders.ifPresent(System.out::println);

//        5. Выяснить, существует ли хоть один трейдер из Милана.

        System.out.println("\n5. Выяснить, существует ли хоть один трейдер из Милана.");
        boolean result = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Cambridge"));
        System.out.println(result ? "Есть трейдер из Милана" : "Нет трейдеров из Милана");

//        6. Вывести суммы всех транзакций трейдеров из Кембриджа.

        System.out.println("\n6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue())
                .forEach(System.out::println);

        int cambridgeSum = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(transaction -> transaction.getValue())
                .sum();
        System.out.println("Сумма транзакций из Кембриджа: " + cambridgeSum);

//        7. Какова максимальная сумма среди всех транзакций?

        System.out.println("\n7. Какова максимальная сумма среди всех транзакций?");
        Optional<Integer> maxSum = transactions.stream()
                .map(transaction -> transaction.getValue())
                .max((o1, o2) -> Integer.compare(o1, o2));
        //                .max(Integer::compare);
        System.out.println(maxSum.get());

//        8. Найти транзакцию с минимальной суммой.

        System.out.println("\n8. Найти транзакцию с минимальной суммой.");
        Optional<Transaction> minTransact = transactions.stream()
                .min((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()));
        System.out.println(minTransact.get());

    }
}
