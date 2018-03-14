package zonsim.tangjunwei.network.scheduler;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Provides different types of schedulers.
 */
public class SchedulerProvider implements ISchedulerProvider {
    
    
    @Inject
    public SchedulerProvider() {
    }
    
    
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
