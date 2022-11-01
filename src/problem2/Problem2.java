package problem2;

import java.util.Random;

public class Problem2 {
	public static String solution(String cryprogram) {
	
		if (cryprogram == null || cryprogram.length() == 0) return cryprogram;

        char[] chars = cryprogram.toCharArray();
        int i, j = 0;
     
        for (i=1; i<chars.length; i++){
            if (chars[i] != chars[i-1]) {
                chars[j++] = chars[i-1];
            }
            else { // 연속하는 중복 제거
                while (i < chars.length && chars[i] == chars[i-1]) i++;
            }
        }
        chars[j++] = chars[i-1];
 
        String result = new String(chars).substring(0, j);
        if (j != chars.length) {
            return solution(result);            
        }
 
        return result;
	}
	
	// 임의의 문자열 생성 
	public static String randomCode() {
		
		int a = 97;  
		int z = 122;
		int length = 10;
		
		Random random = new Random();
						
		String answer = random.ints(a, z+1)
				.limit(length)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		
		return answer;
	
	}
}
