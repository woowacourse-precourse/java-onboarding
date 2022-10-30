package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

//        1. 1차적으로 중복되는 문자들을 모두 삭제
        char[] chars = cryptogram.toCharArray();
        for(int i = 0; i < chars.length-1; i++){
            if(chars[i] != chars[i+1] ){
                answer += chars[i];
                if(i == chars.length-2){
                    answer += chars[i+1];
                }
            }
            else { i += 1;}

        }

//        2. while 문을 통해 연속되는 중복문자들이 없을 때까지 실행

        return answer;
    }

    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";
        System.out.println(solution(cryptogram));
    }
}
