package com.songdz.question02;

/**
 * Created by SongDz on 2016/3/18.
 *
 * @author SongDz
 */
public class SingletonSyn {

    private static SingletonSyn singletonSyn;

    private SingletonSyn() {
    }

    public static SingletonSyn getInstance() {

        if (singletonSyn == null) {
            synchronized (SingletonSyn.class) {
                if (singletonSyn == null) {
                    singletonSyn = new SingletonSyn();
                }
            }
        }

        return singletonSyn;
    }

}
