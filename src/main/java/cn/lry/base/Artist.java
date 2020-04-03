package cn.lry.base;

import java.util.List;

/**
 * 创作音乐的个人或团队
 */
public class Artist {

    private String name;//艺术家名字
    private List<String> members;//乐队成员
    private String origin;//乐队来自哪里

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
