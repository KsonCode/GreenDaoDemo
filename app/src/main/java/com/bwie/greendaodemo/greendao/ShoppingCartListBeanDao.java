package com.bwie.greendaodemo.greendao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.bwie.greendaodemo.entity.ShoppingCartListBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SHOPPING_CART_LIST_BEAN".
*/
public class ShoppingCartListBeanDao extends AbstractDao<ShoppingCartListBean, Long> {

    public static final String TABLENAME = "SHOPPING_CART_LIST_BEAN";

    /**
     * Properties of entity ShoppingCartListBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property CategoryId = new Property(1, Long.class, "categoryId", false, "CATEGORY_ID");
        public final static Property CommodityId = new Property(2, String.class, "commodityId", false, "COMMODITY_ID");
        public final static Property CommodityName = new Property(3, String.class, "commodityName", false, "COMMODITY_NAME");
        public final static Property Count = new Property(4, String.class, "count", false, "COUNT");
        public final static Property Pic = new Property(5, String.class, "pic", false, "PIC");
        public final static Property Price = new Property(6, String.class, "price", false, "PRICE");
    }

    private Query<ShoppingCartListBean> cartEntity_ShoppingCartListQuery;

    public ShoppingCartListBeanDao(DaoConfig config) {
        super(config);
    }
    
    public ShoppingCartListBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SHOPPING_CART_LIST_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CATEGORY_ID\" INTEGER," + // 1: categoryId
                "\"COMMODITY_ID\" TEXT UNIQUE ," + // 2: commodityId
                "\"COMMODITY_NAME\" TEXT," + // 3: commodityName
                "\"COUNT\" TEXT," + // 4: count
                "\"PIC\" TEXT," + // 5: pic
                "\"PRICE\" TEXT);"); // 6: price
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SHOPPING_CART_LIST_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ShoppingCartListBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long categoryId = entity.getCategoryId();
        if (categoryId != null) {
            stmt.bindLong(2, categoryId);
        }
 
        String commodityId = entity.getCommodityId();
        if (commodityId != null) {
            stmt.bindString(3, commodityId);
        }
 
        String commodityName = entity.getCommodityName();
        if (commodityName != null) {
            stmt.bindString(4, commodityName);
        }
 
        String count = entity.getCount();
        if (count != null) {
            stmt.bindString(5, count);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(6, pic);
        }
 
        String price = entity.getPrice();
        if (price != null) {
            stmt.bindString(7, price);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ShoppingCartListBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long categoryId = entity.getCategoryId();
        if (categoryId != null) {
            stmt.bindLong(2, categoryId);
        }
 
        String commodityId = entity.getCommodityId();
        if (commodityId != null) {
            stmt.bindString(3, commodityId);
        }
 
        String commodityName = entity.getCommodityName();
        if (commodityName != null) {
            stmt.bindString(4, commodityName);
        }
 
        String count = entity.getCount();
        if (count != null) {
            stmt.bindString(5, count);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(6, pic);
        }
 
        String price = entity.getPrice();
        if (price != null) {
            stmt.bindString(7, price);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ShoppingCartListBean readEntity(Cursor cursor, int offset) {
        ShoppingCartListBean entity = new ShoppingCartListBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // categoryId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // commodityId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // commodityName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // count
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // pic
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // price
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ShoppingCartListBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCategoryId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setCommodityId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCommodityName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCount(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPic(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPrice(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ShoppingCartListBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ShoppingCartListBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ShoppingCartListBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "shoppingCartList" to-many relationship of CartEntity. */
    public List<ShoppingCartListBean> _queryCartEntity_ShoppingCartList(Long categoryId) {
        synchronized (this) {
            if (cartEntity_ShoppingCartListQuery == null) {
                QueryBuilder<ShoppingCartListBean> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.CategoryId.eq(null));
                cartEntity_ShoppingCartListQuery = queryBuilder.build();
            }
        }
        Query<ShoppingCartListBean> query = cartEntity_ShoppingCartListQuery.forCurrentThread();
        query.setParameter(0, categoryId);
        return query.list();
    }

}
