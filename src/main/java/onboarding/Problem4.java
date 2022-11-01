package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 문자 하나하나 확인 해야하기에 배열로 변환
        char [] wordToStr = word.toCharArray();
        for(int i = 0; i < wordToStr.length; i++){
            if(wordToStr[i] >= 'a' && wordToStr[i] <= 'z')
                wordToStr[i] += (25 - 2*Math.abs(wordToStr[i] - 97));
            else if(wordToStr[i] >= 'A' && wordToStr[i] <= 'M')
                wordToStr[i] += (25 - 2*Math.abs(wordToStr[i] - 65));
        }
        return new String(wordToStr);
    }
}
