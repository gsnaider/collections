package com.collections;

import java.util.Collection;

public interface Graph<N> {

    void clear();

    int size();

    boolean containsNode(N node);

    boolean containsEdge(N node1, N node2);

    boolean addNode(N node);

    boolean addEdge(N node1, N node2);

    Collection<N> adjacentNodes(N node);

    Collection<Edge<N>> adjacentEdges(N node);

    boolean isEmpty();

    boolean equals(Object o);

    int hashCode();

    interface Edge<E> {

        E getNode1();

        E getNode2();

        boolean equals(Object o);

        int hashCode();

    }

}
