package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Song;

public interface SongService 
{
    public String addSongs(Song song);
    
    public boolean songExists(String name);
    
    public List<Song> viewsongs();

	
    
    /*
    //create a method to give body in implements 
    public boolean customersongs();
    */
}
