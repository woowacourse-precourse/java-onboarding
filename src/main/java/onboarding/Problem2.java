package onboarding;

import java.util.Objects;

public class Problem2 {

    public static void main(String[] args){
        String cryptogram = "browoanoommnaon";
        String result = "brown";
        solution(cryptogram);
    }
    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    public static String decrypt(String cryptogram) {
        StringBuilder newString = new StringBuilder();
        do {
            searchOverlap(cryptogram, newString);
            if (newString.length() == cryptogram.length()) break; // 중복된 단어를 제거할 필요가 없다는 뜻
            cryptogram = String.valueOf(newString);
            newString.delete(0,newString.length());
        } while (cryptogram.length() > 0);
        return cryptogram;
    }

    public static void searchOverlap(String cryptogram, StringBuilder newString) {
        String[] array = cryptogram.split("");
        int next;
        for(int i = 0; i < array.length; i++){
            next = searchIndex(i, cryptogram);
            if(next - i == 1){ // 중복되지 않는다면
                newString.append(cryptogram.charAt(i));
                continue;
            }
            i = next - 1; // 중복되었다면 중복된 마지막 index로 대입
        }
    }

    public static int searchIndex(int start, String crpytogram){
        char letter = crpytogram.charAt(start);
        for(int i = start + 1; i < crpytogram.length(); i++){
            if(letter != crpytogram.charAt(i)) return i;
        }
        return crpytogram.length();
    }
}
