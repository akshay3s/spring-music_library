
package com.example.song.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.song.model.Song;
import com.example.song.service.SongJpaService;
import java.util.*;



@RestController
public class SongController{
    
     @Autowired
    public SongJpaService songservice;

    @GetMapping("/songs")

    public ArrayList<Song> getSong(){
        return songservice.getSong();
    }
    
    @GetMapping("/songs/{songId}")

    public Song getSongById(@PathVariable("songId") Integer songId){
        return songservice.getSongById(songId);
    }

    @PostMapping("/songs")

    public Song addSong(@RequestBody Song song){
       return songservice.addSong(song);
    }
    
    @PutMapping("/songs/{songId}")

    public Song updateSong(@PathVariable("songId") Integer songId, @RequestBody Song song){
        return songservice.updateSong(songId,song);
        
    }
    @DeleteMapping("/songs/{songId}")

    public void deleteSong(@PathVariable("songId") Integer songId){
        songservice.deleteSong(songId);
        
    }
}