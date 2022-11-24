hors_d_oeuvre(artichauts_Melanie).
hors_d_oeuvre(truffes_sous_le_sel).
hors_d_oeuvre(cresson_oeuf_poche).

viande(grillade_de_boeuf).
viande(poulet_au_tilleul).

poisson(bar_aux_algues).
poisson(saumon_oseille).

dessert(sorbet_aux_poires).
dessert(fraises_chantilly).
dessert(melon_en_surprise).

calories(artichauts_Melanie, 150).
calories(truffes_sous_le_sel, 202).
calories(cresson_oeuf_poche, 212).
calories(grillade_de_boeuf, 532).
calories(poulet_au_tilleul, 400).
calories(bar_aux_algues, 292).
calories(saumon_oseille, 254).
calories(sorbet_aux_poires, 223).
calories(fraises_chantilly, 289).
calories(melon_en_surprise, 122).


plat_resistance(P):-
    poisson(P).

plat_resistance(P):-
    viande(P).

repas(Hd,Plat,Dessert):-
    hors_d_oeuvre(Hd),
    plat_resistance(Plat),
    dessert(Dessert).

plat200_400(P):-
    plat_resistance(P),
    calories(P,C),
    C >= 200,
    C =< 400.

platPlusGrasBarAlgues(P):-
    calories(bar_aux_algues,C),
    calories(P,C2),
    C2 > C.


valCalorique(Hd,Plat,Dessert,ValCalo):-
    repas(Hd,Plat,Dessert),
    calories(Hd,CaloHd),
    calories(Plat,CaloPlat),
    calories(Dessert,CaloDessert),
    ValCalo is CaloHd + CaloPlat + CaloDessert.

repasEquilibre(Hd,Plat,Dessert):-
    repas(Hd,Plat,Dessert),
    valCalorique(Hd,Plat,Dessert,ValCalo),
    ValCalo < 800.


