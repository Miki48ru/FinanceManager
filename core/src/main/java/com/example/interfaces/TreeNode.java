package com.example.interfaces;

import java.util.List;

/**
 * Created by Mike on 13.03.2016.
 */
public interface TreeNode {

    long getId();

    void addChild();

    void removeChild();

    List<TreeNode> getChilds();

    TreeNode getChild (long id);

    TreeNode getParent();

    void setParent(TreeNode parent);



}
