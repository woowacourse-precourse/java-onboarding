package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        ArrayList<Character> password = new ArrayList<>();
        
        for(int i=0; i<cryptogram.length(); i++) {
        	password.add(cryptogram.charAt(i));
        }
        
        for(int i=0; i<password.size(); i++) {
        	System.out.print(password.get(i));
        }
        System.out.println();
        
        for(int i=1; i<password.size(); i++) {
        	if(password.get(i)==password.get(i-1)) {        		
        		password.remove(i);
        		password.remove(i-1);        		
        		i=0;
        	}
        }
        
        for(int i=0; i<password.size(); i++) {
        	System.out.print(password.get(i));
        }
        System.out.println();
        
        return answer;
    }
}
