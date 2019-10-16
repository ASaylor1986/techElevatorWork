-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

SELECT * FROM actor;

INSERT INTO actor (first_name, last_name)
VALUES ('HAMPTON', 'AVENUE'),
        ('LISA', 'BYWAY');

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

SELECT * FROM film;
SELECT * FROM language;
INSERT INTO film (title, description, release_year, language_id, length)
VALUES ('EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198);

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.


SELECT * FROM film WHERE title = 'EUCLIDEAN PI';
SELECT * FROM actor WHERE first_name = 'HAMPTON' AND last_name = 'AVENUE' OR first_name = 'LISA' AND last_name = 'BYWAY';

SELECT first_name, last_name, film.title
FROM actor
JOIN film_actor ON actor.actor_id = film_actor.actor_id
JOIN film ON film_actor.film_id = film.film_id
WHERE film.title = 'EUCLIDEAN PI'
GROUP BY film.title, first_name, last_name
ORDER BY film.title;


INSERT INTO film_actor (actor_id, film_id)
VALUES (201, 1001),
        (202, 1001);


-- 4. Add Mathmagical to the category table.

SELECT * FROM category;

INSERT INTO category (name)
VALUES ('Mathmagical');
-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

SELECT * FROM film;
SELECT * FROM film_category WHERE category_id = 17;

INSERT INTO film_category (film_id, category_id) 
VALUES (1001, 17);

UPDATE film_category
SET category_id = 17
WHERE film_id IN (274, 494, 714, 996);

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
SELECT * FROM category WHERE name = 'Mathmagical';
SELECT * FROM film_category WHERE category_id = 17;
SELECT * FROM film WHERE film_id IN (1001, 274, 494, 714, 996);

UPDATE film
SET rating = 'G'
WHERE film_id IN (1001, 274, 494, 714, 996);


-- 7. Add a copy of "Euclidean PI" to all the stores.

SELECT * FROM store;
SELECT * FROM inventory WHERE film_id = 1001 ORDER BY store_id;

INSERT INTO inventory (film_id, store_id)
VALUES (1001, 1), (1001, 2);

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.

SELECT * FROM film WHERE film_id = 1001;

DELETE FROM film
WHERE film_id = 1001;
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

It did not succeed because it violates a foreign key constraint in film_actor, etc. where other items are tied to the film id.

-- 9. Delete Mathmagical from the category table.

SELECT * FROM category;

DELETE FROM category WHERE name = 'Mathmagical';
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
It did not succeed because that category id is linked to other tables as a foreign key. 


-- 10. Delete all links to Mathmagical in the film_category tale.

SELECT * FROM film_category WHERE category_id = 17;

DELETE FROM film_category WHERE category_id = 17;
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
It succeeded because film_category is only a link to other tables. The film id and category id can still exist in other tables without it existing in this table. 

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
SELECT * FROM category;

DELETE FROM category WHERE name = 'Mathmagical';

-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>

This one did not give me an error. It showed 0 rows deleted, but it was gone when I selected all from category. When I deleted it from the film_category table, it must have also deleted it from the category table. 

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.

The actors need to be deleted from this film on the film_actor table. 

SELECT * FROM film_actor WHERE film_id = 1001;
DELETE FROM film_actor WHERE film_id = 1001;
*two rows were deleted

Copies of the film need to be deleted from the inventory table. 

SELECT * FROM inventory WHERE film_id = 1001;
DELETE FROM inventory WHERE film_id = 1001;


You should then be able to delete this film from the table. 
SELECT * FROM film WHERE title = 'EUCLIDEAN PI';
DELETE FROM film WHERE title = 'EUCLIDEAN PI';

