var oldCoins = new Set();
var oldPlayers = {};

// TODO  this entire GUI sucks major moose cock and should
// TODO  be redone by someone who knows what theyre doing

$(document).ready(function () {
    setInterval(function () {
        $.ajax({
            url: "/api"
        }).then(function (data) {
            updateCoins(data);
            updatePlayers(data);
        });
    }, 100); //omg
});

function updatePlayers(data) {
    for (var p = 0; p < 2; p++) {
        var playerKey = '#' + data.players[p].x + '_' + data.players[p].y;
        var playerColor = data.players[p].color;

        if (oldPlayers[playerColor] === playerKey) {
            oldPlayers[playerColor] = "";
        } else {
            putPlayerOnKey(playerKey, playerColor);
        }
        deleteKey(oldPlayers[playerColor]);

        // another ugly hack to force redraw the square player just left
        if (oldCoins.has(oldPlayers[playerColor])) {
            oldCoins.delete(oldPlayers[playerColor]);
        }

        oldPlayers[playerColor] = playerKey;
        $('#' + playerColor + 'score').html(data.players[p].score);

        var c = data.players[p].coins;

        //....wow
        $('#' + playerColor + 'coins1').css('visibility', c > 0 ? 'visible' : 'hidden' );
        $('#' + playerColor + 'coins2').css('visibility', c > 1 ? 'visible' : 'hidden' );
        $('#' + playerColor + 'coins3').css('visibility', c > 2 ? 'visible' : 'hidden' );
        $('#' + playerColor + 'coins4').css('visibility', c > 3 ? 'visible' : 'hidden' );
        $('#' + playerColor + 'coins5').css('visibility', c > 4 ? 'visible' : 'hidden' );
    }
}

function updateCoins(data) {
    var newCoins = new Set();
    for (var c = 0; c < data.coinCount; c++) {
        var coinKey = '#' + data.coins[c].x + '_' + data.coins[c].y;
        newCoins.add(coinKey);
        if (oldCoins.has(coinKey)) {
            oldCoins.delete(coinKey);
        } else {
            putCoinOnKey(coinKey);
        }
    }

    oldCoins.forEach(function (x) {
        deleteKey(x);
    });

    oldCoins = newCoins;
}

function deleteKey(key) {
    $(key).css('background-image', '');
}

function putCoinOnKey(key) {
    $(key).css('background-image', 'url(\'/images/coin.gif\')');
}

function putPlayerOnKey(key, color) {
    $(key).css('background-image', 'url(\'/images/' + color + '.png\')');
}