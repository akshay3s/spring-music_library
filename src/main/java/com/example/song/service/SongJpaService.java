package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.repository.SongRepository;
import java.util.*;

import org.springframework.stereotype.Service;
import com.example.song.repository.SongJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SongJpaService implements SongRepository{
    @Autowired
    private SongJpaRepository songJpaRepository; 



    @Override
    public ArrayList<Song> getSong() {
        List<Song>songlist = songJpaRepository.findAll();
        ArrayList<Song>songs = new ArrayList<>(songlist);
        return songs;
    }
    @Override
    public Song getSongById(int songId){
        try{
            Song song = songJpaRepository.findById(songId).get();
            return song;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
    @Override
    public Song addSong(Song song){
        songJpaRepository.save(song);
        return song;
        
    }
    @Override
    public Song updateSong(int songId,Song song){
        try {
            Song newsong =  songJpaRepository.findById(songId).get();
            if(song.getSongName()!=null){
                newsong.setSongName(song.getSongName());
            }
            if(song.getLyricist()!=null){
                newsong.setLyricist(song.getLyricist());
            }
            if(song.getSinger()!=null){
                newsong.setSinger(song.getSinger());
            }
            if(song.getMusicDirector()!=null){
                newsong.setMusicDirector(song.getMusicDirector());
            }
            songJpaRepository.save(newsong);
            return newsong;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    @Override

    public void deleteSong(int songId){
        try{
            songJpaRepository.deleteById(songId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    
}