package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while(true){
            answer = cryptogram;
            cryptogram = remove_repeatChar(cryptogram);
            // 반복 문자를 제거하는 메서드를 수행하고 나서 변화가 없다면 탈출
            if (answer.equals(cryptogram)) break;
        }

        return answer;
    }

    public static String remove_repeatChar(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.append(' ');
        /*
            문자열을 탐색하면서 현재 문자와 다음 문자가 같으면 현재 문자와
            다음 문자를 문자열 상에서 삭제하고, 함수를 탈출한다.
         */
        for(int i = 0; i < sb.length() - 1; i++){
            if(sb.charAt(i) == sb.charAt(i + 1)){
                sb.delete(i, i + 2);
                break;
            }
        }
        // 앞서 넣었던 공백 문자를 지운다.
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
