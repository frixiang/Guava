package com.xiang.observerExplore;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by WIN7 on 2017/12/12.
 * 设计模式之观察者模式探索
 */
public class ObserverHelper implements Observer {
    public void update(Observable o, Object arg) {
        System.out.println("观察者" + arg.toString());
    }
}
