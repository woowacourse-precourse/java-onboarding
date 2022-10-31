package onboarding;

import java.util.*;


public class Problem6 {
    public static List<String> solution(List<List<String>> stList) {
        List<String>emailList = new ArrayList<>();
        String nick1, nick2;
        String cmpStr;
        List<String> temp1, temp2;
        boolean bool = false;

        for(int i=0;i<stList.size();i++){
            temp1 = stList.get(i);
            nick1 = temp1.get(1);
            for(int j=0;j<nick1.length()-1;j++){
                cmpStr = nick1.substring(j,j+2);


                for(int k=0;k<stList.size();k++){
                    if(k == i)
                        continue;

                    temp2 = stList.get(k);
                    nick2 = temp2.get(1);

                    if(nick2.contains(cmpStr)){ //중복포함한다면,
                        for(int l=0;l<emailList.size();l++){
                            bool = false;
                            if(emailList.get(l).equals(temp2.get(0))) {
                                bool = true;
                                break;
                            }
                        }
                        if(!bool){
                            emailList.add(temp2.get(0));
                        }
                    }
                }
            }
        }


        Collections.sort(emailList);

        return emailList;
    }
}
