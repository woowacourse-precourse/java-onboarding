package onboarding;

import java.util.*;

public class test {
    public static void main(String[] args) {
        String word = "I LOVE you";

        // 65~90 , 97 ~122 , 32
        // 65 90 / 66 89 / ... 77 78 / 78 77 / ..
        // 155 / 219

        Map map = new HashMap();
        map.put(32, 32);
        for (int i = 65; i < 91; i++) {
            map.put(i, 155 - i);
        }
        for (int j = 97; j < 123; j++) {
            map.put(j, 219 - j);
        }

        String newword = "";
        for (int a = 0; a < word.length(); a++) {
            int newcharint  = (int)map.get((int)word.charAt(a));
            newword += (char) newcharint;
        }

        System.out.println(newword);



        /*Set set = new HashSet();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));


            System.out.println("바꿀 문자 : " + word.charAt(i));
            if (word.charAt(i) < 91 && word.charAt(i) != 32) {
              word = word.replace(word.charAt(i), (char)(155 - word.charAt(i)));
                System.out.println("대문자 바꾼후 : "+word);
            }

            if (word.charAt(i) > 96 && word.charAt(i) != 32) {
                System.out.println("기존" + word.charAt(i));
                System.out.println("변화" + (char)(219 - word.charAt(i)) );

//                word = word.replace(word.charAt(i), (char)(219 - word.charAt(i)));
               word = word.replaceFirst(String.valueOf(word.charAt(i)),String.valueOf((char) (219 - word.charAt(i))));
                System.out.println(word);
            }
        }
        System.out.println("최종 : " + word);

*/





    }
}
