package com.example.abstracts;

import com.example.interfaces.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 13.03.2016.
 */
public abstract class AbstractTreeNode implements TreeNode {

    private long id;

    private List<TreeNode> childs = new ArrayList<>();

    private TreeNode parent;

    private String name;

    public AbstractTreeNode(long id, List<TreeNode> childs, TreeNode parent, String name) {
        this.id = id;
        this.childs = childs;
        this.parent = parent;
        this.name = name;
    }

    public AbstractTreeNode() {
    }

    public AbstractTreeNode(String name) {
        this.name = name;
    }

    public AbstractTreeNode(List<TreeNode> childs) {
        this.childs = childs;
    }

    public AbstractTreeNode(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void addChild(TreeNode child) {
        child.setParent(this);
        childs.add(child);
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void removeChild(TreeNode child) {
        childs.remove(child);
    }

    @Override
    public List<TreeNode> getChilds() {
        return childs;
    }

    @Override
    public long getId() {
        return 0;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public TreeNode getChild(long id) {
        for (TreeNode child:childs) {
            if (child.getId() == id){
                return child;
            }
        }

        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractTreeNode that = (AbstractTreeNode) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
