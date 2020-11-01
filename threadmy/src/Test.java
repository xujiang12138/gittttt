import java.util.concurrent.Semaphore;

/**
 * @author xujiang
 */
public class Test {

    public static void main(String[] args) {
      new Thread(new Station("窗口1")).start();
        new Thread(new Station("窗口2")).start();
        new Thread(new Station("窗口3")).start();
    }

    public static class Station extends Thread {
        public Station(String name) {
            super(name);
        }

        static int tickers = 1;
        static Object ob = "aa";//指定一个共用对象

        //重写run操作，实现卖票
        @Override
        public void run() {
            // TODO Auto-generated method stub
            super.run();
            while (tickers <= 20) {
                synchronized (ob) {
                    if (tickers <= 20) {
                        System.out.println(getName() + ":卖出了第" + tickers + "张票");
                        tickers++;
                    } else {
                        System.out.println("票卖完了");
                    }
                }
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


    }
}

