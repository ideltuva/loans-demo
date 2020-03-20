package swe.api.loans.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Preparators {

    private static final List<String> VALUES = Arrays.asList(
            "S11111",
            "S11112",
            "S11113",
            "S11114"
    );

    public static String pickPreparator() {
        Random random = new Random();
        int index = random.nextInt(VALUES.size());
        return VALUES.get(index);
    }

    private Preparators() {

    }




}
