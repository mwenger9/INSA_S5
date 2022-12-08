# L'expérience suit une loi Binomiale (Succès ou échec)

N = 5000 # Nombre d'expériences
n = 10 # Nombre de tirage pour chaque expérience (Ici, nombre de questions dans le qcm)
p = 1/4 # Chance d'un succès

tirage = rbinom(N,n,p)
xb<-cumsum(tirage>=6)/1:N
plot(xb,type='l')

