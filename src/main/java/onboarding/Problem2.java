package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decryption(cryptogram);
        do {
            String decode = decryption(answer);
            if (answer.equals(decode)) {
                return decode;
            }
            answer = decode;
        }while (true);
    }

    private static String decryption(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = cryptogram.split("");
        int index = 0;
        while (index < split.length - 1) {
            String temp = split[index];
            if (temp.equals(split[index + 1])) {
                index = findLastSameCharIndex(split, temp, index) + 1; //마지막 중복문자열이 있는 인덱스를 반환
                continue;
            }
            stringBuilder.append(temp);
            index++;
        }
        if (index == split.length - 1) {
            stringBuilder.append(split[split.length - 1]);
        }
        return stringBuilder.toString();
    }

    private static int findLastSameCharIndex(String[] split, String key, int start) {
        int i = start;
        while (i < split.length - 1) {
            if (!key.equals(split[i + 1])) {
                break;
            }
            i++;
        }
        return i;
    }
}
