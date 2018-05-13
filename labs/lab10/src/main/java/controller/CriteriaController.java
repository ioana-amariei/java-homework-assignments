package controller;

import entity.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class CriteriaController implements AbstractController<Criteria, Integer> {
    private EntityManagerFactory emf;

    public CriteriaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Criteria criteria) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(criteria);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Criteria findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Criteria t where t.id=:id");

        List<Criteria> criteria = query.setParameter("id", id).getResultList();
        em.close();
        return criteria.isEmpty() ? null : criteria.get(0);
    }

    @Override
    public List<Criteria> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select * from Criteria t");

        List<Criteria> criteria = query.getResultList();
        em.close();
        return criteria;
    }

    @Override
    public void update(Criteria criteria) {
        EntityManager em = emf.createEntityManager();
        String statement = "update Criteria t set t.albumId=:albumId, t.albumSales=:albumSales, t.rating=:rating, t.downloads=:downloads where t.id=:id";
        Query query = em.createQuery(statement);

        query.setParameter("albumId", criteria.getAlbumId())
                .setParameter("albumSales", criteria.getAlbumSales())
                .setParameter("rating", criteria.getRating())
                .setParameter("downloads", criteria.getDownloads())
                .executeUpdate();
        em.close();
    }

    @Override
    public void delete(Criteria criteria) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("delete from Criteria t where t.id=:id");

        query.setParameter("id", criteria.getId()).executeUpdate();
        em.close();
    }
}
