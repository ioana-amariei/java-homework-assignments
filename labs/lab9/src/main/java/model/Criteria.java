package model;

public class Criteria {
    private int id;
    private int albumId;
    private int albumSales;
    private float rating;
    private int downloads;

    public Criteria(int albumId, int albumSales, float rating, int downloads) {
        this.albumId = albumId;
        this.albumSales = albumSales;
        this.rating = rating;
        this.downloads = downloads;
    }

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
