package cn.lry.base;

import java.util.List;

/**
 * 专辑，由若干曲目组成
 */
public class Album {

    private String name;//专辑名
    private List<String> tracks;//曲目列表
    private List<String> musicians;//参与创作本专辑的所有艺术家列表

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public List<String> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<String> musicians) {
        this.musicians = musicians;
    }
}
