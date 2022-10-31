package onboarding;

public class Problem4 {
    public static String solution(String word) {

        char[] word_arr = word.toCharArray();
        char[] result_arr = new char[word_arr.length];
        for(int i = 0; i < word_arr.length; i++) {
        	if(word_arr[i] >= 65 && word_arr[i] <= 90) result_arr[i] = (char)(65 + (90 - word_arr[i])); // 대문자
        	else if(word_arr[i] >= 97 && word_arr[i] <= 122) result_arr[i] = (char)(97 + (122 - word_arr[i])); // 소문자
        	else result_arr[i] = word_arr[i];
        }
        String answer = new String(result_arr);

        return answer;
    }
}