package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decodeCryptogram(cryptogram);
        return answer;
    }

    /**
     * cryptogram 으로 암호화된 문자열을 해독하는 메소드
     * @param cryptogram : 해독할 문자열
     * @return 해독된 문자열
     */
    private static String decodeCryptogram(String cryptogram){
        // 해독 결과 변수
        String result = cryptogram;
        // result의 값을 저장하기 위한 변수
        String tempResult = null;

        // 중복 제거 후 변화가 없을 때까지 중복 제거
        while (!result.equals(tempResult)){
            tempResult = result;
            result = removeDuplication(result);
        }

        // 모든 중복이 제거된 (해독된) 결과 반환
        return result;
    }

    /**
     * 문자열의 중복 문자를 찾아 제거하는 메소드
     * @param str : 중복 문자를 삭제할 메소드
     * @return 중복 문자가 제거된 문자열
     */
    private static String removeDuplication(String str){
        //중복 소문자를 찾는 정규표현식
        String regex = "(([a-z])\\2{1,})";
        //정규 표현식에 해당하는 문자를 빈 문자열로 치환
        String result = str.replaceAll(regex, "");

        return result;
    }
}
