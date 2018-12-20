package com.malloc.springbootmicroservice.alexa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class SongListGenerator {
    
    Logger logger = LoggerFactory.getLogger(SongListGenerator.class);
    
    //@Scheduled(fixedDelay = 24*60*60)
    public void send() throws IOException {
        String url = "http://www.friendstamilmp3.com/songs2/A-Z%20Movie%20Songs/";
        
        List<Song> songs = new ArrayList<Song>(); 
                
                Jsoup.connect(url)
                .get()
                .select("a[href]")                
                .parallelStream()                
                .collect(Collectors.toMap(f -> f.attr("abs:href"), f -> f.text())).entrySet()                
                .parallelStream()
                .filter(f -> f.getValue().startsWith("B"))
                .map(f -> {                    
                    
                    try {
                        List<Song> fSongs = Jsoup
                        .connect(f.getKey()).get().select("a[href]")
                        .stream()
                        .filter(s -> s.attr("abs:href").endsWith(".mp3"))
                        .map(s -> new Song(f.getValue().replaceAll("/", ""), s.text(), s.attr("abs:href")))
                        .collect(Collectors.toList());
                        
                        return fSongs;
                        
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    
                    return null;                   
                    
                })
                .forEachOrdered(songs::addAll);
        
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("padam.json"), songs);        
                
    }
}

class Song {
    private String film;
    private String name;
    private String url;
    
    public Song(String film, String name, String url) {
        super();
        this.name = name;
        this.url = url;
        this.film = film;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
    public String getFilm() {
        return film;
    }
}
