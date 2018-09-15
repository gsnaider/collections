package com.collections;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectedGraphTest {


    @Test
    public void directedGraphFullTest() {
        Graph<Integer> graph = new DirectedGraph<>();
        assertThat(graph.isEmpty()).isTrue();
        assertThat(graph.size()).isZero();
        assertThat(graph.addNode(1)).isTrue();
        assertThat(graph.isEmpty()).isFalse();
        assertThat(graph.size()).isOne();
        assertThat(graph.containsNode(1)).isTrue();
        assertThat(graph.containsNode(2)).isFalse();
        assertThat(graph.addNode(2)).isTrue();
        assertThat(graph.containsNode(2)).isTrue();
        assertThat(graph.addNode(2)).isFalse();

        graph.clear();
        assertThat(graph.isEmpty()).isTrue();
        assertThat(graph.containsNode(1)).isFalse();
        assertThat(graph.containsNode(2)).isFalse();


        assertThat(graph.addEdge(3, 5)).isTrue();
        assertThat(graph.containsNode(3)).isTrue();
        assertThat(graph.containsNode(5)).isTrue();
        assertThat(graph.size()).isEqualTo(2);
        assertThat(graph.containsEdge(3, 5)).isTrue();

        assertThat(graph.addNode(1)).isTrue();
        assertThat(graph.addNode(2)).isTrue();
        assertThat(graph.addEdge(1, 2)).isTrue();

        assertThat(graph.addEdge(2, 5)).isTrue();

        assertThat(graph.addEdge(2, 7)).isTrue();

        assertThat(graph.size()).isEqualTo(5);

        assertThat(graph.adjacentNodes(2)).containsExactly(5, 7);

        assertThat(graph.adjacentNodes(3)).containsExactly(5);

        assertThat(graph.adjacentNodes(7)).isEmpty();


        assertThat(graph.adjacentEdges(2))
                .containsExactly(new DirectedGraph.DirectedEdge<>(2, 5), new DirectedGraph.DirectedEdge<>(2, 7));

        assertThat(graph.adjacentEdges(3)).containsExactly(new DirectedGraph.DirectedEdge<>(3, 5));

        assertThat(graph.adjacentEdges(7)).isEmpty();


    }
}
