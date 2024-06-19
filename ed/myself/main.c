#include "Tree.h"

void printTree(TNode* node, int indent){
    for (int i=0; i<indent; i++){
        printf("-");
    }

    if (node!=NULL){
        printf("%i\n", node->id);
        printTree(node->left, indent+2);
        printf("\n");
        printTree(node->right, indent+2);
    } else printf("Empty");
}


void menu(){
    TPerson* person;

    printf("Menu:\n");
    printf("Type your name:\n");
    scanf("%s", &(person->name));
    printf("Type your age:\n");
    scanf("%i", &(person->age));
    printf("\n\n");
    printf("Name:%s\nAge:%i", &(person->name), person->age);
    treeAdd(TPerson person);
}

int main()
{
    menu();
    return 0;
}
