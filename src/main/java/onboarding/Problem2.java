package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuilder change = new StringBuilder();
        StringBuilder a = new StringBuilder();
        a = (StringBuilder)cryptogram;
        for(int i=cryptogram.length()-1;i==0;i--) {    
        	if(cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
        		cryptogram.setCharAt(i,"");
        		cryptogram.setCharAt(i-1,"");
        		i--;
        	}
        }
        return answer;
    }
}


//array[i]=cryptogram;