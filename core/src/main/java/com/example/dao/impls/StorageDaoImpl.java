package com.example.dao.impls;

import com.example.dao.interfaces.StorageDAO;
import com.example.database.SQLiteConnection;
import com.example.impls.DefaultStorage;
import com.example.interfaces.Storage;
import com.example.utils.TreeConstructor;

import java.beans.Statement;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mike on 22.03.2016.
 */
public class StorageDAOImpl implements StorageDAO {

    public static final String CURRENCY_TABLE = "currency_amount";
    public static final String STORAGE_TABLE = "storage";

    private TreeConstructor<Storage> treeConstructor = new TreeConstructor();


    private List<Storage> storageList = new ArrayList<>();

    @Override
    public boolean addCurrency(Storage storage, Currency currency) {
        try (PreparedStatement stmt = SQLiteConnection.getConnection().prepareStatement("insert into " + CURRENCY_TABLE + "(currency_code, storage_id, amount) values(?,?,?)");) {
            stmt.setString(1, currency.getCurrencyCode());
            stmt.setLong(2, storage.getId());
            stmt.setBigDecimal(3, BigDecimal.ZERO);

            if (stmt.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(StorageDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }



    public boolean deleteCurrency(Storage storage, Currency currency) {
        try (PreparedStatement stmt = SQLiteConnection.getConnection().prepareStatement("delete into " + CURRENCY_TABLE + " where storage_id=? and currency_code=?");) {
            stmt.setLong(1, storage.getId());
            stmt.setString(2, currency.getCurrencyCode());

            if (stmt.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(StorageDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<Storage> getAll() {
        storageList.clear();

        try (java.sql.Statement stmt = SQLiteConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("select * from " + STORAGE_TABLE);) {

            while (rs.next()) {
                DefaultStorage storage = new DefaultStorage();
                storage.setId(rs.getLong("id"));
                storage.setName(rs.getString("name"));

                long parentId = rs.getLong("parent_id");

                treeConstructor.addToTree(parentId, storage, storageList);

            }

            return storageList;// в итоге storageList должен содержать только корневые элементы

        } catch (SQLException e) {
            Logger.getLogger(StorageDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

    @Override
    public boolean update(Storage storage) {
        // для упрощения - у хранилища даем изменить только название, изменять parent_id нельзя (для этого можно удалить и заново создать)
        try (PreparedStatement stmt = SQLiteConnection.getConnection().prepareStatement("update " + STORAGE_TABLE + " set name=? where id=?");) {

            stmt.setString(1, storage.getName());
            stmt.setLong(2, storage.getId());

            if (stmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            Logger.getLogger(StorageDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    @Override
    public boolean updateAmount(Storage storage, BigDecimal amount) {
        return false;
    }

    @Override
    public Storage get(long id) {
        return null;
    }

    @Override
    public boolean delete(Storage storage) {
        // TODO реализовать - если есть ли операции по данному хранилищу - запрещать удаление
        try (PreparedStatement stmt = SQLiteConnection.getConnection().prepareStatement("delete from " + STORAGE_TABLE + " where id=?");) {

            stmt.setLong(1, storage.getId());

            if (stmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            Logger.getLogger(StorageDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }


}


