

% Tests

tests :-
    test(test_plat),
    test(test_repas),
    test(test_plat200_400),
    test(test_plat_bar),
    test(test_val_cal),
    test(test_repas_eq).

test_plat :-
    assert_true( plat_resistance(grillade_de_boeuf) ),
    assert_true( plat_resistance(saumon_oseille) ),
    assert_true( not (plat_resistance(artichauts_Melanie)) ),
    assert_true( not (plat_resistance(sorbet_aux_poires)) ).

test_repas :-
    assert_true( repas(cresson_oeuf_poche, poulet_au_tilleul, fraises_chantilly) ),
    assert_true( not (repas(melon_en_surprise, poulet_au_tilleul, fraises_chantilly)) ).

test_plat200_400 :-
    assert_true( sortall(P, plat200_400(P), [bar_aux_algues, poulet_au_tilleul, saumon_oseille]) ).

test_plat_bar :-
    assert_true( sortall(P, platPlusGrasBarAlgues(P), [grillade_de_boeuf, poulet_au_tilleul]) ).

test_val_cal :-
    assert_true( valCalorique(cresson_oeuf_poche, poulet_au_tilleul, fraises_chantilly, 901) ),
    assert_true( not (valCalorique(truffes_sous_le_sel, grillade_de_boeuf, sorbet_aux_poires, 901) )).

test_repas_eq :-
    assert_true( repasEquilibre(artichauts_Melanie, saumon_oseille, fraises_chantilly) ),
    assert_true( not (repasEquilibre(truffes_sous_le_sel, grillade_de_boeuf, sorbet_aux_poires)) ).

% SortedList donne la liste triee de toutes les solutions de Term dans le but Goal 
sortall(Term, Goal, SortedList) :- 
    findall(Term, Goal, List),
    msort(List, SortedList).

% Teste la propriete P et affiche ensuite "OK : P" ou "echec : P" 
test(P) :- P, !, printf("OK : %w \n", [P]).
test(P) :- printf("echec : %w \n", [P]), fail.

% Teste la propriete P et affiche ensuite "echec : P", ou rien si succès
assert_true(P) :- P, !.
assert_true(P) :- printf("echec : %w \n", [P]), fail.



% Fin des tests.

