package onboarding;

public class Problem3 {
    public static int check369(String str){
        int result = 0;
        int num;
        for(int i=0; i<str.length(); i++){
            num = str.charAt(i);
            if(num=='3' || num=='6' || num=='9'){
                result++;
            }
        }
        return result;
    }
    public static int solution(int number) {
        int answer = 0;
        String strnum = "";
        for(int i=1; i<=number; i++){
            strnum = Integer.toString(i);
            answer += check369(strnum);
        }
        return answer;
    }
}