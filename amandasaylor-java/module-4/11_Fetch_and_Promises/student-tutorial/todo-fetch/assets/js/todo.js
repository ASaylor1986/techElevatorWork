

fetch('data.json')
.then((response) => {
  // get the JSON from the response
  return response.json();
})
.then((todos) => {
  // when the JSON data is returned log the result
  console.log(todos);
})
.catch((err) => {console.error(err)});