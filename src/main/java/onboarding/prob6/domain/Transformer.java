package onboarding.prob6.domain;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    private Transformer() {
    }

    public static List<List<String>> encodeDecodLists(List<List<String>> forms) {
        List<List<String>> processed = new ArrayList<>(new ArrayList<>());
        for (List<String> form : forms) {
            processed.add(List.of(form.get(0), Decoder.decode(Encoder.encode(form.get(1)))));
        }
        return processed;
    }
}
