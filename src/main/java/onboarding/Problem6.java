package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Problem6 {

    private static final int TWO = 2;

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> nicknameToTwoLetter = new HashMap();
        Map<String, String> nicknameToEmail = new HashMap<>();
        List<String> answer = new ArrayList<>();

        forms.forEach(man -> {
            String email = man.get(0);
            String nickname = man.get(1);
            List<String> twoLetters = computeTwoLetters(nickname);

            nicknameToTwoLetter.put(nickname, twoLetters);
            nicknameToEmail.put(nickname, email);
        });

        //
        //        forms.forEach(man -> {
        //            String nickname = man.get(1);
        //            List<String> twoLetters = computeTwoLetters(nickname);
        //
        //            nicknameTwoLetter.put(nickname, twoLetters);
        //            nicknameToEmail.put(nickname, man.get(0));
        //        });
        //
        //        IntStream.range(0, forms.size())
        //            .map(i -> forms.size() - i - 1)
        //            .forEach(i -> {
        //                String email = forms.get(i)
        //                    .get(0);
        //                String nickname = forms.get(i)
        //                    .get(1);
        //                System.out.println("email : " + email);
        //                System.out.println("nickname : " + nickname);
        //
        //                forms.remove(i);
        //                List<String> nicknames = nicknameTwoLetter.get(nickname)
        //                    .stream()
        //                    .filter(twoLetter -> forms.stream()
        //                        .filter(form -> nicknameTwoLetter.get(form.get(1))
        //                            .contains(twoLetter))
        //                        .count() != 0)
        //                    .collect(Collectors.toList());
        //                if (nicknames.isEmpty()) {
        //                    return ;
        //                }
        //                answer.add(email);
        //                nicknames.stream().map(name -> nicknameToEmail.get(name)).forEach(em -> answer.add(em));
        //            });
        return answer;
    }

    private static List<String> computeTwoLetters(String input) {
        List<String> twoLetter = new ArrayList<>();

        IntStream.range(0, input.length() - TWO)
            .forEach(i -> twoLetter.add(input.substring(i, i + TWO)));
        return twoLetter;
    }
}
