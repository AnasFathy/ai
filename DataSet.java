/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.ai.machineLearning.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Anosa
 */
public class DataSet<t extends DataItem>
{

    public int length;
    private final List<t> items;

    public void addItem(t item)
    {

        this.items.add(item);
        this.length++;
    }

    public void addItems(t... items)
    {
        this.items.addAll(Arrays.asList(items));
        this.length += items.length;
    }

    public List<t> getItems()
    {
        return items;
    }

    public DataSet()
    {
        this.items = new ArrayList<>();
    }

    public t get(int index)
    {
        return items.get(index);
    }

}
