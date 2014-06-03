package me.tomoya.asyncsqlite.db;

import com.activeandroid.serializer.TypeSerializer;

import java.util.Date;

/**
 * Created by usr0200379 on 2014/06/03.
 */
public class UtilDateSerializer extends TypeSerializer {
    @Override
    public Class<?> getDeserializedType() {
        return Date.class;
    }

    @Override
    public Class<?> getSerializedType() {
        return Long.class;
    }

    @Override
    public Object serialize(Object o) {
        if (o == null) {
            return null;
        }

        return ((Date) o).getTime();
    }

    @Override
    public Object deserialize(Object o) {
        if (o == null) {
            return null;
        }

        return new Date((Long) o);
    }
}
