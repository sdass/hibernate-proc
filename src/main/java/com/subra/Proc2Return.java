package com.subra;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;

// modify with http://www.baeldung.com/stored-procedures-with-hibernate-tutorial

@Entity
@NamedNativeQueries({
		@NamedNativeQuery( name = "callTwoMappedRetsHibernate", 
						   query = "hibnatedb.getNameRatingById(:pid)", 
						   resultClass = Proc2Return.class
				       )
})
@NamedStoredProcedureQuery(name="findTwoMappedReturns", procedureName="hibnatedb.getNameRatingById", resultSetMappings="TwoColumnReturnBelow", parameters = {
	@StoredProcedureParameter(name="id", type=Integer.class)		
})
@SqlResultSetMapping(name="TwoColumnReturnBelow", classes= @ConstructorResult(targetClass=Proc2Return.class, columns = {
	@ColumnResult(name="name"),
	@ColumnResult(name="rankings")
	
  }	))
public class Proc2Return {

	public Proc2Return() {}
	
	//@SuppressWarnings("unused")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private Integer ranking;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Proc2Return(String name, Integer ranking) {
		super();
		this.name = name;
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "Proc2Return [name=" + name + ", ranking=" + ranking + "]";
	}
	
	

}
