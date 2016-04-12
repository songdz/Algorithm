package com.songdz.question02;

/**
 * 实现Singleton 枚举类
 *
 * Created by SongDz on 2016/3/17.
 *
 * @author SongDz
 */
public enum SingletonEnum {

    INSTANCE;

    public SingletonEnum getInstance() {
        return INSTANCE;
    }

}
