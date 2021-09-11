package com.example.demo.model;

import java.sql.Timestamp;
import java.time.Year;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Songs")
@AllArgsConstructor
@NoArgsConstructor
public class Song {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String song_name;
	private String genre_name;
	private Integer rating;
	private Integer download_quantity;
	private Timestamp db_date;
	private Timestamp song_year;
	
    public Song(String song_name, String genre_name, Integer rating, Integer download_quantity, Timestamp db_date, Timestamp song_year) {
        this.setSong_name(song_name);
        this.setGenre_name(genre_name);
        this.setRating(rating);
        this.setDownload_quantity(download_quantity);
        this.setDb_date(db_date);
        this.setSong_year(song_year);
    }
}
