package leetcode;


import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 11:45 AM 2018/9/27
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 * <p>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 * <p>
 * Your implementation should support following operations:
 * <p>
 * MyCircularQueue(k): Constructor, set the size of the queue to be k.
 * Front: Get the front item from the queue. If the queue is empty, return -1.
 * Rear: Get the last item from the queue. If the queue is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 * deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 * isEmpty(): Checks whether the circular queue is empty or not.
 * isFull(): Checks whether the circular queue is full or not.
 * <p>
 * <p>
 * Example:
 * <p>
 * MyCircularQueue circularQueue = new MycircularQueue(3); // set the size to be 3
 * circularQueue.enQueue(1);  // return true
 * circularQueue.enQueue(2);  // return true
 * circularQueue.enQueue(3);  // return true
 * circularQueue.enQueue(4);  // return false, the queue is full
 * circularQueue.Rear();  // return 3
 * circularQueue.isFull();  // return true
 * circularQueue.deQueue();  // return true
 * circularQueue.enQueue(4);  // return true
 * circularQueue.Rear();  // return 4
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Queue library.
 */
public class MyCircularQueue {
    int[] data;
    int size;
    int front, rear;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        data = new int[k];
        size = k;
        front = -1;
        rear = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if(isEmpty()){
            front = 0;
        }

        rear = (rear + 1) % size;
        data[rear] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (rear == front) {
            front = -1;
            rear = -1;
            return true;
        }

        front = (front + 1) % size;

        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[front];

    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[rear];

    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        Assert.assertEquals(circularQueue.enQueue(1), true);  // return true
        Assert.assertEquals(circularQueue.enQueue(2), true);  // return true
        Assert.assertEquals(circularQueue.enQueue(3), true);  // return true
        Assert.assertEquals(circularQueue.enQueue(4), false);  // return false, the queue is full
        Assert.assertEquals(circularQueue.Rear(), 3);  // return 3
        Assert.assertEquals(circularQueue.isFull(), true);  // return true
        Assert.assertEquals(circularQueue.deQueue(), true);  // return true
        Assert.assertEquals(circularQueue.enQueue(4), true);  // return true
        Assert.assertEquals(circularQueue.Rear(), 4);  // return 4
    }
}
