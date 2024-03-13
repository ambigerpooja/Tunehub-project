package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongService;

@Controller
public class PlayListController 

{ 
	@Autowired
	PlayListService plser;
	@Autowired
	SongService sserv;
	
	@GetMapping("/map-playlist")
	public String createPlayList(Model model)
	{
		//fetching the songs using song service
		List<Song> songsList=sserv.viewsongs();
		
		//Adding the songs in the model
		model.addAttribute("songsList", songsList);
		
		//sending to createplaylist html 
		return"createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist)
	{
		return "playlistsuccess";
	}

}
