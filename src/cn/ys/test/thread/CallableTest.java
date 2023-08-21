package cn.ys.test.thread;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author YS
 * @date 2023/8/21 13:49
 * @Description
 */
public class CallableTest implements Callable<Boolean> {

    private String url;
    private String name;

    public CallableTest() {
    }

    public CallableTest(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(this.url, this.name);
        System.out.println(this.name);
        return true;
    }


    public static void main(String[] args) {
        String url = "https://img0.utuku.china.com/0x0/ent/20161011/7232c15c-7bff-45c8-9a62-db0983e56a07.jpg";
        CallableTest testThread1 = new CallableTest(url, "c1.jpg");
        CallableTest testThread2 = new CallableTest(url, "c2.jpg");
        CallableTest testThread3 = new CallableTest(url, "c3.jpg");
        CallableTest testThread4 = new CallableTest(url, "c4.jpg");

        // 创建按执行服务
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Boolean> submit1 = service.submit(testThread1);
        Future<Boolean> submit2 = service.submit(testThread2);
        Future<Boolean> submit3 = service.submit(testThread3);
        Future<Boolean> submit4 = service.submit(testThread4);
        try {
            System.out.println(submit1.get());
            System.out.println(submit2.get());
            System.out.println(submit3.get());
            System.out.println(submit4.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdownNow();
    }
}

class WebDownloader {
    // 下载方法
    public void download(String url, String name) throws IOException {
        //模拟已经下载
        System.out.println("开始下载" + name);
    }
}
