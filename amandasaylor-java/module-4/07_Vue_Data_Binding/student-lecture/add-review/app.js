document.addEventListener('DOMContentLoaded', () => {

    const title = document.getElementById('title');
    const reviewer = document.getElementById('reviewer');
    const rating = document.getElementById('rating');
    const review = document.getElementById('review');

    const titleResult = document.getElementById('titleResult');
    const reviewerResult = document.getElementById('reviewerResult');
    const ratingResult = document.getElementById('ratingResult');
    const reviewResult = document.getElementById('reviewResult');

    title.addEventListener('keyup', () => {
        titleResult.innerText = title.value;
    });

    reviewer.addEventListener('keyup', () => {
        reviewerResult.innerText = reviewer.value;
    });
    
    rating.addEventListener('keyup', () => {
        ratingResult.innerText = rating.value;
    });
    
    review.addEventListener('keyup', () => {
        reviewResult.innerText = review.value;
    });
   
    

});

function addReview(event) {
    event.preventDefault();

}