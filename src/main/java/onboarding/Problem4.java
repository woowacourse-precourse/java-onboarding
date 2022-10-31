package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    public static char Reverse(char c){
        int up = 155;
        int low = 219;
        int temp = c;
        if(temp >= 65 && temp <= 90){
            return (char)(up-temp);
        }
        return (char)(low-temp);
    }
    // char받아 반대로 출력하는 함수
    public static void main(String[] args){
        System.out.println(Reverse('A'));
        System.out.println(Reverse('a'));
    }
}
