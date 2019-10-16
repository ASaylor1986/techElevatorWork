-- ORDERING RESULTS

-- Populations of all countries in descending order

SELECT name, population
FROM country
ORDER BY population DESC;


--Names of countries and continents in ascending order

SELECT name, continent
FROM country
ORDER BY continent, name;


-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)

SELECT name, population
FROM city
WHERE countrycode = 'USA'
ORDER BY name ASC, population DESC;


-- Countries sorted by form of govt., region, and gnp

SELECT name, governmentform, region, gnp
FROM country
ORDER BY governmentform, region, gnp DESC;


-- LIMITING RESULTS

-- The 10 largest countries in the world

SELECT name, surfacearea
FROM country
ORDER BY surfacearea DESC
LIMIT 10;




-- The name and average life expectancy of the countries with the 10 highest life expectancies.

SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC
LIMIT 10;





-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip


SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC, name ASC
LIMIT 10 OFFSET 10;





-- CONCATENATING OUTPUTS

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.

SELECT (language || ' is spoken in the country with code ' || countrycode) FROM countrylanguage;

SELECT (name || ' is in the state of ' || district) AS city_state FROM city WHERE countrycode = 'USA';


-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city


SELECT (name || ', ' || district)
FROM city
WHERE district IN ('California', 'Oregon', 'Washington')
ORDER BY district, name;




-- AGGREGATE FUNCTIONS

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.



-- Counts the number of rows in the city table

SELECT COUNT(name) 
FROM city;


-- Also counts the number of rows in the city table

SELECT COUNT(population)
FROM city;


SELECT COUNT(name)
FROM country;

SELECT COUNT(lifeexpectancy)
FROM country;

SELECT COUNT(*)
FROM country;


-- Average Life Expectancy in the World


SELECT AVG(lifeexpectancy) AS average_life
FROM country;


-- Total population in Ohio

SELECT SUM(population) AS total_pop
FROM city
WHERE district = 'Ohio';


-- The surface area of the smallest country in the world

SELECT MIN(surfacearea)
FROM country;

SELECT MAX(surfacearea)
FROM country;


-- The number of countries who declared independence in 1991

SELECT COUNT(*)
FROM country
WHERE indepyear = 1991;

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.

SELECT SUM(population) AS total_pop, round(AVG(population), 2) AS average_pop, COUNT(*)
FROM city;

 --https://www.postgresql.org/docs/current/static/functions-math.html


-- Gets the MIN population and the MAX population from the city table.

SELECT MIN(population), MAX(population) FROM city;


-- GROUP BY

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.

SELECT countrycode, MIN(population), MAX(population)
FROM city
GROUP BY countrycode;

SELECT DISTINCT countrycode FROM city;


-- Count the number of countries where each language is spoken, ordered from most countries to least

SELECT language, COUNT(countrycode) AS country_count
FROM countrylanguage
GROUP BY language
ORDER BY country_count DESC;


-- Average life expectancy of each continent ordered from highest to lowest

SELECT continent, AVG(lifeexpectancy) AS "Average Life Expectancy"
FROM country
GROUP BY continent
ORDER BY "Average Life Expectancy" DESC;


-- Exclude Antarctica from consideration for average life expectancy

SELECT continent, round(AVG(lifeexpectancy)::numeric, 2)
FROM country
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY AVG(lifeexpectancy) DESC;



-- Sum of the population of cities in each state in the USA ordered by state name

SELECT district, SUM(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;


-- The average population of cities in each state in the USA ordered by state name

SELECT district, AVG(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;

SELECT district, AVG(population) AS avg_pop
FROM city
WHERE countrycode = 'USA'
GROUP BY district
HAVING AVG(population) > 300000
ORDER BY avg_pop DESC;


SELECT name, COUNT(*)
FROM city
GROUP BY name
HAVING COUNT(*) > 1
ORDER BY COUNT(*) DESC, name ASC;



-- SUBQUERIES
-- Find the names of cities under a given government leader

SELECT DISTINCT headofstate FROM country;

SELECT name
FROM city
WHERE countrycode IN (SELECT code FROM country WHERE headofstate = 'Beatrix');



-- Find the names of cities whose country they belong to has not declared independence yet

SELECT name
FROM city
WHERE countrycode IN (SELECT code FROM country WHERE indepyear IS NULL);

-- Additional samples
-- You may alias column and table names to be more descriptive

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.

SELECT c.name, co.name
FROM city AS c, country AS co
WHERE countrycode = 'ABW';












