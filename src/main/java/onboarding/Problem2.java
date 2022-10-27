package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        StringBuffer result = new StringBuffer(cryptogram); //delete를 사용하여 중복 문자열을 제거하기 위하여 StringBuffer 사용

        int index = 0;
        while (true) {
            if (index+1 >= result.length()) { //중복된 문자열이 없이 범위를 넘어가면 종료
                break;
            }
            if (result.charAt(index) == result.charAt(index + 1) ) {  // 중복이자 연속된 문자열이 진행될 경우
                deDuplication(result, index);
                index=-1; // index -1로 초기화
            }
            index++;
        }

        answer= String.valueOf(result);
        return answer;
    }

    private static void deDuplication(StringBuffer result, int index) {
        if(result.length()==2){ // zz와 같이 문자열의 길이가 2일경우 따로 처리
            result.delete(index, index +2);
        }
        else { // 중복된 문자의 끝 index가 어디까지인지 범위를 찾고 그곳까지 문자열 삭제
            for (int j = index; j < result.length(); j++) {
                if (result.charAt(index) != result.charAt(j)) {
                    result.delete(index, j);
                    break;
                }
            }
        }
        return;
    }
}
