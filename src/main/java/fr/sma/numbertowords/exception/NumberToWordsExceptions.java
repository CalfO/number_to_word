package fr.sma.numbertowords.exception;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberToWordsExceptions {
    public static class InvalidInputNumber extends NumberToWordsException {
        public InvalidInputNumber(String message) {
            super(message);
        }
    }
}
