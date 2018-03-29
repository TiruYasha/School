grammar ICSS;

stylesheet: stylesheetsection* EOF;

stylesheetsection: selectorStyle | constantDefinition;

selectorStyle: selector SELECTOR_OPEN declaration* SELECTOR_CLOSE;

// Maak een reference voor bv de constname om die op te zoeken in de boom
// constantReference: CONSTNAME
// expression: PIXELLITERAL
// naam geven #PixelLiteral #PercentageLiteral #constReference naar dezelfde regel dat daarvoor is beschreven
// Expression SUMOP expression #addExpression
// SUMOP: '+';
// Addoperation knoop aanmaken die 2 kinderen heeft dus die ook maar weer ns op de stack zetten
selector: DECLARATION_STRING #TagSelector|
          CLASSSELECTOR #ClassSelector |
          IDSELECTOR #IdSelector;

declaration: declarationProperty COLON expression SEMICOLON;

constantDefinition: 'let' constantReference 'is' expression';';

constantReference: REFERENCE_STRING;

declarationProperty: DECLARATION_STRING;

expression: PIXEL_LITERAL #PixelLiteral |
    PERCENTAGE_LITERAL #PercentageLiteral |
    COLOR_LITERAL #ColorLiteral |
    REFERENCE_STRING #ConstantDefinitionExpression;

COLOR_LITERAL: '#'[a-f0-9]+;
PIXEL_LITERAL: [0-9]+'px';
PERCENTAGE_LITERAL: [0-9]+'%';

CLASSSELECTOR: '.'STRING;
IDSELECTOR: '#'STRING;
SELECTOR_OPEN: '{';
SELECTOR_CLOSE: '}';

DECLARATION_STRING: DECLARATION;
REFERENCE_STRING: '$'[a-zA-Z_]+;

STRING: [a-zA-Z]+;
DECLARATION: [a-zA-Z-]+;

COLON: ':';
SEMICOLON: ';';

WHITESPACE: [ \t\r\n]+ -> skip;





