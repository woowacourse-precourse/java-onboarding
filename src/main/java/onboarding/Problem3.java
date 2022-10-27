package onboarding;

public class Problem3 {
    static int countNumber(String n, char ch1, char ch2, char ch3){
        int count = 0;
        for(int i=0; i<n.length(); i++){
            if(n.charAt(i) ==ch1 || n.charAt(i) ==ch2 || n.charAt(i) ==ch3){
                count +=1;
            }
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;

        return answer;
    }
}
