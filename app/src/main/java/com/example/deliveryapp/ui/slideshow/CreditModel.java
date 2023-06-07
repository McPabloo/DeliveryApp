package com.example.deliveryapp.ui.slideshow;

public class CreditModel {
    private String card;
    private String cvv;
    private String date;

    public CreditModel() {
    }

    public CreditModel(String card, String cvv, String date) {
        this.card = card;
        this.cvv = cvv;
        this.date = date;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
