package cn.lry.chapter3;

import cn.lry.base.Album;
import cn.lry.base.Artist;
import javafx.beans.binding.StringExpression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static javafx.scene.input.KeyCode.T;

public class Practice {
    public static void main(String[] args) {

    }

    /**
     * 练习 1.a
     * @param num
     * @return
     */
    public Integer addUp(Stream<Integer> num) {
        return num.reduce(0, (acc, element) -> acc + element);
    }

    /**
     * 练习 1.b
     *
     * @param artists
     * @return
     */
    public List<String> getNameAndNation (List<Artist> artists) {
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName() , artist.getOrigin()))
                .collect(toList());
    }

    /**
     * 练习 1.c
     * @param albums
     * @return
     */
    public List<Album> filterAlbum (List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTracks().size() <= 3)
                .collect(toList());
    }


    /**
     * 练习 2
     * @param artists
     */
    public void test_2(List<Artist> artists) {
//        int totalMembers = 0;
//        for (Artist artist : artists) {
//            Stream<Artist> members = artists.getMembers();
//            totalMembers += members.count();
//        }
//
//        int count = (int)artists.stream()
//                .flatMap(artist -> artist.getMembers())
//                .count();
    }


    /**
     * 练习 6
     * 计算一个字符串中小写字母的个数
     */
    public static int test_6(String content) {
        return (int) content.chars()
                            .filter(Character::isLowerCase)
                            .count();
    }

    /**
     * 练习7
     * 在一个字符串列表中，找出包含最多小写字母的字符串。
     * 对于空列表，返回Optional<String>对象。
     *
     *
     * 1. 字符串列表转成流
     * 2. 每一个字符串转成流
     * 3. 统计小写字母，空串为0
     * 4. 数字最多的返回 ，若为空，返回Optional<String>
     */
    public static Optional<String> test_7(List<String> strlist) {
        return strlist.stream()
                .max(Comparator.comparing(Practice::test_6));
    }

    /**
     * 使用reduce与Lambda实现map功能
     */
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<O>(), (acc, x) -> {
            // We are copying data from acc to new list instance. It is very inefficient,
            // but contract of Stream.reduce method requires that accumulator function does
            // not mutate its arguments.
            // Stream.collect method could be used to implement more efficient mutable reduction,
            // but this exercise asks to use reduce method.
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
            // We are copying left to new list to avoid mutating it.
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }




    /**
     * Advanced Exercises Question 2
     */
        public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
            List<I> initial = new ArrayList<>();
            return stream.reduce(initial,
                    (List<I> acc, I x) -> {
                        if (predicate.test(x)) {
                            // We are copying data from acc to new list instance. It is very inefficient,
                            // but contract of Stream.reduce method requires that accumulator function does
                            // not mutate its arguments.
                            // Stream.collect method could be used to implement more efficient mutable reduction,
                            // but this exercise asks to use reduce method explicitly.
                            List<I> newAcc = new ArrayList<>(acc);
                            newAcc.add(x);
                            return newAcc;
                        } else {
                            return acc;
                        }
                    },
                    Practice::combineLists);
        }

        private static <I> List<I> combineLists(List<I> left, List<I> right) {
            // We are copying left to new list to avoid mutating it.
            List<I> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        }
}
