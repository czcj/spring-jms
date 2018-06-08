package spittr.dao.jpa;

import org.springframework.stereotype.Repository;
import spittr.pojo.Spitter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
//
//@Repository
//public class JapSpitterRepository implements SpittrMapper {
//
//    @PersistenceUnit
//    private EntityManagerFactory emf;
//
//    public void getSpitters() {
//        Spitter spitter = new Spitter();
//        spitter.setUsername("meng");
//        spitter.setPassword("abc123");
//        emf.createEntityManager().persist(spitter);
//    }
//}
