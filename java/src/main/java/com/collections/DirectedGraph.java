package com.collections;


import java.util.*;
import java.util.stream.Collectors;

public class DirectedGraph<N> implements Graph<N> {

    private final Map<N, Set<Edge<N>>> adjacencies = new HashMap<>();

    @Override
    public void clear() {
        adjacencies.clear();
    }

    @Override
    public int size() {
        return adjacencies.size();
    }

    @Override
    public boolean containsNode(N node) {
        return adjacencies.containsKey(node);
    }

    @Override
    public boolean containsEdge(N node1, N node2) {
        return containsNode(node1) && adjacentNodes(node1).contains(node2);
    }

    @Override
    public boolean addNode(N node) {
        if (containsNode(node)) {
            return false;
        }
        adjacencies.put(node, new HashSet<>());
        return true;
    }

    @Override
    public boolean addEdge(N node1, N node2) {
        if (!containsNode(node1)) {
            addNode(node1);
        }
        if (!containsNode(node2)) {
            addNode(node2);
        }
        return adjacentEdges(node1).add(new DirectedEdge<>(node1, node2));
    }

    @Override
    public Collection<N> adjacentNodes(N node) {
        return adjacentEdges(node).stream().map(Edge::getNode2).collect(Collectors.toList());
    }

    @Override
    public Collection<Edge<N>> adjacentEdges(N node) {
        return adjacencies.get(node);
    }

    @Override
    public boolean isEmpty() {
        return adjacencies.isEmpty();
    }

    static class DirectedEdge<N> implements Edge<N> {

        private N node1;
        private N node2;

        DirectedEdge(N node1, N node2) {
            this.node1 = node1;
            this.node2 = node2;

        }

        @Override
        public N getNode1() {
            return node1;
        }

        @Override
        public N getNode2() {
            return node2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DirectedEdge<?> that = (DirectedEdge<?>) o;
            return Objects.equals(node1, that.node1) &&
                    Objects.equals(node2, that.node2);
        }

        @Override
        public int hashCode() {

            return Objects.hash(node1, node2);
        }
    }
}
