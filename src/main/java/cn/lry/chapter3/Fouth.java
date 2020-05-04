package cn.lry.chapter3;

import cn.lry.base.Album;
import cn.lry.base.Artist;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 多次调用流操作
 */
public class Fouth {
    public static void main(String[] args) {
        Const aConst = new Const();
        Album album = aConst.getAlbum();
        Fouth fouth = new Fouth();

        fouth.method_1(album);
        fouth.method_2(album);

    }

    /**
     * 误用流操作
     * 缺点如下
     * 1. 代码可读性差，样板代码太多，隐藏了真正的业务逻辑
     * 2. 效率差，每一步都要对流进行及早求值，生成新的集合
     * 3. 代码中充斥着大量的垃圾变量，只用来保存中间结果，除此之外毫无用处
     * 4. 难于自动并行化处理
     */
    public void method_1(Album album) {

        List<Artist> musicians = album.getMusicians().stream().collect(Collectors.toList());

        List<Artist> artists = musicians.stream().filter(artist -> artist.getName().startsWith("The")).collect(Collectors.toList());

        Set<String> origins = artists.stream().map(artist -> artist.getOrigin()).collect(Collectors.toSet());

        System.out.println(origins);
    }

    public void method_2(Album album) {
        Set<String> origins = album.getMusicians().stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getOrigin())
                .collect(Collectors.toSet());
        System.out.println(origins);

    }
}
