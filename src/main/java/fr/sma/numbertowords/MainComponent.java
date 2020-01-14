package fr.sma.numbertowords;

import fr.sma.numbertowords.converter.NumberToWordConverter;
import fr.sma.numbertowords.exception.NumberToWordsExceptions;
import fr.sma.numbertowords.validator.NumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MainComponent {

    @Autowired
    private NumberToWordConverter numberToWordConverter;

    @Autowired
    private NumberValidator numberValidator;

    @ShellMethod("Convert numbers into words equivalent's")
    public String numberToWord(@ShellOption(help = "Number to be converted into words") String number) throws NumberToWordsExceptions.InvalidInputNumber {
        numberValidator.validate(number);
        return numberToWordConverter.convert(number);
    }

}
