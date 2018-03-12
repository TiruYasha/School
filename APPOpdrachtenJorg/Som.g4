grammar Som;

som: som OP NUM | NUM;

WS: [ \t\r\n\f]+ -> skip;
NUM: [0-9]+;
OP: [-+\\*];