package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++){
            int cnt = 0;
            // i가 한자리수인 경우
            if (i<10){
                if (i==3 || i==6 || i==9){
                    cnt += 1;
                }
                answer += cnt;
                continue;
            }

            // i가 2자리수 이상인 경우
            String iString = String.valueOf(i);
            for (int k=0; k<iString.length(); k++){
                if (iString.charAt(k) == '3' || iString.charAt(k) == '6' || iString.charAt(k) == '9'){
                    cnt += 1;
                    }
            }
            answer += cnt;
        }

        return answer;
    }
}
