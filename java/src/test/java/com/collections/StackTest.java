package com.collections;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StackTest {

    @Test
    public void stackFullTest() {
        Stack<Integer> stack = new Stack<>();
        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.size()).isZero();
        stack.push(1);
        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.size()).isOne();
        assertThat(stack.pop()).isEqualTo(1);
        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.size()).isZero();

        stack.push(5);
        assertThat(stack.peek()).isEqualTo(5);

        stack.push(12);
        stack.push(4);
        assertThat(stack.size()).isEqualTo(3);
        assertThat(stack.peek()).isEqualTo(4);
        assertThat(stack.size()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.size()).isEqualTo(2);

        assertThat(stack.peek()).isEqualTo(12);
        assertThat(stack.pop()).isEqualTo(12);
        assertThat(stack.pop()).isEqualTo(5);

        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.size()).isZero();

        assertThatExceptionOfType(EmptyStackException.class).isThrownBy(stack::peek);
        assertThatExceptionOfType(EmptyStackException.class).isThrownBy(stack::pop);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Stack(0));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Stack(-1));

    }


    @Test
    public void stackStressTest() {
        Stack<Integer> stack = new Stack<>(2);

        for (int i = 0; i < 10; i++) {
            assertThat(stack.size()).isEqualTo(i);
            stack.push(i);
            assertThat(stack.peek()).isEqualTo(i);
        }

        for (int i = 10; i > 0; i--) {
            assertThat(stack.size()).isEqualTo(i);
            assertThat(stack.pop()).isEqualTo(i - 1);
        }

    }

    @Test
    public void isEmpty_newStack_returnsTrue() {
        Stack<Integer> stack = new Stack<>();
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void isEmpty_stackWithElem_returnsFalse() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        assertThat(stack.isEmpty()).isFalse();
    }
}
