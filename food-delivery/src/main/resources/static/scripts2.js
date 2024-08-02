document.getElementById('order-form').addEventListener('submit', function (event) {
    event.preventDefault();
    const customerId = document.getElementById('customer-id').value;
    const restaurantId = document.getElementById('restaurant-id').value;
    const status = document.getElementById('status').value;

    fetch('http://localhost:8081/api/orders', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ customer: { id: customerId }, restaurant: { id: restaurantId }, status })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Order placed', data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
});
