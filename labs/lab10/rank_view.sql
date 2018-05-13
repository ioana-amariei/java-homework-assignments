CREATE OR REPLACE VIEW rank_view as
select artists.name as artistName, albums.name as albumName, criteria.downloads as downloads, criteria.rating as rating, criteria.album_sales as albumSales
FROM artists, albums, criteria
                WHERE artists.id = albums.artist_id
                 AND
                criteria.album_id = albums.id;