package com.example.decorator;

import com.example.dao.interfaces.SourceDAO;
import com.example.impls.operations.OperationType;
import com.example.interfaces.Source;

import java.util.List;

/**
 * Created by Mike on 27.03.2016.
 */
public class SourceSync implements SourceDAO {

    private SourceDAO sourceDAO;
    private List<Source> sourceList;

    public SourceSync(SourceDAO sourceDAO) {
        this.sourceDAO = sourceDAO;
    }

    @Override
    public List<Source> getAll() {
        if (sourceList==null){
            sourceList = sourceDAO.getAll();
        }
        return sourceList;
    }

    @Override
    public Source get(long id) {
        return null;
    }

    @Override
    public boolean update(Source source) {
        if (sourceDAO.update(source)){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Source source) {
        // TODO добавить нужные Exceptions
        if (sourceDAO.delete(source)){
            sourceList.remove(source);
            sourceDAO.getList(source.getOperationType()).remove(source);
            return true;
        }
        return false;
    }

    @Override
    public List<Source> getList(OperationType operationType) {
        return sourceDAO.getList(operationType);
    }
}
