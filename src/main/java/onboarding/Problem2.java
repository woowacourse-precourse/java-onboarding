package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String str = cryptogram;

        int count = 1;
        while(count>0){

            str = changeLetter(str);
            count -= 1;

            // todo : 연속해서 중복되는 부분이 있는 지 확인하는 반복문
            for(int i = 0; i<str.length(); i++){
                for(int j = i+1; j<str.length(); j++){

                    if(str.charAt(i) == str.charAt(j) && j+j-i < str.length()){
                        if(str.substring(i,j).equals(str.substring(j,j+j-i)) ) {
                            count +=1;
                        }
                    }

                }
            }
        }

        return str;
    }

    public static String changeLetter(String name){


        List<String> list = new ArrayList<>();

        for(int i = 0; i<name.length(); i++){
            list.add(name.substring(i,i+1));
        }


        for(int i = 0; i<list.size()-1; i++){
            for(int j = i+1; j<list.size(); j++){
                int num = j-i;
                if(list.get(i).equals(list.get(j)) && j+num-1 <list.size()){
                    boolean isChecked = true;
                    for(int z = 0; z<num; z++){
                        if(!list.get(i+z).equals(list.get(j+z))){
                            isChecked = false;
                        }
                        if(!isChecked){
                            break;
                        }
                    }
                    if(isChecked){
                        for(int y = 0; y<num*2; y++){
                            list.remove(i);

                        }
                        i-=num*2;
                        break;
                    }

                }
            }
        }
        return String.join("",list);
    }

    public static void main(String[] args) {
        String str = new String("oooommmcccmcbbbbbab");
        System.out.println(solution(str));

    }
}
