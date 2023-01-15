package com.example.kidslearningapp;

public class ResultModel {
    private String question;
    private int optiona;
    private int optionb;
    private int optionc;
    private int optionSelected;
    private int result;

    public ResultModel(String question, int optiona, int optionb, int optionc, int optionSelected, int result) {
        this.question = question;
        this.optiona = optiona;
        this.optionb = optionb;
        this.optionc = optionc;
        this.optionSelected = optionSelected;
        this.result = result;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getOptiona() {
        return optiona;
    }

    public void setOptiona(int optiona) {
        this.optiona = optiona;
    }

    public int getOptionb() {
        return optionb;
    }

    public void setOptionb(int optionb) {
        this.optionb = optionb;
    }

    public int getOptionc() {
        return optionc;
    }

    public void setOptionc(int optionc) {
        this.optionc = optionc;
    }

    public int getOptionSelected() {
        return optionSelected;
    }

    public void setOptionSelected(int optionSelected) {
        this.optionSelected = optionSelected;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "question='" + question + '\'' +
                ", optiona=" + optiona +
                ", optionb=" + optionb +
                ", optionc=" + optionc +
                ", optionSelected=" + optionSelected +
                ", result=" + result +
                '}';
    }
}
