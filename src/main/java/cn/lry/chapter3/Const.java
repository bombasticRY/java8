package cn.lry.chapter3;

import cn.lry.base.Album;
import cn.lry.base.Artist;
import cn.lry.base.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化数据
 */
public class Const {

    private List<Artist> artists = new ArrayList<>();



    Artist artist1 = new Artist("One", null, "London");
    Artist artist2 = new Artist("Two", null, "London");
    Artist artist3 = new Artist("The Three", null, "London");
    Artist artist4 = new Artist("Four", null, "Beijing");
    Artist artist5 = new Artist("The Five", null, "Shanghai");
    Track track1 = new Track("Bakai",524);
    Track track2 = new Track("Violets for Your Furs", 378);
    Track track3 = new Track("Time Was", 451);
    Track track4 = new Track("AAA", 122);
    Track track5 = new Track("Beibei", 4);



    public Album getAlbum() {
        return new Album("1", getTracks(), getArtists());
    }

    public List<Track> getTracks() {
        List<Track> tracks = new ArrayList<>();
        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);
        tracks.add(track4);
        tracks.add(track5);


        return tracks;
    }



    public List<Artist> getArtists() {

        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);
        artists.add(artist4);
        artists.add(artist5);


        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
