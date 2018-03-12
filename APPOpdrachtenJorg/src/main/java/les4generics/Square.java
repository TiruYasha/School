package les4generics;

public class Square extends Shape implements Comparable<Square> {

    public int compareTo(Square o) {
        if(this.area > o.area){
            return 1;
        }
        if (this.area < o.area){
            return -1;
        }
        return 0;
    }

}
