package com.theclod;

import java.util.function.Function;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class TheClodItems {

    public static final Item TEN_PIECE_MCCHICKEN = register(
        TheClodItemIds.TEN_PIECE_MCCHICKEN,
        Item::new,
        new Item.Properties().food(
            new FoodProperties(4, 0, false))
    );

    public static final Item BIG_MAC = register(
        TheClodItemIds.BIG_MAC, 
        Item::new, 
        new Item.Properties().food(
            new FoodProperties(13, 5, false))
        );

    public static final Item LARGE_FRY = register(
        TheClodItemIds.LARGE_FRY, 
        Item::new, new Item.Properties().food(
            new FoodProperties(3, 0, false))
        );

    public static final Item HAPPY_MEAL = register(
        TheClodItemIds.HAPPY_MEAL, 
        Item::new, new Item.Properties().food(
            new FoodProperties(16, 20, false)
        ));

    public static final Item CIRCUS_PEANUTS = register(
        TheClodItemIds.CIRCUS_PEANUTS,
        Item::new, new Item.Properties().food(
            new FoodProperties(3, 0, true)
        ));

    public static final Item CIRCUS_POPCORN = register(
        TheClodItemIds.CIRCUS_POPCORN,
        Item::new, new Item.Properties().food(
            new FoodProperties(3, 0, true)
        ));




    public static void initialize(){
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
            .register((creativeTab) -> creativeTab.accept(TheClodItems.TEN_PIECE_MCCHICKEN));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
            .register((creativeTab) -> creativeTab.accept(TheClodItems.BIG_MAC));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
            .register((creativeTab) -> creativeTab.accept(TheClodItems.LARGE_FRY));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
            .register((creativeTab) -> creativeTab.accept(TheClodItems.HAPPY_MEAL));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
            .register((creativeTab) -> creativeTab.accept(TheClodItems.CIRCUS_PEANUTS));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
            .register((creativeTab) -> creativeTab.accept(TheClodItems.CIRCUS_POPCORN));
    }

    // Take input resource key and properties to create an item instance
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {

        // Create the item instance
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
}
