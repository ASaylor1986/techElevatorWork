
// add pageTitle
let pageTitle = "My Shopping List";

// add groceries

let groceries = ['Bananas', 'Eggs', 'Bread', 'Applesauce', 'Cereal', 'Cheese', 'Bacon', 'Lunchables', 'Cat Food', 'Chocolate Milk'];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  // const heading = document.getElementById('heading')
  // heading.innerText = pageTitle;
  // shoppingList.appendChild(heading);  // not really sure why this doesn't work, since it worked for the toDoList...

  const myPageTitle = document.getElementById('title');
  myPageTitle.innerText = pageTitle;
  

}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const allGroceryItems = document.getElementById('groceries');

  groceries.forEach(item => {
    const groceryItem = document.createElement('li');
    groceryItem.innerText = item;
    allGroceryItems.appendChild(groceryItem);
  });

}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  
  let allListItems = document.querySelectorAll('#groceries li');
  
  allListItems.forEach(item => {
  item.classList.add('completed');
  });

}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
