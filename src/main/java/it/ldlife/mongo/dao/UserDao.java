package it.ldlife.mongo.dao;

import com.mongodb.WriteResult;
import it.ldlife.base.MongoBaseDao;
import it.ldlife.pojo.User;
import it.ldlife.util.Page;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created by xubinhui on 17-5-17.
 */
public interface UserDao extends MongoBaseDao<User> {

}
