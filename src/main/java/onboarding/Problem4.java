package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] chArray = word.toCharArray();
        for(int i = 0; i < chArray.length;i++){
            if(chArray[i] >= 'a' && chArray[i] <= 'z'){
                chArray[i] = (char)('m'+'n' - chArray[i]);
            }
            else if(chArray[i] >= 'A' && chArray[i] <= 'Z'){
                chArray[i] = (char)('M'+'N' - chArray[i]);
            }
        }
        answer = String.valueOf(chArray);
        return answer;
    }
}
