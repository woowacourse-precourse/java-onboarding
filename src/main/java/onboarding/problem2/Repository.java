package onboarding.problem2;

import java.util.LinkedList;

import static java.lang.String.valueOf;
import static onboarding.problem2.Returner.returnLinkedList;


public abstract class Repository{

    // 저장 기능
     public static LinkedList<String> stored(String cryptogram){

         LinkedList<String> stringLinkedList = new LinkedList<String>();

        for (String str : stringLinkedList) {
            stringLinkedList.add(str);
        }

        return stringLinkedList;
    }


}
