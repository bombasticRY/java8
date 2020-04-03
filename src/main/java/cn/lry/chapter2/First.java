package cn.lry.chapter2;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class First {

    public static void main(String[] args) {

        // 判断类型
        Predicate<Integer> result = x -> x > 5;

        // 略复杂类型推断 指定类型为long
        BinaryOperator<Long> add = (x, y) -> x + y;

        //ThreadLocal
    }
}
