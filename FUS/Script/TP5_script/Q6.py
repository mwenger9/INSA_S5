class AutomateNomProf(Automate):
    # Constructeur
    def __init__(self):
        super().__init__()

        # Description de l'automate
        self.reIndi=["0…INDI…$",1, self.traitIndi]
        self.reName=["1…NAME…$",2, self.traitName]
        self.reOccu=["1…OCCU…$",3, self.traitOccu]
        self.automateDon={0: [self.reIndi],
                         1: [self.reName, self.reIndi],
                         2: [self.reOccu, self.reIndi],
                         3: [self.reIndi]}

    # Traitement spécifique pour une ligne donnée
    def traitIndi(self,m1):
        return
    def traitName(self,m1):
        …
    def traitOccu(self,m1):
        # Gestion du cas où le nom n’est pas présent
        …
        # Séparation des professions
        …
        # Balayage des professions séparées
        for p in prof:
            # Cas d'une profession existante
            if (…):
                …
            else:
                # Cas où la profession qui n'existe pas
                …

    # Impression de la structure
    def afficher(self):
        for cle1 in self.struct.keys():
            print(cle1," : ",end="")
            for cle2 in self.struct[cle1].keys():
                print(cle2+" ("+str(self.struct[cle1][cle2])+")",end=", ")