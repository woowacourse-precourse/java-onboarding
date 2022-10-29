package onboarding;

public class Problem2 {
    /*
    * 기능 구현 목룍
    * 1. 인접한 문자열이 같은 경우, 없애는 로직
    * 2. 이걸 모든 인접한 문자열이 다를때까지 진행
    * */
    public static String solution(String cryptogram) {
        String answer = "";

        String s =cryptogram;

        if (s.length()==1){
            return s;
        }

        while (true){
            int cnt = 0;

            for (int i=0;i<s.length()-1;i++){
                if (s.charAt(i)==s.charAt(i+1)){
                    cnt+=1;
                    s = s.substring(0,i)+s.substring(i+2);
                    break;
                }
            }

            if (cnt ==0){
                break;
            }
        }
        answer = s;
        return answer;
    }
}
