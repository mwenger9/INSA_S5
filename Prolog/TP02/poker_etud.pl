
% TP2 TERMES CONSTRUITS - A compl�ter et faire tourner sous Eclipse Prolog
% ==============================================================================
% ============================================================================== 
%	FAITS
% ============================================================================== 

  /*
	hauteur(Valeur)
*/
hauteur(deux).
hauteur(trois).
hauteur(quatre).
hauteur(cinq).
hauteur(six).
hauteur(sept).
hauteur(huit).
hauteur(neuf).
hauteur(dix).
hauteur(valet).
hauteur(dame).
hauteur(roi).
hauteur(as).

/*
	couleur(Valeur)
*/
couleur(trefle).
couleur(carreau).
couleur(coeur).
couleur(pique).

/*
	succ_hauteur(H1, H2)
*/
succ_hauteur(deux, trois).
succ_hauteur(trois, quatre).
succ_hauteur(quatre, cinq).
succ_hauteur(cinq, six).
succ_hauteur(six, sept).
succ_hauteur(sept, huit).
succ_hauteur(huit, neuf).
succ_hauteur(neuf, dix).
succ_hauteur(dix, valet).
succ_hauteur(valet, dame).
succ_hauteur(dame, roi).
succ_hauteur(roi, as).

/*
	succ_couleur(C1, C2)
*/
succ_couleur(trefle, carreau).
succ_couleur(carreau, coeur).
succ_couleur(coeur, pique).

/*
  carte_test
  cartes pour tester le pr�dicat EST_CARTE
*/

carte_test(c1,carte(sept,trefle)).
carte_test(c2,carte(neuf,carreau)).
carte_test(ce1,carte(7,trefle)).
carte_test(ce2,carte(sept,t)).

/*
  main_test
  main pour tester vos pr�dicats. 
  par exemple le but main_test(main_triee_brelan,X) vous permet de r�cup�rer
  dans X une main tri�e qui contient un brelan.
*/

main_test(main_triee_une_paire, main(carte(sept,trefle), carte(valet,coeur), carte(dame,carreau), carte(dame,pique), carte(roi,pique))).
% attention ici m2 repr�sente un ensemble de mains	 
main_test(m2, main(carte(valet,_), carte(valet,coeur), carte(dame,carreau), carte(roi,coeur), carte(as,pique))).
main_test(main_triee_deux_paires, main(carte(valet,trefle), carte(valet,coeur), carte(dame,carreau), carte(roi,coeur), carte(roi,pique))).
main_test(main_triee_brelan, main(carte(sept,trefle), carte(dame,carreau), carte(dame,coeur), carte(dame,pique), carte(roi,pique))).	
main_test(main_triee_suite,main(carte(sept,trefle),carte(huit,pique),carte(neuf,coeur),carte(dix,carreau),carte(valet,carreau))).
main_test(main_triee_full,main(carte(deux,coeur),carte(deux,pique),carte(quatre,trefle),carte(quatre,coeur),carte(quatre,pique))).

main_test(merreur1, main(carte(sep,trefle), carte(sept,coeur), carte(dame,pique), carte(as,trefle), carte(as,pique))).
main_test(merreur2, main(carte(sep,trefle), carte(sept,coeur), carte(dame,pique), carte(as,trefle))).



% ============================================================================= 
%        QUESTION 1 : est_carte(carte(Hauteur,Couleur))
% ==============================================================================

est_carte(carte(Hauteur,Couleur)):-
  hauteur(Hauteur),
  couleur(Couleur).


% ==============================================================================
%	QUESTION 2 : est_main(main(C1,C2,C3,C4,C5))
%        faire les tests diff�rents des que l on peut permet d �laguer l arbre et donc de gagner en temps d ex�cution .
%        (la phrase ci-dessus r�pond elle a l histoire du micro seconde dans l ennonce )
% ============================================================================== 

