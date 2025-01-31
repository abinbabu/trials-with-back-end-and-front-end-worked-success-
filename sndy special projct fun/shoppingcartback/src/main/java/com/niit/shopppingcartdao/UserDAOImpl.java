package com.niit.shopppingcartdao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.User;


@Repository("userDao")
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	};
	
	
	
	
	
	@Transactional
	public void delete(String id){
		User UserToDelete=new User();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
		
	}
	
	@Transactional
	public User get(String id){
		String hql= "from User where id=" + "'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser=query.list();
		
		if(listUser != null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;
		
	}
	
	@Transactional
	public List<User> list(){
		@SuppressWarnings("unchecked")
		List<User> listUser=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
		     
	}
	
	@Transactional
	public boolean isValidUser(String id, String password, boolean isAdmin) {
		String hql = "from User where id= '" + id + "' and " + " password ='" + password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	
	
	

}
