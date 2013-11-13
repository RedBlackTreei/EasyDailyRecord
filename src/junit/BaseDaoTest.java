package junit;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import onlyfun.js.dao.impl.BaseDaoImpl;
import onlyfun.js.model.Record;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseDaoTest {
	
	private BaseDaoImpl dao = null;
	@Before
	public void setUp() throws Exception {
		dao = new BaseDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testSave() {
    	BaseDaoImpl bd = new BaseDaoImpl();
    	Record r = new Record();
    	java.util.Date date = new java.util.Date();
    	Timestamp tt = new Timestamp(date.getTime());
    	r.setBeginDate(tt);
    	r.setCompletionDesc("Justin");
    	r.setEmployeeId(1L);
    	r.setEndDate(tt);
    	r.setIsFinished(true);
    	r.setNormalHours(4.0);
    	r.setOverTimeHours(2.0);
    	r.setPlanType("项目沟通11");
    	bd.save(r);
	}

	@Test
	public void testDeleteById() {
//		dao.deleteById(Record.class, 8L);
		assertEquals(1,dao.deleteById(Record.class, 7L));
	}

	@Test
	public void testDelete() {
		Record r = new Record();
		r.setId(14L);
		assertEquals(1,dao.delete(r));
	}

	@Test
	public void testUpdate() {
		fail("尚未实现");
	}

	@Test
	public void testFindById() {
		Record r = (Record)dao.findById(Record.class, 11L);
		System.out.println();
	}

	@Test
	public void testFindByExample() {
		fail("尚未实现");
	}

	@Test
	public void testFindAll() {
		fail("尚未实现");
	}

}
