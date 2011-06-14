package net.weasel.AutoReChunk;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class ARCPlayerListener extends PlayerListener
{
	public static AutoReChunk plugin = null;
	
	public ARCPlayerListener( AutoReChunk instance )
	{
		plugin = instance;
	}
	
	public void onPlayerTeleport( PlayerTeleportEvent e )
	{
		Location loc = e.getPlayer().getLocation();
		genTargetChunks( loc );
	}
	
	public static void genTargetChunks( Location loc )
    {
    	World world = loc.getWorld();
    	Block block = loc.getBlock();

    	Integer X = block.getX();
    	Integer Z = block.getZ();
    	
    	
    	// Force loading of the 3x3 chunk area player teleports to..
    	//
    	world.refreshChunk( X - 16, Z - 16 );
    	world.refreshChunk( X - 16, Z );
    	world.refreshChunk( X - 16, Z + 16 );
    	world.refreshChunk( X, Z - 16 ); 
    	world.refreshChunk( X, Z );
    	world.refreshChunk( X, Z + 16 );
    	world.refreshChunk( X + 16, Z - 16 );
    	world.refreshChunk( X + 16, Z );
    	world.refreshChunk( X + 16, Z + 16 );
    }

}
