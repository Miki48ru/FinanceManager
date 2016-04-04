package com.example.dao.interfaces;

import com.example.enums.OperationType;
import com.example.interfaces.Operation;

import java.util.List;

/**
 * Created by Mike on 04.04.2016.
 */
public interface OperationDAO extends CommonDAO<Operation> {

    boolean add(Operation operation);

    List<Operation> getList(OperationType operationType);// получить список операций определенного типа

}