#!/usr/bin/ruby -p

$_.gsub!(/\s+/,"")

=begin
File.open("source.c","r") { |f|
	f.each { |line|
		if (line=~/^[ 	]* [a-zA-Z][a-z-A-Z0-9]*[ 	]*:/) then print "#{line}\n"; end
	}
	f.close
}
=end
