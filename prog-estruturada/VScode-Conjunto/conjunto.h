#include <stdio.h>
#include <stdlib.h>


#ifndef CONJUNTO_H_INCLUDED
#define CONJUNTO_H_INCLUDED

typedef int Tipo;

typedef int Logic;
#define TRUE 1
#define FALSE 0

typedef int Result;
#define GT 1
#define EQUAL 0
#define LT -1

Result comparar(Tipo a, Tipo b){
    if (a > b) return GT;
    if (a == b) return EQUAL;
    return LT;
}


//typedef void (*funcaoDeForaQueImprime)(Tipo);// ponteiro para função
//typedef Result (*funcaoDeForaQueCompara)(Tipo, Tipo);// ponteiro para função

Logic setsCreate();
Logic setsAddElement(char c1, Tipo e);
Logic setsRemoveElement(char c1, Tipo e);
Logic setsBelongsTo(char c1, Tipo e);
Logic setsUnion(char c1, char c2, char c3);
Logic setsIntersection(char c1, char c2, char c3);
Logic setsNumberOfElements(char c1, int *total);
Logic setsIsIn(char c1, char c2, Logic *result);
Logic setsDestroy();

#endif // CONJUNTO_H_INCLUDED
