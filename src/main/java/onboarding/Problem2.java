package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String str = "";
        int start = 0;
        int end = 1;
        while(end < cryptogram.length()) {
        	if(start >= end) break;
        	if(cryptogram.charAt(start) != cryptogram.charAt(end)) {
        		if(str.equals("")) {
        			start = end;
            		end += 1;
        		}else {
        			cryptogram = cryptogram.replace(str, "");
        			start = 0;
        			end = 1;
        			str = "";
        		}
        	}else {
        		str = cryptogram.substring(start, end+1);
        		if(cryptogram.equals(str)) cryptogram = "";
        		end += 1;
        	}
//        	System.out.println("str : " + str + " start : " + start + " end : " + end);
        	answer = cryptogram;
        }
        return answer;
    }
}
// browoanoommnaon