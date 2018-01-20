import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Test  
{	public static void main(String args[]){
		HashMap<String, Double> hm = new HashMap<String, Double>();
		hm.put("Nuppu",22.33);
		hm.put("Mona",11.33);
		hm.put("Teja",13.03);
		hm.put("Dolly",55.33);
		hm.put("Arthee",92.33);
		System.out.println("HashMap: -\n"+hm);
		
		Set S1 = hm.keySet();
		Collection C = hm.values();
		Set S2 = hm.entrySet();
		
		System.out.println("\nkeySet(): -"+S1+"\nvalues(): -"+C+"\nentrySet(): -"+S2);
		
		Iterator I = S2.iterator();
		while(I.hasNext()){
			Map.Entry mp = (Map.Entry)I.next();
			System.out.println(mp);
			if(mp.getKey().equals("Dolly")){
				mp.setValue("00.00");
			}
		}
		System.out.println("Changed Values: -");
		System.out.println("EntrySet(): -"+S2);
		System.out.println("HashMap: -"+hm);
	}
}
