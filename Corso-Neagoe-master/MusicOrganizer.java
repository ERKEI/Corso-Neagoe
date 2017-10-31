import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;
import java.lang.reflect.*;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author Neagoe - Corso
 * @version 7/10/17
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Track> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer(String filePath)
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
        files = TextFile.getData(filePath,Track.class);
        System.out.println(getNumberOfFiles() + " " + "track(s) loaded");
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public boolean addFile(String filePath)
    {
        File file = new File(filePath);
        if ( !file.exists())
            return false;
        else {
            files = TextFile.getData(filePath,Track.class);
            return true;
        }
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    public boolean checkIndex(int index)
    {
        if(index >= 0 && index < files.size())
            return true;

        else 
            return false;
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(checkIndex(index)) {
            Track filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(checkIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        Track filename = files.get(index);
        player.playSample(Track.getTitolo());
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    public void readSongName(String filePath)
    {
        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("" + listOfFiles[i].getName());
                player.playSample(listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

}
