package cn.lry.chapter2;

import java.text.SimpleDateFormat;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import javax.swing.*;
import javax.swing.text.DateFormatter;

public class First {

    public static void main(String[] args) {

        // 判断类型
        Predicate<Integer> result = x -> x > 5;

        // 略复杂类型推断 指定类型为long
        BinaryOperator<Long> add = (x, y) -> x + y;

        ThreadLocal<DateFormatter> a = ThreadLocal.withInitial(()-> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

        //Runnable helloWorld = () -> System.out.println("hello world");

      /*  JButton button = new JButton();
        button.addActionListener(event ->
            System.out.println(event.getActionCommand()));*/


    }
}

/*
interface IntPred{
    boolean test(Integer value);
}
    boolean check(Predicate<Integer> predicate);

    boolean check(IntPred perdicate);*/
