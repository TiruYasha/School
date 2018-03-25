# Haskell

Dit is voor het eerst dat ik in aanraking kom met een functionele programmeer taal. Voor de eerste keer heb ik Haskell gekozen. Ik heb Haskell gekozen, omdat ik er vaak van heb gehoord en het is volgens velen de puurste vorm van functioneel programmeren. Als ik functioneel voor het eerst doe, dan maar gelijk puur functioneel.

## Dag 1

De eerste dag en voor het eerst in aanraking gekomen met functioneel programmeren en dus ook Haskell. De eerste dag heb ik uit het boek Seven Languages in Seven Weeks van Haskell gevolgd om al een idee van de basis te krijgen.

Voordat ik kon beginnen moest ik Haskell eerst installeren voor Windows. Dit was niet moeilijk en ik kon snel aan de slag. Ik begon eerst in de console de basisvoorbeelden door te nemen en dat sprak allemaal nog voor zich. Het moment dat het boek begon over functies ging ik een manier zoeken om Haskell bestanden aan te roepen. Dit was wat anders dan ik gewend was, omdat je zelf via de command line de bestanden moet aanroepen. Ik deed het via GHCI, waarmee ik dan weer afzonderlijke functies in het Haskell bestand kon aanroepen. Dit is even wennen, omdat ik normaal gesproken unit tests gebruik en bij intellij of visual studio is dat 1 shortcut en het werkt.

Op naar de taal zelf. Het eerste waar ik heel erg aan moest wennen was de syntax. Haakjes zijn niet nodig om functies uit te voeren. Hierdoor zat ik bij de eerste recursive functie te kijken van: "wat gebeurt hier nou", maar ik had toen gewoon even niet door dat een functie ook werkt zonder haakjes. Ik moest ook erg wennen aan de manier, waarop functies gedefinieerd worden en aan pattern matching.

Tuples kende ik al vanuit C# dus dat is niet nieuw en lists zijn ook niet echt spannend.

## Dag 2

Bij Dag 2 van het seven languages boek was het niet moeilijk om de aspecten van Higher-Order Functions, Partially Applied Functions and Currying, and Lazy Evalution te begrijpen. Het begrijpen van de concepten was niet moeilijk, maar het toepassen van de concepten was een stuk moeilijker dan ik dacht. Dit kwam mede door de syntax van Haskell waar ik super veel moeite mee heb om aan te wennen. Dit leverde veel frustratie op. Vooral bij de opdracht van "Write a Haskell function to convert a string to a number. The string should be in the form of $2,345,678.99 and can possibly have leading zeros.". Hiervoor had ik uiteindelijk de oplossing op het internet gezocht. Deze oplossing werkte ook nog niet helemaal, omdat die door komma's in de tekst eruit klapte. Dit heb ik uiteindelijk opgelost door komma's weg te filteren uit de tekst. Deze fout zorgde er wel voor datik de documentatie beter ben gaan begrijpen en de syntax structuur van Haskell.

De opdrachten daarna gingen mij een stuk beter af en ik moest alleen nog weer heel erg wennen aan de head:tail structuur. Omdat ik niet gewend ben om zoiets te gebruiken had ik nog wat moeite met de denominator opdracht. Ik had dit eerst gemaakt met guards, maar op 1 of andere manier werd de list niet aangevuld en gaf die een lege list terug. De guards had ik uiteindelijk omgezet naar een if then else constructie en toen werd de list wel gewoon aangevuld met de waardes.

Al om al was het een deels frustrerende tweede dag, waarbij ik wel veel heb geleerd over de syntax en handige snufjes van Haskell.