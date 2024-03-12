package com.coskun.methods;

public class WebGameInput implements GameInput{
    @Override
    public int nextInt() {
        // return http.readRequest();
        return 0;
    }

    @Override
    public String nextLine() {
        // http.readStringRequest();
        return null;
    }
}
