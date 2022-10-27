package onboarding;

public class Problem2 {

    static int count = 0;

    public static String solution(String cryptogram) {
        return decrypt(cryptogram, "");
    }

    private static String decrypt(String cryptogram, String replaced) {
        if (cryptogram.equals(replaced)) {
            return replaced;
        }

        String[] arr = cryptogram.split("");

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(arr[i - 1])) {
                arr[i] = "*";
                arr[i - 1] = "*";
            }
        }

        // 문자열 변환
        String new_replaced = String.join("", arr);
        // 중복마크 제거
        new_replaced = new_replaced.replace("*", "");

        return decrypt(new_replaced, cryptogram);
    }
}
