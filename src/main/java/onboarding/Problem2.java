package onboarding;

/*
 * # 기능 정리
 * [O] 연속하는 중복문자 검증
 * [O] 제거된 문자열 반환 메서드
 * [O] 1~2 기능 반복 메서드
 * [O] solution 작성
 * [O] 테스트 확인
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

            System.out.println(compressed);
        }

        return compressed;
    }

    private static StringBuffer compressString(final String origin){
        StringBuffer compressed = new StringBuffer();
        int originIdx = 1;
        boolean isLastCharDuplicate = false;

        while(originIdx < origin.length()){
            char beforeChar = origin.charAt(originIdx - 1);
            char currentChar = origin.charAt(originIdx);

            if(beforeChar == currentChar)
                isLastCharDuplicate = true;
            else{
                if(!isLastCharDuplicate){
                    compressed.append(beforeChar);
                }

                if(originIdx == origin.length() - 1)
                    compressed.append(currentChar);

                isLastCharDuplicate = false;
            }

            originIdx++;
        }

        return compressed;
    }
}
