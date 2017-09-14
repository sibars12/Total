package org.kg.gv.DAO;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class member {
	
	@Autowired
	SqlSessionTemplate template;
	
	public boolean addOne(Map map) {
		System.out.println(map);
		int a=template.insert("member.addBasic", map);
		int b=template.insert("member.addDetail", map);
		
		return (a+b)==2;
	}
	public int existOne(Map map) {
		return template.selectOne("member.checkByIdmailAndPass", map);
	}
}
