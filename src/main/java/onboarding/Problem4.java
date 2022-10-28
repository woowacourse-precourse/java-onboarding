/*
1, 대문자, 소문자 유무를 판단한다.
2, 아스키 코드의 차를 이용한 대칭성 조건을 만들어준다. array의 아스키코드 = Z-'A'
3, 출력한다. 

*/
package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    // public static boolean Lowcase(String word){
    //     for(int i = 0; i < answer.length();i++){
    //         if('A' <= answer.charAt(i) && answer.charAt(i) <= 'Z'){
    //     return false;
    // }
    public static void main(String[] args){
        String answer = "I LOVE YOU";
        // char[] answer_arry = answer.toCharArray();
        for(int i = 0; i < answer.length();i++){
            if('A' <= answer.charAt(i) && answer.charAt(i) <= 'Z'){
                int temp = 'A' + ('Z' - answer.charAt(i));
                System.out.print((char)temp);
            }
            else{
                System.out.print(answer.charAt(i));
            }
        }
    }
}
