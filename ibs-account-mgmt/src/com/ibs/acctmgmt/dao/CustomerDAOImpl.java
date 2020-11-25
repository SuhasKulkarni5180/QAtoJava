package com.ibs.acctmgmt.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibs.acctmgmt.entity.BankAccount;
import com.ibs.acctmgmt.entity.BankTransaction;
import com.ibs.acctmgmt.entity.Customer;
import com.ibs.acctmgmt.entity.Login;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(theCustomer);
		
	}

	@Override
	public void createAccount(BankAccount bankAccount) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(bankAccount);
		
	}
	
	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public List<BankAccount> getAccountBalances(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		final List<BankAccount> results = new LinkedList<>();
		
		String queryString = "from BankAccount ba where ba.custId=:custId";
		
		//NativeQuery<String> query = currentSession.createNativeQuery(queryString);
		Query<BankAccount> query = currentSession.createQuery(queryString);
		
		query.setParameter("custId", 100);
		for(final Object o : query.list()) {
			results.add((BankAccount)o);
		}	
		
		return results;
		
		/*// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				// create a query
				Query<BankAccount> theQuery = 
						currentSession.createQuery("from BankAccount", BankAccount.class);
				
				// execute query and get result list
				List<BankAccount> accountDetails = theQuery.getResultList();
						
				// return the results		
				return accountDetails;*/
	}

	@Override
	public void saveTrans(BankTransaction bankTransaction) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(bankTransaction);
		
	}
	
	@Override
	@Transactional
	public List<BankTransaction> getTrasactionsById(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();	
		String queryString = "from BankTransaction bt where bt.custId=:custId order by bt.id desc";
		
		Query<BankTransaction> query = currentSession.createQuery(queryString);
		
		query.setParameter("custId", id);

		return query.list();
	}

	@Override
	public BankAccount getAccountById(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		BankAccount accnt = currentSession.get(BankAccount.class, theId);
		
		return accnt;
	}

	@Override
	public List<BankTransaction> getMiniStatement(int i) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		//final List<BankTransaction> results = new LinkedList<>();
		
		String queryString = "from BankTransaction bt where bt.custId=:custId order by bt.id desc";
		
		//NativeQuery<String> query = currentSession.createNativeQuery(queryString);
		Query<BankTransaction> query = currentSession.createQuery(queryString);
		
		query.setParameter("custId", i);
		query.setMaxResults(5);
		
		/*for(final Object o : query.list()) {
			results.add((BankTransaction)o);
		}	*/
		
		return query.list();
	}

	@Override
	public Login login(String usrName) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		String queryString = "from Login l where l.userName=:name";
		Query<Login> query = currentSession.createQuery(queryString);
		
		query.setParameter("name", usrName);	
		
		return query.list().get(0);
		
	}
	
}






