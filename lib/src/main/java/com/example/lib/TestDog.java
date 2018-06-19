package com.example.lib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestDog {
    public static void main(String[] args){
        An animal = new An();
        Dog dog = new Dog();
        An b = new Dog();

//        //animal.move();
//        dog.move();
//        //dog.bark();
//        b.move();

        List<Integer> list = new ArrayList<>();

        list.add(12);

//        list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = null;
        try {

            add = clazz.getDeclaredMethod("add", Object.class);
            add.invoke(list, "kl");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(list);

    }
}
