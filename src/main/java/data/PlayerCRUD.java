package data;

import player.Player;

public class PlayerCRUD implements IPlayerCRUD {
    private int id;
    private Player[] players;
    private int _length;
    public PlayerCRUD(int number_of_players) {
        id = 1;
        _length = 0;
        players = new Player[number_of_players];
    }

    @Override
    public Player create(Player player) {
        if (_length >= players.length) return null;
        if (player != null) {
            player.setId(id++);
            players[_length++] = player;
        }
        return player;
    }

    @Override
    public Player select(int id) {
        Player player = null;
        for (int i = 0; i < _length; i++) {
            if (id == players[i].getId())
                player = players[i];
        }
        return player;
    }

    @Override
    public Player[] selectAll() {
        Player[] listOfPlayers = new Player[_length];
        for (int i = 0; i < _length; i++)
            if (players[i] != null)
                listOfPlayers[i] = players[i];
        return listOfPlayers;
    }

    @Override
    public Player update(Player updatedPlayer) {
        Player player = select(updatedPlayer.getId());
        if (player != null)
            player.setName(updatedPlayer.getName());
        else
            create(updatedPlayer);
        return updatedPlayer;
    }

    @Override
    public void delete(Player player) {
        if (player == null) return;
        for (int i = 0; i < _length; i++)
            if (players[i].getId() == player.getId()) {
                players[i] = null;
                reorderPlayersList();
                _length--;
            }
    }

    private void reorderPlayersList() {
        for (int i = 0; i < _length; i++) {
            if (players[i] == null) {
                players[i] = players[i + 1];
                players[i + 1] = null;
            }
        }
    }

}
