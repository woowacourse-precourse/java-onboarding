package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        System.out.println(answer);
        int i=0;
        while (findSameChar(cryptogram) > -1){
            //cryptogram = deleteSameChar(cryptogram);
            System.out.println(i);
            i++;
        }
        answer = cryptogram;
        return answer;
    }

    private static String deleteSameChar(String cryptogram) {

        int size = cryptogram.length();
        for (int i = 0; i < size - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                //System.out.println(cryptogram);
                return cryptogram;
            }
        }

        return cryptogram;
    }

    // 같은 문자열 있으면 true 없으면 false -> 자바는 객체에 대해 call-by-reference니까 객체값을 다른 메소드에서 바꿔도 ok
    public static int findSameChar(String cryptogram) {

        int size = cryptogram.length();
        System.out.println(size);
        for (int i = 0; i < size - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                //cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                //System.out.println(cryptogram);
                return i;
            }
        }
        return -1;
    }
}
