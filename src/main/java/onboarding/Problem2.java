package onboarding;

import java.util.regex.Pattern;

/**
 * 기능 요구사항
 * 1. 예외체크
 * 2. 중복제거
 * 3. solution 구현
 */
public class Problem2 {
    private static final String ALLOWED_CHARACTERS ="a-z";
    private static final Pattern pattern = Pattern.compile("[^"+ALLOWED_CHARACTERS+"]");
    public static String solution(String cryptogram) {
        Problem2 problem2 = new Problem2();
        String str = problem2.checkCryptogram(cryptogram);
        return problem2.deleteDuplicateChar(str);
    }

    /**
     * 유효성 검사
     * @param str 소문자로만 이루어진 알파벳
     * @return 소문자로 이루어진 연속적인 문자열이 아닌 경우 "" 빈 문자열 반환.
     */
    private String checkCryptogram(String str){
        if(pattern.matcher(str).matches() ||
        str.length() > 1000 ||
        str.length() < 1) return "";
        return str;
    }

    /**
     * 연속되는 문자열이 존재할 경우 true를 반환한다.
     * @param str 연속적인 문자열
     * @return 연속되는 문자열이 존재할 경우 true.
     */
    private boolean checkDuplicateChar(String str){
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)) return true;
        }
        return false;
    }

    /**
     * 중복된 문자를 제거한다.
     * @param str 연속적인 문자열
     * @return 중복 문자가 없을 경우 반환한다.
     */
    public String deleteDuplicateChar(String str){
        //탈출 조건 -> 중복된 문자열이 존재하지 않는다.
        if(!checkDuplicateChar(str)) return str;
        //문자열 생성
        StringBuilder sb = new StringBuilder();
        //중복되지 않은 문자만 담는다.
        for(int i=0; i<str.length()-1; i++){
            //중복 문자 발견
            if(str.charAt(i) == str.charAt(i+1)){
                //다음 중복되지 않은 인덱스까지 점프
                while(str.charAt(i) == str.charAt(i+1) && i < str.length()-2) i++;
                continue;
            }
            sb.append(str.charAt(i));
        }
        //마지막 문자에 대한 처리
        if(str.charAt(str.length()-1) != str.charAt(str.length()-2)){
            sb.append(str.charAt(str.length()-1));
        }
        return deleteDuplicateChar(sb.toString());
    }


}
