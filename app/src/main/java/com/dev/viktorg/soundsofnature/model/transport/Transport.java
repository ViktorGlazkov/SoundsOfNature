package com.dev.viktorg.soundsofnature.model.transport;

import android.content.Context;

import com.dev.viktorg.soundsofnature.model.entity.Entity;

public class Transport extends Entity {
    public Transport(Context current, Transports transport) {
        super(current, transport.name());
    }
}
