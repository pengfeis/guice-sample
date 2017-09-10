package pengfei.learn.corejava.concurr.inpractice;

import java.util.concurrent.atomic.AtomicReference;


/**
 * non blocking stack in concurrent thread
 * @param <E>
 */
public class NonBlockConcurrStack<E> {

    private AtomicReference<Node<E>> top = new AtomicReference<>();

    public void push(E elt) {
        Node<E> newNode = new Node<>(elt);

        Node<E> oldNode;
        do {
            oldNode = top.get();
            newNode.nextElt = oldNode;
        } while(!top.compareAndSet(oldNode, newNode));
    }


    public E pop() {
        Node<E> oldNode;
        Node<E> newNode;
        for (;;) {
            oldNode = top.get();
            if (oldNode == null) {
                return null;
            } else {
                newNode = oldNode.nextElt;
                if (top.compareAndSet(oldNode, newNode)) {
                    return oldNode.elt;
                }
            }
        }
    }


    private static class Node<E> {
        public final E elt;
        public Node<E> nextElt;

        public Node(E elt) {
            this.elt = elt;
        }
    }

}
