/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.ai.machineLearning.unsupervised;

import com.java.ai.machineLearning.generics.DataItem;

/**
 *
 * @author Anosa
 */
public abstract class Centroid
{

    private double centroidValue;

    public void setCentroidValue(double centroidValue)
    {
        this.centroidValue = centroidValue;
    }

    public double getCentroidValue()
    {
        return centroidValue;
    }

    public abstract double calculateDifference(double value);

    public abstract <t extends DataItem> double calculateDifference(t item);

}
