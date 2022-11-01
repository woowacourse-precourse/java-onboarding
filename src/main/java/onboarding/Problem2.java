package onboarding;

public class Problem2 {
    // 기능 구현 목록
    // 1. 예외처리 (cryptogram의 길이가 1이상 1000 이하인 문자열이 아닌 경우)
    // 2. 문자열 해독 및 해독한 문자열 반환
    public static String solution(String cryptogram) {

        //예외처리
        // 1. cryptogram의 길이가 1이상 1000 이하인 문자열이 아닌 경우
        if (1 > cryptogram.length() || 1000 < cryptogram.length()){
            String e = "wrong input";
            return e;
        }

        // 입력 문자열을 소문자로 변경
        cryptogram = cryptogram.toLowerCase();


        //문자열 해독
        while (true) {

            int count = 0; // 더이상 연속하는 중복 문자가 없는지 확인하기 위한 변수

            for (int i = 0; i < cryptogram.length() - 1; i++) {

                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) { // 연속하는 두 문자가 중복 문자라면
                    StringBuffer temp_cryptogram = new StringBuffer(cryptogram); // delete를 사용하기 위해 StringBuffer로 변환
                    cryptogram = temp_cryptogram.delete(i, i + 2).toString(); // 연속하는 중복 문자들을 삭제
                    count += 1;
                }
            }
            if (count == 0){ // 연속하는 중복 문자가 존재하지 않는다면
                break; // 반복문 빠져나감
            }
        }

        //System.out.println(cryptogram);

        // 해독한 문자열 반환
        String answer = cryptogram;
        return answer;
    }
}
