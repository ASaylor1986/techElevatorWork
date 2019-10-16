let listItems = [];

function loadAllItems() {
  console.log("Loading shopping list items...");

  return fetch('assets/data/shopping-list.json')
    .then((response) => {
      if (response.ok === false) {
        throw('Response not okay');
      } else {
        return response.json();
      }
    })
    .then((data) => {
      listItems = data;
      
    })
    .catch((err) => {
      console.log('ERROR HAPPENED: ' + err);
    });

}


const button = document.querySelector('.loadingButton');
button.addEventListener('click', () => {
    loadAllItems().then(displayShoppingList);
    button.disabled = true;
});

function displayShoppingList() {
    console.log("Display the Shopping List...");
    
    if('content' in document.createElement('template')) {
      const container = document.querySelector("ul");

      listItems.forEach((item) => {
        const tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
        tmpl.querySelector("li").insertAdjacentHTML('afterbegin', item.name);
        if (item.completed) {
          tmpl.querySelector('li').setAttribute("class", "completed");
          const circleCheck = tmpl.querySelector('i');
            // circleCheck.className += " completed";
        }

        container.appendChild(tmpl);
      });
    } else {
      console.error('Your browser does not support templates');
    }
}