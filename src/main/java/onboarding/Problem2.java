package onboarding;

import java.util.HashSet;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        boolean overlap_check = true; //연속하는 중복 문자 있는지 체크
        String[] each_letter_arr = cryptogram.split("");
        while (overlap_check){
            //루프 시작 초기값 대입
            answer = "";
            overlap_check = false;
            HashSet<Integer> letter_idx_set = new HashSet<>(); //시간복잡도를 고려한 HashSet
            //연속하는 중복 문자 인덱스 저장
            for (int i = 0; i < each_letter_arr.length - 1; i++){
                    if (each_letter_arr[i].equals(each_letter_arr[i+1])) {
                        overlap_check = true;
                        letter_idx_set.add(i);
                        letter_idx_set.add(i+1);
                    }
            }
            //연속하는 중복 문자가 아닌 경우 문자열에 입력
            for (int i = 0; i < each_letter_arr.length; i++){
                if (!letter_idx_set.contains(i)) {
                    answer += each_letter_arr[i];
                }
            }
            //다음 루프를 위한 세팅
            each_letter_arr = answer.split("");
        }
        return answer;
    }
}
