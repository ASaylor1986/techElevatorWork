document.addEventListener('DOMContentLoaded', () => {

    const title = document.getElementById('title');
    const reviewer = document.getElementById('reviewer');
    const rating = document.getElementById('rating');
    const review = document.getElementById('review');

    const titleResult = document.querySelector('.titleResult');
    const reviewerResult = document.querySelector('.reviewerResult');
    const ratingResult = document.querySelector('.ratingResult');
    const reviewResult = document.querySelector('.reviewResult');

    title.addEventListener('keyup', () => {
        titleResult.innerText = title.value;
    });

    reviewer.addEventListener('keyup', () => {
        reviewerResult.innerText = reviewer.value;
    });

    rating.addEventListener('change', () => {
        ratingResult.innerText = rating.value;
    });

    review.addEventListener('keyup', () => {
        reviewResult.innerText = review.value;
    });
    
});
