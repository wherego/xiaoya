package wanghaisheng.com.xiaoya.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import wanghaisheng.com.xiaoya.db.Group;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GROUP".
*/
public class GroupDao extends AbstractDao<Group, Long> {

    public static final String TABLENAME = "GROUP";

    /**
     * Properties of entity Group.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Count = new Property(1, Integer.class, "count", false, "COUNT");
        public final static Property Width = new Property(2, Integer.class, "width", false, "WIDTH");
        public final static Property Height = new Property(3, Integer.class, "height", false, "HEIGHT");
        public final static Property Order = new Property(4, Integer.class, "order", false, "ORDER");
        public final static Property Color = new Property(5, Integer.class, "color", false, "COLOR");
        public final static Property Groupid = new Property(6, String.class, "groupid", false, "GROUPID");
        public final static Property Date = new Property(7, String.class, "date", false, "DATE");
        public final static Property Imageurl = new Property(8, String.class, "imageurl", false, "IMAGEURL");
        public final static Property Url = new Property(9, String.class, "url", false, "URL");
        public final static Property Title = new Property(10, String.class, "title", false, "TITLE");
        public final static Property Type = new Property(11, String.class, "type", false, "TYPE");
        public final static Property ViewCount = new Property(12, Long.class, "viewCount", false, "VIEW_COUNT");
        public final static Property Iscollected = new Property(13, Boolean.class, "iscollected", false, "ISCOLLECTED");
    };


    public GroupDao(DaoConfig config) {
        super(config);
    }
    
    public GroupDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GROUP\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"COUNT\" INTEGER," + // 1: count
                "\"WIDTH\" INTEGER," + // 2: width
                "\"HEIGHT\" INTEGER," + // 3: height
                "\"ORDER\" INTEGER," + // 4: order
                "\"COLOR\" INTEGER," + // 5: color
                "\"GROUPID\" TEXT," + // 6: groupid
                "\"DATE\" TEXT," + // 7: date
                "\"IMAGEURL\" TEXT," + // 8: imageurl
                "\"URL\" TEXT," + // 9: url
                "\"TITLE\" TEXT," + // 10: title
                "\"TYPE\" TEXT," + // 11: type
                "\"VIEW_COUNT\" INTEGER," + // 12: viewCount
                "\"ISCOLLECTED\" INTEGER);"); // 13: iscollected
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GROUP\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Group entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer count = entity.getCount();
        if (count != null) {
            stmt.bindLong(2, count);
        }
 
        Integer width = entity.getWidth();
        if (width != null) {
            stmt.bindLong(3, width);
        }
 
        Integer height = entity.getHeight();
        if (height != null) {
            stmt.bindLong(4, height);
        }
 
        Integer order = entity.getOrder();
        if (order != null) {
            stmt.bindLong(5, order);
        }
 
        Integer color = entity.getColor();
        if (color != null) {
            stmt.bindLong(6, color);
        }
 
        String groupid = entity.getGroupid();
        if (groupid != null) {
            stmt.bindString(7, groupid);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(8, date);
        }
 
        String imageurl = entity.getImageurl();
        if (imageurl != null) {
            stmt.bindString(9, imageurl);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(10, url);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(11, title);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(12, type);
        }
 
        Long viewCount = entity.getViewCount();
        if (viewCount != null) {
            stmt.bindLong(13, viewCount);
        }
 
        Boolean iscollected = entity.getIscollected();
        if (iscollected != null) {
            stmt.bindLong(14, iscollected ? 1L: 0L);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Group readEntity(Cursor cursor, int offset) {
        Group entity = new Group( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // count
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // width
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // height
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // order
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // color
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // groupid
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // date
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // imageurl
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // url
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // title
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // type
            cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12), // viewCount
            cursor.isNull(offset + 13) ? null : cursor.getShort(offset + 13) != 0 // iscollected
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Group entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCount(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setWidth(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setHeight(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setOrder(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setColor(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setGroupid(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDate(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setImageurl(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setUrl(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setTitle(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setType(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setViewCount(cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12));
        entity.setIscollected(cursor.isNull(offset + 13) ? null : cursor.getShort(offset + 13) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Group entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Group entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}