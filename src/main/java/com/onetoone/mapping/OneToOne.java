package com.onetoone.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Question q1 = new Question();
		q1.setQuestionId(11);
		q1.setQuestion("what is java");
		
		Answer answer1 =new Answer();
		answer1.setAnswerId(21);
		answer1.setAnswer("java is programming language");
		answer1.setQuestion(q1);
		
		q1.setAnswer(answer1);
		
		Question q2 = new Question();
		q2.setQuestionId(12);
		q2.setQuestion("what is collection framework");
		
		Answer answer2 =new Answer();
		answer2.setAnswerId(22);
		answer2.setAnswer("APL to work with object in java");
		answer2.setQuestion(q2);
		
		q2.setAnswer(answer2);
		
		session.save(q1);
		session.save(q2);
		session.save(answer1);
		session.save(answer2);
		t.commit();
		session.close();
		factory.close();
	}
}
