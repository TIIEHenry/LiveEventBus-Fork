package com.jeremyliao.liveeventbus.core;

import com.jeremyliao.liveeventbus.LiveEventBus;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class LiveEventAction<T> {
    public static Set<String> allIds = new ConcurrentSkipListSet<>();
    public final String id;

    public LiveEventAction(String id) {
        if (!allIds.add(id)) {
            throw new IllegalStateException("duplicated id:" + id);
        }
        this.id = id;
    }

    public LiveEventAction() {
        this.id = getClass().getName();
    }

    public Observable<T> get() {
        return LiveEventBus.get(id);
    }
}
