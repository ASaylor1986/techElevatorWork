-- Display all the films and their language

SELECT film.title, language.name
FROM film
JOIN language ON language.language_id = film.language_id


-- Display all the films and in English

SELECT f.title, l.name
FROM film f
JOIN language l ON l.language_id = f.language_id
WHERE l.name = 'English'

-- Display all the films with their category

SELECT title, cat.name
FROM film AS f
JOIN film_category AS fc ON fc.film_id = f.film_id
JOIN category AS cat ON cat.category_id = fc.category_id;

-- Display all the films with a category of Horror

SELECT title, cat.name
FROM film AS f
JOIN film_category AS fc ON fc.film_id = f.film_id
JOIN category AS cat ON cat.category_id = fc.category_id
WHERE cat.name = 'Horror';

-- Display all the films with a category of Horror and title that begins with the letter F

SELECT title, cat.name
FROM film AS f
JOIN film_category AS fc ON fc.film_id = f.film_id
JOIN category AS cat ON cat.category_id = fc.category_id
WHERE cat.name = 'Horror'
AND title LIKE 'F%';

-- Who acted in what together?

SELECT title, a1.first_name || ' ' || a1.last_name, a2.first_name || ' ' || a2.last_name
FROM film AS f
JOIN film_actor AS fa1 ON f.film_id = fa1.film_id
JOIN film_actor AS fa2 ON f.film_id = fa2.film_id AND fa1.actor_id <> fa2.actor_id
JOIN actor AS a1 ON fa1.actor_id = a1.actor_id
JOIN actor AS a2 ON fa2.actor_id = a2.actor_id;

-- How many times have two actors appeared together?

SELECT COUNT(*) AS num_of_films, a1.first_name || ' ' || a1.last_name, a2.first_name || ' ' || a2.last_name
FROM film AS f
JOIN film_actor AS fa1 ON f.film_id = fa1.film_id
JOIN film_actor AS fa2 ON f.film_id = fa2.film_id AND fa1.actor_id <> fa2.actor_id
JOIN actor AS a1 ON fa1.actor_id = a1.actor_id
JOIN actor AS a2 ON fa2.actor_id = a2.actor_id
GROUP BY a1.actor_id, a2.actor_id
ORDER BY num_of_films DESC;

-- What movies did the two most often acted together actors appear in together?
WITH top_actors AS (
    SELECT a1.actor_id AS id1, a2.actor_id AS id2
    FROM film AS f
    JOIN film_actor AS fa1 ON f.film_id = fa1.film_id
    JOIN film_actor AS fa2 ON f.film_id = fa2.film_id AND fa1.actor_id <> fa2.actor_id
    JOIN actor AS a1 ON fa1.actor_id = a1.actor_id
    JOIN actor AS a2 ON fa2.actor_id = a2.actor_id
    GROUP BY a1.actor_id, a2.actor_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
SELECT film.title
FROM film
JOIN film_actor fa1 ON film.film_id = fa1.film_id
JOIN film_actor fa2 ON film.film_id = fa2.film_id
WHERE fa1.actor_id = (SELECT id1 FROM top_actors)
AND fa2.actor_id = (SELECT id2 FROM top_actors);

