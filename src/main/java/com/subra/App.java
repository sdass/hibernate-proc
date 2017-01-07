package com.subra;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        teamsEntity(session);
        System.exit(0);
        
        session.beginTransaction();
        Stock stock = new Stock();
        
        stock.setStockCode("4717");
        stock.setStockName("APL");
        
        session.save(stock);
        session.getTransaction().commit();
    }
    public static void addteamRec(Session session){
    	session.beginTransaction();
    	Teams ateam = new Teams();
    	ateam.setName("Indian");
    	ateam.setRating(77);
    	session.save(ateam);
    	session.getTransaction().commit();
    }
    
    public static void teamsEntity(Session session){
    	System.out.println("--Maven + Hibernate + MySQL with Users entity--");	
    	//addteamRec(session);
    	//justname(session);
    	//records(session);
    	//storeprocSql(session);
    	//storeprocSqlParam(session);
    	storeprocSql2Parampassed(session);
    	//callprocHbmCfg(session);
    	callprocHbmCfg2param(session);
    }
    
    public static void callprocHbmCfg(Session session){
    	System.out.println("callprocHbmCfg-=-=-=-");
    	Query query = session.getNamedQuery("callprocNamexml");
    	query.setParameter("pname", "Indian");
    	  List<Integer> ids = query.list();
      	for(Integer id : ids){
      		System.out.println(id);
      	}
    	
    }
    
    public static void callprocHbmCfg2param(Session session){
    	System.out.println("callprocHbmCfg2param-=-=-=-");
    	Query query = session.getNamedQuery("callprocNamexml2param");
    	query.setParameter("pname", "Indian").setParameter("prank", 18); //77
    	  List<Integer> ids = query.list();
      	for(Integer id : ids){
      		System.out.println(id);
      	}
    	
    }    
    
    public static void storeprocSql2Parampassed(Session session){
    	System.out.println("storeprocSql2Parampassed-=-=-=-");
    	String procQueryString = "call hibnatedb.getId(:pname, :prank)"; // "call teams";
    	Query query = session.createSQLQuery(procQueryString) ;
    	//query.setParameter("pname", "Yankee");
    	int rank = 77; //18;
    	query.setParameter("pname", "Indian").setParameter("prank", rank);
    	
        List<Integer> ids = query.list();
    	for(Integer id : ids){
    		System.out.println(id);
    	}
    }
    
    public static void storeprocSqlParam(Session session){
    	System.out.println("storeprocSqlParam-=-=-=-");
    	String procQueryString = "call hibnatedb.getName(:pname)"; // "call teams";
    	Query query = session.createSQLQuery(procQueryString) ;
    	//query.setParameter("pname", "Yankee");
    	query.setParameter("pname", "Indian");
    	
        List<Integer> ids = query.list();
    	for(Integer id : ids){
    		System.out.println(id);
    	}
    }
    public static void justname(Session session){
    	String queryString = "select name from Teams";
    	Query query = session.createQuery(queryString) ;
    	List<String> names = query.list();
    	for(String name : names){
    		System.out.println(name);
    	}
    }
    
    public static void records(Session session){
    	String queryString = "from Teams";
    	Query query = session.createQuery(queryString) ;
    	List<Teams> teams = query.list();
    	for(Teams t : teams){
    		System.out.println(t.toString());
    	}
    }
    
    public static void storeprocSql(Session session){
    	System.out.println("storeprocSql-=-=-=-");
    	String procQueryString = "call hibnatedb.getName('Indian')"; // "call teams";
    	Query query = session.createSQLQuery(procQueryString) ;
    	
        List<Integer> ids = query.list();
    	for(Integer id : ids){
    		System.out.println(id);
    	}
    }
    
    
}
