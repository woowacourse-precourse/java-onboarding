package onboarding.problem2;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import static java.lang.String.valueOf;


public class Repository {
    // 저장 기능
    public static LinkedList<String> save(String encode) {

        LinkedList<String> storedList = new LinkedList<>();

        int length = encode.length();
        for (int i=0; i<length; i++) {

            char collect = encode.charAt(i);
            char garbage = encode.charAt(i+1); // java.lang.StringIndexOutOfBoundsException: String index out of range: 15

            // 검사 기능(중복 아닐 때 실행)
            if (collect != garbage){    storedList.add(valueOf(collect));   }

        }
        return storedList;
        }
    }

