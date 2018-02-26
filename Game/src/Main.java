
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author puush
 */
public class Main {

    public static void main(String[] args) {
        DataBaseConnection tkyhteys = new DataBaseConnection();
        Scanner reader = new Scanner(System.in);
        for (;;) {
            String xcoord = tkyhteys.haeKaikki(""
                    + "SELECT player.xcoord "
                    + "FROM player, tile "
                    + "WHERE player.xcoord = tile.xcoord "
                    + "AND player.ycoord = tile.ycoord "
                    + "AND player.id = 1;");
            String ycoord = tkyhteys.haeKaikki(""
                    + "SELECT player.ycoord "
                    + "FROM player, tile "
                    + "WHERE player.xcoord = tile.xcoord "
                    + "AND player.ycoord = tile.ycoord "
                    + "AND player.id = 1;");
            //System.out.println(xcoord);
            //System.out.println(ycoord);
            System.out.println("Players coordinates X / Y: ");
            System.out.println(tkyhteys.haeKaikki(""
                    + "SELECT player.xcoord, player.ycoord, tiletype.name "
                    + "FROM player, tile, tiletype "
                    + "WHERE player.xcoord = tile.xcoord "
                    + "AND player.ycoord = tile.ycoord "
                    + "AND tile.tiletypeId = tiletype.id "
                    + "AND player.id = 1;"));
            System.out.println("Items on ground: ");
            System.out.println(tkyhteys.haeKaikki(""
                    + "SELECT objecttype.name "
                    + "FROM objecttype, player, object "
                    + "WHERE objecttype.id = object.objecttypeId "
                    + "AND object.xcoord = player.xcoord AND object.ycoord = player.ycoord "
                    + "AND player.id = 1;"));
            System.out.println("Items in inventory: ");
            System.out.println(tkyhteys.haeKaikki(""
                    + "SELECT objecttype.name "
                    + "FROM objecttype, player, object "
                    + "WHERE objecttype.id = object.objecttypeId "
                    + "AND object.playerId = player.id "
                    + "AND player.id = 1;"));
            System.out.println("* * * * * * * * *");
            System.out.println("* Give command: *");
            System.out.println("*       W       *");
            System.out.println("*     A S D     *");
            System.out.println("* * * * * * * * *");
            String command = reader.nextLine();
            switch (command) {
                case "w":
                    //System.out.println("moves up by 1");
                    //UPDATE player SET ycoord = ycoord + 1 WHERE id = 1;
                    tkyhteys.Update(""
                            + "UPDATE player "
                            + "SET ycoord = ycoord + 1 "
                            + "WHERE id = 1 "
                            + "AND ycoord < 2;");
                    break;
                case "a":

                    //System.out.println("moves left by 1");
                    tkyhteys.Update(""
                            + "UPDATE player "
                            + "SET xcoord = xcoord - 1 "
                            + "WHERE id = 1 "
                            + "AND xcoord > 0;");

                    break;
                case "s":
                    //System.out.println("moves down by 1");
                    tkyhteys.Update(""
                            + "UPDATE player "
                            + "SET ycoord = ycoord - 1 "
                            + "WHERE id = 1 "
                            + "AND ycoord > 0;");
                    break;
                case "d":
                    //System.out.println("moves right by 1");
                    tkyhteys.Update(""
                            + "UPDATE player "
                            + "SET xcoord = xcoord + 1 "
                            + "WHERE id = 1 "
                            + "AND xcoord < 3;");
                    break;
                default:
                    break;
            }
        }

    }

}
