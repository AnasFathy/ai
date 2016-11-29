/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.ai.machineLearning.unsupervised;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anosa
 */
public class ClusterResult<t extends Cluster>
{

    public int length;

    private final List<t> clusters;

    public ClusterResult()
    {
        this.clusters = new ArrayList<>();
    }

    public void addCluster(t cluster)
    {
        this.clusters.add(cluster);
        this.length++;
    }

    public List<t> getClusters()
    {
        return clusters;
    }

    public t get(int index)
    {
        return this.clusters.get(index);
    }

    public void clear()
    {
        this.clusters.forEach(Cluster::clear);
    }

    public void refreshCentroids()
    {
        this.clusters.forEach(Cluster::refreshCentroid);
    }
}
