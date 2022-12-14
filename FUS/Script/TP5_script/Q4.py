from Q2 import Automate

class AutomateComptage(Automate):
    # Constructeur
    def __init__(self):
        super().__init__()
        self.struct["Nombre occurences"]=0
        # Description de l'automate
        self.automateDon={0: [[...,0,...]]}

    # Traitement spécifique pour une ligne donnée
    def trait(self,m1):
        ...