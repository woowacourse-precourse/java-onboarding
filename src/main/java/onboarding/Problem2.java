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
    	Stack<int[]> pastCharAndIdxes = new Stack<int[]>();
    	
    	for(int i=0; i<cryptogramArr.length; i++) {
    		char cur = cryptogramArr[i];
    		
    		if(pastCharAndIdxes.isEmpty()) {
    			pastCharAndIdxes.add(new int[] {cur, i});
    		} else {
    			int[] pastCharAndIdx = pastCharAndIdxes.peek();
    			char pastChar = (char)pastCharAndIdx[0];
    			int pastCharIdx = pastCharAndIdx[1];
    			
    			if(pastChar == cur) {
    				pastCharAndIdxes.pop();
    				removeDuplicateChars(cryptogramArr, pastCharIdx, i);
    			} else {
    				pastCharAndIdxes.add(new int[] {cur, i});
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
