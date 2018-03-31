grammar ICSS;

stylesheet: stylesheetsection* EOF;

stylesheetsection: selectorStyle | constantDefinition | switchrule;

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

declaration: declarationProperty COLON value SEMICOLON;

constantDefinition: 'let' constantReference 'is' value';';

constantReference: REFERENCE_STRING;

declarationProperty: DECLARATION_STRING;

value: som | expression;

expression: PIXEL_LITERAL #PixelLiteral |
    PERCENTAGE_LITERAL #PercentageLiteral |
    COLOR_LITERAL #ColorLiteral |
    INT #ScalarLiteral |
    REFERENCE_STRING #ConstantDefinitionExpression;

som: expression (calcoperator expression)+;

calcoperator: SUMADD #AddOperator | SUMMULTIPLY #MultiplyOperator | SUMSUBSTRACT #SubstractOperator;

switchrule: selector 'switch' constantReference caserule+ defaultcase;

caserule: 'case' expression SELECTOR_OPEN declaration* SELECTOR_CLOSE;
defaultcase: 'default' SELECTOR_OPEN declaration* SELECTOR_CLOSE;


SUMADD: '+';
SUMMULTIPLY: '*';
SUMSUBSTRACT: '-';

COLOR_LITERAL: '#'[a-f0-9]+;
PIXEL_LITERAL: [0-9]+'px';
PERCENTAGE_LITERAL: [0-9]+'%';

CLASSSELECTOR: '.'STRING;
IDSELECTOR: '#'STRING;
SELECTOR_OPEN: '{';
SELECTOR_CLOSE: '}';

DECLARATION_STRING: DECLARATION;
REFERENCE_STRING: '$'[a-zA-Z_]+;

INT: [0-9]+;
STRING: [a-zA-Z]+;
DECLARATION: [a-zA-Z-]+;

COLON: ':';
SEMICOLON: ';';

WHITESPACE: [ \t\r\n]+ -> skip;





