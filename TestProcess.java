package JavaDevs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Assert;



public class TestProcess {
	private LinkedList<LinkedList<String>> list;
	Process test = new Process();
	
	@Before
	public void setUp() {
		
		list.get(0).add("AM"); 
		list.get(1).add("Name");
		list.get(2).add("Surname");

		list.get(0).add("8170067");
		list.get(0).add("8170133");
		list.get(0).add("8170036");
		list.get(0).add("8170053");
		list.get(0).add("8170091");
		list.get(0).add("8170057");
		list.get(0).add("8170126");
		
		list.get(1).add("Giannis");
		list.get(2).add("Methenitis");
		
		list.get(1).add("Danai");
		list.get(2).add("Tzoumpa");

		list.get(1).add("Ioanna");
		list.get(2).add("Kalogeropoulou");

		list.get(1).add("Pantelis");
		list.get(2).add("Kirpoglou");
		
		list.get(1).add("Alice");
		list.get(2).add("Douzgou");
		
		list.get(1).add("Anna");
		list.get(2).add("Kotsa");

		list.get(1).add("Aristi");
		list.get(2).add("Syriou");
	}
	
	@Test
	public LinkedList<LinkedList<String>> testinput (LinkedList<LinkedList<String>> list) {
		list.get(0).add("12345");
		list.get(1).add("TestName");
		list.get(2).add("TestSurname");
		
		Assert.assertFalse("Failure - new record has not been inputed", !list.get(0).contains("12345"));
		Assert.assertEquals("Failure - wrong size", 8, list.get(0).size());
		
		return list;
		
	}
	@Test
	public LinkedList<LinkedList<String>> testDeleteTheBase(LinkedList<LinkedList<String>> list) {
		Assert.assertFalse("failure - the base has not been deleted", list.isEmpty());
		return list;
	}
	@Test
	public LinkedList<LinkedList<String>> testDeleteRecord(LinkedList<LinkedList<String>> list) {
		list.get(0).remove(2);
		list.get(1).remove(2);
		list.get(2).remove(2);
		
		Assert.assertTrue("failure - element has not been deleted", list.get(0).contains("8170133"));
		
		Assert.assertEquals("failure - wrong size", 8, list.get(0).size());	
		
		return list;
	}
	@Test
	public LinkedList<LinkedList<String>> testViewEverything(LinkedList<LinkedList<String>> list) {
		Assert.assertFalse("failure - there is nothing to be viewed/list is empty", list.isEmpty());
		return list;
	} //end of testViewEverything method

	@Test
	public LinkedList<LinkedList<String>> testViewbyPrimKey(LinkedList<LinkedList<String>> list) {
		 Assert.assertTrue("failure - does not contain primary key", list.contains("8170053"));
		 Assert.assertEquals("failure - wrong size", list.get(0).size(), 7);
		 return list;
	} //end of testViewbyPrimKey method

	@Test
	public LinkedList<LinkedList<String>> testViewbyItem(LinkedList<LinkedList<String>> list) {
		Assert.assertFalse("failure - does not contain the item", list.contains("Anna"));
		Assert.assertEquals("failure - wrong size", list.get(0).size(), 7);
		return list;
	} //end of testViewbyItem
	
	
	@Test 
	public void testEdit(LinkedList<LinkedList<String>> list) {
		
		LinkedList<LinkedList<String>> editedList = test.edit(list);
		 Assert.assertEquals("Failure - no correlation between values", editedList.get(test.p).get(test.ak), test.newValue);
	     
    }
	@After
    public void tearDown() {
    	list = null;
    }
	
	
}
