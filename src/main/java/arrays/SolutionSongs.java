package arrays;


/*
We have a catalog of song titles (and their lengths) that we play at a local radio station.  We have been asked to play two of those songs in a row, and they must add up to exactly seven minutes long.

Given a list of songs and their durations, write a function that returns the names of any two distinct songs that add up to exactly seven minutes.  If there is no such pair, return an empty collection.

Example:
song_times_1 = [
    ("Stairway to Heaven", "8:05"), ("Immigrant Song", "2:27"),
    ("Rock and Roll", "3:41"), ("Communication Breakdown", "2:29"),
    ("Good Times Bad Times", "2:48"), ("Hot Dog", "3:19"),
    ("The Crunge", "3:18"), ("Achilles Last Stand", "10:26"),
    ("Black Dog", "4:55")
]
find_pair(song_times_1) => ["Rock and Roll", "Hot Dog"] (3:41 + 3:19 = 7:00)

Additional Input:
song_times_2 = [
    ("Stairway to Heaven", "8:05"), ("Immigrant Song", "2:27"),
    ("Rock and Roll", "3:41"), ("Communication Breakdown", "2:29"),
    ("Good Times Bad Times", "2:48"), ("Black Dog", "4:55"),
    ("The Crunge", "3:18"), ("Achilles Last Stand", "10:26"),
    ("The Ocean", "4:31"), ("Hot Dog", "3:19"),
]
song_times_3 = [
    ("Stairway to Heaven", "8:05"), ("Immigrant Song", "2:27"),
    ("Rock and Roll", "3:41"), ("Communication Breakdown", "2:29"),
    ("Hey Hey What Can I Do", "4:00"), ("Poor Tom", "3:00"),
    ("Black Dog", "4:55")
]
song_times_4 = [
    ("Hey Hey What Can I Do", "4:00"), ("Rock and Roll", "3:41"),
    ("Communication Breakdown", "2:29"), ("Going to California", "3:30"),
    ("On The Run", "3:50"), ("The Wrestler", "3:50"),
    ("Black Mountain Side", "2:00"), ("Black Dog", "4:55")
]
song_times_5 = [("Celebration Day", "3:30"), ("Going to California", "3:30")]
song_times_6 = [
  ("Rock and Roll", "3:41"), ("If I lived here", "3:59"),
  ("Day and night", "5:03"), ("Tempo song", "1:57")
]


Complexity Variable:
n = number of song/time pairs

All Test Cases - snake_case:
find_pair(song_times_1) => ["Rock and Roll", "Hot Dog"]
find_pair(song_times_2) => ["Rock and Roll", "Hot Dog"] or ["Communication Breakdown", "The Ocean"]
find_pair(song_times_3) => ["Hey Hey What Can I Do", "Poor Tom"]
find_pair(song_times_4) => []
find_pair(song_times_5) => ["Celebration Day", "Going to California"]
find_pair(song_times_6) => ["Day and night", "Tempo song"]

All Test Cases - camelCase:
findPair(songTimes1) => ["Rock and Roll", "Hot Dog"]
findPair(songTimes2) => ["Rock and Roll", "Hot Dog"] or ["Communication Breakdown", "The Ocean"]
findPair(songTimes3) => ["Hey Hey What Can I Do", "Poor Tom"]
findPair(songTimes4) => []
findPair(songTimes5) => ["Celebration Day", "Going to California"]
findPair(songTimes6) => ["Day and night", "Tempo song"]

*/

import java.io.*;
import java.util.*;


public class SolutionSongs {
    static int target = 7 * 60;

    static Integer tranformTime(String str) {
        List<String> list = new ArrayList<>();
        String[] mmSS = str.split(":");
        //System.out.println(mmSS[0] + "++" + mmSS[1]);
        if (mmSS.length == 2) {
            Integer mm = Integer.valueOf(mmSS[0]);
            Integer ss = Integer.valueOf(mmSS[1]);
            //System.out.println(mm + " :int:" + ss + " - " + (mm * 60 + ss));
            return mm * 60 + ss;
        } else {
            //Complain
        }
        return 0;
    }

    static String[] findPair(String[][] songsToTime) {
        //Transform time in MM:SS to seconds
        Map<Integer, Integer> songsMap = new HashMap<>();

        for (int i = 0; i < songsToTime.length; i++) {
            //System.out.println("Song to Time" + songsToTime[i][0] + ", " +  songsToTime[i][1]);
            Integer songSS = tranformTime(songsToTime[i][1]);
            Integer index = -1;
            if (songsMap.containsKey(target - songSS)) {
                String song1 = songsToTime[songsMap.get(target - songSS)][0];
                String song2 = songsToTime[i][0];
                //System.out.println(song1 + "   w "  + song2);
                return new String[]{song1, song2};
            }
            songsMap.put(songSS, i);
        }
        return new String[]{};
    }

    public static void main(String[] argv) {
        String[][] songTimes1 = {
                {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
                {"Good Times Bad Times", "2:48"}, {"Hot Dog", "3:19"},
                {"The Crunge", "3:18"}, {"Achilles Last Stand", "10:26"},
                {"Black Dog", "4:55"}
        };
        String[] songs = findPair(songTimes1);
        if (songs.length > 1) {
            System.out.println("1. " + songs[0] + " 2: " + songs[1]);
        }
        String[][] songTimes2 = {
                {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
                {"Good Times Bad Times", "2:48"}, {"Black Dog", "4:55"},
                {"The Crunge", "3:18"}, {"Achilles Last Stand", "10:26"},
                {"The Ocean", "4:31"}, {"Hot Dog", "3:19"}
        };
        songs = findPair(songTimes2);
        if (songs.length > 1) {
            System.out.println("2. " + songs[0] + " 2: " + songs[1]);
        } else {
            System.out.println("2. ");
        }
        String[][] songTimes3 = {
                {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
                {"Hey Hey What Can I Do", "4:00"}, {"Poor Tom", "3:00"},
                {"Black Dog", "4:55"}
        };

        songs = findPair(songTimes3);
        if (songs.length > 1) {
            System.out.println("3. " + songs[0] + " 2: " + songs[1]);
        } else {
            System.out.println("2. ");
        }
        String[][] songTimes4 = {
                {"Hey Hey What Can I Do", "4:00"}, {"Rock and Roll", "3:41"},
                {"Communication Breakdown", "2:29"}, {"Going to California", "3:30"},
                {"On The Run", "3:50"}, {"The Wrestler", "3:50"},
                {"Black Mountain Side", "2:00"}, {"Black Dog", "4:55"}
        };
        songs = findPair(songTimes4);
        if (songs.length > 1) {
            System.out.println("4. " + songs[0] + " 2: " + songs[1]);
        } else {
            System.out.println("4. ");
        }
        String[][] songTimes5 = {
                {"Celebration Day", "3:30"}, {"Going to California", "3:30"}
        };
        songs = findPair(songTimes5);
        if (songs.length > 1) {
            System.out.println("5. " + songs[0] + " 2: " + songs[1]);
        } else {
            System.out.println("5. ");
        }

        String[][] songTimes6 = {
                {"Rock and Roll", "3:41"}, {"If I lived here", "3:59"},
                {"Day and night", "5:03"}, {"Tempo song", "1:57"}
        };

        songs = findPair(songTimes6);
        if (songs.length > 1) {
            System.out.println("6. " + songs[0] + " 2: " + songs[1]);
        } else {
            System.out.println("6. ");
        }
    }
}
