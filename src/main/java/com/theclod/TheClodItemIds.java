package com.theclod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class TheClodItemIds {

    public static final ResourceKey<Item> TEN_PIECE_MCCHICKEN = create("ten_piece_mcchicken");
    public static final ResourceKey<Item> BIG_MAC = create("big_mac");
    public static final ResourceKey<Item> LARGE_FRY = create("large_fry");
    public static final ResourceKey<Item> HAPPY_MEAL = create("happy_meal");

    public static final ResourceKey<Item> CIRCUS_PEANUTS = create("circus_peanuts");
    public static final ResourceKey<Item> CIRCUS_POPCORN = create("circus_popcorn");

    //Dynamically generate resource keys based on item name
    public static ResourceKey<Item> create(String name){
        return ResourceKey.create(Registries.ITEM, TheClod.id(name));
    }
}
