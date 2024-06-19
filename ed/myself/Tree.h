#include <stdio.h>
#include <stdlib.h>

#ifndef TREE_H_INCLUDED
#define TREE_H_INCLUDED

typedef struct person {
    char name;
    int age;
}TPerson;

//typedef TPerson PersonType;

typedef struct node {
    int id;
    TPerson* person;
    struct node* left;
    struct node* right;
} TNode;

TNode treeCreate();
TNode treeAdd(TPerson person);


#endif // TREE_H_INCLUDED
