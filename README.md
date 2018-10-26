    NUME: SOARE ION-ALEXANDRU
    UNIVERSITATEA: POLITEHNICA DIN BUCURESTI
    FACULTATEA: AUTOMATICA SI CALCULATOARE, CTI
    GRUPA SI SERIA: 323 CD
    AN UNIVERSITAR: 2017-2018
    PROFESOR COORDONATOR: ALEXANDRU OLTEANU

------------------LEAGUE OF POO------------------

Tema este structura in 2 pachete, unul main, ce contine clasa Main, conform
cerintei, iar altul denumit "league", care contine implementarea propriu-zisa
a temei. In pachetul "league" sunt prezenta 6 clase, dintre care:
	- 1 este clasa Hero, care defineste eroul si toate caracteristicile lui;
	- 4 clase specifice tipurilor de eroi (Pyro, Knight, Rogue, Wizard);
	- 1 clasa pentru variabile.
	
	VARIABILE SI FUNCTII:

Pentru totalitatea constantelor necesare calcularii abilitatilor au fost
implementate la inceputul clasei Hero variabile de tip static final. Imediat
dupa acestea sunt declarate, modularizat, elementele necesare unui erou:

    - hp = punctele curente de viata;
	- hpInitial = hp-ul de la inceputul jocului, diferit in functie de rasa;
	- hpMax = helper pentru execute-ul knight-ului, hp-ul maxim curent;
	- alive = boolean care arata statusul eroului (true inseamna ca traieste);

	- xp = punctele de experienta actuale;
	- xpPrag = pragul pentru level up (250, 300, 350 etc);
	- level = nivelul eroului;

	- row = linia pentru coordonatele eroului;
	- col = coloana pentru coordonatele eroului;

	- dotValue = cat damage primeste pe tura (damage over time);
	- overTimeCount = cate ture primeste damage over time;
	- overTimeStunCount = cate ture este incapabil de miscare;
	- stun = statusul de incapacitate al eroului (false inseamna ca face mutare);

	- damageDeflected1 = damage ajutator pentru Wizard, de la abilitatea 1;
	- damageDeflected2 = damage ajutator pentru Wizard, de la abilitatea a 2-a;
	- damageAbility1 = damage total de la abilitatea 1;
	- damageAbility2 = damage total de la abilitatea a 2-a;

Pentru fiecare este setat un getter si un setter, ale caror functionalitati
sunt bine cunoscute. Pentru exceptii, le voi detalia mai jos:
	level_up() este facut astfel incat sa fie atat o verificare, cat si un set
pentru level. Astfel, apelat oriunde, mai intai va verifica daca conditia
de level up este satisfacuta, dupa care va incrementa level-ul, va seta
noul prag pentru xp, urmand sa actualizeze hp-urile (max si curent);
	abilitiesTotalDamage si abilitiesPureDamage returneaza suma damage-urilor
abilitatilor 1 si 2, respectiv abilitatilor deflected 1 si 2.

	DESFASURARE GAMEPLAY:

NU este implementat FILE IO-ul pus la dispozitie pe site, citirea si scrie-
rea din fisiere fiind posibila cu ajutorul FileReader, BUfferedReader, 
Scanner, FilePrinter, BUfferedPrinter si IOException. Asadar, in incipit
sunt declarate scanf si printf pentru citirea, respectiv scrierea in fisier.
De asemenea, un string auxiliar pentru a citi restul randului pana la newline
atunci cand nu se mai doreste sa fie citit nimic de pe acea linie.
	Matricea de char-uri, position, contine tipurile land-urilor si creeaza
o prezenta intuitiva a hartii, in timp ce caracterele dispun doar de coordonate
(row si col).
	Rundele se executa prin intermediul unui for, unde sunt verificate statusurile
