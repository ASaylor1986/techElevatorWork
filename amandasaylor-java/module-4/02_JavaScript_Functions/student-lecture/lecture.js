/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter*secondParameter;
}

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  return firstParameter*secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}
/**JSDoc Example 
 * 
 * This method takes the details of a person and creates an English sentence 
 * that uses that information to describe them. We join the quirks together with the separator specified or ', ' by default.
 * 
 * @param {string} name the name of the person we're describing
 * @param {*} age the age of the person
 * @param {string[]} [listOfQuirks] a list of funny quirks
 * @param {string} [separator = ', ' string to separate a lst of quirks
 * @returns {string} the full sentence about the person
 * 
 * 
 * 
*/


function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

// function multiplyAndLog(value) {
//   console.log(value*2);
// }

// function forEachDemo() {
// let myArray = [1, 2, 3, 4, 5];
// myArray.forEach((value) => console.log(value*2));

// }

// function isEven(n) {
//   return n%2 ==0;
// }

// function filterDemo() {
//   let myArray = [1, 2, 3, 4, 5];
//   return myArray.filter((n) => n%2 ==0);

// }

function mapDemo() {
  let myArray = ['red', 'blue', 'green'];

  return myArray.map(str=> str.substring(1));
}

function reduceDemo() {
  let myArray = ['cat', 'dog', 'bird', 'mouse'];

  return myArray.reduce((acc, str) => acc + str.toUpperCase(), '');
}

function idk() {
  let myArray = ['cat', 'dog', 'bird', 'mouse'];
  return myArray.reduce(
}
/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce();
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  // let numbersToFilter = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];
  return numbersToFilter.filter((n) => n%3 ==0);
}

function allDivisibleByX(numbersToFilter) {
  // let numbersToFilter = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];
  return numbersToFilter.filter((n) => n%x ==0);
}