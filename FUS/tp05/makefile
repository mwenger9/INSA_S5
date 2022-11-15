CC=gcc
CFLAGS= -Wunused
SOURCES=tri.c tableau.c principal.c
OBJETS=$(SOURCES:.c=.o)
include principal.d


principal: $(OBJETS)
	$(CC) $(OBJETS) -o $@

principalR: CFLAGS:=-O3
principalR: $(OBJETS)

clean:
	rm *.o; rm principal
