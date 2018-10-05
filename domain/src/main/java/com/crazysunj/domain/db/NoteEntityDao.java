package com.crazysunj.domain.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.crazysunj.domain.entity.note.NoteEntity.StringConverter;
import java.util.List;

import com.crazysunj.domain.entity.note.NoteEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "Note".
*/
public class NoteEntityDao extends AbstractDao<NoteEntity, Long> {

    public static final String TABLENAME = "Note";

    /**
     * Properties of entity NoteEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Images = new Property(1, String.class, "images", false, "IMAGES");
        public final static Property Text = new Property(2, String.class, "text", false, "TEXT");
        public final static Property IsCanDownload = new Property(3, boolean.class, "isCanDownload", false, "IS_CAN_DOWNLOAD");
        public final static Property Flag = new Property(4, Integer.class, "flag", false, "FLAG");
    }

    private final StringConverter imagesConverter = new StringConverter();

    public NoteEntityDao(DaoConfig config) {
        super(config);
    }
    
    public NoteEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"Note\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"IMAGES\" TEXT," + // 1: images
                "\"TEXT\" TEXT NOT NULL ," + // 2: text
                "\"IS_CAN_DOWNLOAD\" INTEGER NOT NULL ," + // 3: isCanDownload
                "\"FLAG\" INTEGER);"); // 4: flag
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Note\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, NoteEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        List images = entity.getImages();
        if (images != null) {
            stmt.bindString(2, imagesConverter.convertToDatabaseValue(images));
        }
        stmt.bindString(3, entity.getText());
        stmt.bindLong(4, entity.getIsCanDownload() ? 1L: 0L);
 
        Integer flag = entity.getFlag();
        if (flag != null) {
            stmt.bindLong(5, flag);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, NoteEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        List images = entity.getImages();
        if (images != null) {
            stmt.bindString(2, imagesConverter.convertToDatabaseValue(images));
        }
        stmt.bindString(3, entity.getText());
        stmt.bindLong(4, entity.getIsCanDownload() ? 1L: 0L);
 
        Integer flag = entity.getFlag();
        if (flag != null) {
            stmt.bindLong(5, flag);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public NoteEntity readEntity(Cursor cursor, int offset) {
        NoteEntity entity = new NoteEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : imagesConverter.convertToEntityProperty(cursor.getString(offset + 1)), // images
            cursor.getString(offset + 2), // text
            cursor.getShort(offset + 3) != 0, // isCanDownload
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4) // flag
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, NoteEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setImages(cursor.isNull(offset + 1) ? null : imagesConverter.convertToEntityProperty(cursor.getString(offset + 1)));
        entity.setText(cursor.getString(offset + 2));
        entity.setIsCanDownload(cursor.getShort(offset + 3) != 0);
        entity.setFlag(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(NoteEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(NoteEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(NoteEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
