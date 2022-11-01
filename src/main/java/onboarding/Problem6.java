package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return trimList(duplicatedNickname(trimInvalidFormat(forms)));
    }

    private static boolean isValidEmail(String email){
        if(email.length() < 11 || email.length() > 19)
            return false;
        String[] emailArr = email.split("@");
        String emailDomain = emailArr[1];
        if(!emailDomain.equals("email.com"))
            return false;

        return true;
    }

    private static boolean isValidNickname(String nickname){
        if(nickname.length() == 0 || nickname.length() > 19)
            return false;
        for(int i=0; i<nickname.length(); i++)
            if(!nickname.substring(i, i+1).matches("[가-힣]+"))
                return false;

        return true;
    }

    private static List<List<String>> trimInvalidFormat(List<List<String>> forms){
        List<List<String>> validFormat = new ArrayList<>();
        for(List<String> crew: forms)
            if(isValidEmail(crew.get(0)) && isValidNickname(crew.get(1)))
                validFormat.add(crew);

        return validFormat;
    }

    private static List<String> duplicatedNickname(List<List<String>> forms){
        List<String> duplicatedEmail = new ArrayList<>();
        List<List<String>> formCopy = forms;
        List<Integer> isduplicatedIdx = new ArrayList<>();

        for(int i=0; i<formCopy.size(); i++){
            List<String> nowCrew = formCopy.get(i);
            String nowCrewEmail = nowCrew.get(0);
            String nowCrewNickname = nowCrew.get(1);

            if(isduplicatedIdx.contains(i))
                continue;

            boolean isDuplicated = false;
            for(int j=i+1; j<formCopy.size(); j++){
                List<String> nextCrew = formCopy.get(j);
                String nextCrewEmail = nextCrew.get(0);
                String nextCrewNickname = nextCrew.get(1);

                boolean isContain = false;
                for(int k=0; k<nowCrewNickname.length() - 1; k++){
                    if(isContain)
                        break;
                    if(nextCrewNickname.contains(nowCrewNickname.substring(k, k+2))){
                        isContain = true;
                        isDuplicated = true;
                        isduplicatedIdx.add(j);
                    }
                }
            }
            if(isDuplicated){
                isduplicatedIdx.add(i);
            }
        }

        for(int i=0; i<isduplicatedIdx.size(); i++)
            duplicatedEmail.add(formCopy.get(isduplicatedIdx.get(i)).get(0));

        return duplicatedEmail;
    }

    private static List<String> trimList(List<String> duplicatedEmail){
        List<String> listCopy = duplicatedEmail;
        listCopy = Lists.newArrayList(Sets.newHashSet(listCopy));
        Collections.sort(listCopy);

        return listCopy;
    }

}
