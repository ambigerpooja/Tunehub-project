package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService
{
	@Autowired
    SongRepository srp;
	@Override
	public String addSongs(Song song) {
		srp.save(song);
		return" Song is added";
	}
	@Override
	public boolean songExists(String name) 
	{
		Song song = srp.findByName(name);
		if(song==null)
		{
			return false;
		}
		else 
		{
			return true;
		}
		
	}
	@Override
	public List<Song> viewsongs() 
	{
		List<Song> songList=srp.findAll();
		return songList;
	}
	
	//Another way to viwe songs from the cusomer side give the body from the songService interface here
	/*
	public boolean customersongs() {
		// TODO Auto-generated method stub
		return true;
	}
	*/
	   
}
