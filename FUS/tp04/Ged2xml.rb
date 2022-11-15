#!/usr/bin/ruby

# Message donnant la syntaxe d'utilisation
syntaxe="Usage : #{$0} FichierOrigine.ged FichierResultat.txt"

# Vérification du nombre de paramètres
# Pour calculer le nombre de paramètres, on utilise la fonction ...
nbarg=ARGV.size
if (nbarg!=2) then abort syntaxe ; end

# Renommage des paramètres
(entree, sortie)=ARGV

# Vérification de l'existence des fichiers
if (! File.exist?(entree))
	abort "\t[Erreur: Le fichier d'entrée #{entree} n'existe pas]\n";
end
=begin
if (File.exist?(sortie))
	abort "\t[Erreur: Le fichier de sortie #{sortie} existe déjà]\n";
end
=end

# Ouverture du fichier d'entrée
begin
	fe=File.open(entree,"r") 
	rescue Errno::ENOENT
		abort "\t[Erreur: Echec d'ouverture du fichier d'entrée #{entree}]\n"
end

# Ouverture du fichier de sortie
=begin
begin
	fs=File.open(sortie,"w") 
	rescue Errno::ENOENT
		abort "\t[Erreur: Echec d'ouverture du fichier de sortie #{sortie}]\n"
end
=end

# Redirection du fichier de sortie vers la sortie standard dans la phase de test
fs=STDOUT

# Boucle de lecture du fichier d'entrée
begin

	ancien_NumImbr = -1
	tab = []
	fs.print("<GEN>")
	while line=fe.readline
		#fs.print line

		# Retrait des blancs en fin de ligne
		# Séparation des lignes en 2 parties : le chiffre et le reste
		if (line =~ /(\d)(.*)/)
			nbImbric = $1.to_i
			reste = $2
		end
		# Fermeture des balises (à faire en dernier)
		if ancien_NumImbr == nbImbric
			bal = tab.pop
			fs.print("</",bal,">\n")
		
		elsif ancien_NumImbr > nbImbric
			tmp = ancien_NumImbr - nbImbric + 1
			for a in 1..tmp do
 				bal = tab.pop
				fs.print("</",bal,">\n") 
			end
		else
			fs.print("\n")
		end
		# Sélection des lignes de la classe des identificateurs @...@ (INDI,FAM)
		if (reste =~ /@(.*)@\s*(INDI|FAM)$/)
			balise=$2
			fs.print("<#{balise} ID=",'"',$1,'">')
		# Sélections des lignes de la classe NAME
		
		elsif (reste =~ /(NAME)\s+(.*)\/(.*)\//)
			balise=$1
			fs.print("<NAME>",$2,"<S>",$3,"</S>")


		# Sélection des lignes avec un identificateur de fin (FAMS, FAMC, HUSB, WIFE, CHIL...)
		elsif (reste =~ /(FAMS|FAMC|HUSB|WIFE|CHIL)\s+@(.*)@$/)
			balise=$1
			fs.print("<",$1,' REF="',$2,'">')
			
		# ...
		elsif(reste =~ /(BIRT|DEAT|MARR|MARC)$/)
			balise=$1
			fs.print('<EVEN EV="',$1,'">')
		
		elsif(reste=~/(SEX|OCCU|DATE|PLAC)\s+(.*)/)
			balise=$1
			fs.print("<#{$1}> #{$2}")
		#Cas non prévus
		else
			print("Ligne non prévue: #{line}\n") 	
		end

		# Mémorisation de l'ancien niveau
		ancien_NumImbr = nbImbric
		tab.push(balise)
		
	end
	rescue EOFError
end
# Fermeture des balises non fermées
for a in tab do
 	bal = tab.pop
	fs.print("</",bal,">\n")
end

	
fs.print("</GEN>\n")

fe.close
#fs.close





