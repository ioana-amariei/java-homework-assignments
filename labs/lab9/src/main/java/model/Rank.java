package model;

public class Rank {
    private String albumName;
    private String artistName;
    private int downloads;
    private float rating;
    private int albumSales;

    public Rank(String albumName, String artistName, int downloads, float rating, int albumSales) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.downloads = downloads;
        this.rating = rating;
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


}
