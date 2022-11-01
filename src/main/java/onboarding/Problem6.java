package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //- 크루는 1명 이상 10,000명 이하이다.
        //- 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
        //- 신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
        //- 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.




        int formsFirstRowLength = forms.toArray().length;

        //예외사항 1
        if (formsFirstRowLength < 1 || formsFirstRowLength > 10000){
            System.out.println("Please, Enter number of member between 1 ~ 10000");
            return new ArrayList<>();
        }


        String nickName ="";
        String emailAddress ="";

        HashMap<String, String> hashMapCheckOverlap = new HashMap<String, String>();
        HashMap<String, String> hashMapCollectOverlapEmail = new HashMap<String, String>();



        while(formsFirstRowLength > 0){
            emailAddress = forms.get(formsFirstRowLength - 1).get(0);
            int emailAddressLength = emailAddress.length();
            //예외사항2,3
            if (emailAddressLength<11 || emailAddressLength>20){
                System.out.println("Please, Enter email address length between 11~20");
                return new ArrayList<>();
            } else if (emailAddress.substring(emailAddressLength-8,emailAddressLength+1) != "email.com"){
                System.out.println("Please, Enter email domain only 'email.com'");
                return new ArrayList<>();
            }

            nickName = forms.get(formsFirstRowLength - 1).get(1);
            int nickNameLength = nickName.length();

            for (int i = 0; i < nickNameLength - 1; i++){
                String twoWords = nickName.substring(i, i+2);

                if (hashMapCheckOverlap.containsKey(twoWords)){

                    hashMapCollectOverlapEmail.put(emailAddress,"");
                    hashMapCollectOverlapEmail.put(hashMapCheckOverlap.get(twoWords),"");
                    continue;

                }

                hashMapCheckOverlap.put(twoWords,emailAddress);

            }
            formsFirstRowLength -=1;


        }


        List<String> answer = new ArrayList(List.of(hashMapCollectOverlapEmail.keySet().toArray(new String[hashMapCollectOverlapEmail.size()])));
        answer.sort(Comparator.naturalOrder());


        return answer;
    }
}
