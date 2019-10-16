-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)

SELECT * FROM city WHERE countrycode = 'USA';

INSERT INTO city (countrycode, name, district, population)
VALUES ('USA', 'Smallville', 'Kansas', 45001);


-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

INSERT INTO countrylanguage (countrycode, language, percentage, isofficial)
VALUES ('USA', 'Kryptonese', 0.0001, false);

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.

SELECT language FROM countrylanguage WHERE countrycode = 'USA';

UPDATE countrylanguage
SET language = ('Krypto-babble')
WHERE language = 'Kryptonese';

-- 4. Set the US captial to Smallville, Kansas in the country table.

SELECT id FROM city WHERE name = 'Smallville';
SELECT * FROM country WHERE code = 'USA';

UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Smallville')
WHERE code = 'USA';

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

SELECT * FROM city
WHERE countrycode = 'USA';

DELETE FROM city
WHERE id = (SELECT id FROM city WHERE name = 'Smallville');
*************
-- Won't let us delete it because it is set to the capital on the country table. 
*************

-- 6. Return the US captial to Washington.

SELECT id FROM city WHERE name = 'Washington';
SELECT * FROM country WHERE code = 'USA';

UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Washington')
WHERE code = 'USA';

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

SELECT * FROM city
WHERE countrycode = 'USA';

DELETE FROM city
WHERE id = (SELECT id FROM city WHERE name = 'Smallville');

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)

SELECT * FROM countrylanguage;
SELECT * FROM country WHERE indepyear between 1800 AND 1972;

UPDATE countrylanguage
SET isofficial = not isofficial 
WHERE countrycode IN (SELECT code FROM country WHERE indepyear between 1800 AND 1972);

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)

SELECT * FROM city ORDER BY id;

UPDATE city
SET population = round((population/1000):: numeric, 0);

-- 10. Assuming a country's surfacearea is expressed in miles, convert it to 
-- meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)

SELECT * FROM country;
SELECT * FROM countrylanguage WHERE language = 'French' AND percentage > 20;

UPDATE country
SET surfacearea = (surfacearea*1609.34)
WHERE code IN (SELECT countrycode FROM countrylanguage WHERE language = 'French' AND percentage > 20);