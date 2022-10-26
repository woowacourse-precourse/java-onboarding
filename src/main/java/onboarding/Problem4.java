package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] wordChar = word.toCharArray();
        char[] result = new char[wordChar.length];

        for(int i=0; i<result.length; i++){
            if('a'<= wordChar[i] && wordChar[i] <= 'z'){
                result[i] = (char)('a'+ ('z'- wordChar[i])) ;
            } else if ('A'<= wordChar[i] && wordChar[i]<='Z') {
                result[i] = (char)('A'+ ('Z'- wordChar[i]));
            } else {
                result[i] = wordChar[i];
            }
        }

        for(char c:result){
            sb.append(c);
        }

        answer = sb.toString();
        return answer;
    }
}
