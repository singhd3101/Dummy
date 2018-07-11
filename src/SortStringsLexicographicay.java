import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SortStringsLexicographicay{

	public static void main(String[] args) {

		List<String> lst = new ArrayList<String>();
		lst.add("funny");
		lst.add("Funny");
		lst.add("fun");

		//Collections.sort(lst, Collator.getInstance(Locale.ENGLISH));

		/*Collections.sort(lst, new Comparator<String>() {
			@Override
                    public int compare(String o1, String o2) {
                        if(o1.equalsIgnoreCase(o2)){
                            return o1.compareTo(o2);
                        }
                        return o1.toLowerCase().compareTo(o2.toLowerCase());
                    }
		});*/


		Collections.sort(lst, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.toLowerCase().equals(o2.toLowerCase())) {
					if (o1.toLowerCase().equals(o1)) {
						return -1;
					} else {
						return  1;
					}
				} else {
					return o1.toLowerCase().compareTo(o2.toLowerCase());

				}
			}
		});

		for(String s : lst) {
			System.out.print(s+" ");
		}

	}
}