package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        // Exception
        if (cryptogram == null || cryptogram.length() == 0) {
            return answer;
        }

        // Progress_1
        char[] compare = cryptogram.toCharArray();
        char temp = 0;
        int i = 0, k = 0;

        // if) Symmetry(대칭) 구조일 경우 변수 선언
        int lt = 0, rt = compare.length-1;
        // if) Symmetry(대칭) 구조일 경우 예외 처리문
        if(compare[lt] == compare[rt]) {
            for(int j = 1; j < compare.length; j++) {
                if(compare[lt + j - 1] == compare[rt - j + 1]) {
                    // 대칭 구조이면서 모든 중복이 제거되어 반환할 값이 없을 경우
                    if(compare[lt + j] == compare[rt - j]) return answer = "";

                    // 대칭 구조이면서 길이가 짝수일경우
                    if(cryptogram.length() % 2 == 0) {
                        return answer = cryptogram.substring(cryptogram.length()/2-1,
                                cryptogram.length()/2+1);
                    }
                    // 대칭 구조이면서 길이가 홀수일경우
                    else if(cryptogram.length() % 2 != 0) {
                        return answer = cryptogram.substring(cryptogram.length()/2,
                                cryptogram.length()/2+1);
                    }
                    continue;
                }
            }
        }
        // Progress_2
        for(i = 1; i < compare.length; i++) {

            if(compare[i - 1] != compare[i]) {
                compare[k++] = compare[i - 1]; // 후위증가연산자, 이전 문자로 업데이트
            }
            else {
                while (i < compare.length && compare[i - 1] == compare[i]) i++;
            }
        }
        // 마지막 문자까지 추가
        compare[k++] = compare[i - 1];

        // Create New String
        String c = new String(compare).substring(0, k);

        // 중복이 제거되면 다시 시작(새롭게 구성된 문자열로 재호출) - 슐레미엘 화가의 알고리즘
        if(k != compare.length) return solution(c);

        answer = c;

        // Remove All Overlap char result
        return answer;
    }
}
