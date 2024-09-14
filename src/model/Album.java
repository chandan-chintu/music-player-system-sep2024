package model;

import java.util.List;

public class Album {

    private String albumName;
    private String artistName;
    private List<Song> songsList;

    public Album(String albumName, String artistName, List<Song> sonsList) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songsList = sonsList;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Song> getSonsList() {
        return songsList;
    }

    public void setSonsList(List<Song> sonsList) {
        this.songsList = sonsList;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", sonsList=" + songsList +
                '}';
    }

    public boolean findSongsInAlbum(String title) {
        // trvaerse the songslist and find out the song
        for (Song song1 : songsList) {
            if (song1.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public String addSongsIntoAlbum(Song song){
        // check if songs are present in album
        // if already present do not add it else add it
        boolean songAlreadyPresent = findSongsInAlbum(song.getTitle());
        if (songAlreadyPresent){
            return "Song already present";
        } else{
            songsList.add(song);
            return "song is added to the album";
        }
    }
}
