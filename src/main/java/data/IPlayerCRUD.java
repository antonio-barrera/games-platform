package data;

import player.Player;

public interface IPlayerCRUD {
    Player create(Player player);
    Player select(int id);
    Player[] selectAll();
    Player update(Player player);
    void delete(Player player);
}
