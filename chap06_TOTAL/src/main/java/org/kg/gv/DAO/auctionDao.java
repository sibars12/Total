package org.kg.gv.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class auctionDao {

	@Autowired
	SqlSessionTemplate template;
	
	public boolean add(Map map) {
		boolean b=template.insert("auction.add" , map)==1;
		return b;
	}
	public List<Map> list(){
		return template.selectList("auction.list");
	}
	public List<Map> uper(Map map){
		return template.selectList("auction.uper");
	}
	public Map read(String no) {
		return template.selectOne("auction.read",no);
	}
}
