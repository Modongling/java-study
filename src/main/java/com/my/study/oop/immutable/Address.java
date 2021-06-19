package com.my.study.oop.immutable;

import java.util.Objects;

/**
 * final域的不可变类
 */
public class Address {
    private final String detail;
    private final String postCode;

    public Address() {
        detail = "";
        postCode = "";
    }

    public Address(String detail, String postCode) {
        this.detail = detail;
        this.postCode = postCode;
    }

    public String getDetail() {
        return detail;
    }

    public String getPostCode() {
        return postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(detail, address.detail) && Objects.equals(postCode, address.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detail, postCode);
    }
}
