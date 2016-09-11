package com.will;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by 11654 on 2016/9/10.
 */
public class ZkWatcher implements Watcher {
    public void process(WatchedEvent event){
        String path = event.getPath();
        System.out.println(String.format("event path：%s",path));
        System.out.println(String.format("keeper stat：%s",event.getState().toString()));
        System.out.println(String.format("eventType：%s",event.getType().toString()));
    }
}
