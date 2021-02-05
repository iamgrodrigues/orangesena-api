package com.iamgrodrigues.orangesenaapi.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryUtils {

    public static String lotteryNumbers() {
        List<Integer> lotteryNumbers = IntStream.range(1, 61).boxed().collect(Collectors.toList());
        Collections.shuffle(lotteryNumbers);
        return lotteryNumbers.subList(0, 6).stream().sorted().map(number -> {
            String value = String.valueOf(number);
            if (number <= 9) {
                value = "0" + number;
            }
            return value;
        }).collect(Collectors.joining(" "));
    }
}