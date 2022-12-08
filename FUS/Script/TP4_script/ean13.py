# -*- coding: utf-8 -*-
"""
Created on Sat Jan  6 08:30:18 2018

@author: leplumey

Module de gestion des codes-barres
"""

# Importation module expressions régulières
import re

class EAN13:
    LGEAN13=13
    
    def __init__(self,code="3333299304137"):
        self.code=code
        self.valide=self.verification()
        
    # Vérification du code-barre et ajout si nécessaire du chiffre de contrôle    
    def verification(self):
        if re.compile("\D").search(self.code)!=None:
            return(False)

        if(len(self.code) == 13):
            return True
        elif(len(self.code) == 12):
            self.code = self.code + self.cle()
            return True
        return(True)
    
    # Calcul du chiffre de contrôle rendu sous forme de chaine de caractères        
    def cle(self):
        fact_mult = [1,3,1,3,1,3,1,3,1,3,1,3]
        # res = 0
        try:
            checksum = sum(map(lambda e : int(e[0]) * e[1],zip([l for l in self.code],fact_mult)))

            # for i in range(len(self.code)):
            #     chiffre = int(self.code[i])
            #     res += chiffre * fact_mult[i]
        except:
            print("clé incorrecte")
            exit()

        reste = checksum % 10
        return str(0 if not reste else 10-reste)  
        
# Programme principal
if __name__ == "__main__":
    ean13=EAN13("333329930413")
    print(ean13.verification())
    print(ean13.cle())

    # Liste de DVD récents
    lst=["3333299304137","3344428069940","3475001049988","3475001052476","3475001054487",\
         "3700724902778","5051889599852","5051889606659","5051889606666","7321950126194"]
    print("Test de la classe EAN13 sur {0} codes".format(len(lst)))
    for i in range(len(lst)):
        ean13=EAN13(lst[i])
