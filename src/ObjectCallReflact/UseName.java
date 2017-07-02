package ObjectCallReflact;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class UseName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Name name1 = new Name("Ibrahim", "Sanosi");
//		System.out.println("Name Before Change="+name1);
//		change(name1);
//		System.out.println("Name After Change="+name1);
		ConcurrentMap<Long, AckCommitHandler> ackOrCommitReceived = new ConcurrentHashMap<Long, AckCommitHandler>();
		AckCommitHandler a1 = new AckCommitHandler((byte)22);
		a1.addACK();
		ackOrCommitReceived.put((long)1, a1);
		System.out.println("a1//"+a1);
		AckCommitHandler a2 = ackOrCommitReceived.get((long)1);
		a2.addACK();
		System.out.println("a1//"+a1);


	}
	
	private static void change(Name n){
		String lastName = n.getLastName();
		lastName = "EL-Sanosi";
		//n.setLastName("EL-sanosi");
	}

}
