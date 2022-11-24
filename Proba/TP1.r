# pipo <- "du texte"
# doc <- 33
# print(paste(pipo,doc))
# 
# variables <- ls()
# print("Les variables de mon espace personnel sont :")
# print(variables)
# 
# 
# pipo <- "une variable texte"
# nombre <- 3
# rm(pipo)
# help(rm)
# 
# texte <- "33"
# print(typeof(texte))
# nbr <- as.integer(texte)
# print(is.numeric(nbr))
# print(typeof(nbr))

# mot <- "petite"
# text1 <- paste("une", mot, "phrase")
# text2 <- paste(text1, "compte", nchar(text1), "lettres")
# print(text2)

# tmp <- 3 / 0
# nsp <- NA
# resultat <- paste(tmp, tmp+1, tmp+nsp)
# print(resultat)

# vecteur1 <- c(1, 3, 5, 7, 9)
# vecteur2 <- seq(from=0, to=10, by=2)
# vecteur3 <- 0:10
# vecteur4 <- rep(1:2, 5)

# print(vecteur1)
# print(vecteur2)
# print(vecteur3)
# print(vecteur4)

# print(vecteur1[1])

# v1 <- c(175, 182, 165, 187, 158)
# v2 <- c(19, 18, 21, 22, 20)
# v3 <- c("Louis", "Paule", "Pierre", "Rémi", "Claude")
# tableau <- data.frame(prenom=v3, taille=v1, age=v2)
# print(names(tableau))
# print(tableau$prenom)
# write.table(tableau, "sortie.csv", sep=";",row.names = FALSE, col.names =FALSE)


# curve(dnorm(x,mean = 0,sd=0.3),from=-1,to=1)
# curve(dnorm(x,mean = 0,sd=0.4),add=T,col="red")
# curve(dnorm(x,mean = 0,sd=0.5),add=T,col="green")
# 
# x <- 0:10
# y <- dbinom(x,size=10,prob=0.2)
# 
# plot(x,y,type='h',lwd=30,lend="square",ylab="P(X=x)")

nbElem <- 20
data <- rnorm(nbElem,mean=1,sd=3)
#print(data)

#hist(data,freq=F)

# curve(dexp(x,rate=2),from=0,to=1)
# curve(dexp(x,rate = 1),add=T,col="red")
# curve(dexp(x,rate = 0.5),add=T,col="green")
# data_exp <- rexp(80,rate=2)
# hist(data_exp,freq = F)
# curve(dnorm(x,mean=1/2,sd=1/2),add=T)

Urne <- function(k, p, q) {
  u = c("Rouge","Noir")
  print(sample(u,replace=TRUE,size=k))
}

Urne(6,8,5)




