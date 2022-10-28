package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
    	
    	char[] cryptogramArr = cryptogram.toCharArray();
    	findDuplicateChars(cryptogramArr);
    	
        String deduplicationCrypto = getFinalCrypto(cryptogramArr);
        
        return deduplicationCrypto;
    }
    public static void findDuplicateChars(char[] cryptogramArr) {
    	
    	Stack<Character> pastChars = new Stack<>();
    	Stack<Integer> pastIdxes = new Stack<>();
    	
    	for(int i=0; i<cryptogramArr.length; i++) {
    		char cur = cryptogramArr[i];
    		
    		if(pastChars.isEmpty()) {
    			pastChars.add(cur);
    			pastIdxes.add(i);
    		} else {

    			char pastChar = pastChars.peek();
    			int pastIdx = pastIdxes.peek();
    			
    			if(pastChar == cur) {
    				pastChars.pop();
    				pastIdxes.pop();
    				removeDuplicateChars(cryptogramArr, pastIdx, i);
    			} else {
    				pastChars.add(cur);
    				pastIdxes.add(i);
    			}
    		}
    	}
    }
    public static void removeDuplicateChars(char[] cryptogramArr, int pastIdx, int curIdx) {
    	cryptogramArr[pastIdx] = '0';
    	cryptogramArr[curIdx] = '0';
    }
    public static String getFinalCrypto(char[] cryptogramArr) {
        String deduplicationCrypto = "";
    	StringBuilder sb = new StringBuilder();
        for(char c: cryptogramArr) {
        	if(c=='0') continue;
        	sb.append(c);
        }
        deduplicationCrypto = sb.toString();
        return deduplicationCrypto;
    }
}
