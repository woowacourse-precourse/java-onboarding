package onboarding;

/*
1. cryptogram에 연속된 부분이 있으면 while문 반복
    a. cryptogram에 연속된 부분이 있을 때마다, 제거하고 마저 확인
    b. 연속된 부분이 없으면 isDuplicated를 false로 바꾸고 while문 중단
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        boolean isDuplicated = true;
        String code = cryptogram;
        while(isDuplicated){
            char bf = 0;
            int i = 0;
            boolean isChanged = false;
            String left, right;
            for(char c : code.toCharArray()){
                if(c == bf) {
                    left = code.substring(0, i - 1);
                    right = code.substring(i + 1);
                    code = left+right;
                    isChanged = true;
                    break;
                }
                i++;
                bf = c;
            }
            isDuplicated = isChanged;
        }
        answer = code;
        return answer;

    }
}
