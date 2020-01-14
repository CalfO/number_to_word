package fr.sma.numbertowords.domain.convertion;

import lombok.Data;

@Data
public class SentenceBuilder {
    private StringBuilder builder;

    public SentenceBuilder() {
        this.builder = new StringBuilder();
    }

    public void append(String str) {
        if(builder.length() > 0) {
            this.builder.append(" ").append(str);
        } else {
            this.builder.append(str);
        }
    }
}
