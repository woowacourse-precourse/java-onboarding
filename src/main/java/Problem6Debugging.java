import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Problem6Debugging {

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

            int formsFirstRowLength = forms.toArray().length;
            int formsFirstRowNumber = formsFirstRowLength - 1; //열에 맞는 번호를 위해 미리 길이에서 1을 빼줌

            String nickName ="";
            String emailAddress ="";

            HashMap<String, String> hashMapCheckOverlap = new HashMap<String, String>(190000);
            HashMap<String, String> hashMapCollectOverlapEmail = new HashMap<String, String>(10000);



            while(formsFirstRowLength > 0){
                emailAddress = forms.get(formsFirstRowNumber).get(0);
                nickName = forms.get(formsFirstRowNumber).get(1);
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

        List<String> answer = List.of(hashMapCollectOverlapEmail.keySet().toArray(new String[hashMapCollectOverlapEmail.size()]));
        answer.sort(Comparator.naturalOrder());
    }
}
