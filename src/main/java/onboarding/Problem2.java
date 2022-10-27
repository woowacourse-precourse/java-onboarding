package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        ArrayList<String> decipher;
        int index = -1;

        // string -> arrayList 로 변환
        decipher = changeString(cryptogram);

        while(true) {
            // 중복되는 문자열 찾기
            index = duplicateIndex(decipher);

            // 더 이상 중복되는 문자열이 없을 경우 return
            if(index == -1) {
                answer = changeList(decipher);
                break;
            }

            // 중복되는 문자열이 있을 경우, 중복 문자 삭제 후 업데이트
            decipher = deleteList(decipher, index);
        }


        return answer;
    }

    // string -> arrayList 로 변환
    private static ArrayList<String> changeString(String input) {
        String[] strArr = input.split("");
        ArrayList<String> output = new ArrayList<String>(Arrays.asList(strArr));
        return output;
    }

    // arrayList -> string 로 변환
    private static String changeList(ArrayList<String> input) {
        String answer = "";
        for(int i = 0; i<input.size(); i++) {
            answer += input.get(i);
        }
        return answer;
    }

    // 연속 중복되는 문자열 찾기
    private static int duplicateIndex(ArrayList<String> input) {

        for(int i = 0; i<input.size(); i++) {
            if(i != input.size()-1 && input.get(i).equals(input.get(i+1))) {
                return i;
            }
        }
        // 연속으로 중복된 문자열이 없을 경우, -1을 리턴
        return -1;
    }

    // 연속 중복되는 문자열 삭제
    private static ArrayList<String> deleteList(ArrayList<String> input, int index) {
        // 중복된 문자열이 있을 경우
        input.remove(index);
        input.remove(index);

        return input;
    }

}
