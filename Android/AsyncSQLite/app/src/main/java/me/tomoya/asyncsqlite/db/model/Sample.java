package me.tomoya.asyncsqlite.db.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by usr0200379 on 2014/06/03.
 */
@Table(name = "Sample") /* テーブル名:Sample */
public class Sample extends Model {

    @Column(name = "Name", length = 255, notNull = true)
    public String name;

    @Column(name = "Sequence", length = 10, notNull = true)
    public Integer sequence;

    @Column(name = "Status", length = 1, notNull = true)
    public Integer status;

    public Sample(){
        super();
    }

    public Sample(String name, Integer sequence, Integer status) {
        super();
        this.name = name;
        this.sequence = sequence;
        this.status = status;
    }



    public static final class STATUS {
        public static final int ON = 1;
        public static final int OFF = 0;
    }
}
