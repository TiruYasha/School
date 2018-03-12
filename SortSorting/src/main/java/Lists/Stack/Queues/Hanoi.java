package Lists.Stack.Queues;

public class Hanoi {
    HANStack<Integer> startStack;
    HANStack<Integer> middleStack;
    HANStack<Integer> destinationStack;

    public Hanoi(){
        startStack = new HANStack<>();
        middleStack = new HANStack<>();
        destinationStack = new HANStack<>();
    }

    public void hanoi(int amount){
        for(int i = amount; i > 0; i--) {
            startStack.push(i);
        }

        hanoi(amount, startStack, destinationStack);
    }

    private void hanoi(int amount, HANStack<Integer> startStack, HANStack<Integer> destinationStack) {
        if(amount == 1){
            destinationStack.push(startStack.pop());
        }else{
            hanoi(amount - 1, startStack, middleStack);
            hanoi(1, startStack, destinationStack);
            hanoi(amount - 1, middleStack, destinationStack);
        }
    }
}
