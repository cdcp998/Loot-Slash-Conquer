package thexfactor117.lsc.config;

import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thexfactor117.lsc.util.Reference;

/**
 *
 * @author TheXFactor117
 *
 */
@Mod.EventBusSubscriber
public class EventConfigSync
{
	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.getModID().equals(Reference.MODID))
		{
			ConfigManager.sync(Reference.MODID, Type.INSTANCE);
		}
	}
}
