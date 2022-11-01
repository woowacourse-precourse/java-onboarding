package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] array = word.toCharArray();
        for (int i=0;i<array.length;i++) {
            if(array[i]!=' ') {
                if(array[i] >= 'a')
                    array[i] = (char) ('z'+'a' - array[i]);
                else
                    array[i] = (char) ('Z'+'A' - array[i]);
            }
        }

        System.out.println(array);
        return String.valueOf(array);
    }
}
