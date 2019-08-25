package com.xiongzehua.learning.algorithm.test.miaomiao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by xiongzehua on 2019/5/15.
 */
public class Main {
    static Observable observable = new Observable();
    static Observer observer1 = new Observer1();
    static Observer observer2 = new Observer2();
    static Observer3 observer3 = new Observer3(observable);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        threadPool.execute(() -> {
            observable.signin(observer1);
        });

        threadPool.execute(() -> {
            observable.signin(observer2);
        });

        threadPool.execute(() -> {
            try {
                observable.setMessage("第一个消息");
                Thread.sleep(5 * 1000);
                observable.setMessage("第二个消息");
                Thread.sleep(5 * 1000);
                observable.setMessage("第三个消息");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            observer3.show();
        });
    }
}

interface Observer {
    void show(String message);
}

class Observer1 implements Observer {

    public void show(String message) {
        System.out.println("这里是中华日报观察者，据报道，最新消息是：" + message);
    }
}

class Observer2 implements Observer {

    public void show(String message) {
        System.out.println("这里是苗苗报社观察者，据报道，最新消息是：" + message);
    }
}

class Observer3 {
    String oldMessage = "";
    Observable observable;
    public Observer3(Observable observable) {
        this.observable = observable;
    }
    // 被歧视的公司，不被运行订阅
    public void show() {
        while (true) {
            String message = observable.getMessage();

            if (!oldMessage.equals(message)) {
                System.out.println("这里是被歧视的报社观察者，据报道，最新消息是：" + oldMessage);
                oldMessage = message;

            }
//            System.out.println(oldMessage);

        }
    }
}

class Observable {
    String message;
    List<Observer> observerList = new ArrayList<>();

    public void signin(Observer observer) {
        observerList.add(observer);
    }

    public void signout(Observer observer) {
        observerList.remove(observer);
    }

    public void setMessage(String message) {
        this.message = message;
        for (Observer observer : observerList) {
            observer.show(message);
        }
    }
    public String getMessage() {
        return message;
    }

}