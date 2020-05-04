package cn.lry.base;

import java.util.List;
import java.util.stream.Stream;

/**
 * 专辑，由若干曲目组成
 */
public class Album {

    private String name;//专辑名
    private List<Track> tracks;//曲目列表
    private List<Artist> musicians;//参与创作本专辑的所有艺术家列表

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        this.name = name;
        this.tracks = tracks;
        this.musicians = musicians;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }

    public Stream<Artist> getAllMusicians() {
        return getMusicians().stream();
    }
}
