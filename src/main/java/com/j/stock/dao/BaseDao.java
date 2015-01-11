package com.j.stock.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;


public class BaseDao extends SqlMapClientDaoSupport{
    @Autowired
    public void setSqlMapClientBase(SqlMapClient sqlMapClient) {  
        super.setSqlMapClient(sqlMapClient);  
    } 
    
    /**
     * 查询对象
     * @Title: queryForObject 
     * @Description: TODO
     * @param @param key
     * @param @param param
     * @param @return    设定文件 
     * @return Object    返回类型 
     * @throws
     */
    public Object queryForObject(String key, Object param) {
        return this.getSqlMapClientTemplate().queryForObject(key, param);
    }
    
    /**
     * 查询LIST
     * @Title: queryForList 
     * @Description: TODO
     * @param @param key
     * @param @param param
     * @param @return    设定文件 
     * @return List<?>    返回类型 
     * @throws
     */
    public List<?> queryForList(String key, Object param) {
        return this.getSqlMapClientTemplate().queryForList(key, param);
    }
    
    /**
     * 插入
     * @Title: insert 
     * @Description: TODO
     * @param @param key
     * @param @param param
     * @param @return    设定文件 
     * @return Object    返回类型 
     * @throws
     */
    public Object insert(String key, Object param) {
        return this.getSqlMapClientTemplate().insert(key, param);
    }
    
    /**
     * 修改
     * @Title: update 
     * @Description: TODO
     * @param @param key
     * @param @param param
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    public int update(String key, Object param) {
        return this.getSqlMapClientTemplate().update(key, param);
    }
    
    /**
     * 删除
     * @Title: delete 
     * @Description: TODO
     * @param @param key
     * @param @param param
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    public int delete(String key, Object param) {
        return this.getSqlMapClientTemplate().delete(key, param);
    }
}
