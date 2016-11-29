/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.ai.machineLearning.unsupervised;

import com.java.ai.machineLearning.generics.DataItem;
import com.java.ai.machineLearning.generics.DataSet;
import java.util.List;

/**
 * this class performs the actual work of clustering data
 *
 * @author Anas Fathy Mohammed
 */
public class ClusterEngine
{

    public <t extends DataItem, m extends Centroid> ClusterResult cluster(DataSet<t> dataSet, List<m> centroids, int loop, String... names)
    {
        ClusterResult clusters = this.createGroups(centroids, names);
        return this.cluster(dataSet, clusters, loop);
    }

    private <t extends DataItem, c extends Centroid> ClusterResult createGroups(List<c> centroids, String... names)
    {
        ClusterResult<Cluster<t, c>> result = new ClusterResult();
        int counter = 0;
        for (String name : names)
        {
            Cluster<t, c> cluster = new Cluster<>(name, centroids.get(counter));
            result.addCluster(cluster);
            counter++;
        }
        return result;
    }

    private <t extends DataItem> ClusterResult cluster(DataSet<t> dataSet, ClusterResult result, int loop)
    {
        for (int counter = 0; counter < loop; counter++)
        {
            for (int i = 0; i < dataSet.length; i++)
            {
                result.get(findClosestCentroid(dataSet.get(i).getNumericalValue(), result)).addItem(dataSet.get(i));
            }
            if (counter == loop - 2)
            {
                result.refreshCentroids();
                return result;
            }
            result.refreshCentroids();
            result.clear();
        }
        return result;
    }

    private int findClosestCentroid(double value, ClusterResult result)
    {
        double min = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < result.length; i++)
        {
            double distance = Math.abs(result.get(i).
                    getCentroid().calculateDifference(value));
            if (min > distance)
            {
                min = distance;
                index = i;
            }
        }
        return index;
    }

    private ClusterResult createGroups(Class<Centroid> implementationClass, double[] centroids, String... names)
    {
        ClusterResult result = new ClusterResult();

        for (int i = 0; i < names.length; i++)
        {

            try
            {
                String name = names[i];
                double value = centroids[i];
                Centroid c = implementationClass.newInstance();
                c.setCentroidValue(value);
                Cluster group = new Cluster(name, c);
                result.addCluster(group);
            } catch (IllegalAccessException | InstantiationException e)
            {
                throw new RuntimeException("");
            }
        }
        return result;
    }

    private ClusterResult createGroups(Class<Centroid> implementationClass, double[] centroids)
    {
        String[] names = new String[centroids.length];
        for (int i = 0; i < names.length; i++)
        {
            names[i] = "";
        }
        return this.createGroups(implementationClass, centroids, names);
    }

    private <t extends DataItem> double[] initCentroids(DataSet<t> dateset, int k)
    {
        double[] cetnroeids = new double[k];
        double sum = 0;
        for (int i = 0; i < dateset.getItems().size(); i++)
        {
            sum += dateset.getItems().get(i).getNumericalValue();
        }
        double avarage = sum / (k);
        double value = avarage / 2;
        for (int i = 0; i < k; i++)
        {
            value = value + avarage;
            cetnroeids[i] = value;
        }
        return cetnroeids;
    }

    private <t extends Centroid> void createCentroids(Class<t> centroidImplementation, double[] values, String names)
    {

    }

    private class TaskDivider
    {

        public void start()
        {
        }

        public void putTask(int start)
        {
        }
    }
}
