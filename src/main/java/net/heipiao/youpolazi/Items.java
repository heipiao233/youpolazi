package net.heipiao.youpolazi;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class Items {
    private Items(){};
    public static final DeferredRegister<Item> ITEMS=DeferredRegister.create(ForgeRegistries.ITEMS, "youpolazi");
    public static final RegistryObject<Item> PEPPER=ITEMS.register("pepper", ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> SESAME=ITEMS.register("sesame", ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZANTHOXYLUM=ITEMS.register("zanthoxylum", ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> EDIBLE_OIL_BOTTLE=ITEMS.register("edible_oil_bottle", ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> PAPRIKA=ITEMS.register("paprika", ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> YOU_PO_LA_ZI_BOTTLE=ITEMS.register("you_po_la_zi_bottle", ()->new Item(new Item.Properties()));
}
