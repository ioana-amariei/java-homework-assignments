package entity;

import javax.persistence.*;

@Entity
@Table(name = "criteria")
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "album_id")
    private int albumId;

    @Column(name = "album_sales")
    private int albumSales;

    private float rating;
    private int downloads;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getAlbumSales() {
        return albumSales;
    }

    public void setAlbumSales(int albumSales) {
        this.albumSales = albumSales;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", albumSales=" + albumSales +
                ", rating=" + rating +
                ", downloads=" + downloads +
                '}';
    }
}