eroilor de stun, pentru a putea face miscarea. Indiferent daca sunt sau nu morti,
acestia vor efectua miscarile, desi nu vor mai fi vizibile pentru restul, intrucat
acestia au statusul alive = false. Dupa efectuarea miscarilor, se scade damage-ul
over time de care dispun personajele (fiecare erou are setat damage over time,
over time count etc. care reprezinta parametrii ce-i afecteaza pe ei, nu
pe adversarii lor, singurele campuri ce afecteaza adversarii si sunt insusiri
proprii sunt damage-urile de la abilitati, NU deflected). Dupa aceea, se verifica
cu ajutorul a 2 for-uri daca un erou se intalneste cu altul (dupa pattern-ul
a cu urmatorii de la a+1 in sus, a+1 cu urmatorii de la a+2 in sus etc). Daca
2 eroi se intalnesc si au statusurile alive = true, urmeaza sa se dueleze.
	Abilitatile trebuie sa se dea simultan. Pentru a simula acest lucru, mereu
primul caracter care da damage adversarului trebuie sa NU fie un Wizard, deoarece
adversarul sau trebuie sa stie cat damage da, pentru a i se seta damage-ul
deflectat, care va ajuta Wizard-ul sa isi dea damage-ul pentru abilitatea a 2-a.
Daca un Wizard ar incepe lupta primul, damage-ul dat de deflect va fi stabilit
de un damage primit tura anterioara, sau mai rau, va fi nul. Daca se lupta 2
Wizards, nu are importanta cine incepe, deoarece Deflectul nu se aplica unul
altuia.
	La finalul castarii abilitatilor, se va scadea din hp-ul oponentului damage-ul
efectiv dat, urmand o verificare. Verificarea consta in statusul celor 2 eroi.
Daca unul supravietuieste si isi omoara adversarul, va primi experienta si va
fi verificat level_up() de care am vorbit mai devreme. Daca ambii eroi mor, 
statusurile lor vor fi setate la dead (alive = false).
	Urmeaza scrierea in fisier, pentru ca rundele s-au terminat de la iesirea
din for. Este utilizata, la fel ca la race modifiers-urile din spell-uri, sin-
taxa "instance of" pentru a vedea la ce tip de erou ne referim. La final se inchid
cele doua instante de citire, scriere.

	DETALII SUPLIMENTARE SPELL-URI:

Damage-ul pentru fiecare spell incepe prin declararea unei variabile
damage de tip float, careia i se asigneaza mereu Math.round de valori in functie
de damage-ul de baza, land modifier si race modifier (in aceasta ordine). 
Cum am specificat mai sus, abilitatile de tip dot vor seta dotValue si
OverTimeCount ale adversarilor in functie de ce dispun acestea (vrajile). Magiile
Pyromancer-ului sunt basic, neavand algoritmi complicati. Backstab-ul Rogue-lui
prezinta un critCount pentru a stabili daca va da criticala in runda respectiva.
Asadar, din 3 in 3 ture, incepand cu prima, Rogue-ul va da criticala daca se
afla pe teren de tip Woods (critCount%3 == 0). Vrajile Wizard-ului au fost
cele mai ample. Drain-ul porneste cu calcularea procentului in format zecimal, 
urmand ca la final sa fie impartit la 100 pentru returnarea valorii corecte.
Deflect-ul verifica daca adversarul este un Wizard, setand damage-ul dat
la 0 in caz afirmativ. In caz contrar, va porni cu un procent subunitar si va
face modificarile necesare in functie de land/rasa pentru a calcula damage-ul
total dat de aceasta abilitate.

	SCHIMBARI PE ULTIMA SUTA:
	
Datorita unei erori la testul 5x5, setHp este facut astfel incat sa seteze
hp-ul eroilor la inceput si de fiecare data cand fac level. Inlocuitor pentru
setarea hp-ului dupa o lupta (cand un anumit erou primeste damage) devine
setHpBasic. Initial, exista o clasa separata pentru harta, ce avea in ea doar
o matrice de char-uri. Datorita simplitatii, a fost mutata in clasa Main.

