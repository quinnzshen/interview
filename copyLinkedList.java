public LinkedList copyLinkedList(LinkedList originalList) {
    Node currentNode = originalList.getHead();
    LinkedList copyList = new LinkedList(new Node(currentNode.getValue()));
    
    while (currentNode.hasNext()) {
        currentNode = currentNode.getNext();
        copyList.setNext(new Node(currentNode.getValue()));
    }

    currentNode = originalList.getHead();
    Node currentNodeNext = currentNode.getNext();
    Node copyNode = copyList.getHead();
    Node copyNodeNext = copyNode.getNext();

    // Weave lists
    while (currentNode.hasNext()) {
        currentNode.setNext(copyNode);
        copyNode.setNext(currentNodeNext);

        currentNode = currentNodeNext;
        copyNode = copyNodeNext;
        currentNodeNext = currentNode.getNext();
        copyNodeNext = copyNode.getNext();
    }
    currentNode.setNext(copyNode);
    
    currentNode = originalList.getHead();
    currentNode.setNextRand(currentNode.getNextRand().getNext());

    while (currentNode.hasNext()) {
        currentNode = currentNode.getNext();
        currentNode.setNextRand(currentNode.getNextRand().getNext());
    }

    // Un-weave lists
    currentNode = originalList.getHead().getNext();
    while (currentNode.hasNext()) {
        currentNode.setNext(currentNode.getNext().getNext());
        currentNode = currentNode.getNext().getNext();
    }

    return copyList;
}

public LinkedList copyLinkedList(LinkedList originalList) {
    Node currentNode = originalList.getHead();
    Node copyNode = new Node(currentNode.getValue());
    LinkedList copyList = new LinkedList(copyNode);

    Map<Node, Node> originalToCopyMap = new HashMap<>();
    originalToCopyMap.put(currentNode, copyNode);

    while (currentNode.hasNext()) {
        currentNode = currentNode.getNext();
        copyNode.setNext(new Node(currentNode.getValue()));

        originalToCopyMap.put(currentNode, copyNode.getNext());
    }

    currentNode = originalList.getHead();
    copyNode = copyList.getHead();
    copyNode.setNextRand(originalToCopyMap.get(currentNode));

    while (currentNode.hasNext()) {
        currentNode = currentNode.getNext();
        copyNode.setNextRand(originalToCopyMap.get(currentNode));
    }

    return copyList;
}