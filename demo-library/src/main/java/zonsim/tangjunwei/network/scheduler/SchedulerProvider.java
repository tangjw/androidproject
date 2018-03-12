package zonsim.tangjunwei.network.scheduler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Provides different types of schedulers.
 */
public class SchedulerProvider implements ISchedulerProvider {
    
   /* @Nullable
    private static SchedulerProvider INSTANCE;*/
    
    @Inject
    public SchedulerProvider() {
    }
    
    /* public static synchronized SchedulerProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SchedulerProvider();
        }
        return INSTANCE;
    }*/
    
    @Override
    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }
    
    @Override
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }
    
    @Override
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
