package onboarding;

public class Problem2 {
    static char[] answer;
    static String temp;
    public static String solution(String cryptogram) {
        temp = cryptogram;
        findWord(false);
        return temp;
    }
    public static void findWord(boolean check){
        answer = temp.toCharArray();
        for (int i = 0 ; i < answer.length-1 ; i++){
            char ch = answer[i];
            if (ch==answer[i+1] && ch!='0'){
                //convert(i,findLength(i));
                check =true;
            }
        }
        if (check) {
            //generateString();
            findWord(false);
        }
    }
}
