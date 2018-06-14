import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * print all the user names in sorted order for email id's contaian gmail.com
 * @author D
 *
 */

public class GmailRegex {

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        List<String> list = new ArrayList<String>();
        String p = "[a-z]+(@gmail\\.com)$";
        Pattern pattern = Pattern.compile(p);

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            
             Matcher matcher = pattern.matcher(emailID);
            
            if(matcher.find()) {
                list.add(firstName);
            }
        }
        
        Collections.sort(list);
        
        for(String s : list) {
            System.out.println(s);
        }

        scanner.close();
    }

}
