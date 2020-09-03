package abhamare_lab7;

public class QueueNode {

    RenderCommand renderCommand;
    QueueNode next;    // Reference to successor
    QueueNode prev;    // Reference to predecessor
    QueueNode(RenderCommand renderCommand, QueueNode n, QueueNode p)
    {
        this.renderCommand=renderCommand;
        next = n;
        prev = p;
    }

   QueueNode(RenderCommand renderCommand)
    {
        // Call the other constructor
        this(renderCommand, null, null);
    }
}
