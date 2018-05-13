package controller;

import entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class ArtistController implements AbstractController<Artist, Integer> {
    private EntityManagerFactory emf;

    public ArtistController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Artist findByName(String artistName) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Artist t where t.name=:name");

        List<Artist> artists = query.setParameter("name", artistName).getResultList();
        em.close();
        return artists.isEmpty() ? null : artists.get(0);
    }

    @Override
    public void save(Artist artist) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Artist findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Artist t where t.id=:id");

        List<Artist> artists = query.setParameter("id", id).getResultList();
        em.close();
        return artists.isEmpty() ? null : artists.get(0);
    }

    @Override
    public List <Artist> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select * from Artist t");

        List<Artist> artists = query.getResultList();
        em.close();

        return artists;
    }

    @Override
    public void update(Artist artist) {
        EntityManager em = emf.createEntityManager();
        String statement = "update Artist t set t.name=:name, t.country=:country where t.id=:id";
        Query query = em.createQuery(statement);

        query.setParameter("name", artist.getName())
                .setParameter("country", artist.getCountry())
                .setParameter("id", artist.getId())
                .executeUpdate();
        em.close();
    }

    @Override
    public void delete(Artist artist) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("delete from Artist t where t.id=:id");

        query.setParameter("id", artist.getId()).executeUpdate();
        em.close();
    }
}