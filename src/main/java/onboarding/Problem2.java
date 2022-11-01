package onboarding;

public class Problem2 {
    /*
        check라는 변수를 통해 변동사항이 있는지 체크
        answer의 길이가 0이거나 check가 false 인 경우 반복문 종료
        before_index와 after_index를 할용해 문자열의 중복 구간의 index를 구함
        temp라는 변수로 이전 문자열과 for문 안의 i번째 문자열을 비교
        중복 구간의 처음과 끝을 나타내는 before_index와 after_index의 값이 다른 경우 중복이 발생했으므로 중복문자열을 제거하는 deduplication 메서드 실행
        for문이 종료된 후 마지막으로 남은 중복 구간이 없는지 확인 후 중복 구간이 있다면 deduplication 메서드 실행

     */
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        Boolean check = true;

        while(answer.length()>0 && check){
            int before_index = 0;
            int after_index = 0;
            char temp = cryptogram.charAt(0);
            check = false;

            for(int i=1; i<cryptogram.length(); i++) {
                if(temp == cryptogram.charAt(i)){
                    check = true;
                    ++after_index;
                }else{
                    if (before_index != after_index){
                        answer = deduplication(before_index,after_index,answer);
                        --before_index;
                        after_index = before_index;
                    }
                    ++before_index;
                    ++after_index;
                }
                temp = cryptogram.charAt(i);
            }

            if (before_index != after_index) {
                answer = deduplication(before_index, after_index, answer);
            }

            cryptogram = answer;
        }

        return answer;
    }
    public static String deduplication(int first, int last, String words) {
        return words.substring(0,first)+words.substring(last+1);
    }
}
