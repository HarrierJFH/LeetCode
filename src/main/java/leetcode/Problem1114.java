package leetcode;

public class Problem1114 {

    private static class Foo {

        private boolean b1 = false;
        private boolean b2 = false;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            b1 = true;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            for (;;) {
                if (b1) {
                    break;
                } else {
                    Thread.yield();
                }
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            b2 = true;
        }

        public void third(Runnable printThird) throws InterruptedException {
            for (;;) {
                if (b2) {
                    break;
                } else {
                    Thread.yield();
                }
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
