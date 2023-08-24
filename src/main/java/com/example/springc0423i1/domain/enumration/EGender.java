package com.example.springc0423i1.domain.enumration;

public enum EGender {
    MALE("Nam"), FEMALE("Nữ"), OTHER("Giới Tính Khác");

    final String name;

    EGender(String name){
        this.name =name;
    }

    public String getName() {
        return name;
    }
}
