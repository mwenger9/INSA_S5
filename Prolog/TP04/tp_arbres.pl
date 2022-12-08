arbre_binaire(vide).
arbre_binaire(arb_bin(R,G,D)):-
    integer(R),
    arbre_binaire(G),
    arbre_binaire(D).

dans_arbre_binaire(E,arb_bin(E,_,_)).
dans_arbre_binaire(E,arb_bin(_,G,D)):-
    \==(E,R),
    dans_arbre_binaire(E,G);
    dans_arbre_binaire(E,D).

sous_arbre_binaire(arb_bin(R,G,D),arb_bin(R,G,D)).
sous_arbre_binaire(S,arb_bin(R2,G2,D2)):-
    sous_arbre_binaire(S,G2);
    sous_arbre_binaire(S,D2).




remplacer(SA1,SA2,SA1,SA2).
remplacer(SA1,SA2,vide,vide).

remplacer(SA1,SA2,arb_bin(E,G,D),arb_bin(E2,G2,D2)):-
    \==(SA1,arb_bin(E,G,D)),
    remplacer(SA1,SA2,G,G2),
    remplacer(SA1,SA2,D2,D2).
    

isomorphes(B,B).
isomorphes(arb_bin(E1,G1,D1),arb_bin(E1,D1,G1)).
isomorphes(arb_bin(E1,G1,D1),arb_bin(E2,G2,D2)):-
    isomorphes(G1,G2),
    isomorphes(D1,D2).


infixe(vide,[]).
infixe(arb_bin(R,G,D),L):-
    infixe(G,L1),
    append(L1,[R],L2),
    infixe(D,L3),
    append(L2,L3,L).

insertion_arbre_ordonnee(X,vide,arb_bin(X,vide,vide)).
insertion_arbre_ordonnee(X,arb_bin(E,G,D),arb_bin(E2,G2,D2)):-
    X > E,
    insertion_arbre_ordonnee(X,D,D2).

insertion_arbre_ordonnee(X,arb_bin(E,G,D),arb_bin(E2,G2,D2)):-
    X < E,
    insertion_arbre_ordonnee(X,G,G2).

%arb_bin(3,arb_bin(4,vide,vide),arb_bin(5,arb_bin(6,vide,vide),arb_bin(7,vide,vide)))
%arb_bin(3,arb_bin(5,arb_bin(6,vide,vide),arb_bin(7,vide,vide)),arb_bin(4,vide,vide))
arb_bin(8,arb_bin(4,arb_bin(2,vide,vide),arb_bin(6,vide,vide)),arb_bin(12,arb_bin(10,vide,vide),vide))
%infixe(arb_bin(1, arb_bin(2, arb_bin(6, vide, vide), vide), arb_bin(3, arb_bin(4, vide, vide), arb_bin(5, vide, vide))),L)