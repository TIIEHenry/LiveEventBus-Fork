package com.jeremyliao.liveeventbus.core;

import com.jeremyliao.liveeventbus.LiveEventBus;

public class LiveEventAction<T> {
    public final String id;

    public LiveEventAction(String id) {
        this.id = id;
    }

    public LiveEventAction() {
        this.id = getClass().getName();
    }

    public Observable<T> get() {
        return LiveEventBus.get(id);
    }
}
