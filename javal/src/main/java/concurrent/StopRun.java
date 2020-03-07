package concurrent;

/**
 * 将一个线程从running的状态改变的方法
 * yield,告诉线程调度器当前可以切换，调度器可以无视，或是检查当钱其他优先级大于等于该线程的线程，然后执行权交给其他线程，
 * 但是此线程仍是runnable
 *
 * sleep，当前线程停止执行一段时间，受制于系统的定时器和调度器，如果没有其他线程要执行，则cpu进入空闲
 *
 * join,等待另一线程执行完毕，自己会进入WAITING
 */
public class StopRun {
}
