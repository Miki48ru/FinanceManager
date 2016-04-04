package com.example.impls;

import com.example.abstracts.AbstractTreeNode;
import com.example.enums.OperationType;
import com.example.interfaces.Source;
import com.example.interfaces.TreeNode;


import java.util.List;

/**
 * Created by Mike on 15.03.2016.
 */
public class DefaultSource extends AbstractTreeNode implements Source {

    private OperationType operationType;

    public DefaultSource() {
    }

    public DefaultSource(String name) {
        super(name);
    }

    public DefaultSource(List<TreeNode> childs) {
        super(childs);
    }

    public DefaultSource(String name, long id) {
        super(name, id);
    }

    public DefaultSource(long id, List<TreeNode> childs, TreeNode parent, String name) {
        super(id, childs, parent, name);
    }

    public DefaultSource(String name, long id, OperationType operationType) {
        super(name, id);
        this.operationType = operationType;
    }


    @Override
    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }




    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void add(TreeNode child) {
        if (child instanceof DefaultSource){
            ((DefaultSource)child).setOperationType(operationType);
        }

        super.add(child);
    }
}
