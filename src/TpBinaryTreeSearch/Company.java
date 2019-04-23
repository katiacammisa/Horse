package TpBinaryTreeSearch;

import Nodes.DoubleNodeSearch;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Company {

    private SearchBinaryTree<Data> tree;

    public Company(LinkedList<Data> list) {
        tree = new SearchBinaryTree<>();
        put(list);
    }

    public void put(List<Data> list) {
        for (int i = 0; i < list.size(); i++) {
            tree.insert(list.get(i));
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
