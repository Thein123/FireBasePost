package com.globaldroid.app.myfirebase;

import android.app.job.JobParameters;
import android.util.Log;

/**
 * Created by User on 2/22/2018.
 */

public class JobService JobService {

    private static final String TAG = "MyJobService";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "Performing long running task in scheduled job");
        // TODO(developer): add long running task here.
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

}
