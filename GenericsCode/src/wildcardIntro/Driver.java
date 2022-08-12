package wildcardIntro;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		ArrayList <C>cList = new ArrayList<C>();
		cList.add(new C());
	
		
		ArrayList <? extends B> exampleExtend = cList;  //B or subtype of B
		B bVar = exampleExtend.get(0); //returns a B (C is a B)
		//C cVar = exampleExtend.get(0); //might be a B ..B is not C
		exampleExtend.add(null); //Ok null can be assigned to all references
		//exampleExtend.add(new C()); //no adds of objects allowed
		
		ArrayList <A> aList = new ArrayList<A>();
		aList.add(new A());
		
		ArrayList <? super B> exampleSuper = aList;  //B or above
		//A bVar2 = exampleSuper.get(0);  //Might be an Object (Object is not A)
		Object bVar2 = exampleSuper.get(0);  //Whatever it is, it is an Object
		exampleSuper.add(new B()); //Be or below can be added, since ArrayList is at least a B
		exampleSuper.add(new C());
		exampleSuper.add(new D());
		//exampleSuper.add(new A()); //Can not add anything above B (A is not B)
		
	}

}
