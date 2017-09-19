package org.kg.gv.DAO;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class member {

	@Autowired
	SqlSessionTemplate template;

	public boolean addOne(Map map) {
		System.out.println(map);
		int a = template.insert("member.addBasic", map);
		int b = template.insert("member.addDetail", map);
		System.out.println(a + b);

		return (a + b) == 2;
	}

	public Map existOne(Map map) {
		return template.selectOne("member.checkByIdmailAndPass", map);
	}

	public List<Map> proall(String id) {

		return template.selectList("member.proall", id);
	}

	public Map proone(String id) {

		return template.selectOne("member.proone", id);
	}

	public int addpro(Map map) {
		return template.insert("member.addpro", map);
	}

	public Map getid(String id) {
		return template.selectOne("member.getid", id );
	}
	public List<Map> allpro(Map map) {
		System.out.println(map);
		return template.selectList("member.allpro",map);
	}
	public int all() {
		return template.selectOne("member.all");
	}
	
}
