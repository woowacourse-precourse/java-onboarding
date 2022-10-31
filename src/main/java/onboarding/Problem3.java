package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++){
            String str = String.valueOf(i);
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(clap(c)){
                    answer++;
                }
            }
        }

        return answer;
    }

    /**
     * 3, 6, 9 인지 확인하는 메소드
     * @param c
     * @return 3, 6, 9 라면 true, 아니면 false
     */
    static boolean clap(char c){
        if(c == '3' || c == '6' || c == '9'){
            return true;
        }

        return false;
    }
}
