package cn.lry.chapter3;

import cn.lry.base.Album;
import cn.lry.base.Track;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 重构遗留代码
 * 在一张专辑中 找出长度大于1分钟的曲目名称
 */
public class Third {
    public static void main(String[] args) {
        Third third = new Third();
        List<Album> albums = new ArrayList<>();
        albums.add(new Const().getAlbum());

        System.out.println(third.findLongTracks(albums).toString());
        System.out.println(third.findLongTracks_1(albums).toString());
        System.out.println(third.findLongTracks_2(albums).toString());
        System.out.println(third.findLongTracks_3(albums).toString());
        System.out.println(third.findLongTracks_4(albums).toString());

    }

    /**
     * 遗留代码
     */
    public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTracks()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }

    /**
     * 重构第一步 修改for循环为 foreach
     * @return
     */
    public Set<String> findLongTracks_1(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach( album -> {
                    album.getTracks()
                            .forEach( track -> {
                                if (track.getLength() > 60) {
                                    String name = track.getName();
                                    trackNames.add(name);
                                }
                            });
                });
        return trackNames;
    }

    /**
     * 重构第二步
     * 突破口为最里层foreach
     * 作用为
     *      1. 找出长度大于1分钟曲目 -- filter
     *      2. 得到曲目名 -- map
     *      3. 放入Set集合  -- foreach
     * @param albums
     * @return
     */
    public Set<String> findLongTracks_2(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> {
                    album.getTracks().stream()
                            .filter( track -> track.getLength() > 60)
                            .map( track -> track.getName())
                            .forEach( name -> trackNames.add(name));
                });

        return trackNames;
    }

    /**
     * 重构第三步
     * 将第一个foreach代替 换成map或者flatMap
     */
    public Set<String> findLongTracks_3(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter( track -> track.getLength() > 60)
                .map( track -> track.getName())
                .forEach( name -> trackNames.add(name));
        return trackNames;
    }

    /**
     * 重构第四步
     * 不用先创建变量，stream流处理完成之后直接返回set
     * 将最后一个foreach去掉，改为Collectos.toSet()
     * @param albums
     * @return
     */
    public Set<String> findLongTracks_4(List<Album> albums) {

        return albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter( track -> track.getLength() > 60)
                .map( track -> track.getName())
                .collect(Collectors.toSet());

    }

}
