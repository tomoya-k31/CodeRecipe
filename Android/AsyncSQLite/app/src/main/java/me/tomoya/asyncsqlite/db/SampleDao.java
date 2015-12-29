package me.tomoya.asyncsqlite.db;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import me.tomoya.asyncsqlite.db.model.Sample;

import java.util.List;

/**
 * Created by usr0200379 on 2014/06/03.
 */
public class SampleDao {

    private static SampleDao instance;
    private SampleDao() {}

    public static synchronized SampleDao getInstance() {
        if (instance == null) {
            instance = new SampleDao();
        }
        return instance;
    }


    public int count(int status) {
        return new Select().from(Sample.class).where("status = ?", status).count();
    }

    public List<Sample> select(int status) {
        return new Select().from(Sample.class).where("status = ?", status).execute();
    }

    public int maxSeq() {
        Sample sample = new Select().from(Sample.class).orderBy("sequence desc").executeSingle();
        if (sample == null) return 0;
        return sample.sequence;
    }

    public void insert(Sample sample) {
        sample.save();
    }

    public void insert(List<Sample> sampleList) {
        ActiveAndroid.beginTransaction();
        try {
            for (Sample sample : sampleList) sample.save();
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

    public void update(Sample sample) {
        Sample _sample = new Select().from(Sample.class).where("sequence = ?", sample.sequence).executeSingle();
        if (_sample != null) {
            if (sample.name != null)   _sample.name   = sample.name;
            if (sample.status != null) _sample.status = sample.status;
            _sample.save();
        }
    }

    public void deleteBySeq(Sample sample) {
        new Delete().from(Sample.class).where("sequence = ?",sample.sequence).execute();
    }

    public void deleteByModel(Sample sample) {
        sample.delete();
    }

    public void deleteAll() {
        new Delete().from(Sample.class).execute();
    }
}
