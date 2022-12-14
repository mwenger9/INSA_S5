
make_paires(X,[],[likes(X,X)]).
make_paires(X,[Y|R],[likes(X,Y),likes(Y,X)|R2]):-
    make_paires(X,R,R2).


make_all_paires([],[]).
make_all_paires([X|R],Res):-
    make_all_paires(R,R1),
    make_paires(X,R,Res2),
    append(R1,Res2,Res).


sub_list([],[]).
sub_list([X|R],[X|Res]):-
    sub_list(R,Res).
sub_list([_|R],Res):-
    sub_list(R,Res).


proposition1([likes(dana,cody)|R]).
proposition1([likes(X,Y)|R]):-
    proposition1(R).


proposition2([]).
proposition2([likes(bess,dana)|R]):-
    fail.
proposition2([likes(X,Y)|R]):-
    \==(X,bess);
    \==(Y,dana),
    proposition2(R).


proposition3([]).
proposition3([likes(cody,abby)|R]):-
    fail.
proposition3([likes(X,Y)|R]):-
    \==(X,cody);
    \==(Y,abby),
    proposition3(R).


% member(X,[X|R]).
% member(X,[E|R]):-
%     member(X,R).

%proposition4TMP([likes(X,Y)|R1],[likes(Y,X)|R]).
proposition4TMP([likes(X,Y)|R1],M):-
    member(likes(Y,X),M),
    proposition4TMP(R1,M).

proposition4([]).
proposition4(M):-
    proposition4TMP(M,M).

