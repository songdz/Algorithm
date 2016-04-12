package com.songdz.question02;

/**
 *
 * 实现Singleton 内部类方式
 *
 * Created by SongDz on 2016/3/17.
 *
 * @author SongDz
 */
public class Singleton {

    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton SINGLETON = new Singleton();
    }

    public Singleton getInstance() {
        return SingletonHolder.SINGLETON;
    }

}
