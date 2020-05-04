package cn.lry.base;

/**
 * 专辑中一支曲目
 */
public class Track {

    private String name;//曲目名称

    private int length;

    public Track(String name, Integer length) {
        this.name = name;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
