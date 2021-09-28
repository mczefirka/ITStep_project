package com.example.demo.model;

import java.sql.Timestamp;
import java.time.Year;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name="song_name")
	private String songName;
	@Column(name="genre_name")	
	private String genreName;
	private Integer rating;
	@Column(name="download_quantity")	
	private Integer downloadQuantity;
	@Column(name="db_date")		
	private Timestamp dbDate;
	@Column(name="song_date")		
	private Timestamp songDate;
	
    public Song(String songName, String genreName, Integer rating, Integer downloadQuantity, Timestamp dbDate, Timestamp songDate) {
        this.setSongName(songName);
        this.setGenreName(genreName);
        this.setRating(rating);
        this.setDownloadQuantity(downloadQuantity);
        this.setDbDate(dbDate);
        this.setSongDate(songDate);
    }
    
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "name", nullable = false)
//	private Genre genre;
}
