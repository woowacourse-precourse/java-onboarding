package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int num = 0;
        int change_num = 0;

        for(int i=0;i<word.length();i++){
            num = (int)word.charAt(i);
            if(num == 32) answer += " ";
            else{
                if(num>=97){
                    change_num = 122 - (num - 97);
                }
                else{
                    change_num = 90 - (num - 65);
                }
                answer += (char)change_num;
            }
        }

        return answer;
    }
}
