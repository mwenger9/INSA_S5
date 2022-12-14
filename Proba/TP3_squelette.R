
# Calcul de quantile

## Q1) Quelle est la loi exacte suivie par X, son esperance, son ecart type ?

# X suit une loi Binomiale B(n,0.75).
# E(X) = np
# sd(X) = np(1-p)

## Q2) on suppose que la compagnie vend n=150 billets. La compagnie est sur à 95% d avoir combien de personnes max ? 
# On calcule le quantile
valmax = (qbinom(0.95,150,0.75))

## Q3) Quel est le nombre maximum de places que la compagnie peut vendre pour etre sur a 95% de ne rembourser personne, c est à dire d être sûre que tout le monde puisse monter dans l avion ?

# On incrément i jusqu'à ce que qu'on soit sûr à 95% d'obtenir 150

i = 151
while(valmax < 150){
  valmax = qbinom(0.95,i,0.75)
  i = i + 1
}
print(i)



## Q4) idem avec 300 places et p=0.5 puis p=0.8
#300 places p=0.5

i = 300
valmax = (qbinom(0.95,300,0.5))
while(valmax < 300){
  valmax = qbinom(0.95,i,0.5)
  i = i + 1
}
print("Pour 300 places et p = 0.5 : ")
print(i)




#300 places p=0.8
i = 300
valmax = (qbinom(0.95,300,0.8))
while(valmax < 300){
  valmax = qbinom(0.95,i,0.8)
  i = i + 1
}
print("Pour 300 places et p = 0.8 : ")
print(i)


# Intervalles de confiance de la moyenne
## Q5) récupération des données

vitesse = read.csv2("vitesse.csv")
print(vitesse)

## Q6) Calcul de la moyenne par semaine
moyennes = tapply(vitesse$vecVitesses, vitesse$vecNum, mean)
print(moyennes)


## Q7) Intervalle de confiance de la moyenne par semaine
# On cherche l'intervalle de confiance de la moyenne
# Cf diapo 61 du cours, on pose le Z, on sait qu'on veut un intervalle de 95% (donc 2,5% de chaque côté)
#D'où v1 et v2 
v1 = qnorm(0.025)
v2 = qnorm(0.975)

IC_moy_inf = moyennes - ((10/sqrt(6)) * v2)
IC_moy_sup = moyennes - ((10/sqrt(6)) * v1)


## Q8) Pourcentage ou valeur réelle dans IC
taille = min(length(IC_moy_inf),length(IC_moy_sup))
res = 0
for(i in 1:taille){
  if(IC_moy_inf[i] > 120 | 120 > IC_moy_sup[i]){
    res = res + 1
  }
}

print(res/taille)



## Q9) Plot des intervalles de confiance de la moyenne

nbAff<-40
plot(c(IC_moy_inf[1:nbAff],IC_moy_sup[1:nbAff]),c(1:nbAff,1:nbAff),pch=4,
    xlab = "intervalles de confiance de la moyenne", ylab="numéro de semaine")
for(i in 1:nbAff){
 segments(IC_moy_inf[i],i,IC_moy_sup[i],i)
}
abline(v=120,col="red")


# Distribution de la variance

## Q10) Calcul de la variance par semaine

variances = tapply(vitesse$vecVitesses, vitesse$vecNum, var)
print(variances)

## Q11) Variable étudiée

# La loi du Khi 2

## Q12) Valecur de cette variable par semaine



## Q13) affichage de la distribution de la variance


# Intervalles de confiance de la variance
## Q14) Calcul des intervalles de confiance de la variance


## Q15) IC de la variance pour chaque semaine


## Plot des intervalles de confiance de l'écart type par semaine

#nbAff=40
#print(IC_moy_inf[1:nbAff])
#IC_sd_inf=sapply(IC_var_inf,sqrt)
#IC_sd_sup=sapply(IC_var_sup,sqrt)
#plot(c(IC_sd_inf[1:nbAff],IC_sd_sup[1:nbAff]),c(1:nbAff,1:nbAff),pch=4,
#     xlab = "intervalles de confiance de l écart type", ylab="numéro de semaine")
#for(i in 1:nbAff){
#  segments(IC_sd_inf[i],i,IC_sd_sup[i],i)
#}
#abline(v=10,col="red")
