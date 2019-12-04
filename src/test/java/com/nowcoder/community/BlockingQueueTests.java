package com.nowcoder.community;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Song Weiwei
 * @date 2019-12-04
 * 阻塞队列
 */

// 测试阻塞队列
public class BlockingQueueTests {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        new Thread(new Producer(queue)).start();    //创建生产者线程
        new Thread(new Consumer(queue)).start();    //创建消费者线程
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

// 生产者
class Producer implements Runnable {

    private BlockingQueue<Integer> queue;   //接收阻塞队列

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(20);
                queue.put(i);
                System.out.println(Thread.currentThread().getName() + "生产" + queue.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//消费者
class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;   //接收阻塞队列

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(new Random().nextInt(1000));
                queue.take();
                System.out.println(Thread.currentThread().getName() + "消费" + queue.size());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}