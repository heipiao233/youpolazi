package net.heipiao.youpolazi;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.VanillaGameEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
@Mod("youpolazi")
public class YouPoLaZi
{
    public YouPoLaZi(){
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
            ItemStack item;
            if((item=player.getMainHandItem()).is(Items.YOU_PO_LA_ZI_BOTTLE.get())){
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20*20));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*20));
                item.shrink(1);
            }else if((item=player.getOffhandItem()).is(Items.YOU_PO_LA_ZI_BOTTLE.get())){
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20*20));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*20));
                item.shrink(1);
            }
        }
    }
}
