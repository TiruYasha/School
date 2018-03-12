package les5listsstacksqueues;

public class TorensVanHanoi<AnyType> {

    private Stack<AnyType> stok;

    public TorensVanHanoi() {
        stok = new Stack<>();
    }

    public int Hanoi(Stack<AnyType> bronStok) {
        return Hanoi(bronStok.getSize(), bronStok, new Stack<AnyType>());
    }

    private int Hanoi(int aantal, Stack<AnyType> bronStok, Stack<AnyType> doelStok) {
        if(aantal == 1) {
            doelStok.push(bronStok.topAndPop());
            return 1;
        } else {
            int value = Hanoi(aantal - 1, bronStok, stok);
            value += Hanoi(1, bronStok, doelStok);
            value += Hanoi(aantal - 1, stok, doelStok);
            return value;
        }
    }
}
