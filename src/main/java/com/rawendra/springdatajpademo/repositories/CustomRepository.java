package com.rawendra.springdatajpademo.repositories;


import com.rawendra.springdatajpademo.entities.TeacherEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomRepository {

  @Autowired
  private SessionFactory sessionFactory;

  public void addTeacherRecord(TeacherEntity teacherEntity){

    Session session=sessionFactory.getCurrentSession();
    session.beginTransaction();
    session.persist(teacherEntity);
    session.getTransaction().commit();


  }


}
