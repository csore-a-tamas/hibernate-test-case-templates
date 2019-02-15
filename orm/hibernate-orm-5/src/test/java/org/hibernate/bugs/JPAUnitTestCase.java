package org.hibernate.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.jpa.A;
import org.hibernate.jpa.B;
import org.hibernate.jpa.C;
import org.hibernate.jpa.D;
import org.hibernate.jpa.E;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

        private int a_id;
        
	@Before
	public void init() {
            entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            E e1 = new E("e_1");
            E e2 = new E("e_2");

            D d1 = new D("d_1");
            d1.setE(e1);
            D d2 = new D("d_2");
            d2.setE(e2);

            C c = new C("c_1");
            c.setD(d1);

            B b = new B("b_1");

            A a = new A("a_1");
            a.setD(d2);
            a.setC(c);
            a.setB(b);

            entityManager.persist(a);

            A _a = entityManager.createQuery(
                        "select a " +
                        "from A a", A.class)
                    .getSingleResult();
            
            a_id = _a.getId();
            
            entityManager.getTransaction().commit();
            entityManager.close();
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	@Test
	public void multipleOneToOneRelationToTheSameTypeOfEntityTest() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
 
                A a = entityManager.find(A.class, a_id);
                
                assertEquals("a_1", a.getSomeField());
                
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
