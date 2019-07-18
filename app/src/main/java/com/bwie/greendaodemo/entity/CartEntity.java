package com.bwie.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.bwie.greendaodemo.greendao.DaoSession;
import com.bwie.greendaodemo.greendao.ShoppingCartListBeanDao;
import com.bwie.greendaodemo.greendao.CartEntityDao;

@Entity
public class CartEntity {
    @Id(autoincrement = true)
    private Long id;

    @Unique
    private Long categoryId;

    public String categoryName;

    @ToMany(referencedJoinProperty = "categoryId")
    public List<ShoppingCartListBean> shoppingCartList;

    @Transient//不想加到表
    private boolean isChecked;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1419999415)
    private transient CartEntityDao myDao;

    @Generated(hash = 1665435476)
    public CartEntity(Long id, Long categoryId, String categoryName) {
        this.id = id;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Generated(hash = 1508478210)
    public CartEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 464190913)
    public List<ShoppingCartListBean> getShoppingCartList() {
        if (shoppingCartList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ShoppingCartListBeanDao targetDao = daoSession
                    .getShoppingCartListBeanDao();
            List<ShoppingCartListBean> shoppingCartListNew = targetDao
                    ._queryCartEntity_ShoppingCartList(id);
            synchronized (this) {
                if (shoppingCartList == null) {
                    shoppingCartList = shoppingCartListNew;
                }
            }
        }
        return shoppingCartList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1007164370)
    public synchronized void resetShoppingCartList() {
        shoppingCartList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 494388974)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCartEntityDao() : null;
    }



}
