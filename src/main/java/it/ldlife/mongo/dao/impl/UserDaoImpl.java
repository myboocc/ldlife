package it.ldlife.mongo.dao.impl;

import it.ldlife.base.MongoBaseDaoImpl;
import it.ldlife.mongo.dao.UserDao;
import it.ldlife.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * Created by xubinhui on 17-5-17.
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends MongoBaseDaoImpl<User> implements UserDao {
}
