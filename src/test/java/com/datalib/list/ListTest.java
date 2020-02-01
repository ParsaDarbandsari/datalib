package com.datalib.list;


import org.junit.*;

public class ListTest {
    @Test
    public void test_append_one_item() {
        List<String> list = new List<>();
        list.append("A");
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void test_get_main_success_scenario() {
        List<String> list = new List<>();
        list.append("X");
        Assert.assertEquals("X", list.get(0));
    }

    @Test(expected = ListIndexOutOfBondsException.class)
    public void test_get_index_bigger_than_size() {
        List<String> list = new List<>();
        list.append("P");
        Object a = list.get(3);
    }

    @Test()
    public void test_removeItem() {
        List<String> list = new List<>();
        list.append("A");
        list.append("B");
        list.append("C");
        list.append("D");
        list.append("C");
        list.removeItem("C");
        Assert.assertEquals("D", list.get(2));
        Assert.assertEquals(3, list.size());
    }
}
