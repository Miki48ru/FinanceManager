package com.example.interfaces;

import java.util.List;

/**
 * Created by Mike on 13.03.2016.
 */
public interface TreeNode {

    String getName();

    long getId();

    void add();

    void remove();

    List<TreeNode> getChilds();

    TreeNode getChild (long id);

    TreeNode getParent();

    void add(TreeNode child);

    void setParent(TreeNode parent);

    void remove(TreeNode child);

    boolean hasChilds(); //проверяет наличие дочерних элементов


}
