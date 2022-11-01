package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "answer";
		answer = removeAdjDup(cryptogram);
        return answer;
    }
    
    public static String removeAdjDup(String str){
    	 
        char[] chars = str.toCharArray();
        int i, k = 0;
 
        for (i = 1; i < chars.length; i++){
            if (chars[i - 1] != chars[i]) {
                chars[k++] = chars[i - 1];
            }
            else {
                while (i < chars.length && chars[i - 1] == chars[i]) {
                    i++;
                }
            }
        }
 
        chars[k++] = chars[i - 1];
 
        String s = new String(chars).substring(0, k);
 
        if (k != chars.length) {
            return removeAdjDup(s);          
        }
 
        return s;
    }
}
