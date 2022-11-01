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

            //대소문자를 비교하여 각자 다른 메서드를 불러오는 기능
            if (num >= 65 && num <= 90) { //대문자일 경우
                sb.append(upperCase(num));
            } else if (num >= 97 && num <= 122) { //소문자일 경우
                sb.append(lowerCase(num));
            } else { //알파벳이 아닐경우(빈문자 등) 그대로 추가
                sb.append(arr[i]);
            }
        }

        String answer = sb.toString();
        return answer;
    }

    //대문자일 경우 변환 문자를 리턴하는 기능
    public static char upperCase(int num) {
        int distance = num - 65; //첫번호(A)와 해당문자 번호의 차이
        int back = 90 - distance; //대문자 끝번호에서 차이 빼기
        return (char)back;
    }

    //소문자일 경우 변환 문자를 리턴하는 기능
    public static char lowerCase(int num) {
        int distance = num - 97; //첫번호(a)와 해당문자 번호의 차이
        int back = 122 - distance; //소문자 끝번호에서 차이 빼기
        return (char)back;
    }

}
