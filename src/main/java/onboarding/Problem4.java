package onboarding;

public class Problem4 {
    public static String solution(String word) {
        //글자 저장할 stringBuilder
        StringBuilder sb = new StringBuilder();
        //char배열에 한글자씩 넣는 기능
        char[] arr = word.toCharArray();

        //글자수 길이만큼 반복해서 한글자씩 비교하는 기능
        for(int i = 0 ; i < arr.length ; i++) {
            //글자를 아스키코드 int형으로 변환
            int num = (int)arr[i];

        }

        String answer = sb.toString();
        return answer;
    }

}
