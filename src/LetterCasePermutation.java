import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	
	 public List<String> letterCasePermutation(String S) {
	        List<String> lst = new ArrayList<String>();
	        lst.add("");
	        
	        for(int i=0; i<S.length(); i++ ){
	        	char c = S.charAt(i);
	        	if(Character.isDigit(c)){
	                for(int j= 0;j<lst.size();j++){
	                   lst.set(j, lst.get(j)+c);
	                }
	            }
	            if(Character.isAlphabetic(c)){
	                for(int j=0; j<lst.size(); j++){
	                    lst.add(lst.get(j)+Character.toLowerCase(c));
	                    lst.set(j, lst.get(j)+Character.toUpperCase(c));
	                }
	            }
	        }        
	        return lst;        
	    }

}
