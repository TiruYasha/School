grammar ICSS;

stylesheet: stylesheetsection* EOF;

stylesheetsection: selectorStyle | constantDefinition | switchrule;

selectorStyle: selector SELECTOR_OPEN declaration* SELECTOR_CLOSE;

selector: DECLARATION_STRING #TagSelector|
          CLASSSELECTOR #ClassSelector |
          IDSELECTOR #IdSelector;

declaration: declarationProperty COLON value SEMICOLON;

constantDefinition: 'let' constantReference 'is' value';';

constantReference: REFERENCE_STRING;

declarationProperty: DECLARATION_STRING;

value: calc+;

expressionLiteral: PIXEL_LITERAL #PixelLiteral |
    PERCENTAGE_LITERAL #PercentageLiteral |
    COLOR_LITERAL #ColorLiteral |
    INT #ScalarLiteral |
    REFERENCE_STRING #ConstantDefinitionExpression;

calc:   expressionLiteral #Expression|
        calc SUMMULTIPLY calc #MultiplyOperator |
      calc SUMADD  calc #AddOperator |
      calc SUMSUBSTRACT calc #SubstractOperator;

switchrule: selector 'switch' constantReference caserule+ defaultcase;

caserule: 'case' calc SELECTOR_OPEN declaration* SELECTOR_CLOSE;
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
