package onboarding;

/**
 * Programs should be written for people to read, and only incidectally for machine to execute
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = recursion(cryptogram);
        return answer;
    }

    /**
     * 문제 요구사항에 따라 재귀적으로 중복을 제거해 나간다.
     * 반복문의 수를 줄여 코드의 가독성을 높인다.
     */

    private static String recursion(String cryptogram){
        char[] chars = cryptogram.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        boolean isClear = true;
        char prev = ' ';
        for(char a : chars){
            if(a != prev){
                prev = a;
                stringBuffer.append(a);
            }
            else{
                int lastChar = stringBuffer.length() - 1;
                stringBuffer.deleteCharAt(lastChar);
                isClear = false;
            }
        }
        if(isClear){
            return stringBuffer.toString();
        }
        return recursion(stringBuffer.toString());
    }


}
