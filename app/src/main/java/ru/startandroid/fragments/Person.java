package ru.startandroid.fragments;

import java.util.Random;


class Person {

    private static final String cont_NUMBER = "1234567890";
    private static final String cont_SYMBOL = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
    private String contacts;
    private String phone_number;
    private int photo;

    Person(int image, int var) {
        int length = var;
        contacts = this.RandomString(cont_SYMBOL, length);
        phone_number = this.RandomString(cont_NUMBER, length);
        photo = image;
    }

    private String RandomString(String symbol, int v) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < v; i++) {
            int number = new Random().nextInt(symbol.length());
            char ch = symbol.charAt(number);
            builder.append(ch);
        }
        return builder.toString();
    }

    String getContacts() {
        return this.contacts;
    }

    String getPhone_Number() {
        return this.phone_number;
    }

    int getPhoto() {
        return this.photo;
    }
}
