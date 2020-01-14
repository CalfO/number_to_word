package fr.sma.numbertowords.words;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class NumberWords {
    public static Map<String, String> singleDigitsByLanguage;

    public static final Map<Character, String> DIGITS = Map.of('0', "zero", '1', "one",
            '2', "two", '3', "tree", '4' , "four", '5', "five", '6', "six",
            '7', "seven", '8', "height", '9', "nine");

    public static final Map<String, String> SPECIAL_NUMBERS = Map.of("10", "ten", "11", "eleven",
            "12", "twelve", "13", "thirteen", "14", "fourteen", "15", "fifteen",
            "16", "sixteen", "17", "seventeen", "18", "eighteen", "19", "nineteen");

    public static final Map<String, String> TENS = Map.of("20", "twenty", "30", "thirty",
            "40", "forty", "50", "fifty", "60", "sixty", "70", "seventy",
            "80", "eighty", "90", "ninety");

    public static final Map<String, String> HIGH_NUMBERS = Map.of("100","hundred", "1000", "thousand");

}
