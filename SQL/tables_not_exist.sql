drop table if exists InfoA;
drop table if exists InfoB;
drop table if exists InfoC;
CREATE TABLE InfoA
(    
	idA INT PRIMARY KEY,
	mText text
);
CREATE TABLE InfoB
(    
   	idB INT PRIMARY KEY,
	bInt int 
);
CREATE TABLE InfoC
(    
	idC INT PRIMARY KEY,
	cInt int ,
	FOREIGN KEY (idC) REFERENCES InfoD (idB)
);

