package it.ldlife.mongo.dao;

import it.ldlife.base.MongoBaseDao;
import it.ldlife.pojo.User;

/**
 * Created by xubinhui on 17-5-17.
 */
public interface UserDao extends MongoBaseDao<User> {

	int checkUserName(String username);

	int checkEmail(String email);

	User selectQuestionByUserName(String userName);

	boolean checkAnswer(String username, String question, String answer);
}
