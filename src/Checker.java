import java.util.Comparator;

public class Checker implements Comparator<Player> {

	@Override
	public int compare(Player a, Player b) {
		
		int k = 0;
		if(a.score > b.score) {
			k = -1;
		}
		else if(a.score < b.score) {
			k = 1;
		}
		else if(a.score == b.score) {
			k = a.name.compareTo(b.name);
		}
		return k;
	}	
}
