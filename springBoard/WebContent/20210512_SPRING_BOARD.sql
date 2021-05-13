DROP TABLE SPRING_BOARD;
CREATE TABLE SPRING_BOARD(
	SBNUM VARCHAR2(20) PRIMARY KEY 
   ,SBSUBJECT VARCHAR2(200) NOT NULL
   ,SBNAME VARCHAR2(100) NOT NULL
   ,SBCONTENT VARCHAR2(2000)
   ,SBFILE VARCHAR2(300)
   ,SBPW VARCHAR2(300)
   ,SBDELYN VARCHAR2(1) NOT NULL
   ,SBINSERTDATE DATE
   ,SBUPDATEDATE DATE 
);



CREATE TABLE SPRING_RBOARD(
	RSBNUM VARCHAR2(20) PRIMARY KEY
   ,SBNUM VARCHAR2(20) NOT NULL
   ,RSBNAME VARCHAR2(100) NOT NULL
   ,RSBCONTENT VARCHAR2(600)
   ,RSBPW VARCHAR2(300) 
   ,RSBDELYN VARCHAR2(1)
   ,RSBINSERTDATE DATE
);