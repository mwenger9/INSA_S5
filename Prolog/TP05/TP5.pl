
entier(zero).
entier(s(X)):-
    entier(X).

add(zero,N,N).

add(s(X),Y,s(Res)):-
    add(X,Y,Res).

sub(N,zero,N).
sub(s(X),s(Y),Res):-
    sub(X,Y,Res).

prod(X,zero,zero).
prod(X,s(Y),Res):-
    prod(X,Y,R2),
    add(X,R2,Res).

factorial(zero,s(zero)).
factorial(s(X),Res):-
    factorial(X,R2),
    prod(s(X),R2,Res).

%add_bit(?, ?, ?, ?, ?): bit * bit * bit * bit * bit
%add_bit(Bit1, Bit2, CarryIn, Res, CarryOut)
add_bit(0, 0, 0, 0, 0).
add_bit(0, 0, 1, 1, 0).
add_bit(0, 1, 0, 1, 0).
add_bit(0, 1, 1, 0, 1).
add_bit(1, 0, 0, 1, 0).
add_bit(1, 0, 1, 0, 1).
add_bit(1, 1, 0, 0, 1).
add_bit(1, 1, 1, 1, 1).

add_bit_list([],[],Res).

add_bit_list(N,M,Res):-
    add_carry(N,M,0,Res).

add_carry([],[],0,[]).
add_carry([],[],1,[1]).

add_carry([E1|R1],[],CarryIn,[R|Res]):-
    add_bit(E1,0,CarryIn,R,CarryOut),
    add_carry(R1,[],CarryOut,Res).

add_carry([],[E1|R1],CarryIn,[R|Res]):-
    add_bit(0,E1,CarryIn,R,CarryOut),
    add_carry([],R1,CarryOut,Res).



add_carry([E1|R1],[E2|R2],CarryIn,[R|Res]):-
    add_bit(E1,E2,CarryIn,R,CarryOut),
    add_carry(R1,R2,CarryOut,Res).

% Faire sub avec les propriété de l'addition


