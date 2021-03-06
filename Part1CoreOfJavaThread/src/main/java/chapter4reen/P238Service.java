/***********************************************************
 * @Description : 读共享，写独占.
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/10 下午10:31
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter4reen;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class P238Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write(){
        try {
            lock.writeLock().lock();
            System.out.println("获得写锁："+Thread.currentThread().getName()+" "+System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
