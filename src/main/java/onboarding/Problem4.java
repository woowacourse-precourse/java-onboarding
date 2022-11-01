package onboarding;

public class Problem4 {
    public static String solution(String word) {

        StringBuffer sb = new StringBuffer();
        char[] wordCharArr = word.toCharArray();
        int ascii = 0;
        int absVal = 0;
        int reverseWord = 0;


        for(char wordTemp : wordCharArr){
            if(Character.isUpperCase(wordTemp)){
                ascii = 65;
            }else if(Character.isLowerCase(wordTemp)){
                ascii = 97;
            }else {
                sb.append(wordTemp);
                continue;
            }
            // ascii에서 해당 문자의 아스키 코드 값을 밴 후 절댓값을 취함
            absVal = Math.abs(ascii - wordTemp);
            // ascii에서 영문자의 개수 만큼 더한 후 avsVal을 빼게되면 반대 영문자로 변환됨
            reverseWord = (ascii + 25) - absVal;
            sb.append((char) reverseWord);
        } // end for

        String answer = sb.toString();

        return answer;
    }
}
