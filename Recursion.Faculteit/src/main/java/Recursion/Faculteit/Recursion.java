package Recursion.Faculteit;

import java.util.ArrayList;

public class Recursion {

    public static int faculteit(int faculteitOf) {
        if (faculteitOf < 1) {
            return 1;
        } else {
            return faculteitOf * faculteit(faculteitOf - 1);
        }
    }

    public static int sum(int sumOf) {
        if (sumOf == 0) {
            return 0;
        } else {
            return sumOf + sum(sumOf - 1);
        }
    }

    public void test(){
        ArrayList<Person> studentList = new ArrayList<Student>();
    }

}
