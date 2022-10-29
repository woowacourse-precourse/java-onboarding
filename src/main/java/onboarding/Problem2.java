package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (!cryptogram.equals("")) { // 만약 공백이라면 종료
            if(cryptogram.equals(test(cryptogram))) // 만약 제거 전과 후가 동일하다면 종료
                break;

            cryptogram = test(cryptogram);

        }
        return cryptogram;
    }

    public static String test(String cryman) { //입력받은 문자열을 배열로 바꾼 후 조건에 맞게 중복문자 제거
        String[] cry = cryman.split("");

        for (int i = 0; i < cry.length - 1; i++) {

            if (cry[i].equals(cry[i + 1])) {
                cry[i] = "";
                cry[i + 1] = "";
            }
        }
        return String.join("",cry);
    }
}
