package me.tomoya.asyncsqlite.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import me.tomoya.asyncsqlite.db.SampleDao;
import me.tomoya.asyncsqlite.db.model.Sample;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by usr0200379 on 2014/06/03.
 */
public class AsyncDBManager {

    private static ScheduledExecutorService executorService;
    static {
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    private AsyncDBManager() {}

    private static void addTaskQueue(Runnable task) {
        bootExecutorIfTerminated();
        executorService.schedule(task, 200, TimeUnit.MILLISECONDS);
    }

    public static void insert(final PackageManager packageManager) {
        final SampleDao dao = SampleDao.getInstance();
        addTaskQueue(new Runnable() {
            @Override
            public void run() {
                int seq = dao.maxSeq();
                dao.insert(new Sample("sample_" + (seq + 1), seq + 1, Sample.STATUS.ON));
                Log.v("", "Async Insert" + Thread.currentThread().getId());

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {}
                List<ApplicationInfo> applicationInfo = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
                for (ApplicationInfo info : applicationInfo) {
                    if ((info.flags & ApplicationInfo.FLAG_SYSTEM) == ApplicationInfo.FLAG_SYSTEM) continue;
//                    if (info.packageName.equals(this.getPackageName())) continue;
                    Log.v("", info.packageName);
                }
            }
        });
    }

    public static void delete() {
        final SampleDao dao = SampleDao.getInstance();
        List<Sample> sampleList = dao.select(Sample.STATUS.ON);
        for (final Sample sample : sampleList) {
            addTaskQueue(new Runnable() {
                @Override
                public void run() {
                    sample.delete();
                    Log.v("", "Async Delete" + Thread.currentThread().getId());

                    if (sample.sequence == 3) {
                        throw new RuntimeException();
                    }
                }
            });
        }
    }

    private static void bootExecutorIfTerminated() {
        if (executorService.isTerminated())
            executorService = Executors.newSingleThreadScheduledExecutor();
    }


    public static void exit() {
        try {
            executorService.shutdown();
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
