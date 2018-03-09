package Lists.Stack.Queues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class HANLinkedListTest {

    private HANLinkedList<Integer> sut;

    @Before
    public void initialize(){
        sut = new HANLinkedList<>();
    }

    @Test
    public void initializingLinkedListCreatesHead(){
        HANLinkedList<Integer> list = new HANLinkedList<>();

        assertNotNull(list.head);
    }

    @Test
    public void addFirstValue(){
        sut.addFirst(1);

        Node<Integer> result = sut.head.getNextNode();

        assertNotNull(result);
        assertEquals(result.getValue(), new Integer(1));
    }

    @Test
    public void addFirstValueToFrontAndKeepOtherValue(){
        sut.addFirst(1);
        sut.addFirst(2);

        Node<Integer> result = sut.head.getNextNode();

        assertNotNull(result);
        assertEquals(result.getValue(), new Integer(2));
        assertNotNull(result.getNextNode());
        assertEquals(result.getNextNode().getValue(), new Integer(1));
    }

    @Test
    public void removeFirstValue(){
        sut.addFirst(1);
        sut.removeFirst();

        assertNull(sut.head.getNextNode());
    }

    @Test
    public void removeFirstValueAndChangeReferenceOfSecond(){
        sut.addFirst(1);
        sut.addFirst(2);

        sut.removeFirst();

        Node<Integer> result = sut.head.getNextNode();

        assertNotNull(result);
        assertEquals(result.getValue(), new Integer(1));
    }

    @Test
    public void insertValueToDefinedIndex(){
        sut.addFirst(1);
        sut.addFirst(2);

        sut.insert(1, 3);

        Node<Integer> result = sut.head.getNextNode().getNextNode();

        assertNotNull(result);
        assertEquals(result.getValue(), new Integer(3));
    }

    @Test
    public void deleteByDefinedIndex(){
        sut.addFirst(1);
        sut.addFirst(2);

        sut.delete(1);

        Node<Integer> result = sut.head.getNextNode().getNextNode();
        assertNull(result);
    }

    @Test
    public void deleteByDefinedIndexKeepsOtherReferences(){
        sut.addFirst(1);
        sut.addFirst(2);
        sut.addFirst(3);

        sut.delete(1);

        Node<Integer> result = sut.head.getNextNode().getNextNode();
        assertNotNull(result);
        assertEquals(result.getValue(), new Integer(1));
    }

    @Test
    public void getReturnsIntByDefinedIndex(){
        sut.addFirst(1);
        sut.addFirst(2);
        sut.addFirst(3);

        Integer result = sut.get(1);

        assertEquals(result, new Integer(2));
    }
}
