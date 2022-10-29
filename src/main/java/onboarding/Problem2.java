package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int cryptoLength = cryptogram.length();
        String answer = cryptogram;
        String removeCryptogram = cryptogram;

        for (int i = 0; i < cryptoLength; i++) {
            removeCryptogram = findDuplicate(answer);
            if (!answer.equals(removeCryptogram)) {
                answer = removeCryptogram;
                cryptoLength = answer.length();
                i = -1; // 첫 번째 문장부터 다시 검사하기 위한 초기화 끝나면 i++이 되기 때문에 i = -1이어야함
            }
        }

        return answer;
    }

    public static String findDuplicate(String cryptogram) {
        String[] splitCryptogram = cryptogram.split("");

        for (int i = 0; i < splitCryptogram.length - 1; i++) {
            if (splitCryptogram[i].equals(splitCryptogram[i + 1])) {
                splitCryptogram = removeDuplicate(splitCryptogram, i);
            }
        }

        return String.join("", splitCryptogram);
    }

    public static String[] removeDuplicate(String[] splitCryptogram, int index) {

        for (int i = index + 1; i < splitCryptogram.length; i++) {
            if (splitCryptogram[i].equals(splitCryptogram[index]) == false) {
                break;
            }
            splitCryptogram[i] = "";
        }

        splitCryptogram[index] = "";

        return splitCryptogram;
    }

}
