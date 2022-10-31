package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder("");

        String sequenceUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String sequenceLower = "abcdefghijklmnopqrstuvmxyz";

        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==' '){ // 공백일 경우
                sb.append(' '); // 공백 추가
            } else{
                if(Character.isUpperCase(word.charAt(i))){ // 대문자일경우
                    int fIndex = sequenceUpper.indexOf(word.charAt(i)); // Character.toString(cr) String.valueOf(cr)
                    sb.append(sequenceUpper.charAt(sequenceUpper.length()-fIndex-1));
                } else{ // 소문자일 경우
                    int fIndex = sequenceLower.indexOf(word.charAt(i));
                    sb.append(sequenceLower.charAt(sequenceLower.length()-fIndex-1));
                }
            }

        }

        String answer = sb.toString();
        return answer;
    }
}
