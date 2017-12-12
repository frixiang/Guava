package com.xiang.observerExplore;

/**
 * Created by WIN7 on 2017/12/12.
 */
public class Client {
    public static void main(String[] args){
        ObservableT T = new ObservableT();
        ObserverHelper helper = new ObserverHelper();
        /**
         * 为T添加观察者
         */
        T.addObserver(helper);
        T.sendInfo("first explore");
    }
}
