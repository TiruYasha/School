package toets;

import les5listsstacksqueues.LinkedList;

public class BlockChain extends LinkedList<Transaction> {
    public BlockChain() {
        header = new BlockChainListNode(null, null, 0);
        size = 0;
    }

    public int getBalance() {
        if (size == 0)
            return 0;//Geen transacties, we gaan uit van een saldo van 0

        // Het huidige saldo staat altijd vooraan:
        return ((BlockChainListNode) header.next).getBalance();
    }

    public void addTransaction(Transaction transaction) {
        if (size == 0) {
            setFirst(new BlockChainListNode(transaction, null, transaction.getAmount()));
        } else {
            int balance = ((BlockChainListNode) header.next).getBalance();
            setFirst(new BlockChainListNode(transaction, ((BlockChainListNode) header.next), balance + transaction.getAmount()));
        }
        size++;
        //vraag b
    }

    /**
     * Vraag d
     * Validates the complete blockchain; e.g. EVERY node must be the sum of its own and previous transactions.
     *
     * @return true when every node in the chain is the sum of its own and previous transactions.
     */
    public boolean validate() {
        if (size == 0)
            return true;

        BlockChainListNode tmpNode = ((BlockChainListNode) header.next);
        for (int i = 0; i < size; i++) {
            int balance = ((BlockChainListNode) tmpNode).getBalance();
            BlockChainListNode tmpNode2 = tmpNode;
            for (int j = i; j < size; j++) {
                balance -= tmpNode2.getValue().getAmount();
                tmpNode2 = (BlockChainListNode) tmpNode2.next;
            }
            if(balance != 0) {
                return false;
            }
            tmpNode = (BlockChainListNode) tmpNode.next;
        }
        return true;
    }


    public static void main(String[] arg) {
        Transaction a = new Transaction(4);
        Transaction b = new Transaction(5);
        Transaction c = new Transaction(6);

        BlockChain bc = new BlockChain();
        bc.addTransaction(a);
        bc.addTransaction(b);
        bc.addTransaction(c);

        if (bc.validate()) {
            System.out.println("Validates!, total balance: " + bc.getBalance());
        } else {
            System.out.println("Error in blockchain. Balance does not match transactions");
        }

        // Evil hacker:
        bc.delete(1);

        if (bc.validate()) {
            System.out.println("Validates!");
        } else {
            System.out.println("Error in blockchain. Balance does not match transactions");
        }
    }
}
