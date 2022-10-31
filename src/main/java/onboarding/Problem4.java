package onboarding;

public class Problem4 {
    static String makeReverse(String word){
        char[] chars = word.toCharArray();

        for(int i = 0; i < chars.length; i++){
            int val = (int)chars[i];
            if(val >= 65 && val <= 90){ // 대문자일 경우
                int diff = val - 65;
                chars[i] = (char)(90-diff);
            }else if(val >= 97 && val <= 122){  // 소문자일 경우
                int diff = val - 97;
                chars[i] = (char)(122-diff);
            }
        }

        String result = new String(chars);
        return result;
    }
    public static String solution(String word) {
        String answer = "";
        answer = makeReverse(word);
        return answer;
    }
}
