package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int asciinum =0;
        String answer = "";

        for(int i=0;i<word.length();i++){
            if(word.charAt(i) != 32 && (word.charAt(i) < 65 || (word.charAt(i) > 90 && word.charAt(i) < 97) ||
                    word.charAt(i) > 122)) continue; // 바꾸려는 문자가 알파벳이 아니면 변환 X


            if(word.charAt(i) == 32) answer = answer + " ";

            if(word.charAt(i) < 91 && word.charAt(i) > 64) {
                asciinum = 155 - word.charAt(i);
                answer = answer + (char) asciinum;
            }
            else if(word.charAt(i) > 96 && word.charAt(i) < 123) {
                asciinum = 219 - word.charAt(i);
                answer = answer + (char) asciinum;
            }
        }
        return answer;
    }
}
