package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
    	
    	char[] cryptogramArr = cryptogram.toCharArray();
    	getDeduplicateCrypto(cryptogramArr);
    	
        String deduplicationCrypto = getFinalCrypto(cryptogramArr);
        
        return deduplicationCrypto;
    }
    public static void getDeduplicateCrypto(char[] cryptogramArr) {
    	
    	Stack<Character> pastChars = new Stack<>();
    	Stack<Integer> pastIdxes = new Stack<>();
    	Stack<Integer> duplicateCharIdxes = new Stack<>();
    	
    	for(int idx=0; idx<cryptogramArr.length; idx++) {
    		char cur = cryptogramArr[idx];
    		
    		if(pastChars.isEmpty()) {
    			pastChars.add(cur);
    			pastIdxes.add(idx);
    		} else {
    			char pastChar = pastChars.peek();
    			int pastIdx = pastIdxes.peek();
    			
    			if(pastChar == cur) {
    				if(idx!=cryptogramArr.length-1) {
        				duplicateCharIdxes.add(idx);    					
    				} else {
    					cryptogramArr[idx] = '0';
    					removeDuplicateChars(cryptogramArr, pastIdx, duplicateCharIdxes);
    				}
    			} else {
    				
    				if(duplicateCharIdxes.isEmpty()) {
    					pastChars.add(cur);
    					pastIdxes.add(idx);
    				} else {
    					pastChars.pop();
    					pastIdxes.pop();
    					removeDuplicateChars(cryptogramArr, pastIdx, duplicateCharIdxes);
    					idx -= 1;
    				}
    			}
    		}
    	}
    }
    public static void removeDuplicateChars(char[] cryptogramArr, int pastIdx, Stack<Integer> duplicateCharIdxes) {
    	cryptogramArr[pastIdx] = '0';
    	while(!duplicateCharIdxes.isEmpty()) {
    		cryptogramArr[duplicateCharIdxes.pop()] = '0';
    	}
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
