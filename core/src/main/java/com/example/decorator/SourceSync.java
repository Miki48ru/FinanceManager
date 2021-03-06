package com.example.decorator;

import com.example.dao.interfaces.SourceDAO;
import com.example.enums.OperationType;
import com.example.interfaces.Source;
import com.example.utils.TreeUtils;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Mike on 27.03.2016.
 */
public class SourceSync implements SourceDAO {

    private TreeUtils<Source> treeUtils = new TreeUtils();// построитель дерева

    // Все коллекции хранят ссылки на одни и те же объекты, но в разных "срезах"
    // при удалении - удалять нужно из всех коллекций
    private List<Source> treeList = new ArrayList<>(); // хранит деревья объектов без разделения по типам операции
    private Map<OperationType, List<Source>> sourceMap = new EnumMap<>(OperationType.class); // деревья объектов с разделением по типам операции
    private Map<Long, Source> identityMap = new HashMap<>(); // нет деревьев, каждый объект хранится отдельно, нужно для быстрого доступа к любому объекту по id (чтобы каждый раз не использовать перебор по всей коллекции List и не обращаться к бд)

    private SourceDAO sourceDAO;// реализация слоя работы с БД

    public SourceSync(SourceDAO sourceDAO) {
        this.sourceDAO = sourceDAO;
        init();
    }

    public void init() {
        List<Source> sourceList = sourceDAO.getAll();// запрос в БД происходит только один раз, чтобы заполнить коллекцию sourceList

        for (Source s : sourceList) {
            identityMap.put(s.getId(), s);
            treeUtils.addToTree(s.getParentId(), s, treeList);
        }

        // важно - сначала построить деревья, уже потом разделять по типам операции
        fillSourceMap(treeList);// разделяем по типам операции


    }

    private void fillSourceMap(List<Source> list) {


        // TODO когда начнется поддержка Java 8 для Android - использовать этот код
//        for (OperationType type : OperationType.values()) {
//            // используем lambda выражение для фильтрации
//            sourceMap.put(type, list.stream().filter(s -> s.getOperationType() == type).collect(Collectors.toList()));
//        }



        for (OperationType type : OperationType.values()) {
            ArrayList<Source> incomeSources = new ArrayList<>();
            ArrayList<Source> outcomeSources = new ArrayList<>();
            ArrayList<Source> transferSources = new ArrayList<>();
            ArrayList<Source> convertSources = new ArrayList<>();

            // проход по коллекции только один раз
            for (Source o : list) {
                switch (o.getOperationType()){
                    case INCOME:{
                        incomeSources.add(o);
                        break;
                    }

                    case OUTCOME:{
                        outcomeSources.add(o);
                        break;
                    }

                    case TRANSFER:{
                        transferSources.add(o);
                        break;
                    }

                    case CONVERT:{
                        convertSources.add(o);
                        break;
                    }
                }
            }

            sourceMap.put(OperationType.INCOME, incomeSources);
            sourceMap.put(OperationType.OUTCOME, outcomeSources);
            sourceMap.put(OperationType.CONVERT, convertSources);
            sourceMap.put(OperationType.TRANSFER, transferSources);

        }




    }

    @Override
    public List<Source> getAll() {// возвращает объекты уже в виде деревьев
        return treeList;
    }

    @Override
    public Source get(long id) {// не делаем запрос в БД, а получаем ранее загруженный объект из коллекции
        return identityMap.get(id);
    }


    @Override
    public boolean update(Source source) {
        if (sourceDAO.update(source)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Source source) {
        // TODO добавить нужные Exceptions
        if (sourceDAO.delete(source)) {
            removeFromCollections(source);

            return true;
        }
        return false;
    }

    private void addToCollections(Source source) {
        identityMap.put(source.getId(), source);

        if (source.hasParent()) {
            if (!source.getParent().getChilds().contains(source)) {// если ранее не был добавлен уже
                source.getParent().add(source);
            }
        } else {// если добавляем элемент, у которого нет родителей (корневой)
            sourceMap.get(source.getOperationType()).add(source);
            treeList.add(source);
        }
    }

    private void removeFromCollections(Source source) {
        identityMap.remove(source.getId());

        if (source.hasParent()) {// если удаляем дочерний элемент
            source.getParent().remove(source);// т.к. у каждого дочернего элемента есть ссылка на родительский - можно быстро удалять элемент из дерева без поиска по всему дереву
        } else {// если удаляем элемент, у которого нет родителей
            sourceMap.get(source.getOperationType()).remove(source);
            treeList.remove(source);
        }
    }

    @Override
    public boolean add(Source source) {
        if (sourceDAO.add(source)) {// если в БД добавился нормально
            addToCollections(source);
            return true;

        }
        return false;
    }


    @Override
    public List<Source> getList(OperationType operationType) {
        return sourceMap.get(operationType);
    }


    // если понадобится напрямую получить объекты из БД - можно использовать sourceDAO
    public SourceDAO getSourceDAO() {
        return sourceDAO;
    }

    public Map<Long, Source> getIdentityMap() {
        return identityMap;
    }
}
