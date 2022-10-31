package onboarding;
import java.util.ArrayList;
import java.util.List;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        List<Character> list = new ArrayList<>();
        
        for(int i = 0; i<cryptogram.length();i++) {
        	list.add(cryptogram.charAt(i));
        }
        for(int i = 0; i<list.size()-1; i++) { //size는 1~8 
        	if(list.get(i)==list.get(i+1)) {
        		list.remove(i+1);
        		list.remove(i);
        		i = -1;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch: list) {
            sb.append(ch);
        } 
        String string = sb.toString();
        return answer = string;
    }
    public static void main(String[] args) {
    	/*System.out.println(solution("browoanoommnaon"));
    	System.out.println(solution("zyelleyz"));
    	System.out.println(solution("apple"));*/
    	
    }
}
 