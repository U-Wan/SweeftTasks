package sweeft.linkedlist

/*
function for finding node at current index: findNodeAt()-> complexity:O(n)

function for removing node(next node) : removeAfter()-> complexity:O(1)

so this data structure needs O(n) time for finding an element
but it's able to remove it in O(1) time (as required in the condition)
 */


class LinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }
    fun push(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    fun append(value: T) {

        if (isEmpty()) {
            push(value)
            return
        }

        tail?.next = Node(value = value)


        tail = tail?.next
        size++
    }

    //finding node at index
    fun findNodeAt(index: Int): Node<T>? {

        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        if (currentNode == null) {
            println("Can't find element at position:$index ");
        }

        return currentNode

    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = Node(value = value, next = afterNode.next)

        afterNode.next = newNode
        size++
        return newNode
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value
        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result
    }


}
