package fr.sma.numbertowords;

import fr.sma.numbertowords.converter.NumberToWordConverter;
import fr.sma.numbertowords.exception.NumberToWordsExceptions;
import fr.sma.numbertowords.validator.NumberValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainComponentTest {

    @Mock
    private NumberToWordConverter numberToWordConverter;
    @Mock
    private NumberValidator numberValidator;
    @InjectMocks
    private MainComponent mainComponent;

    @Test
    public void test_numberToWord() throws NumberToWordsExceptions.InvalidInputNumber {
        // WHEN
        mainComponent.numberToWord("1234");
        // THEN
        verify(numberToWordConverter, atLeastOnce()).convert("1234");
        verify(numberValidator, atLeastOnce()).validate("1234");
    }
}
