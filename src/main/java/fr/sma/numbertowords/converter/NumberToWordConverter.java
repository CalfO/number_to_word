package fr.sma.numbertowords.converter;

import fr.sma.numbertowords.domain.convertion.SentenceBuilder;
import fr.sma.numbertowords.exception.NumberToWordsExceptions;
import fr.sma.numbertowords.words.NumberWords;
import org.springframework.stereotype.Service;

@Service
public class NumberToWordConverter {

    public String convert(String number) throws NumberToWordsExceptions.InvalidInputNumber {
        char[] numberInChar = number.toCharArray();
        int dept = numberInChar.length;
        if (dept == 0) throw new NumberToWordsExceptions.InvalidInputNumber("Input number size invalid");
        if (dept > 4) throw new NumberToWordsExceptions.InvalidInputNumber("Input number > range max");

        if (dept == 1) { // 0 - 9
            return NumberWords.DIGITS.get(numberInChar[0]);
        }

        return buildWordFromNumber(numberInChar, dept);
    }

    private String buildWordFromNumber(char[] numberInChar, int dept) {
        SentenceBuilder sentenceBuilder = new SentenceBuilder();
        int x = 0;
        int tmpDept = dept;
        while (x < numberInChar.length) {
            if (tmpDept >= 3) { // First 2 digits
                tmpDept = manageFirstTwoDigits(numberInChar, sentenceBuilder, x, tmpDept);
            } else { // Last 2 digits
                manageLastTwoDigits(numberInChar, sentenceBuilder, x);
                break;
            }
            x++;
        }

        return sentenceBuilder.getBuilder().toString();
    }

    private void manageLastTwoDigits(char[] numberInChar, SentenceBuilder sentenceBuilder, int x) {
        if (numberInChar[x] == '0' && numberInChar[x + 1] == '0') { // 00
            return;
        } else if (numberInChar[x] == '1') { // 10 to 19
            String sum = Character.toString(numberInChar[x]) + numberInChar[x + 1];
            sentenceBuilder.append(NumberWords.SPECIAL_NUMBERS.get(sum));
        } else if (numberInChar[x] == '2' && numberInChar[x + 1] == '0') { // 20
            sentenceBuilder.append(NumberWords.TENS.get("20"));
        } else { // 21 to 99
            if (numberInChar[x + 1] == '0') {// silent zero
                sentenceBuilder.append(NumberWords.TENS.get(numberInChar[x] + "0"));
            } else {
                sentenceBuilder.append(NumberWords.TENS.get(numberInChar[x] + String.valueOf('0')));
                sentenceBuilder.append(NumberWords.DIGITS.get(numberInChar[x + 1]));
            }
        }
    }

    private int manageFirstTwoDigits(char[] numberInChar, SentenceBuilder sentenceBuilder, int x, int tmpDept) {
        if (numberInChar[x] != '0') { // Except silent zero
            sentenceBuilder.append(NumberWords.DIGITS.get(numberInChar[x]));
            sentenceBuilder.append(NumberWords.HIGH_NUMBERS.get("1" + "0".repeat(Math.max(0, tmpDept - 1))));
        }
        tmpDept--;
        return tmpDept;
    }
}
