package com.sabghat.colorpicker;

public class ModelClass {
    private final String question;
    private final int option1;
    private final int option2;
    private final int option3;
    private final int option4;
    private final int answer;

    public ModelClass(String question, int option1, int option2, int option3, int option4, int answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public int getOption1() {
        return option1;
    }

    public int getOption2() {
        return option2;
    }

    public int getOption3() {
        return option3;
    }

    public int getOption4() {
        return option4;
    }

    public int getAnswer() {
        return answer;
    }

}
