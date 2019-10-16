import emoji from 'node-emoji';


document.addEventListener('DOMContentLoaded', () =>{


    let messageText = emoji.emojify('I :heart: JavaScript and ');

    document.getElementById('message').innerText = messageText + emoji.random().emoji;


})