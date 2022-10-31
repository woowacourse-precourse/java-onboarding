package onboarding;

public class Problem4 {
    public static String solution(String word) {
        //입력으로 들어오는 String을 char[]로 변환
        char[] list = word.toCharArray();

        for(int i=0; i<list.length; i++){
            //char배열의 원소를 모두 확인하면서 원소가 알파벳일 경우만 수정
            if(Character.isAlphabetic(list[i])){
                if(Character.isUpperCase(list[i])){
                    char temp = (char)('Z' - (list[i] - 'A'));
                    list[i] = temp;
                }
                else{
                    char temp = (char)('z' - (list[i] - 'a'));
                    list[i] = temp;
                }
            }
        }

        String answer = "";
        for(char c : list)
            answer += c;

        return answer;
    }
}
