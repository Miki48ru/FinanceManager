package com.example.dao.interfaces;

import com.example.enums.OperationType;
import com.example.interfaces.Source;

import java.util.List;

/**
 * Created by Mike on 27.03.2016.
 */
public interface SourceDAO extends CommonDAO<Source> {

   // получить список корневыъ элементов деревьев для определенного типа операции

    boolean add(Source source);

    List<Source> getList(OperationType operationType);
}

