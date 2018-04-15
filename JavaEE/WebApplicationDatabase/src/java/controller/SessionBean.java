/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Contact;

/**
 *
 * @author Sami
 */
@Stateless
public class SessionBean {

    @PersistenceContext
    private EntityManager em;

    public Contact insert(Contact c) {
        em.persist(c);
        return c;
    }

    public void update(Contact c) {
        em.merge(c);
    }
    
    public void delete(int id) {
        em.remove(selectById(id));
    }
    
    public List<Contact> selectAll(){
        return  em.createNamedQuery("Contact.findAll").getResultList();
    }
    
    public Contact selectById (int id){
        return (Contact) em.createNamedQuery("Contact.findById").setParameter("id", id).getSingleResult();
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
