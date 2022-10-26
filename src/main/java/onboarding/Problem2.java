package onboarding;

import java.util.StringJoiner;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
//        System.out.println(removeDupChars(cryptogram));
        return answer;
    }
    
    /**
     * 전달받은 문자열에서 중복문자가 존재하는 인덱스와 동일한 인덱스에 true값을 저장한 boolean 배열을 반환한다.
     * @param cryptogram
     * @return boolean 배열
     */
    private static boolean[] checkDuplicated(String cryptogram) {
    	boolean[] isDuplicate = new boolean[cryptogram.length()];
    	for (int i = 1; i < cryptogram.length(); i++) {
    		// 이전의 문자값과 현재의 문자값이 동일한 경우 true값을 저장한다.
    		if (cryptogram.charAt(i-1) == cryptogram.charAt(i)) {
    			isDuplicate[i-1] = true;
    			isDuplicate[i] = true;
    		}
    	}
    	return isDuplicate;
    }
    
    /**
     * 전달받은 문자열에서 중복문자를 제거한 문자열 반환한다.
     * @param cryptogram
     * @return 중복문자를 제거한 문자열
     */
    private static String removeDupChars(String cryptogram) {
    	String result = "";
    	// false값이 저장된 인덱스 위치의 문자열만 더한다.
    	for (int i = 0; i < cryptogram.length(); i++) {
    		if (!checkDuplicated(cryptogram)[i]) {
    			result += cryptogram.charAt(i);
    		}
    	}
    	
    	return result;
    }
}
