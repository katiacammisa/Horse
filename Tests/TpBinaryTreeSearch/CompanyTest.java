package TpBinaryTreeSearch;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class CompanyTest {

    Data data1 = new Data("001", 3, "Corta", 2);
    Data data2 = new Data("002", 5, "Larga", 6);
    LinkedList<Data> list = new LinkedList();

    @Test
    public void inOrder() {
        list.add(data2);
        list.add(data1);

        Company com = new Company(list);
        String p = com.inOrder();
        System.out.println();
    }
}