est_main(C1,C2,C3,C4,C5):-
  est_carte(C1),
  est_carte(C2),
  \==(C1,C2),
  est_carte(C3),
  \==(C1,C3),
  \==(C2,C3),
  est_carte(C4),
  \==(C1,C4),
  \==(C2,C4),
  \==(C3,C4),
  est_carte(C5),
  \==(C1,C5),
  \==(C2,C5),
  \==(C3,C5),
  \==(C4,C5).


% ============================================================================= 
%       QUESTION 3  inf_carte(carte(_,_),carte(_,_))
% ============================================================================= 

est_hauteur_inf(H1,H2):-
  succ_hauteur(H1,H2).

est_hauteur_inf(H1,H2):-
  succ_hauteur(H1,X),
  est_hauteur_inf(X,H2).

est_couleur_inf(C1,C2):-
  succ_couleur(C1,C2).

est_couleur_inf(C1,C2):-
  succ_couleur(C1,X),
  est_couleur_inf(X,C2).

inf_carte(carte(H1,_),carte(H2,_)):-
  est_hauteur_inf(H1,H2).

inf_carte(carte(H1,C1),carte(H2,C2)):-
  H1 == H2,
  est_couleur_inf(C1,C2).


% ============================================================================= 
%       QUESTION 4 : est_main_triee(main(C1,C2,C3,C4,C5))
% ============================================================================= 

est_main_triee(main(C1,C2,C3,C4,C5)):-
  inf_carte(C1,C2),
  inf_carte(C2,C3),
  inf_carte(C3,C4),
  inf_carte(C4,C5).


% ============================================================================= 
%       QUESTION 5 : une_paire(main(carte(_,_),carte(_,_),carte(_,_),carte(_,_),carte(_,_)))
% ============================================================================== 

une_paire(M):-
  est_main_triee(M),
  une_paire_triee(M).

une_paire_triee(main(carte(H,_),carte(H,_),_,_,_)).
une_paire_triee(main(_,carte(H,_),carte(H,_),_,_)).
une_paire_triee(main(_,_,carte(H,_),carte(H,_),_)).
une_paire_triee(main(_,_,_,carte(H,_),carte(H,_))).
  

% ============================================================================= 
%       QUESTION 6 : deux_paires(main(carte(_,_),carte(_,_),carte(_,_),carte(_,_),carte(_,_)))
% ============================================================================= 

deux_paires(M):-
  est_main_triee(M),
  deux_paires_triee(M).

deux_paires_triee(main(_,carte(H,_),carte(H,_),carte(H,_),carte(H,_))).
deux_paires_triee(main(carte(H,_),carte(H,_),carte(H,_),carte(H,_),_)).


% ==============================================================================
%       QUESTION 7 : brelan(main(carte(_,_),carte(_,_),carte(_,_),carte(_,_),carte(_,_)))
% ==============================================================================

brelan(M):-
  est_main_triee(M),
  brelan_triee(M).

brelan_triee(main(carte(H,_),carte(H,_),carte(H,_),_,_)).
brelan_triee(main(_,carte(H,_),carte(H,_),carte(H,_),_)).
brelan_triee(main(_,_,carte(H,_),carte(H,_),carte(H,_))).

   


% ============================================================================= 
%       QUESTION 8 : suite(main(carte(_,_),carte(_,_),carte(_,_),carte(_,_),carte(_,_)))
% ============================================================================= 

suite(carte(H1,_),carte(H2,_),carte(H3,_),carte(H4,_),carte(H5,_)):-
  succ_hauteur(H1,H2),
  succ_hauteur(H2,H3),
  succ_hauteur(H3,H4),
  succ_hauteur(H4,H5).



% ============================================================================= 
%       QUESTION 9 : full(main(carte(_,_),carte(_,_),carte(_,_),carte(_,_),carte(_,_)))
% =============================================================================

full(M):-
  est_main_triee(M),
  full_triee(M).


full_triee(carte(H,_),carte(H,_),carte(H,_),carte(H2,_),carte(H2,_)).
full_triee(carte(H,_),carte(H,_),carte(H2,_),carte(H2,_),carte(H2,_)).
  



