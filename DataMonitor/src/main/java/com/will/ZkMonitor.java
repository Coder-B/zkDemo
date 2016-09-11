package com.will;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by 11654 on 2016/9/3.
 */
public class ZkMonitor implements Runnable{
    public static void main(String[] args){
        Thread zkThread=new Thread(new ZkMonitor());
        zkThread.start();
        try {
            zkThread.join();
        }catch (InterruptedException e){

        }
    }

    public void run(){
        try {

            ZooKeeper zk = new ZooKeeper("10.4.1.243:2182", 10000, new ZkWatcher());
            ZkWatcher nodeWatcher=new ZkWatcher();
            Stat stat=zk.exists("/znode1",nodeWatcher);
            System.out.println(String.format("Czxid:%d,Mzxid:%d,Pzxid:%d",stat.getCzxid(),stat.getMzxid(),stat.getPzxid()));
            System.out.println(String.format("Ctime:%d,Mtime:%d,numchld:%d",stat.getCtime(),stat.getMtime(),stat.getNumChildren()));
        }catch (IOException e){
            e.printStackTrace(System.err);
        }catch (InterruptedException e){
            e.printStackTrace(System.err);
        }catch (KeeperException e){
            e.printStackTrace(System.err);
        }
    }
}
