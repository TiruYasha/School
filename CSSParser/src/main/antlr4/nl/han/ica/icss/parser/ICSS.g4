grammar ICSS;

stylesheet: stylesheetsection*;

stylesheetsection: selectorStyle;

selectorStyle: SELECTOR SELECTOR_OPEN declaration* SELECTOR_CLOSE;

// Maak een reference voor bv de constname om die op te zoeken in de boom
// constantReference: CONSTNAME
// expression: PIXELLITERAL
// naam geven #PixelLiteral #PercentageLiteral
declaration: DECLARATION_STRING COLON;

WHITESPACE: [ \t\r\n]+ -> skip;
INT: [0-9]+;

DECLARATION_STRING: [a-zA-Z-]+;
PXVALUE: [0-9]+'px';

SELECTOR: [a-zA-Z0-9]+;
SELECTOR_OPEN: '{';
SELECTOR_CLOSE: '}';


COLON: ':';
SEMICOLON: ';';
HASHTAG: '#';
DOT: '.';





