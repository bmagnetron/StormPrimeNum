package com.storm.junit;

import javax.inject.*;

public class Index {

    @Inject
    Provider<Boundary> boundary;

    public String getMessage() {
        return boundary.get().message();
    }

}