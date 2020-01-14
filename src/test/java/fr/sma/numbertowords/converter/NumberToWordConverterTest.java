package fr.sma.numbertowords.converter;


import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import fr.sma.numbertowords.exception.NumberToWordsExceptions;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(DataProviderRunner.class)
public class NumberToWordConverterTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    private NumberToWordConverter numberToWordConverter = new NumberToWordConverter();

    @Test
    public void test_convert_with_zero() throws NumberToWordsExceptions.InvalidInputNumber {
        // WHEN
        String words = numberToWordConverter.convert("0");
        // THEN
        assertThat(words.toLowerCase()).isEqualTo("zero");
    }

    @Test
    @UseDataProvider("randomNumbers")
    public void test_convert(String input, String expectedOutput) throws NumberToWordsExceptions.InvalidInputNumber {
        assertThat(numberToWordConverter.convert(input)).isEqualTo(expectedOutput);
    }

    @Test
    public void test_convert_expect_InvalidInputNumberException_outOfRangeCustom() throws NumberToWordsExceptions.InvalidInputNumber {
        exceptionRule.expectMessage("Input number > range max");
        exceptionRule.expect(NumberToWordsExceptions.InvalidInputNumber.class);
        numberToWordConverter.convert("19840");
    }

    @Test
    public void test_convert_expect_InvalidInputNumberException_sizeAtZero() throws NumberToWordsExceptions.InvalidInputNumber {
        exceptionRule.expectMessage("Input number size invalid");
        exceptionRule.expect(NumberToWordsExceptions.InvalidInputNumber.class);
        numberToWordConverter.convert("");
    }

    @DataProvider
    public static Object[][] randomNumbers() {
        return new Object[][]{
                {"1", "one"},
                {"5", "five"},
                {"8", "height"},
                {"12", "twelve"},
                {"10", "ten"},
                {"20", "twenty"},
                {"64", "sixty four"},
                {"70", "seventy"},
                {"90", "ninety"},
                {"99", "ninety nine"},
                {"100", "one hundred"},
                {"124", "one hundred twenty four"},
                {"120", "one hundred twenty"},
                {"154", "one hundred fifty four"},
                {"167", "one hundred sixty seven"},
                {"186", "one hundred eighty six"},
                {"199", "one hundred ninety nine"},
                {"1000", "one thousand"},
                {"1593", "one thousand five hundred ninety tree"},
                {"2100", "two thousand one hundred"},
                {"4218", "four thousand two hundred eighteen"},
                {"5080", "five thousand eighty"},
                {"7650", "seven thousand six hundred fifty"},
                {"8453", "height thousand four hundred fifty tree"},
                {"9999", "nine thousand nine hundred ninety nine"}
        };
    }
}