package com.rmdmod.terracottaarmymod.block;

import com.rmdmod.terracottaarmymod.TerracottaArmyMod;
import com.rmdmod.terracottaarmymod.block.custom.RiceCropBlock;
import com.rmdmod.terracottaarmymod.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    // registering blocks and dropped item (when mined)
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TerracottaArmyMod.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TerracottaArmyMod.MOD_ID);


    public static final RegistryObject<LiquidBlock> MERCURY_BLOCK = BLOCKS.register("mercury_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MERCURY, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final RegistryObject<Block> RICE_CROP_BLOCK = BLOCKS.register("rice_crop",
            () -> new RiceCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
    public static final RegistryObject<Item> RICE = ITEMS.register("rice",
            () -> new BlockItem(RICE_CROP_BLOCK.get(), new Item.Properties()));


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
