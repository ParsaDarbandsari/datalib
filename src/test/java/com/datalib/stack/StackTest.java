package com.datalib.stack;

import org.junit.*;

public class StackTest {

    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack<String>(3);
    }

    @Test
    public void test_stack_cannot_push_items_when_full() {
        try {
            stack.push("A");
            stack.push("B");
            stack.push("C");
            stack.push("D");
            Assert.fail("Exception wasn't thrown");
        }
        catch (StackIsFullException sfe) {
            // If Exception is thrown, this test is passed
        }
    }

    @Test
    public void test_stack_cannot_pop_items_when_empty() {
        try {
            stack.pop();
            Assert.fail();
        }
        catch (StackIsEmptyException see){
            // If Exception is thrown, this test is passed
        }
    }

    @Test
    public void test_stack_push_and_pop() throws StackIsFullException, StackIsEmptyException {
        stack.push("A");
        stack.push("B");
        String pop = (String) stack.pop();
        Assert.assertEquals("B", pop);
    }

    @Test
    public void test_top() throws StackIsFullException {
        stack.push("A");
    }

    @Test
    public void test_top_full_stack() throws StackIsFullException, StackIsEmptyException {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        String t = (String) stack.top();
        String p = (String) stack.pop();
        Assert.assertEquals("C", t);
        Assert.assertEquals("C", p);
    }
}
