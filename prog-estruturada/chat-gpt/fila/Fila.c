#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_QUEUE_SIZE 100

// Structure for a queue node
struct QueueNode {
    char data[50];
    struct QueueNode* next;
};

// Structure for the queue itself
struct Queue {
    struct QueueNode* front;
    struct QueueNode* rear;
};

// Function to create an empty queue
struct Queue* createQueue() {
    struct Queue* queue = (struct Queue*)malloc(sizeof(struct Queue));
    queue->front = queue->rear = NULL;
    return queue;
}

// Function to check if the queue is empty
int isEmpty(struct Queue* queue) {
    return (queue->front == NULL);
}

// Function to enqueue an element (string) into the queue
void enqueue(struct Queue* queue, char* data) {
    struct QueueNode* newNode = (struct QueueNode*)malloc(sizeof(struct QueueNode));
    strcpy(newNode->data, data);
    newNode->next = NULL;
    
    if (isEmpty(queue)) {
        queue->front = queue->rear = newNode;
    } else {
        queue->rear->next = newNode;
        queue->rear = newNode;
    }
}

// Function to dequeue an element (string) from the queue and print it
void dequeue(struct Queue* queue) {
    if (isEmpty(queue)) {
        printf("Queue is empty.\n");
        return;
    }
    
    struct QueueNode* temp = queue->front;
    printf("Removed from queue: %s\n", temp->data);
    queue->front = temp->next;
    
    free(temp);
}

int main() {
    struct Queue* queue = createQueue();
    char* strings[] = {"Hello", "World", "Queue", "Example"};

    // Enqueue strings into the queue
    for (int i = 0; i < sizeof(strings) / sizeof(strings[0]); i++) {
        enqueue(queue, strings[i]);
    }

    // Dequeue and print values
    while (!isEmpty(queue)) {
        dequeue(queue);
    }

    free(queue); // Free the queue when done
    return 0;
}
