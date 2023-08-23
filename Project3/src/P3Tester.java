/** Example of using unit tests for this assignment.  To run them on the command line, make
 * sure that the junit-cs211.jar is in the same directory.  
 * 
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar E3Tester        # run tests
 * 
 * On windows replace colons with semicolons: (: with ;)
 *  demo$ javac -cp .;junit-cs211.jar *.java   # compile everything
 *  demo$ java -cp .;junit-cs211.jar E3Tester  # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
  
public class P3Tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("P3Tester");
  }
  
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  DLNode class Tester %%%%%%%%%%%%%%%%%%%%%%%%%%%% 
  
  
  Integer integerInput[] = {55, -39, 27, 15, -98, 6669};
  String stringDLInput[] = {"Lexus","Nissan","VolksWagen","Ferrari","Cheverolet","Fiat"};
  DLNode nodes[]  =  {new DLNode<>("lexux"), new DLNode<>("25.5f"), new DLNode<>("45")};
  
  int [] size = {1,2,3,4,5,6};
  int len1 = integerInput.length;
  int len2 = stringDLInput.length;

  
  @Test public void DLNode_construct_def_01() { 
       
	  DLNode<Integer> d = new DLNode<>(integerInput[0]);
	  DLNode<String> d1 = new DLNode<>();
	  DLNode<String> d2 = new DLNode<>(stringDLInput[0]);
	          assertEquals("constructor DLNode() is incorrect", integerInput[0], d.getData());
	          assertEquals("constructor DLNode() is incorrect", null, d1.getData());
	          assertEquals("constructor DLNode() is incorrect", stringDLInput[0], d2.getData());
	          assertEquals("constructor DLNode() is incorrect", null, d1.getNext());
	          assertEquals("constructor DLNode() is incorrect", null, d1.getPrev());
	          assertEquals("constructor DLNode() is incorrect", null, d.getNext());
	          assertEquals("constructor DLNode() is incorrect", null, d1.getPrev());
	        
	    }
  void checkSetGet_DLNode_01(int a) {
	  DLNode<String> f = new DLNode<>("");
	   f.setData(stringDLInput[a]);
	  String errMsg = String.format("set/getData(%s) for DLNode incorrect", stringDLInput[a]);
	  assertEquals(errMsg, stringDLInput[a], f.getData());
  }
     
  @Test(timeout=1000) public void checkSetGet_DLNode_00() { checkSetGet_DLNode_01(0); }
  @Test(timeout=1000) public void checkSetGet_DLNode_01() { checkSetGet_DLNode_01(1); }
  @Test(timeout=1000) public void checkSetGet_DLNode_02() { checkSetGet_DLNode_01(2); }
  @Test(timeout=1000) public void checkSetGet_DLNode_03() { checkSetGet_DLNode_01(3); }
  @Test(timeout=1000) public void checkSetGet_DLNode_04() { checkSetGet_DLNode_01(4); }
  @Test(timeout=1000) public void checkSetGet_DLNode_05() { checkSetGet_DLNode_01(5); }
  
  void checkSetGet_DLNode_02(int a) {
	  DLNode<Integer> f = new DLNode<Integer>(0);
	   f.setData(integerInput[a]);
	  String errMsg = String.format("set/getData(%d) for DLNode incorrect", integerInput[a]);
	  assertEquals(errMsg, integerInput[a], f.getData());
  }
     
  @Test(timeout=1000) public void checkSetGet_DLNode_06() { checkSetGet_DLNode_02(0); }
  @Test(timeout=1000) public void checkSetGet_DLNode_07() { checkSetGet_DLNode_02(1); }
  @Test(timeout=1000) public void checkSetGet_DLNode_08() { checkSetGet_DLNode_02(2); }
  @Test(timeout=1000) public void checkSetGet_DLNode_09() { checkSetGet_DLNode_02(3); }
  @Test(timeout=1000) public void checkSetGet_DLNode_10() { checkSetGet_DLNode_02(4); }
  @Test(timeout=1000) public void checkSetGet_DLNode_11() { checkSetGet_DLNode_02(5); }
  
  
  void checkSetGetNext_DLNode_02(int a) {
	  DLNode f = new DLNode<>(0);
	   f.setNext(nodes[a]);
	  String errMsg = String.format("set/getNext() for DLNode incorrect");
	  assertEquals(errMsg, nodes[a], f.getNext());
  }
     
  @Test(timeout=1000) public void checkSetGetNext_DLNode_06() { checkSetGetNext_DLNode_02(0); }
  @Test(timeout=1000) public void checkSetGetNext_DLNode_07() { checkSetGetNext_DLNode_02(1); }
  @Test(timeout=1000) public void checkSetGetNext_DLNode_08() { checkSetGetNext_DLNode_02(2); }
  
  
  void checkSetGetPrev_DLNode_02(int a) {
	  DLNode f = new DLNode<>(0);
	   f.setPrev(nodes[a]);
	  String errMsg = String.format("set/getPrev() for DLNode incorrect");
	  assertEquals(errMsg, nodes[a], f.getPrev());
  }
     
  @Test(timeout=1000) public void checkSetGetPrev_DLNode_06() { checkSetGetPrev_DLNode_02(0); }
  @Test(timeout=1000) public void checkSetGetPrev_DLNode_07() { checkSetGetPrev_DLNode_02(1); }
  @Test(timeout=1000) public void checkSetGetPrev_DLNode_08() { checkSetGetPrev_DLNode_02(2); }
  
  
  //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  OneEndContainer class Tester %%%%%%%%%%%%%%%%%%%%%%%%%%%% 
  
  @Test(timeout=1000) public void OneEndContainer_construct_def_00() { 
	  OneEndContainer<String> s = new OneEndContainer<>();
     // assertEquals("Default constructor (OneEndContainer) is incorrect", 100, s.getCapacity());
      assertEquals("Default constructor (OneEndContainer) is incorrect", 0, s.size());
      OneEndContainer<Integer> s1 = new OneEndContainer<>();
      
      //assertEquals("Non-Default constructor (OneEndContainer) is incorrect", 55, s1.getCapacity());
      assertEquals("Non-Default constructor (OneEndContainer) is incorrect", 0, s1.size());
       
    }
 
  @Test(timeout=1000) public void OneEndContainer_Inheritance_def_00() { 
		OneEndContainer<Integer> s = new OneEndContainer<>();
		OneEndContainer<Boolean> s1 = new OneEndContainer<>();	  
	    assertEquals("OneEndContainer does not implement the correct inheritance(DataContainer)", true, s instanceof DataContainer);
	    assertEquals("OneEndContainer does not implement the correct inheritance(DataContainer)", true, s1 instanceof DataContainer);
	     assertEquals("Non-Default constructor (OrderedContainer) is incorrect", 0, s1.size());
	   
	}

  
  String stringInput[] = {"Garvey","King","Malcom","Baldwin","Lawson","Lewis","Minilik","Brown"};
  Float floatInput[] = {25.5f,0.0f,-225.69f,98.32f,-897.0f,99.99f,10.5f,14.55f};
  int capacity[] = { 1, 10, 200, 89,586};
  int capacity2[] = { 1, 2, 3, 4,5,6,7,8};

  
  
  void checkIsEmpty_OneEndContainer() {
	  OneEndContainer<String> f = new OneEndContainer<>();
	  OneEndContainer<Integer> f1 = new OneEndContainer<>();
	  boolean result1 = f.isEmpty();
	  boolean result2 = f1.isEmpty();
	  String errMsg = String.format("isEmpty() for OneEndContainer incorrect");
	  assertEquals(errMsg, true,result1);
	  assertEquals(errMsg, true,result2);
  }
     
  @Test(timeout=1000) public void OneEndContainer_isEmpty_00() { checkIsEmpty_OneEndContainer(); }
  
  
  private static<T> T[] subArray(T[] array, int beg, int end) {
		return Arrays.copyOfRange(array, beg, end + 1);
	}
  void checkAdd_OneEndContainer(int a) {
	  int n = capacity2[a];
	  OneEndContainer<String> f = new OneEndContainer<>();
	  for(int i=n-1;i>=0;i--) 
		  f.add(stringInput[i]);
       String [] st =subArray(stringInput, 0,a);
       List  ss= Arrays.asList(st);
	  boolean result = (ss.toString()).equals(f.toString());
	  String errMsg = String.format("add() for OneEndContainer incorrect");
	  assertEquals(errMsg, true, result);
}

@Test(timeout=1000) public void OneEndContainer_add_00() { checkAdd_OneEndContainer(0); }
@Test(timeout=1000) public void OneEndContainer_add_01() { checkAdd_OneEndContainer(1); }
@Test(timeout=1000) public void OneEndContainer_add_02() { checkAdd_OneEndContainer(2); }
@Test(timeout=1000) public void OneEndContainer_add_03() { checkAdd_OneEndContainer(3); }
@Test(timeout=1000) public void OneEndContainer_add_04() { checkAdd_OneEndContainer(4); }
@Test(timeout=1000) public void OneEndContainer_add_05() { checkAdd_OneEndContainer(5); }
@Test(timeout=1000) public void OneEndContainer_add_06() { checkAdd_OneEndContainer(6); }
@Test(timeout=1000) public void OneEndContainer_add_07() { checkAdd_OneEndContainer(7); }

void checkAdd_OneEndContainer_0(int a) {
	  int n = capacity2[a];
	  OneEndContainer<Float> f = new OneEndContainer<>();
	  for(int i=n-1;i>=0;i--) 
		  f.add(floatInput[i]);
     Float [] st =subArray(floatInput, 0,a);
     List  ss= Arrays.asList(st);
	  boolean result = (ss.toString()).equals(f.toString());
	  String errMsg = String.format("add() for OneEndContainer incorrect");
	  assertEquals(errMsg, true, result);
}

@Test(timeout=1000) public void OneEndContainer_add_08() { checkAdd_OneEndContainer_0(0); }
@Test(timeout=1000) public void OneEndContainer_add_09() { checkAdd_OneEndContainer_0(1); }
@Test(timeout=1000) public void OneEndContainer_add_10() { checkAdd_OneEndContainer_0(2); }
@Test(timeout=1000) public void OneEndContainer_add_11() { checkAdd_OneEndContainer_0(3); }
@Test(timeout=1000) public void OneEndContainer_add_12() { checkAdd_OneEndContainer_0(4); }
@Test(timeout=1000) public void OneEndContainer_add_13() { checkAdd_OneEndContainer_0(5); }
@Test(timeout=1000) public void OneEndContainer_add_14() { checkAdd_OneEndContainer_0(6); }
@Test(timeout=1000) public void OneEndContainer_add_15() { checkAdd_OneEndContainer_0(7); }

String output[] = {"[Garvey]","[King, Garvey]","[Malcom, King, Garvey]","[Baldwin, Malcom, King, Garvey]", "[Lawson, Baldwin, Malcom, King, Garvey]","[Lewis, Lawson, Baldwin, Malcom, King, Garvey]", "[Minilik, Lewis, Lawson, Baldwin, Malcom, King, Garvey]", "[Brown, Minilik, Lewis, Lawson, Baldwin, Malcom, King, Garvey]"};
String outputRe ="[Brown, Minilik, Lewis, Lawson, Malcom, King, Garvey]";
String output1[] ={"[25.5]", "[0.0, 25.5]", "[-225.69, 0.0, 25.5]","[98.32, -225.69, 0.0, 25.5]", "[-897.0, 98.32, -225.69, 0.0, 25.5]","[99.99, -897.0, 98.32, -225.69, 0.0, 25.5]","[10.5, 99.99, -897.0, 98.32, -225.69, 0.0, 25.5]", "[14.55, 10.5, 99.99, -897.0, 98.32, -225.69, 0.0, 25.5]"};
String output1Re ="[14.55, 10.5, 99.99, 98.32, -225.69, 0.0, 25.5]";
void checktoString_OneEndContainer_0(int a) {
	  int n = capacity2[a];
	  OneEndContainer<Float> f = new OneEndContainer<>();
	 
	  for(int i=0;i<n;i++) 
	  {
		  f.add(floatInput[i]);
		  	  }
	
      String  st =f.toString();
      String errMsg = String.format("toString() for OneEndContainer() incorrect");
	  assertEquals(errMsg, output1[a], st);
}

@Test(timeout=1000) public void OneEndContainer_toString_00() { checktoString_OneEndContainer_0(0); }
@Test(timeout=1000) public void OneEndContainer_toString_01() { checktoString_OneEndContainer_0(1);  }
@Test(timeout=1000) public void OneEndContainer_toString_02() { checktoString_OneEndContainer_0(2); }
@Test(timeout=1000) public void OneEndContainer_toString_03() { checktoString_OneEndContainer_0(3);  }
@Test(timeout=1000) public void OneEndContainer_toString_04() { checktoString_OneEndContainer_0(4); }
@Test(timeout=1000) public void OneEndContainer_toString_05() { checktoString_OneEndContainer_0(5); }
@Test(timeout=1000) public void OneEndContainer_toString_06() { checktoString_OneEndContainer_0(6); }
@Test(timeout=1000) public void OneEndContainer_toString_07() { checktoString_OneEndContainer_0(7); }

void checktoString_OneEndContainer(int a) {
	  int n = capacity2[a];
	  OneEndContainer<String> f = new OneEndContainer<>();
	 
	  for(int i=0;i<n;i++) 
	  {
		  f.add(stringInput[i]);
		  	  }
	
    String  st =f.toString();
    String errMsg = String.format("toString() for OneEndContainer() incorrect");
	  assertEquals(errMsg, output[a], st);
}

@Test(timeout=1000) public void OneEndContainer_toString_08() { checktoString_OneEndContainer(0); }
@Test(timeout=1000) public void OneEndContainer_toString_09() { checktoString_OneEndContainer(1);  }
@Test(timeout=1000) public void OneEndContainer_toString_10() { checktoString_OneEndContainer(2); }
@Test(timeout=1000) public void OneEndContainer_toString_11() { checktoString_OneEndContainer(3);  }
@Test(timeout=1000) public void OneEndContainer_toString_12() { checktoString_OneEndContainer(4); }
@Test(timeout=1000) public void OneEndContainer_toString_13() { checktoString_OneEndContainer(5); }
@Test(timeout=1000) public void OneEndContainer_toString_14() { checktoString_OneEndContainer(6); }
@Test(timeout=1000) public void OneEndContainer_toString_15() { checktoString_OneEndContainer(7); }

  
  void checkIsFull_OneEndContainer(int a) {
	  int n = capacity2[a];
	  OneEndContainer<String> f = new OneEndContainer<>();
	  OneEndContainer<Float> f1 = new OneEndContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	  boolean result = f.isFull();
	  boolean result1 = f1.isFull();
	  String errMsg = String.format("isFull() for OneEndContainer(%d) incorrect", n);
	  assertEquals(errMsg, false, result);
	  assertEquals(errMsg, false, result1);
  }
     
  @Test(timeout=1000) public void OneEndContainer_isFull_00() { checkIsFull_OneEndContainer(0); }
  @Test(timeout=1000) public void OneEndContainer_isFull_01() { checkIsFull_OneEndContainer(1); }
  @Test(timeout=1000) public void OneEndContainer_isFull_02() { checkIsFull_OneEndContainer(2); }
  @Test(timeout=1000) public void OneEndContainer_isFull_03() { checkIsFull_OneEndContainer(3); }
  @Test(timeout=1000) public void OneEndContainer_isFull_04() { checkIsFull_OneEndContainer(4); }
  @Test(timeout=1000) public void OneEndContainer_isFull_05() { checkIsFull_OneEndContainer(5); }
  @Test(timeout=1000) public void OneEndContainer_isFull_06() { checkIsFull_OneEndContainer(6); }
  
  void checkClear_OneEndContainer(int a) {
	  int n = capacity2[a];
	  OneEndContainer<String> f = new OneEndContainer<>();
	  OneEndContainer<Float> f1 = new OneEndContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	   f.clear();
	  f1.clear();
	 // f.clear();
	  boolean result = f.isEmpty();
	  boolean result1 = f1.isEmpty();
	  String errMsg = String.format("clear() for OneEndContainer incorrect", n);
	  assertEquals(errMsg, true, result);
	  assertEquals(errMsg, true, result1);
	  assertEquals(errMsg,0,f.size());
	  assertEquals(errMsg,0,f1.size());
  }
     
  @Test(timeout=1000) public void OneEndContainer_isClear_00() { checkClear_OneEndContainer(0); }
  @Test(timeout=1000) public void OneEndContainer_isClear_01() { checkClear_OneEndContainer(1); }
  @Test(timeout=1000) public void OneEndContainer_isClear_02() { checkClear_OneEndContainer(2); }
  @Test(timeout=1000) public void OneEndContainer_isClear_03() { checkClear_OneEndContainer(3); }
  @Test(timeout=1000) public void OneEndContainer_isClear_04() { checkClear_OneEndContainer(4); }
  @Test(timeout=1000) public void OneEndContainer_isClear_05() { checkClear_OneEndContainer(5); }
  @Test(timeout=1000) public void OneEndContainer_isClear_06() { checkClear_OneEndContainer(6); }
  @Test(timeout=1000) public void OneEndContainer_isClear_07() { checkClear_OneEndContainer(7); }

  @Test(expected = EmptyContainerException.class) 
  public void OneEndContainer_isClear_08() {
	  OneEndContainer<String> f = new OneEndContainer<>();
	  f.clear();
  }
void checkRemove_OneEndContainer(int a) {
	  int n = capacity2[a];
	  OneEndContainer<String> f = new OneEndContainer<>();
	  OneEndContainer<Float> f1 = new OneEndContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	 String result = f.remove();
	 Float result1=f1.remove();
	  String errMsg = String.format("remove() for OneEndContainer() incorrect", n);
	  assertEquals(errMsg, stringInput[a], result );
	  assertEquals(errMsg, floatInput[a], result1 );
}
   
@Test(timeout=1000) public void OneEndContainer_remove_00() { checkRemove_OneEndContainer(0); }
@Test(timeout=1000) public void OneEndContainer_remove_01() { checkRemove_OneEndContainer(1); }
@Test(timeout=1000) public void OneEndContainer_remove_02() { checkRemove_OneEndContainer(2); }
@Test(timeout=1000) public void OneEndContainer_remove_03() { checkRemove_OneEndContainer(3); }
@Test(timeout=1000) public void OneEndContainer_remove_04() { checkRemove_OneEndContainer(4); }
@Test(timeout=1000) public void OneEndContainer_remove_05() { checkRemove_OneEndContainer(5); }
@Test(timeout=1000) public void OneEndContainer_remove_06() { checkRemove_OneEndContainer(6); }
@Test(timeout=1000) public void OneEndContainer_remove_07() { checkRemove_OneEndContainer(7); }

@Test(expected = EmptyContainerException.class) 
public void OneEndContainer_remove_08() {
	  OneEndContainer<String> f = new OneEndContainer<>();
	  f.remove();
}

void checkRemoveOverloaded_OneEndContainer(int a) {
	  int n = capacity2[a];
	  OneEndContainer<String> f = new OneEndContainer<>();
	  OneEndContainer<Float> f1 = new OneEndContainer<>();
	  for(int i=0;i<8;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
    f.remove("Baldwin");
	f1.remove(-897.0f);
	
	 String result = f.toString();
	 String result1 = f1.toString();
	 String errMsg = String.format("remove(%s) for OneEndContainer() incorrect", "Baldwin");
	  String errMsg1 = String.format("remove(%f) for OneEndContainer() incorrect", -897.0f);
	  assertEquals(errMsg, outputRe, result );
	  assertEquals(errMsg1, output1Re, result1 );
	  assertEquals(errMsg, false, f.remove("hello"));
	  assertEquals(errMsg1, false, f1.remove(444.44f));
	  
}
 
@Test(timeout=1000) public void OneEndContainer_removeOverloaded_00() { checkRemoveOverloaded_OneEndContainer(0); }

@Test(expected = EmptyContainerException.class) 
public void OneEndContainer_removeOverloaded_08() {
	  OneEndContainer<String> f = new OneEndContainer<>();
	  f.remove("Hello");
}
void checkGetLast_OneEndContainer(int a) {
	 // int n = capacity2[a];
	  OneEndContainer<String> f = new OneEndContainer<>();
	  OneEndContainer<Float> f1 = new OneEndContainer<>();
	  for(int i=0;i<8;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	  String result = f.getLast();
	  Float result1 = f1.getLast();
	  String errMsg = String.format("GetLast() forOneEndContainer() incorrect");
	  assertEquals(errMsg, stringInput[0], result );
	  assertEquals(errMsg, floatInput[0], result1 );
}
 
@Test(timeout=1000) public void OneEndContainer_getLast_00() { checkGetLast_OneEndContainer(0); }
@Test(timeout=1000) public void OneEndContainer_getLast_01() { checkGetLast_OneEndContainer(1); }
@Test(timeout=1000) public void OneEndContainer_getLast_02() { checkGetLast_OneEndContainer(2); }
@Test(timeout=1000) public void OneEndContainer_getLast_03() { checkGetLast_OneEndContainer(3); }
@Test(timeout=1000) public void OneEndContainer_getLast_04() { checkGetLast_OneEndContainer(4); }
@Test(timeout=1000) public void OneEndContainer_getLast_05() { checkGetLast_OneEndContainer(5); }
@Test(timeout=1000) public void OneEndContainer_getLast_06() { checkGetLast_OneEndContainer(6); }
@Test(timeout=1000) public void OneEndContainer_getLast_07() { checkGetLast_OneEndContainer(7); }

@Test(expected = EmptyContainerException.class) 
public void OneEndContainer_getLast_08() {
	  OneEndContainer<String> f = new OneEndContainer<>();
	  f.getLast();
}
void checkGetFirst_OneEndContainer(int a) {
	// int n = capacity2[a];
	OneEndContainer<String> f = new OneEndContainer<>();
	  OneEndContainer<Float> f1 = new OneEndContainer<>();
	  for(int i=0;i<a;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	  String result = f.getFirst();
	  Float result1 = f1.getFirst();
	  String errMsg = String.format("GetFirst() forOneEndContainer() incorrect");
	  assertEquals(errMsg, stringInput[a-1], result );
	  assertEquals(errMsg, floatInput[a-1], result1 );
}

//@Test(timeout=1000) public void OneEndContainer_getFirst_00() { checkGetFirst_OneEndContainer(0); }
@Test(timeout=1000) public void OneEndContainer_getFirst_01() { checkGetFirst_OneEndContainer(1); }
@Test(timeout=1000) public void OneEndContainer_getFirst_02() { checkGetFirst_OneEndContainer(2); }
@Test(timeout=1000) public void OneEndContainer_getFirst_03() { checkGetFirst_OneEndContainer(3); }
@Test(timeout=1000) public void OneEndContainer_getFirst_04() { checkGetFirst_OneEndContainer(4); }
@Test(timeout=1000) public void OneEndContainer_getFirst_05() { checkGetFirst_OneEndContainer(5); }
@Test(timeout=1000) public void OneEndContainer_getFirst_06() { checkGetFirst_OneEndContainer(6); }
@Test(timeout=1000) public void OneEndContainer_getFirst_07() { checkGetFirst_OneEndContainer(7); }

@Test(expected = EmptyContainerException.class) 
public void OneEndContainer_getFirst_08() {
	  OneEndContainer<String> f = new OneEndContainer<>();
	  f.getFirst();
}

//Float floatSInput[] = {25.5f,10.0f,-225.66f,98.32f,-897.0f,100.99f,10.5f,0.1f};
//String searchInput[]= {"Baldwin","John","Raju", "Khan","Brown", "Ali","Minilik","Lu"};
//boolean searchOutput[] = { true, false,false,false,true, false, true,false};
//boolean searchFOutput[] = { true, false,false,true,true, false, true,false};
void checkSearch_OneEndContainer(int a) {
	//  int n = capacity2[a];
	  OneEndContainer<String> f = new OneEndContainer<>();
	  OneEndContainer<Float> f1 = new OneEndContainer<>();
	  for(int i=0;i<8;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	 boolean result = f.search(searchInput[a]);
	 boolean result1 = f1.search(floatSInput[a]);
	  String errMsg = String.format("search(%s) for OneEndContainer incorrect", searchInput[a]);
	  String errMsg1 = String.format("search(%f) for OneEndContainer incorrect", floatSInput[a]);
	  assertEquals(errMsg, searchOutput[a], result );
	  assertEquals(errMsg1, searchFOutput[a], result1 );
}

@Test(timeout=1000) public void OneEndContainer_search_00() { checkSearch_OneEndContainer(0); }
@Test(timeout=1000) public void OneEndContainer_search_01() { checkSearch_OneEndContainer(1); }
@Test(timeout=1000) public void OneEndContainer_search_02() { checkSearch_OneEndContainer(2); }
@Test(timeout=1000) public void OneEndContainer_search_03() { checkSearch_OneEndContainer(3); }
@Test(timeout=1000) public void OneEndContainer_search_04() { checkSearch_OneEndContainer(4); }
@Test(timeout=1000) public void OneEndContainer_search_05() { checkSearch_OneEndContainer(5); }
@Test(timeout=1000) public void OneEndContainer_search_06() { checkSearch_OneEndContainer(6); }
@Test(timeout=1000) public void OneEndContainer_search_07() { checkSearch_OneEndContainer(7); }


void checkRecursiveSearch_OneEndContainer(int a) {
	  int n = capacity2[a];
	  OneEndContainer<String> f = new OneEndContainer<>();
	  OneEndContainer<Float> f1 = new OneEndContainer<>();
	  for(int i=0;i<8;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	 boolean result = f.search(searchInput[a],f.front);
	 boolean result1 = f1.search(floatSInput[a],f1.front);
	  String errMsg = String.format("recursive search(%s) for OneEndContainer incorrect", searchInput[a]);
	  String errMsg1 = String.format("recursive search(%f) for OneEndContainer incorrect", floatSInput[a]);
	  assertEquals(errMsg, searchOutput[a], result );
	  assertEquals(errMsg1, searchFOutput[a], result1 );
}

@Test(timeout=1000) public void OneEndContainer_Recursivesearch_00() { checkRecursiveSearch_OneEndContainer(0); }
@Test(timeout=1000) public void OneEndContainer_Recursivesearch_01() { checkRecursiveSearch_OneEndContainer(1); }
@Test(timeout=1000) public void OneEndContainer_Recursivesearch_02() { checkRecursiveSearch_OneEndContainer(2); }
@Test(timeout=1000) public void OneEndContainer_Recursivesearch_03() { checkRecursiveSearch_OneEndContainer(3); }
@Test(timeout=1000) public void OneEndContainer_Recursivesearch_04() { checkRecursiveSearch_OneEndContainer(4); }
@Test(timeout=1000) public void OneEndContainer_Recursivesearch_05() { checkRecursiveSearch_OneEndContainer(5); }
@Test(timeout=1000) public void OneEndContainer_Recursivesearch_06() { checkRecursiveSearch_OneEndContainer(6); }
@Test(timeout=1000) public void OneEndContainer_Recursivesearch_07() { checkRecursiveSearch_OneEndContainer(7); }

void checkSize_OneEndContainer(int a) {
	  int n = capacity2[a];
	  OneEndContainer<String> f = new OneEndContainer<>();
	  for(int i=0;i<n;i++) 
		  f.add(stringInput[i]);
	  int s = f.size();
	  String errMsg = String.format("size() for OneEndContainer() incorrect");
	  assertEquals(errMsg, n, s );
}

@Test(timeout=1000) public void OneEndContainer_size_00() { checkSize_OneEndContainer(0); }
@Test(timeout=1000) public void OneEndContainer_size_01() { checkSize_OneEndContainer(1); }
@Test(timeout=1000) public void OneEndContainer_size_02() { checkSize_OneEndContainer(2); }
@Test(timeout=1000) public void OneEndContainer_size_03() { checkSize_OneEndContainer(3); }
@Test(timeout=1000) public void OneEndContainer_size_04() { checkSize_OneEndContainer(4); }
@Test(timeout=1000) public void OneEndContainer_size_05() { checkSize_OneEndContainer(5); }
@Test(timeout=1000) public void OneEndContainer_size_06() { checkSize_OneEndContainer(6); }
@Test(timeout=1000) public void OneEndContainer_size_07() { checkSize_OneEndContainer(7); }
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  TwoEndsContainer class Tester %%%%%%%%%%%%%%%%%%%%%%%%%%%% 


 @Test(timeout=1000) public void TwoEndsContainer_construct_def_00() { 
	  TwoEndsContainer<String> s = new TwoEndsContainer<>();
     // assertEquals("Default constructor (OneEndContainer) is incorrect", 100, s.getCapacity());
      assertEquals("Default constructor (TwoEndsContainer) is incorrect", 0, s.size());
      TwoEndsContainer<Integer> s1 = new TwoEndsContainer<>();
      
      //assertEquals("Non-Default constructor (OneEndContainer) is incorrect", 55, s1.getCapacity());
      assertEquals("Constructor (TwoEndsContainer) is incorrect", 0, s1.size());
       
    }
 
  @Test(timeout=1000) public void TwoEndsContainer_Inheritance_def_00() { 
		TwoEndsContainer<Integer> s = new TwoEndsContainer<>();
		TwoEndsContainer<Boolean> s1 = new TwoEndsContainer<>();	  
	    assertEquals("TwoEndsContainer does not implement the correct inheritance(DataContainer)", true, s instanceof DataContainer);
	    assertEquals("TwoEndsContainer does not implement the correct inheritance(DataContainer)", true, s1 instanceof DataContainer);
	   //  assertEquals("Non-Default constructor (OrderedContainer) is incorrect", 0, s1.size());
	   
	}

  
 // String stringInput[] = {"Garvey","King","Malcom","Baldwin","Lawson","Lewis","Minilik","Brown"};
 // Float floatInput[] = {25.5f,0.0f,-225.69f,98.32f,-897.0f,99.99f,10.5f,14.55f};
 // int capacity[] = { 1, 10, 200, 89,586};
 // int capacity2[] = { 1, 2, 3, 4,5,6,7,8};

  
  
  void checkIsEmpty_TwoEndsContainer() {
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  TwoEndsContainer<Integer> f1 = new TwoEndsContainer<>();
	  boolean result1 = f.isEmpty();
	  boolean result2 = f1.isEmpty();
	  String errMsg = String.format("isEmpty() for TwoEndsContainer incorrect");
	  assertEquals(errMsg, true,result1);
	  assertEquals(errMsg, true,result2);
  }
     
  @Test(timeout=1000) public void TwoEndsContainer_isEmpty_00() { checkIsEmpty_TwoEndsContainer(); }
  
  
  
  void checkAdd_TwoEndsContainer(int a) {
	  int n = capacity2[a];
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  for(int i=0;i<n;i++) 
		  f.add(stringInput[i]);
       String [] st =subArray(stringInput, 0,a);
       List  ss= Arrays.asList(st);
	  boolean result = (ss.toString()).equals(f.toString());
	  String errMsg = String.format("add() for TwoEndsContainer incorrect");
	  assertEquals(errMsg, true, result);
}

@Test(timeout=1000) public void TwoEndsContainer_add_00() { checkAdd_TwoEndsContainer(0); }
@Test(timeout=1000) public void TwoEndsContainer_add_01() { checkAdd_TwoEndsContainer(1); }
@Test(timeout=1000) public void TwoEndsContainer_add_02() { checkAdd_TwoEndsContainer(2); }
@Test(timeout=1000) public void TwoEndsContainer_add_03() { checkAdd_TwoEndsContainer(3); }
@Test(timeout=1000) public void TwoEndsContainer_add_04() { checkAdd_TwoEndsContainer(4); }
@Test(timeout=1000) public void TwoEndsContainer_add_05() { checkAdd_TwoEndsContainer(5); }
@Test(timeout=1000) public void TwoEndsContainer_add_06() { checkAdd_TwoEndsContainer(6); }
@Test(timeout=1000) public void TwoEndsContainer_add_07() { checkAdd_TwoEndsContainer(7); }

void checkAdd_TwoEndsContainer_0(int a) {
	  int n = capacity2[a];
	  TwoEndsContainer<Float> f = new TwoEndsContainer<>();
	  for(int i=0;i<n;i++) 
		  f.add(floatInput[i]);
     Float [] st =subArray(floatInput, 0,a);
     List  ss= Arrays.asList(st);
	  boolean result = (ss.toString()).equals(f.toString());
	  String errMsg = String.format("add() for TwoEndsContainer incorrect");
	  assertEquals(errMsg, true, result);
}

@Test(timeout=1000) public void TwoEndsContainer_add_08() { checkAdd_TwoEndsContainer_0(0); }
@Test(timeout=1000) public void TwoEndsContainer_add_09() { checkAdd_TwoEndsContainer_0(1); }
@Test(timeout=1000) public void TwoEndsContainer_add_10() { checkAdd_TwoEndsContainer_0(2); }
@Test(timeout=1000) public void TwoEndsContainer_add_11() { checkAdd_TwoEndsContainer_0(3); }
@Test(timeout=1000) public void TwoEndsContainer_add_12() { checkAdd_TwoEndsContainer_0(4); }
@Test(timeout=1000) public void TwoEndsContainer_add_13() { checkAdd_TwoEndsContainer_0(5); }
@Test(timeout=1000) public void TwoEndsContainer_add_14() { checkAdd_TwoEndsContainer_0(6); }
@Test(timeout=1000) public void TwoEndsContainer_add_15() { checkAdd_TwoEndsContainer_0(7); }

String outputT[] = {"[Garvey]","[Garvey, King]","[Garvey, King, Malcom]","[Garvey, King, Malcom, Baldwin]", "[Garvey, King, Malcom, Baldwin, Lawson]","[Garvey, King, Malcom, Baldwin, Lawson, Lewis]", "[Garvey, King, Malcom, Baldwin, Lawson, Lewis, Minilik]", "[Garvey, King, Malcom, Baldwin, Lawson, Lewis, Minilik, Brown]"};
String output1T[] ={"[25.5]", "[25.5, 0.0]", "[25.5, 0.0, -225.69]","[25.5, 0.0, -225.69, 98.32]", "[25.5, 0.0, -225.69, 98.32, -897.0]","[25.5, 0.0, -225.69, 98.32, -897.0, 99.99]","[25.5, 0.0, -225.69, 98.32, -897.0, 99.99, 10.5]", "[25.5, 0.0, -225.69, 98.32, -897.0, 99.99, 10.5, 14.55]"};

void checktoString_TwoEndsContainer_0(int a) {
	  int n = capacity2[a];
	  TwoEndsContainer<Float> f = new TwoEndsContainer<>();
	 
	  for(int i=0;i<n;i++) 
	  {
		  f.add(floatInput[i]);
		  	  }
	
      String  st =f.toString();
      String errMsg = String.format("toString() for TwoEndsContainer() incorrect");
	  assertEquals(errMsg, output1T[a], st);
}

@Test(timeout=1000) public void TwoEndsContainer_toString_00() { checktoString_TwoEndsContainer_0(0); }
@Test(timeout=1000) public void TwoEndsContainer_toString_01() { checktoString_TwoEndsContainer_0(1);  }
@Test(timeout=1000) public void TwoEndsContainer_toString_02() { checktoString_TwoEndsContainer_0(2); }
@Test(timeout=1000) public void TwoEndsContainer_toString_03() { checktoString_TwoEndsContainer_0(3);  }
@Test(timeout=1000) public void TwoEndsContainer_toString_04() { checktoString_TwoEndsContainer_0(4); }
@Test(timeout=1000) public void TwoEndsContainer_toString_05() { checktoString_TwoEndsContainer_0(5); }
@Test(timeout=1000) public void TwoEndsContainer_toString_06() { checktoString_TwoEndsContainer_0(6); }
@Test(timeout=1000) public void TwoEndsContainer_toString_07() { checktoString_TwoEndsContainer_0(7); }

void checktoString_TwoEndsContainer(int a) {
	  int n = capacity2[a];
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	 
	  for(int i=0;i<n;i++) 
	  {
		  f.add(stringInput[i]);
		  	  }
	
    String  st =f.toString();
    String errMsg = String.format("toString() for TwoEndsContainer() incorrect");
	  assertEquals(errMsg, outputT[a], st);
}

@Test(timeout=1000) public void TwoEndsContainer_toString_08() { checktoString_TwoEndsContainer(0); }
@Test(timeout=1000) public void TwoEndsContainer_toString_09() { checktoString_TwoEndsContainer(1);  }
@Test(timeout=1000) public void TwoEndsContainer_toString_10() { checktoString_TwoEndsContainer(2); }
@Test(timeout=1000) public void TwoEndsContainer_toString_11() { checktoString_TwoEndsContainer(3);  }
@Test(timeout=1000) public void TwoEndsContainer_toString_12() { checktoString_TwoEndsContainer(4); }
@Test(timeout=1000) public void TwoEndsContainer_toString_13() { checktoString_TwoEndsContainer(5); }
@Test(timeout=1000) public void TwoEndsContainer_toString_14() { checktoString_TwoEndsContainer(6); }
@Test(timeout=1000) public void TwoEndsContainer_toString_15() { checktoString_TwoEndsContainer(7); }

  
  void checkIsFull_TwoEndsContainer(int a) {
	  int n = capacity2[a];
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  TwoEndsContainer<Float> f1 = new TwoEndsContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	  boolean result = f.isFull();
	  boolean result1 = f1.isFull();
	  String errMsg = String.format("isFull() for TwoEndsContainer(%d) incorrect", n);
	  assertEquals(errMsg, false, result);
	  assertEquals(errMsg, false, result1);
  }
     
  @Test(timeout=1000) public void TwoEndsContainer_isFull_00() { checkIsFull_TwoEndsContainer(0); }
  @Test(timeout=1000) public void TwoEndsContainer_isFull_01() { checkIsFull_TwoEndsContainer(1); }
  @Test(timeout=1000) public void TwoEndsContainer_isFull_02() { checkIsFull_TwoEndsContainer(2); }
  @Test(timeout=1000) public void TwoEndsContainer_isFull_03() { checkIsFull_TwoEndsContainer(3); }
  @Test(timeout=1000) public void TwoEndsContainer_isFull_04() { checkIsFull_TwoEndsContainer(4); }
  @Test(timeout=1000) public void TwoEndsContainer_isFull_05() { checkIsFull_TwoEndsContainer(5); }
  @Test(timeout=1000) public void TwoEndsContainer_isFull_06() { checkIsFull_TwoEndsContainer(6); }
  
  void checkClear_TwoEndsContainer(int a) {
	  int n = capacity2[a];
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  TwoEndsContainer<Float> f1 = new TwoEndsContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	   f.clear();
	  f1.clear();
	 // f.clear();
	  boolean result = f.isEmpty();
	  boolean result1 = f1.isEmpty();
	  String errMsg = String.format("clear() for TwoEndsContainer incorrect", n);
	  assertEquals(errMsg, true, result);
	  assertEquals(errMsg, true, result1);
	  assertEquals(errMsg,0,f.size());
	  assertEquals(errMsg,0,f1.size());
  }
     
  @Test(timeout=1000) public void TwoEndsContainer_isClear_00() { checkClear_TwoEndsContainer(0); }
  @Test(timeout=1000) public void TwoEndsContainer_isClear_01() { checkClear_TwoEndsContainer(1); }
  @Test(timeout=1000) public void TwoEndsContainer_isClear_02() { checkClear_TwoEndsContainer(2); }
  @Test(timeout=1000) public void TwoEndsContainer_isClear_03() { checkClear_TwoEndsContainer(3); }
  @Test(timeout=1000) public void TwoEndsContainer_isClear_04() { checkClear_TwoEndsContainer(4); }
  @Test(timeout=1000) public void TwoEndsContainer_isClear_05() { checkClear_TwoEndsContainer(5); }
  @Test(timeout=1000) public void TwoEndsContainer_isClear_06() { checkClear_TwoEndsContainer(6); }
  @Test(timeout=1000) public void TwoEndsContainer_isClear_07() { checkClear_TwoEndsContainer(7); }

  @Test(expected = EmptyContainerException.class) 
  public void TwoEndsContainer_isClear_08() {
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  f.clear();
  }
void checkRemove_TwoEndsContainer(int a) {
	  int n = capacity2[a];
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  TwoEndsContainer<Float> f1 = new TwoEndsContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	 String result = f.remove();
	 Float result1=f1.remove();
	  String errMsg = String.format("remove() for TwoEndsContainer() incorrect", n);
	  assertEquals(errMsg, stringInput[0], result );
	  assertEquals(errMsg, floatInput[0], result1 );
}
   
@Test(timeout=1000) public void TwoEndsContainer_remove_00() { checkRemove_TwoEndsContainer(0); }
@Test(timeout=1000) public void TwoEndsContainer_remove_01() { checkRemove_TwoEndsContainer(1); }
@Test(timeout=1000) public void TwoEndsContainer_remove_02() { checkRemove_TwoEndsContainer(2); }
@Test(timeout=1000) public void TwoEndsContainer_remove_03() { checkRemove_TwoEndsContainer(3); }
@Test(timeout=1000) public void TwoEndsContainer_remove_04() { checkRemove_TwoEndsContainer(4); }
@Test(timeout=1000) public void TwoEndsContainer_remove_05() { checkRemove_TwoEndsContainer(5); }
@Test(timeout=1000) public void TwoEndsContainer_remove_06() { checkRemove_TwoEndsContainer(6); }
@Test(timeout=1000) public void TwoEndsContainer_remove_07() { checkRemove_TwoEndsContainer(7); }

@Test(expected = EmptyContainerException.class) 
public void TwoEndsContainer_remove_08() {
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  f.remove();
}

void checkRemoveOverloaded_TwoEndsContainer(int a) {
	  int n = capacity2[a];
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  TwoEndsContainer<Float> f1 = new TwoEndsContainer<>();
	  for(int i=7;i>=0;i--) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
    f.remove("Baldwin");
	f1.remove(-897.0f);
	
	 String result = f.toString();
	 String result1 = f1.toString();
	
	  String errMsg = String.format("remove(%s) for TwoEndsContainer() incorrect", "Baldwin");
	  String errMsg1 = String.format("remove(%f) for TwoEndsContainer() incorrect", -897.0f);
	  assertEquals(errMsg, outputRe, result );
	  assertEquals(errMsg1, output1Re, result1 );
	  assertEquals(errMsg, false, f.remove("hello"));
	  assertEquals(errMsg1, false, f1.remove(444.44f));
	  
}

@Test(timeout=1000) public void TwoEndsContainer_removeOverloaded_00() { checkRemoveOverloaded_TwoEndsContainer(0); }

@Test(expected = EmptyContainerException.class) 
public void TwoEndsContainer_removeOverloaded_08() {
	TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  f.remove("Hello");
}
void checkGetLast_TwoEndsContainer(int a) {
	  int n = capacity2[a];
	 TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  TwoEndsContainer<Float> f1 = new TwoEndsContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	  String result = f.getLast();
	  Float result1 = f1.getLast();
	  String errMsg = String.format("GetLast() for TwoEndsContainer() incorrect");
	  assertEquals(errMsg, stringInput[n-1], result );
	  assertEquals(errMsg, floatInput[n-1], result1 );
}
 
@Test(timeout=1000) public void TwoEndsContainer_getLast_00() { checkGetLast_TwoEndsContainer(0); }
@Test(timeout=1000) public void TwoEndsContainer_getLast_01() { checkGetLast_TwoEndsContainer(1); }
@Test(timeout=1000) public void TwoEndsContainer_getLast_02() { checkGetLast_TwoEndsContainer(2); }
@Test(timeout=1000) public void TwoEndsContainer_getLast_03() { checkGetLast_TwoEndsContainer(3); }
@Test(timeout=1000) public void TwoEndsContainer_getLast_04() { checkGetLast_TwoEndsContainer(4); }
@Test(timeout=1000) public void TwoEndsContainer_getLast_05() { checkGetLast_TwoEndsContainer(5); }
@Test(timeout=1000) public void TwoEndsContainer_getLast_06() { checkGetLast_TwoEndsContainer(6); }
@Test(timeout=1000) public void TwoEndsContainer_getLast_07() { checkGetLast_TwoEndsContainer(7); }

@Test(expected = EmptyContainerException.class) 
public void TwoEndsContainer_getLast_08() {
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  f.getLast();
}
void checkGetFirst_TwoEndsContainer(int a) {
	// int n = capacity2[a];
	TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  TwoEndsContainer<Float> f1 = new TwoEndsContainer<>();
	  for(int i=0;i<a;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	  String result = f.getFirst();
	  Float result1 = f1.getFirst();
	  String errMsg = String.format("GetFirst() for TwoEndsContainer() incorrect");
	  assertEquals(errMsg, stringInput[0], result );
	  assertEquals(errMsg, floatInput[0], result1 );
}

//@Test(timeout=1000) public void TwoEndsContainer_getFirst_00() { checkGetFirst_TwoEndsContainer(0); }
@Test(timeout=1000) public void TwoEndsContainer_getFirst_01() { checkGetFirst_TwoEndsContainer(1); }
@Test(timeout=1000) public void TwoEndsContainer_getFirst_02() { checkGetFirst_TwoEndsContainer(2); }
@Test(timeout=1000) public void TwoEndsContainer_getFirst_03() { checkGetFirst_TwoEndsContainer(3); }
@Test(timeout=1000) public void TwoEndsContainer_getFirst_04() { checkGetFirst_TwoEndsContainer(4); }
@Test(timeout=1000) public void TwoEndsContainer_getFirst_05() { checkGetFirst_TwoEndsContainer(5); }
@Test(timeout=1000) public void TwoEndsContainer_getFirst_06() { checkGetFirst_TwoEndsContainer(6); }
@Test(timeout=1000) public void TwoEndsContainer_getFirst_07() { checkGetFirst_TwoEndsContainer(7); }

@Test(expected = EmptyContainerException.class) 
public void TwoEndsContainer_getFirst_08() {
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  f.getFirst();
}

Float floatSInput[] = {25.5f,10.0f,-225.66f,98.32f,-897.0f,100.99f,10.5f,0.1f};
String searchInput[]= {"Baldwin","John","Raju", "Khan","Brown", "Ali","Minilik","Lu"};
boolean searchOutput[] = { true, false,false,false,true, false, true,false};
boolean searchFOutput[] = { true, false,false,true,true, false, true,false};
void checkSearch_TwoEndsContainer(int a) {
	//  int n = capacity2[a];
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  TwoEndsContainer<Float> f1 = new TwoEndsContainer<>();
	  for(int i=0;i<8;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	 boolean result = f.search(searchInput[a]);
	 boolean result1 = f1.search(floatSInput[a]);
	  String errMsg = String.format("search(%s) for TwoEndsContainer incorrect", searchInput[a]);
	  String errMsg1 = String.format("search(%f) for TwoEndsContainer incorrect", floatSInput[a]);
	  assertEquals(errMsg, searchOutput[a], result );
	  assertEquals(errMsg1, searchFOutput[a], result1 );
}

@Test(timeout=1000) public void TwoEndsContainer_search_00() { checkSearch_TwoEndsContainer(0); }
@Test(timeout=1000) public void TwoEndsContainer_search_01() { checkSearch_TwoEndsContainer(1); }
@Test(timeout=1000) public void TwoEndsContainer_search_02() { checkSearch_TwoEndsContainer(2); }
@Test(timeout=1000) public void TwoEndsContainer_search_03() { checkSearch_TwoEndsContainer(3); }
@Test(timeout=1000) public void TwoEndsContainer_search_04() { checkSearch_TwoEndsContainer(4); }
@Test(timeout=1000) public void TwoEndsContainer_search_05() { checkSearch_TwoEndsContainer(5); }
@Test(timeout=1000) public void TwoEndsContainer_search_06() { checkSearch_TwoEndsContainer(6); }
@Test(timeout=1000) public void TwoEndsContainer_search_07() { checkSearch_TwoEndsContainer(7); }


void checkRecursiveSearch_TwoEndsContainer(int a) {
	  int n = capacity2[a];
	  TwoEndsContainer<String> f = new TwoEndsContainer<>();
	  TwoEndsContainer<Float> f1 = new TwoEndsContainer<>();
	  for(int i=0;i<8;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	 boolean result = f.search(searchInput[a],f.getFront());
	 boolean result1 = f1.search(floatSInput[a],f1.getFront());
	  String errMsg = String.format("recursive search(%s) for TwoEndsContainer incorrect", searchInput[a]);
	  String errMsg1 = String.format("recursive search(%f) for TwoEndsContainer incorrect", floatSInput[a]);
	  assertEquals(errMsg, searchOutput[a], result );
	  assertEquals(errMsg1, searchFOutput[a], result1 );
}

@Test(timeout=1000) public void TwoEndsContainer_Recursivesearch_00() { checkRecursiveSearch_TwoEndsContainer(0); }
@Test(timeout=1000) public void TwoEndsContainer_Recursivesearch_01() { checkRecursiveSearch_TwoEndsContainer(1); }
@Test(timeout=1000) public void TwoEndsContainer_Recursivesearch_02() { checkRecursiveSearch_TwoEndsContainer(2); }
@Test(timeout=1000) public void TwoEndsContainer_Recursivesearch_03() { checkRecursiveSearch_TwoEndsContainer(3); }
@Test(timeout=1000) public void TwoEndsContainer_Recursivesearch_04() { checkRecursiveSearch_TwoEndsContainer(4); }
@Test(timeout=1000) public void TwoEndsContainer_Recursivesearch_05() { checkRecursiveSearch_TwoEndsContainer(5); }
@Test(timeout=1000) public void TwoEndsContainer_Recursivesearch_06() { checkRecursiveSearch_TwoEndsContainer(6); }
@Test(timeout=1000) public void TwoEndsContainer_Recursivesearch_07() { checkRecursiveSearch_TwoEndsContainer(7); }

void checkSize_TwoEndsContainer(int a) {
	  int n = capacity2[a];
	   TwoEndsContainer<String> f = new  TwoEndsContainer<>();
	  for(int i=0;i<n;i++) 
		  f.add(stringInput[i]);
	  int s = f.size();
	  String errMsg = String.format("size() for  TwoEndsContainer() incorrect");
	  assertEquals(errMsg, n, s );
}

@Test(timeout=1000) public void TwoEndsContainer_size_00() { checkSize_TwoEndsContainer(0); }
@Test(timeout=1000) public void  TwoEndsContainer_size_01() { checkSize_TwoEndsContainer(1); }
@Test(timeout=1000) public void  TwoEndsContainer_size_02() { checkSize_TwoEndsContainer(2); }
@Test(timeout=1000) public void  TwoEndsContainer_size_03() { checkSize_TwoEndsContainer(3); }
@Test(timeout=1000) public void  TwoEndsContainer_size_04() { checkSize_TwoEndsContainer(4); }
@Test(timeout=1000) public void  TwoEndsContainer_size_05() { checkSize_TwoEndsContainer(5); }
@Test(timeout=1000) public void  TwoEndsContainer_size_06() { checkSize_TwoEndsContainer(6); }
@Test(timeout=1000) public void  TwoEndsContainer_size_07() { checkSize_TwoEndsContainer(7); }


//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  OrderedContainer class Tester %%%%%%%%%%%%%%%%%%%%%%%%%%%% 




String outputO[] = {"[Garvey]","[Garvey, King]","[Garvey, King, Malcom]","[Baldwin, Garvey, King, Malcom]", "[Baldwin, Garvey, King, Lawson, Malcom]","[Baldwin, Garvey, King, Lawson, Lewis, Malcom]", "[Baldwin, Garvey, King, Lawson, Lewis, Malcom, Minilik]", "[Baldwin, Brown, Garvey, King, Lawson, Lewis, Malcom, Minilik]"};
String outputORe = "[Baldwin, Brown, Garvey, Lawson, Lewis, Malcom, Minilik]";
String[][]outputOO = {{"Garvey"},{"Garvey", "King"},{"Garvey", "King", "Malcom"},{"Baldwin", "Garvey", "King", "Malcom"}, {"Baldwin", "Garvey", "King", "Lawson", "Malcom"},{"Baldwin", "Garvey", "King", "Lawson", "Lewis", "Malcom"}, {"Baldwin", "Garvey", "King", "Lawson", "Lewis", "Malcom", "Minilik"}, {"Baldwin", "Brown", "Garvey", "King", "Lawson", "Lewis", "Malcom", "Minilik"}};
String output1O[] ={"[25.5]", "[0.0, 25.5]", "[-225.69, 0.0, 25.5]","[-225.69, 0.0, 25.5, 98.32]", "[-897.0, -225.69, 0.0, 25.5, 98.32]","[-897.0, -225.69, 0.0, 25.5, 98.32, 99.99]","[-897.0, -225.69, 0.0, 10.5, 25.5, 98.32, 99.99]", "[-897.0, -225.69, 0.0, 10.5, 14.55, 25.5, 98.32, 99.99]"};
String output1ORe= "[-897.0, -225.69, 0.0, 14.55, 25.5, 98.32, 99.99]";
Float output1OO[][] ={{25.5f}, {0.0f, 25.5f}, {-225.69f, 0.0f, 25.5f},{-225.69f, 0.0f, 25.5f, 98.32f}, {-897.0f, -225.69f, 0.0f, 25.5f, 98.32f},{-897.0f, -225.69f, 0.0f, 25.5f, 98.32f, 99.99f},{-897.0f, -225.69f, 0.0f, 10.5f, 25.5f, 98.32f, 99.99f}, {-897.0f, -225.69f, 0.0f, 10.5f, 14.55f, 25.5f, 98.32f, 99.99f}};

@Test(timeout=1000) public void OrderedContainer_construct_def_00() { 
	  OrderedContainer<String> s = new OrderedContainer<>();
     
      assertEquals("Default constructor (OrderedContainer) is incorrect", 0, s.size());
      OrderedContainer<Integer> s1 = new OrderedContainer<>();
      
     
      assertEquals("Constructor (OrderedContainer) is incorrect", 0, s1.size());
       
    }
 
  @Test(timeout=1000) public void OrderedContainer_Inheritance_def_00() { 
		OrderedContainer<Integer> s = new OrderedContainer<>();
		OrderedContainer<Boolean> s1 = new OrderedContainer<>();	  
	    assertEquals("OrderedContainer does not implement the correct inheritance(DataContainer)", true, s instanceof DataContainer);
	    assertEquals("OrderedContainer does not implement the correct inheritance(DataContainer)", true, s1 instanceof DataContainer);
	   //  assertEquals("Non-Default constructor (OrderedContainer) is incorrect", 0, s1.size());
	   
	}

  
 // String stringInput[] = {"Garvey","King","Malcom","Baldwin","Lawson","Lewis","Minilik","Brown"};
 // Float floatInput[] = {25.5f,0.0f,-225.69f,98.32f,-897.0f,99.99f,10.5f,14.55f};
 // int capacity[] = { 1, 10, 200, 89,586};
 // int capacity2[] = { 1, 2, 3, 4,5,6,7,8};

  
  
  void checkIsEmpty_OrderedContainer() {
	  OrderedContainer<String> f = new OrderedContainer<>();
	  OrderedContainer<Integer> f1 = new OrderedContainer<>();
	  boolean result1 = f.isEmpty();
	  boolean result2 = f1.isEmpty();
	  String errMsg = String.format("isEmpty() for OrderedContainer incorrect");
	  assertEquals(errMsg, true,result1);
	  assertEquals(errMsg, true,result2);
  }
     
  @Test(timeout=1000) public void OrderedContainer_isEmpty_00() { checkIsEmpty_OrderedContainer(); }
  
  
  
  void checkAdd_OrderedContainer(int a) {
	  int n = capacity2[a];
	  OrderedContainer<String> f = new OrderedContainer<>();
	  for(int i=0;i<n;i++) 
		  f.add(stringInput[i]);
      
       List  ss= Arrays.asList(outputOO[a]);
	  boolean result = (ss.toString()).equals(f.toString());
	  String errMsg = String.format("add() for OrderedContainer incorrect");
	  assertEquals(errMsg, true, result);
}

@Test(timeout=1000) public void OrderedContainer_add_00() { checkAdd_OrderedContainer(0); }
@Test(timeout=1000) public void OrderedContainer_add_01() { checkAdd_OrderedContainer(1); }
@Test(timeout=1000) public void OrderedContainer_add_02() { checkAdd_OrderedContainer(2); }
@Test(timeout=1000) public void OrderedContainer_add_03() { checkAdd_OrderedContainer(3); }
@Test(timeout=1000) public void OrderedContainer_add_04() { checkAdd_OrderedContainer(4); }
@Test(timeout=1000) public void OrderedContainer_add_05() { checkAdd_OrderedContainer(5); }
@Test(timeout=1000) public void OrderedContainer_add_06() { checkAdd_OrderedContainer(6); }
@Test(timeout=1000) public void OrderedContainer_add_07() { checkAdd_OrderedContainer(7); }

void checkAdd_OrderedContainer_0(int a) {
	  int n = capacity2[a];
	  OrderedContainer<Float> f = new OrderedContainer<>();
	  for(int i=0;i<n;i++) 
		  f.add(floatInput[i]);
     
     List  ss= Arrays.asList(output1OO[a]);
	  boolean result = (ss.toString()).equals(f.toString());
	  String errMsg = String.format("add() for OrderedContainer incorrect");
	  assertEquals(errMsg, true, result);
}

@Test(timeout=1000) public void OrderedContainer_add_08() { checkAdd_OrderedContainer_0(0); }
@Test(timeout=1000) public void OrderedContainer_add_09() { checkAdd_OrderedContainer_0(1); }
@Test(timeout=1000) public void OrderedContainer_add_10() { checkAdd_OrderedContainer_0(2); }
@Test(timeout=1000) public void OrderedContainer_add_11() { checkAdd_OrderedContainer_0(3); }
@Test(timeout=1000) public void OrderedContainer_add_12() { checkAdd_OrderedContainer_0(4); }
@Test(timeout=1000) public void OrderedContainer_add_13() { checkAdd_OrderedContainer_0(5); }
@Test(timeout=1000) public void OrderedContainer_add_14() { checkAdd_OrderedContainer_0(6); }
@Test(timeout=1000) public void OrderedContainer_add_15() { checkAdd_OrderedContainer_0(7); }

//String outputT[] = {"[Garvey]","[Garvey, King]","[Garvey, King, Malcom]","[Garvey, King, Malcom, Baldwin]", "[Garvey, King, Malcom, Baldwin, Lawson]","[Garvey, King, Malcom, Baldwin, Lawson, Lewis]", "[Garvey, King, Malcom, Baldwin, Lawson, Lewis, Minilik]", "[Garvey, King, Malcom, Baldwin, Lawson, Lewis, Minilik, Brown]"};
//String output1T[] ={"[25.5]", "[25.5, 0.0]", "[25.5, 0.0, -225.69]","[25.5, 0.0, -225.69, 98.32]", "[25.5, 0.0, -225.69, 98.32, -897.0]","[25.5, 0.0, -225.69, 98.32, -897.0, 99.99]","[25.5, 0.0, -225.69, 98.32, -897.0, 99.99, 10.5]", "[25.5, 0.0, -225.69, 98.32, -897.0, 99.99, 10.5, 14.55]"};

void checktoString_OrderedContainer_0(int a) {
	  int n = capacity2[a];
	  OrderedContainer<Float> f = new OrderedContainer<>();
	 
	  for(int i=0;i<n;i++) 
	  {
		  f.add(floatInput[i]);
		  	  }
	
      String  st =f.toString();
      String errMsg = String.format("toString() for OrderedContainer() incorrect");
	  assertEquals(errMsg, output1O[a], st);
}

@Test(timeout=1000) public void OrderedContainer_toString_00() { checktoString_OrderedContainer_0(0); }
@Test(timeout=1000) public void OrderedContainer_toString_01() { checktoString_OrderedContainer_0(1);  }
@Test(timeout=1000) public void OrderedContainer_toString_02() { checktoString_OrderedContainer_0(2); }
@Test(timeout=1000) public void OrderedContainer_toString_03() { checktoString_OrderedContainer_0(3);  }
@Test(timeout=1000) public void OrderedContainer_toString_04() { checktoString_OrderedContainer_0(4); }
@Test(timeout=1000) public void OrderedContainer_toString_05() { checktoString_OrderedContainer_0(5); }
@Test(timeout=1000) public void OrderedContainer_toString_06() { checktoString_OrderedContainer_0(6); }
@Test(timeout=1000) public void OrderedContainer_toString_07() { checktoString_OrderedContainer_0(7); }

void checktoString_OrderedContainer(int a) {
	  int n = capacity2[a];
	  OrderedContainer<String> f = new OrderedContainer<>();
	 
	  for(int i=0;i<n;i++) 
	  {
		  f.add(stringInput[i]);
		  	  }
	
    String  st =f.toString();
    String errMsg = String.format("toString() for OrderedContainer() incorrect");
	  assertEquals(errMsg, outputO[a], st);
}

@Test(timeout=1000) public void OrderedContainer_toString_08() { checktoString_OrderedContainer(0); }
@Test(timeout=1000) public void OrderedContainer_toString_09() { checktoString_OrderedContainer(1);  }
@Test(timeout=1000) public void OrderedContainer_toString_10() { checktoString_OrderedContainer(2); }
@Test(timeout=1000) public void OrderedContainer_toString_11() { checktoString_OrderedContainer(3);  }
@Test(timeout=1000) public void OrderedContainer_toString_12() { checktoString_OrderedContainer(4); }
@Test(timeout=1000) public void OrderedContainer_toString_13() { checktoString_OrderedContainer(5); }
@Test(timeout=1000) public void OrderedContainer_toString_14() { checktoString_OrderedContainer(6); }
@Test(timeout=1000) public void OrderedContainer_toString_15() { checktoString_OrderedContainer(7); }

  
  void checkIsFull_OrderedContainer(int a) {
	  int n = capacity2[a];
	  OrderedContainer<String> f = new OrderedContainer<>();
	  OrderedContainer<Float> f1 = new OrderedContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	  boolean result = f.isFull();
	  boolean result1 = f1.isFull();
	  String errMsg = String.format("isFull() for OrderedContainer(%d) incorrect", n);
	  assertEquals(errMsg, false, result);
	  assertEquals(errMsg, false, result1);
  }
     
  @Test(timeout=1000) public void OrderedContainer_isFull_00() { checkIsFull_OrderedContainer(0); }
  @Test(timeout=1000) public void OrderedContainer_isFull_01() { checkIsFull_OrderedContainer(1); }
  @Test(timeout=1000) public void OrderedContainer_isFull_02() { checkIsFull_OrderedContainer(2); }
  @Test(timeout=1000) public void OrderedContainer_isFull_03() { checkIsFull_OrderedContainer(3); }
  @Test(timeout=1000) public void OrderedContainer_isFull_04() { checkIsFull_OrderedContainer(4); }
  @Test(timeout=1000) public void OrderedContainer_isFull_05() { checkIsFull_OrderedContainer(5); }
  @Test(timeout=1000) public void OrderedContainer_isFull_06() { checkIsFull_OrderedContainer(6); }
  
  void checkClear_OrderedContainer(int a) {
	  int n = capacity2[a];
	  OrderedContainer<String> f = new OrderedContainer<>();
	  OrderedContainer<Float> f1 = new OrderedContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	   f.clear();
	  f1.clear();
	 // f.clear();
	  boolean result = f.isEmpty();
	  boolean result1 = f1.isEmpty();
	  String errMsg = String.format("clear() for OrderedContainer incorrect", n);
	  assertEquals(errMsg, true, result);
	  assertEquals(errMsg, true, result1);
	  assertEquals(errMsg,0,f.size());
	  assertEquals(errMsg,0,f1.size());
  }
     
  @Test(timeout=1000) public void OrderedContainer_isClear_00() { checkClear_OrderedContainer(0); }
  @Test(timeout=1000) public void OrderedContainer_isClear_01() { checkClear_OrderedContainer(1); }
  @Test(timeout=1000) public void OrderedContainer_isClear_02() { checkClear_OrderedContainer(2); }
  @Test(timeout=1000) public void OrderedContainer_isClear_03() { checkClear_OrderedContainer(3); }
  @Test(timeout=1000) public void OrderedContainer_isClear_04() { checkClear_OrderedContainer(4); }
  @Test(timeout=1000) public void OrderedContainer_isClear_05() { checkClear_OrderedContainer(5); }
  @Test(timeout=1000) public void OrderedContainer_isClear_06() { checkClear_OrderedContainer(6); }
  @Test(timeout=1000) public void OrderedContainer_isClear_07() { checkClear_OrderedContainer(7); }

  @Test(expected = EmptyContainerException.class) 
  public void OrderedContainer_isClear_08() {
	  OrderedContainer<String> f = new OrderedContainer<>();
	  f.clear();
  }
void checkRemove_OrderedContainer(int a) {
	  int n = capacity2[a];
	  OrderedContainer<String> f = new OrderedContainer<>();
	  OrderedContainer<Float> f1 = new OrderedContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	 String result = f.remove();
	 Float result1=f1.remove();
	  String errMsg = String.format("remove() for OrderedContainer() incorrect", n);
	  assertEquals(errMsg, outputOO[a][0], result );
	  assertEquals(errMsg, output1OO[a][0], result1 );
}
   
@Test(timeout=1000) public void OrderedContainer_remove_00() { checkRemove_OrderedContainer(0); }
@Test(timeout=1000) public void OrderedContainer_remove_01() { checkRemove_OrderedContainer(1); }
@Test(timeout=1000) public void OrderedContainer_remove_02() { checkRemove_OrderedContainer(2); }
@Test(timeout=1000) public void OrderedContainer_remove_03() { checkRemove_OrderedContainer(3); }
@Test(timeout=1000) public void OrderedContainer_remove_04() { checkRemove_OrderedContainer(4); }
@Test(timeout=1000) public void OrderedContainer_remove_05() { checkRemove_OrderedContainer(5); }
@Test(timeout=1000) public void OrderedContainer_remove_06() { checkRemove_OrderedContainer(6); }
@Test(timeout=1000) public void OrderedContainer_remove_07() { checkRemove_OrderedContainer(7); }

@Test(expected = EmptyContainerException.class) 
public void OrderedContainer_remove_08() {
	  OrderedContainer<String> f = new OrderedContainer<>();
	  f.remove();
}

void checkRemoveOverloaded_OrderedContainer(int a) {
	  int n = capacity2[a];
	  OrderedContainer<String> f = new OrderedContainer<>();
	  OrderedContainer<Float> f1 = new OrderedContainer<>();
	  for(int i=0;i<8;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
  f.remove("King");
	f1.remove( 10.5f);
	
	 String result = f.toString();
	 String result1 = f1.toString();
	 String errMsg = String.format("remove(%s) for OrderedContainer() incorrect", "King");
	  String errMsg1 = String.format("remove(%f) for OrderedContainer() incorrect",  10.5f);
	  assertEquals(errMsg, outputORe, result );
	  assertEquals(errMsg1, output1ORe, result1 );
	  assertEquals(errMsg, false, f.remove("hello"));
	  assertEquals(errMsg1, false, f1.remove(444.44f));
	  
}

@Test(timeout=1000) public void OrderedContainer_removeOverloaded_00() { checkRemoveOverloaded_OrderedContainer(0); }

@Test(expected = EmptyContainerException.class) 
public void OrderedContainer_removeOverloaded_08() {
	OrderedContainer<String> f = new OrderedContainer<>();
	  f.remove("Hello");
}
void checkGetLast_OrderedContainer(int a) {
	  int n = capacity2[a];
	 OrderedContainer<String> f = new OrderedContainer<>();
	  OrderedContainer<Float> f1 = new OrderedContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	  String result = f.getLast();
	  Float result1 = f1.getLast();
	  String errMsg = String.format("GetLast() for OrderedContainer() incorrect");
	  assertEquals(errMsg, outputOO[a][a], result );
	  assertEquals(errMsg, output1OO[a][a], result1 );
}
 
@Test(timeout=1000) public void OrderedContainer_getLast_00() { checkGetLast_OrderedContainer(0); }
@Test(timeout=1000) public void OrderedContainer_getLast_01() { checkGetLast_OrderedContainer(1); }
@Test(timeout=1000) public void OrderedContainer_getLast_02() { checkGetLast_OrderedContainer(2); }
@Test(timeout=1000) public void OrderedContainer_getLast_03() { checkGetLast_OrderedContainer(3); }
@Test(timeout=1000) public void OrderedContainer_getLast_04() { checkGetLast_OrderedContainer(4); }
@Test(timeout=1000) public void OrderedContainer_getLast_05() { checkGetLast_OrderedContainer(5); }
@Test(timeout=1000) public void OrderedContainer_getLast_06() { checkGetLast_OrderedContainer(6); }
@Test(timeout=1000) public void OrderedContainer_getLast_07() { checkGetLast_OrderedContainer(7); }

@Test(expected = EmptyContainerException.class) 
public void OrderedContainer_getLast_08() {
	  OrderedContainer<String> f = new OrderedContainer<>();
	  f.getLast();
}
void checkGetFirst_OrderedContainer(int a) {
	 int n = capacity2[a];
	OrderedContainer<String> f = new OrderedContainer<>();
	  OrderedContainer<Float> f1 = new OrderedContainer<>();
	  for(int i=0;i<n;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	  String result = f.getFirst();
	  Float result1 = f1.getFirst();
	  String errMsg = String.format("GetFirst() for OrderedContainer() incorrect");
	  assertEquals(errMsg, outputOO[a][0], result );
	  assertEquals(errMsg, output1OO[a][0], result1 );
}

//@Test(timeout=1000) public void OrderedContainer_getFirst_00() { checkGetFirst_OrderedContainer(0); }
@Test(timeout=1000) public void OrderedContainer_getFirst_01() { checkGetFirst_OrderedContainer(1); }
@Test(timeout=1000) public void OrderedContainer_getFirst_02() { checkGetFirst_OrderedContainer(2); }
@Test(timeout=1000) public void OrderedContainer_getFirst_03() { checkGetFirst_OrderedContainer(3); }
@Test(timeout=1000) public void OrderedContainer_getFirst_04() { checkGetFirst_OrderedContainer(4); }
@Test(timeout=1000) public void OrderedContainer_getFirst_05() { checkGetFirst_OrderedContainer(5); }
@Test(timeout=1000) public void OrderedContainer_getFirst_06() { checkGetFirst_OrderedContainer(6); }
@Test(timeout=1000) public void OrderedContainer_getFirst_07() { checkGetFirst_OrderedContainer(7); }

@Test(expected = EmptyContainerException.class) 
public void OrderedContainer_getFirst_08() {
	  OrderedContainer<String> f = new OrderedContainer<>();
	  f.getFirst();
}

//Float floatSInput[] = {25.5f,10.0f,-225.66f,98.32f,-897.0f,100.99f,10.5f,0.1f};
//String searchInput[]= {"Baldwin","John","Raju", "Khan","Brown", "Ali","Minilik","Lu"};
//boolean searchOutput[] = { true, false,false,false,true, false, true,false};
//boolean searchFOutput[] = { true, false,false,true,true, false, true,false};
void checkSearch_OrderedContainer(int a) {
	//  int n = capacity2[a];
	  OrderedContainer<String> f = new OrderedContainer<>();
	  OrderedContainer<Float> f1 = new OrderedContainer<>();
	  for(int i=0;i<8;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	 boolean result = f.search(searchInput[a]);
	 boolean result1 = f1.search(floatSInput[a]);
	  String errMsg = String.format("search(%s) for OrderedContainer incorrect", searchInput[a]);
	  String errMsg1 = String.format("search(%f) for OrderedContainer incorrect", floatSInput[a]);
	  assertEquals(errMsg, searchOutput[a], result );
	  assertEquals(errMsg1, searchFOutput[a], result1 );
}

@Test(timeout=1000) public void OrderedContainer_search_00() { checkSearch_OrderedContainer(0); }
@Test(timeout=1000) public void OrderedContainer_search_01() { checkSearch_OrderedContainer(1); }
@Test(timeout=1000) public void OrderedContainer_search_02() { checkSearch_OrderedContainer(2); }
@Test(timeout=1000) public void OrderedContainer_search_03() { checkSearch_OrderedContainer(3); }
@Test(timeout=1000) public void OrderedContainer_search_04() { checkSearch_OrderedContainer(4); }
@Test(timeout=1000) public void OrderedContainer_search_05() { checkSearch_OrderedContainer(5); }
@Test(timeout=1000) public void OrderedContainer_search_06() { checkSearch_OrderedContainer(6); }
@Test(timeout=1000) public void OrderedContainer_search_07() { checkSearch_OrderedContainer(7); }


void checkRecursiveSearch_OrderedContainer(int a) {
	  int n = capacity2[a];
	  OrderedContainer<String> f = new OrderedContainer<>();
	  OrderedContainer<Float> f1 = new OrderedContainer<>();
	  for(int i=0;i<8;i++) {
		  f.add(stringInput[i]);
		  f1.add(floatInput[i]);}
	 boolean result = f.search(searchInput[a],f.getFront());
	 boolean result1 = f1.search(floatSInput[a],f1.getFront());
	  String errMsg = String.format("recursive search(%s) for OrderedContainer incorrect", searchInput[a]);
	  String errMsg1 = String.format("recursive search(%f) for OrderedContainer incorrect", floatSInput[a]);
	  assertEquals(errMsg, searchOutput[a], result );
	  assertEquals(errMsg1, searchFOutput[a], result1 );
}

@Test(timeout=1000) public void OrderedContainer_Recursivesearch_00() { checkRecursiveSearch_OrderedContainer(0); }
@Test(timeout=1000) public void OrderedContainer_Recursivesearch_01() { checkRecursiveSearch_OrderedContainer(1); }
@Test(timeout=1000) public void OrderedContainer_Recursivesearch_02() { checkRecursiveSearch_OrderedContainer(2); }
@Test(timeout=1000) public void OrderedContainer_Recursivesearch_03() { checkRecursiveSearch_OrderedContainer(3); }
@Test(timeout=1000) public void OrderedContainer_Recursivesearch_04() { checkRecursiveSearch_OrderedContainer(4); }
@Test(timeout=1000) public void OrderedContainer_Recursivesearch_05() { checkRecursiveSearch_OrderedContainer(5); }
@Test(timeout=1000) public void OrderedContainer_Recursivesearch_06() { checkRecursiveSearch_OrderedContainer(6); }
@Test(timeout=1000) public void OrderedContainer_Recursivesearch_07() { checkRecursiveSearch_OrderedContainer(7); }

void checkSize_OrderedContainer(int a) {
	  int n = capacity2[a];
	   OrderedContainer<String> f = new  OrderedContainer<>();
	  for(int i=0;i<n;i++) 
		  f.add(stringInput[i]);
	  int s = f.size();
	  String errMsg = String.format("size() for  OrderedContainer() incorrect");
	  assertEquals(errMsg, n, s );
}

@Test(timeout=1000) public void OrderedContainer_size_00() { checkSize_OrderedContainer(0); }
@Test(timeout=1000) public void  OrderedContainer_size_01() { checkSize_OrderedContainer(1); }
@Test(timeout=1000) public void  OrderedContainer_size_02() { checkSize_OrderedContainer(2); }
@Test(timeout=1000) public void  OrderedContainer_size_03() { checkSize_OrderedContainer(3); }
@Test(timeout=1000) public void OrderedContainer_size_04() { checkSize_OrderedContainer(4); }
@Test(timeout=1000) public void  OrderedContainer_size_05() { checkSize_OrderedContainer(5); }
@Test(timeout=1000) public void  OrderedContainer_size_06() { checkSize_OrderedContainer(6); }
@Test(timeout=1000) public void  OrderedContainer_size_07() { checkSize_OrderedContainer(7); }


}