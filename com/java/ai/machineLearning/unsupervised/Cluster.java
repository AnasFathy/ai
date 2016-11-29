/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.ai.machineLearning.unsupervised;

import com.java.ai.machineLearning.generics.DataItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anosa
 * @param <t>
 */
public class Cluster<t extends DataItem, c extends Centroid>
{

    private String name;
    private c centroid;
    private List<t> items;

    public Cluster(c centroid)
    {
        this();
        this.centroid = centroid;

    }

    public Cluster(String name, c centroid)
    {
        this(centroid);
        this.name = name;
    }

    public Cluster()
    {
        this.items = new ArrayList<>();
    }

    public void setCentroid(c centroid)
    {
        this.centroid = centroid;
    }

    public void addItem(t item)
    {
        this.items.add(item);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public c getCentroid()
    {

        return centroid;
    }

    public void refreshCentroid()
    {
        if (items.isEmpty())
        {
            double sum = 0;
            for (t item : items)
            {
                sum += item.getNumericalValue();
            }
            sum = sum / items.size();
            centroid.setCentroidValue(sum);
        }
    }

    public void clear()
    {
        this.items.removeAll(items);
    }

    public String getName()
    {
        return name;
    }

    public t getItem(int index)
    {
        return items.get(index);
    }

    public List<t> getItems()
    {
        return items;
    }

}
