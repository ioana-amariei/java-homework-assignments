package controller;

import entity.Rank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class RankController {
    private EntityManagerFactory emf;

    public RankController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List <Rank> findAllByDownloads() throws SQLException {
        EntityManager em = emf.createEntityManager();

        String statement = "SELECT r FROM Rank r ORDER BY r.downloads DESC";
        Query query = em.createQuery(statement);
        List <Rank> ranks = query.getResultList();

        return ranks;
    }

    public List <Rank> findAllBySales() throws SQLException {
        EntityManager em = emf.createEntityManager();

        String statement = "SELECT r FROM Rank r ORDER BY r.albumSales DESC";
        Query query = em.createQuery(statement);
        List <Rank> ranks = query.getResultList();

        return ranks;
    }

    public List <Rank> findAllByRating() throws SQLException {
        EntityManager em = emf.createEntityManager();

        String statement = "SELECT r FROM Rank r ORDER BY r.rating DESC";
        Query query = em.createQuery(statement);
        List <Rank> ranks = query.getResultList();

        return ranks;
    }
}
