package it.ldlife.mongo.dao.impl;

import it.ldlife.base.MongoBaseDaoImpl;
import it.ldlife.mongo.dao.UserDao;
import it.ldlife.pojo.User;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by xubinhui on 17-5-17.
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends MongoBaseDaoImpl<User> implements UserDao {

	@Override
	public int checkUserName(String username) {
		Query query = new Query();
    	query.addCriteria(Criteria.where("username").is(username));
    	User user = this.mongoTemplate.findOne(query, this.getEntityClass());
    	if(user != null){
    		return 1;
    	}
		return 0;
	}

	@Override
	public int checkEmail(String email) {
		Query query = new Query();
    	query.addCriteria(Criteria.where("email").is(email));
    	User user = this.mongoTemplate.findOne(query, this.getEntityClass());
    	if(user != null){
    		return 1;
    	}
		return 0;
	}

	@Override
	public User selectQuestionByUserName(String userName) {
		Query query = new Query();
    	query.addCriteria(Criteria.where("username").is(userName));
    	User user = this.mongoTemplate.findOne(query, this.getEntityClass());
		return user;
	}

	@Override
	public boolean checkAnswer(String username, String question, String answer) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username).and("question").is(question).and("answer").is(answer));
		return this.mongoTemplate.exists(query, this.getEntityClass());
	}
}
