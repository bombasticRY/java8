package cn.lry.chapter3;

import cn.lry.base.Artist;

import java.util.List;
import java.util.stream.Stream;

public class First {

    public static void main(String[] args) {
        First first = new First();

//        first.method_1();
        /* 无输出 */
        //first.method_2();
        /*  输出结果如下
            One
            Two
            Three
            Four
            Five*/
        first.method_3();
    }
    public void method_1 () {
        // 内部迭代计算伦敦艺术家人数
        Const aConst = new Const();
        List<Artist> artists = aConst.getArtists();

        long count = artists.stream()
                            .filter(artlist -> artlist.isFrom("London"))
                            .count();
        System.out.println(count);
    }

    /**
     * 惰性求值  没有输出
     */
    public void method_2 () {
        // 内部迭代计算伦敦艺术家人数
        Const aConst = new Const();
        List<Artist> artists = aConst.getArtists();

        Stream<Artist> london = artists.stream()
                .filter(artlist -> {
                    System.out.println(artlist.getName());
                    return artlist.isFrom("London");
                });
    }

    /**
     * 及早求值  没有输出
     */
    public void method_3 () {
        // 内部迭代计算伦敦艺术家人数
        Const aConst = new Const();
        List<Artist> artists = aConst.getArtists();

        long count = artists.stream()
                .filter(artlist -> {
                    System.out.println(artlist.getName());
                    return artlist.isFrom("London");
                })
                .count();
    }

}
