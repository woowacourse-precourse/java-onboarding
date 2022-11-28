package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static final int EMAIL_INDEX = 0;
    public static final int NICKNAME_INDEX = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> duplicatedEmails = new ArrayList<>();

        for (List<String> form : forms) {

            String myNickName = form.get(NICKNAME_INDEX);
            String myEmail = form.get(EMAIL_INDEX);
            System.out.println("나의 닉네임: " + myNickName);

            List<String> nickNamesOfOtherPeople = forms.stream()
                    .filter(element -> element != form)
                    .map(element -> element.get(NICKNAME_INDEX))
                    .collect(Collectors.toList());
            System.out.println("다른 사람들 닉네임: " + nickNamesOfOtherPeople);

            HashSet<String> duplicateTestElement = new HashSet<>();
            for (String nickName : nickNamesOfOtherPeople) {
                for (int index = 0; index < nickName.length() - 1; index++) {
                    duplicateTestElement.add(nickName.substring(index, index + 2));
                }
            }
            System.out.println("중복 테스트용: " + duplicateTestElement + ", 길이: " + duplicateTestElement.size());

            int sizeBefore = duplicateTestElement.size();

            for (int index = 0; index < myNickName.length() - 1; index++) {
                duplicateTestElement.add(myNickName.substring(index, index + 2));

            }
            int sizeAfter = duplicateTestElement.size();

            System.out.println("내가 들어온 후: " + duplicateTestElement + ", 길이: " + duplicateTestElement.size());

            int normalGap = myNickName.length() - 1;
            if (sizeBefore + normalGap > sizeAfter) {
                System.out.println(myNickName + " 중복 발생");
                duplicatedEmails.add(myEmail);
            }
        }

        return duplicatedEmails.stream().sorted().collect(Collectors.toList());
    }

}
