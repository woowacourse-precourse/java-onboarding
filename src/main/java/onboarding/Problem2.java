package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        // stringBuilder를 스택처럼 사용
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cryptogram.length(); ++i){
            // 스택이 비었으면 push
            if(sb.length() == 0) sb.append(cryptogram.charAt(i));
            // 스택의 가장 위의 값과 다음 입력 값이 같으면 pop 아니면 push
            else{
                if(sb.charAt(sb.length() - 1) == cryptogram.charAt(i))
                    sb.deleteCharAt(sb.length() - 1);
                else
                    sb.append(cryptogram.charAt(i));
            }
        }

        return sb.toString();
    }
}
