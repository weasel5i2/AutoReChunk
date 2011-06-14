package net.weasel.AutoReChunk;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoReChunk extends JavaPlugin
{
	public static String pluginName = "";
	public static String pluginVersion = "";
	public static PluginManager pm = null;
	public static ARCPlayerListener pListener = null;
	
	@Override
	public void onDisable() 
	{
		logOutput( "AutoReChunk v" + pluginVersion + " disabled." );
	}

	@Override
	public void onEnable() 
	{
		pluginName = getDescription().getName();
		pluginVersion = getDescription().getVersion();
		pListener = new ARCPlayerListener( this );
		pm = getServer().getPluginManager();
		
		pm.registerEvent( Type.PLAYER_TELEPORT, pListener, Priority.Monitor, this );
		
		logOutput( "AutoReChunk v" + pluginVersion + " ready." );
	}
	
	public static void logOutput( String message )
	{
		System.out.println( "[" + pluginName + "] " + message );
	}
}
