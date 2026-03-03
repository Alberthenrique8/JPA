//package org.example;
//
//import br.com.albert.domain.Produto;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Produto produto = new Produto("Machado", "10");
//
//        session.persist(produto);
//
//        transaction.commit();
//        session.close();
//
//        System.out.println("Salvo com sucesso!");
//    }
//}