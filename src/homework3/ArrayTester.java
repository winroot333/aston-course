package homework3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ArrayTester {
    public static void main(String[] args) {

        MyList<Double> superList = new MyArrayList<>();
        superList.add(0.5523);
        superList.add(3.5523);
        superList.add(2.5523);
        superList.add(4.5523);
        superList.add(7.5523);
        superList.add(3.5523);
//        MyArrayList.staticSort(superList);
        printList((MyArrayList) superList);

        superList.add(0.5523);
        superList.add(3.5523);
        superList.add(2.5523);
        superList.add(4.5523);
        superList.add(7.5523);
        ((MyArrayList<Double>) superList).bubbleSort(Double::compareTo);
        printList((MyArrayList) superList);

        List<Object> list2 = new ArrayList<>();
        list2.add(0.5523);
        list2.add(2);
        list2.add(3);
//        MyArrayList.staticSort(list2);

        List<String> listToAdd = new ArrayList<>();
        listToAdd.add("1");
        listToAdd.add("3");
        listToAdd.add("5");
        listToAdd.add("99");

        MyArrayList<String> list3 = new MyArrayList<>(listToAdd);
        printList(list3);
        list3.remove(3);
        printList(list3);
        list3.remove(0);
        printList(list3);

        System.out.println("static sort");
        List<String> list4 = new ArrayList<>();
        list4.add("5");
        list4.add("3");
        list4.add("1");
        list4.add("4");
        list4.add("1");
        MyArrayList.staticSort(list4);
        list4.forEach(System.out::println);

    }

    public static void printList(MyList list) {
        System.out.println("List size: " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
