package fr.sma.numbertowords.exception;

public class NumberToWordsException extends Exception {
    private final String message;

    NumberToWordsException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
