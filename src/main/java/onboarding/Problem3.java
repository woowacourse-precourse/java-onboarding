package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = reClap(number);

        return answer;
    }
    public static int reClap(int num){
        int count = 0;
        for(int i=1;i<=num;i++){
            count += count369(i);
        }
        return count;
    }
    public static int count369(int num){
        int count =0;
        String s = Integer.toString(num);
        for(int i=0;i<s.length();i++){
            if(check369(s.charAt(i))){
                count++;
            }
        }
        return count;
    }
    public static boolean check369(char c){
        if(c =='3' ||c =='6'|| c=='9'){
            return true;
        }
        return false;
    }
}
