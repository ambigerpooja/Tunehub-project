package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

@Controller
public class SongsController 
{
	@Autowired
	SongService ssr;
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Song song)
	{
		boolean songstatus=ssr.songExists(song.getName());
		if(songstatus==false)
		{
			ssr.addSongs(song);
			System.out.println("songs added");
			return "songsuccess";
		}
		else
		{  
			System.out.println("song is already exit");
			return"songaddedfail";
		}

	}
	@GetMapping("/map-viewsongs")
	public String viewsongs(Model model)
	{
		List<Song> songList=ssr.viewsongs();
		model.addAttribute("songs",songList);
		return "viewsongs";
	}
	
	
    @GetMapping("/map-display")
	public String displaysong(Model model)
	
	{
    	//intend of giving direct true to the primeStatus ssr.customersongs(); from there only we can change condition as true or false
    	//false makepayment true song list are displyed from the customer side
		boolean primeStatus=true;
		if(primeStatus==true)
		{
			List<Song> songList=ssr.viewsongs();
			model.addAttribute("songs",songList);
			return"viewsongs";
		}
		else
		{
			return"makepayment";
		}
	}
}