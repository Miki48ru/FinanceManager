package com.example.interfaces;


import com.example.impls.operations.OperationType;

/**
 * Created by Mike on 15.03.2016.
 */
public interface Source extends TreeNode {

    OperationType getOperationType();
}
