package onboarding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "";

        // 문자열을 리스트화
        ArrayList<Character> list = new ArrayList<>();
        cryptogram.chars().forEach((val)-> {
            list.add((char) val);
        });

        int left = 0;
        int right = 1;

        // 슬라이딩 윈도우 전략으로 앞,뒤가 같은 문자 제거
        while (true) {
            // 리스트 마지막 값보다 오른쪽 스코프가 커지면 종료
            if(right > list.size()-1 ){
                break;
            }
            // 비교할 문자 가져오기
            Character front = list.get(left);
            Character back = list.get(right);

            // 앞 뒤 문자가 같을 때 리스트에서 값을 제거하고 스코프 조정
            if (front == back) {
                if(right == cryptogram.length()){
                    list.remove(left);
                    list.remove(--right);
                }else {
                    list.remove(left--);
                    list.remove(--right);
                }
            }else {
                // 앞 뒤 문자가 다르다면 다음 위치로 이동
                left++;
                right++;
            }
        }

        // 구한 리스트를 문자열로 변환 ( 스트림 연산을 이용한 방법 실패 )
        for (char l : list) {
            answer += l;
        }

        return answer;
    }

    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";
        solution(cryptogram);
    }
}