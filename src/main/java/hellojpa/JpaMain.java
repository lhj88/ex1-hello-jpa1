package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            /*Member member = new Member();
            member.setId(2L);
            member.setName("헳로 HelloA");

            em.persist(member);
            */

            /*Member member = em.find(Member.class, 1L);

            System.out.println(member.getName());
            member.setName("update! 오오오");*/

            List<Member> result = em.createQuery("Select m from Member as m", Member.class)
                    .setFirstResult(0)
                    .setMaxResults(1)
                    .getResultList();
            for(Member member : result){
                //System.out.println("member.getName() = " + member.get());
            }

            /*// 비영속
            Member member =new Member();
            member.setId(3L);
            member.setName("Test3");

            // 영속
            em.persist(member);*/

            //Member member1 = new Member(150L, "A");
            //Member member2 = new Member(160L, "B");



            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }








    }
}
