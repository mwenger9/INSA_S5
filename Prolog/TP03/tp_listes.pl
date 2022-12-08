
membre(A,[A|_]).
membre(A,[_|R]):-
    membre(A,R).

compte(_,[],N):-
    N is 0.

compte(A,[A|R],N):- 
    compte(A,R,M),
    N is M + 1.    

compte(A,[_|R],N):-
    compte(A,R,N).

renverser(X,Y):-
    renv(X,[],Y).

renv([],Y,Y).

renv([X1|R1],A,Y):-
    renv(R1,[X1|A],Y).

palind([]).
palind([X|[]]).
palind(L):-
    renverser(L,L).

enieme(0,[X|R],A):-
    A is X.

enieme(_,[],A):-
    fail.

enieme(N,[X|R],A):-
    M is N-1,
    enieme(M,R,A).

hors_de(_,[]).
hors_de(A,[A|R]):-
    fail.
hors_de(A,[X|R]):-
    \==(A,X),
    hors_de(A,R).

tous_diff([]).
tous_diff([X|R]):-
    not(membre(X,R)),
    tous_diff(R).



concat([],L,L).
concat([X1|L1],L2,[X1|L3]):-
    concat(L1,L2,L3).



debute_par([],_).
debute_par([X|R],[X|R2]):-
    debute_par(R,R2).

sous_liste([],_).
sous_liste(X,[E|R]):-
    debute_par(X,[E|R]);
    sous_liste(X,R).

elim([],Y).
elim([E|R],Y):-
    hors_de(E,Y),
    elim(R,[E|Y]).
    



