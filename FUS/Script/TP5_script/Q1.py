import re
# Fonction de recherche des sabotiers
def listePatronymes(nom, dct : dict):
    f = open(nom,'r')
    etat=0
    # …
    for ligne in f:
        res_indiv=re.search(r"\bINDI\b",ligne)
        
        if (etat==0):     # Etat initial
            if res_indiv!=None: # Etat individu détecté
                etat=1
        elif (etat==1):
            if res_indiv:
                etat=1
                continue
            res=re.search(r"\bNAME\b",ligne)
            if res:
                etat = 2
                res_nom_famille = re.search(r"/.*/",ligne).group(0)[1:-1]
                if(res_nom_famille not in dct):
                    dct[res_nom_famille] = 1
        elif (etat==2):
            res = re.search(r"\bOCCU\b",ligne)
            if res_indiv:
                etat=1
            elif res:
                etat = 3
                if "sabot" in ligne:
                    dct[res_nom_famille] += 1
        elif (etat==3):
                if res_indiv: # Etat individu détecté
                    etat=1
    f.close()
# Affichage d’un dictionnaire
def affichageDict(dct):
    for c in dct.keys():
        print(c," : ",dct[c])

# Programme principal
if __name__ == "__main__":

    dct={}
    listePatronymes("sabotiers.ged.txt",dct)
    affichageDict(dct)
