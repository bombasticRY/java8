package cn.lry.chapter3;

import cn.lry.base.Album;
import cn.lry.base.Track;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Second {

    public static void main(String[] args) {
        Second second = new Second();
//        second.method_1();
//        second.method_2();
//        second.method_3();
//        second.method_4();
//        second.method_5();
//        second.method_6();
//      second.method_7();
//        second.method_8();
//        second.method_9();
//        second.method_10();
//        second.method_11();
        second.method_12();

    }

    /**
     * 及早求值 -- collect(toList))
     */
    public void method_1() {
        List<String> collect = Stream.of("a", "b", "c")
                                     .collect(toList());

        boolean b = asList("a", "b", "c") .equals(collect);
        System.out.println(b);
    }

    /**
     * 字符串转大写
     * java8 之前的写法
     */
    public void method_2() {
        List<String> collected = new ArrayList<>();
        for (String string : asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }

        boolean equals = asList("A", "B", "HELLO").equals(collected);
        System.out.println(equals);
    }

    /**
     * 及早求值 -- map函数
     * 字符串转大写
     */
    public void method_3() {
        List<String> collected = Stream.of("a", "b", "hello")
                                       .map(string -> string.toUpperCase())
                                       .collect(toList());
        boolean equals = asList("A", "B", "HELLO").equals(collected);
        System.out.println(equals);
    }

    /**
     * 过滤字段
     * java8 之前写法
     */
    public void method_4() {
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : asList("a", "1abc", "abc1")) {
            if (isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }

        boolean equals = asList("1abc").equals(beginningWithNumbers);
        System.out.println(equals);
    }

    /**
     * filter 过滤方法
     */
    public void method_5 () {
        List<String> beginningWithNumbers = Stream.of("a", "abc1", "1abc")
                                                  .filter(value -> isDigit(value.charAt(0)))
                                                  .collect(toList());
        boolean equals = asList("1abc").equals(beginningWithNumbers);
        System.out.println(equals);
    }

    /**
     * flatMap 将多个stream拼接成一个
     */
    public void method_6 () {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                                       .flatMap(numbers -> numbers.stream())
                                       .collect(toList());

        boolean equals = asList(1, 2, 3, 4).equals(together);
        System.out.println(equals);
    }

    /**
     * max min
     */
    public void method_7() {
        List<Track> tracks = asList(new Track("Bakai",524),
                                    new Track("Violets for Your Furs", 378),
                                    new Track("Time Was", 451));
        Track shorttestTrack = tracks.stream()
                                     .min(Comparator.comparing(track -> track.getLength()))
                                     .get();
        boolean equals = tracks.get(1).equals(shorttestTrack);
        System.out.println(equals);

    }

    /**
     * 通用模式
     * 通过 max min 扩展出可使用for循环这种通用模式
     * 在连接到reduce操作
     *
     */
    public void method_8 () {
        // 承上
        List<Track> tracks = asList(new Track("Bakai",524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        Track shortestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLength() < shortestTrack.getLength()) {
                shortestTrack = track;
            }
        }
        boolean equals = tracks.get(1).equals(shortestTrack);
        System.out.println(equals);


        //启下
        // 伪代码如下
//        Object accumulator = initialValue;
//        for ( Object element : collection) {
//            accumulator = combine(accumulator, element);
//        }
    }

    /**
     * reduce模式
     * 一组值中生成一个值
     * count/max/min等
     **/

    /**
     *  使用reduce模式实现累加
     */
    public void method_9 () {
        int count = Stream.of(1, 2, 3)
                           .reduce(0, (acc, element) -> acc + element);
        System.out.println(6 == count);
    }

    /**
     * method_9() 的展开
     * 展开reduce操作
     */
    public void method_10() {
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int count = accumulator.apply(
                        accumulator.apply(
                            accumulator.apply(0,1),
                     2),
                 3);
    }

    /**
     * 区别于函数式编程的命令式编程
     * 命令式编程实现累加
     */
    public void method_11 () {
        int acc = 0;
        for (Integer element : asList(1, 2, 3)) {
            acc = acc + element;
        }
        System.out.println(6 == acc);
    }

    /**
     * 整合操作
     * 以上几种方法的整合
     *
     * 1. 找出专辑上的所有表演者
     * 2. 分辨出哪些表演者是乐队(以"The"开头)
     * 3. 找出每一个乐队的国籍
     * 4. 将找出的国籍放入一个集合
     */
    public void method_12 () {
        Const aConst = new Const();
        Album album = aConst.getAlbum();
        Set<String> origins = album.getAllMusicians()
                                   .filter(artist -> artist.getName().startsWith("The"))
                                   .map(artist -> artist.getOrigin())
                                   .collect(Collectors.toSet());
        System.out.println(origins.toString());
    }
}
