package main;

import model.Album;
import model.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        List<Song> songList1 = new ArrayList<>();
        Song song1 = new Song("channa mereya","3.25 mins");
        Song song2 = new Song("tum kya mile","2.25 mins");
        Song song3 = new Song("abcd","4.25 mins");
        songList1.add(song1);
        songList1.add(song2);
        songList1.add(song3);

        Album album1 = new Album("old songs", "oldartist", songList1);
        System.out.println(album1);

        System.out.println("Find song from album");
        Scanner s = new Scanner(System.in);
        String titleOfSong = s.nextLine();
        boolean songsPresent  = album1.findSongsInAlbum(titleOfSong);
        if(songsPresent){
            System.out.println("Song "+titleOfSong+" is playing ................");
        } else{
            System.out.println("Song "+titleOfSong+" not found");
        }

        System.out.println("Do you wnat to play previous or next song : ");
        int previousOrNext = s.nextInt();
        if(previousOrNext == 1){
            playNext(album1,titleOfSong);
        } else if (previousOrNext == -1) {
            playPrevious(album1, titleOfSong);
        } else{
            System.out.println("Replaying same song : "+titleOfSong);
        }

    }

    public static void playPrevious(Album album, String titleOfSong){
        List<Song> songList = album.getSonsList();
        for(int i=0;i<songList.size();i++){
            if(songList.get(i).getTitle().equals(titleOfSong)){
                System.out.println("Previous song playing is : "+songList.get(i-1).getTitle());
            }
        }
    }

        public static void playNext(Album album, String titleOfSong){
        List<Song> songList = album.getSonsList();
        for(int i=0;i<songList.size();i++){
            if(songList.get(i).getTitle().equals(titleOfSong)){
                System.out.println("Previous song playing is : "+songList.get(i+1).getTitle());
            }
        }
    }
}
