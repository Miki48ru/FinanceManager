package com.example.utils;

import com.example.interfaces.TreeNode;

import java.util.List;

/**
 * Created by Mike on 23.03.2016.
 */
public class TreeConstructor<T extends TreeNode> {

    public void addToTree(long parentId, T newNode, List<T> storageList) {
        if (parentId!=0){
            for (T currentNode: storageList) {// искать сначала во всех корневых объектах
                if (currentNode.getId()==parentId){
                    currentNode.addChild(newNode);
                    return;
                }else {// если среди корневых элементов не найдены родители
                    TreeNode node = recursiveSearch(parentId, currentNode);// проходим по всем уровням дочерних элементов
                    if (node!=null){// если нашли среди дочерних элементов
                        node.addChild(newNode);
                        return;
                    }
                }
            }
        }

        storageList.add(newNode);// если не найден родительский элемент - добавляем как корневой
    }


    // рекурсивно проходит по всем дочерним элементам
    private TreeNode recursiveSearch(long parentId, TreeNode child){
        for (TreeNode node: child.getChilds()) {
            if (node.getId() == parentId){
                return node;
            }else if (node.hasChilds()){// если у текущего узло есть свои дочерние элемента - проходим и по ним
                recursiveSearch(parentId, node);
            }
        }
        return null;
    }
}
