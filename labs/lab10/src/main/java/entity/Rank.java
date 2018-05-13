package entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rank_view")
public class Rank {
    @Id private String albumName;
    @Id private String artistName;
    @Id private int downloads;
    @Id private float rating;
    @Id private int albumSales;

    public Rank() {
    }

    public Rank(String albumName, String artistName, int downloads, float rating, int albumSales) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.downloads = downloads;
        this.rating = rating;
        this.albumSales = albumSales;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getAlbumSales() {
        return albumSales;
    }

    public void setAlbumSales(int albumSales) {
        this.albumSales = albumSales;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "albumName='" + albumName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", downloads=" + downloads +
                ", rating=" + rating +
                ", albumSales=" + albumSales +
                '}';
    }
}
