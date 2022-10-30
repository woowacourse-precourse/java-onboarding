package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = game(number);
        return answer;
    }

    public static int game(int number){
        int count = 0;
        // 입력 받은 숫자까지 순차적으로 접근
        for(int i=0; i<=number; i++){
            // 순차적으로 접근하는 숫자를 charArray로 변환
            char[] charArray = Integer.toString(i).toCharArray();
            // 배열 길이 만큼 반복문 실행 각 배열의 값이 3,6,9 라면 카운트 하나씩 증가
            for(int j=0; j<charArray.length; j++){
                if(charArray[j]=='3'||charArray[j]=='6'||charArray[j]=='9'){
                    count +=1;
                }
            }
        }
        return count;
    }
}
