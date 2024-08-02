document.getElementById('delivery-form').addEventListener('submit', function (event) {
    event.preventDefault();
    const deliveryId = document.getElementById('delivery-id').value;
    const status = document.getElementById('status').value;

    fetch(`http://localhost:8081/api/deliveries/${deliveryId}/status`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ status })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Delivery status updated', data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
});
