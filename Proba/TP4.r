
data<-c(1150, 1500, 1700, 1800, 1800, 1850, 2200, 2700, 2900, 3000, 3100, 3500,
        3900, 4000, 5400)


# Ecart type théorique non connu => 

n = length(data)
moy = (mean(data))
ecart_type = sd(data)

v1 <- qt(p=0.05,df=n-1)
v2 <- qt(p=0.95,df=n-1)

borne_sup = moy - (v1*(ecart_type/sqrt(n)))
borne_inf= moy - (v2*(ecart_type/sqrt(n)))

# Test de conformité
# H0 : mu = 3000
# H1 : mu != 3000

mu = 3000

S <- (moy - mu) / (ecart_type/sqrt(n)) 

# Loi suivie : loi de student à n-1 degré de liberté
# Valeurs permettant d'accepter H0 : S dans [v1,v2]
# On accepte H0 car S est compris entre les deux quantiles (v1 et v2)

print(t.test(data,mu=mu,conf.level=0.90))

# p-value > alpha => on accepte H0



###############################################.

# Exercice 2

# Test d'homogénéité, Sigma connu (avec sigma1 = sigma2 = sigma), Loi suivie : student de fd = n1+n2-2
# H0 : mu1 = mu2
# H1 : mu1 != mu2

n1 = 12
n2 = 8

moy1 = 1.5
moy2 = 2.35

sigma1 = 0.95
sigma2 = 1.35

sigma_chapeau_carre = ( ((n1-1)*(sigma1**2)) + ( (n2-1)*(sigma2**2)) ) / (n1 + n2 - 2)
sigma_chapeau_carre_d = sigma_chapeau_carre * ((1/n1) + (1/n2))

sigma_chapeau_d = sqrt(sigma_chapeau_carre_d)
print(sigma_chapeau_d)



D = moy1 - moy2
T = D/sigma_chapeau_d

v1 <- qt(p=0.025,df=n1+n2-2)
v2 <- qt(p=0.975,df=n1+n2-2)

# v1<T<v2 => mu1 = mu2 (H0 validée)




