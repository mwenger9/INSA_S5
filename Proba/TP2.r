# Moyenne et écart type

moyenne = mean(michelson$Speed)
#print(moyenne)
ecartType = sd(michelson$Speed)
#print(ecartType)

# Calcul de la moyenne empirique
xb<-cumsum(michelson$Speed)/1:100


#print(xb)

#plot(xb,type='l')
# On voit que ça prend de grandes valeurs au début, puis ça converge vers 852

# On garde 852 (Loi des grands nombres)

# On trace l'histogramme des vitesses, on met freq à false pour pas avoir les fréquences en y (pour superposer dnorm)
hist(michelson$Speed,freq = F,col="yellow")
curve(dnorm(x,mean = moyenne,sd = ecartType),add = T,col="red")



# Fait la moyenne des speed par Expt (celles qui ont Expt en commun)
moy_par_expt = tapply(michelson$Speed,michelson$Expt, mean)

hist(moy_par_expt,freq=F,add=T)
# Pour trouver la loi que X20 suit on utilise le théorème central limite
# X20 suit la loi N(moyenne, ecartType / sqrt(20) ) 
curve(dnorm(x,mean = moyenne,sd = (ecartType / sqrt(20))),add = T,col="red")
