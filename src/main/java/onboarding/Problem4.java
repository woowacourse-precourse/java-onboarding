package onboarding;

/*
1. 청개구리 사전인덱스 순서대로 return 값만 배열에 저장한다.
2. 검색할 때 소문자인지 대문자인지 아스키값을 기준으로 검색하고 플래그에 저장된다.
3. 리턴받은 값을
 */

public class Problem4 {

    private static int[] dic = new int[26];

    public static String solution(String word) {

        String answer = "";

        initDic();
        answer = changeChar(word);

        return answer;
    }

    private static void initDic() {
        for (int i = 0; i < 26; i++) {
            dic[i] = 'Z' - i;
        }
    }

    private static String changeChar(String word) {
        int len = word.length();
        char translation [] = new char[len];

        for (int i = 0; i < len; i++) {
            if (isLower(word.charAt(i))) {
                translation[i] = (char)(dic[word.charAt(i) - 32 - 48] + 32);
            } else {
                translation[i] = (char) dic[word.charAt(i) - 48];
            }
        }
        return new String(translation);
    }
}
