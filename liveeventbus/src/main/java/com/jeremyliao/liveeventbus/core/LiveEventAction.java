package com.jeremyliao.liveeventbus.core;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.jeremyliao.liveeventbus.LiveEventBus;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class LiveEventAction<T> implements Observable<T> {
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

    @Override
    public void post(T value) {
        get().post(value);
    }

    @Override
    public void postAcrossProcess(T value) {
        get().postAcrossProcess(value);
    }

    @Override
    public void postAcrossApp(T value) {
        get().postAcrossApp(value);
    }

    @Override
    public void postDelay(T value, long delay) {
        get().postDelay(value, delay);
    }

    @Override
    public void postDelay(LifecycleOwner sender, T value, long delay) {
        get().postDelay(sender, value, delay);
    }

    @Override
    public void postOrderly(T value) {
        get().postOrderly(value);
    }

    @Override
    public void broadcast(T value) {
        get().broadcast(value);
    }

    @Override
    public void broadcast(T value, boolean foreground, boolean onlyInApp) {
        get().broadcast(value, foreground, onlyInApp);
    }

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<T> observer) {
        get().observe(owner, observer);
    }

    @Override
    public void observeSticky(@NonNull LifecycleOwner owner, @NonNull Observer<T> observer) {
        get().observeSticky(owner, observer);
    }

    @Override
    public void observeForever(@NonNull Observer<T> observer) {
        get().observeForever(observer);
    }

    @Override
    public void observeStickyForever(@NonNull Observer<T> observer) {
        get().observeStickyForever(observer);
    }

    @Override
    public void removeObserver(@NonNull Observer<T> observer) {
        get().removeObserver(observer);
    }
}
