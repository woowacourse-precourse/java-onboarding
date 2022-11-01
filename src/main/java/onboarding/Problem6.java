package onboarding;


import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return restrictedID(forms);
    }

    static List<String> restrictedID(List<List<String>> forms){
        Set<String> Email=new HashSet<>();
        Map<String,String> duplicatedWord = new HashMap<>();
        for(List<String>applicant : forms){
            for(int i=0; i<applicant.get(1).length()-1; i++){
                String includedWord=""+applicant.get(1).charAt(i)+applicant.get(1).charAt(i+1);
                if(duplicatedWord.containsKey(includedWord)){
                    Email.add(duplicatedWord.get(includedWord));
                    Email.add(applicant.get(0));
                }
                else{
                    duplicatedWord.put(includedWord,applicant.get(0));
                }
            }
        }
        List<String> applicantEmail=new ArrayList<>(Email);
        Collections.sort(applicantEmail);
        return applicantEmail;
    }
}
