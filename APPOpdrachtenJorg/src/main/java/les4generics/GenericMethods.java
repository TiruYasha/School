package les4generics;

public class GenericMethods {


    public static <T extends Comparable<? super T>> T min(T[ ] a){
        int minIndex = 0;

        for (int i = 1; i < a.length; i++) {
            if( a[i].compareTo(a[minIndex]) < 0){   // <0 kleiner dan
                minIndex = i;
            }
        }
        return a[minIndex];
    }

    public static void main(String[] args) {
        String[] strings = {"A", "B" , "C" , "D"};
        System.out.println(min(strings));
    }
}
