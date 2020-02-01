package com.datalib.linkedlist;

import org.junit.*;

public class SingleLinkedListTest {
    @Test
    public void test_linked_list_addTail_method() {
        LinkedList<String> sll = new LinkedList<>();
        sll.addTail("A");
        Assert.assertEquals(1, sll.size());
    }

    @Test
    public void test_linkedList_removeTail() throws LinkedListIsEmptyException {
        LinkedList<String> sll = new LinkedList<>();
        sll.addTail("A");
        String value = (String) sll.removeTail();
        Assert.assertEquals("A", value);
        Assert.assertEquals(0, sll.size());
    }

    @Test
    public void test_size_many_items() {
        LinkedList<String> sll = new LinkedList<>();
        sll.addTail("A");
        Assert.assertEquals(1, sll.size());
        sll.addTail("B");
        sll.addTail("C");
        Assert.assertEquals(3, sll.size());
        sll.removeHead();
        Assert.assertEquals(2, sll.size());
    }

    @Test
    public void test_size_empty() {
        LinkedList<String> sll = new LinkedList<>();
        Assert.assertEquals(0, sll.size());
    }

    @Test
    public void test_addHead_empty_LinkedList() {
        LinkedList<String> sll = new LinkedList<>();
        sll.addTail("A");
        Assert.assertEquals(1, sll.size());
    }

    @Test
    public void test_addByIndex() {
        LinkedList<String> sll = new LinkedList<>();
        sll.addTail("A");
        sll.addTail("B");
        sll.addTail("D");
        sll.addTail("E");
        sll.addByIndex(2, "C");
        Assert.assertEquals("C", sll.get(2));
        Assert.assertEquals(5, sll.size());
    }

    @Test
    public void test_removeByIndex() {
        LinkedList<String> sll = new LinkedList<>();
        sll.addTail("A");
        sll.addTail("B");
        sll.addTail("D");
        sll.addTail("E");
        sll.remove(2);
        Assert.assertEquals("E", sll.get(2));
        Assert.assertEquals(3, sll.size());
    }
}