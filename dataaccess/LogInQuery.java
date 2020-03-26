package dataaccess;

import business.UserDataStructure;
import org.hibernate.criterion.Expression;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class LogInQuery {
    private static SessionFactory factory; 
    private UserDataStructure data;
    private Session session;
    
    public LogInQuery(UserDataStructure data){
        this.data = data;
    }
    
    public boolean doQuery(){
        User u = null;
        
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
        }
        
        session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
         
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Expression.eq("Username", data.getUsername()));
            criteria.add(Expression.eq("Password", data.getPassword()));
            try{
                u =(User) criteria.uniqueResult();
            }catch(HibernateException e){            
                session.close();
                return false;
            }  
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
        
        if(u !=null)
            return true;
        else 
            return false;
    }
}