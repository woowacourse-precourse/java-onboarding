package onboarding;

/*
 * # 기능 정리
 * [O] 연속하는 중복문자 검증
 * [?] 제거된 문자열 반환 메서드
 * [O] 1~2 기능 반복 메서드
 * [O] solution 작성
 * [X] 테스트 확인
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = checkStringCompressed(cryptogram);
        return answer;
    }

    private static String checkStringCompressed(final String origin){
        String before = "";
        String compressed = origin;

        while(!before.equals(compressed)){
            before = compressed;
            compressed = compressString(compressed).toString();

            System.out.println(before);
            System.out.println(compressed);
        }

        return compressed;
    }

    private static StringBuffer compressString(final String str){
        StringBuffer compressedString = new StringBuffer();

        compressedString.append(str.charAt(0));
        for(int i = 1; i < str.length(); i++){
            char beforeChar = str.charAt(i - 1);
            char currentChar = str.charAt(i);

            if(beforeChar != currentChar)
                compressedString.append(currentChar);
        }

        return compressedString;
    }
}
