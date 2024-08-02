function fetchUsers() {
    fetch('http://localhost:8081/api/admin/users')
    .then(response => response.json())
    .then(users => {
        const userList = document.getElementById('user-list');
        userList.innerHTML = '';
        users.forEach(user => {
            const listItem = document.createElement('li');
            listItem.textContent = `${user.username} (${user.role})`;
            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Delete';
            deleteButton.addEventListener('click', () => deleteUser(user.id));
            listItem.appendChild(deleteButton);
            userList.appendChild(listItem);
        });
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function deleteUser(userId) {
    fetch(`http://localhost:8081/api/admin/users/${userId}`, {
        method: 'DELETE'
    })
    .then(() => {
        console.log('User deleted');
        fetchUsers();
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

document.addEventListener('DOMContentLoaded', fetchUsers);
