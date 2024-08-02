document.getElementById('restaurant-form').addEventListener('submit', function (event) {
    event.preventDefault();
    const name = document.getElementById('restaurant-name').value;
    const address = document.getElementById('restaurant-address').value;
    const phoneNumber = document.getElementById('restaurant-phone').value;

    fetch('http://localhost:8081/api/restaurants', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, address, phoneNumber })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Restaurant added', data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

document.getElementById('menu-form').addEventListener('submit', function (event) {
    event.preventDefault();
    const restaurantId = 1; // assuming a restaurant ID for demonstration
    const name = document.getElementById('menu-item-name').value;
    const price = document.getElementById('menu-item-price').value;

    fetch(`http://localhost:8081/api/restaurants/${restaurantId}/menu`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, price })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Menu item added', data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
});
