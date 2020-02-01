package com.datalib.queue;

import org.junit.*;

public class QueueTest {

    private Queue queue;

    @Before
    public void setUp() {
        queue = new Queue(3);
    }

    @Test
    public void test_queue_is_full() {
        try {
            queue.enqueue("B");
            queue.enqueue("A");
            queue.enqueue("C");
            queue.enqueue("D");
            Assert.fail("Exception wasn't thrown");
        }
        catch (QueueIsFullException qfe) {
            // If Exception is thrown, this test is passed
        }
    }

    @Test
    public void test_queue_cannot_be_dequeued_when_empty() {
        try {
            queue.dequeue();
            Assert.fail("Exception wasn't thrown");
        }
        catch(QueueIsEmptyException qee) {
            // If Exception is thrown, this test is passed
        }
    }

    @Test
    public void test_queue_circular_buffer_working() {
        try {
            queue.enqueue("A");
            queue.enqueue("B");
            queue.enqueue("C");
            queue.dequeue();
            queue.dequeue();
            queue.enqueue("D");
            queue.enqueue("E");
            // If Exception is not thrown, this test is passed
        }
        catch (QueueIsFullException | QueueIsEmptyException | ArrayIndexOutOfBoundsException queueException) {
            Assert.fail("Exception thrown");
        }
    }
}
