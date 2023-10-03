package com.scsb.t.dao;

import com.scsb.t.entity.EmployeeLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    //define field for entity Manager
    private  EntityManager entityManager;
    //inject entity manager using constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public EmployeeDAOImpl() {

    }

    @Override
    @Transactional
    public void save(EmployeeLogin employeeLogin) {
        entityManager.persist(employeeLogin);
    }

    @Override
    public EmployeeLogin findById(String Emp_id) {
        return entityManager.find(EmployeeLogin.class, Emp_id);
    }

    @Override
    public List<EmployeeLogin> findAll() {
        //create query
        //後面放Class Name不是Table Name
        TypedQuery<EmployeeLogin> theQuery = entityManager.createQuery("FROM EmployeeLogin", EmployeeLogin.class);
        //return query
        return theQuery.getResultList();
    }

    @Override
    public List<EmployeeLogin> findAllByEmpId(String Emp_id) {
        TypedQuery<EmployeeLogin> theQueryEmpId = entityManager.createQuery("FROM EmployeeLogin where Emp_id =:theData", EmployeeLogin.class);
        theQueryEmpId.setParameter("theData", Emp_id);
        return theQueryEmpId.getResultList();
    }

    //inplement checkAccount method
    @Override
    @Transactional
    public Boolean checkAccount(EmployeeLogin employeeLogin) {
        entityManager.persist(employeeLogin);
        return false;
    }
}
