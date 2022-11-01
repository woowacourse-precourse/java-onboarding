package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = List.of("answer");

        if(!isValidSize(forms)){
            throw new InputMismatchException();
        }
        List<Set<String>> bigramList = getBigramList(forms);

        Set<String> emailSet = getDuplicatedNickNameSet(bigramList, forms);

        answer = new ArrayList<>(emailSet);
        answer.sort(String::compareTo);
        return answer;
    }

    private static List<Set<String>> getBigramList(List<List<String>> input){
        List<Set<String>> bigramList = new LinkedList<>();
        for(List<String> formPair: input){
            String email = formPair.get(0);
            String nickname = formPair.get(1);
            if(!isValidEmail(email) || !isValidNickname(nickname)){
                throw new InputMismatchException();
            }
            bigramList.add(getBigramofNickname(nickname));
        }
        return bigramList;
    }

    private static Set<String> getDuplicatedNickNameSet(List<Set<String>> bigramList, List<List<String>> forms){
        int j =0;
        Set<String> emailSet = new LinkedHashSet<>();
        for(Set<String> eachBigramList : bigramList){
            for(String bigram : eachBigramList){

                for(int k = 0; k<bigramList.size(); k++){
                    if(k == j)
                        continue;

                    if(bigramList.get(k).contains(bigram)){
                        String email = forms.get(j).get(0);
                        emailSet.add(email);
                        break;
                    }
                }
            }
            j++;
        }
        return emailSet;
    }

    private static boolean isValidSize(List<List<String>> input){
        if(input == null){
            return false;
        }
        return input.size() >= 1 && input.size() <= 10000;
    }

    private static boolean isValidEmail(String input){
        if(input == null){
            return false;
        }
        if(input.length() < 11 || input.length() >20){
            return false;
        }

        Matcher matcher = Pattern.compile("^([\\w\\D]+)@([a-z].+[a-z])$").matcher(input);
        String domain;
        if(!matcher.find()){
            return false;
        }
        domain = matcher.group(2);
        return domain.equals("email.com");
    }

    private static boolean isValidNickname(String input){
        if(input == null){
            return false;
        }
        if(input.length() < 1 || input.length() > 20){
            return false;
        }
        return Pattern.matches("^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$", input);
    }
    private static Set<String> getBigramofNickname(String input){
        Set<String> result = new HashSet<>();
        char[] inputCharArray = input.toCharArray();
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for(char c :inputCharArray){
            stringBuilder.append(c);
            if(i == 1){
                result.add(stringBuilder.toString());
                i = 0;
                stringBuilder.setLength(0);
                stringBuilder.append(c);
            }
            i++;
        }
        return result;
    }
}
