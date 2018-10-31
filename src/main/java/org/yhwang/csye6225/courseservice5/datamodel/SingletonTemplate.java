package org.yhwang.csye6225.courseservice5.datamodel;

public class SingletonTemplate {
    private static SingletonTemplate ourInstance = new SingletonTemplate();

    public static SingletonTemplate getInstance() {
        return ourInstance;
    }

    private SingletonTemplate() {
    }
}
