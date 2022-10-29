package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";
        StringBuffer result = new StringBuffer(
            cryptogram); //delete를 사용하여 중복 문자열을 제거하기 위하여 StringBuffer 사용

        int index = 0;
        while (true) {
            if (index + 1 >= result.length()) { //중복된 문자열이 없이 범위를 넘어가면 종료
                break;
            }
            if (result.charAt(index) == result.charAt(index + 1)) {  // 중복이자 연속된 문자열이 진행될 경우
                deDuplication(result, index);
                index = -1; // index -1로 초기화
            }
            index++;
        }

        answer = String.valueOf(result);
        System.out.println("answer = " + answer);
        return answer;
    }

    private static void deDuplication(StringBuffer result, int index) {
        if (result.length() == 2) {
            result.delete(index, index + 2);
        } else if (result.length() > 2) {
            for (int j = index; j < result.length(); j++) {
                if (result.charAt(index) != result.charAt(j)) { // 맨 끝까지 같은 문자가 나오지 않을 경우 걸러내게 됨.
                    result.delete(index, j);
                    break;
                }

            }
        }
        return;
    }
}
