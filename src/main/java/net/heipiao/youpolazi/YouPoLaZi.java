package net.heipiao.youpolazi;

import com.mojang.logging.LogUtils;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.VanillaGameEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("youpolazi")
public class YouPoLaZi
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public YouPoLaZi(){
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        Items.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @SubscribeEvent
    public void onTrade(final VillagerTradesEvent event){
        if(!event.getType().equals(VillagerProfession.FARMER))return;
        event.getTrades().get(1).add(new BasicItemListing(1, new ItemStack(Items.PEPPER.get(), 20), 16, 2));
        event.getTrades().get(1).add(new BasicItemListing(1, new ItemStack(Items.SESAME.get(), 20), 16, 2));
        event.getTrades().get(1).add(new BasicItemListing(1, new ItemStack(Items.ZANTHOXYLUM.get(), 20), 16, 2));
    }

    @SubscribeEvent
    public void onEat(final VanillaGameEvent event){
        if(event.getVanillaEvent().equals(GameEvent.EAT)&&event.getCause() instanceof Player player){
            if(player.getMainHandItem().is(Items.YOU_PO_LA_ZI_BOTTLE.get())||player.getOffhandItem().is(Items.YOU_PO_LA_ZI_BOTTLE.get())){
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20*20));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*20));
            }
        }
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
