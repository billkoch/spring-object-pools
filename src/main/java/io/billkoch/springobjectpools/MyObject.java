package io.billkoch.springobjectpools;

import java.time.LocalDateTime;

public class MyObject {

    private final LocalDateTime instantiationTimestamp;

    public MyObject(LocalDateTime instantiationTimestamp) {
        this.instantiationTimestamp = instantiationTimestamp;
    }

    public LocalDateTime getInstantiationTimestamp() {
        return instantiationTimestamp;
    }
}
