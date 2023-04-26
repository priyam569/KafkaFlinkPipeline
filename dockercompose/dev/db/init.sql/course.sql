CREATE TABLE COURSE(
   ID TEXT PRIMARY KEY     NOT NULL,
   NAME           TEXT    NOT NULL,
AUTHOR           TEXT    NOT NULL,
IMAGE           TEXT    NOT NULL,
TYPE           TEXT    NOT NULL,
DESCRIPTION           TEXT    NOT NULL,
   DURATION            INT     NOT NULL,
PRICE            INT     NOT NULL,
RATING            INT     NOT NULL
);

INSERT INTO course values('1000001109991','Spring','Priya M', 'assets/spring.jpg','Free','Spring - Begininers Guide',12,10000,4);