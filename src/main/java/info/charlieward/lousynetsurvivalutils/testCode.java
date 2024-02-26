package info.charlieward.lousynetsurvivalutils;

import redis.clients.jedis.Jedis;

public class testCode {
    public static Jedis jedis = new Jedis();
    public static void main(String[] args) {
        jedis.set("LousyBoiHome", "");
        jedis.set("Jakeosu06Home", "");

        getPlayersHome("LousyBoi");
        setPlayersHome("LousyBoi");
        getPlayersHome("LousyBoi");
    }

    public static void getPlayerHomesAll(){
        System.out.println(jedis.get("LousyBoiHome"));
        System.out.println(jedis.get("Jakeosu06Home"));
    }

    public static void setPlayersHome(String Player) {
        String jedisKey = Player + "Home";
        int locX = (int) 104.9;
        int locY = (int) 32.7;
        int locZ = (int) 1243.2;
        String coords = locX + "," + locY + "," + locZ;

        jedis.set(jedisKey, coords);
    }

    public static void getPlayersHome(String Player) {
        String jedisKey = Player + "Home";
        String coords = jedis.get(jedisKey);
        if (coords == null || coords.isEmpty()) {
            System.out.println("No Home Set");
        } else {
            String[] coordsSplit = coords.split(",");
            System.out.println("X: " + coordsSplit[0]);
            System.out.println("Z: " + coordsSplit[1]);
            System.out.println("Y: " + coordsSplit[2]);
        }
    }

}
