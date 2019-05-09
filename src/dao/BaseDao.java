package dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class BaseDao extends SqlMapClientDaoSupport {
	public void save(String id,Object obj){
		getSqlMapClientTemplate().insert(id,obj);
	}
	public void delete(String id,Object obj){
		getSqlMapClientTemplate().delete(id,obj);
	}
	public void update(String id,Object obj){
		getSqlMapClientTemplate().update(id,obj);
	}
	public Object findById(String id,Object obj){
		return getSqlMapClientTemplate().queryForObject(id,obj);
	}
	public List all(String id,Object obj){
		return getSqlMapClientTemplate().queryForList(id,obj);
	}
}
