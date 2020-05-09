package cn.lry.chapter3;

import cn.lry.base.Album;
import cn.lry.base.Artist;
import javafx.beans.binding.StringExpression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

}
