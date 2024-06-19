#include "Tree.h"

int count;
TNode* left;
TNode* right;

TNode treeCreate(){
    count = 0;
    left = right = NULL;
    return true;
}

TNode treeAdd(TPerson newPerson){
    TNode* newNode = (TNode*) malloc(sizeof(TNode));
    newNode->person = newPerson;
    newNode->id = rand();
    newNode->left = newNode->right = NULL;
}


