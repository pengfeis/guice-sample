package algorithm;

import java.util.Stack;

public class TwoStackAsQueue<E> {
    private Stack<E> stackA = new Stack<>();
    private Stack<E> stackB= new Stack<>();

    public void put(E e) {
        if (stackA.isEmpty() && !stackB.isEmpty())
        infunde(stackB, stackA);
        stackA.push(e);
    }

    public E poll() {
        if (!stackA.isEmpty() && stackB.isEmpty()) {
            infunde(stackA, stackB);
        }
        return stackB.pop();
    }

    private void infunde(Stack<E> from, Stack<E> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwoStackAsQueue<?> that = (TwoStackAsQueue<?>) o;

        if (stackA != null ? !stackA.equals(that.stackA) : that.stackA != null) return false;
        return stackB != null ? stackB.equals(that.stackB) : that.stackB == null;
    }

    @Override
    public int hashCode() {
        int result = stackA != null ? stackA.hashCode() : 0;
        result = 31 * result + (stackB != null ? stackB.hashCode() : 0);
        return result;
    }
}
