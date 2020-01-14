package fr.sma.numbertowords.validator;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class NumberValidator {

    public void validate(String number) {
        Assert.isTrue(canBeCastInDouble(number), "Please enter a valid number");
        double numberDouble = Double.parseDouble(number);
        Assert.isTrue(canBeCastInInt(numberDouble), "This function did not work with this numbers, too high or with virgules");
        Assert.isTrue(numberDouble > 0, "Number to translate should be positive");
        Assert.isTrue(numberDouble < 1000, "This function work only for number lower than 1000, pay someone to do the job for amount bigger");
    }

    private boolean canBeCastInDouble(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean canBeCastInInt(double number) {
        try {
            int test = (int) number;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
