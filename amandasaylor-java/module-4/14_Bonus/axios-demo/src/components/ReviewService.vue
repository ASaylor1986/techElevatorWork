import axios from 'axios';

const apiClient = axios.create({
    baseURL : 'https://5d41aa9075f67300146b41a4.mockapi.io/api/reviews',
    headers: {
        'Content-Type': 'application/json',
        Accept: 'application/json'
    }
});

export default {

    getReviews() {
        return apiClient.get().then(response => response.data);
    },

    getReview(id) {
        return apiClient.get('/' + id).then(response => response.data);
    }
    deleteReview(id) {
        return apiClient.delete('/' + id);
    }
}