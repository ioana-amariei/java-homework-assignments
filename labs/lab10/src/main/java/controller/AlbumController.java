package controller;

import entity.Album;
import entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class AlbumController implements AbstractController<Album, Integer> {
    private EntityManagerFactory emf;

    public AlbumController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Album findByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Album t where t.name=:name");

        List<Album> albums = query.setParameter("name", name).getResultList();
        em.close();
        return albums.isEmpty() ? null : albums.get(0);
    }

    public List<Album> findByArtistId(int artistId){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Album t where t.artistId=:artistId");

        List<Album> albums = query.setParameter("artistId", artistId).getResultList();
        em.close();

        return albums;
    }

    @Override
    public void save(Album album) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Album findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Album t where t.id=:id");

        List<Album> albums = query.setParameter("id", id).getResultList();
        em.close();
        return albums.isEmpty() ? null : albums.get(0);
    }

    @Override
    public List <Album> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select * from Album t");

        List<Album> albums = query.getResultList();
        em.close();
        return albums;
    }

    @Override
    public void update(Album album) {
        EntityManager em = emf.createEntityManager();
        String statement = "update Album t set t.name=:name, t.artist_id=:artist_id, t.release_year=:release_year where t.id=:id";
        Query query = em.createQuery(statement);

        query.setParameter("name", album.getName())
                .setParameter("artist_id", album.getArtistId())
                .setParameter("release_year", album.getReleaseYear())
                .setParameter("id", album.getId())
                .executeUpdate();
        em.close();
    }

    @Override
    public void delete(Album album) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("delete from Album t where t.id=:id");

        query.setParameter("id", album.getId()).executeUpdate();
        em.close();
    }
}
