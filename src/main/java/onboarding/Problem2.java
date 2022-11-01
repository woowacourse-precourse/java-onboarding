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
                convert(i,findLength(i));
                check =true;
            }
        }
        if (check) {
            //generateString();
            findWord(false);
        }
    }
    public static int findLength(int index){
        int count = 1;
        char ch = answer[index];
        for (int i = index+1 ; i < answer.length ;i++){
            if (ch==answer[i]) count++;
            else if (ch!=answer[i]) break;
        }
        return count;
    }
    public static void convert(int index, int length){
        for (int i = index ; i < index+length ;i++){
            answer[i] = '0';
        }
    }
}
