package onboarding;

/**
 * <기능 목록>
 *     1. 메소드
 *          1) deduplicate
 *          : '현재 문자열'에서 중복되는 단어들을 제거한 문자열을 반환한다.
 *
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = deduplicate(cryptogram);
        return answer;
    }

    public static String deduplicate(String word){
        // 빈 문자열의 경우 : 그대로 반환함.
        if(word == null || word.equals("")){
            return word;
        }

        char[] chars = word.toCharArray();
        String result = "";

        int i;

        for (i = 1; i<=chars.length; i++){

            if(i < chars.length){
                if (chars[i-1] != chars[i]){
                    result += chars[i-1];
                } else {
                    while (i < chars.length && chars[i-1] == chars[i]){
                        i++;
                    }
                }
            } else if (chars[i-1] == chars[i-1]) {
                result += chars[i-1];
            }
        }

        // 중복이 있으면 temp.length() != chars.length
        // 이런 경우 중복 제거된 result로 다시 중복 여부 체크하고, 중복있다면 제거
        if(result.length() != chars.length){
            return deduplicate(result);
        }


        return result;
    }

}
