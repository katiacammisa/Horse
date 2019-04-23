package TpBinaryTreeSearch;

import Nodes.DoubleNodeSearch;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Company {

    private SearchBinaryTree<Data> tree;

    public Company(LinkedList<Data> list) {
        tree = transformToTree(list);
    }

    private SearchBinaryTree<Data> transformToTree(LinkedList<Data> list) {
        sortList(list);
        SearchBinaryTree<Data> a = new SearchBinaryTree<>();
        return a;
    }

    private void sortList(LinkedList<Data> list) {
        list.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.compareTo(o2);
            }
        });

    }

    public void put(SearchBinaryTree<Data> a, List<Data> list) {
        for (int i = 0; i < list.size(); i++) {
            a.insert(list.get(i));
        }
    }

    public void insert(Data x){
        tree.insert(x);
    }

    public void eliminate(Data x){
        tree.eliminate(x);
    }

    public void modify(Data x) {
        eliminate((Data) tree.search(x));
        insert(x);
    }

    public String inOrder(){
        String s = "";
        return inOrder(tree, s);
    }

    private String inOrder(SearchBinaryTree a, String s) {
        if (!a.isEmpty()) {
            s = inOrder(a.getLeft(), s);
            s = s + a.getRoot().toString();
            s = inOrder(a.getRight(), s);
        }
        return s;
    }



}
