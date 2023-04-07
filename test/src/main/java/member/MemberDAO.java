package member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	
	@Autowired private SqlSession sql;
	
	public void join() {
		sql.selectOne("sqlmap.mapper.join");
	}
}
