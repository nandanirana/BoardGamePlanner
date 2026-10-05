// ===============================
// GAMES
// ===============================

function addGame() {

    const game = {
        title: document.getElementById("title").value,
        minPlayers: document.getElementById("minPlayers").value,
        maxPlayers: document.getElementById("maxPlayers").value,
        complexity: document.getElementById("complexity").value
    };

    fetch("/games", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(game)
    })
    .then(response => response.json())
    .then(data => {
        alert("Game added successfully!");
        displayGames();
    })
    .catch(error => {
        console.error(error);
        alert("Could not add game.");
    });
}


// Display all games
function displayGames() {

    fetch("/games")
        .then(response => response.json())
        .then(games => {

            const list = document.getElementById("gamesList");

            list.innerHTML = "";

            games.forEach(game => {

                list.innerHTML += `
                    <div class="card">
                        <h3>${game.title}</h3>
                        <p>Players: ${game.minPlayers} - ${game.maxPlayers}</p>
                        <p>Complexity: ${game.complexity}</p>
                        <p>Game ID: ${game.id}</p>
                        <button onclick="deleteGame(${game.id})">Delete</button>
                    </div>
                `;
            });

        })
        .catch(error => console.error(error));
}

function deleteGame(id) {
    if (!confirm("Are you sure you want to delete this game?")) {
        return;
    }

    fetch(`/games/${id}`, {
        method: "DELETE"
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Could not delete game (HTTP ${response.status}).`);
        }
        displayGames();
    })
    .catch(error => {
        console.error(error);
        alert("Could not delete game.");
    });
}


// Filter games by number of players
function filterGames() {

    const players = Number(document.getElementById("playerFilter").value);
    if (!Number.isInteger(players) || players < 1) {
        alert("Enter a valid number of players.");
        return;
    }

    fetch(`/games/filter?${new URLSearchParams({ players })}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Could not search games (HTTP ${response.status}).`);
            }
            return response.json();
        })
        .then(games => {

            const list = document.getElementById("gamesList");

            list.innerHTML = "";

            if (games.length === 0) {
                list.textContent = `No games found for ${players} players.`;
                return;
            }

            games.forEach(game => {

                list.innerHTML += `
                    <div class="card">
                        <h3>${game.title}</h3>
                        <p>Players: ${game.minPlayers} - ${game.maxPlayers}</p>
                        <p>Complexity: ${game.complexity}</p>
                        <button onclick="deleteGame(${game.id})">Delete</button>
                    </div>
                `;
            });

        })
        .catch(error => {
            console.error(error);
            alert("Could not search games.");
        });
}


// ===============================
// FRIENDS
// ===============================

function addFriend() {

    const friend = {
        name: document.getElementById("friendName").value,
        contact: document.getElementById("friendContact").value
    };

    fetch("/friends", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(friend)
    })
    .then(response => response.json())
    .then(data => {
        alert("Friend added successfully!");
        displayFriends();
    })
    .catch(error => {
        console.error(error);
        alert("Could not add friend.");
    });
}


function displayFriends() {

    fetch("/friends")
        .then(response => response.json())
        .then(friends => {

            const list = document.getElementById("friendsList");

            list.innerHTML = "";

            friends.forEach(friend => {

                list.innerHTML += `
                    <div class="card">
                        <h3>${friend.name}</h3>
                        <p>Contact: ${friend.contact}</p>
                        <p>Friend ID: ${friend.id}</p>
                    </div>
                `;
            });

        })
        .catch(error => console.error(error));
}


// ===============================
// LOANS
// ===============================

function addLoan() {

    const loan = {

        gameId: document.getElementById("loanGameId").value,

        friendId: document.getElementById("loanFriendId").value,

        borrowDate: document.getElementById("borrowDate").value,

        returnDate: document.getElementById("returnDate").value
    };

    fetch("/loans", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(loan)
    })
    .then(response => response.json())
    .then(data => {
        alert("Loan added successfully!");
    })
    .catch(error => {
        console.error(error);
        alert("Could not add loan.");
    });
}


// Load data when page opens
displayGames();
displayFriends();