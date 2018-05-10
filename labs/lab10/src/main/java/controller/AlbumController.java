package controller;

import entity.Album;
import entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class AlbumController {
    private EntityManagerFactory emf;

    public AlbumController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Album album) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        em.close();
    }

    public Album findByName(String albumName) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Album t where t.name=" + albumName);

        List<Album> albums = query.setParameter("name", albumName).getResultList();
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
}
