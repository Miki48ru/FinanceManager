package com.example.interfaces;

import java.util.List;

/**
 * Created by Mike on 13.03.2016.
 */
public interface TreeNode {

    String getName();

    long getId();

    void addChild();

    void removeChild();

    List<TreeNode> getChilds();

    TreeNode getChild (long id);

    TreeNode getParent();

    void addChild(TreeNode child);

    void setParent(TreeNode parent);


    void removeChild(TreeNode child);
}
