package com.xiang.observerExplore;

import java.util.Observable;

/**
 * Created by WIN7 on 2017/12/12.
 */
public class ObservableT extends Observable {
    public void sendInfo(String info){
        System.out.println(info);
        setChanged();
        notifyObservers(info);
    }
}
