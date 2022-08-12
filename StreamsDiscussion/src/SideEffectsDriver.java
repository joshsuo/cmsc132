
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SideEffectsDriver {
	
    static List<Integer> lst = List.of(-1, 5, 3, 2, -5, 2, -3, 1);

    public static void main(String[] args) {
        /*
         * This file contains intentionally bad code to highlight some of the
         * quirks of the Stream API. The Stream API's quirks arise from making
         * it more optimized and more parallelizable.
         */
        // sideEffects1();
        // sideEffects2();
        // sideEffects3();
        // sideEffects4();
    }
    
    static void sideEffects1() {
        /*
         * Streams are "lazily" evaluated, meaning operations are only
         * performed on an as-needed basis, upon a terminal operation.
         */
        // filter is non terminal
        Stream<Integer> filteredStream = lst.stream().filter(i -> {
            System.out.print(i + " ");
            return i > 0;
        });
        System.out.println("We filtered the numbers!...Or did we...");
        // collect is terminal
        List<Integer> positiveInts = filteredStream.collect(Collectors.toList());
        System.out.println("List: " + positiveInts);
    }

    static void sideEffects2() {
        /*
         * Something is a "side-effect" if it produces a change outside of the
         * current scope. Using System.out.print is a side-effect because it
         * produces output to the console (which is outside of the scope of
         * the lambda). Here's another (admittedly contrived) example of a side
         * effect.
         */
        List<Integer> negativeInts = new ArrayList<>();
        Stream<Integer> filteredStream = lst.stream().filter(i -> {
            if (i < 0) negativeInts.add(i); // negativeInts is outside of scope
            return i > 0;
        });
        System.out.println("Negative numbers: " + negativeInts);
        List<Integer> positiveInts = filteredStream.collect(Collectors.toList());
        System.out.println("Positive list: " + positiveInts);
        System.out.println("Negative numbers: " + negativeInts);
        
        // Note: if you actually wanted to do something like this:
        // var negativeInts = lst.stream().filter(i -> i < 0).collect(Collectors.toList());
        // var positiveInts = lst.stream().filter(i -> i > 0).collect(Collectors.toList());
    }

    static void sideEffects3() {
        /*
         * Because the Streams API doesn't guarantee when operations are
         * performed, it's frowned upon to perform actions that have side
         * effects in intermediate operations. It's OK in terminal
         * operations though! Even then, there are some gotchas (outside of
         * scope of discussion; see documentation).
         */
        lst.stream().forEach(i -> System.out.println("forEach: " + i));
        System.out.println("forEach finished.");
    }

    static void sideEffects4() {
        /*
         * In some cases, side effects won't run at all if they can be
         * optimized away. The map method doesn't affect how many elements
         * are in the stream, so the lambda is never executed when count is
         * called.
         */
        Stream<Integer> countMe = lst.stream().map(i -> {
            System.out.println("map: " + i);
            return i * 2;
        });
        System.out.println("map finished?");
        System.out.println(countMe.count());
    }
    
}
